package com.tencent.recovery.p662wx;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import com.tencent.recovery.log.RecoveryLog;

/* renamed from: com.tencent.recovery.wx.RecoveryTinkerManager */
public class RecoveryTinkerManager {
    /* renamed from: bY */
    public static int m8741bY(Context context, String str) {
        if (RecoveryTinkerManager.m8740bI(context, RecoveryTinkerManager.m8744iD(context))) {
            return -2;
        }
        if (VERSION.SDK_INT < 26) {
            return RecoveryTinkerManager.m8742bZ(context, str);
        }
        return RecoveryTinkerManager.m8743ca(context, str);
    }

    /* renamed from: bZ */
    private static int m8742bZ(Context context, String str) {
        try {
            Intent intent = new Intent();
            intent.setClassName(context, "com.tencent.tinker.lib.service.IntentServiceRunner");
            intent.putExtra("patch_path_extra", str);
            intent.putExtra("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
            context.startService(intent);
            return 0;
        } catch (Throwable th) {
            RecoveryLog.m8711e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
            return -1;
        }
    }

    @TargetApi(21)
    /* renamed from: ca */
    private static int m8743ca(Context context, String str) {
        try {
            Builder builder = new Builder(-252579085, new ComponentName(context, "com.tencent.tinker.lib.service.JobServiceRunner"));
            PersistableBundle persistableBundle = new PersistableBundle();
            persistableBundle.putString("patch_path_extra", str);
            persistableBundle.putString("patch_result_class", "com.tencent.mm.modelrecovery.RecoveryTinkerResultService");
            builder.setExtras(persistableBundle);
            builder.setOverrideDeadline(5);
            JobScheduler jobScheduler = (JobScheduler) context.getSystemService("jobscheduler");
            if (jobScheduler == null) {
                RecoveryLog.m8711e("Recovery.RecoveryTinkerManager", "fail to get job scheduler service.", new Object[0]);
                return -1;
            } else if (jobScheduler.schedule(builder.build()) == 1) {
                return 0;
            } else {
                RecoveryLog.m8711e("Recovery.RecoveryTinkerManager", "fail to schedule job.", new Object[0]);
                return -1;
            }
        } catch (Throwable th) {
            RecoveryLog.m8711e("Recovery.RecoveryTinkerManager", "start patch service fail, exception:".concat(String.valueOf(th)), new Object[0]);
            return -1;
        }
    }

    /* renamed from: iD */
    private static String m8744iD(Context context) {
        String str;
        PackageManager packageManager = context.getPackageManager();
        if (VERSION.SDK_INT < 26) {
            str = "com.tencent.tinker.lib.service.IntentServiceRunner";
        } else {
            str = "com.tencent.tinker.lib.service.JobServiceRunner";
        }
        try {
            return packageManager.getServiceInfo(new ComponentName(context, str), 0).processName;
        } catch (Throwable th) {
            return null;
        }
    }

    /* renamed from: bI */
    private static boolean m8740bI(Context context, String str) {
        try {
            for (RunningAppProcessInfo runningAppProcessInfo : ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses()) {
                if (runningAppProcessInfo.processName != null && runningAppProcessInfo.processName.equals(str)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
