package remotetest.test_runner.test_info;

/**
 * Created by sfaxi19 on 02.07.17.
 */
public class IntervalInfo {
    private String socket;
    private String start;
    private String end;
    private String seconds;
    private String bytes;
    private String bits_per_second;
    private String retransmits;
    private String snd_cwnd;
    private String omitted;

    public IntervalInfo(String socket,
                        String start,
                        String end,
                        String seconds,
                        String bytes,
                        String bits_per_second,
                        String retransmits,
                        String snd_cwnd,
                        String omitted) {
        this.socket = socket;
        this.start = start;
        this.end = end;
        this.seconds = seconds;
        this.bytes = bytes;
        this.bits_per_second = bits_per_second;
        this.retransmits = retransmits;
        this.snd_cwnd = snd_cwnd;
        this.omitted = omitted;
    }

    public String getSocket() {
        return socket;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String getSeconds() {
        return seconds;
    }

    public String getBytes() {
        return bytes;
    }

    public String getBits_per_second() {
        return bits_per_second;
    }

    public String getRetransmits() {
        return retransmits;
    }

    public String getSnd_cwnd() {
        return snd_cwnd;
    }

    public String getOmitted() {
        return omitted;
    }

    @Override
    public String toString() {
        return "IntervalInfo:\n" +
                "socket:\t" + socket + "\n" +
                "start:\t" + start + "\n" +
                "end:\t" + end + "\n" +
                "seconds:\t" + seconds + "\n" +
                "bytes:\t" + bytes + "\n" +
                "bits_per_second:\t" + bits_per_second + "\n" +
                "retransmits:\t" + retransmits + "\n" +
                "snd_cwnd:\t" + snd_cwnd + "\n" +
                "omitted:\t" + omitted + "\n";
    }
}
