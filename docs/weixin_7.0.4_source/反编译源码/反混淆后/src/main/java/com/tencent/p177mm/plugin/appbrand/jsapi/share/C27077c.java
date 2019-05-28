package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.model.C37922v.C32800b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C45622a;
import com.tencent.p177mm.plugin.appbrand.menu.C38449o;
import com.tencent.p177mm.plugin.appbrand.menu.C42636n;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.weishi.C33572e;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.c */
public final class C27077c extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131441);
        final C19722s c19722s = (C19722s) c2241c;
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "data is null");
            c19722s.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131441);
            return;
        }
        final C37402a c37402a = (C27242w) c19722s.mo61196ac(C27242w.class);
        if (c37402a == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            c19722s.mo6107M(i, mo73394j("fail:current page do not exist", null));
            AppMethodBeat.m2505o(131441);
            return;
        }
        C42636n ps = c37402a.mo71769ps(C38449o.ShareAppMsg.ordinal());
        if (ps == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            c19722s.mo6107M(i, mo73394j("fail:menu is null", null));
            AppMethodBeat.m2505o(131441);
            return;
        }
        C32800b c32800b = ps.hAx;
        if (c32800b.mo53357nX("user_clicked_share_btn")) {
            c32800b.mo53359z("user_clicked_share_btn", false);
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            final MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
            if (mMActivity == null) {
                C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                c19722s.mo6107M(i, mo73394j("fail: page context is null", null));
                AppMethodBeat.m2505o(131441);
                return;
            }
            boolean optBoolean;
            String str;
            boolean E = C33572e.m54822E(c19722s.getRuntime());
            final AppBrandInitConfigWC atI = c19722s.getRuntime().atI();
            final C16597h atH = c19722s.getRuntime().atH();
            final boolean z = c32800b.getBoolean("enable_share_with_share_ticket", false);
            final int i2 = z ? 3 : 2;
            final String optString = jSONObject.optString("title");
            final String optString2 = jSONObject.optString("desc", "");
            final String optString3 = jSONObject.optString("path");
            final String optString4 = jSONObject.optString("imageUrl");
            final String optString5 = jSONObject.optString("cacheKey");
            if (c19722s.getRuntime().mo65903xy()) {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
            } else {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            }
            if (E) {
                optBoolean = false;
            }
            final boolean nX = c32800b.mo53357nX("enable_share_dynamic");
            final boolean nX2 = c32800b.mo53357nX("enable_share_with_updateable_msg");
            final String string = c32800b.getString("enable_share_with_updateable_msg_template_id", "");
            final String appId = c19722s.getAppId();
            final String str2 = c19722s.getRuntime().atI().username;
            int i3 = atH.hhd.gVt;
            int i4 = atH.hhd.gVu;
            final int i5 = c19722s.getRuntime().atI().bQe;
            if (E) {
                String optString6 = jSONObject.optString("webpageUrl");
                if (C5046bo.isNullOrNil(optString6)) {
                    optString6 = C42700v.m75636xh(c19722s.getAppId());
                }
                str = optString6;
            } else {
                str = C42700v.m75636xh(c19722s.getAppId());
            }
            final boolean BK = C27080l.m43030BK(optString4);
            final String a = C27080l.m43031a(c37402a, optString4, optBoolean);
            HashMap hashMap = new HashMap();
            hashMap.put("desc", optString2);
            hashMap.put("type", Integer.valueOf(i2));
            hashMap.put("title", optString);
            hashMap.put("app_id", appId);
            hashMap.put("pkg_type", Integer.valueOf(i3));
            hashMap.put("pkg_version", Integer.valueOf(i4));
            hashMap.put("img_url", optString4);
            hashMap.put("is_dynamic", Boolean.valueOf(nX));
            hashMap.put("cache_key", optString5);
            hashMap.put("path", optString3);
            if (!C5046bo.isNullOrNil(a)) {
                hashMap.put("delay_load_img_path", a);
            }
            if (E) {
                hashMap.put("is_weishi_video", Boolean.TRUE);
                if (!(atI.bQj == null || C5046bo.isNullOrNil(atI.bQj.ijw))) {
                    hashMap.put("msg_img_path", atI.bQj.ijw);
                }
            }
            C4990ab.m7417i("MicroMsg.JsApiShareAppMessage", "msgParams:%s", hashMap);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", !z);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            final int i6 = i;
            final C270781 c270781 = new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, final int i2, Intent intent) {
                    AppMethodBeat.m2504i(131439);
                    if (i != 1) {
                        C4990ab.m7417i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", Integer.valueOf(i));
                        AppMethodBeat.m2505o(131439);
                    } else if (i2 != -1) {
                        C4990ab.m7417i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
                        c19722s.mo6107M(i6, C27077c.this.mo73394j("cancel", null));
                        C27077c.m43027a(appId, optString3, z ? 16 : 2, "", 3, i2);
                        AppMethodBeat.m2505o(131439);
                    } else {
                        final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (stringExtra == null || stringExtra.length() == 0) {
                            C4990ab.m7412e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                            c19722s.mo6107M(i6, C27077c.this.mo73394j("fail:selected user is nil", null));
                            C27077c.m43027a(appId, optString3, z ? 16 : 2, "", 2, i2);
                            AppMethodBeat.m2505o(131439);
                            return;
                        }
                        C4990ab.m7417i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", stringExtra);
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.hWD = stringExtra2;
                        sendAppMessageTask.toUser = stringExtra;
                        sendAppMessageTask.appId = appId;
                        C41243o runtime = c19722s.getRuntime();
                        if (runtime == null || runtime.mo15035yf() == null || !(runtime.mo15035yf() instanceof AppBrandInitConfigWC)) {
                            C4990ab.m7420w("MicroMsg.JsApiShareAppMessage", "hy: can not retrieve init config");
                            sendAppMessageTask.axy = -1;
                        } else {
                            sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.mo15035yf()).axy;
                        }
                        sendAppMessageTask.userName = str2;
                        sendAppMessageTask.title = optString;
                        sendAppMessageTask.description = optString2;
                        sendAppMessageTask.url = str;
                        sendAppMessageTask.path = optString3;
                        sendAppMessageTask.type = i2;
                        sendAppMessageTask.hWE = optString4;
                        sendAppMessageTask.iconUrl = atH.hgW;
                        sendAppMessageTask.cBc = atH.hhd.gVt;
                        sendAppMessageTask.hiv = atH.hhd.cvZ;
                        sendAppMessageTask.version = atH.hhd.gVu;
                        sendAppMessageTask.nickname = atH.cwz;
                        sendAppMessageTask.fhu = string;
                        sendAppMessageTask.hWJ = C38450n.m65049xb(appId).gPd.getAndIncrement();
                        sendAppMessageTask.hWL = c37402a.getURL();
                        sendAppMessageTask.hWM = c37402a.aBg();
                        AppBrandStatObject appBrandStatObject = c37402a.getRuntime().mo43491ya().bQn;
                        if (appBrandStatObject != null) {
                            sendAppMessageTask.scene = appBrandStatObject.scene == 0 ? 1000 : appBrandStatObject.scene;
                            sendAppMessageTask.cst = C5046bo.nullAsNil(appBrandStatObject.cst);
                            sendAppMessageTask.hWK = C5046bo.nullAsNil(c37402a.getRuntime().atI().mo32993xz());
                        }
                        sendAppMessageTask.hIs = BK;
                        sendAppMessageTask.hWF = C27080l.getRealPath(a);
                        sendAppMessageTask.withShareTicket = z;
                        sendAppMessageTask.hWN = nX;
                        sendAppMessageTask.hWO = nX2;
                        sendAppMessageTask.cacheKey = optString5;
                        sendAppMessageTask.fmr = i5;
                        C45622a aJS = c37402a.aJS();
                        if (aJS == null) {
                            stringExtra2 = "";
                        } else {
                            stringExtra2 = aJS.getWebView().getUrl();
                        }
                        sendAppMessageTask.hWP = stringExtra2;
                        if (C33572e.m54822E(runtime)) {
                            sendAppMessageTask.hWH = 3;
                            if (atI.bQj != null) {
                                sendAppMessageTask.hWQ = atI.bQj.appId;
                                sendAppMessageTask.hWR = atI.bQj.appName;
                                sendAppMessageTask.hWS = atI.bQj.ijx;
                                sendAppMessageTask.hWT = atI.bQj.thumbUrl;
                                if (C5046bo.isNullOrNil(sendAppMessageTask.hWE)) {
                                    sendAppMessageTask.hWF = atI.bQj.ijv;
                                    sendAppMessageTask.hIs = false;
                                }
                            }
                        }
                        if (z) {
                            sendAppMessageTask.hww = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.m2504i(131438);
                                    C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "task callback");
                                    sendAppMessageTask.aBW();
                                    HashMap hashMap = new HashMap();
                                    JSONArray jSONArray = new JSONArray();
                                    try {
                                        if (!C5046bo.m7548ek(sendAppMessageTask.hWU)) {
                                            Iterator it = sendAppMessageTask.hWU.iterator();
                                            while (it.hasNext()) {
                                                ShareInfo shareInfo = (ShareInfo) it.next();
                                                JSONObject jSONObject = new JSONObject();
                                                jSONObject.put("shareKey", shareInfo.bQi);
                                                jSONObject.put("shareName", shareInfo.bQh);
                                                jSONArray.put(jSONObject);
                                            }
                                        }
                                    } catch (JSONException e) {
                                        C4990ab.m7412e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
                                    }
                                    hashMap.put("shareInfos", jSONArray);
                                    c19722s.mo6107M(i6, C27077c.this.mo73394j("ok", hashMap));
                                    int i = 16;
                                    String str = stringExtra + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                                    if (stringExtra.toLowerCase().endsWith("@chatroom")) {
                                        i = 15;
                                    }
                                    C27077c.m43027a(appId, optString3, i, str, 1, i2);
                                    if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
                                        C7060h.pYm.mo8381e(16979, appId, optString3, Integer.valueOf(0), Integer.valueOf(3));
                                    }
                                    AppMethodBeat.m2505o(131438);
                                }
                            };
                            sendAppMessageTask.aBV();
                            AppBrandMainProcessService.m54349a(sendAppMessageTask);
                        } else {
                            AppBrandMainProcessService.m54349a(sendAppMessageTask);
                            c19722s.mo6107M(i6, C27077c.this.mo73394j("ok", null));
                            int i3 = 2;
                            if (stringExtra.toLowerCase().endsWith("@chatroom")) {
                                i3 = 9;
                            }
                            C27077c.m43027a(appId, optString3, i3, "", 1, i2);
                            if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
                                C7060h.pYm.mo8381e(16979, appId, optString3, Integer.valueOf(0), Integer.valueOf(3));
                            }
                        }
                        if (mMActivity != null) {
                            C30379h.m48465bQ(mMActivity, mMActivity.getResources().getString(C25738R.string.f8839gp));
                        }
                        AppMethodBeat.m2505o(131439);
                    }
                }
            };
            final MMActivity mMActivity2 = mMActivity;
            final Intent intent2 = intent;
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(131440);
                    C25985d.m41460a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, c270781);
                    AppMethodBeat.m2505o(131440);
                }
            }, 200);
            AppMethodBeat.m2505o(131441);
            return;
        }
        C4990ab.m7416i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        c19722s.mo6107M(i, mo73394j("fail:not allow to share", null));
        AppMethodBeat.m2505o(131441);
    }

    /* renamed from: a */
    static /* synthetic */ void m43027a(String str, String str2, int i, String str3, int i2, int i3) {
        AppMethodBeat.m2504i(131442);
        C19690c.m30500a(str, str2, i, str3, C5046bo.anT(), i2, i3);
        AppMethodBeat.m2505o(131442);
    }
}
