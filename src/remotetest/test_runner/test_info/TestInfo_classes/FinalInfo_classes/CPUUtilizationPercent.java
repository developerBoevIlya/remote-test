package remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes;

public class CPUUtilizationPercent {
    public String host_total;
    public String host_user;
    public String host_system;
    public String remote_total;
    public String remote_user;
    public String remote_system;

    public CPUUtilizationPercent(String host_total,
                                 String host_user,
                                 String host_system,
                                 String remote_total,
                                 String remote_user,
                                 String remote_system) {
        this.host_total = host_total;
        this.host_user = host_user;
        this.host_system = host_system;
        this.remote_total = remote_total;
        this.remote_user = remote_user;
        this.remote_system = remote_system;
    }

    @Override
    public String toString() {
        return "CPU utilization percent:\n" +
                "\thost_total:   \t\t" + host_total + "\n" +
                "\thost_user:    \t\t" + host_user + "\n" +
                "\thost_system:  \t\t" + host_system + "\n" +
                "\tremote_total: \t\t" + remote_total + "\n" +
                "\tremote_user:  \t\t" + remote_user + "\n" +
                "\tremote_system:\t\t" + remote_system + "\n";
    }
}
