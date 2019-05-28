package com.tencent.p177mm.plugin.appbrand.p329s;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.LinkedList;
import java.util.Queue;

/* renamed from: com.tencent.mm.plugin.appbrand.s.f */
public final class C27289f implements ActivityLifecycleCallbacks {
    public Application app;
    public final Queue<C27290a> iRm = new LinkedList();
    private int iRn = 0;
    public boolean iRo = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.s.f$a */
    public interface C27290a {
        void aNZ();

        /* renamed from: da */
        void mo6375da(Context context);
    }

    public C27289f() {
        AppMethodBeat.m2504i(126633);
        AppMethodBeat.m2505o(126633);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.m2504i(126634);
        this.iRn++;
        if (this.iRn == 1) {
            C4990ab.m7416i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
            for (C27290a da : this.iRm) {
                da.mo6375da(activity);
            }
        }
        AppMethodBeat.m2505o(126634);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.m2504i(126635);
        this.iRn--;
        if (this.iRn == 0) {
            C4990ab.m7416i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
            for (C27290a aNZ : this.iRm) {
                aNZ.aNZ();
            }
            if (this.iRo && this.app != null) {
                Application application = this.app;
                C4990ab.m7416i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
                application.unregisterActivityLifecycleCallbacks(this);
                this.iRm.clear();
                this.app = null;
                this.iRo = false;
                this.iRo = false;
                this.app = null;
            }
        }
        AppMethodBeat.m2505o(126635);
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
}
