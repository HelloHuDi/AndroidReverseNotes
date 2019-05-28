package com.tencent.mm.plugin.appbrand.s;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import java.util.Queue;

public final class f implements ActivityLifecycleCallbacks {
    public Application app;
    public final Queue<a> iRm = new LinkedList();
    private int iRn = 0;
    public boolean iRo = false;

    public interface a {
        void aNZ();

        void da(Context context);
    }

    public f() {
        AppMethodBeat.i(126633);
        AppMethodBeat.o(126633);
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AppMethodBeat.i(126634);
        this.iRn++;
        if (this.iRn == 1) {
            ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnActivityCreated ");
            for (a da : this.iRm) {
                da.da(activity);
            }
        }
        AppMethodBeat.o(126634);
    }

    public final void onActivityDestroyed(Activity activity) {
        AppMethodBeat.i(126635);
        this.iRn--;
        if (this.iRn == 0) {
            ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.notifyOnNoActivityLeft ");
            for (a aNZ : this.iRm) {
                aNZ.aNZ();
            }
            if (this.iRo && this.app != null) {
                Application application = this.app;
                ab.i("MicroMsg.AppSingletonRegistry", "AppSingletonRegistry.release ");
                application.unregisterActivityLifecycleCallbacks(this);
                this.iRm.clear();
                this.app = null;
                this.iRo = false;
                this.iRo = false;
                this.app = null;
            }
        }
        AppMethodBeat.o(126635);
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
