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

    public void setStartInfo(StartInfo startInfo) {
        this.startInfo = startInfo;
    }

    public ArrayList<IntervalInfo> getIntervals() {
        return intervals;
    }

    public void setIntervals(ArrayList<IntervalInfo> intervals) {
        this.intervals = intervals;
    }

    public FinalInfo getFinalInfo() {
        return finalInfo;
    }

    public void setFinalInfo(FinalInfo finalInfo) {
        this.finalInfo = finalInfo;
    }
}
