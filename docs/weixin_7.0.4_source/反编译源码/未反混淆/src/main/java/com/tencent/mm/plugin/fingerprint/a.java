package com.tencent.mm.plugin.fingerprint;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.h.d;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fingerprint.b.b;
import com.tencent.mm.plugin.fingerprint.b.c;
import com.tencent.mm.plugin.fingerprint.b.f;
import com.tencent.mm.plugin.fingerprint.b.g;
import com.tencent.mm.plugin.fingerprint.b.i;
import com.tencent.mm.plugin.fingerprint.b.j;
import com.tencent.mm.plugin.fingerprint.b.k;
import com.tencent.mm.plugin.fingerprint.b.p;
import com.tencent.mm.plugin.fingerprint.b.r;
import java.util.HashMap;

public class a implements at {
    private p mqI = new p();
    private j mqJ = new j();
    private k mqK = new k();
    private b mqL = new b();
    private f mqM = new f();
    private g mqN = new g();
    private c mqO;

    public a() {
        AppMethodBeat.i(41348);
        AppMethodBeat.o(41348);
    }

    static {
        AppMethodBeat.i(41353);
        com.tencent.mm.wallet_core.a.g("FingerprintAuth", com.tencent.mm.plugin.fingerprint.ui.a.class);
        AppMethodBeat.o(41353);
    }

    public static a bwM() {
        AppMethodBeat.i(41349);
        a aVar = (a) q.Y(a.class);
        AppMethodBeat.o(41349);
        return aVar;
    }

    public final HashMap<Integer, d> Jx() {
        return null;
    }

    public final void iy(int i) {
    }

    public final void bz(boolean z) {
        AppMethodBeat.i(41350);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqI);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqJ);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqK);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqL);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqM);
        com.tencent.mm.sdk.b.a.xxA.c(this.mqN);
        com.tencent.mm.kernel.g.a(i.class, new e(new r()));
        AppMethodBeat.o(41350);
    }

    public final void bA(boolean z) {
    }

    public final void onAccountRelease() {
        AppMethodBeat.i(41351);
        com.tencent.mm.sdk.b.a.xxA.d(this.mqI);
        this.mqJ.release();
        com.tencent.mm.sdk.b.a.xxA.d(this.mqJ);
        com.tencent.mm.sdk.b.a.xxA.d(this.mqK);
        com.tencent.mm.sdk.b.a.xxA.d(this.mqL);
        com.tencent.mm.sdk.b.a.xxA.d(this.mqM);
        if (this.mqO != null) {
            c.abort();
            c.release();
            this.mqO = null;
        }
        com.tencent.mm.sdk.b.a.xxA.d(this.mqN);
        com.tencent.mm.kernel.g.L(i.class);
        AppMethodBeat.o(41351);
    }

    public static c bwN() {
        AppMethodBeat.i(41352);
        com.tencent.mm.kernel.g.RN().QU();
        if (bwM().mqO == null) {
            bwM().mqO = new c();
        }
        c cVar = bwM().mqO;
        AppMethodBeat.o(41352);
        return cVar;
    }
}
