package remotetest.test_runner.staf_test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import remotetest.test_runner.test_info.IntervalInfo;
import remotetest.test_runner.test_info.TestInfo;

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
        return new TestInfo(null, intervalsInfo, null);
    }

}
