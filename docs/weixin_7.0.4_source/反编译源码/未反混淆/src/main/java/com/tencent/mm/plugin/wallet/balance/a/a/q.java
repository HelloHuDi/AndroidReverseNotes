package com.tencent.mm.plugin.wallet.balance.a.a;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bfg;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bnr;
import com.tencent.mm.protocal.protobuf.sw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class q extends a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$4 */
    class AnonymousClass4 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bfg>> {
        final /* synthetic */ b bQV;

        AnonymousClass4(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45266);
            Void d = d((com.tencent.mm.ai.a.a) obj);
            AppMethodBeat.o(45266);
            return d;
        }

        private Void d(com.tencent.mm.ai.a.a<bfg> aVar) {
            AppMethodBeat.i(45265);
            ab.i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ab.ach(((bfg) aVar.fsy).tgu);
                p.tfu.a(((bfg) aVar.fsy).wJa, true);
                p.tfu.a((bfg) aVar.fsy);
            } else {
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.fu2), 1).show();
            }
            this.bQV.resume();
            Void voidR = zXH;
            AppMethodBeat.o(45265);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bnr>> {
        final /* synthetic */ b bQV;

        AnonymousClass1(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45261);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bnr bnr = (bnr) aVar.fsy;
                ab.i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                if (bnr.kdT == 0) {
                    ab.ach(bnr.tgu);
                    this.bQV.B(bnr);
                    h.pYm.a(663, 0, 1, false);
                } else {
                    this.bQV.cR(bnr.kdU);
                    h.pYm.a(663, 1, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(663, 2, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45261);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$3 */
    class AnonymousClass3 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bfi>> {
        final /* synthetic */ b bQV;

        AnonymousClass3(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45264);
            Void d = d((com.tencent.mm.ai.a.a) obj);
            AppMethodBeat.o(45264);
            return d;
        }

        private Void d(com.tencent.mm.ai.a.a<bfi> aVar) {
            AppMethodBeat.i(45263);
            ab.i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                ab.ach(((bfi) aVar.fsy).tgu);
                s.cMK().a((bfi) aVar.fsy);
                p.tfu.a(((bfi) aVar.fsy).wJa, false);
            } else {
                Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.fu2), 1).show();
            }
            this.bQV.resume();
            Void voidR = zXH;
            AppMethodBeat.o(45263);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<sw>> {
        final /* synthetic */ b bQV;

        AnonymousClass2(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45262);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtDetailInteractor", "on close lqt account finish, errType: %s, errCode: %s", Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            q.cMJ();
            if (aVar.errType == 0 && aVar.errCode == 0) {
                sw swVar = (sw) aVar.fsy;
                ab.i("MicroMsg.LqtDetailInteractor", "on close lqt account finsih, retcode: %s, retmsg: %s", Integer.valueOf(swVar.kdT), swVar.kdU);
                if (swVar.kdT == 0) {
                    ab.ach(swVar.tgu);
                    this.bQV.B(swVar);
                    h.pYm.a(663, 15, 1, false);
                } else {
                    this.bQV.cR(swVar.kdU);
                    h.pYm.a(663, 16, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(663, 17, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45262);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.i(45267);
        super.onCreate();
        AppMethodBeat.o(45267);
    }

    static /* synthetic */ void cMJ() {
        AppMethodBeat.i(45268);
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(-1));
        g.RQ();
        g.RP().Ry().set(ac.a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, null);
        AppMethodBeat.o(45268);
    }
}
