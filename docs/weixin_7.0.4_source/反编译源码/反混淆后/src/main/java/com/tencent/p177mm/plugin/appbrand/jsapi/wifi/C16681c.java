package com.tencent.p177mm.plugin.appbrand.jsapi.wifi;

import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.os.Build.VERSION;
import com.google.firebase.analytics.FirebaseAnalytics.C8741b;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.p147g.C0991g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C27137c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C27138d;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C27140c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.c */
public final class C16681c extends C10296a {
    public static final int CTRL_INDEX = 317;
    public static final String NAME = "getWifiList";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.c$a */
    public static class C16682a extends C42467ah {
        private static final int CTRL_INDEX = 321;
        private static final String NAME = "onGetWifiList";
    }

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94373);
        HashMap hashMap;
        if (C16683d.ide) {
            Context context = c2241c.getContext();
            if (context == null) {
                C4990ab.m7412e("MicroMsg.JsApiGetWifiList", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                c2241c.mo6107M(i, mo73394j("fail:context is null", hashMap));
                AppMethodBeat.m2505o(94373);
                return;
            }
            C27138d.m43130cP(context);
            if (C27140c.isWifiEnabled()) {
                C27137c aGz = C27138d.aGz();
                if (aGz.hAa.equals("ok")) {
                    C4990ab.m7417i("MicroMsg.JsApiGetWifiList", "onGetWifiList size:%d", Integer.valueOf(aGz.ido.size()));
                    if (aGz.ido.size() == 0) {
                        if (VERSION.SDK_INT < 23 || ((LocationManager) context.getSystemService(C8741b.LOCATION)).isProviderEnabled("gps")) {
                            try {
                                C4990ab.m7417i("MicroMsg.JsApiGetWifiList", "checkLocation:%b", Boolean.valueOf(C0991g.m2252a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)));
                                if (!C0991g.m2252a((Activity) context, "android.permission.ACCESS_COARSE_LOCATION", 64, null, null)) {
                                    hashMap = new HashMap();
                                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_DISCONNECT));
                                    c2241c.mo6107M(i, mo73394j("fail:may be not obtain GPS Perrmission", hashMap));
                                    C4990ab.m7412e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not obtain GPS Perrmission");
                                    AppMethodBeat.m2505o(94373);
                                    return;
                                }
                            } catch (JSONException e) {
                                C4990ab.printErrStackTrace("MicroMsg.JsApiGetWifiList", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                c2241c.mo6107M(i, mo73394j("fail:parse json err", hashMap));
                                AppMethodBeat.m2505o(94373);
                                return;
                            }
                        }
                        hashMap = new HashMap();
                        hashMap.put("errCode", Integer.valueOf(12006));
                        c2241c.mo6107M(i, mo73394j("fail:may be not open GPS", hashMap));
                        C4990ab.m7412e("MicroMsg.JsApiGetWifiList", "wifiList is empty, may be not open GPS");
                        AppMethodBeat.m2505o(94373);
                        return;
                    }
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(0));
                    c2241c.mo6107M(i, mo73394j("ok", hashMap));
                    C4990ab.m7411d("MicroMsg.JsApiGetWifiList", "onGetWifiList %s", aGz);
                    C16682a c16682a = new C16682a();
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("wifiList", aGz.aGx());
                    c16682a.mo61030b(c2241c, 0).mo34958t(hashMap2).aCj();
                    AppMethodBeat.m2505o(94373);
                    return;
                }
                C4990ab.m7413e("MicroMsg.JsApiGetWifiList", "error, mErrorMsg:%s", aGz.hAa);
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                c2241c.mo6107M(i, mo73394j("fail:" + aGz.hAa, hashMap));
                AppMethodBeat.m2505o(94373);
                return;
            }
            C4990ab.m7412e("MicroMsg.JsApiGetWifiList", "wifi is disable,invoke fail!");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
            c2241c.mo6107M(i, mo73394j("fail:wifi is disable", hashMap));
            AppMethodBeat.m2505o(94373);
            return;
        }
        C4990ab.m7412e("MicroMsg.JsApiGetWifiList", "not invoke startWifi");
        hashMap = new HashMap();
        hashMap.put("errCode", Integer.valueOf(12000));
        c2241c.mo6107M(i, mo73394j("fail:not invoke startWifi", hashMap));
        AppMethodBeat.m2505o(94373);
    }
}
