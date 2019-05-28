package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.e */
public final class C16657e extends C10296a {
    public static final int CTRL_INDEX = 550;
    public static final String NAME = "privateEnterContact";
    String hID;
    String hIE;
    String hIF;
    String hIG;
    String hIH;
    private String sessionFrom;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.e$a */
    interface C16658a {
        /* renamed from: a */
        void mo30635a(boolean z, String str, Intent intent);
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131022);
        if (c2241c instanceof C38492q) {
            C38492q c38492q = (C38492q) c2241c;
            C44709u currentPageView = c38492q.getCurrentPageView();
            if (currentPageView == null) {
                C4990ab.m7416i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, pageView is null");
                c38492q.mo6107M(i, mo73394j("fail:current page do not exist", null));
                AppMethodBeat.m2505o(131022);
                return;
            }
            m25657a(currentPageView, c38492q, jSONObject, i);
            AppMethodBeat.m2505o(131022);
        } else if (c2241c instanceof C44709u) {
            m25657a((C44709u) c2241c, c2241c, jSONObject, i);
            AppMethodBeat.m2505o(131022);
        } else {
            C4990ab.m7420w("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact not support");
            AppMethodBeat.m2505o(131022);
        }
    }

    /* renamed from: a */
    private void m25657a(C44709u c44709u, final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131023);
        m25659a(c44709u, jSONObject, new C16658a() {
            /* renamed from: a */
            public final void mo30635a(boolean z, String str, Intent intent) {
                AppMethodBeat.m2504i(131019);
                C4990ab.m7417i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact page enterChatting isSuccess:%b", Boolean.valueOf(z));
                if (z) {
                    HashMap hashMap = new HashMap();
                    Object obj = "";
                    Object hashMap2 = new HashMap();
                    if (intent != null) {
                        String bc = C5046bo.m7532bc(intent.getStringExtra("keyOutPagePath"), "");
                        obj = C8874h.m15847bO(bc);
                        hashMap2 = C8874h.m15848bP(bc);
                    }
                    hashMap.put("path", obj);
                    hashMap.put(SearchIntents.EXTRA_QUERY, hashMap2);
                    C4990ab.m7417i("MicroMsg.JsApiPrivateEnterContact", "onBackFromContact path:%s, query:%s", obj, hashMap2.toString());
                    c2241c.mo6107M(i, C16657e.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(131019);
                    return;
                }
                c2241c.mo6107M(i, C16657e.this.mo73394j(str, null));
                AppMethodBeat.m2505o(131019);
            }
        });
        AppMethodBeat.m2505o(131023);
    }

    /* renamed from: a */
    private void m25659a(C44709u c44709u, JSONObject jSONObject, C16658a c16658a) {
        AppMethodBeat.m2504i(131024);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, data is null");
            c16658a.mo30635a(false, "fail:invalid data", null);
            AppMethodBeat.m2505o(131024);
        } else if (((AppBrandSysConfigWC) c44709u.getRuntime().mo15034ye()) == null) {
            C4990ab.m7412e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact enterChatting fail, config is null");
            c16658a.mo30635a(false, "fail:config is null", null);
            AppMethodBeat.m2505o(131024);
        } else {
            this.sessionFrom = jSONObject.optString("sessionFrom");
            if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
                this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                C4990ab.m7416i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact sessionFrom length is large than 1024!");
            }
            this.hID = jSONObject.optString("appId");
            if (!C5046bo.isNullOrNil(this.hID)) {
                this.hIE = jSONObject.optString("userName");
                this.hIF = jSONObject.optString("title");
                this.hIG = jSONObject.optString("subTitle");
                this.hIH = jSONObject.optString("headimgUrl");
                m25658a(c44709u, c16658a);
            }
            AppMethodBeat.m2505o(131024);
        }
    }

    /* renamed from: a */
    private void m25658a(final C44709u c44709u, final C16658a c16658a) {
        AppMethodBeat.m2504i(131025);
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        jsApiChattingTask.username = this.hIE;
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        jsApiChattingTask.hww = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.e$2$1 */
            class C166611 implements C5186a {
                C166611() {
                }

                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(131020);
                    if (i == 1) {
                        if (c16658a != null) {
                            c16658a.mo30635a(true, "ok", intent);
                        }
                        jsApiChattingTask.aBW();
                    }
                    AppMethodBeat.m2505o(131020);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(131021);
                C4990ab.m7416i("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact go to the customized chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                C19154a c19154a = new C19154a();
                c19154a.appId = C16657e.this.hID;
                c19154a.username = C16657e.this.hIE;
                c19154a.from = 5;
                intent.putExtra("app_brand_chatting_expose_params", c19154a.ayP());
                intent.putExtra("keyPrivateAppId", C16657e.this.hID);
                intent.putExtra("keyPrivateUserName", C16657e.this.hIE);
                intent.putExtra("keyPrivateTitle", C16657e.this.hIF);
                intent.putExtra("keyPrivateSubTitle", C16657e.this.hIG);
                intent.putExtra("keyPrivateHeadImage", C16657e.this.hIH);
                Context context = (MMActivity) c44709u.mContext;
                if (context == null) {
                    if (c16658a != null) {
                        c16658a.mo30635a(false, "fail:internal error invalid android context", null);
                    }
                    C4990ab.m7412e("MicroMsg.JsApiPrivateEnterContact", "privateEnterContact mmActivity is null, invoke fail!");
                    AppMethodBeat.m2505o(131021);
                    return;
                }
                context.ifE = new C166611();
                C25985d.m41466b(context, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                AppMethodBeat.m2505o(131021);
            }
        };
        jsApiChattingTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiChattingTask);
        AppMethodBeat.m2505o(131025);
    }
}
