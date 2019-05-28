package com.tencent.p177mm.plugin.card.p352b;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p183ai.C1202f;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p230g.p231a.C42046qj;
import com.tencent.p177mm.p230g.p231a.C42046qj.C42045b;
import com.tencent.p177mm.plugin.card.model.C33772o;
import com.tencent.p177mm.plugin.card.model.C42852am;
import com.tencent.p177mm.plugin.card.model.CardInfo;
import com.tencent.p177mm.plugin.card.p931d.C27575f;
import com.tencent.p177mm.sdk.p600b.C4884c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.card.b.a */
public final class C20119a extends C4884c<C42046qj> implements C1202f {
    private C42046qj kaz;

    public C20119a() {
        AppMethodBeat.m2504i(87625);
        this.xxI = C42046qj.class.getName().hashCode();
        AppMethodBeat.m2505o(87625);
    }

    /* renamed from: a */
    private boolean m31116a(C42046qj c42046qj) {
        AppMethodBeat.m2504i(87626);
        if (!C1720g.m3531RK()) {
            C4990ab.m7412e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent account is not ready");
            AppMethodBeat.m2505o(87626);
            return false;
        } else if (c42046qj instanceof C42046qj) {
            this.kaz = c42046qj;
            String str = this.kaz.cMA.cMC;
            String str2 = this.kaz.cMA.cMD;
            int i = this.kaz.cMA.cME;
            if (TextUtils.isEmpty(str)) {
                C4990ab.m7412e("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent card_id is empty");
                bah();
                AppMethodBeat.m2505o(87626);
                return false;
            }
            C1720g.m3535RO().eJo.mo14539a(651, (C1202f) this);
            C4990ab.m7416i("MicroMsg.AccessCardEventListener", "ShakeAcceptCouponCardEvent doscene from scene ".concat(String.valueOf(i)));
            C1720g.m3535RO().eJo.mo14541a(new C33772o(str, i, "", str2, "", "", 0, 0, null), 0);
            AppMethodBeat.m2505o(87626);
            return true;
        } else {
            AppMethodBeat.m2505o(87626);
            return false;
        }
    }

    public final void onSceneEnd(int i, int i2, String str, C1207m c1207m) {
        AppMethodBeat.m2504i(87627);
        if (c1207m instanceof C33772o) {
            C42045b c42045b = new C42045b();
            C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return errcode " + i2 + " errmsg" + str);
            if (i == 0 && i2 == 0) {
                C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is success");
                C33772o c33772o = (C33772o) c1207m;
                int i3 = c33772o.kdT;
                String str2 = c33772o.kdS;
                String str3 = c33772o.kdU;
                if (i3 == 0) {
                    C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return ok ");
                    c42045b.cxT = true;
                    CardInfo cardInfo = new CardInfo();
                    C27575f.m43802a(cardInfo, str2);
                    if (TextUtils.isEmpty(cardInfo.field_card_id)) {
                        C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return card_id is empty ");
                        c42045b.cMC = "";
                    } else {
                        c42045b.cMC = cardInfo.field_card_id;
                    }
                    C42852am.bbb().putValue("key_accept_card_info", cardInfo);
                } else {
                    C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene return false, retCode " + i3 + " retMsg" + str3);
                    c42045b.cxT = false;
                }
            } else {
                C4990ab.m7416i("MicroMsg.AccessCardEventListener", "NetSceneAcceptCardItem doscene is fail");
                c42045b.cxT = false;
            }
            C1720g.m3535RO().eJo.mo14546b(651, (C1202f) this);
            this.kaz.cMB = c42045b;
            bah();
        }
        AppMethodBeat.m2505o(87627);
    }

    private void bah() {
        AppMethodBeat.m2504i(87628);
        if (this.kaz.callback != null) {
            this.kaz.callback.run();
        }
        this.kaz = null;
        AppMethodBeat.m2505o(87628);
    }
}
