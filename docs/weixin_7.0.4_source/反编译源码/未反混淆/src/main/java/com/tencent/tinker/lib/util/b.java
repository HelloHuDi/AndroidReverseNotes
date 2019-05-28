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

public final class b extends ShareTinkerInternals {
    private static String ACl = null;

    public static void iY(Context context) {
        String ja = ja(context);
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

    public static boolean iZ(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        String ja = ja(context);
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

    private static String ja(Context context) {
        if (ACl != null) {
            return ACl;
        }
        String c = c(context, TinkerPatchService.class);
        if (c == null) {
            return null;
        }
        ACl = c;
        return c;
    }

    public static boolean jb(Context context) {
        String aD = ShareTinkerInternals.aD(context);
        String ja = ja(context);
        if (ja == null || ja.length() == 0) {
            return false;
        }
        return aD.equals(ja);
    }

    private static String c(Context context, Class<? extends Service> cls) {
        try {
            return context.getPackageManager().getServiceInfo(new ComponentName(context, cls), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }
}
