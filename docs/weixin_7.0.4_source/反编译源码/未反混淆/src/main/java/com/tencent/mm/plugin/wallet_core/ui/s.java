package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.bp.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.c.o;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.sdk.platformtools.ab;

public final class s implements f {
    public boolean cui = false;
    public b tLw;
    private a tLx;

    public interface a {
        void bNo();

        void bNp();

        void cancel();
    }

    public interface b {
        int bNq();

        Context getContext();
    }

    public final void onResume() {
        AppMethodBeat.i(47730);
        g.RQ();
        g.RO().eJo.a(2541, (f) this);
        g.RQ();
        g.RO().eJo.a(2791, (f) this);
        AppMethodBeat.o(47730);
    }

    public final void onPause() {
        AppMethodBeat.i(47731);
        g.RQ();
        g.RO().eJo.b(2541, (f) this);
        g.RQ();
        g.RO().eJo.b(2791, (f) this);
        AppMethodBeat.o(47731);
    }

    public final void bNo() {
        AppMethodBeat.i(47732);
        m oVar = new o();
        g.RQ();
        g.RO().eJo.a(oVar, 0);
        if (this.tLx != null) {
            this.tLx.bNo();
        }
        AppMethodBeat.o(47732);
    }

    public final void cancel() {
        AppMethodBeat.i(47733);
        if (this.tLx != null) {
            this.tLx.cancel();
        }
        AppMethodBeat.o(47733);
    }

    public final void a(a aVar, boolean z) {
        AppMethodBeat.i(47734);
        this.tLx = aVar;
        g.RQ();
        ab.v("MicroMsg.WxPayAgreementsHelper", "showProtoCol agree %s isServerControlShow %s", Boolean.valueOf(((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()), Boolean.valueOf(z));
        if (((Boolean) g.RP().Ry().get(com.tencent.mm.storage.ac.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
            aVar.bNp();
            AppMethodBeat.o(47734);
        } else if (this.cui) {
            ab.i("MicroMsg.WxPayAgreementsHelper", "showProtoCol isShow %s", Boolean.valueOf(this.cui));
            aVar.bNp();
            AppMethodBeat.o(47734);
        } else if (z) {
            this.cui = true;
            m fVar = new com.tencent.mm.plugin.wallet_core.c.f();
            g.RQ();
            g.RO().eJo.a(fVar, 0);
            AppMethodBeat.o(47734);
        } else {
            aVar.bNp();
            AppMethodBeat.o(47734);
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(47735);
        if (!(mVar instanceof com.tencent.mm.plugin.wallet_core.c.f)) {
            if (mVar instanceof o) {
                if (i == 0 && i2 == 0) {
                    g.RQ();
                    g.RP().Ry().set(com.tencent.mm.storage.ac.a.USERINFO_WALLET_AGREE_PAY_BOOLEAN_SYNC, Boolean.TRUE);
                    ab.i("MicroMsg.WxPayAgreementsHelper", "agree Ok!");
                } else {
                    AppMethodBeat.o(47735);
                    return;
                }
            }
            AppMethodBeat.o(47735);
        } else if (i == 0 && i2 == 0) {
            com.tencent.mm.plugin.wallet_core.c.f fVar = (com.tencent.mm.plugin.wallet_core.c.f) mVar;
            ab.d("MicroMsg.WxPayAgreementsHelper", "errType =  %s errCode %s isShow %s content: %s need_agree_duty %s", Integer.valueOf(i), Integer.valueOf(i2), Boolean.valueOf(al.aFF()), fVar.ttP, Boolean.valueOf(fVar.ttQ));
            if (al.aFF() && fVar.ttQ) {
                Intent intent = new Intent();
                intent.putExtra("agreement_content", fVar.ttP);
                d.b(this.tLw.getContext(), "wallet_core", ".ui.ShowWxPayAgreementsUI", intent, this.tLw.bNq());
            }
            AppMethodBeat.o(47735);
        } else {
            AppMethodBeat.o(47735);
        }
    }
}
