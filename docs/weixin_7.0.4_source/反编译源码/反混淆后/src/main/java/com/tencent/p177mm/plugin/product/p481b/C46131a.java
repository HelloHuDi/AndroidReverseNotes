package com.tencent.p177mm.plugin.product.p481b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42029mt;
import com.tencent.p177mm.p230g.p231a.C42029mt.C1559b;
import com.tencent.p177mm.plugin.product.p1498a.C34676a;
import com.tencent.p177mm.plugin.product.p482ui.C39492c;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.product.b.a */
public final class C46131a extends C4884c<C42029mt> {
    public C46131a() {
        AppMethodBeat.m2504i(43946);
        this.xxI = C42029mt.class.getName().hashCode();
        AppMethodBeat.m2505o(43946);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        String str = null;
        AppMethodBeat.m2504i(43947);
        C42029mt c42029mt = (C42029mt) c4883b;
        switch (c42029mt.cIE.opType) {
            case 1:
                C34676a.bZC();
                C12808c bZD = C34676a.bZD();
                if (bZD != null) {
                    C12812m b = C12812m.m20813b(null, c42029mt.cIE.cIG);
                    bZD.mo24811a(b, null);
                    c42029mt.cIF.cIH = bZD.bZV();
                    C1559b c1559b = c42029mt.cIF;
                    if (!C5046bo.isNullOrNil(b.bZY())) {
                        str = C39492c.m67475UK(b.bZY());
                    }
                    c1559b.thumbPath = str;
                    c42029mt.cIF.cvi = true;
                    break;
                }
                C4990ab.m7421w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", c42029mt.cIE.cIG);
                c42029mt.cIF.cvi = false;
                break;
        }
        AppMethodBeat.m2505o(43947);
        return false;
    }
}
