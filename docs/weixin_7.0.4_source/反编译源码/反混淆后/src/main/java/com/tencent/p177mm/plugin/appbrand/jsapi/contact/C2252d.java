package com.tencent.p177mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.p147g.C8874h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b;
import com.tencent.p177mm.ipcinvoker.wx_extension.C42146b.C9557a;
import com.tencent.p177mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.WxaExposedParams.C19154a;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C27080l;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.protocal.protobuf.aoo;
import com.tencent.p177mm.protocal.protobuf.aop;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.d */
public final class C2252d extends C10296a {
    public static final int CTRL_INDEX = 145;
    public static final String NAME = "enterContact";
    private String hIm;
    String hIn;
    String hIo;
    String hIp;
    boolean hIq;
    String hIr;
    boolean hIs;
    private String sessionFrom;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.d$a */
    interface C2256a {
        /* renamed from: a */
        void mo6133a(boolean z, String str, Intent intent);
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131004);
        if (c2241c instanceof C19722s) {
            c2241c = (C19722s) c2241c;
            C27242w aun = c2241c.aun();
            if (aun == null) {
                C4990ab.m7416i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
                c2241c.mo6107M(i, mo73394j("fail:current page do not exist", null));
                AppMethodBeat.m2505o(131004);
                return;
            }
            m4474a(aun, c2241c, jSONObject, i);
            AppMethodBeat.m2505o(131004);
        } else if (c2241c instanceof C44709u) {
            m4474a((C27242w) c2241c, c2241c, jSONObject, i);
            AppMethodBeat.m2505o(131004);
        } else {
            c2241c.mo6107M(i, mo73394j("fail:internal error invalid js component", null));
            AppMethodBeat.m2505o(131004);
        }
    }

    /* renamed from: a */
    private void m4474a(C27242w c27242w, final C2241c c2241c, JSONObject jSONObject, final int i) {
        AppMethodBeat.m2504i(131005);
        m4475a(c27242w, jSONObject, new C2256a() {
            /* renamed from: a */
            public final void mo6133a(boolean z, String str, Intent intent) {
                AppMethodBeat.m2504i(130999);
                C4990ab.m7417i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", Boolean.valueOf(z));
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
                    C4990ab.m7417i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", obj, hashMap2.toString());
                    c2241c.mo6107M(i, C2252d.this.mo73394j("ok", hashMap));
                    AppMethodBeat.m2505o(130999);
                    return;
                }
                c2241c.mo6107M(i, C2252d.this.mo73394j(str, null));
                AppMethodBeat.m2505o(130999);
            }
        });
        AppMethodBeat.m2505o(131005);
    }

    /* renamed from: a */
    private void m4475a(C27242w c27242w, JSONObject jSONObject, C2256a c2256a) {
        AppMethodBeat.m2504i(131006);
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
            c2256a.mo6133a(false, "fail:invalid data", null);
            AppMethodBeat.m2505o(131006);
            return;
        }
        AppBrandSysConfigWC atH = c27242w.getRuntime().atH();
        if (atH == null) {
            C4990ab.m7416i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
            c2256a.mo6133a(false, "fail:config is null", null);
            AppMethodBeat.m2505o(131006);
            return;
        }
        this.sessionFrom = jSONObject.optString("sessionFrom");
        if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            C4990ab.m7416i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        this.hIm = jSONObject.optString("businessId");
        this.hIn = jSONObject.optString("sendMessageTitle");
        this.hIo = jSONObject.optString("sendMessagePath");
        this.hIp = jSONObject.optString("sendMessageImg");
        this.hIq = jSONObject.optBoolean("showMessageCard", false);
        this.hIs = C27080l.m43030BK(this.hIp);
        this.hIr = C27080l.m43031a(c27242w, this.hIp, true);
        if (C5046bo.isNullOrNil(this.hIm)) {
            C4990ab.m7416i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            mo6132a(c27242w, atH, "", c2256a);
            AppMethodBeat.m2505o(131006);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        m4473a(c27242w, atH, c2256a);
        AppMethodBeat.m2505o(131006);
    }

    /* renamed from: a */
    private void m4473a(final C27242w c27242w, final AppBrandSysConfigWC appBrandSysConfigWC, final C2256a c2256a) {
        AppMethodBeat.m2504i(131007);
        String str = c27242w.getRuntime().atI().username;
        if (appBrandSysConfigWC == null || C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
            if (c2256a != null) {
                c2256a.mo6133a(false, "fail:config is null", null);
            }
            AppMethodBeat.m2505o(131007);
            return;
        }
        C1196a c1196a = new C1196a();
        c1196a.fsJ = new aoo();
        c1196a.fsK = new aop();
        c1196a.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        c1196a.fsI = 1303;
        c1196a.fsL = 0;
        c1196a.fsM = 0;
        C7472b acD = c1196a.acD();
        aoo aoo = (aoo) acD.fsG.fsP;
        aoo.username = str;
        aoo.wsG = this.hIm;
        C42146b.m74301a(acD, new C9557a() {
            /* renamed from: a */
            public final void mo5951a(int i, int i2, String str, C7472b c7472b) {
                AppMethodBeat.m2504i(131001);
                if (i == 0 && i2 == 0 && c7472b.fsH.fsP != null) {
                    final aop aop = (aop) c7472b.fsH.fsP;
                    C4990ab.m7417i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", aop.wsH);
                    C5004al.m7441d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.m2504i(131000);
                            C2252d.this.mo6132a(c27242w, appBrandSysConfigWC, aop.wsH, c2256a);
                            AppMethodBeat.m2505o(131000);
                        }
                    });
                    AppMethodBeat.m2505o(131001);
                    return;
                }
                C4990ab.m7413e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, c7472b.fsH.fsP);
                if (c2256a != null) {
                    c2256a.mo6133a(false, "fail:cgi fail", null);
                }
                AppMethodBeat.m2505o(131001);
            }
        });
        AppMethodBeat.m2505o(131007);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo6132a(C27242w c27242w, AppBrandSysConfigWC appBrandSysConfigWC, String str, C2256a c2256a) {
        AppMethodBeat.m2504i(131008);
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        String str2 = c27242w.getRuntime().atI().username;
        final C19154a c19154a = new C19154a();
        c19154a.appId = c27242w.getAppId();
        c19154a.username = str2;
        c19154a.nickname = appBrandSysConfigWC.cwz;
        c19154a.iconUrl = appBrandSysConfigWC.hgW;
        c19154a.gVt = appBrandSysConfigWC.hhd.gVt;
        c19154a.gVu = appBrandSysConfigWC.hhd.gVu;
        c19154a.hiv = appBrandSysConfigWC.hhd.cvZ;
        c19154a.from = 5;
        c19154a.pageId = C2252d.m4472a(c27242w);
        c19154a.hiw = C42700v.m75636xh(c27242w.getAppId());
        jsApiChattingTask.username = C2252d.m4477cc(str2, str);
        jsApiChattingTask.nickname = C2252d.m4476cb(appBrandSysConfigWC.cwz, str);
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        final C27242w c27242w2 = c27242w;
        final C2256a c2256a2 = c2256a;
        jsApiChattingTask.hww = new Runnable() {

            /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.contact.d$3$1 */
            class C22551 implements C5186a {
                C22551() {
                }

                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(131002);
                    if (i == 1) {
                        if (c2256a2 != null) {
                            c2256a2.mo6133a(true, "ok", intent);
                        }
                        jsApiChattingTask.aBW();
                    }
                    AppMethodBeat.m2505o(131002);
                }
            }

            public final void run() {
                AppMethodBeat.m2504i(131003);
                C4990ab.m7416i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", c19154a.ayP());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (C2252d.this.hIq) {
                    intent.putExtra("sendMessageTitle", C2252d.this.hIn);
                    intent.putExtra("sendMessagePath", C2252d.this.hIo);
                    intent.putExtra("sendMessageImg", C2252d.this.hIp);
                    intent.putExtra("sendMessageLocalImg", C27080l.getRealPath(C2252d.this.hIr));
                    intent.putExtra("needDelThumb", C2252d.this.hIs);
                }
                intent.putExtra("showMessageCard", C2252d.this.hIq);
                Context context = (MMActivity) c27242w2.mContext;
                if (context == null) {
                    if (c2256a2 != null) {
                        c2256a2.mo6133a(false, "fail:internal error invalid android context", null);
                    }
                    C4990ab.m7412e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    AppMethodBeat.m2505o(131003);
                    return;
                }
                context.ifE = new C22551();
                C25985d.m41466b(context, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                AppMethodBeat.m2505o(131003);
            }
        };
        jsApiChattingTask.aBV();
        AppBrandMainProcessService.m54349a(jsApiChattingTask);
        AppMethodBeat.m2505o(131008);
    }

    /* renamed from: cb */
    private static String m4476cb(String str, String str2) {
        AppMethodBeat.m2504i(131009);
        if (!C5046bo.isNullOrNil(str2)) {
            str = "";
            AppMethodBeat.m2505o(131009);
            return str;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str = "";
            AppMethodBeat.m2505o(131009);
            return str;
        } else {
            AppMethodBeat.m2505o(131009);
            return str;
        }
    }

    /* renamed from: cc */
    private static String m4477cc(String str, String str2) {
        AppMethodBeat.m2504i(131010);
        if (!C5046bo.isNullOrNil(str2)) {
            AppMethodBeat.m2505o(131010);
            return str2;
        } else if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str2 = "";
            AppMethodBeat.m2505o(131010);
            return str2;
        } else {
            AppMethodBeat.m2505o(131010);
            return str;
        }
    }

    /* renamed from: a */
    private static String m4472a(C44709u c44709u) {
        AppMethodBeat.m2504i(131011);
        String str = "";
        if (c44709u != null) {
            str = c44709u.getURL();
        }
        C4990ab.m7411d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", str);
        AppMethodBeat.m2505o(131011);
        return str;
    }
}
