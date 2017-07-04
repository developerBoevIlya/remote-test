package remotetest.test_runner.test_info.TestInfo_classes;

import remotetest.test_runner.test_info.TestInfo_classes.StartInfo_classes.TestStart;

/**
 * Created by sfaxi19 on 02.07.17.
 */
public class StartInfo {

    public String socket;
    public String local_host;
    public String local_port;
    public String remote_host;
    public String remote_port;
    public String version;
    public String system_info;
    public String time;
    public String timesecs;
    public String connecting_to_host;
    public String connecting_to_port;
    public String cookie;
    public String tcp_mss_default;
    private TestStart test_start;

    public StartInfo(String socket,
                     String local_host,
                     String local_port,
                     String remote_host,
                     String remote_port,
                     String version,
                     String system_info,
                     String time,
                     String timesecs,
                     String connecting_to_host,
                     String connecting_to_port,
                     String cookie,
                     String tcp_mss_default,
                     TestStart test_start) {
        this.socket = socket;
        this.local_host = local_host;
        this.local_port = local_port;
        this.remote_host = remote_host;
        this.remote_port = remote_port;
        this.version = version;
        this.system_info = system_info;
        this.time = time;
        this.timesecs = timesecs;
        this.connecting_to_host = connecting_to_host;
        this.connecting_to_port = connecting_to_port;
        this.cookie = cookie;
        this.tcp_mss_default = tcp_mss_default;
        this.test_start = test_start;
    }

    @Override
    public String toString() {
        return "========== StartInfo ==========\n" +
                "socket:            \t\t" + socket + "\n" +
                "local_host:        \t\t" + local_host + "\n" +
                "local_port:        \t\t" + local_port + "\n" +
                "remote_host:       \t\t" + remote_host + "\n" +
                "remote_port:       \t\t" + remote_port + "\n" +
                "version:           \t\t" + version + "\n" +
                "system_info:       \t\t" + system_info + "\n" +
                "time:              \t\t" + time + "\n" +
                "timesecs:          \t\t" + timesecs + "\n" +
                "connecting_to_host:\t\t" + connecting_to_host + "\n" +
                "connecting_to_port:\t\t" + connecting_to_port + "\n" +
                "cookie:            \t\t" + cookie + "\n" +
                "tcp_mss_default:   \t\t" + tcp_mss_default + "\n" +
                test_start;
    }
}
