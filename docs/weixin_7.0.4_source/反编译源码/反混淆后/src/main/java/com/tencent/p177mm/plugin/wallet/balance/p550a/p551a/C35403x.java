package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.blh;
import com.tencent.p177mm.protocal.protobuf.bmo;
import com.tencent.p177mm.protocal.protobuf.bnp;
import com.tencent.p177mm.protocal.protobuf.bqq;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x */
public class C35403x extends C16025a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$2 */
    class C141082 implements C5681a<Void, C37441a<bnp>> {
        final /* synthetic */ C5688b bQV;

        C141082(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45296);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finish, cgiBack: %s, errType: %s, errCode: %s", c37441a, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bnp bnp = (bnp) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on qry purchase result finsih, retcode: %s, retmsg: %s, purchase_state: %s", Integer.valueOf(bnp.kdT), bnp.kdU, Integer.valueOf(bnp.wQn));
                if (bnp.kdT == 0) {
                    C14103ab.ach(bnp.tgu);
                    this.bQV.mo11581B(bnp);
                    C7060h.pYm.mo8378a(663, 6, 1, false);
                } else {
                    this.bQV.mo11582cR(bnp.kdU);
                    C7060h.pYm.mo8378a(663, 7, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(663, 8, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45296);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$3 */
    class C141093 implements C5681a<Void, C37441a<bqq>> {
        final /* synthetic */ C5688b bQV;

        C141093(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45297);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", c37441a, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bqq bqq = (bqq) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on redeem fund finsih, retcode: %s, retmsg: %s", Integer.valueOf(bqq.kdT), bqq.kdU);
                if (bqq.kdT == 0) {
                    C14103ab.ach(bqq.tgu);
                    this.bQV.mo11581B(bqq);
                    C7060h.pYm.mo8378a(663, 12, 1, false);
                } else {
                    this.bQV.mo11582cR(bqq.kdU);
                    C7060h.pYm.mo8378a(663, 13, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(663, 14, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45297);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$1 */
    class C295331 implements C5681a<Void, C37441a<bmo>> {
        final /* synthetic */ C5688b bQV;

        C295331(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45295);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finish, cgiBack: %s, errType: %s, errCode: %s", c37441a, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bmo bmo = (bmo) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on purchaseFund finsih, retcode: %s, retmsg: %s, prepayid: %s, out_trade_no: %s", Integer.valueOf(bmo.kdT), bmo.kdU, bmo.wPy, bmo.vAg);
                if (bmo.kdT == 0) {
                    C14103ab.ach(bmo.tgu);
                    this.bQV.mo11581B(c37441a.fsy);
                    C7060h.pYm.mo8378a(663, 3, 1, false);
                } else {
                    this.bQV.mo11582cR(bmo.kdU);
                    C7060h.pYm.mo8378a(664, 4, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(664, 5, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45295);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.x$4 */
    class C354024 implements C5681a<Void, C37441a<blh>> {
        final /* synthetic */ C5688b bQV;

        C354024(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45298);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finish, cgiBack: %s, errType: %s, errCode: %s", c37441a, Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                blh blh = (blh) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtSaveFetchInteractor", "on pre redeem fund finsih, retcode: %s, retmsg: %s, redeem_listid: %s", Integer.valueOf(blh.kdT), blh.kdU, blh.wOn);
                if (blh.kdT == 0) {
                    C14103ab.ach(blh.tgu);
                    this.bQV.mo11581B(blh);
                    C7060h.pYm.mo8378a(663, 9, 1, false);
                } else {
                    this.bQV.mo11582cR(blh.kdU);
                    C7060h.pYm.mo8378a(663, 10, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(663, 11, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45298);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(45299);
        super.onCreate();
        AppMethodBeat.m2505o(45299);
    }
}
