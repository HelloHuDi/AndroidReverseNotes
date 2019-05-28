package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.actions.SearchIntents;
import com.tencent.luggage.g.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.share.l;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.aoo;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import org.json.JSONObject;

public final class d extends com.tencent.mm.plugin.appbrand.jsapi.a {
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

    interface a {
        void a(boolean z, String str, Intent intent);
    }

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131004);
        if (cVar instanceof s) {
            cVar = (s) cVar;
            w aun = cVar.aun();
            if (aun == null) {
                ab.i("MicroMsg.JsApiEnterContact", "enterChatting fail, pageView is null");
                cVar.M(i, j("fail:current page do not exist", null));
                AppMethodBeat.o(131004);
                return;
            }
            a(aun, cVar, jSONObject, i);
            AppMethodBeat.o(131004);
        } else if (cVar instanceof u) {
            a((w) cVar, cVar, jSONObject, i);
            AppMethodBeat.o(131004);
        } else {
            cVar.M(i, j("fail:internal error invalid js component", null));
            AppMethodBeat.o(131004);
        }
    }

    private void a(w wVar, final c cVar, JSONObject jSONObject, final int i) {
        AppMethodBeat.i(131005);
        a(wVar, jSONObject, new a() {
            public final void a(boolean z, String str, Intent intent) {
                AppMethodBeat.i(130999);
                ab.i("MicroMsg.JsApiEnterContact", "page enterChatting isSuccess:%b", Boolean.valueOf(z));
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
                    ab.i("MicroMsg.JsApiEnterContact", "onBackFromContact path:%s, query:%s", obj, hashMap2.toString());
                    cVar.M(i, d.this.j("ok", hashMap));
                    AppMethodBeat.o(130999);
                    return;
                }
                cVar.M(i, d.this.j(str, null));
                AppMethodBeat.o(130999);
            }
        });
        AppMethodBeat.o(131005);
    }

    private void a(w wVar, JSONObject jSONObject, a aVar) {
        AppMethodBeat.i(131006);
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiEnterContact", "enterChatting fail, data is null");
            aVar.a(false, "fail:invalid data", null);
            AppMethodBeat.o(131006);
            return;
        }
        AppBrandSysConfigWC atH = wVar.getRuntime().atH();
        if (atH == null) {
            ab.i("MicroMsg.JsApiEnterContact", "enterChatting fail, config is null");
            aVar.a(false, "fail:config is null", null);
            AppMethodBeat.o(131006);
            return;
        }
        this.sessionFrom = jSONObject.optString("sessionFrom");
        if (this.sessionFrom.length() > WXMediaMessage.DESCRIPTION_LENGTH_LIMIT) {
            this.sessionFrom = this.sessionFrom.substring(0, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
            ab.i("MicroMsg.JsApiEnterContact", "sessionFrom length is large than 1024!");
        }
        this.hIm = jSONObject.optString("businessId");
        this.hIn = jSONObject.optString("sendMessageTitle");
        this.hIo = jSONObject.optString("sendMessagePath");
        this.hIp = jSONObject.optString("sendMessageImg");
        this.hIq = jSONObject.optBoolean("showMessageCard", false);
        this.hIs = l.BK(this.hIp);
        this.hIr = l.a(wVar, this.hIp, true);
        if (bo.isNullOrNil(this.hIm)) {
            ab.i("MicroMsg.JsApiEnterContact", "businessId is empty, enter to chatting");
            a(wVar, atH, "", aVar);
            AppMethodBeat.o(131006);
            return;
        }
        ab.i("MicroMsg.JsApiEnterContact", "do GetSubBusinessInfo cgi");
        a(wVar, atH, aVar);
        AppMethodBeat.o(131006);
    }

    private void a(final w wVar, final AppBrandSysConfigWC appBrandSysConfigWC, final a aVar) {
        AppMethodBeat.i(131007);
        String str = wVar.getRuntime().atI().username;
        if (appBrandSysConfigWC == null || bo.isNullOrNil(str)) {
            ab.e("MicroMsg.JsApiEnterContact", "doCgiAndEnterChatting username is null, err");
            if (aVar != null) {
                aVar.a(false, "fail:config is null", null);
            }
            AppMethodBeat.o(131007);
            return;
        }
        com.tencent.mm.ai.b.a aVar2 = new com.tencent.mm.ai.b.a();
        aVar2.fsJ = new aoo();
        aVar2.fsK = new aop();
        aVar2.uri = "/cgi-bin/mmbiz-bin/wxausrevent/getsubbusinessinfo";
        aVar2.fsI = 1303;
        aVar2.fsL = 0;
        aVar2.fsM = 0;
        b acD = aVar2.acD();
        aoo aoo = (aoo) acD.fsG.fsP;
        aoo.username = str;
        aoo.wsG = this.hIm;
        com.tencent.mm.ipcinvoker.wx_extension.b.a(acD, new com.tencent.mm.ipcinvoker.wx_extension.b.a() {
            public final void a(int i, int i2, String str, b bVar) {
                AppMethodBeat.i(131001);
                if (i == 0 && i2 == 0 && bVar.fsH.fsP != null) {
                    final aop aop = (aop) bVar.fsH.fsP;
                    ab.i("MicroMsg.JsApiEnterContact", "getsubbusinessinfo success, subBusinessUsername:%s", aop.wsH);
                    al.d(new Runnable() {
                        public final void run() {
                            AppMethodBeat.i(131000);
                            d.this.a(wVar, appBrandSysConfigWC, aop.wsH, aVar);
                            AppMethodBeat.o(131000);
                        }
                    });
                    AppMethodBeat.o(131001);
                    return;
                }
                ab.e("MicroMsg.JsApiEnterContact", "getsubbusinessinfo cgi failed, errType = %d, errCode = %d, errMsg = %s, rr.resp = %s", Integer.valueOf(i), Integer.valueOf(i2), str, bVar.fsH.fsP);
                if (aVar != null) {
                    aVar.a(false, "fail:cgi fail", null);
                }
                AppMethodBeat.o(131001);
            }
        });
        AppMethodBeat.o(131007);
    }

    /* Access modifiers changed, original: final */
    public final void a(w wVar, AppBrandSysConfigWC appBrandSysConfigWC, String str, a aVar) {
        AppMethodBeat.i(131008);
        final MainProcessTask jsApiChattingTask = new JsApiChattingTask();
        String str2 = wVar.getRuntime().atI().username;
        final com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a aVar2 = new com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a();
        aVar2.appId = wVar.getAppId();
        aVar2.username = str2;
        aVar2.nickname = appBrandSysConfigWC.cwz;
        aVar2.iconUrl = appBrandSysConfigWC.hgW;
        aVar2.gVt = appBrandSysConfigWC.hhd.gVt;
        aVar2.gVu = appBrandSysConfigWC.hhd.gVu;
        aVar2.hiv = appBrandSysConfigWC.hhd.cvZ;
        aVar2.from = 5;
        aVar2.pageId = a(wVar);
        aVar2.hiw = v.xh(wVar.getAppId());
        jsApiChattingTask.username = cc(str2, str);
        jsApiChattingTask.nickname = cb(appBrandSysConfigWC.cwz, str);
        jsApiChattingTask.sessionFrom = this.sessionFrom;
        final w wVar2 = wVar;
        final a aVar3 = aVar;
        jsApiChattingTask.hww = new Runnable() {
            public final void run() {
                AppMethodBeat.i(131003);
                ab.i("MicroMsg.JsApiEnterContact", "go to the chattingUI");
                Intent intent = new Intent();
                intent.setFlags(67108864);
                intent.putExtra("Chat_User", jsApiChattingTask.username);
                intent.putExtra("app_brand_chatting_from_scene", 2);
                intent.putExtra("app_brand_chatting_expose_params", aVar2.ayP());
                intent.putExtra("key_temp_session_from", jsApiChattingTask.sessionFrom);
                intent.putExtra("finish_direct", true);
                intent.putExtra("key_need_send_video", false);
                if (d.this.hIq) {
                    intent.putExtra("sendMessageTitle", d.this.hIn);
                    intent.putExtra("sendMessagePath", d.this.hIo);
                    intent.putExtra("sendMessageImg", d.this.hIp);
                    intent.putExtra("sendMessageLocalImg", l.getRealPath(d.this.hIr));
                    intent.putExtra("needDelThumb", d.this.hIs);
                }
                intent.putExtra("showMessageCard", d.this.hIq);
                Context context = (MMActivity) wVar2.mContext;
                if (context == null) {
                    if (aVar3 != null) {
                        aVar3.a(false, "fail:internal error invalid android context", null);
                    }
                    ab.e("MicroMsg.JsApiEnterContact", "mmActivity is null, invoke fail!");
                    AppMethodBeat.o(131003);
                    return;
                }
                context.ifE = new com.tencent.mm.ui.MMActivity.a() {
                    public final void c(int i, int i2, Intent intent) {
                        AppMethodBeat.i(131002);
                        if (i == 1) {
                            if (aVar3 != null) {
                                aVar3.a(true, "ok", intent);
                            }
                            jsApiChattingTask.aBW();
                        }
                        AppMethodBeat.o(131002);
                    }
                };
                com.tencent.mm.bp.d.b(context, ".ui.chatting.AppBrandServiceChattingUI", intent, 1);
                AppMethodBeat.o(131003);
            }
        };
        jsApiChattingTask.aBV();
        AppBrandMainProcessService.a(jsApiChattingTask);
        AppMethodBeat.o(131008);
    }

    private static String cb(String str, String str2) {
        AppMethodBeat.i(131009);
        if (!bo.isNullOrNil(str2)) {
            str = "";
            AppMethodBeat.o(131009);
            return str;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str = "";
            AppMethodBeat.o(131009);
            return str;
        } else {
            AppMethodBeat.o(131009);
            return str;
        }
    }

    private static String cc(String str, String str2) {
        AppMethodBeat.i(131010);
        if (!bo.isNullOrNil(str2)) {
            AppMethodBeat.o(131010);
            return str2;
        } else if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.JsApiEnterContact", "username & subBusinessUsername is null, err");
            str2 = "";
            AppMethodBeat.o(131010);
            return str2;
        } else {
            AppMethodBeat.o(131010);
            return str;
        }
    }

    private static String a(u uVar) {
        AppMethodBeat.i(131011);
        String str = "";
        if (uVar != null) {
            str = uVar.getURL();
        }
        ab.d("MicroMsg.JsApiEnterContact", "getCurrentPageId %s", str);
        AppMethodBeat.o(131011);
        return str;
    }
}
