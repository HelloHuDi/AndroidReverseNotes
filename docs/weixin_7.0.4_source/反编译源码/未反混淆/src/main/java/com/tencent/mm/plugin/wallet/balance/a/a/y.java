package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet.balance.a.a.x.AnonymousClass1;
import com.tencent.mm.plugin.wallet.balance.a.a.x.AnonymousClass2;
import com.tencent.mm.plugin.wallet.balance.a.a.x.AnonymousClass3;
import com.tencent.mm.plugin.wallet.balance.a.a.x.AnonymousClass4;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.h.e;
import com.tencent.mm.vending.j.f;

public class y implements com.tencent.mm.vending.c.b<x> {
    protected x tfV;
    public final d tfW;
    public final b tfX;
    public final c tfY;
    public final a tfZ;

    public class b implements e<bnp, f<String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45301);
            f fVar = (f) obj;
            x xVar = y.this.tfV;
            String str = (String) fVar.get(0);
            String str2 = (String) fVar.get(1);
            int intValue = ((Integer) fVar.get(2)).intValue();
            String str3 = (String) fVar.get(4);
            ab.i("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, accountType: %s", str, str2, Integer.valueOf(((Integer) fVar.get(3)).intValue()));
            ab.d("MicroMsg.LqtSaveFetchInteractor", "do lqtQueryPurchaseResult, tradeNo: %s, transactionId: %s, purchaseFee: %s", str, str2, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            dMj.dMi();
            new k(str, str2, intValue, r4, str3).acy().b(new AnonymousClass2(dMj));
            AppMethodBeat.o(45301);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class c implements e<bqq, f<Integer, String, String, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45302);
            f fVar = (f) obj;
            x xVar = y.this.tfV;
            int intValue = ((Integer) fVar.get(0)).intValue();
            String str = (String) fVar.get(1);
            String str2 = (String) fVar.get(4);
            ab.i("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemListId: %s, accountType: %s", (String) fVar.get(2), Integer.valueOf(((Integer) fVar.get(3)).intValue()));
            ab.d("MicroMsg.LqtSaveFetchInteractor", "do lqtRedeemFund, redeemFee: %s, payPasswdEnc: %s, redeemListId: %s", Integer.valueOf(intValue), str, r3);
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            dMj.dMi();
            new m(intValue, str, r3, r4, str2).acy().b(new AnonymousClass3(dMj));
            AppMethodBeat.o(45302);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class d implements e<bmo, f<String, String, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45303);
            f fVar = (f) obj;
            x xVar = y.this.tfV;
            String str = (String) fVar.get(0);
            String str2 = (String) fVar.get(1);
            int intValue = ((Integer) fVar.get(2)).intValue();
            String str3 = (String) fVar.get(4);
            ab.i("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, accountType: %s, spid: %s", str, Integer.valueOf(((Integer) fVar.get(3)).intValue()), str2);
            ab.d("MicroMsg.LqtSaveFetchInteractor", "do lqtSave, fundCode: %s, purchaseFee: %s", str, Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            dMj.dMi();
            new j(str, str2, intValue, r4, str3).acy().b(new AnonymousClass1(dMj));
            AppMethodBeat.o(45303);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public class a implements e<blh, f<Integer, ha, Integer, Integer, String>> {
        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45300);
            f fVar = (f) obj;
            x xVar = y.this.tfV;
            int intValue = ((Integer) fVar.get(0)).intValue();
            ha haVar = (ha) fVar.get(1);
            int intValue2 = ((Integer) fVar.get(2)).intValue();
            int intValue3 = ((Integer) fVar.get(3)).intValue();
            String str = (String) fVar.get(4);
            ab.i("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, accountType: %s", Integer.valueOf(intValue2));
            ab.d("MicroMsg.LqtSaveFetchInteractor", "do lqtPreRedeemFund, redeemFee: %s", Integer.valueOf(intValue));
            com.tencent.mm.vending.g.b dMj = com.tencent.mm.vending.g.f.dMj();
            dMj.dMi();
            new i(intValue, haVar, intValue2, intValue3, str).acy().b(new AnonymousClass4(dMj));
            AppMethodBeat.o(45300);
            return null;
        }

        public final String HZ() {
            return "Vending.UI";
        }
    }

    public y() {
        this(new x());
        AppMethodBeat.i(45304);
        AppMethodBeat.o(45304);
    }

    private y(x xVar) {
        AppMethodBeat.i(45305);
        this.tfW = new d();
        this.tfX = new b();
        this.tfY = new c();
        this.tfZ = new a();
        this.tfV = xVar;
        AppMethodBeat.o(45305);
    }

    public final /* bridge */ /* synthetic */ Object aog() {
        return this.tfV;
    }
}
