package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.modelsns.SnsAdClick;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.storage.b;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.pluginsdk.ui.e.o.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;

public class j implements a {
    Activity activity;
    public int cvd = 0;
    private ae rhQ;

    public j(Activity activity, int i, ae aeVar) {
        this.activity = activity;
        this.cvd = i;
        this.rhQ = aeVar;
    }

    public void a(View view, Object obj) {
        AppMethodBeat.i(38198);
        Intent intent = new Intent();
        if (this.activity == null) {
            AppMethodBeat.o(38198);
            return;
        }
        String str;
        if (obj instanceof com.tencent.mm.plugin.sns.data.a) {
            com.tencent.mm.plugin.sns.data.a aVar = (com.tencent.mm.plugin.sns.data.a) obj;
            ab.d("Micro.ClickableCallBack", "onClick : " + aVar.userName + " activity: " + (this.activity == null));
            n YT = af.cnF().YT(aVar.czD);
            if (aVar.qFG) {
                com.tencent.mm.plugin.sns.storage.a aVar2;
                b cqo = YT.cqo();
                if (YT == null) {
                    aVar2 = null;
                } else if (this.cvd == 2) {
                    aVar2 = YT.cqr();
                } else {
                    aVar2 = YT.cqq();
                }
                String str2 = aVar2.hnw;
                SnsAdClick snsAdClick = new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.crd().field_snsId, 2, 0);
                i.a(snsAdClick);
                if (cqo == null || cqo.qUq != 1 || bo.isNullOrNil(cqo.qUr)) {
                    this.rhQ.cnj().a(YT, false);
                    if (aVar.userName.endsWith("@ad")) {
                        AppMethodBeat.o(38198);
                        return;
                    }
                    intent.putExtra("Contact_User", aVar.userName);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    intent.putExtra("Contact_Scene", 37);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd == 0 ? 6 : 1);
                    com.tencent.mm.plugin.sns.c.a.gkE.c(intent, this.activity);
                    AppMethodBeat.o(38198);
                    return;
                }
                String str3 = cqo.qUr;
                ab.i("Micro.ClickableCallBack", "headClickParam url " + str3 + " " + cqo.qUs);
                Intent intent2 = new Intent();
                boolean z = cqo.qUs == 0;
                intent2.putExtra("KsnsViewId", str2);
                intent2.putExtra("KRightBtn", z);
                intent2.putExtra("jsapiargs", new Bundle());
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("useJs", true);
                com.tencent.mm.plugin.sns.c.a.gkE.i(intent2, this.activity);
                AppMethodBeat.o(38198);
                return;
            }
            com.tencent.mm.modelsns.b lY;
            str = aVar.userName;
            if (this.cvd == 0) {
                lY = com.tencent.mm.modelsns.b.lY(719);
            } else {
                lY = com.tencent.mm.modelsns.b.lZ(719);
            }
            lY.tx(i.j(YT)).mb(YT.field_type).cS(YT.DI(32)).tx(YT.crc()).tx(str);
            lY.ajK();
            if (this.cvd == 0) {
                lY = com.tencent.mm.modelsns.b.lY(746);
            } else {
                lY = com.tencent.mm.modelsns.b.lZ(746);
            }
            lY.tx(str).cS(str.endsWith(r.Yz()));
            lY.b(intent, "intent_key_StatisticsOplog");
            if (this.cvd == 0) {
                this.rhQ.cnj().a(YT, false);
            }
        } else {
            str = (String) obj;
            if (str.contains("@")) {
                str = str.replace("@", "");
            }
            g.RQ();
            ad aoM = ((com.tencent.mm.plugin.messenger.foundation.a.j) g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(str);
            if (aoM != null && aoM.dsf()) {
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd);
                com.tencent.mm.plugin.sns.c.a.gkE.c(intent, this.activity);
                AppMethodBeat.o(38198);
                return;
            } else if (this.cvd == 0) {
                n nVar = new n();
                nVar.field_userName = str;
                this.rhQ.cnj().a(nVar, false);
            }
        }
        intent.putExtra("Contact_User", str);
        intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd);
        com.tencent.mm.plugin.sns.c.a.gkE.c(intent, this.activity);
        AppMethodBeat.o(38198);
    }
}
