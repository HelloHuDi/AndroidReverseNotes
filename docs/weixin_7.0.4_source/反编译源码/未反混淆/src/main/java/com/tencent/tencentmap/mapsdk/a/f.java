package com.tencent.tencentmap.mapsdk.a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@TargetApi(14)
public final class f implements ActivityLifecycleCallbacks {
    private static SparseArray<WeakReference<Activity>> a = new SparseArray();

    static {
        AppMethodBeat.i(97836);
        AppMethodBeat.o(97836);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(97828);
        a(activity);
        AppMethodBeat.o(97828);
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.i(97829);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97829);
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.i(97830);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97830);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.i(97831);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97831);
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.i(97832);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97832);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AppMethodBeat.i(97833);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97833);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(97834);
        a.b = true;
        a(activity);
        AppMethodBeat.o(97834);
    }

    private static void a(Activity activity) {
        AppMethodBeat.i(97835);
        if (!(activity == null || a == null)) {
            int hashCode = activity.hashCode();
            if (a.get(hashCode) == null) {
                a.put(hashCode, new WeakReference(activity));
            }
        }
        AppMethodBeat.o(97835);
    }
}
