package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.q.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.q.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.q.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.a.a.q.AnonymousClass4;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.vending.g.f;
import com.tencent.mm.vending.h.e;

public class r implements com.tencent.mm.vending.c.b<q> {
    protected q tfB;
    public final b tfC;
    public final a tfD;
    public final d tfE;
    public final c tfF;

    public class a implements e<sw, com.tencent.mm.vending.j.c<String, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45269);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            q qVar = r.this.tfB;
            String str = (String) cVar.get(0);
            int intValue = ((Integer) cVar.get(1)).intValue();
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            ab.i("MicroMsg.LqtDetailInteractor", "closeAccount, accountType: %s", Integer.valueOf(intValue));
            new b(str, intValue).acy().h(new AnonymousClass2(dMj));
            AppMethodBeat.o(45269);
            return null;
        }

        public final String HZ() {
            return "Vending.LOGIC";
        }
    }

    public class c implements e<bfg, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45273);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            q qVar = r.this.tfB;
            int intValue = ((Integer) cVar.get(0)).intValue();
            int intValue2 = ((Integer) cVar.get(1)).intValue();
            ab.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase, accountType: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new e(intValue, intValue2).acy().b(new AnonymousClass4(dMj));
            AppMethodBeat.o(45273);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }

        public final com.tencent.mm.vending.g.c<bfg> ge(int i, int i2) {
            AppMethodBeat.i(45272);
            com.tencent.mm.vending.g.c c = f.D(Integer.valueOf(i), Integer.valueOf(i2)).c(this);
            AppMethodBeat.o(45272);
            return c;
        }
    }

    public class d implements e<bfi, com.tencent.mm.vending.j.c<Integer, Integer>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45274);
            com.tencent.mm.vending.j.c cVar = (com.tencent.mm.vending.j.c) obj;
            q qVar = r.this.tfB;
            int intValue = ((Integer) cVar.get(0)).intValue();
            ((Integer) cVar.get(1)).intValue();
            ab.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem, accountType: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            new f(intValue).acy().b(new AnonymousClass3(dMj));
            AppMethodBeat.o(45274);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class b implements e<bnr, Void> {
        public final String HZ() {
            return "Vending.LOGIC";
        }

        public final com.tencent.mm.vending.g.c<bnr> aor() {
            AppMethodBeat.i(45270);
            com.tencent.mm.vending.g.c c = f.dMn().c(this);
            AppMethodBeat.o(45270);
            return c;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45271);
            q qVar = r.this.tfB;
            com.tencent.mm.vending.g.b dMj = f.dMj();
            dMj.dMi();
            if (!at.isNetworkConnected(ah.getContext())) {
                dMj.cR(Boolean.FALSE);
            }
            new l().acy().h(new AnonymousClass1(dMj));
            AppMethodBeat.o(45271);
            return null;
        }
    }

    public r() {
        this(new q());
        AppMethodBeat.i(45275);
        AppMethodBeat.o(45275);
    }

    private r(q qVar) {
        AppMethodBeat.i(45276);
        this.tfC = new b();
        this.tfD = new a();
        this.tfE = new d();
        this.tfF = new c();
        this.tfB = qVar;
        AppMethodBeat.o(45276);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfB;
    }
}
