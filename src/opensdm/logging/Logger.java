package opensdm.logging;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;

public class Logger {

    private static String getCurrentTimeStamp() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }
    public static void logInfo(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] INFO > " + msg);
    }

    public static void logWarn(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] WARN > " + msg);
    }

    public static void logError(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] ERROR > " + msg);
    }

    public static void logDebug(String msg) {
        System.out.println("[" + getCurrentTimeStamp() + "] DEBUG > " + msg);
    }

}
