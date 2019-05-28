package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.wallet_core.model.C29634m;
import com.tencent.p177mm.protocal.protobuf.C15328ct;
import com.tencent.p177mm.protocal.protobuf.bdd;
import com.tencent.p177mm.protocal.protobuf.bla;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t */
public final class C40054t extends C16025a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$1 */
    class C224991 implements C5681a<Object, C37441a<bla>> {
        final /* synthetic */ C5688b bQV;

        C224991(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45279);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), c37441a.fsy);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bla bla = (bla) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bla.kdT), bla.kdU);
                if (bla.kdT == 0) {
                    this.bQV.mo11581B(bla);
                } else {
                    this.bQV.mo11582cR(C29634m.m47002a(true, bla.kdT, 0, bla.kdU));
                }
            } else {
                this.bQV.mo11582cR(C29634m.m47003gi(c37441a.errCode, c37441a.errType));
            }
            AppMethodBeat.m2505o(45279);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$2 */
    class C225002 implements C5681a<Object, C37441a<C15328ct>> {
        final /* synthetic */ C5688b bQV;

        C225002(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45280);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), c37441a.fsy);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                C15328ct c15328ct = (C15328ct) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(c15328ct.kdT), c15328ct.kdU);
                if (c15328ct.kdT == 0) {
                    this.bQV.mo11581B(c15328ct);
                } else {
                    this.bQV.mo11582cR(C29634m.m47002a(true, c15328ct.kdT, 0, c15328ct.kdU));
                }
            } else {
                this.bQV.mo11582cR(C29634m.m47003gi(c37441a.errCode, c37441a.errType));
            }
            AppMethodBeat.m2505o(45280);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.t$3 */
    class C400553 implements C5681a<Object, C37441a<bdd>> {
        final /* synthetic */ C5688b bQV;

        C400553(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45281);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), c37441a.fsy);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bdd bdd = (bdd) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtPlanAddInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bdd.kdT), bdd.kdU);
                if (bdd.kdT == 0) {
                    this.bQV.mo11581B(bdd);
                } else {
                    this.bQV.mo11582cR(C29634m.m47002a(true, bdd.kdT, 0, bdd.kdU));
                }
            } else {
                this.bQV.mo11582cR(C29634m.m47003gi(c37441a.errCode, c37441a.errType));
            }
            AppMethodBeat.m2505o(45281);
            return null;
        }
    }
}
