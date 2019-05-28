package com.tencent.mm.plugin.soter.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.soter.d.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.a.b.b;
import com.tencent.soter.a.b.c;
import com.tencent.soter.a.b.e;

public abstract class d extends m implements k {
    private h rNG;

    class a implements a {
        private a() {
        }

        /* synthetic */ a(d dVar, byte b) {
            this();
        }

        public final void cvF() {
            AppMethodBeat.i(59302);
            d.this.bxO();
            AppMethodBeat.o(59302);
        }

        public final void EA(int i) {
            AppMethodBeat.i(59303);
            d.this.vL(i);
            AppMethodBeat.o(59303);
        }
    }

    public abstract void bxO();

    public abstract void d(int i, int i2, String str, q qVar);

    public abstract void vL(int i);

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        int i4 = 1;
        ab.i("MicroMsg.NetSceneSoterBase", "onGYNetEnd errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        this.rNG = new h(new a(this, (byte) 0));
        this.rNG.rNJ = -3202;
        h hVar = this.rNG;
        if (i2 == 4 && i3 == -3200) {
            com.tencent.soter.a.a.a(new b<c>() {
                public final /* synthetic */ void a(e eVar) {
                    AppMethodBeat.i(59318);
                    c cVar = (c) eVar;
                    ab.i("MicroMsg.SoterNetDelegateUtil", "generate and upload ask onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                    if (!cVar.isSuccess()) {
                        a.fH(1, cVar.errCode);
                        if (h.this.rNI != null) {
                            h.this.rNI.EA(cVar.errCode);
                        }
                    } else if (h.this.rNI != null) {
                        h.this.rNI.cvF();
                        AppMethodBeat.o(59318);
                        return;
                    }
                    AppMethodBeat.o(59318);
                }
            }, true, new f());
        } else if (i2 != 4 || i3 != hVar.rNJ) {
            i4 = 0;
        } else if (hVar.rNI != null) {
            hVar.rNI.cvF();
        }
        if (i4 == 0) {
            d(i2, i3, str, qVar);
        }
    }
}
