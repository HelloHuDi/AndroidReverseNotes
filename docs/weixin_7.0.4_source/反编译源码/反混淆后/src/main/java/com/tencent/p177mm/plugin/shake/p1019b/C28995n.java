package com.tencent.p177mm.plugin.shake.p1019b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42060sx;
import com.tencent.p177mm.plugin.shake.p1296e.C43525c;
import com.tencent.p177mm.plugin.shake.p1296e.C43525c.C29005a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.shake.b.n */
public final class C28995n extends C4884c<C42060sx> {
    public C28995n() {
        AppMethodBeat.m2504i(24506);
        this.xxI = C42060sx.class.getName().hashCode();
        AppMethodBeat.m2505o(24506);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(24507);
        C42060sx c42060sx = (C42060sx) c4883b;
        switch (c42060sx.cPa.opType) {
            case 0:
                C29005a WN = C43525c.m77779WN(c42060sx.cPa.cPc);
                if (WN != null) {
                    c42060sx.cPb.cIH = C43525c.m77780a(c42060sx.cPa.context, WN);
                    c42060sx.cPb.thumbPath = C28987m.m46014fQ(WN.field_thumburl, "@B");
                    c42060sx.cPb.cvi = true;
                    break;
                }
                C4990ab.m7421w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", c42060sx.cPa.cPc);
                c42060sx.cPb.cvi = false;
                break;
        }
        AppMethodBeat.m2505o(24507);
        return false;
    }
}
