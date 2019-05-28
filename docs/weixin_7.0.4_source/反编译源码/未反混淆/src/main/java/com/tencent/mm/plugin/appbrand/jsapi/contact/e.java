package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 550;
    public static final String NAME = "privateEnterContact";
    String hID;
    String hIE;
    String hIF;
    String hIG;
    String hIH;
    private String sessionFrom;

    interface a {
        void a(boolean z, String str, Intent intent);
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131022);
        if (cVar instanceof q) {
            q qVar = (q) cVar;
            u currentPageView = qVar.getCurrentPageView();
            if (currentPageView == null) {
                ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
                qVar.M(i, j("fail:current page do not exist", null));
                AppMethodBeat.o(131022);
                return;
            }
            a(currentPageView, qVar, jSONObject, i);
            AppMethodBeat.o(131022);
        } else if (cVar instanceof u) {
            a((u) cVar, cVar, jSONObject, i);
            AppMethodBeat.o(131022);
        } else {
            ab.w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
            AppMethodBeat.o(131022);
        }
    }

    private void a(u uVar, final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131023);
        a(uVar, jSONObject, new a() {
            public final void a(boolean z, String str, Intent intent) {
                AppMethodBeat.i(131019);
                ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", Boolean.valueOf(z));
                if (z) {
                    HashMap hashMap = new HashMap();
                    Object obj = "";
                    Object hashMap2 = new HashMap();
                    if (intent != null) {
                        String bc = bo.bc(intent.getStringExtra("keyOutPagePath"), "");
                        obj = h.bO(bc);
                        hashMap2 = h.bP(bc);
                    }
                    hashMap.put("path", obj);
                    hashMap.put(SearchIntents.EXTRA_QUERY, hashMap2);
                    ab.i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", obj, hashMap2.toString());
                    cVar.M(i, e.this.j("ok", hashMap));
                    AppMethodBeat.o(131019);
                    return;
                }
                cVar.M(i, e.this.j(str, null));
                AppMethodBeat.o(131019);
            }
        });
        AppMethodBeat.o(131023);
    }

    private void a(u uVar, JSONObject jSONObject, a aVar) {
        AppMethodBeat.i(131024);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
            aVar.a(false, "fail:invalid data", null);
            AppMethodBeat.o(131024);
        } else if (((AppBrandSysConfigWC) uVar.getRuntime().ye()) == null) {
            ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
            aVar.a(false, "fail:config is null", null);
            AppMethodBeat.o(131024);
        } else {
            this.sessionFrom = jSONObject.optString("sessionFrom");
            if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
            }
            this.hID = jSONObject.optString("appId");
            if (!bo.isNullOrNil(this.hID)) {
                this.hIE = jSONObject.optString("userName");
                this.hIF = jSONObject.optString("title");
                this.hIG = jSONObject.optString("subTitle");
                this.hIH = jSONObject.optString("headimgUrl");
                a(uVar, aVar);
            }
            AppMethodBeat.o(131024);
        }
    }

    private void a(final u uVar, final a aVar) {
        AppMethodBeat.i(131025);
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        jsApiChattingTask.username = this.hIE;
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(131021);
                ab.i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
                aVar.appId = e.this.hID;
                aVar.username = e.this.hIE;
                aVar.from = 5;
                intent.putExtra("app_brand_chatting_expose_params", aVar.ayP());
                intent.putExtra("keyPrivateAppId", e.this.hID);
                intent.putExtra("keyPrivateUserName", e.this.hIE);
                intent.putExtra("keyPrivateTitle", e.this.hIF);
                intent.putExtra("keyPrivateSubTitle", e.this.hIG);
                intent.putExtra("keyPrivateHeadImage", e.this.hIH);
                Context context = (MMActivity) uVar.mContext;
                if (context == null) {
                    if (aVar != null) {
                        aVar.a(false, "fail:internal error invalid android context", null);
                    }
                    ab.e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
                    AppMethodBeat.o(131021);
                    return;
                }
                context.ifE = new com.tencent.mm.ui.MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(131020);
                        if (i == 1) {
                            if (aVar != null) {
                                aVar.a(true, "ok", intent);
                            }
                            jsApiChattingTask.aBW();
                        }
                        AppMethodBeat.o(131020);
                    }
                };
                d.b(context, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                AppMethodBeat.o(131021);
            }
        };
        jsApiChattingTask.aBV();
        AppBrandMainProcessService.a(jsApiChattingTask);
        AppMethodBeat.o(131025);
    }
}
