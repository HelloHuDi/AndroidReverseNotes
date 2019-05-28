package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.bdd;
import com.tencent.mm.protocal.protobuf.bla;
import com.tencent.mm.protocal.protobuf.ct;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public final class t extends a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<bla>> {
        final /* synthetic */ b bQV;

        AnonymousClass1(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45279);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), aVar.fsy);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bla bla = (bla) aVar.fsy;
                ab.i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bla.kdT), bla.kdU);
                if (bla.kdT == 0) {
                    this.bQV.B(bla);
                } else {
                    this.bQV.cR(m.a(true, bla.kdT, 0, bla.kdU));
                }
            } else {
                this.bQV.cR(m.gi(aVar.errCode, aVar.errType));
            }
            AppMethodBeat.o(45279);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<ct>> {
        final /* synthetic */ b bQV;

        AnonymousClass2(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45280);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), aVar.fsy);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ct ctVar = (ct) aVar.fsy;
                ab.i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(ctVar.kdT), ctVar.kdU);
                if (ctVar.kdT == 0) {
                    this.bQV.B(ctVar);
                } else {
                    this.bQV.cR(m.a(true, ctVar.kdT, 0, ctVar.kdU));
                }
            } else {
                this.bQV.cR(m.gi(aVar.errCode, aVar.errType));
            }
            AppMethodBeat.o(45280);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$3 */
    class AnonymousClass3 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<bdd>> {
        final /* synthetic */ b bQV;

        AnonymousClass3(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45281);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), aVar.fsy);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bdd bdd = (bdd) aVar.fsy;
                ab.i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bdd.kdT), bdd.kdU);
                if (bdd.kdT == 0) {
                    this.bQV.B(bdd);
                } else {
                    this.bQV.cR(m.a(true, bdd.kdT, 0, bdd.kdU));
                }
            } else {
                this.bQV.cR(m.gi(aVar.errCode, aVar.errType));
            }
            AppMethodBeat.o(45281);
            return null;
        }
    }
}
