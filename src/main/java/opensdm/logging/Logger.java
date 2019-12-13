package opensdm.logging;

import opensdm.config.Configuration;
import opensdm.config.ConfigurationManager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

    private static BufferedWriter bufferedWriter;
    private static boolean log = true;

    public static void initalizeLogger() throws IOException {
        File f = new File("latest.log");

        if (f.exists()) {
            f.delete();
            Logger.logErrorWithoutLogging("Can't delete latest.log!");
        }

        if(f.canWrite()) {
            Logger.logWarnWithoutLogging("Can't write into file latest.log. The console output will not be logged!");
            log = false;
        }

        if(log) {
            bufferedWriter = new BufferedWriter(new FileWriter(f, true));
        }
    }

    private static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    static void writeToLog(String s) throws IOException {
        if(log) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
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

    public static void logWarnWithoutLogging(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] WARN > " + msg);
    }

    public static void logError(String msg) {
        System.err.println("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
        try {
            writeToLog("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
        } catch (IOException e) {
            logError(e.getMessage());
        }
    }

    public static void logErrorWithoutLogging(String msg) {
        System.err.println("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
    }

    public static void logDebug(String msg) {
        if(ConfigurationManager.getConfiguration().isShowDebugMessages()) {
            System.out.println("[" + getCurrentTimeStamp() + "] DEBUG > " + msg);
            try {
                writeToLog("[" + getCurrentTimeStamp() + "] DEBUG > " + msg);
            } catch (IOException e) {
                logError(e.getMessage());
            }
        }
    }

}
