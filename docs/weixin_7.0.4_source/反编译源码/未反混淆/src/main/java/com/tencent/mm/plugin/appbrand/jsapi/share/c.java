package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.content.Intent;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.menu.n;
import com.tencent.mm.plugin.appbrand.menu.o;
import com.tencent.mm.plugin.appbrand.page.w;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.plugin.appbrand.weishi.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends a<s> {
    public static final int CTRL_INDEX = 73;
    public static final String NAME = "shareAppMessage";

    public final /* synthetic */ void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(131441);
        final s sVar = (s) cVar;
        if (jSONObject == null) {
            ab.i("MicroMsg.JsApiShareAppMessage", "data is null");
            sVar.M(i, j("fail:data is null", null));
            AppMethodBeat.o(131441);
            return;
        }
        final com.tencent.luggage.sdk.a.a.a aVar = (w) sVar.ac(w.class);
        if (aVar == null) {
            ab.i("MicroMsg.JsApiShareAppMessage", "share app message fail, pageView is null");
            sVar.M(i, j("fail:current page do not exist", null));
            AppMethodBeat.o(131441);
            return;
        }
        n ps = aVar.ps(o.ShareAppMsg.ordinal());
        if (ps == null) {
            ab.i("MicroMsg.JsApiShareAppMessage", "share app message fail, menuInfo is null.");
            sVar.M(i, j("fail:menu is null", null));
            AppMethodBeat.o(131441);
            return;
        }
        b bVar = ps.hAx;
        if (bVar.nX("user_clicked_share_btn")) {
            bVar.z("user_clicked_share_btn", false);
            ab.i("MicroMsg.JsApiShareAppMessage", "invoke share app message");
            final MMActivity mMActivity = (MMActivity) sVar.ad(MMActivity.class);
            if (mMActivity == null) {
                ab.i("MicroMsg.JsApiShareAppMessage", "share app message fail, context is null");
                sVar.M(i, j("fail: page context is null", null));
                AppMethodBeat.o(131441);
                return;
            }
            boolean optBoolean;
            String str;
            boolean E = e.E(sVar.getRuntime());
            final AppBrandInitConfigWC atI = sVar.getRuntime().atI();
            final h atH = sVar.getRuntime().atH();
            final boolean z = bVar.getBoolean("enable_share_with_share_ticket", false);
            final int i2 = z ? 3 : 2;
            final String optString = jSONObject.optString("title");
            final String optString2 = jSONObject.optString("desc", "");
            final String optString3 = jSONObject.optString("path");
            final String optString4 = jSONObject.optString("imageUrl");
            final String optString5 = jSONObject.optString("cacheKey");
            if (sVar.getRuntime().xy()) {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", false);
            } else {
                optBoolean = jSONObject.optBoolean("useDefaultSnapshot", true);
            }
            if (E) {
                optBoolean = false;
            }
            final boolean nX = bVar.nX("enable_share_dynamic");
            final boolean nX2 = bVar.nX("enable_share_with_updateable_msg");
            final String string = bVar.getString("enable_share_with_updateable_msg_template_id", "");
            final String appId = sVar.getAppId();
            final String str2 = sVar.getRuntime().atI().username;
            int i3 = atH.hhd.gVt;
            int i4 = atH.hhd.gVu;
            final int i5 = sVar.getRuntime().atI().bQe;
            if (E) {
                String optString6 = jSONObject.optString("webpageUrl");
                if (bo.isNullOrNil(optString6)) {
                    optString6 = v.xh(sVar.getAppId());
                }
                str = optString6;
            } else {
                str = v.xh(sVar.getAppId());
            }
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
            if (E) {
                hashMap.put("is_weishi_video", Boolean.TRUE);
                if (!(atI.bQj == null || bo.isNullOrNil(atI.bQj.ijw))) {
                    hashMap.put("msg_img_path", atI.bQj.ijw);
                }
            }
            ab.i("MicroMsg.JsApiShareAppMessage", "msgParams:%s", hashMap);
            Intent intent = new Intent();
            intent.putExtra("Select_Conv_Type", 3);
            intent.putExtra("mutil_select_is_ret", !z);
            intent.putExtra("select_is_ret", true);
            intent.putExtra("scene_from", 3);
            intent.putExtra("appbrand_params", hashMap);
            intent.putExtra("Retr_Msg_Type", 2);
            final int i6 = i;
            final AnonymousClass1 anonymousClass1 = new MMActivity.a() {
                public final void c(int i, final int i2, Intent intent) {
                    AppMethodBeat.i(131439);
                    if (i != 1) {
                        ab.i("MicroMsg.JsApiShareAppMessage", "requestCode(%d) not corrected.", Integer.valueOf(i));
                        AppMethodBeat.o(131439);
                    } else if (i2 != -1) {
                        ab.i("MicroMsg.JsApiShareAppMessage", "resultCode is not RESULT_OK(%d)", Integer.valueOf(i2));
                        sVar.M(i6, c.this.j("cancel", null));
                        c.a(appId, optString3, z ? 16 : 2, "", 3, i2);
                        AppMethodBeat.o(131439);
                    } else {
                        final String stringExtra = intent == null ? null : intent.getStringExtra("Select_Conv_User");
                        if (stringExtra == null || stringExtra.length() == 0) {
                            ab.e("MicroMsg.JsApiShareAppMessage", "mmOnActivityResult fail, toUser is null");
                            sVar.M(i6, c.this.j("fail:selected user is nil", null));
                            c.a(appId, optString3, z ? 16 : 2, "", 2, i2);
                            AppMethodBeat.o(131439);
                            return;
                        }
                        ab.i("MicroMsg.JsApiShareAppMessage", "result success toUser : %s ", stringExtra);
                        String stringExtra2 = intent.getStringExtra("custom_send_text");
                        final MainProcessTask sendAppMessageTask = new SendAppMessageTask();
                        sendAppMessageTask.hWD = stringExtra2;
                        sendAppMessageTask.toUser = stringExtra;
                        sendAppMessageTask.appId = appId;
                        com.tencent.mm.plugin.appbrand.o runtime = sVar.getRuntime();
                        if (runtime == null || runtime.yf() == null || !(runtime.yf() instanceof AppBrandInitConfigWC)) {
                            ab.w("MicroMsg.JsApiShareAppMessage", "hy: can not retrieve init config");
                            sendAppMessageTask.axy = -1;
                        } else {
                            sendAppMessageTask.axy = ((AppBrandInitConfigWC) runtime.yf()).axy;
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
                        sendAppMessageTask.hWJ = com.tencent.mm.plugin.appbrand.n.xb(appId).gPd.getAndIncrement();
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
                        sendAppMessageTask.withShareTicket = z;
                        sendAppMessageTask.hWN = nX;
                        sendAppMessageTask.hWO = nX2;
                        sendAppMessageTask.cacheKey = optString5;
                        sendAppMessageTask.fmr = i5;
                        com.tencent.mm.plugin.appbrand.jsapi.t.a aJS = aVar.aJS();
                        if (aJS == null) {
                            stringExtra2 = "";
                        } else {
                            stringExtra2 = aJS.getWebView().getUrl();
                        }
                        sendAppMessageTask.hWP = stringExtra2;
                        if (e.E(runtime)) {
                            sendAppMessageTask.hWH = 3;
                            if (atI.bQj != null) {
                                sendAppMessageTask.hWQ = atI.bQj.appId;
                                sendAppMessageTask.hWR = atI.bQj.appName;
                                sendAppMessageTask.hWS = atI.bQj.ijx;
                                sendAppMessageTask.hWT = atI.bQj.thumbUrl;
                                if (bo.isNullOrNil(sendAppMessageTask.hWE)) {
                                    sendAppMessageTask.hWF = atI.bQj.ijv;
                                    sendAppMessageTask.hIs = false;
                                }
                            }
                        }
                        if (z) {
                            sendAppMessageTask.hww = new Runnable() {
                                public final void run() {
                                    AppMethodBeat.i(131438);
                                    ab.i("MicroMsg.JsApiShareAppMessage", "task callback");
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
                                        ab.e("MicroMsg.JsApiShareAppMessage", Log.getStackTraceString(e));
                                    }
                                    hashMap.put("shareInfos", jSONArray);
                                    sVar.M(i6, c.this.j("ok", hashMap));
                                    int i = 16;
                                    String str = stringExtra + VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D;
                                    if (stringExtra.toLowerCase().endsWith("@chatroom")) {
                                        i = 15;
                                    }
                                    c.a(appId, optString3, i, str, 1, i2);
                                    if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
                                        com.tencent.mm.plugin.report.service.h.pYm.e(16979, appId, optString3, Integer.valueOf(0), Integer.valueOf(3));
                                    }
                                    AppMethodBeat.o(131438);
                                }
                            };
                            sendAppMessageTask.aBV();
                            AppBrandMainProcessService.a(sendAppMessageTask);
                        } else {
                            AppBrandMainProcessService.a(sendAppMessageTask);
                            sVar.M(i6, c.this.j("ok", null));
                            int i3 = 2;
                            if (stringExtra.toLowerCase().endsWith("@chatroom")) {
                                i3 = 9;
                            }
                            c.a(appId, optString3, i3, "", 1, i2);
                            if ("wxfe02ecfe70800f46".equalsIgnoreCase(appId)) {
                                com.tencent.mm.plugin.report.service.h.pYm.e(16979, appId, optString3, Integer.valueOf(0), Integer.valueOf(3));
                            }
                        }
                        if (mMActivity != null) {
                            com.tencent.mm.ui.base.h.bQ(mMActivity, mMActivity.getResources().getString(R.string.gp));
                        }
                        AppMethodBeat.o(131439);
                    }
                }
            };
            final MMActivity mMActivity2 = mMActivity;
            final Intent intent2 = intent;
            al.n(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(131440);
                    d.a(mMActivity2, ".ui.transmit.SelectConversationUI", intent2, 1, anonymousClass1);
                    AppMethodBeat.o(131440);
                }
            }, 200);
            AppMethodBeat.o(131441);
            return;
        }
        ab.i("MicroMsg.JsApiShareAppMessage", "share app message fail, not allow to share");
        sVar.M(i, j("fail:not allow to share", null));
        AppMethodBeat.o(131441);
    }

    static /* synthetic */ void a(String str, String str2, int i, String str3, int i2, int i3) {
        AppMethodBeat.i(131442);
        com.tencent.mm.plugin.appbrand.report.c.a(str, str2, i, str3, bo.anT(), i2, i3);
        AppMethodBeat.o(131442);
    }
}
