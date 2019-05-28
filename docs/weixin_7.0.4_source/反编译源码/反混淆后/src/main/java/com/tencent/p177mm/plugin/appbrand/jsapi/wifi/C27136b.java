package com.tencent.p177mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.DetailedState;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C19528b;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C27138d;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C27140c;
import com.tencent.p177mm.sdk.p609h.C4971b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.b */
public final class C27136b extends C10296a {
    public static final int CTRL_INDEX = 318;
    public static final String NAME = "getConnectedWifi";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94372);
        HashMap hashMap;
        if (C16683d.ide) {
            Context context = c2241c.getContext();
            if (context == null) {
                C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                c2241c.mo6107M(i, mo73394j("fail:context is null", hashMap));
                AppMethodBeat.m2505o(94372);
                return;
            }
            C27138d.m43130cP(context);
            if (C27140c.isWifiEnabled()) {
                C19528b aGy = C27138d.aGy();
                if (aGy != null) {
                    ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                    if (connectivityManager == null) {
                        C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        c2241c.mo6107M(i, mo73394j("fail:connectivityManager is null", hashMap));
                        AppMethodBeat.m2505o(94372);
                        return;
                    }
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo == null) {
                        C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "netInfo is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        c2241c.mo6107M(i, mo73394j("fail:netInfo is null", hashMap));
                        AppMethodBeat.m2505o(94372);
                        return;
                    } else if (activeNetworkInfo.getDetailedState() != DetailedState.CONNECTED) {
                        C4990ab.m7413e("MicroMsg.JsApiGetConnectedWifi", "ConnectivityManager is null, detailState:%s", activeNetworkInfo.getDetailedState());
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        c2241c.mo6107M(i, mo73394j("fail:detailState is not connected", hashMap));
                        AppMethodBeat.m2505o(94372);
                        return;
                    } else {
                        C4990ab.m7417i("MicroMsg.JsApiGetConnectedWifi", "[invoke]currentWifi:%s", aGy);
                        try {
                            hashMap = new HashMap();
                            hashMap.put("wifi", aGy.toJSONObject());
                            hashMap.put("errCode", Integer.valueOf(0));
                            c2241c.mo6107M(i, mo73394j("ok", hashMap));
                            AppMethodBeat.m2505o(94372);
                            return;
                        } catch (JSONException e) {
                            C4990ab.printErrStackTrace("MicroMsg.JsApiGetConnectedWifi", e, "", new Object[0]);
                            hashMap = new HashMap();
                            hashMap.put("errCode", Integer.valueOf(12010));
                            c2241c.mo6107M(i, mo73394j("fail:parse json err", hashMap));
                            AppMethodBeat.m2505o(94372);
                            return;
                        }
                    }
                } else if (VERSION.SDK_INT < 23 || C4971b.m7363Ms() || ((LocationManager) context.getSystemService(C8741b.LOCATION)).isProviderEnabled("gps")) {
                    C4990ab.m7417i("MicroMsg.JsApiGetConnectedWifi", "checkLocation:%b", Boolean.valueOf(C0991g.m2252a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                    if (C0991g.m2252a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                        C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "currentWifi is null");
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12010));
                        c2241c.mo6107M(i, mo73394j("fail:currentWifi is null", hashMap));
                        AppMethodBeat.m2505o(94372);
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                    c2241c.mo6107M(i, mo73394j("fail:may be not obtain GPS Perrmission", hashMap));
                    C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not obtain GPS Perrmission");
                    AppMethodBeat.m2505o(94372);
                    return;
                } else {
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(12006));
                    c2241c.mo6107M(i, mo73394j("fail:may be not open GPS", hashMap));
                    C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "wifiList is empty, may be not open GPS");
                    AppMethodBeat.m2505o(94372);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            c2241c.mo6107M(i, mo73394j("fail:wifi is disable", hashMap));
            AppMethodBeat.m2505o(94372);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiGetConnectedWifi", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        c2241c.mo6107M(i, mo73394j("fail:not invoke startWifi", hashMap));
        AppMethodBeat.m2505o(94372);
    }
}
