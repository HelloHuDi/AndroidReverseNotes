package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.protocal.protobuf.C35953sw;
import com.tencent.p177mm.protocal.protobuf.bfg;
import com.tencent.p177mm.protocal.protobuf.bfi;
import com.tencent.p177mm.protocal.protobuf.bnr;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q */
public class C4309q extends C16025a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$4 */
    class C43104 implements C5681a<Void, C37441a<bfg>> {
        final /* synthetic */ C5688b bQV;

        C43104(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45266);
            Void d = m6664d((C37441a) obj);
            AppMethodBeat.m2505o(45266);
            return d;
        }

        /* renamed from: d */
        private Void m6664d(C37441a<bfg> c37441a) {
            AppMethodBeat.m2504i(45265);
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "lqtOnClickPurchase end, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C14103ab.ach(((bfg) c37441a.fsy).tgu);
                C22496p.tfu.mo38047a(((bfg) c37441a.fsy).wJa, true);
                C22496p.tfu.mo38048a((bfg) c37441a.fsy);
            } else {
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.fu2), 1).show();
            }
            this.bQV.resume();
            Void voidR = zXH;
            AppMethodBeat.m2505o(45265);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$1 */
    class C43111 implements C5681a<Void, C37441a<bnr>> {
        final /* synthetic */ C5688b bQV;

        C43111(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45261);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bnr bnr = (bnr) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "on qryusrfunddetail finsih, retcode: %s, retmsg: %s", Integer.valueOf(bnr.kdT), bnr.kdU);
                if (bnr.kdT == 0) {
                    C14103ab.ach(bnr.tgu);
                    this.bQV.mo11581B(bnr);
                    C7060h.pYm.mo8378a(663, 0, 1, false);
                } else {
                    this.bQV.mo11582cR(bnr.kdU);
                    C7060h.pYm.mo8378a(663, 1, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(663, 2, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45261);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$3 */
    class C43123 implements C5681a<Void, C37441a<bfi>> {
        final /* synthetic */ C5688b bQV;

        C43123(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45264);
            Void d = m6665d((C37441a) obj);
            AppMethodBeat.m2505o(45264);
            return d;
        }

        /* renamed from: d */
        private Void m6665d(C37441a<bfi> c37441a) {
            AppMethodBeat.m2504i(45263);
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "lqtOnClickRedeem end, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C14103ab.ach(((bfi) c37441a.fsy).tgu);
                C4319s.cMK().mo9338a((bfi) c37441a.fsy);
                C22496p.tfu.mo38047a(((bfi) c37441a.fsy).wJa, false);
            } else {
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.fu2), 1).show();
            }
            this.bQV.resume();
            Void voidR = zXH;
            AppMethodBeat.m2505o(45263);
            return voidR;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.q$2 */
    class C43132 implements C5681a<Void, C37441a<C35953sw>> {
        final /* synthetic */ C5688b bQV;

        C43132(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45262);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "on close lqt account finish, errType: %s, errCode: %s", Integer.valueOf(c37441a.errType), Integer.valueOf(c37441a.errCode));
            C4309q.cMJ();
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C35953sw c35953sw = (C35953sw) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtDetailInteractor", "on close lqt account finsih, retcode: %s, retmsg: %s", Integer.valueOf(c35953sw.kdT), c35953sw.kdU);
                if (c35953sw.kdT == 0) {
                    C14103ab.ach(c35953sw.tgu);
                    this.bQV.mo11581B(c35953sw);
                    C7060h.pYm.mo8378a(663, 15, 1, false);
                } else {
                    this.bQV.mo11582cR(c35953sw.kdU);
                    C7060h.pYm.mo8378a(663, 16, 1, false);
                }
            } else {
                this.bQV.mo11582cR(Boolean.FALSE);
                C7060h.pYm.mo8378a(663, 17, 1, false);
            }
            Void voidR = zXH;
            AppMethodBeat.m2505o(45262);
            return voidR;
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(45267);
        super.onCreate();
        AppMethodBeat.m2505o(45267);
    }

    static /* synthetic */ void cMJ() {
        AppMethodBeat.m2504i(45268);
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LQT_OPEN_FLAG_INT_SYNC, Integer.valueOf(-1));
        C1720g.m3537RQ();
        C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_LQT_ENTRY_WORDING_STRING_SYNC, null);
        AppMethodBeat.m2505o(45268);
    }
}
