package com.tencent.mm.plugin.shake.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.sx;
import com.tencent.mm.plugin.shake.e.c.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class n extends c<sx> {
    public n() {
        AppMethodBeat.i(24506);
        this.xxI = sx.class.getName().hashCode();
        AppMethodBeat.o(24506);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(24507);
        sx sxVar = (sx) bVar;
        switch (sxVar.cPa.opType) {
            case 0:
                a WN = com.tencent.mm.plugin.shake.e.c.WN(sxVar.cPa.cPc);
                if (WN != null) {
                    sxVar.cPb.cIH = com.tencent.mm.plugin.shake.e.c.a(sxVar.cPa.context, WN);
                    sxVar.cPb.thumbPath = m.fQ(WN.field_thumburl, "@B");
                    sxVar.cPb.cvi = true;
                    break;
                }
                ab.w("MicroMsg.TVOperationListener", "error, xml[%s] can not parse", sxVar.cPa.cPc);
                sxVar.cPb.cvi = false;
                break;
        }
        AppMethodBeat.o(24507);
        return false;
    }
}
