package com.tencent.p177mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.luggage.sdk.p819a.p820a.C37402a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p181af.C8909j.C8913a;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.MMActivity.C5186a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.appbrand.C19722s;
import com.tencent.p177mm.plugin.appbrand.C38450n;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.C42700v;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.p177mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.p316t.C45622a;
import com.tencent.p177mm.plugin.appbrand.page.C27242w;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.share.e */
public final class C42570e extends C10296a<C19722s> {
    public static final int CTRL_INDEX = 589;
    public static final String NAME = "shareAppMessageForFakeNative";

    /* renamed from: a */
    public final /* synthetic */ void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(131449);
        final C19722s c19722s = (C19722s) c2241c;
        C4990ab.m7416i("MicroMsg.JsApiShareAppMessageForFakeNative", "invoke share app message for fake native.");
        if (jSONObject == null) {
            C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, data is null.");
            c19722s.mo6107M(i, mo73394j("fail:data is null", null));
            AppMethodBeat.m2505o(131449);
            return;
        }
        final C37402a c37402a = (C27242w) c19722s.mo61196ac(C27242w.class);
        if (c37402a == null) {
            C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, pageView is null.");
            c19722s.mo6107M(i, mo73394j("fail:current page do not exist", null));
            AppMethodBeat.m2505o(131449);
            return;
        }
        final MMActivity mMActivity = (MMActivity) c19722s.mo61197ad(MMActivity.class);
        if (mMActivity == null) {
            C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, context is null.");
            c19722s.mo6107M(i, mo73394j("fail:page context is null", null));
            AppMethodBeat.m2505o(131449);
            return;
        }
        final int optInt = jSONObject.optInt("bizType", C8913a.BUSINESS_MAX.ordinal());
        if (C8913a.isValid(optInt)) {
            final String optString = jSONObject.optString("title");
            if (C5046bo.isNullOrNil(optString)) {
                C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, title is empty.");
                c19722s.mo6107M(i, mo73394j("fail:title is empty", null));
                AppMethodBeat.m2505o(131449);
                return;
            }
            String optString2 = jSONObject.optString("defaultHintUrl");
            if (C5046bo.isNullOrNil(optString2)) {
                optString2 = C42700v.m75636xh(c19722s.getAppId());
            }
            C4990ab.m7411d("MicroMsg.JsApiShareAppMessageForFakeNative", "errorUrl: %s.", optString2);
            final String optString3 = jSONObject.optString("desc", "");
            final String optString4 = jSONObject.optString("path", "");
            final String optString5 = jSONObject.optString("imageUrl", "");
            boolean optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            final String optString6 = jSONObject.optString("tailLang", "");
            final boolean optBoolean2 = jSONObject.optBoolean("disableForward", true);
            final String appId = c19722s.getAppId();
            final String str = c19722s.getRuntime().atI().username;
            final AppBrandSysConfigWC atH = c19722s.getRuntime().atH();
            final int i2 = c19722s.getRuntime().atI().bQe;
            final boolean BK = C27080l.m43030BK(optString5);
            final String a = C27080l.m43031a(c37402a, optString5, optBoolean);
            HashMap hashMap = new HashMap();
            hashMap.put("type", Integer.valueOf(2));
            hashMap.put("biz", Integer.valueOf(optInt));
            hashMap.put("title", optString);
            hashMap.put("desc", optString3);
            hashMap.put("path", optString4);
            hashMap.put("img_url", optString5);
            hashMap.put("tail_lang", optString6);
            hashMap.put("disableForward", Boolean.valueOf(optBoolean2));
            hashMap.put("app_id", appId);
            hashMap.put("pkg_type", Integer.valueOf(atH.hhd.gVt));
            hashMap.put("pkg_version", Integer.valueOf(atH.hhd.gVu));
            hashMap.put("icon_url", atH.hgW);
            hashMap.put("nickname", atH.cwz);
            if (!C5046bo.isNullOrNil(a)) {
                hashMap.put("delay_load_img_path", a);
            }
            C4990ab.m7417i("MicroMsg.JsApiShareAppMessageForFakeNative", "msgParams:%s", hashMap);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            final int i3 = i;
            final C105141 c105141 = new C5186a() {
                /* renamed from: c */
                public final void mo6069c(int i, int i2, Intent intent) {
                    AppMethodBeat.m2504i(131447);
                    if (1 != i) {
                        C4990ab.m7413e("MicroMsg.JsApiShareAppMessageForFakeNative", "requestCode(%d) not corrected.", Integer.valueOf(i));
                        AppMethodBeat.m2505o(131447);
                    } else if (-1 != i2) {
                        C4990ab.m7413e("MicroMsg.JsApiShareAppMessageForFakeNative", "resultCode is not RESULT_OK(%d).", Integer.valueOf(i2));
                        c19722s.mo6107M(i3, C42570e.this.mo73394j("cancel", null));
                        AppMethodBeat.m2505o(131447);
                    } else {
                        String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (C5046bo.isNullOrNil(stringExtra)) {
                            C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "mmOnActivityResult fail, toUser is null.");
                            c19722s.mo6107M(i3, C42570e.this.mo73394j("fail:no selected user", null));
                            AppMethodBeat.m2505o(131447);
                            return;
                        }
                        int i3;
                        C4990ab.m7411d("MicroMsg.JsApiShareAppMessageForFakeNative", "share app msg success, to: %s ", stringExtra);
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.hWD = stringExtra2;
                        sendAppMessageTask.toUser = stringExtra;
                        sendAppMessageTask.appId = appId;
                        C41243o runtime = c19722s.getRuntime();
                        if (runtime == null || runtime.mo15035yf() == null || !(runtime.mo15035yf() instanceof AppBrandInitConfigWC)) {
                            C4990ab.m7420w("MicroMsg.JsApiShareAppMessageForFakeNative", "can not retrieve init config.");
                            sendAppMessageTask.axy = -1;
                        } else {
                            sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.mo15035yf()).axy;
                        }
                        sendAppMessageTask.hWH = 2;
                        sendAppMessageTask.type = 2;
                        sendAppMessageTask.duk = optInt;
                        if (optBoolean2) {
                            i3 = 1;
                        } else {
                            i3 = 0;
                        }
                        sendAppMessageTask.hWI = i3;
                        sendAppMessageTask.title = optString;
                        sendAppMessageTask.description = optString3;
                        sendAppMessageTask.hWE = optString5;
                        sendAppMessageTask.hWG = optString6;
                        sendAppMessageTask.iconUrl = atH.hgW;
                        sendAppMessageTask.userName = str;
                        sendAppMessageTask.nickname = atH.cwz;
                        sendAppMessageTask.path = optString4;
                        sendAppMessageTask.cBc = atH.hhd.gVt;
                        sendAppMessageTask.hiv = atH.hhd.cvZ;
                        sendAppMessageTask.version = atH.hhd.gVu;
                        sendAppMessageTask.url = optString2;
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
                        sendAppMessageTask.fmr = i2;
                        C45622a aJS = c37402a.aJS();
                        if (aJS == null) {
                            stringExtra = "";
                        } else {
                            stringExtra = aJS.getWebView().getUrl();
                        }
                        sendAppMessageTask.hWP = stringExtra;
                        AppBrandMainProcessService.m54349a(sendAppMessageTask);
                        c19722s.mo6107M(i3, C42570e.this.mo73394j("ok", null));
                        C30379h.m48465bQ(mMActivity, mMActivity.getResources().getString(C25738R.string.f8839gp));
                        AppMethodBeat.m2505o(131447);
                    }
                }
            };
            final MMActivity mMActivity2 = mMActivity;
            final Intent intent2 = intent;
            C5004al.m7442n(new Runnable() {
                public final void run() {
                    AppMethodBeat.m2504i(131448);
                    C25985d.m41460a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, c105141);
                    AppMethodBeat.m2505o(131448);
                }
            }, 200);
            AppMethodBeat.m2505o(131449);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
        c19722s.mo6107M(i, mo73394j("fail:biz is invalid", null));
        AppMethodBeat.m2505o(131449);
    }
}
