package com.tencent.soter.p663a.p1105a;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.soter.p663a.p664g.C44472g;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.a.a.a */
public final class C40985a {
    public CancellationSignal zZp = null;

    /* renamed from: com.tencent.soter.a.a.a$2 */
    class C161612 implements Runnable {
        C161612() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10460);
            C40985a.this.zZp.cancel();
            AppMethodBeat.m2505o(10460);
        }
    }

    /* renamed from: com.tencent.soter.a.a.a$3 */
    class C161623 implements Runnable {
        C161623() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10461);
            C44476d.m80486w("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
            C40994f.dRn().dRp();
            AppMethodBeat.m2505o(10461);
        }
    }

    public C40985a() {
        AppMethodBeat.m2504i(10462);
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        dRd();
        AppMethodBeat.m2505o(10462);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: rp */
    public final boolean mo64929rp(final boolean z) {
        AppMethodBeat.m2504i(10463);
        C44476d.m80485v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.zZp.isCanceled()) {
            C44476d.m80484i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
            AppMethodBeat.m2505o(10463);
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            C44472g.dRq().mo70644R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10459);
                    C44476d.m80485v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    C40985a.this.zZp.cancel();
                    if (z) {
                        C40994f.dRn().dRp();
                    }
                    AppMethodBeat.m2505o(10459);
                }
            });
        } else {
            C44472g.dRq().mo70644R(new C161612());
            C44472g.dRq().mo70646s(new C161623(), 350);
        }
        AppMethodBeat.m2505o(10463);
        return true;
    }

    @SuppressLint({"NewApi"})
    public final void dRd() {
        AppMethodBeat.m2504i(10464);
        this.zZp = new CancellationSignal();
        AppMethodBeat.m2505o(10464);
    }
}
