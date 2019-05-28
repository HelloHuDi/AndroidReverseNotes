package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.t.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.t.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.t.AnonymousClass3;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.h;

public class u implements com.tencent.mm.vending.c.b<t> {
    protected t tfK;
    public final c tfL;
    public final a tfM;
    public final b tfN;

    public class a implements e<ct, h<String, String, String, String, Integer, Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45282);
            h hVar = (h) obj;
            t tVar = u.this.tfK;
            String str = (String) hVar.get(0);
            String str2 = (String) hVar.get(1);
            String str3 = (String) hVar.get(2);
            String str4 = (String) hVar.get(3);
            int intValue = ((Integer) hVar.get(4)).intValue();
            int intValue2 = ((Integer) hVar.get(5)).intValue();
            int intValue3 = ((Integer) hVar.get(6)).intValue();
            ab.i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new a(str, str2, str3, str4, (long) intValue, intValue2, intValue3).acy().b(new AnonymousClass2(dMj));
            AppMethodBeat.o(45282);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class b implements e<bdd, h<Integer, String, String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45283);
            h hVar = (h) obj;
            t tVar = u.this.tfK;
            int intValue = ((Integer) hVar.get(0)).intValue();
            String str = (String) hVar.get(1);
            String str2 = (String) hVar.get(2);
            String str3 = (String) hVar.get(3);
            int intValue2 = ((Integer) hVar.get(4)).intValue();
            int intValue3 = ((Integer) hVar.get(5)).intValue();
            String str4 = (String) hVar.get(6);
            ab.i("MicroMsg.LqtPlanAddInteractor", "do add plan");
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new d(intValue, str, str2, str3, (long) intValue2, intValue3, str4).acy().b(new AnonymousClass3(dMj));
            AppMethodBeat.o(45283);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class c implements e<bla, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45284);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            t tVar = u.this.tfK;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            ab.i("MicroMsg.LqtPlanAddInteractor", "do pre add plan");
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new h(intValue, intValue2).acy().b(new AnonymousClass1(dMj));
            AppMethodBeat.o(45284);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public u() {
        this(new t());
        AppMethodBeat.i(45285);
        AppMethodBeat.o(45285);
    }

    private u(t tVar) {
        AppMethodBeat.i(45286);
        this.tfL = new c();
        this.tfM = new a();
        this.tfN = new b();
        this.tfK = tVar;
        AppMethodBeat.o(45286);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfK;
    }
}
