package opensdm.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static BufferedWriter bufferedWriter;

    public static void initalizeLogger() throws IOException {
        File f = new File("latest.log");

        if(f.exists()) {
            f.delete();
        }

        f.createNewFile();

        bufferedWriter = new BufferedWriter(new FileWriter(f));
    }

    private static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    private static void writeToLog(String s) throws IOException {
        bufferedWriter.write(s);
        // TODO
    }

    public static void logInfo(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] INFO > " + msg);
        try {
            writeToLog("[" + getCurrentTimeStamp() + "] INFO > " + msg);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    public static void logWarn(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] WARN > " + msg);
        try {
            writeToLog("[" + getCurrentTimeStamp() + "] WARN > " + msg);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    public static void logError(String msg) {
        System.err.println("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
        try {
            writeToLog("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    public static void logDebug(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] DEBUG > " + msg);
        try {
            writeToLog("[" + getCurrentTimeStamp() + "] DEBUG > " + msg);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

}
