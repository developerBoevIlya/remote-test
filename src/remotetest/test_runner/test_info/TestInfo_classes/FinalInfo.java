package remotetest.test_runner.test_info.TestInfo_classes;

import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.CPUUtilizationPercent;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumReceived;
import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes.SumSent;

/**
 * Created by sfaxi19 on 02.07.17.
 */
public class FinalInfo {

    private SumSent sum_sent;
    private SumReceived sum_received;
    private CPUUtilizationPercent cpu_utilization_percent;

    public FinalInfo(SumSent sum_sent, SumReceived sum_received, CPUUtilizationPercent cpu_utilization_percent) {
        this.sum_sent = sum_sent;
        this.sum_received = sum_received;
        this.cpu_utilization_percent = cpu_utilization_percent;
    }

    public SumSent getSum_sent() {
        return sum_sent;
    }

    public SumReceived getSum_received() {
        return sum_received;
    }

    public CPUUtilizationPercent getCpu_utilization_percent() {
        return cpu_utilization_percent;
    }

}

