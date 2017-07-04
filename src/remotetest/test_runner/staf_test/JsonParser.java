package remotetest.test_runner.staf_test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import remotetest.test_runner.test_info.*;
import remotetest.test_runner.test_info.TestInfo_classes.*;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.CPUUtilizationPercent;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumReceived;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumSent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JsonParser {

    public static TestInfo parser(String jsonResp) throws IOException {
        JsonNode root = new ObjectMapper().readTree(jsonResp);
        List<JsonNode> intervalsJson = root.findValue("intervals").findValues("streams");
        ArrayList<IntervalInfo> intervalsInfo = new ArrayList<IntervalInfo>();
        for (JsonNode interval : intervalsJson) {
            intervalsInfo.add(new IntervalInfo(
                    interval.findValues("socket").get(0).toString(),
                    interval.findValues("start").get(0).toString(),
                    interval.findValues("end").get(0).toString(),
                    interval.findValues("seconds").get(0).toString(),
                    interval.findValues("bytes").get(0).toString(),
                    interval.findValues("bits_per_second").get(0).toString(),
                    interval.findValues("retransmits").get(0).toString(),
                    interval.findValues("snd_cwnd").get(0).toString(),
                    interval.findValues("omitted").get(0).toString()
            ));

        }
        JsonNode end = root.findValue("end");
        SumSent sum_sent = new SumSent(
                end.findValues("start").get(0).toString(),
                end.findValues("end").get(0).toString(),
                end.findValues("seconds").get(0).toString(),
                end.findValues("bytes").get(0).toString(),
                end.findValues("bits_per_second").get(0).toString(),
                end.findValues("retransmits").get(0).toString()
        );

        SumReceived sum_received = new SumReceived(
                end.findValues("start").get(0).toString(),
                end.findValues("end").get(0).toString(),
                end.findValues("seconds").get(0).toString(),
                end.findValues("bytes").get(0).toString(),
                end.findValues("bits_per_second").get(0).toString()
        );

        CPUUtilizationPercent cpu_utilization_percent = new CPUUtilizationPercent(
                end.findValues("host_total").get(0).toString(),
                end.findValues("host_user").get(0).toString(),
                end.findValues("host_system").get(0).toString(),
                end.findValues("remote_total").get(0).toString(),
                end.findValues("remote_user").get(0).toString(),
                end.findValues("remote_system").get(0).toString()
        );
        FinalInfo finalInfo = new FinalInfo(sum_sent, sum_received, cpu_utilization_percent);
        JsonNode sum_sent_Json = root.findValue("end").findValue("sum_sent");
        JsonNode sum_received_Json = root.findValue("end").findValue("sum_received");
        JsonNode cpu_utilization_percent_Json = root.findValue("end").findValue("cpu_utilization_percent");
        return new TestInfo(null, intervalsInfo, finalInfo);
    }

}
