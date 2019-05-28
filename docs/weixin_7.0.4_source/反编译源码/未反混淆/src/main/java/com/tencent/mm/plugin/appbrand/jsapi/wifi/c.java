package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics.b;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class c extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    public static class a extends ah {
        private static final int CTRL_INDEX = 321;
        private static final String NAME = "onGetWifiList";
    }

    public final void a(com.tencent.mm.plugin.appbrand.jsapi.c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94373);
        HashMap hashMap;
        if (d.ide) {
            Context context = cVar.getContext();
            if (context == null) {
                ab.e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                cVar.M(i, j("fail:context is null", hashMap));
                AppMethodBeat.o(94373);
                return;
            }
            d.cP(context);
            if (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.c aGz = d.aGz();
                if (aGz.hAa.equals("ok")) {
                    ab.i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", Integer.valueOf(aGz.ido.size()));
                    if (aGz.ido.size() == 0) {
                        if (VERSION.SDK_INT < 23 || ((LocationManager) context.getSystemService(b.LOCATION)).isProviderEnabled("gps")) {
                            try {
                                ab.i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", Boolean.valueOf(g.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                                if (!g.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                                    hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                                    cVar.M(i, j("fail:may be not obtain GPS Perrmission", hashMap));
                                    ab.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                                    AppMethodBeat.o(94373);
                                    return;
                                }
                            } catch (JSONException e) {
                                ab.printErrStackTrace("MicroMsg.JsApiGetWifiList", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                cVar.M(i, j("fail:parse json err", hashMap));
                                AppMethodBeat.o(94373);
                                return;
                            }
                        }
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12006));
                        cVar.M(i, j("fail:may be not open GPS", hashMap));
                        ab.e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                        AppMethodBeat.o(94373);
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(0));
                    cVar.M(i, j("ok", hashMap));
                    ab.d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", aGz);
                    a aVar = new a();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("wifiList", aGz.aGx());
                    aVar.b(cVar, 0).t(hashMap2).aCj();
                    AppMethodBeat.o(94373);
                    return;
                }
                ab.e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", aGz.hAa);
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                cVar.M(i, j("fail:" + aGz.hAa, hashMap));
                AppMethodBeat.o(94373);
                return;
            }
            ab.e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            cVar.M(i, j("fail:wifi is disable", hashMap));
            AppMethodBeat.o(94373);
            return;
        }
        ab.e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        cVar.M(i, j("fail:not invoke startWifi", hashMap));
        AppMethodBeat.o(94373);
    }
}
