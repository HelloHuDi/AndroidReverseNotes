package com.tencent.soter.a.d;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.soter.a.g.f;
import com.tencent.soter.a.g.g;
import com.tencent.soter.core.c.d;
import junit.framework.Assert;

public final class a {
    public CancellationSignal zZp = null;

    public a() {
        AppMethodBeat.i(10470);
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        dRd();
        AppMethodBeat.o(10470);
    }

    @SuppressLint({"NewApi"})
    public final boolean rr(final boolean z) {
        AppMethodBeat.i(10471);
        d.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.zZp.isCanceled()) {
            d.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            AppMethodBeat.o(10471);
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10467);
                    d.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    a.this.zZp.cancel();
                    if (z) {
                        f.dRn().dRp();
                    }
                    AppMethodBeat.o(10467);
                }
            });
        } else {
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10468);
                    a.this.zZp.cancel();
                    AppMethodBeat.o(10468);
                }
            });
            g.dRq().s(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10469);
                    d.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
                    f.dRn().dRp();
                    AppMethodBeat.o(10469);
                }
            }, 350);
        }
        AppMethodBeat.o(10471);
        return true;
    }

    @SuppressLint({"NewApi"})
    public final void dRd() {
        AppMethodBeat.i(10472);
        this.zZp = new CancellationSignal();
        AppMethodBeat.o(10472);
    }
}
