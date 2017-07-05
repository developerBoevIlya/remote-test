package remotetest.test_runner.staf_test;

import remotetest.test_runner.test_info.TestInfo;

import java.io.IOException;

/**
 * Created by sfaxi19 on 02.07.17.
 */
public class ExampleTest {
    /**
     * test(String string, String where, String command)
     * where - где запускать
     * command - что запускать
     * <p/>
     * TestInfo - содержит все данные выдаваемые iperf-ом
     * JsonParser.parser(String json) - парсит json и выдаёт TestInfo
     */
    public static void main(String[] args) throws IOException {
        STAFRunner stafRunner = new STAFRunner();
        stafRunner.test("Iperf test", "local", "start \"\" iperf3 -s ");
		//192.168.69.192
        String jsonResp = stafRunner.test("Iperf test", "192.168.69.192", "iperf3 -J -c 192.168.69.193");
        if (jsonResp == null) return;
        TestInfo testInfo = JsonParser.parser(jsonResp);
        System.out.println(testInfo.getStartInfo());
        System.out.println(testInfo.getIntervals().get(0));
        System.out.println(testInfo.getFinalInfo());

    }
}
