package com.tencent.mm.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class bk extends m implements k {
    private f ehi;
    private final a fmT;
    private final String fmU;
    private long fmV;

    public interface a {
        void a(e eVar);
    }

    public bk(a aVar) {
        this(aVar, null);
    }

    public bk(a aVar, String str) {
        AppMethodBeat.i(58111);
        ab.i("MicroMsg.NetSceneLocalProxy", "init LocalProxy task:%s [%s] ", str, bo.dpG());
        this.fmT = aVar;
        this.fmU = str;
        AppMethodBeat.o(58111);
    }

    public final int getType() {
        return 0;
    }

    public final int a(e eVar, f fVar) {
        AppMethodBeat.i(58112);
        c(eVar);
        this.ehi = fVar;
        this.fmV = bo.yz();
        g.RS().aa(new Runnable() {
            public final void run() {
                AppMethodBeat.i(58109);
                bk.this.a(0, 0, 0, null, null, null);
                AppMethodBeat.o(58109);
            }

            public final String toString() {
                AppMethodBeat.i(58110);
                String str = super.toString() + "|doScene";
                AppMethodBeat.o(58110);
                return str;
            }
        });
        AppMethodBeat.o(58112);
        return 0;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        AppMethodBeat.i(58113);
        if (this.fmT != null) {
            ab.d("MicroMsg.NetSceneLocalProxy", "local proxy [%s] end, cost=%d", this.fmU, Long.valueOf(bo.az(this.fmV)));
            this.fmT.a(this.ftf);
        }
        this.ehi.onSceneEnd(0, 0, null, this);
        AppMethodBeat.o(58113);
    }
}
