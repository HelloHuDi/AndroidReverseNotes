package com.tencent.p177mm.plugin.appbrand.p281b;

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
import com.tencent.p177mm.plugin.appbrand.p329s.C42677e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import java.lang.ref.WeakReference;

/* renamed from: com.tencent.mm.plugin.appbrand.b.f */
public abstract class C10142f {
    private final WeakReference<Activity> gWO;
    public final BroadcastReceiver gWT = new C101431();

    /* renamed from: com.tencent.mm.plugin.appbrand.b.f$1 */
    class C101431 extends BroadcastReceiver {

        /* renamed from: com.tencent.mm.plugin.appbrand.b.f$1$1 */
        class C101441 implements Runnable {
            C101441() {
            }

            public final void run() {
                AppMethodBeat.m2504i(114318);
                C10142f.m17754a(C10142f.this);
                AppMethodBeat.m2505o(114318);
            }
        }

        C101431() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(114319);
            if (intent == null) {
                AppMethodBeat.m2505o(114319);
                return;
            }
            if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                C42677e.aNS().mo10302aa(new C101441());
            }
            AppMethodBeat.m2505o(114319);
        }
    }

    public abstract void awE();

    public C10142f(Activity activity) {
        this.gWO = new WeakReference(activity);
    }

    /* renamed from: a */
    static /* synthetic */ void m17754a(C10142f c10142f) {
        Activity activity = (Activity) c10142f.gWO.get();
        if (activity != null) {
            PackageManager packageManager = activity.getPackageManager();
            ActivityManager activityManager = (ActivityManager) activity.getSystemService("activity");
            RunningTaskInfo av = C5046bo.m7523av(activity, activity.getTaskId());
            if (av != null) {
                try {
                    ComponentName componentName = av.topActivity;
                    if (componentName != null && activityManager != null && packageManager != null) {
                        ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
                        if (activityInfo != null) {
                            for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                                if ((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == ErrorCode.THROWABLE_INITX5CORE) && ((componentName.equals(runningAppProcessInfo.importanceReasonComponent) || runningAppProcessInfo.importanceReasonCode == 0) && runningAppProcessInfo.processName.equals(activityInfo.processName))) {
                                    c10142f.awE();
                                    return;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    C4990ab.m7412e("MicroMsg.BaseAppBrandUIScreenOffReceiver", "ScreenOff try confirm task top ui status, e = ".concat(String.valueOf(e)));
                }
            }
        }
    }
}
