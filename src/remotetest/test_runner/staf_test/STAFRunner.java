package remotetest.test_runner.staf_test;

import com.ibm.staf.STAFException;
import com.ibm.staf.STAFHandle;
import com.ibm.staf.STAFMarshallingContext;
import com.ibm.staf.STAFResult;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class STAFRunner {

    private static STAFHandle handle;

    public STAFRunner() {

    }

    private void registering(String string) {
        try {
            handle = new STAFHandle(string);
        } catch (STAFException e) {
            System.out.println("Error registering with STAF, RC: " + e.rc);
            System.exit(1);
        }
    }

    private void unregistering() {
        try {
            handle.unRegister();
        } catch (STAFException e) {
            System.out.println("Error unregistering with STAF, RC: " + e.rc);
            System.exit(1);
        }
    }

    public String test(String string, String where, String command) throws IOException {
        System.out.println("Start test " + string + ":\t" + where + "\t:\t" + command);
        registering(string);
        STAFResult result = handle.submit2(where, "PROCESS", "START SHELL COMMAND \"" + command + "\" RETURNSTDOUT RETURNSTDERR NEWCONSOLE WAIT\n");
        STAFMarshallingContext mc = STAFMarshallingContext.unmarshall(result.result);
        Map resultMap = (HashMap)mc.getRootObject();
        String processRC = (String)resultMap.get("rc");
        System.out.println("\nPROCESS RC: " + processRC);


        List returnedFiles = (List)resultMap.get("fileList");
        String stdoutData = "";
        String stderrData = "";

        Map stdoutMap = (HashMap)returnedFiles.get(0);
        String stdoutRC = (String)stdoutMap.get("rc");

        if (stdoutRC.equals("0"))
            stdoutData = (String)stdoutMap.get("data");
        else
            System.out.println(
                    "Error retrieving process Stdout data. RC: " + stdoutRC);

        Map stderrMap = (HashMap)returnedFiles.get(1);
        String stderrRC = (String)stderrMap.get("rc");

        if (stderrRC.equals("0"))
            stderrData = (String)stderrMap.get("data");
        else
            System.out.println(
                    "Error retrieving process Stderr data. RC: " + stderrRC);
        System.out.println("\nPROCESS STDOUT:\n\n" + stdoutData);
        System.out.println("\nPROCESS STDERR:\n\n" + stderrData);
        unregistering();
        return stdoutData;
    }

}