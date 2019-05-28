package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager.WakeLock;
import android.os.Process;
import android.text.TextUtils;
import com.google.android.gms.common.stats.StatisticalEventTrackerProvider.StatisticalEventTracker;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class StatsUtils {
    public static String getEventKey(AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str) {
        Object str2;
        AppMethodBeat.m2504i(89972);
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(abstractThreadedSyncAdapter))));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String valueOf2 = String.valueOf(str2);
        if (valueOf2.length() != 0) {
            valueOf2 = valueOf.concat(valueOf2);
            AppMethodBeat.m2505o(89972);
            return valueOf2;
        }
        valueOf2 = new String(valueOf);
        AppMethodBeat.m2505o(89972);
        return valueOf2;
    }

    public static String getEventKey(Context context, Intent intent) {
        AppMethodBeat.m2504i(89970);
        String valueOf = String.valueOf((((long) System.identityHashCode(context)) << 32) | ((long) System.identityHashCode(intent)));
        AppMethodBeat.m2505o(89970);
        return valueOf;
    }

    public static String getEventKey(WakeLock wakeLock, String str) {
        Object str2;
        AppMethodBeat.m2504i(89971);
        String valueOf = String.valueOf(String.valueOf((((long) Process.myPid()) << 32) | ((long) System.identityHashCode(wakeLock))));
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        String valueOf2 = String.valueOf(str2);
        if (valueOf2.length() != 0) {
            valueOf2 = valueOf.concat(valueOf2);
            AppMethodBeat.m2505o(89971);
            return valueOf2;
        }
        valueOf2 = new String(valueOf);
        AppMethodBeat.m2505o(89971);
        return valueOf2;
    }

    public static boolean isLoggingEnabled() {
        AppMethodBeat.m2504i(89969);
        StatisticalEventTracker impl = StatisticalEventTrackerProvider.getImpl();
        if (impl != null && impl.isEnabled() && (zza(Integer.valueOf(impl.getLogLevel(3))) || zza(Integer.valueOf(impl.getLogLevel(2))) || zza(Integer.valueOf(impl.getLogLevel(1))))) {
            AppMethodBeat.m2505o(89969);
            return true;
        }
        AppMethodBeat.m2505o(89969);
        return false;
    }

    public static boolean isTimeOutEvent(StatsEvent statsEvent) {
        AppMethodBeat.m2504i(89973);
        switch (statsEvent.getEventType()) {
            case 6:
            case 9:
            case 12:
                AppMethodBeat.m2505o(89973);
                return true;
            default:
                AppMethodBeat.m2505o(89973);
                return false;
        }
    }

    private static boolean zza(Integer num) {
        AppMethodBeat.m2504i(89968);
        if (num.equals(Integer.valueOf(LoggingConstants.LOG_LEVEL_OFF))) {
            AppMethodBeat.m2505o(89968);
            return false;
        }
        AppMethodBeat.m2505o(89968);
        return true;
    }
}
