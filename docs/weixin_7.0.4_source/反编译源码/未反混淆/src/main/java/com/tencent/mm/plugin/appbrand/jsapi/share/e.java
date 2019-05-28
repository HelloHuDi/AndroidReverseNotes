package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.n;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import java.util.HashMap;
import org.json.JSONObject;

public final class e extends a<s> {
    public static final int CTRL_INDEX = 589;
    public static final String NAME = "shareAppMessageForFakeNative";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131449);
        final s sVar = (s) cVar;
        ab.i("MicroMsg.JsApiShareAppMessageForFakeNative", "invoke share app message for fake native.");
        if (jSONObject == null) {
            ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, data is null.");
            sVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131449);
            return;
        }
        final com.tencent.luggage.sdk.a.a.a aVar = (w) sVar.ac(w.class);
        if (aVar == null) {
            ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, pageView is null.");
            sVar.M(i, j("fail:current page do not exist", null));
            AppMethodBeat.o(131449);
            return;
        }
        final MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
        if (mMActivity == null) {
            ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, context is null.");
            sVar.M(i, j("fail:page context is null", null));
            AppMethodBeat.o(131449);
            return;
        }
        final int optInt = jSONObject.optInt("bizType", j.a.BUSINESS_MAX.ordinal());
        if (j.a.isValid(optInt)) {
            final String optString = jSONObject.optString("title");
            if (bo.isNullOrNil(optString)) {
                ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, title is empty.");
                sVar.M(i, j("fail:title is empty", null));
                AppMethodBeat.o(131449);
                return;
            }
            String optString2 = jSONObject.optString("defaultHintUrl");
            if (bo.isNullOrNil(optString2)) {
                optString2 = v.xh(sVar.getAppId());
            }
            ab.d("MicroMsg.JsApiShareAppMessageForFakeNative", "errorUrl: %s.", optString2);
            final String optString3 = jSONObject.optString("desc", "");
            final String optString4 = jSONObject.optString("path", "");
            final String optString5 = jSONObject.optString("imageUrl", "");
            boolean optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            final String optString6 = jSONObject.optString("tailLang", "");
            final boolean optBoolean2 = jSONObject.optBoolean("disableForward", true);
            final String appId = sVar.getAppId();
            final String str = sVar.getRuntime().atI().username;
            final AppBrandSysConfigWC atH = sVar.getRuntime().atH();
            final int i2 = sVar.getRuntime().atI().bQe;
            final boolean BK = l.BK(optString5);
            final String a = l.a(aVar, optString5, optBoolean);
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
            if (!bo.isNullOrNil(a)) {
                hashMap.put("delay_load_img_path", a);
            }
            ab.i("MicroMsg.JsApiShareAppMessageForFakeNative", "msgParams:%s", hashMap);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            final int i3 = i;
            final AnonymousClass1 anonymousClass1 = new MMActivity.a() {
                public final void c(int i, int i2, Intent intent) {
                    AppMethodBeat.i(131447);
                    if (1 != i) {
                        ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "requestCode(%d) not corrected.", Integer.valueOf(i));
                        AppMethodBeat.o(131447);
                    } else if (-1 != i2) {
                        ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "resultCode is not RESULT_OK(%d).", Integer.valueOf(i2));
                        sVar.M(i3, e.this.j("cancel", null));
                        AppMethodBeat.o(131447);
                    } else {
                        String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (bo.isNullOrNil(stringExtra)) {
                            ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "mmOnActivityResult fail, toUser is null.");
                            sVar.M(i3, e.this.j("fail:no selected user", null));
                            AppMethodBeat.o(131447);
                            return;
                        }
                        int i3;
                        ab.d("MicroMsg.JsApiShareAppMessageForFakeNative", "share app msg success, to: %s ", stringExtra);
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.hWD = stringExtra2;
                        sendAppMessageTask.toUser = stringExtra;
                        sendAppMessageTask.appId = appId;
                        o runtime = sVar.getRuntime();
                        if (runtime == null || runtime.yf() == null || !(runtime.yf() instanceof AppBrandInitConfigWC)) {
                            ab.w("MicroMsg.JsApiShareAppMessageForFakeNative", "can not retrieve init config.");
                            sendAppMessageTask.axy = -1;
                        } else {
                            sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.yf()).axy;
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
                        sendAppMessageTask.hWJ = n.xb(appId).gPd.getAndIncrement();
                        sendAppMessageTask.hWL = aVar.getURL();
                        sendAppMessageTask.hWM = aVar.aBg();
                        AppBrandStatObject appBrandStatObject = aVar.getRuntime().ya().bQn;
                        if (appBrandStatObject != null) {
                            sendAppMessageTask.scene = appBrandStatObject.scene == 0 ? 1000 : appBrandStatObject.scene;
                            sendAppMessageTask.cst = bo.nullAsNil(appBrandStatObject.cst);
                            sendAppMessageTask.hWK = bo.nullAsNil(aVar.getRuntime().atI().xz());
                        }
                        sendAppMessageTask.hIs = BK;
                        sendAppMessageTask.hWF = l.getRealPath(a);
                        sendAppMessageTask.fmr = i2;
                        com.tencent.mm.plugin.appbrand.jsapi.t.a aJS = aVar.aJS();
                        if (aJS == null) {
                            stringExtra = "";
                        } else {
                            stringExtra = aJS.getWebView().getUrl();
                        }
                        sendAppMessageTask.hWP = stringExtra;
                        AppBrandMainProcessService.a(sendAppMessageTask);
                        sVar.M(i3, e.this.j("ok", null));
                        h.bQ(mMActivity, mMActivity.getResources().getString(R.string.gp));
                        AppMethodBeat.o(131447);
                    }
                }
            };
            final MMActivity mMActivity2 = mMActivity;
            final Intent intent2 = intent;
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(131448);
                    d.a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, anonymousClass1);
                    AppMethodBeat.o(131448);
                }
            }, 200);
            AppMethodBeat.o(131449);
            return;
        }
        ab.e("MicroMsg.JsApiShareAppMessageForFakeNative", "share app message fail, biz is invalid.");
        sVar.M(i, j("fail:biz is invalid", null));
        AppMethodBeat.o(131449);
    }
}
