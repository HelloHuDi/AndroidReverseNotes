package com.tencent.mm.plugin.card.b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.a.qj.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.o;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;

public final class a extends c<qj> implements f {
    private qj kaz;

    public a() {
        AppMethodBeat.i(87625);
        this.xxI = qj.class.getName().hashCode();
        AppMethodBeat.o(87625);
    }

    private boolean a(qj qjVar) {
        AppMethodBeat.i(87626);
        if (!g.RK()) {
            ab.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            AppMethodBeat.o(87626);
            return false;
        } else if (qjVar instanceof qj) {
            this.kaz = qjVar;
            String str = this.kaz.cMA.cMC;
            String str2 = this.kaz.cMA.cMD;
            int i = this.kaz.cMA.cME;
            if (TextUtils.isEmpty(str)) {
                ab.e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                bah();
                AppMethodBeat.o(87626);
                return false;
            }
            g.RO().eJo.a(651, (f) this);
            ab.i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
            g.RO().eJo.a(new o(str, i, "", str2, "", "", 0, 0, null), 0);
            AppMethodBeat.o(87626);
            return true;
        } else {
            AppMethodBeat.o(87626);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, m mVar) {
        AppMethodBeat.i(87627);
        if (mVar instanceof o) {
            b bVar = new b();
            ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                o oVar = (o) mVar;
                int i3 = oVar.kdT;
                String str2 = oVar.kdS;
                String str3 = oVar.kdU;
                if (i3 == 0) {
                    ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    bVar.cxT = true;
                    CardInfo cardInfo = new CardInfo();
                    com.tencent.mm.plugin.card.d.f.a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        bVar.cMC = "";
                    } else {
                        bVar.cMC = cardInfo.field_card_id;
                    }
                    am.bbb().putValue("key_accept_card_info", cardInfo);
                } else {
                    ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    bVar.cxT = false;
                }
            } else {
                ab.i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                bVar.cxT = false;
            }
            g.RO().eJo.b(651, (f) this);
            this.kaz.cMB = bVar;
            bah();
        }
        AppMethodBeat.o(87627);
    }

    private void bah() {
        AppMethodBeat.i(87628);
        if (this.kaz.callback != null) {
            this.kaz.callback.run();
        }
        this.kaz = null;
        AppMethodBeat.o(87628);
    }
}
