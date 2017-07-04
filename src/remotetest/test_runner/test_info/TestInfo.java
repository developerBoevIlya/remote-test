package remotetest.test_runner.test_info;

import remotetest.test_runner.test_info.TestInfo_classes.FinalInfo;
import remotetest.test_runner.test_info.TestInfo_classes.IntervalInfo;
import remotetest.test_runner.test_info.TestInfo_classes.StartInfo;

import java.util.ArrayList;

/**
 * Created by sfaxi19 on 02.07.17.
 */
public class TestInfo {

    private StartInfo startInfo;
    private ArrayList<IntervalInfo> intervals;
    private FinalInfo finalInfo;

    public TestInfo(StartInfo startInfo, ArrayList<IntervalInfo> intervals, FinalInfo finalInfo) {
        this.startInfo = startInfo;
        this.intervals = intervals;
        this.finalInfo = finalInfo;
    }

    public StartInfo getStartInfo() {
        return startInfo;
    }

    public ArrayList<IntervalInfo> getIntervals() {
        return intervals;
    }

    public FinalInfo getFinalInfo() {
        return finalInfo;
    }

    @Override
    public String toString() {
        return  startInfo.toString() +
                intervals.toString() +
                finalInfo.toString();
    }
}
