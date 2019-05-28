package com.tencent.mm.plugin.soter.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.a;
import com.tencent.mm.vending.g.b;
import com.tencent.mm.vending.g.f;
import com.tencent.soter.a.f.e;

public final class c implements a<Boolean, com.tencent.mm.vending.j.c<Boolean, Boolean>> {
    private b glt = null;

    public final /* synthetic */ Object call(Object obj) {
        AppMethodBeat.i(59359);
        final com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
        ab.v("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc call");
        Boolean bool;
        if (((Boolean) cVar.get(0)).booleanValue()) {
            this.glt = f.dMj();
            if (com.tencent.soter.a.a.dRc()) {
                com.tencent.mm.plugin.soter.b.f fVar;
                if (g.RK()) {
                    fVar = new com.tencent.mm.plugin.soter.b.f();
                } else {
                    fVar = new com.tencent.mm.plugin.soter.b.g();
                }
                e eVar = fVar;
                ab.v("MicroMsg.SoterPrepareAskFunc", "alvinluo has ask: %b", Boolean.valueOf(com.tencent.soter.core.a.dQQ()));
                this.glt.dMi();
                com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b<com.tencent.soter.a.b.c>() {
                    public final /* synthetic */ void a(com.tencent.soter.a.b.e eVar) {
                        AppMethodBeat.i(59358);
                        com.tencent.soter.a.b.c cVar = (com.tencent.soter.a.b.c) eVar;
                        ab.i("MicroMsg.SoterPrepareAskFunc", "alvinluo SoterPrepareAskFunc onResult errCode: %d, errMsg: %s", Integer.valueOf(cVar.errCode), cVar.aIm);
                        if (cVar.isSuccess()) {
                            c.this.glt.B(cVar.get(1));
                            AppMethodBeat.o(59358);
                            return;
                        }
                        com.tencent.mm.plugin.soter.d.a.fH(1, cVar.errCode);
                        c.this.glt.cR(f.E(Integer.valueOf(cVar.errCode), cVar.aIm));
                        AppMethodBeat.o(59358);
                    }
                }, false, eVar);
                ab.v("MicroMsg.SoterPrepareAskFunc", "alvinluo prepareask isNeedSaveDeviceInfo: %b", cVar.get(1));
                bool = (Boolean) cVar.get(1);
                AppMethodBeat.o(59359);
                return bool;
            }
            Object obj2 = Boolean.FALSE;
            AppMethodBeat.o(59359);
            return obj2;
        }
        ab.i("MicroMsg.SoterPrepareAskFunc", "alvinluo not need prepare ask, return");
        bool = (Boolean) cVar.get(1);
        AppMethodBeat.o(59359);
        return bool;
    }
}
