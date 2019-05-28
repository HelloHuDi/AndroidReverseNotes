package com.tencent.p177mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.at */
public final class C19292at extends C10296a {
    public static final int CTRL_INDEX = 62;
    public static final String NAME = "openAddress";

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, final int i) {
        Activity ad;
        Context context;
        AppMethodBeat.m2504i(130513);
        Intent intent = new Intent();
        intent.putExtra("req_app_id", c2241c.getAppId());
        intent.putExtra("launch_from_appbrand", true);
        if (c2241c instanceof C38492q) {
            ad = ((C38492q) c2241c).mo61197ad(Activity.class);
        } else {
            ad = c2241c.getContext();
        }
        if (ad == null || !(ad instanceof MMActivity)) {
            context = null;
        } else {
            MMActivity context2 = (MMActivity) ad;
        }
        if (context2 == null) {
            c2241c.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(130513);
            return;
        }
        context2.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(130512);
                if (i != (C19292at.this.hashCode() & CdnLogic.kBizGeneric)) {
                    AppMethodBeat.m2505o(130512);
                    return;
                }
                if (i2 == -1 && intent != null) {
                    String bc = C5046bo.m7532bc(intent.getStringExtra("nationalCode"), "");
                    String bc2 = C5046bo.m7532bc(intent.getStringExtra("userName"), "");
                    String bc3 = C5046bo.m7532bc(intent.getStringExtra("telNumber"), "");
                    String bc4 = C5046bo.m7532bc(intent.getStringExtra("addressPostalCode"), "");
                    String bc5 = C5046bo.m7532bc(intent.getStringExtra("proviceFirstStageName"), "");
                    String bc6 = C5046bo.m7532bc(intent.getStringExtra("addressCitySecondStageName"), "");
                    String bc7 = C5046bo.m7532bc(intent.getStringExtra("addressCountiesThirdStageName"), "");
                    String bc8 = C5046bo.m7532bc(intent.getStringExtra("addressDetailInfo"), "");
                    C4990ab.m7416i("MicroMsg.JsApiOpenAddress", "first =  " + bc5 + " ; detail =" + bc8 + "; second = " + bc6 + " ; tel = " + bc3 + "; third = " + bc7);
                    if (!C5046bo.isNullOrNil(bc2)) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("nationalCode", bc);
                        hashMap.put("userName", bc2);
                        hashMap.put("telNumber", bc3);
                        hashMap.put("addressPostalCode", bc4);
                        hashMap.put("proviceFirstStageName", bc5);
                        hashMap.put("addressCitySecondStageName", bc6);
                        hashMap.put("addressCountiesThirdStageName", bc7);
                        hashMap.put("addressDetailInfo", bc8);
                        c2241c.mo6107M(i, C19292at.this.mo73394j("ok", hashMap));
                        AppMethodBeat.m2505o(130512);
                        return;
                    }
                }
                if (i2 == 0) {
                    c2241c.mo6107M(i, C19292at.this.mo73394j("cancel", null));
                    AppMethodBeat.m2505o(130512);
                    return;
                }
                c2241c.mo6107M(i, C19292at.this.mo73394j("fail", null));
                AppMethodBeat.m2505o(130512);
            }
        };
        C25985d.m41453a(context2, "address", ".ui.WalletSelectAddrUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(130513);
    }
}
