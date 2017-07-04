package remotetest.test_runner.staf_test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import remotetest.test_runner.test_info.TestInfo;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.CPUUtilizationPercent;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumReceived;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumSent;
import remotetest.test_runner.test_info.TestInfo_classes.IntervalInfo;
import remotetest.test_runner.test_info.TestInfo_classes.StartInfo;
import remotetest.test_runner.test_info.TestInfo_classes.StartInfo_classes.TestStart;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static TestInfo parser(String jsonResp) throws IOException {
        JsonNode root = new ObjectMapper().readTree(jsonResp);
        List<JsonNode> intervalsJson = root.get("intervals").findValues("streams");
        ArrayList<IntervalInfo> intervalsInfo = new ArrayList<IntervalInfo>();
        for (JsonNode interval : intervalsJson) {
            intervalsInfo.add(new IntervalInfo(
                    interval.findValue("socket").toString(),
                    interval.findValue("start").toString(),
                    interval.findValue("end").toString(),
                    interval.findValue("seconds").toString(),
                    interval.findValue("bytes").toString(),
                    interval.findValue("bits_per_second").toString(),
                    interval.findValue("retransmits").toString(),
                    interval.findValue("snd_cwnd").toString(),
                    interval.findValue("omitted").toString()
            ));
        }
        JsonNode sum_sent_Json = root.get("end").get("sum_sent");
        JsonNode sum_received_Json = root.get("end").get("sum_received");
        JsonNode cpu_utilization_percent_Json = root.get("end").get("cpu_utilization_percent");
        SumSent sum_sent = new SumSent(
                sum_sent_Json.findValue("start").toString(),
                sum_sent_Json.findValue("end").toString(),
                sum_sent_Json.findValue("seconds").toString(),
                sum_sent_Json.findValue("bytes").toString(),
                sum_sent_Json.findValue("bits_per_second").toString(),
                sum_sent_Json.findValue("retransmits").toString()
        );
        SumReceived sum_received = new SumReceived(
                sum_received_Json.findValue("start").toString(),
                sum_received_Json.findValue("end").toString(),
                sum_received_Json.findValue("seconds").toString(),
                sum_received_Json.findValue("bytes").toString(),
                sum_received_Json.findValue("bits_per_second").toString()
        );
        CPUUtilizationPercent cpu_utilization_percent = new CPUUtilizationPercent(
                cpu_utilization_percent_Json.findValue("host_total").toString(),
                cpu_utilization_percent_Json.findValue("host_user").toString(),
                cpu_utilization_percent_Json.findValue("host_system").toString(),
                cpu_utilization_percent_Json.findValue("remote_total").toString(),
                cpu_utilization_percent_Json.findValue("remote_user").toString(),
                cpu_utilization_percent_Json.findValue("remote_system").toString()
        );
        JsonNode startJson = root.get("start");
        TestStart test_start = new TestStart(
                startJson.findValue("protocol").toString(),
                startJson.findValue("num_streams").toString(),
                startJson.findValue("blksize").toString(),
                startJson.findValue("omit").toString(),
                startJson.findValue("duration").toString(),
                startJson.findValue("bytes").toString(),
                startJson.findValue("blocks").toString(),
                startJson.findValue("reverse").toString()
        );

        StartInfo start_info = new StartInfo(
                startJson.findValue("socket").toString(),
                startJson.findValue("local_host").toString(),
                startJson.findValue("local_port").toString(),
                startJson.findValue("remote_host").toString(),
                startJson.findValue("remote_port").toString(),
                startJson.findValue("version").toString(),
                startJson.findValue("system_info").toString(),
                startJson.findValue("time").toString(),
                startJson.findValue("timesecs").toString(),
                startJson.findValue("host").toString(),
                startJson.findValue("port").toString(),
                startJson.findValue("cookie").toString(),
                startJson.findValue("tcp_mss_default").toString(),
                test_start
        );

        FinalInfo finalInfo = new FinalInfo(sum_sent, sum_received, cpu_utilization_percent);
        return new TestInfo(start_info, intervalsInfo, finalInfo);
    }

}
