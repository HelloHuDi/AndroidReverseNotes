package com.tencent.soter.p663a.p1349d;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.core.p1351c.C44476d;
import com.tencent.soter.p663a.p664g.C40994f;
import com.tencent.soter.p663a.p664g.C44472g;
import junit.framework.Assert;

/* renamed from: com.tencent.soter.a.d.a */
public final class C40987a {
    public CancellationSignal zZp = null;

    /* renamed from: com.tencent.soter.a.d.a$2 */
    class C242902 implements Runnable {
        C242902() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10468);
            C40987a.this.zZp.cancel();
            AppMethodBeat.m2505o(10468);
        }
    }

    /* renamed from: com.tencent.soter.a.d.a$3 */
    class C409883 implements Runnable {
        C409883() {
        }

        public final void run() {
            AppMethodBeat.m2504i(10469);
            C44476d.m80486w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
            C40994f.dRn().dRp();
            AppMethodBeat.m2505o(10469);
        }
    }

    public C40987a() {
        AppMethodBeat.m2504i(10470);
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        dRd();
        AppMethodBeat.m2505o(10470);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: rr */
    public final boolean mo64931rr(final boolean z) {
        AppMethodBeat.m2504i(10471);
        C44476d.m80485v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.zZp.isCanceled()) {
            C44476d.m80484i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            AppMethodBeat.m2505o(10471);
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            C44472g.dRq().mo70644R(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(10467);
                    C44476d.m80485v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    C40987a.this.zZp.cancel();
                    if (z) {
                        C40994f.dRn().dRp();
                    }
                    AppMethodBeat.m2505o(10467);
                }
            });
        } else {
            C44472g.dRq().mo70644R(new C242902());
            C44472g.dRq().mo70646s(new C409883(), 350);
        }
        AppMethodBeat.m2505o(10471);
        return true;
    }

    @SuppressLint({"NewApi"})
    public final void dRd() {
        AppMethodBeat.m2504i(10472);
        this.zZp = new CancellationSignal();
        AppMethodBeat.m2505o(10472);
    }
}
