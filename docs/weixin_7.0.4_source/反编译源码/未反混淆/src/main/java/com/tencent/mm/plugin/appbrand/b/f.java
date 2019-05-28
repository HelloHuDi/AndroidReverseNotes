package com.tencent.mm.plugin.appbrand.b;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.s.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.ref.WeakReference;

public abstract class f {
    private final WeakReference<Activity> gWO;
    public final BroadcastReceiver gWT = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(114319);
            if (intent == null) {
                AppMethodBeat.o(114319);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                e.aNS().aa(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(114318);
                        f.a(f.this);
                        AppMethodBeat.o(114318);
                    }
                });
            }
            AppMethodBeat.o(114319);
        }
    };

    public abstract void awE();

    public f(Activity activity) {
        this.gWO = new WeakReference(activity);
    }

    static /* synthetic */ void a(f fVar) {
        Activity activity = (Activity) fVar.gWO.get();
        if (activity != null) {
            PackageManager packageManager = activity.getPackageManager();
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            RunningTaskInfo av = bo.av(activity, activity.getTaskId());
            if (av != null) {
                try {
                    ComponentName componentName = av.topActivity;
                    if (componentName != null && activityManager != null && packageManager != null) {
                        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                        if (activityInfo != null) {
                            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == ErrorCode.THROWABLE_INITX5CORE) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                    fVar.awE();
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    ab.e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = ".concat(String.valueOf(e)));
                }
            }
        }
    }
}
