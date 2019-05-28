package com.tencent.p177mm.plugin.wallet.balance.p550a.p551a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C37440a.C37441a;
import com.tencent.p177mm.plugin.wallet_core.model.C29634m;
import com.tencent.p177mm.protocal.protobuf.bae;
import com.tencent.p177mm.protocal.protobuf.bkl;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vending.app.C16025a;
import com.tencent.p177mm.vending.p637c.C5681a;
import com.tencent.p177mm.vending.p641g.C5688b;

/* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.v */
public final class C46339v extends C16025a {

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.v$2 */
    class C354012 implements C5681a<Object, C37441a<bae>> {
        final /* synthetic */ C5688b bQV;

        C354012(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45288);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtPlanHomeInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), c37441a.fsy);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bae bae = (bae) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtPlanHomeInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bae.kdT), bae.kdU);
                if (bae.kdT == 0) {
                    this.bQV.mo11581B(bae);
                } else {
                    this.bQV.mo11582cR(C29634m.m47002a(true, bae.kdT, 0, bae.kdU));
                }
            } else {
                this.bQV.mo11582cR(C29634m.m47003gi(c37441a.errCode, c37441a.errType));
            }
            AppMethodBeat.m2505o(45288);
            return null;
        }
    }

    /* renamed from: com.tencent.mm.plugin.wallet.balance.a.a.v$1 */
    class C463381 implements C5681a<Object, C37441a<bkl>> {
        final /* synthetic */ C5688b bQV;

        C463381(C5688b c5688b) {
            this.bQV = c5688b;
        }

        public final /* synthetic */ Object call(Object obj) {
            AppMethodBeat.m2504i(45287);
            C37441a c37441a = (C37441a) obj;
            C4990ab.m7417i("MicroMsg.LqtPlanHomeInteractor", "errCode: %s, errType: %s, resp: %s", Integer.valueOf(c37441a.errCode), Integer.valueOf(c37441a.errType), c37441a.fsy);
            if (c37441a.errType == 0 && c37441a.errCode == 0) {
                bkl bkl = (bkl) c37441a.fsy;
                C4990ab.m7417i("MicroMsg.LqtPlanHomeInteractor", "retCode: %s, retMsg: %s", Integer.valueOf(bkl.kdT), bkl.kdU);
                if (bkl.kdT == 0) {
                    this.bQV.mo11581B(bkl);
                } else {
                    this.bQV.mo11582cR(C29634m.m47002a(true, bkl.kdT, 0, bkl.kdU));
                }
            } else {
                this.bQV.mo11582cR(C29634m.m47003gi(c37441a.errCode, c37441a.errType));
            }
            AppMethodBeat.m2505o(45287);
            return null;
        }
    }

    public final void onCreate() {
        AppMethodBeat.m2504i(45289);
        super.onCreate();
        AppMethodBeat.m2505o(45289);
    }

    public final void onDestroy() {
        AppMethodBeat.m2504i(45290);
        super.onDestroy();
        AppMethodBeat.m2505o(45290);
    }
}
