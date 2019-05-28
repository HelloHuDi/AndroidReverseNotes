package com.tencent.mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.b.b;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.jsapi.ah;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d;
import com.tencent.mm.plugin.appbrand.widget.b.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    public static class a extends ah {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnected";
    }

    public final void a(final c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(94371);
        HashMap hashMap;
        if (!d.ide) {
            ab.e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            cVar.M(i, j("fail:not invoke startWifi", hashMap));
            AppMethodBeat.o(94371);
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            ab.e("MicroMsg.JsApiConenctWifi", "params is invalid");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            cVar.M(i, j("fail:invalid data", hashMap));
            AppMethodBeat.o(94371);
        } else {
            Context context = cVar.getContext();
            if (context == null) {
                ab.e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                cVar.M(i, j("fail:context is null", hashMap));
                AppMethodBeat.o(94371);
                return;
            }
            d.cP(context);
            if (!com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c.isWifiEnabled()) {
                ab.e("MicroMsg.JsApiConenctWifi", "wifi is disable");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
                cVar.M(i, j("fail:wifi is disable", hashMap));
                AppMethodBeat.o(94371);
            } else if (cVar.asD() != b.FOREGROUND) {
                ab.e("MicroMsg.JsApiConenctWifi", "current state :%s isn't foreground", cVar.asD());
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED));
                cVar.M(i, j("fail:weapp in background", hashMap));
                AppMethodBeat.o(94371);
            } else {
                final com.tencent.luggage.c.a.a aVar = (com.tencent.luggage.c.a.a) e.B(com.tencent.luggage.c.a.a.class);
                final j av = aVar.av(context);
                al.d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(94367);
                        cVar.asF().b(av);
                        AppMethodBeat.o(94367);
                    }
                });
                final c cVar2 = cVar;
                final int i2 = i;
                d.a(new com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.a() {
                    public final void Ca(String str) {
                        AppMethodBeat.i(94369);
                        d.a(null);
                        al.d(new Runnable() {
                            public final void run() {
                                AppMethodBeat.i(94368);
                                if (av != null) {
                                    aVar.a(av);
                                }
                                AppMethodBeat.o(94368);
                            }
                        });
                        HashMap hashMap;
                        if (str.equals("ok")) {
                            com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.b aGy = d.aGy();
                            ab.i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", aGy);
                            if (aGy == null) {
                                ab.e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12006));
                                cVar2.M(i2, a.this.j("ok:can't gain current wifi may be not open GPS", hashMap));
                                AppMethodBeat.o(94369);
                                return;
                            }
                            try {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("wifi", aGy.toJSONObject());
                                hashMap2.put("errCode", Integer.valueOf(0));
                                cVar2.M(i2, a.this.j("ok", hashMap2));
                                AppMethodBeat.o(94369);
                                return;
                            } catch (JSONException e) {
                                ab.e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
                                ab.printErrStackTrace("MicroMsg.JsApiConenctWifi", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                cVar2.M(i2, a.this.j("fail:parse json err", hashMap));
                                AppMethodBeat.o(94369);
                                return;
                            }
                        }
                        hashMap = new HashMap();
                        if (str.equals("duplicated request")) {
                            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_CONNECT_FAILED));
                        } else if (str.equals("password error")) {
                            hashMap.put("errCode", Integer.valueOf(12002));
                        } else if (str.equals("wifi config may be expired")) {
                            hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_READ_FAILED));
                        } else {
                            hashMap.put("errCode", Integer.valueOf(12003));
                        }
                        ab.e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", str);
                        cVar2.M(i2, a.this.j("fail:".concat(String.valueOf(str)), hashMap));
                        AppMethodBeat.o(94369);
                    }
                });
                g.a(cVar.getAppId(), new g.c() {
                    public final void onDestroy() {
                        AppMethodBeat.i(94370);
                        ab.d("MicroMsg.JsApiConenctWifi", "remove listener");
                        d.a(null);
                        g.b(cVar.getAppId(), this);
                        AppMethodBeat.o(94370);
                    }
                });
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    ab.e("MicroMsg.JsApiConenctWifi", "params is invalid");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN));
                    cVar.M(i, j("fail:invalid data", hashMap));
                    AppMethodBeat.o(94371);
                    return;
                }
                ab.i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", optString, optString2);
                d.D(optString, optString2, optString3);
                AppMethodBeat.o(94371);
            }
        }
    }
}
