package com.tencent.p177mm.plugin.webview.p580ui.tools.jsapi;

import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C19285af;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33246ax;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiResumeDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiAddDownloadTaskStraight;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiCancelDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiInstallDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiPauseDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiQueryDownloadTask;
import com.tencent.p177mm.plugin.appbrand.jsapi.bio.face.C33253d;
import com.tencent.p177mm.plugin.appbrand.jsapi.fakenative.C19365c;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseMedia;
import com.tencent.p177mm.plugin.appbrand.jsapi.media.JsApiChooseVideo;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.JsApiLaunchMiniProgram;
import com.tencent.p177mm.plugin.appbrand.jsapi.p304e.C2278j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p897a.C38251e;
import com.tencent.p177mm.plugin.appbrand.jsapi.share.C42571f;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.plugin.webview.stub.C40281e;
import com.tencent.p177mm.pluginsdk.p597ui.tools.C30152u;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.jsapi.l */
public final class C46445l {
    private static String iCz = "";
    private static String jVi = "";
    private static Set<String> uIZ = new HashSet();
    private static String unl = "";

    static {
        AppMethodBeat.m2504i(9850);
        AppMethodBeat.m2505o(9850);
    }

    /* renamed from: a */
    public static void m87598a(Map<String, Object> map, boolean z, String str, String str2) {
        AppMethodBeat.m2504i(9847);
        if (map != null) {
            map.put("fromMenu", Boolean.valueOf(z));
            map.put("keyParam", str);
            if (C5046bo.isNullOrNil((String) map.get("appId"))) {
                map.put("appId", str2);
            }
        }
        AppMethodBeat.m2505o(9847);
    }

    /* renamed from: a */
    public static void m87597a(C40281e c40281e) {
        String str;
        AppMethodBeat.m2504i(9848);
        Object obj = c40281e == null ? 1 : null;
        if (obj != null) {
            try {
                str = "";
            } catch (Exception e) {
                C4990ab.m7420w("MicroMsg.WebViewSecurityUtil", "report, ex = " + e.getMessage());
                AppMethodBeat.m2505o(9848);
                return;
            }
        }
        str = c40281e.cYY();
        jVi = str;
        iCz = obj != null ? "" : c40281e.getCurrentUrl();
        unl = obj != null ? "" : c40281e.cYZ();
        AppMethodBeat.m2505o(9848);
    }

    /* renamed from: C */
    public static void m87596C(String str, Map<String, Object> map) {
        AppMethodBeat.m2504i(9849);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.WebViewSecurityUtil", "function name is null or nil.");
            AppMethodBeat.m2505o(9849);
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
            e = C5046bo.m7546e((Boolean) map.get("fromMenu"));
            str3 = C5046bo.nullAsNil((String) map.get("keyParam"));
            str4 = C5046bo.m7532bc((String) map.get("appId"), "");
            e2 = C5046bo.m7546e((Boolean) map.get("isSuccess"));
            h = C5046bo.m7567h((Integer) map.get("permissionValue"));
            h2 = C5046bo.m7567h((Integer) map.get("baseErrorCode"));
            h3 = C5046bo.m7567h((Integer) map.get("jsapiErrorCode"));
        } else {
            h3 = 0;
            h2 = 0;
            h = 0;
            e2 = false;
            e = false;
        }
        String akk = C30152u.akk(C5046bo.nullAsNil(jVi));
        String akk2 = C30152u.akk(C5046bo.nullAsNil(iCz));
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
        C4990ab.m7411d("MicroMsg.WebViewSecurityUtil", "report: %s", stringBuilder.toString());
        C7060h.pYm.mo8374X(10417, r0);
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
            uIZ.add(C38251e.NAME);
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
            uIZ.add(C42571f.NAME);
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
            uIZ.add(C33246ax.NAME);
            uIZ.add(C33253d.NAME);
            uIZ.add("scanLicence");
            uIZ.add(C19365c.NAME);
            uIZ.add("getBrandWCPayRequest");
            uIZ.add("editAddress");
            uIZ.add("getLatestAddress");
            uIZ.add(C2278j.NAME);
            uIZ.add(C19285af.NAME);
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
            C4990ab.m7411d("MicroMsg.WebViewSecurityUtil", "report importantJsApi %s", stringBuilder2.toString());
            C7060h.pYm.mo8374X(17048, r0);
        }
        AppMethodBeat.m2505o(9849);
    }
}
