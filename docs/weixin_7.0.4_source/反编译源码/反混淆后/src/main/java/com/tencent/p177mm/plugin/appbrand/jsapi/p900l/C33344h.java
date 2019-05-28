package com.tencent.p177mm.plugin.appbrand.jsapi.p900l;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.game.page.C33204f;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C10443b.C10444a;
import com.tencent.p177mm.plugin.appbrand.jsapi.p900l.C42531a.C194094;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.pluginsdk.wallet.C40493g;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.l.h */
public final class C33344h extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 218;
    public static final String NAME = "sendBizRedPacket";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131422);
        final C19722s c19722s = (C19722s) c2241c;
        Context context = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (context == null) {
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131422);
            return;
        }
        try {
            jSONObject.put("appId", c19722s.getAppId());
            C27242w aun = c19722s.aun();
            if (aun != null && (aun instanceof C33204f)) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("needPortraitSnapshot", true);
                aun.mo53736a(2, bundle, new Object[0]);
            }
            C42531a c42531a = C42531a.hTJ;
            C194121 c194121 = new C10444a() {
                /* renamed from: a */
                public final void mo21960a(int i, String str, Map<String, Object> map) {
                    AppMethodBeat.m2504i(131421);
                    switch (i) {
                        case 1:
                            c19722s.mo6107M(i, C33344h.this.mo73394j("ok", null));
                            AppMethodBeat.m2505o(131421);
                            return;
                        case 2:
                            if (C5046bo.isNullOrNil(str)) {
                                c19722s.mo6107M(i, C33344h.this.mo73394j("fail", null));
                                AppMethodBeat.m2505o(131421);
                                return;
                            }
                            c19722s.mo6107M(i, C33344h.this.mo73394j(String.format("fail %s", new Object[]{str}), null));
                            AppMethodBeat.m2505o(131421);
                            return;
                        default:
                            c19722s.mo6107M(i, C33344h.this.mo73394j("cancel", null));
                            AppMethodBeat.m2505o(131421);
                            return;
                    }
                }
            };
            C40493g c40493g = new C40493g(jSONObject);
            c40493g.cvS = 16;
            C194094 c194094 = new C194094(c194121);
            Intent intent = new Intent();
            intent.putExtra("key_way", 3);
            intent.putExtra("appId", c40493g.appId);
            intent.putExtra("timeStamp", c40493g.timeStamp);
            intent.putExtra("nonceStr", c40493g.nonceStr);
            intent.putExtra("packageExt", c40493g.packageExt);
            intent.putExtra("signtype", c40493g.signType);
            intent.putExtra("paySignature", c40493g.cId);
            intent.putExtra("key_static_from_scene", 100004);
            intent.putExtra("url", c40493g.url);
            context.ifE = c194094;
            C25985d.m41453a(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", intent, c42531a.hashCode() & CdnLogic.kBizGeneric, false);
            AppMethodBeat.m2505o(131422);
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.JsApiSendBizRedPacket", e.getMessage());
            c19722s.mo6107M(i, mo73394j("fail", null));
            AppMethodBeat.m2505o(131422);
        }
    }
}
