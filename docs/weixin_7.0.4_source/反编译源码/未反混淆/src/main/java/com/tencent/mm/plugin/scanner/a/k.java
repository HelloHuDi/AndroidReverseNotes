package com.tencent.mm.plugin.scanner.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mt;
import com.tencent.mm.plugin.scanner.e;
import com.tencent.mm.plugin.scanner.util.o.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class k extends c<mt> {
    public k() {
        AppMethodBeat.i(80855);
        this.xxI = mt.class.getName().hashCode();
        AppMethodBeat.o(80855);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(80856);
        mt mtVar = (mt) bVar;
        switch (mtVar.cIE.opType) {
            case 0:
                a cV = j.cV(mtVar.cIE.cIG, 0);
                if (cV != null) {
                    mtVar.cIF.cIH = j.a(mtVar.cIE.context, cV);
                    mtVar.cIF.thumbPath = e.cgy().fQ(cV.field_thumburl, "@S");
                    mtVar.cIF.cvi = true;
                    break;
                }
                ab.w("MicroMsg.ProductOperationListener", "error, xml[%s] can not parse", mtVar.cIE.cIG);
                mtVar.cIF.cvi = false;
                break;
        }
        AppMethodBeat.o(80856);
        return false;
    }
}
