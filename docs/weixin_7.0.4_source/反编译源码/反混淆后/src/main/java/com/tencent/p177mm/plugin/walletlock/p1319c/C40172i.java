package com.tencent.p177mm.plugin.walletlock.p1319c;

import android.app.Activity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.walletlock.c.i */
public enum C40172i {
    ;
    
    private boolean tXd;
    private boolean tXe;
    private Object tXf;
    public HashSet<WeakReference<Activity>> tXg;

    private C40172i(String str) {
        AppMethodBeat.m2504i(51740);
        this.tXd = false;
        this.tXe = false;
        this.tXf = new Object();
        this.tXg = new HashSet();
        AppMethodBeat.m2505o(51740);
    }

    static {
        AppMethodBeat.m2505o(51743);
    }

    /* renamed from: nB */
    public final void mo63515nB(boolean z) {
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

    /* renamed from: nC */
    public final void mo63516nC(boolean z) {
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

    /* renamed from: c */
    public final void mo63510c(WeakReference<Activity> weakReference) {
        AppMethodBeat.m2504i(51741);
        if (this.tXg != null) {
            if (weakReference.get() != null) {
                C4990ab.m7419v("MicroMsg.WalletLockStatusManager", "alvinluo addProtectActivity %s", ((Activity) weakReference.get()).getClass().getName());
            }
            this.tXg.add(weakReference);
        }
        AppMethodBeat.m2505o(51741);
    }

    public final void cUg() {
        AppMethodBeat.m2504i(51742);
        Iterator it = this.tXg.iterator();
        while (it.hasNext()) {
            Activity activity = (Activity) ((WeakReference) it.next()).get();
            if (!(activity == null || activity.isFinishing())) {
                C4990ab.m7419v("MicroMsg.WalletLockStatusManager", "alvinluo finish %s", activity.getClass().getName());
                activity.finish();
            }
            it.remove();
        }
        AppMethodBeat.m2505o(51742);
    }
}
