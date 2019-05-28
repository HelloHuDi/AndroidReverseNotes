package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.blh;
import com.tencent.mm.protocal.protobuf.bmo;
import com.tencent.mm.protocal.protobuf.bnp;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.app.a;
import com.tencent.mm.vending.g.b;

public class x extends a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$2 */
    class AnonymousClass2 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bnp>> {
        final /* synthetic */ b bQV;

        AnonymousClass2(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45296);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bnp bnp = (bnp) aVar.fsy;
                ab.i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s, purchase_state: %s", Integer.valueOf(bnp.kdT), bnp.kdU, Integer.valueOf(bnp.wQn));
                if (bnp.kdT == 0) {
                    ab.ach(bnp.tgu);
                    this.bQV.B(bnp);
                    h.pYm.a(663, 6, 1, false);
                } else {
                    this.bQV.cR(bnp.kdU);
                    h.pYm.a(663, 7, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(663, 8, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45296);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$3 */
    class AnonymousClass3 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bqq>> {
        final /* synthetic */ b bQV;

        AnonymousClass3(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45297);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bqq bqq = (bqq) aVar.fsy;
                ab.i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", Integer.valueOf(bqq.kdT), bqq.kdU);
                if (bqq.kdT == 0) {
                    ab.ach(bqq.tgu);
                    this.bQV.B(bqq);
                    h.pYm.a(663, 12, 1, false);
                } else {
                    this.bQV.cR(bqq.kdU);
                    h.pYm.a(663, 13, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(663, 14, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45297);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$1 */
    class AnonymousClass1 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<bmo>> {
        final /* synthetic */ b bQV;

        AnonymousClass1(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45295);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                bmo bmo = (bmo) aVar.fsy;
                ab.i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s, prepayid: %s, out_trade_no: %s", Integer.valueOf(bmo.kdT), bmo.kdU, bmo.wPy, bmo.vAg);
                if (bmo.kdT == 0) {
                    ab.ach(bmo.tgu);
                    this.bQV.B(aVar.fsy);
                    h.pYm.a(663, 3, 1, false);
                } else {
                    this.bQV.cR(bmo.kdU);
                    h.pYm.a(664, 4, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(664, 5, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45295);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$4 */
    class AnonymousClass4 implements com.tencent.mm.vending.c.a<Void, com.tencent.mm.ai.a.a<blh>> {
        final /* synthetic */ b bQV;

        AnonymousClass4(b bVar) {
            this.bQV = bVar;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.i(45298);
            com.tencent.mm.ai.a.a aVar = (com.tencent.mm.ai.a.a) obj;
            ab.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", aVar, Integer.valueOf(aVar.errType), Integer.valueOf(aVar.errCode));
            if (aVar.errType == 0 && aVar.errCode == 0) {
                blh blh = (blh) aVar.fsy;
                ab.i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s, redeem_listid: %s", Integer.valueOf(blh.kdT), blh.kdU, blh.wOn);
                if (blh.kdT == 0) {
                    ab.ach(blh.tgu);
                    this.bQV.B(blh);
                    h.pYm.a(663, 9, 1, false);
                } else {
                    this.bQV.cR(blh.kdU);
                    h.pYm.a(663, 10, 1, false);
                }
            } else {
                this.bQV.cR(Boolean.FALSE);
                h.pYm.a(663, 11, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.o(45298);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.i(45299);
        super.onCreate();
        AppMethodBeat.o(45299);
    }
}
