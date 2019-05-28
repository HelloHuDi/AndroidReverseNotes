package com.tencent.p177mm.plugin.wallet_core.p561ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.wallet_core.model.C22589al;
import com.tencent.p177mm.plugin.wallet_core.p749c.C40095o;
import com.tencent.p177mm.plugin.wallet_core.p749c.C43788f;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.wallet_core.ui.s */
public final class C7186s implements C1202f {
    public boolean cui = false;
    public C7188b tLw;
    private C7187a tLx;

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.s$a */
    public interface C7187a {
        void bNo();

        void bNp();

        void cancel();
    }

    /* renamed from: com.tencent.mm.plugin.wallet_core.ui.s$b */
    public interface C7188b {
        int bNq();

        Context getContext();
    }

    public final void onResume() {
        AppMethodBeat.m2504i(47730);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2541, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14539a(2791, (C1202f) this);
        AppMethodBeat.m2505o(47730);
    }

    public final void onPause() {
        AppMethodBeat.m2504i(47731);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2541, (C1202f) this);
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14546b(2791, (C1202f) this);
        AppMethodBeat.m2505o(47731);
    }

    public final void bNo() {
        AppMethodBeat.m2504i(47732);
        C1207m c40095o = new C40095o();
        C1720g.m3537RQ();
        C1720g.m3535RO().eJo.mo14541a(c40095o, 0);
        if (this.tLx != null) {
            this.tLx.bNo();
        }
        AppMethodBeat.m2505o(47732);
    }

    public final void cancel() {
        AppMethodBeat.m2504i(47733);
        if (this.tLx != null) {
            this.tLx.cancel();
        }
        AppMethodBeat.m2505o(47733);
    }

    /* renamed from: a */
    public final void mo15494a(C7187a c7187a, boolean z) {
        AppMethodBeat.m2504i(47734);
        this.tLx = c7187a;
        C1720g.m3537RQ();
        C4990ab.m7419v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", Boolean.valueOf(((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()), Boolean.valueOf(z));
        if (((Boolean) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            c7187a.bNp();
            AppMethodBeat.m2505o(47734);
        } else if (this.cui) {
            C4990ab.m7417i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", Boolean.valueOf(this.cui));
            c7187a.bNp();
            AppMethodBeat.m2505o(47734);
        } else if (z) {
            this.cui = true;
            C1207m c43788f = new C43788f();
            C1720g.m3537RQ();
            C1720g.m3535RO().eJo.mo14541a(c43788f, 0);
            AppMethodBeat.m2505o(47734);
        } else {
            c7187a.bNp();
            AppMethodBeat.m2505o(47734);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(47735);
        if (!(c1207m instanceof C43788f)) {
            if (c1207m instanceof C40095o) {
                if (i == 0 && i2 == 0) {
                    C1720g.m3537RQ();
                    C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.TRUE);
                    C4990ab.m7416i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
                } else {
                    AppMethodBeat.m2505o(47735);
                    return;
                }
            }
            AppMethodBeat.m2505o(47735);
        } else if (i == 0 && i2 == 0) {
            C43788f c43788f = (C43788f) c1207m;
            C4990ab.m7411d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(C22589al.aFF()), c43788f.ttP, Boolean.valueOf(c43788f.ttQ));
            if (C22589al.aFF() && c43788f.ttQ) {
                Intent intent = new Intent();
                intent.putExtra("agreement_content", c43788f.ttP);
                C25985d.m41468b(this.tLw.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.tLw.bNq());
            }
            AppMethodBeat.m2505o(47735);
        } else {
            AppMethodBeat.m2505o(47735);
        }
    }
}
