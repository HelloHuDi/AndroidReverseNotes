package com.tencent.p177mm.plugin.luckymoney.appbrand.p988a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p217ci.C37654f;
import com.tencent.p177mm.protocal.protobuf.bsr;
import com.tencent.p177mm.protocal.protobuf.btd;
import com.tencent.p177mm.vending.p637c.C5681a;

/* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.a */
public abstract class C46056a<Req extends bsr, Resp extends btd> {
    private C37440a nRJ;
    Req nRK;
    private Resp nRL;

    /* renamed from: com.tencent.mm.plugin.luckymoney.appbrand.a.a$1 */
    class C432471 implements C5681a<C37441a<Resp>, C37441a<Resp>> {
        C432471() {
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(41982);
            C37441a c37441a = (C37441a) obj;
            C46056a.this.bKT();
            AppMethodBeat.m2505o(41982);
            return c37441a;
        }
    }

    /* renamed from: ZU */
    public abstract int mo24259ZU();

    public abstract Resp bKR();

    public abstract String getUri();

    /* renamed from: b */
    public final <T> C37654f<T> mo73978b(C5681a<T, C37441a<Resp>> c5681a) {
        boolean z = true;
        bKS();
        this.nRL = bKR();
        this.nRJ = new C37440a();
        C37440a c37440a = this.nRJ;
        bsr bsr = this.nRK;
        btd btd = this.nRL;
        if (bsr == null || btd == null) {
            StringBuilder append = new StringBuilder("CgiBase called withoud req or resp req?[").append(bsr == null).append("] resp?[");
            if (btd != null) {
                z = false;
            }
            throw new IllegalStateException(append.append(z).append("]").toString());
        }
        C1196a c1196a = new C1196a();
        c1196a.fsI = mo24259ZU();
        c1196a.uri = getUri();
        c1196a.fsJ = bsr;
        c1196a.fsK = btd;
        c37440a.ehh = c1196a.acD();
        return this.nRJ.acy().mo60491g(new C432471()).mo60487b((C5681a) c5681a);
    }

    /* Access modifiers changed, original: protected */
    public void bKS() {
    }

    /* Access modifiers changed, original: protected */
    public void bKT() {
    }
}
