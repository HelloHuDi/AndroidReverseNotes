package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import org.json.JSONObject;

public class ax extends bd<d> {
    public final String name() {
        return f.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(final a aVar) {
        AppMethodBeat.i(6383);
        ab.i("MicroMsg.JsApiShareTimeLine", "invoke");
        final Context context = (MMActivity) ((d) aVar.bOZ).mContext;
        if (context == null || context.isFinishing()) {
            ab.w("MicroMsg.JsApiShareTimeLine", "activity is null or finish");
            AppMethodBeat.o(6383);
            return;
        }
        JSONObject jSONObject = aVar.bPa.bOf;
        String optString = jSONObject.optString("link");
        if (bo.isNullOrNil(optString)) {
            ab.e("MicroMsg.JsApiShareTimeLine", "link is null");
            aVar.a("invalid_params", null);
            AppMethodBeat.o(6383);
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
        ab.i("MicroMsg.JsApiShareTimeLine", "doTimeline, rawUrl:[%s], shareUrl:[%s]", optString, optString);
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
        if (t.mZ(optString8)) {
            intent.putExtra("src_username", optString8);
            intent.putExtra("src_displayname", optString9);
        }
        intent.putExtra("Ksnsupload_source", 1);
        intent.putExtra("Ksnsupload_type", 1);
        if (!bo.isNullOrNil(optString5) && optString5.equals("music")) {
            intent.putExtra("ksnsis_music", true);
        }
        if (!bo.isNullOrNil(optString5) && optString5.equals("video")) {
            intent.putExtra("ksnsis_video", true);
        }
        if (optString3 != null && optString3.length() > 0) {
            intent.putExtra("Ksnsupload_appid", optString3);
        }
        intent.putExtra("ShareUrlOriginal", optString);
        intent.putExtra("ShareUrlOpen", ((d) aVar.bOZ).getUrl());
        intent.putExtra("JsAppId", ((d) aVar.bOZ).uij.getAppId());
        intent.putExtra("need_result", true);
        ab.i("MicroMsg.JsApiShareTimeLine", "doTimeline, start activity");
        context.ifE = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(6382);
                if (i == (ax.this.hashCode() & CdnLogic.kBizGeneric)) {
                    if (i2 == -1) {
                        aVar.a("", null);
                    } else {
                        aVar.a("cancel", null);
                    }
                    context.ifE = null;
                }
                AppMethodBeat.o(6382);
            }
        };
        com.tencent.mm.bp.d.a(context, "sns", ".ui.SnsUploadUI", intent, hashCode() & CdnLogic.kBizGeneric, false);
        AppMethodBeat.o(6383);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
