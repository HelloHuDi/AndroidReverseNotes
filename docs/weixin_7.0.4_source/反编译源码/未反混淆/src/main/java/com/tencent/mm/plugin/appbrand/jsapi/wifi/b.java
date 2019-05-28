package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.g.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class b extends a {
    public static final int CTRL_INDEX = 318;
    public static final String NAME = "getConnectedWifi";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94372);
        HashMap hashMap;
        if (d.ide) {
            Context context = cVar.getContext();
            if (context == null) {
                ab.e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                cVar.M(i, j("fail:context is null", hashMap));
                AppMethodBeat.o(94372);
                return;
            }
            d.cP(context);
            if (com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()) {
                com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b aGy = d.aGy();
                if (aGy != null) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        ab.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        cVar.M(i, j("fail:connectivityManager is null", hashMap));
                        AppMethodBeat.o(94372);
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        ab.e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        cVar.M(i, j("fail:netInfo is null", hashMap));
                        AppMethodBeat.o(94372);
                        return;
                    } else if (activeNetworkInfo.getDetailedState() != DetailedState.CONNECTED) {
                        ab.e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", activeNetworkInfo.getDetailedState());
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        cVar.M(i, j("fail:detailState is not connected", hashMap));
                        AppMethodBeat.o(94372);
                        return;
                    } else {
                        ab.i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", aGy);
                        try {
                            hashMap = new HashMap();
                            hashMap.put("wifi", aGy.toJSONObject());
                            hashMap.put("errCode", Integer.valueOf(0));
                            cVar.M(i, j("ok", hashMap));
                            AppMethodBeat.o(94372);
                            return;
                        } catch (JSONException e) {
                            ab.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", e, "", new Object[0]);
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(12010));
                            cVar.M(i, j("fail:parse json err", hashMap));
                            AppMethodBeat.o(94372);
                            return;
                        }
                    }
                } else if (VERSION.SDK_INT < 23 || com.tencent.mm.sdk.h.b.Ms() || ((LocationManager) context.getSystemService(com.google.firebase.analytics.FirebaseAnalytics.b.LOCATION)).isProviderEnabled("gps")) {
                    ab.i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", Boolean.valueOf(g.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                    if (g.a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                        ab.e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        cVar.M(i, j("fail:currentWifi is null", hashMap));
                        AppMethodBeat.o(94372);
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                    cVar.M(i, j("fail:may be not obtain GPS Perrmission", hashMap));
                    ab.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
                    AppMethodBeat.o(94372);
                    return;
                } else {
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(12006));
                    cVar.M(i, j("fail:may be not open GPS", hashMap));
                    ab.e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
                    AppMethodBeat.o(94372);
                    return;
                }
            }
            ab.e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            cVar.M(i, j("fail:wifi is disable", hashMap));
            AppMethodBeat.o(94372);
            return;
        }
        ab.e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        cVar.M(i, j("fail:not invoke startWifi", hashMap));
        AppMethodBeat.o(94372);
    }
}
