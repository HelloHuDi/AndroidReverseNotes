package com.tencent.mm.plugin.game.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.y;
import com.tencent.mm.plugin.game.f.d;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;

public final class ad extends x {
    public static void a(bc bcVar) {
        AppMethodBeat.i(111377);
        if (bcVar == null || bo.ek(bcVar.nbU)) {
            AppMethodBeat.o(111377);
            return;
        }
        Iterator it = bcVar.nbU.iterator();
        while (it.hasNext()) {
            com.tencent.mm.plugin.game.d.ad adVar = (com.tencent.mm.plugin.game.d.ad) it.next();
            if (adVar.naE != null && adVar.naE.mZk != null) {
                d.a(x.a(adVar.naE.mZk));
            } else if (adVar.naG != null && !bo.ek(adVar.naG.mZK)) {
                Iterator it2 = adVar.naG.mZK.iterator();
                while (it2.hasNext()) {
                    d.a(x.a(((y) it2.next()).mZk));
                }
            } else if (!(adVar.naF == null || adVar.naF.mZk == null)) {
                d.a(x.a(adVar.naF.mZk));
            }
        }
        AppMethodBeat.o(111377);
    }
}
