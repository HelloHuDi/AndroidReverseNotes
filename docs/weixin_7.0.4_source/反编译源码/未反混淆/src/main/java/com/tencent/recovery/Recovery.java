package com.tencent.recovery;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.recovery.handler.RecoveryMessageHandler;
import com.tencent.recovery.log.RecoveryLog;
import com.tencent.recovery.option.OptionFactory;
import com.tencent.recovery.util.Util;

public class Recovery {
    private static RecoveryMessageHandler AqQ;
    private static long AqR;
    private static String AqS;
    private static boolean AqT = false;
    private static boolean AqU = false;
    private static int AqV = 0;
    private static ActivityLifecycleCallbacks AqW = new ActivityLifecycleCallbacks() {
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            if (!Recovery.AqU && !Recovery.AqQ.hasMessages(3)) {
                Recovery.AqQ.removeCallbacksAndMessages(null);
                String iC = Util.iC(Recovery.context);
                Editor edit = Recovery.context.getSharedPreferences(Recovery.AqS, 0).edit();
                edit.putInt("KeyComponentOnCreateForeground", 1);
                edit.putInt("KeyComponentOnCreateExceptionType", 4096);
                edit.apply();
                Recovery.AqQ.sendEmptyMessageDelayed(3, (long) OptionFactory.eN(iC, 1).azs);
                RecoveryLog.i("Recovery", "%s markActivityOnCreated %s", iC, Long.valueOf(System.currentTimeMillis() - Recovery.AqR));
            }
        }

        public final void onActivityStarted(Activity activity) {
            Recovery.dQb();
        }

        public final void onActivityResumed(Activity activity) {
        }

        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivityStopped(Activity activity) {
            Recovery.dQc();
            if (Recovery.AqV == 0) {
                RecoveryLog.i("Recovery", "%s onActivityStopped: activityForegroundCount is 0", Util.iC(Recovery.context));
                Recovery.QY(16);
            }
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityDestroyed(Activity activity) {
        }
    };
    private static Application application;
    private static Context context;

    static /* synthetic */ int dQb() {
        int i = AqV;
        AqV = i + 1;
        return i;
    }

    static /* synthetic */ int dQc() {
        int i = AqV;
        AqV = i - 1;
        return i;
    }

    public static void dPV() {
        if (!AqU && !AqT) {
            AqT = true;
            String iC = Util.iC(context);
            int bW = RecoveryLogic.bW(context, iC);
            RecoveryLog.i("Recovery", "%s markApplicationOnCreateNormal %d", iC, Long.valueOf(System.currentTimeMillis() - AqR));
            Editor edit = context.getSharedPreferences(AqS, 0).edit();
            edit.remove("KeyAppOnCreateExceptionType");
            edit.putInt("KeyAppOnCreateNormalType", 256);
            if (RecoveryLogic.bW(context, iC) == 16) {
                edit.putInt("KeyComponentOnCreateForeground", bW);
                edit.putInt("KeyComponentOnCreateExceptionType", 4096);
                AqQ.sendEmptyMessageDelayed(2, (long) OptionFactory.eN(iC, bW).azs);
            }
            edit.apply();
        }
    }

    private static void destroy() {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(AqW);
        }
    }

    public static void dPW() {
        if (context != null && !AqU) {
            dPY();
            RecoveryLog.i("Recovery", "%s Recovery.crash %d", Util.iC(context), Long.valueOf(System.currentTimeMillis() - AqR));
            Editor edit = context.getSharedPreferences(AqS, 0).edit();
            if (AqT) {
                edit.putInt("KeyComponentOnCreateExceptionType", 65536);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 65536);
            }
            edit.apply();
            destroy();
        }
    }

    public static void dPX() {
        if (context != null && !AqU) {
            dPY();
            RecoveryLog.i("Recovery", "%s Recovery.anr %d", Util.iC(context), Long.valueOf(System.currentTimeMillis() - AqR));
            Editor edit = context.getSharedPreferences(AqS, 0).edit();
            if (AqT) {
                edit.putInt("KeyComponentOnCreateExceptionType", 1048576);
            } else {
                edit.putInt("KeyAppOnCreateExceptionType", 1048576);
            }
            edit.apply();
            destroy();
        }
    }

    public static void QY(int i) {
        if (context != null && !AqU) {
            dPY();
            String iC = Util.iC(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences(AqS, 0);
            RecoveryLog.i("Recovery", "%s Recovery.normal %s %d", iC, Integer.toHexString(i), Long.valueOf(System.currentTimeMillis() - AqR));
            AqQ.removeCallbacksAndMessages(null);
            Editor edit = sharedPreferences.edit();
            edit.remove("KeyComponentOnCreateExceptionType");
            edit.putInt("KeyComponentOnCreateNormalType", i);
            edit.apply();
            destroy();
        }
    }

    public static Context getContext() {
        return context;
    }

    private static void dPY() {
        if (context != null && !AqU) {
            RecoveryLog.i("Recovery", "%s markFinalStatus", Util.iC(context));
            AqU = true;
        }
    }
}
