package com.google.android.gms.common.stats;

import android.content.ComponentName;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class LoggingConstants {
    public static final String ALARM_LOG_FILE_NAME = ".alarms";
    public static final String CONNECTION_LOG_FILE_NAME = ".service_connections";
    public static final String EXTRA_LOG_EVENT = "com.google.android.gms.common.stats.EXTRA_LOG_EVENT";
    public static final String EXTRA_WAKE_LOCK_KEY = "WAKE_LOCK_KEY";
    public static int IGNORE_INTRA_PROCESS = 16;
    public static int LOG_CLOSE_EVENTS = 4;
    public static final String LOG_FILE_PREFIX = "stats";
    public static int LOG_LEVEL_OFF = 0;
    public static int LOG_MEM_INFO = 32;
    public static int LOG_OPEN_EVENTS = 2;
    public static int LOG_TOO_LONG_EVENTS = 1;
    public static int LOG_VERBOSE = 8;
    public static int LOG_WAKEFUL_ALARMS = 1;
    public static final ComponentName STATS_SERVICE_COMPONENT_NAME = new ComponentName("com.google.android.gms", "com.google.android.gms.common.stats.GmsCoreStatsService");
    public static final String WAKE_LOCK_LOG_FILE_NAME = ".wakelocks";

    static {
        AppMethodBeat.m2504i(89960);
        AppMethodBeat.m2505o(89960);
    }

    private LoggingConstants() {
    }
}
