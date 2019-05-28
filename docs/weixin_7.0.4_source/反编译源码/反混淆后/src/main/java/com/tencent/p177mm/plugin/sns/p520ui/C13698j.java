package com.tencent.p177mm.plugin.sns.p520ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1853r;
import com.tencent.p177mm.modelsns.C37952b;
import com.tencent.p177mm.modelsns.SnsAdClick;
import com.tencent.p177mm.plugin.messenger.foundation.p454a.C6982j;
import com.tencent.p177mm.plugin.sns.data.C13357a;
import com.tencent.p177mm.plugin.sns.data.C29036i;
import com.tencent.p177mm.plugin.sns.model.C13373af;
import com.tencent.p177mm.plugin.sns.model.C29045ae;
import com.tencent.p177mm.plugin.sns.p1363c.C24826a;
import com.tencent.p177mm.plugin.sns.storage.C21980a;
import com.tencent.p177mm.plugin.sns.storage.C21984b;
import com.tencent.p177mm.plugin.sns.storage.C46236n;
import com.tencent.p177mm.pluginsdk.p597ui.p598e.C24944o.C24945a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;

/* renamed from: com.tencent.mm.plugin.sns.ui.j */
public class C13698j implements C24945a {
    Activity activity;
    public int cvd = 0;
    private C29045ae rhQ;

    public C13698j(Activity activity, int i, C29045ae c29045ae) {
        this.activity = activity;
        this.cvd = i;
        this.rhQ = c29045ae;
    }

    /* renamed from: a */
    public void mo25466a(View view, Object obj) {
        AppMethodBeat.m2504i(38198);
        Intent intent = new Intent();
        if (this.activity == null) {
            AppMethodBeat.m2505o(38198);
            return;
        }
        String str;
        if (obj instanceof C13357a) {
            C13357a c13357a = (C13357a) obj;
            C4990ab.m7410d("Micro.ClickableCallBack", "onClick : " + c13357a.userName + " activity: " + (this.activity == null));
            C46236n YT = C13373af.cnF().mo62918YT(c13357a.czD);
            if (c13357a.qFG) {
                C21980a c21980a;
                C21984b cqo = YT.cqo();
                if (YT == null) {
                    c21980a = null;
                } else if (this.cvd == 2) {
                    c21980a = YT.cqr();
                } else {
                    c21980a = YT.cqq();
                }
                String str2 = c21980a.hnw;
                SnsAdClick snsAdClick = new SnsAdClick(this.cvd, this.cvd == 0 ? 1 : 2, YT.crd().field_snsId, 2, 0);
                C29036i.m46098a(snsAdClick);
                if (cqo == null || cqo.qUq != 1 || C5046bo.isNullOrNil(cqo.qUr)) {
                    this.rhQ.cnj().mo69103a(YT, false);
                    if (c13357a.userName.endsWith("@ad")) {
                        AppMethodBeat.m2505o(38198);
                        return;
                    }
                    intent.putExtra("Contact_User", c13357a.userName);
                    intent.putExtra("KSnsAdTag", snsAdClick);
                    intent.putExtra("Contact_Scene", 37);
                    intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd == 0 ? 6 : 1);
                    C24826a.gkE.mo38912c(intent, this.activity);
                    AppMethodBeat.m2505o(38198);
                    return;
                }
                String str3 = cqo.qUr;
                C4990ab.m7416i("Micro.ClickableCallBack", "headClickParam url " + str3 + " " + cqo.qUs);
                Intent intent2 = new Intent();
                boolean z = cqo.qUs == 0;
                intent2.putExtra("KsnsViewId", str2);
                intent2.putExtra("KRightBtn", z);
                intent2.putExtra("jsapiargs", new Bundle());
                intent2.putExtra("rawUrl", str3);
                intent2.putExtra("useJs", true);
                C24826a.gkE.mo38924i(intent2, this.activity);
                AppMethodBeat.m2505o(38198);
                return;
            }
            C37952b lY;
            str = c13357a.userName;
            if (this.cvd == 0) {
                lY = C37952b.m64170lY(719);
            } else {
                lY = C37952b.m64171lZ(719);
            }
            lY.mo60722tx(C29036i.m46115j(YT)).mo60720mb(YT.field_type).mo60718cS(YT.mo74253DI(32)).mo60722tx(YT.crc()).mo60722tx(str);
            lY.ajK();
            if (this.cvd == 0) {
                lY = C37952b.m64170lY(746);
            } else {
                lY = C37952b.m64171lZ(746);
            }
            lY.mo60722tx(str).mo60718cS(str.endsWith(C1853r.m3846Yz()));
            lY.mo60717b(intent, "intent_key_StatisticsOplog");
            if (this.cvd == 0) {
                this.rhQ.cnj().mo69103a(YT, false);
            }
        } else {
            str = (String) obj;
            if (str.contains("@")) {
                str = str.replace("@", "");
            }
            C1720g.m3537RQ();
            C7616ad aoM = ((C6982j) C1720g.m3528K(C6982j.class)).mo15369XM().aoM(str);
            if (aoM != null && aoM.dsf()) {
                intent.putExtra("Contact_User", str);
                intent.putExtra("Contact_Scene", 37);
                intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd);
                C24826a.gkE.mo38912c(intent, this.activity);
                AppMethodBeat.m2505o(38198);
                return;
            } else if (this.cvd == 0) {
                C46236n c46236n = new C46236n();
                c46236n.field_userName = str;
                this.rhQ.cnj().mo69103a(c46236n, false);
            }
        }
        intent.putExtra("Contact_User", str);
        intent.putExtra("CONTACT_INFO_UI_SOURCE", this.cvd);
        C24826a.gkE.mo38912c(intent, this.activity);
        AppMethodBeat.m2505o(38198);
    }
}
