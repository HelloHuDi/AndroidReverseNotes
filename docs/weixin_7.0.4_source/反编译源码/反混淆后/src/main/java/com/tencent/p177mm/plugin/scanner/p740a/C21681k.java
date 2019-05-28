package com.tencent.p177mm.plugin.scanner.p740a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p230g.p231a.C42029mt;
import com.tencent.p177mm.plugin.scanner.C43488e;
import com.tencent.p177mm.plugin.scanner.util.C43494o.C13185a;
import com.tencent.p177mm.sdk.p600b.C4883b;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.scanner.a.k */
public final class C21681k extends C4884c<C42029mt> {
    public C21681k() {
        AppMethodBeat.m2504i(80855);
        this.xxI = C42029mt.class.getName().hashCode();
        AppMethodBeat.m2505o(80855);
    }

    /* renamed from: a */
    public final /* synthetic */ boolean mo4653a(C4883b c4883b) {
        AppMethodBeat.m2504i(80856);
        C42029mt c42029mt = (C42029mt) c4883b;
        switch (c42029mt.cIE.opType) {
            case 0:
                C13185a cV = C43486j.m77691cV(c42029mt.cIE.cIG, 0);
                if (cV != null) {
                    c42029mt.cIF.cIH = C43486j.m77690a(c42029mt.cIE.context, cV);
                    c42029mt.cIF.thumbPath = C43488e.cgy().mo69040fQ(cV.field_thumburl, "@S");
                    c42029mt.cIF.cvi = true;
                    break;
                }
                C4990ab.m7421w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", c42029mt.cIE.cIG);
                c42029mt.cIF.cvi = false;
                break;
        }
        AppMethodBeat.m2505o(80856);
        return false;
    }
}
