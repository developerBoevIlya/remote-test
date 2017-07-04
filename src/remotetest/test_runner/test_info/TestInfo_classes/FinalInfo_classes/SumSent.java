package remotetest.test_runner.test_info.TestInfo_classes.FinalInfo_classes;

public class SumSent {
    public String start;
    public String end;
    public String seconds;
    public String bytes;
    public String bits_per_second;
    public String retransmits;

    public SumSent(String start,
                   String end,
                   String seconds,
                   String bytes,
                   String bits_per_second,
                   String retransmits) {
        this.start = start;
        this.end = end;
        this.seconds = seconds;
        this.bytes = bytes;
        this.bits_per_second = bits_per_second;
        this.retransmits = retransmits;
    }
}
