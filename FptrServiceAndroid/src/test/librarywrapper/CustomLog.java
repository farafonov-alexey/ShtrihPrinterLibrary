package test.librarywrapper;

import android.util.Log;

/**
 * Created by mamba on 17.08.2017.
 */

public class CustomLog {
    private static String logName = "LogReadersLibraryCCT";
    private static boolean isShow = true;

    public static void d(String tag, String message) {
        if(isShow)
            Log.d(tag, message);
    }

    public static void e(String tag, String message) {
        if(isShow)
            Log.e(tag, message);
    }

    public static void v(String tag, String message) {
        if(isShow)
            Log.v(tag, message);
    }

    public static void i(String tag, String message) {
        if(isShow)
            Log.i(tag, message);
    }

    public static void v(String message) {
        if(isShow)
            Log.v(logName, message);
    }

    public static void enableDebugLogging(boolean isShowExt) {
        isShow = isShowExt;
    }
}
