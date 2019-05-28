package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class d extends a<s> {
    public static final int CTRL_INDEX = 240;
    public static final String NAME = "shareAppMessageDirectly";

    public final /* synthetic */ void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131446);
        final s sVar = (s) cVar;
        ab.i("MicroMsg.JsApiShareAppMessageDirectly", "invoke share app message directly.");
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiShareAppMessageDirectly", "data is null");
            sVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131446);
            return;
        }
        final MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
        if (mMActivity == null) {
            ab.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, context is null");
            sVar.M(i, j("fail: page context is null", null));
            AppMethodBeat.o(131446);
            return;
        }
        final com.tencent.luggage.sdk.a.a.a aVar = (w) sVar.ac(w.class);
        if (aVar == null) {
            ab.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, pageView is null");
            sVar.M(i, j("fail:current page do not exist", null));
            AppMethodBeat.o(131446);
            return;
        }
        n ps = aVar.ps(o.ShareAppMsg.ordinal());
        if (ps == null) {
            ab.i("MicroMsg.JsApiShareAppMessageDirectly", "share app message fail, menuInfo is null.");
            sVar.M(i, j("fail:menu is null", null));
            AppMethodBeat.o(131446);
            return;
        }
        boolean optBoolean;
        final h atH = sVar.getRuntime().atH();
        final boolean z = ps.hAx.getBoolean("enable_share_with_share_ticket", false);
        final int i2 = z ? 3 : 2;
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("desc", "");
        final String optString3 = jSONObject.optString("path");
        final String optString4 = jSONObject.optString("imageUrl");
        final String optString5 = jSONObject.optString("cacheKey");
        final String optString6 = jSONObject.optString("messageExtraData");
        if (sVar.getRuntime().xy()) {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
        } else {
            optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
        }
        final boolean nX = ps.hAx.nX("enable_share_dynamic");
        final boolean nX2 = ps.hAx.nX("enable_share_with_updateable_msg");
        final String string = ps.hAx.getString("enable_share_with_updateable_msg_template_id", "");
        final String appId = sVar.getAppId();
        final String str = sVar.getRuntime().atI().username;
        int i3 = atH.hhd.gVt;
        int i4 = atH.hhd.gVu;
        final int i5 = sVar.getRuntime().atI().bQe;
        final String xh = v.xh(sVar.getAppId());
        final boolean BK = l.BK(optString4);
        final String a = l.a(aVar, optString4, optBoolean);
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
        if (!bo.isNullOrNil(a)) {
            hashMap.put("delay_load_img_path", a);
        }
        ab.i("MicroMsg.JsApiShareAppMessageDirectly", "msgParams:%s", hashMap);
        Intent intent = new Intent();
        intent.putExtra("Select_Conv_Type", 3);
        intent.putExtra("mutil_select_is_ret", !z);
        intent.putExtra("select_is_ret", true);
        intent.putExtra("scene_from", 3);
        intent.putExtra("appbrand_params", hashMap);
        intent.putExtra("Retr_Msg_Type", 2);
        i4 = i;
        final AnonymousClass1 anonymousClass1 = new MMActivity.a() {
            public final void c(int i, int i2, Intent intent) {
                AppMethodBeat.i(131444);
                if (i != 1) {
                    ab.i("MicroMsg.JsApiShareAppMessageDirectly", "requestCode(%d) not corrected.", Integer.valueOf(i));
                    AppMethodBeat.o(131444);
                } else if (i2 != -1) {
                    ab.i("MicroMsg.JsApiShareAppMessageDirectly", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
                    sVar.M(i4, d.this.j("cancel", null));
                    AppMethodBeat.o(131444);
                } else {
                    String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                    if (stringExtra == null || stringExtra.length() == 0) {
                        ab.e("MicroMsg.JsApiShareAppMessageDirectly", "mmOnActivityResult fail, toUser is null");
                        sVar.M(i4, d.this.j("fail:selected user is nil", null));
                        AppMethodBeat.o(131444);
                        return;
                    }
                    ab.i("MicroMsg.JsApiShareAppMessageDirectly", "result success toUser : %s ", stringExtra);
                    String stringExtra2 = intent.getStringExtra("custom_send_text");
                    final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                    sendAppMessageTask.hWD = stringExtra2;
                    sendAppMessageTask.toUser = stringExtra;
                    sendAppMessageTask.appId = appId;
                    com.tencent.mm.plugin.appbrand.o runtime = sVar.getRuntime();
                    if (runtime == null || runtime.yf() == null || !(runtime.yf() instanceof AppBrandInitConfigWC)) {
                        ab.w("MicroMsg.JsApiShareAppMessageDirectly", "hy: can not retrieve init config");
                        sendAppMessageTask.axy = -1;
                    } else {
                        sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.yf()).axy;
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
                    sendAppMessageTask.hWJ = com.tencent.mm.plugin.appbrand.n.xb(appId).gPd.getAndIncrement();
                    sendAppMessageTask.hWL = aVar.getURL();
                    sendAppMessageTask.hWM = aVar.aBg();
                    AppBrandStatObject appBrandStatObject = aVar.getRuntime().ya().bQn;
                    if (appBrandStatObject != null) {
                        sendAppMessageTask.scene = appBrandStatObject.scene == 0 ? 1000 : appBrandStatObject.scene;
                        sendAppMessageTask.cst = bo.nullAsNil(appBrandStatObject.cst);
                        sendAppMessageTask.hWK = bo.nullAsNil(aVar.getRuntime().atI().xz());
                    }
                    sendAppMessageTask.hWF = l.getRealPath(a);
                    sendAppMessageTask.withShareTicket = z;
                    sendAppMessageTask.hWN = nX;
                    sendAppMessageTask.hWO = nX2;
                    sendAppMessageTask.fhu = string;
                    sendAppMessageTask.cacheKey = optString5;
                    sendAppMessageTask.fmr = i5;
                    com.tencent.mm.plugin.appbrand.jsapi.t.a aJS = aVar.aJS();
                    if (aJS == null) {
                        stringExtra = "";
                    } else {
                        stringExtra = aJS.getWebView().getUrl();
                    }
                    sendAppMessageTask.hWP = stringExtra;
                    if (z) {
                        sendAppMessageTask.hww = new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(131443);
                                ab.i("MicroMsg.JsApiShareAppMessageDirectly", "task callback");
                                sendAppMessageTask.aBW();
                                HashMap hashMap = new HashMap();
                                JSONArray jSONArray = new JSONArray();
                                try {
                                    if (!bo.ek(sendAppMessageTask.hWU)) {
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
                                    ab.e("MicroMsg.JsApiShareAppMessageDirectly", Log.getStackTraceString(e));
                                }
                                hashMap.put("shareInfos", jSONArray);
                                sVar.M(i4, d.this.j("ok", hashMap));
                                AppMethodBeat.o(131443);
                            }
                        };
                        sendAppMessageTask.aBV();
                        AppBrandMainProcessService.a(sendAppMessageTask);
                    } else {
                        AppBrandMainProcessService.a(sendAppMessageTask);
                        sVar.M(i4, d.this.j("ok", null));
                    }
                    if (mMActivity != null) {
                        com.tencent.mm.ui.base.h.bQ(mMActivity, mMActivity.getResources().getString(R.string.gp));
                    }
                    AppMethodBeat.o(131444);
                }
            }
        };
        final MMActivity mMActivity2 = mMActivity;
        final Intent intent2 = intent;
        al.n(new Runnable() {
            public final void run() {
                AppMethodBeat.i(131445);
                com.tencent.mm.bp.d.a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, anonymousClass1);
                AppMethodBeat.o(131445);
            }
        }, 200);
        AppMethodBeat.o(131446);
    }
}
