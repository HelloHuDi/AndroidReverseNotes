package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.bae;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public final class v extends a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.v$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<bae>> {
        final /* synthetic */ b bQV;

        AnonymousClass2(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45288);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtPlanHomeInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), aVar.fsy);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bae bae = (bae) aVar.fsy;
                ab.i("MicroMsg.LqtPlanHomeInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bae.kdT), bae.kdU);
                if (bae.kdT == 0) {
                    this.bQV.B(bae);
                } else {
                    this.bQV.cR(m.a(true, bae.kdT, 0, bae.kdU));
                }
            } else {
                this.bQV.cR(m.gi(aVar.errCode, aVar.errType));
            }
            AppMethodBeat.o(45288);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.v$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Object, com.tencent.mm.ai.a.a<bkl>> {
        final /* synthetic */ b bQV;

        AnonymousClass1(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45287);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtPlanHomeInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(aVar.errCode), Integer.valueOf(aVar.errType), aVar.fsy);
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bkl bkl = (bkl) aVar.fsy;
                ab.i("MicroMsg.LqtPlanHomeInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bkl.kdT), bkl.kdU);
                if (bkl.kdT == 0) {
                    this.bQV.B(bkl);
                } else {
                    this.bQV.cR(m.a(true, bkl.kdT, 0, bkl.kdU));
                }
            } else {
                this.bQV.cR(m.gi(aVar.errCode, aVar.errType));
            }
            AppMethodBeat.o(45287);
            return null;
        }
    }

    public final void onCreate() {
        AppMethodBeat.i(45289);
        super.onCreate();
        AppMethodBeat.o(45289);
    }

    public final void onDestroy() {
        AppMethodBeat.i(45290);
        super.onDestroy();
        AppMethodBeat.o(45290);
    }
}
