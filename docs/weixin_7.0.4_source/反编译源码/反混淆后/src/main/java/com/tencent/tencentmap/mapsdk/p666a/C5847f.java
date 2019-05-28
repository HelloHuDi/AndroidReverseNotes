package com.tencent.tencentmap.mapsdk.p666a;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

@TargetApi(14)
/* renamed from: com.tencent.tencentmap.mapsdk.a.f */
public final class C5847f implements ActivityLifecycleCallbacks {
    /* renamed from: a */
    private static SparseArray<WeakReference<Activity>> f1485a = new SparseArray();

    static {
        AppMethodBeat.m2504i(97836);
        AppMethodBeat.m2505o(97836);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(97828);
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97828);
    }

    public final void onActivityStarted(Activity activity) {
        AppMethodBeat.m2504i(97829);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97829);
    }

    public final void onActivityResumed(Activity activity) {
        AppMethodBeat.m2504i(97830);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97830);
    }

    public final void onActivityPaused(Activity activity) {
        AppMethodBeat.m2504i(97831);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97831);
    }

    public final void onActivityStopped(Activity activity) {
        AppMethodBeat.m2504i(97832);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97832);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(97833);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97833);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.m2504i(97834);
        C41003a.f16326b = true;
        C5847f.m8976a(activity);
        AppMethodBeat.m2505o(97834);
    }

    /* renamed from: a */
    private static void m8976a(Activity activity) {
        AppMethodBeat.m2504i(97835);
        if (!(activity == null || f1485a == null)) {
            int hashCode = activity.hashCode();
            if (f1485a.get(hashCode) == null) {
                f1485a.put(hashCode, new WeakReference(activity));
            }
        }
        AppMethodBeat.m2505o(97835);
    }
}
