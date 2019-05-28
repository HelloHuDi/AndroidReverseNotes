package com.tencent.mm.plugin.luckymoney.appbrand.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.f;
import com.tencent.mm.protocal.protobuf.bsr;
import com.tencent.mm.protocal.protobuf.btd;

public abstract class a<Req extends bsr, Resp extends btd> {
    private com.tencent.mm.ai.a nRJ;
    Req nRK;
    private Resp nRL;

    public abstract int ZU();

    public abstract Resp bKR();

    public abstract String getUri();

    public final <T> f<T> b(com.tencent.mm.vending.c.a<T, com.tencent.mm.ai.a.a<Resp>> aVar) {
        boolean z = true;
        bKS();
        this.nRL = bKR();
        this.nRJ = new com.tencent.mm.ai.a();
        com.tencent.mm.ai.a aVar2 = this.nRJ;
        bsr bsr = this.nRK;
        btd btd = this.nRL;
        if (bsr == null || btd == null) {
            StringBuilder append = new StringBuilder("CgiBase called withoud req or resp req?[").append(bsr == null).append("] resp?[");
            if (btd != null) {
                z = false;
            }
            throw new IllegalStateException(append.append(z).append("]").toString());
        }
        com.tencent.mm.ai.b.a aVar3 = new com.tencent.mm.ai.b.a();
        aVar3.fsI = ZU();
        aVar3.uri = getUri();
        aVar3.fsJ = bsr;
        aVar3.fsK = btd;
        aVar2.ehh = aVar3.acD();
        return this.nRJ.acy().g(new com.tencent.mm.vending.c.a<com.tencent.mm.ai.a.a<Resp>, com.tencent.mm.ai.a.a<Resp>>() {
            public final /* synthetic */ Object call(Object obj) {
                AppMethodBeat.i(41982);
                com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
                a.this.bKT();
                AppMethodBeat.o(41982);
                return aVar;
            }
        }).b((com.tencent.mm.vending.c.a) aVar);
    }

    /* Access modifiers changed, original: protected */
    public void bKS() {
    }

    /* Access modifiers changed, original: protected */
    public void bKT() {
    }
}
