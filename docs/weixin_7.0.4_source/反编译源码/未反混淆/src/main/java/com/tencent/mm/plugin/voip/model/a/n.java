package com.tencent.mm.plugin.voip.model.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.voip.model.l;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;

public abstract class n<REQ, RESP> extends m implements k {
    protected b ehh;
    f ehi;
    private f mww;
    protected com.tencent.mm.plugin.voip.model.k sPK = l.cIW();

    public abstract f cKt();

    public final void a(int i, final int i2, final int i3, final String str, q qVar, byte[] bArr) {
        fW(i2, i3);
        if (this.mww != null) {
            this.mww.onSceneEnd(i2, i3, str, this);
        }
        if (this.ehi != null) {
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(4738);
                    if (n.this.ehi != null) {
                        n.this.ehi.onSceneEnd(i2, i3, str, n.this);
                    }
                    AppMethodBeat.o(4738);
                }
            });
        }
    }

    public int cKu() {
        return 0;
    }

    public void fW(int i, int i2) {
    }

    public final void cKw() {
        ab.i("MicroMsg.VoipNetSceneBase", "netscene " + getClass().getSimpleName() + '@' + Integer.toHexString(hashCode()) + " is started.");
        g.Rg().a((m) this, 0);
    }

    public final int a(e eVar, f fVar) {
        int cKu = cKu();
        if (cKu != 0) {
            return cKu;
        }
        this.mww = fVar;
        this.ehi = cKt();
        return a(eVar, this.ehh, this);
    }

    public final <RESP> RESP cKx() {
        return this.ehh.fsH.fsP;
    }

    public final <REQ> REQ cKy() {
        return this.ehh.fsG.fsP;
    }
}
