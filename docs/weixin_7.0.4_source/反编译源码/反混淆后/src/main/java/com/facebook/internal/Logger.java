package com.facebook.internal;

import android.util.Log;
import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map.Entry;

public class Logger {
    public static final String LOG_TAG_BASE = "FacebookSDK.";
    private static final HashMap<String, String> stringsToReplace = new HashMap();
    private final LoggingBehavior behavior;
    private StringBuilder contents;
    private int priority = 3;
    private final String tag;

    static {
        AppMethodBeat.m2504i(72422);
        AppMethodBeat.m2505o(72422);
    }

    public static synchronized void registerStringToReplace(String str, String str2) {
        synchronized (Logger.class) {
            AppMethodBeat.m2504i(72405);
            stringsToReplace.put(str, str2);
            AppMethodBeat.m2505o(72405);
        }
    }

    public static synchronized void registerAccessToken(String str) {
        synchronized (Logger.class) {
            AppMethodBeat.m2504i(72406);
            if (!FacebookSdk.isLoggingBehaviorEnabled(LoggingBehavior.INCLUDE_ACCESS_TOKENS)) {
                registerStringToReplace(str, "ACCESS_TOKEN_REMOVED");
            }
            AppMethodBeat.m2505o(72406);
        }
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2) {
        AppMethodBeat.m2504i(72407);
        log(loggingBehavior, 3, str, str2);
        AppMethodBeat.m2505o(72407);
    }

    public static void log(LoggingBehavior loggingBehavior, String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(72408);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, 3, str, String.format(str2, objArr));
        }
        AppMethodBeat.m2505o(72408);
    }

    public static void log(LoggingBehavior loggingBehavior, int i, String str, String str2, Object... objArr) {
        AppMethodBeat.m2504i(72409);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            log(loggingBehavior, i, str, String.format(str2, objArr));
        }
        AppMethodBeat.m2505o(72409);
    }

    public static void log(LoggingBehavior loggingBehavior, int i, String str, String str2) {
        AppMethodBeat.m2504i(72410);
        if (FacebookSdk.isLoggingBehaviorEnabled(loggingBehavior)) {
            String replaceStrings = replaceStrings(str2);
            if (!str.startsWith(LOG_TAG_BASE)) {
                str = LOG_TAG_BASE.concat(String.valueOf(str));
            }
            Log.println(i, str, replaceStrings);
            if (loggingBehavior == LoggingBehavior.DEVELOPER_ERRORS) {
                Exception exception = new Exception();
            }
        }
        AppMethodBeat.m2505o(72410);
    }

    private static synchronized String replaceStrings(String str) {
        synchronized (Logger.class) {
            AppMethodBeat.m2504i(72411);
            for (Entry entry : stringsToReplace.entrySet()) {
                str = str.replace((CharSequence) entry.getKey(), (CharSequence) entry.getValue());
            }
            AppMethodBeat.m2505o(72411);
        }
        return str;
    }

    public Logger(LoggingBehavior loggingBehavior, String str) {
        AppMethodBeat.m2504i(72412);
        Validate.notNullOrEmpty(str, "tag");
        this.behavior = loggingBehavior;
        this.tag = LOG_TAG_BASE.concat(String.valueOf(str));
        this.contents = new StringBuilder();
        AppMethodBeat.m2505o(72412);
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        AppMethodBeat.m2504i(72413);
        Validate.oneOf(Integer.valueOf(i), "value", Integer.valueOf(7), Integer.valueOf(3), Integer.valueOf(6), Integer.valueOf(4), Integer.valueOf(2), Integer.valueOf(5));
        this.priority = i;
        AppMethodBeat.m2505o(72413);
    }

    public String getContents() {
        AppMethodBeat.m2504i(72414);
        String replaceStrings = replaceStrings(this.contents.toString());
        AppMethodBeat.m2505o(72414);
        return replaceStrings;
    }

    public void log() {
        AppMethodBeat.m2504i(72415);
        logString(this.contents.toString());
        this.contents = new StringBuilder();
        AppMethodBeat.m2505o(72415);
    }

    public void logString(String str) {
        AppMethodBeat.m2504i(72416);
        log(this.behavior, this.priority, this.tag, str);
        AppMethodBeat.m2505o(72416);
    }

    public void append(StringBuilder stringBuilder) {
        AppMethodBeat.m2504i(72417);
        if (shouldLog()) {
            this.contents.append(stringBuilder);
        }
        AppMethodBeat.m2505o(72417);
    }

    public void append(String str) {
        AppMethodBeat.m2504i(72418);
        if (shouldLog()) {
            this.contents.append(str);
        }
        AppMethodBeat.m2505o(72418);
    }

    public void append(String str, Object... objArr) {
        AppMethodBeat.m2504i(72419);
        if (shouldLog()) {
            this.contents.append(String.format(str, objArr));
        }
        AppMethodBeat.m2505o(72419);
    }

    public void appendKeyValue(String str, Object obj) {
        AppMethodBeat.m2504i(72420);
        append("  %s:\t%s\n", str, obj);
        AppMethodBeat.m2505o(72420);
    }

    private boolean shouldLog() {
        AppMethodBeat.m2504i(72421);
        boolean isLoggingBehaviorEnabled = FacebookSdk.isLoggingBehaviorEnabled(this.behavior);
        AppMethodBeat.m2505o(72421);
        return isLoggingBehaviorEnabled;
    }
}
