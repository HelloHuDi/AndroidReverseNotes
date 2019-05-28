package com.tencent.p177mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.p146d.C17821n;
import com.tencent.luggage.p146d.C37393a.C32183a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.loader.BuildConfig;
import com.tencent.p177mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.p177mm.plugin.appbrand.p328r.C19679b;
import com.tencent.p177mm.plugin.webview.luggage.jsapi.C22840bc.C22841a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.webview.luggage.jsapi.o */
public class C43904o extends C22840bc<C17821n> {
    public final String name() {
        return JsApiGetInstallState.NAME;
    }

    public final int biG() {
        return 0;
    }

    /* renamed from: b */
    public final void mo9618b(C32183a c32183a) {
        AppMethodBeat.m2504i(6310);
        C4990ab.m7416i("Micromsg.JsApiGetInstallState", "invokeInOwn");
        JSONObject jSONObject = c32183a.bPa.bOf;
        Context context = ((C17821n) c32183a.bOZ).mContext;
        JSONArray optJSONArray = jSONObject.optJSONArray(DownloadInfoColumns.PACKAGENAME);
        if (optJSONArray != null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            Object obj = null;
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    String optString = optJSONArray.optString(i);
                    PackageInfo packageInfo = C19679b.getPackageInfo(context, optString);
                    int i2 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                    C4990ab.m7416i("Micromsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", version = " + i2 + ", versionName = " + str);
                    if (obj == null && i2 > 0) {
                        obj = 1;
                    }
                    jSONObject2.put(optString, i2);
                    jSONObject3.put(optString, str);
                    i++;
                } catch (Exception e) {
                }
            }
            HashMap hashMap = new HashMap();
            hashMap.put("result", jSONObject2.toString());
            hashMap.put("versionName", jSONObject3.toString());
            if (obj != null) {
                c32183a.mo52825c("get_install_state:yes", hashMap);
                AppMethodBeat.m2505o(6310);
                return;
            }
            c32183a.mo52824a("get_install_state:no", null);
            AppMethodBeat.m2505o(6310);
            return;
        }
        String optString2 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        if (C5046bo.isNullOrNil(optString2)) {
            C4990ab.m7416i("Micromsg.JsApiGetInstallState", "packageName is null or nil");
            c32183a.mo52824a("get_install_state:no_null_packageName", null);
            AppMethodBeat.m2505o(6310);
            return;
        }
        PackageInfo packageInfo2 = C19679b.getPackageInfo(context, optString2);
        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
        C4990ab.m7416i("Micromsg.JsApiGetInstallState", "doGetInstallState, packageName = " + optString2 + ", version = " + i3 + ", versionName = " + str2);
        if (packageInfo2 == null) {
            c32183a.mo52824a("get_install_state:no", null);
            AppMethodBeat.m2505o(6310);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("versionName", str2);
        c32183a.mo52825c("get_install_state:yes_".concat(String.valueOf(i3)), hashMap2);
        AppMethodBeat.m2505o(6310);
    }

    /* renamed from: a */
    public final void mo9617a(Context context, String str, C22841a c22841a) {
    }
}
