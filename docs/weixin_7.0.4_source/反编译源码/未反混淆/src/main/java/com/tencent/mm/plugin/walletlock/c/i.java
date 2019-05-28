package com.tencent.mm.plugin.walletlock.c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

public enum i {
    ;
    
    private boolean tXd;
    private boolean tXe;
    private Object tXf;
    public HashSet<WeakReference<Activity>> tXg;

    private i(String str) {
        AppMethodBeat.i(51740);
        this.tXd = false;
        this.tXe = false;
        this.tXf = new Object();
        this.tXg = new HashSet();
        AppMethodBeat.o(51740);
    }

    static {
        AppMethodBeat.o(51743);
    }

    public final void nB(boolean z) {
        synchronized (this.tXf) {
            this.tXd = z;
        }
    }

    public final boolean cUd() {
        boolean z;
        synchronized (this.tXf) {
            z = this.tXd;
        }
        return z;
    }

    public final void nC(boolean z) {
        synchronized (this.tXf) {
            this.tXe = z;
        }
    }

    public final boolean cUe() {
        boolean z;
        synchronized (this.tXf) {
            z = this.tXe;
        }
        return z;
    }

    public final void cUf() {
        synchronized (this.tXf) {
            this.tXe = true;
        }
    }

    public final void c(WeakReference<Activity> weakReference) {
        AppMethodBeat.i(51741);
        if (this.tXg != null) {
            if (weakReference.get() != null) {
                ab.v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", ((Activity) weakReference.get()).getClass().getName());
            }
            this.tXg.add(weakReference);
        }
        AppMethodBeat.o(51741);
    }

    public final void cUg() {
        AppMethodBeat.i(51742);
        Iterator it = this.tXg.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                ab.v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", activity.getClass().getName());
                activity.finish();
            }
            it.remove();
        }
        AppMethodBeat.o(51742);
    }
}
