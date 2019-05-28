package com.tencent.tinker.lib.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.os.Process;
import com.tencent.tinker.lib.service.TinkerPatchService;
import com.tencent.tinker.loader.shareutil.ShareTinkerInternals;
import java.util.List;

/* renamed from: com.tencent.tinker.lib.util.b */
public final class C31098b extends ShareTinkerInternals {
    private static String ACl = null;

    /* renamed from: iY */
    public static void m50186iY(Context context) {
        String ja = C31098b.m50188ja(context);
        if (ja != null) {
            List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.processName.equals(ja)) {
                        Process.killProcess(runningAppProcessInfo.pid);
                    }
                }
            }
        }
    }

    /* renamed from: iZ */
    public static boolean m50187iZ(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String ja = C31098b.m50188ja(context);
        if (ja == null) {
            return false;
        }
        try {
            List<RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo.processName.equals(ja)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            new StringBuilder("isTinkerPatchServiceRunning Exception: ").append(e.toString());
            return false;
        } catch (Error e2) {
            new StringBuilder("isTinkerPatchServiceRunning Error: ").append(e2.toString());
            return false;
        }
    }

    /* renamed from: ja */
    private static String m50188ja(Context context) {
        if (ACl != null) {
            return ACl;
        }
        String c = C31098b.m50185c(context, TinkerPatchService.class);
        if (c == null) {
            return null;
        }
        ACl = c;
        return c;
    }

    /* renamed from: jb */
    public static boolean m50189jb(Context context) {
        String aD = ShareTinkerInternals.m9416aD(context);
        String ja = C31098b.m50188ja(context);
        if (ja == null || ja.length() == 0) {
            return false;
        }
        return aD.equals(ja);
    }

    /* renamed from: c */
    private static String m50185c(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
