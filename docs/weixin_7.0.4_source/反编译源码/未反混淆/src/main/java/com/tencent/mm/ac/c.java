package com.tencent.mm.ac;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

public final class c implements ActivityLifecycleCallbacks {
    private Application application;

    private c(Application application) {
        this.application = application;
    }

    public static void c(Application application) {
        AppMethodBeat.i(115070);
        if (Build.MANUFACTURER.equals("samsung") && VERSION.SDK_INT >= 19 && VERSION.SDK_INT <= 24) {
            application.registerActivityLifecycleCallbacks(new c(application));
        }
        AppMethodBeat.o(115070);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityResumed(Activity activity) {
    }

    public final void onActivityPaused(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(115071);
        try {
            Class cls = Class.forName("com.samsung.android.emergencymode.SemEmergencyManager");
            Field declaredField = cls.getDeclaredField("sInstance");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Field declaredField2 = cls.getDeclaredField("mContext");
            declaredField2.setAccessible(true);
            declaredField2.set(obj, this.application);
        } catch (Exception e) {
        }
        this.application.unregisterActivityLifecycleCallbacks(this);
        AppMethodBeat.o(115071);
    }
}
