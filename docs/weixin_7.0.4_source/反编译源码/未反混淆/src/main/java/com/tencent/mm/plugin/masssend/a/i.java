package com.tencent.mm.plugin.masssend.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.tu;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.protocal.protobuf.bic;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public final class i extends c<tu> {
    public i() {
        AppMethodBeat.i(22752);
        this.xxI = tu.class.getName().hashCode();
        AppMethodBeat.o(22752);
    }

    public final /* synthetic */ boolean a(b bVar) {
        AppMethodBeat.i(22753);
        List list = ((tu) bVar).cPV.cPW;
        if (list == null || list.size() <= 0) {
            ab.e("MicroMsg.UpdateMassSendPlaceTopListener", "empty mass send top config package");
            AppMethodBeat.o(22753);
        } else {
            byte[] a = aa.a(((bic) list.get(0)).vFG);
            if (a == null || a.length == 0) {
                AppMethodBeat.o(22753);
            } else {
                String str = new String(a);
                ab.i("MicroMsg.UpdateMassSendPlaceTopListener", "MassSendTopConfXml:".concat(String.valueOf(str)));
                h.bNF().Qt(str);
                AppMethodBeat.o(22753);
            }
        }
        return false;
    }
}
