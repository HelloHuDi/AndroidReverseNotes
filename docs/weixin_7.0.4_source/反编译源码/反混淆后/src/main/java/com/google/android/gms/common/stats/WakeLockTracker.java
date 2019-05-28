package com.google.android.gms.common.stats;

import android.content.AbstractThreadedSyncAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.util.DeviceStateUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;
import java.util.List;

public class WakeLockTracker {
    @VisibleForTesting
    private static boolean zzyh = false;
    private static WakeLockTracker zzyz = new WakeLockTracker();
    private static Boolean zzza;

    static {
        AppMethodBeat.m2504i(89991);
        AppMethodBeat.m2505o(89991);
    }

    public static WakeLockTracker getInstance() {
        return zzyz;
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, String str4) {
        AppMethodBeat.m2504i(89986);
        registerAcquireEvent(context, intent, str, str2, str3, i, Arrays.asList(new String[]{str4}));
        AppMethodBeat.m2505o(89986);
    }

    public void registerAcquireEvent(Context context, Intent intent, String str, String str2, String str3, int i, List<String> list) {
        AppMethodBeat.m2504i(89987);
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 7, str, str2, str3, i, list);
        AppMethodBeat.m2505o(89987);
    }

    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list) {
        AppMethodBeat.m2504i(89989);
        registerEvent(context, str, i, str2, str3, str4, i2, list, 0);
        AppMethodBeat.m2505o(89989);
    }

    public void registerEvent(Context context, String str, int i, String str2, String str3, String str4, int i2, List<String> list, long j) {
        AppMethodBeat.m2504i(89990);
        if (zzza == null) {
            zzza = Boolean.FALSE;
        }
        if (!zzza.booleanValue()) {
            AppMethodBeat.m2505o(89990);
        } else if (TextUtils.isEmpty(str)) {
            String str5 = "missing wakeLock key. ";
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str5.concat(valueOf);
                AppMethodBeat.m2505o(89990);
                return;
            }
            valueOf = new String(str5);
            AppMethodBeat.m2505o(89990);
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            if (7 == i || 8 == i || 10 == i || 11 == i) {
                List list2;
                if (list == null || list.size() != 1) {
                    List<String> list22 = list;
                } else {
                    if ("com.google.android.gms".equals(list.get(0))) {
                        list = null;
                    }
                    list22 = list;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                int deviceState = DeviceStateUtils.getDeviceState(context);
                String packageName = context.getPackageName();
                if ("com.google.android.gms".equals(packageName)) {
                    packageName = null;
                }
                try {
                    context.startService(new Intent().setComponent(LoggingConstants.STATS_SERVICE_COMPONENT_NAME).putExtra(LoggingConstants.EXTRA_LOG_EVENT, new WakeLockEvent(currentTimeMillis, i, str2, i2, list22, str, elapsedRealtime, deviceState, str3, packageName, DeviceStateUtils.getPowerPercentage(context), j, str4)));
                    AppMethodBeat.m2505o(89990);
                    return;
                } catch (Exception e) {
                    Log.wtf("WakeLockTracker", e);
                }
            }
            AppMethodBeat.m2505o(89990);
        }
    }

    public void registerReleaseEvent(Context context, Intent intent) {
        AppMethodBeat.m2504i(89988);
        registerEvent(context, intent.getStringExtra(LoggingConstants.EXTRA_WAKE_LOCK_KEY), 8, null, null, null, 0, null);
        AppMethodBeat.m2505o(89988);
    }

    public void registerSyncEnd(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2, boolean z) {
        AppMethodBeat.m2504i(89985);
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 11, str, str2, null, 0, null);
        AppMethodBeat.m2505o(89985);
    }

    public void registerSyncStart(Context context, AbstractThreadedSyncAdapter abstractThreadedSyncAdapter, String str, String str2) {
        AppMethodBeat.m2504i(89984);
        registerEvent(context, StatsUtils.getEventKey(abstractThreadedSyncAdapter, str), 10, str, str2, null, 0, null);
        AppMethodBeat.m2505o(89984);
    }
}
