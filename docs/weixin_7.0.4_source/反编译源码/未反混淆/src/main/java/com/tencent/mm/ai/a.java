package com.tencent.mm.ai;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.f;
import com.tencent.mm.ci.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.btd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import junit.framework.Assert;

public class a<_Resp extends btd> {
    public b ehh;
    b<_Resp> fsv = new b(this);
    private f<a<_Resp>> fsw;

    public static class a<T extends btd> {
        public String aIm;
        public m cwn;
        public int errCode;
        public int errType;
        public T fsy;
        public a fsz;

        public static <T extends btd> a<T> a(int i, int i2, String str, T t, m mVar, a aVar) {
            AppMethodBeat.i(58149);
            a aVar2 = new a();
            aVar2.errType = i;
            aVar2.errCode = i2;
            aVar2.aIm = str;
            aVar2.fsy = t;
            aVar2.cwn = mVar;
            aVar2.fsz = aVar;
            if (aVar != null) {
                aVar.a(i, i2, str, t, mVar);
            }
            AppMethodBeat.o(58149);
            return aVar2;
        }
    }

    static class b<_Resp extends btd> extends m {
        f eIc = null;
        final m fsA = this;
        b fsB;
        com.tencent.mm.vending.g.b fsC;
        a fsD;
        private k fsE = new k() {
            public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
                AppMethodBeat.i(58150);
                com.tencent.mm.vending.g.b bVar = b.this.fsC;
                Object[] objArr = new Object[1];
                objArr[0] = a.a(i2, i3, str, (btd) b.this.fsB.fsH.fsP, b.this, b.this.fsD);
                com.tencent.mm.vending.g.f.a(bVar, objArr);
                b.this.eIc.onSceneEnd(i2, i3, str, b.this.fsA);
                ab.i("MicroMsg.Cgi", "onGYNetEnd:%d func:%d time:%d [%d,%d,%s]", Integer.valueOf(b.this.fsA.hashCode()), Integer.valueOf(b.this.getType()), Long.valueOf(bo.anU() - b.this.mStartTime), Integer.valueOf(i2), Integer.valueOf(i3), str);
                AppMethodBeat.o(58150);
            }
        };
        final long mStartTime = bo.anU();

        public b(a aVar) {
            AppMethodBeat.i(58151);
            this.fsD = aVar;
            AppMethodBeat.o(58151);
        }

        /* Access modifiers changed, original: protected|final */
        public final int acn() {
            return 1;
        }

        public final int getType() {
            return this.fsB.fsI;
        }

        public final int a(e eVar, f fVar) {
            AppMethodBeat.i(58152);
            this.eIc = fVar;
            int a = a(eVar, this.fsB, this.fsE);
            ab.i("MicroMsg.Cgi", "Start doScene:%d func:%d netid:%d time:%d", Integer.valueOf(this.fsA.hashCode()), Integer.valueOf(this.fsB.fsI), Integer.valueOf(a), Long.valueOf(bo.anU() - this.mStartTime));
            if (a < 0) {
                com.tencent.mm.vending.g.b bVar = this.fsC;
                Object[] objArr = new Object[1];
                objArr[0] = a.a(3, -1, "", (btd) this.fsB.fsH.fsP, this, this.fsD);
                com.tencent.mm.vending.g.f.a(bVar, objArr);
            }
            AppMethodBeat.o(58152);
            return a;
        }
    }

    public final void cancel() {
        AppMethodBeat.i(58153);
        if (this.fsv != null) {
            w.c(this.fsv);
        }
        if (this.fsw != null) {
            this.fsw.a(true);
        }
        AppMethodBeat.o(58153);
    }

    public a() {
        AppMethodBeat.i(58154);
        AppMethodBeat.o(58154);
    }

    public final void a(b bVar) {
        this.ehh = bVar;
    }

    public synchronized f<a<_Resp>> acy() {
        f fVar;
        AppMethodBeat.i(58155);
        Assert.assertNotNull("You should set a CommReqResp!", this.ehh);
        Assert.assertTrue("RunCgi NetSceneQueue not ready!", w.adF());
        if (this.fsw == null) {
            this.fsw = g.c(new com.tencent.mm.vending.g.c.a<a<_Resp>>() {
                public final /* synthetic */ Object call() {
                    AppMethodBeat.i(58148);
                    com.tencent.mm.vending.g.b dMo = com.tencent.mm.vending.g.f.dMo();
                    a.this.fsv.fsC = dMo;
                    a.this.fsv.fsB = a.this.ehh;
                    if (!w.fuq.Rh().a(a.this.fsv, 0)) {
                        ab.e("MicroMsg.Cgi", "RunCgi doScene failed!");
                        com.tencent.mm.vending.g.f.a(dMo);
                    }
                    AppMethodBeat.o(58148);
                    return null;
                }
            });
        }
        fVar = this.fsw;
        AppMethodBeat.o(58155);
        return fVar;
    }

    /* Access modifiers changed, original: protected */
    public void a(int i, int i2, String str, _Resp _resp, m mVar) {
    }
}
