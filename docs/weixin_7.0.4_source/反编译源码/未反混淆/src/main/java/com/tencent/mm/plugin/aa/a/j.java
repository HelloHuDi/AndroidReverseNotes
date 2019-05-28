package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public final class j implements com.tencent.mm.vending.c.b<i> {
    protected i glL;
    public final b glM;
    public final a glN;

    public class a implements e<Boolean, com.tencent.mm.vending.j.e<String, Integer, String, Long>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40628);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            i iVar = j.this.glL;
            String str = (String) eVar.get(0);
            int intValue = ((Integer) eVar.get(1)).intValue();
            String str2 = (String) eVar.get(2);
            long longValue = ((Long) eVar.get(3)).longValue();
            iVar.fsC = f.dMj();
            iVar.cvx = longValue;
            if (bo.isNullOrNil(str)) {
                iVar.fsC.cR(Boolean.FALSE);
            } else {
                m eVar2 = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
                g.RQ();
                g.RO().eJo.a(eVar2, 0);
                ab.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                iVar.fsC = f.dMo();
            }
            AppMethodBeat.o(40628);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class b implements e<Boolean, d<String, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40629);
            d dVar = (d) obj;
            i iVar = j.this.glL;
            String str = (String) dVar.get(0);
            int intValue = ((Integer) dVar.get(1)).intValue();
            String str2 = (String) dVar.get(2);
            iVar.fsC = f.dMj();
            if (bo.isNullOrNil(str)) {
                iVar.fsC.cR(Boolean.FALSE);
            } else {
                m eVar = new com.tencent.mm.plugin.aa.a.a.e(str, intValue, str2);
                g.RQ();
                g.RO().eJo.a(eVar, 0);
                ab.i("MicroMsg.CloseAALogic", "closeAA, billNo: %s, scene: %s", str, Integer.valueOf(intValue));
                iVar.fsC = f.dMo();
            }
            AppMethodBeat.o(40629);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public j() {
        this(new i());
        AppMethodBeat.i(40630);
        AppMethodBeat.o(40630);
    }

    private j(i iVar) {
        AppMethodBeat.i(40631);
        this.glM = new b();
        this.glN = new a();
        this.glL = iVar;
        AppMethodBeat.o(40631);
    }

    public final i aoo() {
        return this.glL;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glL;
    }
}
