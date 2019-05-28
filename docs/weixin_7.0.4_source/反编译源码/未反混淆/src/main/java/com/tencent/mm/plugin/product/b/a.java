package com.tencent.mm.plugin.product.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class a extends c<mt> {
    public a() {
        AppMethodBeat.i(43946);
        this.xxI = mt.class.getName().hashCode();
        AppMethodBeat.o(43946);
    }

    public final /* synthetic */ boolean a(b bVar) {
        String str = null;
        AppMethodBeat.i(43947);
        mt mtVar = (mt) bVar;
        switch (mtVar.cIE.opType) {
            case 1:
                com.tencent.mm.plugin.product.a.a.bZC();
                c bZD = com.tencent.mm.plugin.product.a.a.bZD();
                if (bZD != null) {
                    m b = m.b(null, mtVar.cIE.cIG);
                    bZD.a(b, null);
                    mtVar.cIF.cIH = bZD.bZV();
                    mt.b bVar2 = mtVar.cIF;
                    if (!bo.isNullOrNil(b.bZY())) {
                        str = com.tencent.mm.plugin.product.ui.c.UK(b.bZY());
                    }
                    bVar2.thumbPath = str;
                    mtVar.cIF.cvi = true;
                    break;
                }
                ab.w("MicroMsg.MallProductListener", "error, xml[%s] can not parse", mtVar.cIE.cIG);
                mtVar.cIF.cvi = false;
                break;
        }
        AppMethodBeat.o(43947);
        return false;
    }
}
