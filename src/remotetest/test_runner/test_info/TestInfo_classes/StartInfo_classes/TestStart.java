package remotetest.test_runner.test_info.TestInfo_classes.StartInfo_classes;

/**
 * Created by sfaxi19 on 05.07.17.
 */
public class TestStart {
    public String protocol;
    public String num_streams;
    public String blksize;
    public String omit;
    public String duration;
    public String bytes;
    public String blocks;
    public String reverse;

    public TestStart(String protocol,
                     String num_streams,
                     String blksize,
                     String omit,
                     String duration,
                     String bytes,
                     String blocks,
                     String reverse) {
        this.protocol = protocol;
        this.num_streams = num_streams;
        this.blksize = blksize;
        this.omit = omit;
        this.duration = duration;
        this.bytes = bytes;
        this.blocks = blocks;
        this.reverse = reverse;
    }

    @Override
    public String toString() {
        return "Test start:\n" +
                "\tprotocol:   \t\t" + protocol + "\n" +
                "\tnum_streams:\t\t" + num_streams + "\n" +
                "\tblksize:    \t\t" + blksize + "\n" +
                "\tomit:       \t\t" + omit + "\n" +
                "\tduration:   \t\t" + duration + "\n" +
                "\tbytes:      \t\t" + bytes + "\n" +
                "\tblocks:     \t\t" + blocks + "\n" +
                "\treverse:    \t\t" + reverse + "\n";
    }
}
