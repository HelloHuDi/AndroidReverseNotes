package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.af;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.mm.plugin.appbrand.jsapi.ax;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.d;
import com.tencent.mm.plugin.appbrand.jsapi.e.j;
import com.tencent.mm.plugin.appbrand.jsapi.fakenative.c;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.stub.e;
import com.tencent.mm.pluginsdk.ui.tools.u;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class l {
    private static String iCz = "";
    private static String jVi = "";
    private static Set<String> uIZ = new HashSet();
    private static String unl = "";

    static {
        AppMethodBeat.i(9850);
        AppMethodBeat.o(9850);
    }

    public static void a(Map<String, Object> map, boolean z, String str, String str2) {
        AppMethodBeat.i(9847);
        if (map != null) {
            map.put("fromMenu", Boolean.valueOf(z));
            map.put("keyParam", str);
            if (bo.isNullOrNil((String) map.get("appId"))) {
                map.put("appId", str2);
            }
        }
        AppMethodBeat.o(9847);
    }

    public static void a(e eVar) {
        String str;
        AppMethodBeat.i(9848);
        Object obj = eVar == null ? 1 : null;
        if (obj != null) {
            try {
                str = "";
            } catch (Exception e) {
                ab.w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e.getMessage());
                AppMethodBeat.o(9848);
                return;
            }
        }
        str = eVar.cYY();
        jVi = str;
        iCz = obj != null ? "" : eVar.getCurrentUrl();
        unl = obj != null ? "" : eVar.cYZ();
        AppMethodBeat.o(9848);
    }

    public static void C(String str, Map<String, Object> map) {
        AppMethodBeat.i(9849);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
            AppMethodBeat.o(9849);
            return;
        }
        boolean e;
        boolean e2;
        int h;
        int h2;
        int h3;
        String str2;
        String str3 = null;
        String str4 = "";
        if (map != null) {
            e = bo.e((Boolean) map.get("fromMenu"));
            str3 = bo.nullAsNil((String) map.get("keyParam"));
            str4 = bo.bc((String) map.get("appId"), "");
            e2 = bo.e((Boolean) map.get("isSuccess"));
            h = bo.h((Integer) map.get("permissionValue"));
            h2 = bo.h((Integer) map.get("baseErrorCode"));
            h3 = bo.h((Integer) map.get("jsapiErrorCode"));
        } else {
            h3 = 0;
            h2 = 0;
            h = 0;
            e2 = false;
            e = false;
        }
        String akk = u.akk(bo.nullAsNil(jVi));
        String akk2 = u.akk(bo.nullAsNil(iCz));
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(akk);
        stringBuilder.append(",");
        stringBuilder.append(akk2);
        stringBuilder.append(",");
        stringBuilder.append(unl == null ? "" : unl);
        stringBuilder.append(",");
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        stringBuilder.append(str2);
        stringBuilder.append(",");
        stringBuilder.append(e ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuilder.append(",");
        if (str3 == null) {
            str3 = "";
        }
        stringBuilder.append(str3);
        stringBuilder.append(",");
        stringBuilder.append(str4);
        stringBuilder.append(",");
        stringBuilder.append(e2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        stringBuilder.append(",");
        stringBuilder.append(h);
        if (!e2) {
            stringBuilder.append(",");
            stringBuilder.append(0);
            stringBuilder.append(",");
            stringBuilder.append(h2);
            stringBuilder.append(",");
            stringBuilder.append(h3);
        }
        ab.d("MicroMsg.WebViewSecurityUtil", "report: %s", stringBuilder.toString());
        h.pYm.X(10417, r0);
        if (uIZ.size() <= 0) {
            uIZ.add("openUrlByExtBrowser");
            uIZ.add("startVoipCall");
            uIZ.add("getCurrentSSID");
            uIZ.add(JsApiChooseVideo.NAME);
            uIZ.add("uploadVideo");
            uIZ.add("getOpenDeviceId");
            uIZ.add("chooseIdCard");
            uIZ.add("recordVideo");
            uIZ.add(JsApiChooseMedia.NAME);
            uIZ.add("requestWxFacePictureVerify");
            uIZ.add("requestWxFacePictureVerifyUnionVideo");
            uIZ.add(com.tencent.mm.plugin.appbrand.jsapi.a.e.NAME);
            uIZ.add(JsApiGetInstallState.NAME);
            uIZ.add(JsApiAddDownloadTask.NAME);
            uIZ.add(JsApiCancelDownloadTask.NAME);
            uIZ.add(JsApiQueryDownloadTask.NAME);
            uIZ.add(JsApiInstallDownloadTask.NAME);
            uIZ.add("launch3rdApp");
            uIZ.add(JsApiPauseDownloadTask.NAME);
            uIZ.add(JsApiResumeDownloadTask.NAME);
            uIZ.add("launchApplication");
            uIZ.add(JsApiAddDownloadTaskStraight.NAME);
            uIZ.add(Scopes.PROFILE);
            uIZ.add("addContact");
            uIZ.add("jumpToBizProfile");
            uIZ.add("startTempSession");
            uIZ.add("quicklyAddBrandContact");
            uIZ.add("openBizChat");
            uIZ.add(f.NAME);
            uIZ.add("sendAppMessage");
            uIZ.add("sendServiceAppMessage");
            uIZ.add("getSendC2CMessageRequest");
            uIZ.add("shareQQ");
            uIZ.add("selectSingleContact");
            uIZ.add("sendAppMessageToSpecifiedContact");
            uIZ.add("sendSingleAppMessage");
            uIZ.add("openWeApp");
            uIZ.add(JsApiLaunchMiniProgram.NAME);
            uIZ.add("addCustomMenuItems");
            uIZ.add("openUrlWithExtraWebview");
            uIZ.add("enableFullScreen");
            uIZ.add("openCustomWebview");
            uIZ.add("openSpecificView");
            uIZ.add("getBrandWCPayBindCardRequest");
            uIZ.add("getTransferMoneyRequest");
            uIZ.add("verifyWCPayPassword");
            uIZ.add("getRecevieBizHongBaoRequest");
            uIZ.add("getH5PrepayRequest");
            uIZ.add("getH5TransactionRequest");
            uIZ.add("getWebPayCheckoutCounterRequst");
            uIZ.add("getWCPayRealnameVerify");
            uIZ.add("unbindBankCard");
            uIZ.add("idCardRealnameVerify");
            uIZ.add("openLuckyMoneyDetailView");
            uIZ.add("setWCPayPassword");
            uIZ.add(ax.NAME);
            uIZ.add(d.NAME);
            uIZ.add("scanLicence");
            uIZ.add(c.NAME);
            uIZ.add("getBrandWCPayRequest");
            uIZ.add("editAddress");
            uIZ.add("getLatestAddress");
            uIZ.add(j.NAME);
            uIZ.add(af.NAME);
            uIZ.add("requireSoterBiometricAuthentication");
        }
        if (uIZ.contains(str)) {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(akk);
            stringBuilder2.append(",");
            stringBuilder2.append(akk2);
            stringBuilder2.append(",");
            if (str == null) {
                str = "";
            }
            stringBuilder2.append(str);
            stringBuilder2.append(",");
            stringBuilder2.append(str4);
            stringBuilder2.append(",");
            stringBuilder2.append(e2 ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
            ab.d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", stringBuilder2.toString());
            h.pYm.X(17048, r0);
        }
        AppMethodBeat.o(9849);
    }
}
