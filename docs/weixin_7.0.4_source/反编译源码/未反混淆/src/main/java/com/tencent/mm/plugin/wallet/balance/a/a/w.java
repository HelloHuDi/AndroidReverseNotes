package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.v.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.v.AnonymousClass2;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.d;

public class w implements com.tencent.mm.vending.c.b<v> {
    protected v tfQ;
    public final b tfR;
    public final a tfS;

    public class b implements e<bkl, Void> {
        public final String HZ() {
            return "Vending.UI";
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45292);
            v vVar = w.this.tfQ;
            ab.i("MicroMsg.LqtPlanHomeInteractor", "do plan index");
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new g().acy().b(new AnonymousClass1(dMj));
            AppMethodBeat.o(45292);
            return null;
        }
    }

    public class a implements e<bae, d<Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45291);
            d dVar = (d) obj;
            v vVar = w.this.tfQ;
            int intValue = ((Integer) dVar.get(0)).intValue();
            int intValue2 = ((Integer) dVar.get(1)).intValue();
            String str = (String) dVar.get(2);
            ab.i("MicroMsg.LqtPlanHomeInteractor", "do oper plan");
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new c(intValue, intValue2, str).acy().b(new AnonymousClass2(dMj));
            AppMethodBeat.o(45291);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public w() {
        this(new v());
        AppMethodBeat.i(45293);
        AppMethodBeat.o(45293);
    }

    private w(v vVar) {
        AppMethodBeat.i(45294);
        this.tfR = new b();
        this.tfS = new a();
        this.tfQ = vVar;
        AppMethodBeat.o(45294);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfQ;
    }
}
