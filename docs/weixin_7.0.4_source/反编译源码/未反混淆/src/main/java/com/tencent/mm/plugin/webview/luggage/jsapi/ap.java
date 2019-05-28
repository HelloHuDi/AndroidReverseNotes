package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.g.a.cl;
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.a.qb;
import com.tencent.mm.model.t;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.plugin.webview.model.c;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.k;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

public class ap extends bd<d> {
    private static int cSP;

    public static void IF(int i) {
        cSP = i;
    }

    public static int cXn() {
        return cSP;
    }

    public static void cXo() {
        cSP = 0;
    }

    public final String name() {
        return "sendAppMessage";
    }

    public final int biG() {
        return 2;
    }

    public final void b(a aVar) {
    }

    public final void a(final Context context, String str, final bc.a aVar) {
        JSONObject jSONObject;
        AppMethodBeat.i(6369);
        ab.d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            aVar.d("data is null", null);
            AppMethodBeat.o(6369);
            return;
        }
        switch (jSONObject.optInt("sendAppMessageScene", 0)) {
            case 1:
                ab.i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
                cl clVar = new cl();
                c.a aVar2 = new c.a();
                aVar2.url = jSONObject.optString("shareUrl");
                aVar2.thumbUrl = jSONObject.optString("img_url");
                aVar2.title = jSONObject.optString("title");
                aVar2.desc = jSONObject.optString("desc");
                aVar2.csB = jSONObject.optString("appid");
                if (context != null && (context instanceof MMActivity)) {
                    clVar.cvA.activity = (Activity) context;
                    clVar.cvA.cvH = 36;
                }
                clVar.cvA.cvJ = new com.tencent.mm.ui.widget.snackbar.a.c() {
                    public final void onShow() {
                    }

                    public final void onHide() {
                        AppMethodBeat.i(6367);
                        ab.d("MicroMsg.JsApiSendAppMessage", "onHide");
                        aVar.d(null, null);
                        AppMethodBeat.o(6367);
                    }

                    public final void cLd() {
                    }
                };
                c.a(clVar, aVar2);
                com.tencent.mm.sdk.b.a.xxA.m(clVar);
                if (clVar.cvB.ret != 0) {
                    aVar.d("fail", null);
                }
                AppMethodBeat.o(6369);
                return;
            default:
                k.agC(jSONObject.optString("img_url"));
                HashMap hashMap = new HashMap();
                hashMap.put("img_url", jSONObject.optString("img_url"));
                hashMap.put("desc", jSONObject.optString("desc"));
                hashMap.put("title", jSONObject.optString("title"));
                hashMap.put("url", jSONObject.optString("shareUrl"));
                Intent intent = new Intent();
                intent.putExtra("Select_Conv_Type", 3);
                intent.putExtra("scene_from", 2);
                intent.putExtra("mutil_select_is_ret", true);
                intent.putExtra("webview_params", hashMap);
                intent.putExtra("Retr_Msg_Type", 2);
                com.tencent.mm.bp.d.a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, new MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(6368);
                        if (i == 1) {
                            String optString = jSONObject.optString("appid");
                            switch (i2) {
                                case -1:
                                    String str;
                                    if (intent == null) {
                                        str = null;
                                    } else {
                                        str = intent.getStringExtra("Select_Conv_User");
                                    }
                                    if (str == null || str.length() == 0) {
                                        ab.e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                                        aVar.d("fail", null);
                                        AppMethodBeat.o(6368);
                                        return;
                                    } else if (bo.isNullOrNil(str)) {
                                        ab.e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                                        AppMethodBeat.o(6368);
                                        return;
                                    } else {
                                        o.ahk();
                                        Bitmap kR = com.tencent.mm.at.c.kR(jSONObject.optString("img_url"));
                                        WXMediaMessage aN = ap.aN(jSONObject);
                                        if (!(kR == null || kR.isRecycled())) {
                                            ab.i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            aN.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        f bT = g.bT(optString, true);
                                        py pyVar = new py();
                                        pyVar.cMe.cEl = aN;
                                        pyVar.cMe.appId = optString;
                                        pyVar.cMe.appName = bT == null ? "" : bT.field_appName;
                                        pyVar.cMe.toUser = str;
                                        pyVar.cMe.cMf = 2;
                                        if (bo.isNullOrNil(jSONObject.optString("src_username"))) {
                                            pyVar.cMe.cMi = null;
                                        } else {
                                            pyVar.cMe.cMg = jSONObject.optString("src_username");
                                            pyVar.cMe.cMh = jSONObject.optString("src_displayname");
                                        }
                                        pyVar.cMe.cMj = jSONObject.optString("shareUrl");
                                        pyVar.cMe.cMk = jSONObject.optString("currentUrl");
                                        pyVar.cMe.cMl = jSONObject.optString("preVerifyAppId");
                                        com.tencent.mm.sdk.b.a.xxA.m(pyVar);
                                        String stringExtra = intent.getStringExtra("custom_send_text");
                                        if (!bo.isNullOrNil(stringExtra)) {
                                            qb qbVar = new qb();
                                            qbVar.cMq.cMr = str;
                                            qbVar.cMq.content = stringExtra;
                                            qbVar.cMq.type = t.nK(str);
                                            qbVar.cMq.flags = 0;
                                            com.tencent.mm.sdk.b.a.xxA.m(qbVar);
                                        }
                                        h.bQ(context, context.getResources().getString(R.string.to));
                                        aVar.d(null, null);
                                        AppMethodBeat.o(6368);
                                        return;
                                    }
                                case 0:
                                case 1:
                                    aVar.d("cancel", null);
                                    AppMethodBeat.o(6368);
                                    return;
                                default:
                                    aVar.d("fail", null);
                                    break;
                            }
                        }
                        AppMethodBeat.o(6368);
                    }
                });
                AppMethodBeat.o(6369);
                return;
        }
    }

    static /* synthetic */ WXMediaMessage aN(JSONObject jSONObject) {
        AppMethodBeat.i(6370);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = jSONObject.optString("link");
        wXWebpageObject.extInfo = jSONObject.optString("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.o(6370);
        return wXMediaMessage;
    }
}
