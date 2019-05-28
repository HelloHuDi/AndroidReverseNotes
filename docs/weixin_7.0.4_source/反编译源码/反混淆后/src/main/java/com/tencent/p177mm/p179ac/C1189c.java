package com.tencent.p177mm.p179ac;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Field;

/* renamed from: com.tencent.mm.ac.c */
public final class C1189c implements ActivityLifecycleCallbacks {
    private Application application;

    private C1189c(Application application) {
        this.application = application;
    }

    /* renamed from: c */
    public static void m2614c(Application application) {
        AppMethodBeat.m2504i(115070);
        if (Build.MANUFACTURER.equals("samsung") && VERSION.SDK_INT >= 19 && VERSION.SDK_INT <= 24) {
            application.registerActivityLifecycleCallbacks(new C1189c(application));
        }
        AppMethodBeat.m2505o(115070);
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
        AppMethodBeat.m2504i(115071);
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
        AppMethodBeat.m2505o(115071);
    }
}
