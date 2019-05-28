package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42571f;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ax */
public class C29801ax extends C46419bd<C24905d> {
    public final String name() {
        return C42571f.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(final C32183a c32183a) {
        AppMethodBeat.m2504i(6383);
        C4990ab.m7416i("MicroMsg.JsApiShareTimeLine", "invoke");
        final Context context = (MMActivity) ((C24905d) c32183a.bOZ).mContext;
        if (context == null || context.isFinishing()) {
            C4990ab.m7420w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
            AppMethodBeat.m2505o(6383);
            return;
        }
        JSONObject jSONObject = c32183a.bPa.bOf;
        String optString = jSONObject.optString("link");
        if (C5046bo.isNullOrNil(optString)) {
            C4990ab.m7412e("MicroMsg.JsApiShareTimeLine", "link is null");
            c32183a.mo52824a("invalid_params", null);
            AppMethodBeat.m2505o(6383);
            return;
        }
        String optString2 = jSONObject.optString("desc");
        if (optString2 != null) {
            if (optString2.startsWith("http://")) {
                optString2.substring(7);
            } else if (optString2.startsWith("https://")) {
                optString2.substring(8);
            }
        }
        String optString3 = jSONObject.optString("appid");
        optString2 = jSONObject.optString("img_width");
        String optString4 = jSONObject.optString("img_height");
        C4990ab.m7417i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", optString, optString);
        String optString5 = jSONObject.optString("type");
        String optString6 = jSONObject.optString("title");
        String optString7 = jSONObject.optString("img_url");
        String optString8 = jSONObject.optString("src_username");
        String optString9 = jSONObject.optString("src_displayname");
        int i = -1;
        try {
            i = Integer.valueOf(optString2).intValue();
            Integer.valueOf(optString4);
        } catch (Exception e) {
        }
        Intent intent = new Intent();
        intent.putExtra("Ksnsupload_width", i);
        intent.putExtra("Ksnsupload_height", i);
        intent.putExtra("Ksnsupload_link", optString);
        intent.putExtra("Ksnsupload_title", optString6);
        intent.putExtra("Ksnsupload_imgurl", optString7);
        if (C1855t.m3913mZ(optString8)) {
            intent.putExtra("src_username", optString8);
            intent.putExtra("src_displayname", optString9);
        }
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        if (!C5046bo.isNullOrNil(optString5) && optString5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!C5046bo.isNullOrNil(optString5) && optString5.equals("video")) {
            intent.putExtra("ksnsis_video", true);
        }
        if (optString3 != null && optString3.length() > 0) {
            intent.putExtra("Ksnsupload_appid", optString3);
        }
        intent.putExtra("ShareUrlOriginal", optString);
        intent.putExtra("ShareUrlOpen", ((C24905d) c32183a.bOZ).getUrl());
        intent.putExtra("JsAppId", ((C24905d) c32183a.bOZ).uij.getAppId());
        intent.putExtra("need_result", true);
        C4990ab.m7416i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
        context.ifE = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(6382);
                if (i == (C29801ax.this.hashCode() & CdnLogic.kBizGeneric)) {
                    if (i2 == -1) {
                        c32183a.mo52824a("", null);
                    } else {
                        c32183a.mo52824a("cancel", null);
                    }
                    context.ifE = null;
                }
                AppMethodBeat.m2505o(6382);
            }
        };
        C25985d.m41453a(context, "sns", ".ui.SnsUploadUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.m2505o(6383);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
