package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
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
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.d */
public final class C42568d extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131446);
        final C19722s c19722s = (C19722s) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "invoke share app message directly.");
        if (jSONObject == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "data is null");
            c19722s.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131446);
            return;
        }
        final MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, context is null");
            c19722s.mo6107M(i, mo73394j("fail: page context is null", null));
            AppMethodBeat.m2505o(131446);
            return;
        }
        final C37402a c37402a = (C27242w) c19722s.mo61196ac(C27242w.class);
        if (c37402a == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, pageView is null");
            c19722s.mo6107M(i, mo73394j("fail:current page do not exist", null));
            AppMethodBeat.m2505o(131446);
            return;
        }
        C42636n ps = c37402a.mo71769ps(C38449o.ShareAppMsg.ordinal());
        if (ps == null) {
            C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, menuInfo is null.");
            c19722s.mo6107M(i, mo73394j("fail:menu is null", null));
            AppMethodBeat.m2505o(131446);
            return;
        }
        boolean optBoolean;
        final C16597h atH = c19722s.getRuntime().atH();
        final boolean z = ps.hAx.getBoolean("enable_share_with_share_ticket", false);
        final int i2 = z ? 3 : 2;
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("desc", "");
        final String optString3 = jSONObject.optString("path");
        final String optString4 = jSONObject.optString("imageUrl");
        final String optString5 = jSONObject.optString("cacheKey");
        final String optString6 = jSONObject.optString("messageExtraData");
        if (c19722s.getRuntime().mo65903xy()) {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
        } else {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
        }
        final boolean nX = ps.hAx.mo53357nX("enable_share_dynamic");
        final boolean nX2 = ps.hAx.mo53357nX("enable_share_with_updateable_msg");
        final String string = ps.hAx.getString("enable_share_with_updateable_msg_template_id", "");
        final String appId = c19722s.getAppId();
        final String str = c19722s.getRuntime().atI().username;
        int i3 = atH.hhd.gVt;
        int i4 = atH.hhd.gVu;
        final int i5 = c19722s.getRuntime().atI().bQe;
        final String xh = C42700v.m75636xh(c19722s.getAppId());
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
        C4990ab.m7417i("MicroMsg.JsApiShareAppMessageDirectly", "msgParams:%s", hashMap);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", !z);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        i4 = i;
        final C383821 c383821 = new C5186a() {
            /* renamed from: c */
            public final void mo6069c(int i, int i2, Intent intent) {
                AppMethodBeat.m2504i(131444);
                if (i != 1) {
                    C4990ab.m7417i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", Integer.valueOf(i));
                    AppMethodBeat.m2505o(131444);
                } else if (i2 != -1) {
                    C4990ab.m7417i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
                    c19722s.mo6107M(i4, C42568d.this.mo73394j("cancel", null));
                    AppMethodBeat.m2505o(131444);
                } else {
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        C4990ab.m7412e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
                        c19722s.mo6107M(i4, C42568d.this.mo73394j("fail:selected user is nil", null));
                        AppMethodBeat.m2505o(131444);
                        return;
                    }
                    C4990ab.m7417i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", stringExtra);
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                    sendAppMessageTask.hWD = stringExtra2;
                    sendAppMessageTask.toUser = stringExtra;
                    sendAppMessageTask.appId = appId;
                    C41243o runtime = c19722s.getRuntime();
                    if (runtime == null || runtime.mo15035yf() == null || !(runtime.mo15035yf() instanceof AppBrandInitConfigWC)) {
                        C4990ab.m7420w("MicroMsg.JsApiShareAppMessageDirectly", "hy: can not retrieve init config");
                        sendAppMessageTask.axy = -1;
                    } else {
                        sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.mo15035yf()).axy;
                    }
                    sendAppMessageTask.userName = str;
                    sendAppMessageTask.title = optString;
                    sendAppMessageTask.description = optString2;
                    sendAppMessageTask.url = xh;
                    sendAppMessageTask.path = optString3;
                    sendAppMessageTask.type = i2;
                    sendAppMessageTask.hIs = BK;
                    sendAppMessageTask.hWE = optString4;
                    sendAppMessageTask.iconUrl = atH.hgW;
                    sendAppMessageTask.cBc = atH.hhd.gVt;
                    sendAppMessageTask.hiv = atH.hhd.cvZ;
                    sendAppMessageTask.version = atH.hhd.gVu;
                    sendAppMessageTask.nickname = atH.cwz;
                    sendAppMessageTask.cOv = optString6;
                    sendAppMessageTask.hWJ = C38450n.m65049xb(appId).gPd.getAndIncrement();
                    sendAppMessageTask.hWL = c37402a.getURL();
                    sendAppMessageTask.hWM = c37402a.aBg();
                    AppBrandStatObject appBrandStatObject = c37402a.getRuntime().mo43491ya().bQn;
                    if (appBrandStatObject != null) {
                        sendAppMessageTask.scene = appBrandStatObject.scene == 0 ? 1000 : appBrandStatObject.scene;
                        sendAppMessageTask.cst = C5046bo.nullAsNil(appBrandStatObject.cst);
                        sendAppMessageTask.hWK = C5046bo.nullAsNil(c37402a.getRuntime().atI().mo32993xz());
                    }
                    sendAppMessageTask.hWF = C27080l.getRealPath(a);
                    sendAppMessageTask.withShareTicket = z;
                    sendAppMessageTask.hWN = nX;
                    sendAppMessageTask.hWO = nX2;
                    sendAppMessageTask.fhu = string;
                    sendAppMessageTask.cacheKey = optString5;
                    sendAppMessageTask.fmr = i5;
                    C45622a aJS = c37402a.aJS();
                    if (aJS == null) {
                        stringExtra = "";
                    } else {
                        stringExtra = aJS.getWebView().getUrl();
                    }
                    sendAppMessageTask.hWP = stringExtra;
                    if (z) {
                        sendAppMessageTask.hww = new Runnable() {
                            public final void run() {
                                AppMethodBeat.m2504i(131443);
                                C4990ab.m7416i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
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
                                    C4990ab.m7412e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(e));
                                }
                                hashMap.put("shareInfos", jSONArray);
                                c19722s.mo6107M(i4, C42568d.this.mo73394j("ok", hashMap));
                                AppMethodBeat.m2505o(131443);
                            }
                        };
                        sendAppMessageTask.aBV();
                        AppBrandMainProcessService.m54349a(sendAppMessageTask);
                    } else {
                        AppBrandMainProcessService.m54349a(sendAppMessageTask);
                        c19722s.mo6107M(i4, C42568d.this.mo73394j("ok", null));
                    }
                    if (mMActivity != null) {
                        C30379h.m48465bQ(mMActivity, mMActivity.getResources().getString(C25738R.string.f8839gp));
                    }
                    AppMethodBeat.m2505o(131444);
                }
            }
        };
        final MMActivity mMActivity2 = mMActivity;
        final Intent intent2 = intent;
        C5004al.m7442n(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(131445);
                C25985d.m41460a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, c383821);
                AppMethodBeat.m2505o(131445);
            }
        }, 200);
        AppMethodBeat.m2505o(131446);
    }
}
