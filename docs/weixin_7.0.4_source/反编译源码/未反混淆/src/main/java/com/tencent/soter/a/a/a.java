package com.tencent.soter.a.a;

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
        AppMethodBeat.i(10462);
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        dRd();
        AppMethodBeat.o(10462);
    }

    @SuppressLint({"NewApi"})
    public final boolean rp(final boolean z) {
        AppMethodBeat.i(10463);
        d.v("Soter.SoterBiometricCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.zZp.isCanceled()) {
            d.i("Soter.SoterBiometricCanceller", "soter: cancellation signal already expired.", new Object[0]);
            AppMethodBeat.o(10463);
            return false;
        }
        if (VERSION.SDK_INT < 23) {
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10459);
                    d.v("Soter.SoterBiometricCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    a.this.zZp.cancel();
                    if (z) {
                        f.dRn().dRp();
                    }
                    AppMethodBeat.o(10459);
                }
            });
        } else {
            g.dRq().R(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10460);
                    a.this.zZp.cancel();
                    AppMethodBeat.o(10460);
                }
            });
            g.dRq().s(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(10461);
                    d.w("Soter.SoterBiometricCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
                    f.dRn().dRp();
                    AppMethodBeat.o(10461);
                }
            }, 350);
        }
        AppMethodBeat.o(10463);
        return true;
    }

    @SuppressLint({"NewApi"})
    public final void dRd() {
        AppMethodBeat.i(10464);
        this.zZp = new CancellationSignal();
        AppMethodBeat.o(10464);
    }
}
