package com.tencent.mm.plugin.webview.luggage.jsapi;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.luggage.d.a.a;
import com.tencent.luggage.d.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.appbrand.jsapi.appdownload.JsApiGetInstallState;
import com.tencent.mm.plugin.appbrand.r.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class o extends bc<n> {
    public final String name() {
        return JsApiGetInstallState.NAME;
    }

    public final int biG() {
        return 0;
    }

    public final void b(a aVar) {
        AppMethodBeat.i(6310);
        ab.i("Micromsg.JsApiGetInstallState", "invokeInOwn");
        JSONObject jSONObject = aVar.bPa.bOf;
        Context context = ((n) aVar.bOZ).mContext;
        JSONArray optJSONArray = jSONObject.optJSONArray(DownloadInfoColumns.PACKAGENAME);
        if (optJSONArray != null) {
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            Object obj = null;
            int i = 0;
            while (i < optJSONArray.length()) {
                try {
                    String optString = optJSONArray.optString(i);
                    PackageInfo packageInfo = b.getPackageInfo(context, optString);
                    int i2 = packageInfo == null ? 0 : packageInfo.versionCode;
                    String str = packageInfo == null ? BuildConfig.COMMAND : packageInfo.versionName;
                    ab.i("Micromsg.JsApiGetInstallState", "getInstallState, packageName = " + optString + ", version = " + i2 + ", versionName = " + str);
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
                aVar.c("get_install_state:yes", hashMap);
                AppMethodBeat.o(6310);
                return;
            }
            aVar.a("get_install_state:no", null);
            AppMethodBeat.o(6310);
            return;
        }
        String optString2 = jSONObject.optString(DownloadInfoColumns.PACKAGENAME);
        if (bo.isNullOrNil(optString2)) {
            ab.i("Micromsg.JsApiGetInstallState", "packageName is null or nil");
            aVar.a("get_install_state:no_null_packageName", null);
            AppMethodBeat.o(6310);
            return;
        }
        PackageInfo packageInfo2 = b.getPackageInfo(context, optString2);
        int i3 = packageInfo2 == null ? 0 : packageInfo2.versionCode;
        String str2 = packageInfo2 == null ? BuildConfig.COMMAND : packageInfo2.versionName;
        ab.i("Micromsg.JsApiGetInstallState", "doGetInstallState, packageName = " + optString2 + ", version = " + i3 + ", versionName = " + str2);
        if (packageInfo2 == null) {
            aVar.a("get_install_state:no", null);
            AppMethodBeat.o(6310);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("versionName", str2);
        aVar.c("get_install_state:yes_".concat(String.valueOf(i3)), hashMap2);
        AppMethodBeat.o(6310);
    }

    public final void a(Context context, String str, bc.a aVar) {
    }
}
