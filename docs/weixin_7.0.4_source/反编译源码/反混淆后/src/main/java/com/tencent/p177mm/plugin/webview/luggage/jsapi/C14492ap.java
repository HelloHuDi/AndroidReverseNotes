package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.p177mm.p190at.C17937c;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p230g.p231a.C18372qb;
import com.tencent.p177mm.p230g.p231a.C26217py;
import com.tencent.p177mm.p230g.p231a.C45316cl;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p612ui.widget.snackbar.C24110a.C24112c;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.webview.luggage.C24905d;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.plugin.webview.model.C43915c;
import com.tencent.p177mm.plugin.webview.model.C43915c.C43916a;
import com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi.C40341k;
import com.tencent.p177mm.pluginsdk.model.app.C40439f;
import com.tencent.p177mm.pluginsdk.model.app.C46494g;
import com.tencent.p177mm.sdk.p600b.C4879a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.ap */
public class C14492ap extends C46419bd<C24905d> {
    private static int cSP;

    /* renamed from: IF */
    public static void m22691IF(int i) {
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

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
    }

    /* renamed from: a */
    public final void mo9617a(final Context context, String str, final C22841a c22841a) {
        JSONObject jSONObject;
        AppMethodBeat.m2504i(6369);
        C4990ab.m7410d("MicroMsg.JsApiSendAppMessage", "invokeInMM");
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception e) {
            jSONObject = null;
        }
        if (jSONObject == null) {
            c22841a.mo26722d("data is null", null);
            AppMethodBeat.m2505o(6369);
            return;
        }
        switch (jSONObject.optInt("sendAppMessageScene", 0)) {
            case 1:
                C4990ab.m7416i("MicroMsg.JsApiSendAppMessage", "favoriteUrl");
                C45316cl c45316cl = new C45316cl();
                C43916a c43916a = new C43916a();
                c43916a.url = jSONObject.optString("shareUrl");
                c43916a.thumbUrl = jSONObject.optString("img_url");
                c43916a.title = jSONObject.optString("title");
                c43916a.desc = jSONObject.optString("desc");
                c43916a.csB = jSONObject.optString("appid");
                if (context != null && (context instanceof MMActivity)) {
                    c45316cl.cvA.activity = (Activity) context;
                    c45316cl.cvA.cvH = 36;
                }
                c45316cl.cvA.cvJ = new C24112c() {
                    public final void onShow() {
                    }

                    public final void onHide() {
                        AppMethodBeat.m2504i(6367);
                        C4990ab.m7410d("MicroMsg.JsApiSendAppMessage", "onHide");
                        c22841a.mo26722d(null, null);
                        AppMethodBeat.m2505o(6367);
                    }

                    public final void cLd() {
                    }
                };
                C43915c.m78771a(c45316cl, c43916a);
                C4879a.xxA.mo10055m(c45316cl);
                if (c45316cl.cvB.ret != 0) {
                    c22841a.mo26722d("fail", null);
                }
                AppMethodBeat.m2505o(6369);
                return;
            default:
                C40341k.agC(jSONObject.optString("img_url"));
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
                C25985d.m41460a((MMActivity) context, ".ui.transmit.SelectConversationUI", intent, 1, new C5186a() {
                    /* renamed from: c */
                    public final void mo6069c(int i, int i2, Intent intent) {
                        AppMethodBeat.m2504i(6368);
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
                                        C4990ab.m7412e("MicroMsg.JsApiSendAppMessage", "mmOnActivityResult fail, toUser is null");
                                        c22841a.mo26722d("fail", null);
                                        AppMethodBeat.m2505o(6368);
                                        return;
                                    } else if (C5046bo.isNullOrNil(str)) {
                                        C4990ab.m7412e("MicroMsg.JsApiSendAppMessage", "toUser is null");
                                        AppMethodBeat.m2505o(6368);
                                        return;
                                    } else {
                                        C32291o.ahk();
                                        Bitmap kR = C17937c.m28186kR(jSONObject.optString("img_url"));
                                        WXMediaMessage aN = C14492ap.m22692aN(jSONObject);
                                        if (!(kR == null || kR.isRecycled())) {
                                            C4990ab.m7416i("MicroMsg.JsApiSendAppMessage", "thumb image is not null");
                                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                            kR.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                            aN.thumbData = byteArrayOutputStream.toByteArray();
                                        }
                                        C40439f bT = C46494g.m87739bT(optString, true);
                                        C26217py c26217py = new C26217py();
                                        c26217py.cMe.cEl = aN;
                                        c26217py.cMe.appId = optString;
                                        c26217py.cMe.appName = bT == null ? "" : bT.field_appName;
                                        c26217py.cMe.toUser = str;
                                        c26217py.cMe.cMf = 2;
                                        if (C5046bo.isNullOrNil(jSONObject.optString("src_username"))) {
                                            c26217py.cMe.cMi = null;
                                        } else {
                                            c26217py.cMe.cMg = jSONObject.optString("src_username");
                                            c26217py.cMe.cMh = jSONObject.optString("src_displayname");
                                        }
                                        c26217py.cMe.cMj = jSONObject.optString("shareUrl");
                                        c26217py.cMe.cMk = jSONObject.optString("currentUrl");
                                        c26217py.cMe.cMl = jSONObject.optString("preVerifyAppId");
                                        C4879a.xxA.mo10055m(c26217py);
                                        String stringExtra = intent.getStringExtra("custom_send_text");
                                        if (!C5046bo.isNullOrNil(stringExtra)) {
                                            C18372qb c18372qb = new C18372qb();
                                            c18372qb.cMq.cMr = str;
                                            c18372qb.cMq.content = stringExtra;
                                            c18372qb.cMq.type = C1855t.m3925nK(str);
                                            c18372qb.cMq.flags = 0;
                                            C4879a.xxA.mo10055m(c18372qb);
                                        }
                                        C30379h.m48465bQ(context, context.getResources().getString(C25738R.string.f9229to));
                                        c22841a.mo26722d(null, null);
                                        AppMethodBeat.m2505o(6368);
                                        return;
                                    }
                                case 0:
                                case 1:
                                    c22841a.mo26722d("cancel", null);
                                    AppMethodBeat.m2505o(6368);
                                    return;
                                default:
                                    c22841a.mo26722d("fail", null);
                                    break;
                            }
                        }
                        AppMethodBeat.m2505o(6368);
                    }
                });
                AppMethodBeat.m2505o(6369);
                return;
        }
    }

    /* renamed from: aN */
    static /* synthetic */ WXMediaMessage m22692aN(JSONObject jSONObject) {
        AppMethodBeat.m2504i(6370);
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = jSONObject.optString("link");
        wXWebpageObject.extInfo = jSONObject.optString("review_data");
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXWebpageObject;
        wXMediaMessage.title = jSONObject.optString("title");
        wXMediaMessage.description = jSONObject.optString("desc");
        AppMethodBeat.m2505o(6370);
        return wXMediaMessage;
    }
}
