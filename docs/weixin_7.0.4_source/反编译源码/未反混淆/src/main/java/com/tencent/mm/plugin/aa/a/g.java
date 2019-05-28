package com.tencent.mm.plugin.aa.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.aa.a.a.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.c.b;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.c;

public final class g implements b<f> {
    protected f glI;
    public final a glJ;

    public class a implements e<c<String, String>, com.tencent.mm.vending.j.e<String, Long, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(40606);
            com.tencent.mm.vending.j.e eVar = (com.tencent.mm.vending.j.e) obj;
            f fVar = g.this.glI;
            String str = (String) eVar.get(0);
            long longValue = ((Long) eVar.get(1)).longValue();
            int intValue = ((Integer) eVar.get(2)).intValue();
            String str2 = (String) eVar.get(3);
            if (fVar.glH) {
                ab.e("MicroMsg.AAPayLogic", "aaPay, isPaying!");
            } else {
                m iVar = new i(str, longValue, intValue, str2);
                com.tencent.mm.kernel.g.RQ();
                com.tencent.mm.kernel.g.RO().eJo.a(iVar, 0);
                fVar.glt = f.dMo();
                fVar.glH = true;
            }
            AppMethodBeat.o(40606);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public g() {
        this(new f());
        AppMethodBeat.i(40607);
        AppMethodBeat.o(40607);
    }

    private g(f fVar) {
        AppMethodBeat.i(40608);
        this.glJ = new a();
        this.glI = fVar;
        AppMethodBeat.o(40608);
    }

    public final f aol() {
        return this.glI;
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.glI;
    }
}
