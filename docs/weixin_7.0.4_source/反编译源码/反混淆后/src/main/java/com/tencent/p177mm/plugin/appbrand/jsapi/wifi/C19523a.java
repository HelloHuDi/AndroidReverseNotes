package com.tencent.p177mm.plugin.appbrand.jsapi.wifi;

import android.content.Context;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.luggage.p1170a.C37384e;
import com.tencent.luggage.p1433c.p1434a.C31256a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33186c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42467ah;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C10565a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C19528b;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.C27138d;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C27140c;
import com.tencent.p177mm.plugin.appbrand.p281b.C45524b;
import com.tencent.p177mm.plugin.appbrand.widget.p337b.C38571j;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.a */
public final class C19523a extends C10296a {
    public static final int CTRL_INDEX = 316;
    public static final String NAME = "connectWifi";

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.a$a */
    public static class C19527a extends C42467ah {
        private static final int CTRL_INDEX = 322;
        private static final String NAME = "onWifiConnected";
    }

    /* renamed from: a */
    public final void mo5994a(final C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(94371);
        HashMap hashMap;
        if (!C16683d.ide) {
            C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "not invoke startWifi");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12000));
            c2241c.mo6107M(i, mo73394j("fail:not invoke startWifi", hashMap));
            AppMethodBeat.m2505o(94371);
        } else if (jSONObject == null || !jSONObject.has("SSID")) {
            C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "params is invalid");
            hashMap = new HashMap();
            hashMap.put("errCode", Integer.valueOf(12010));
            c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
            AppMethodBeat.m2505o(94371);
        } else {
            Context context = c2241c.getContext();
            if (context == null) {
                C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "mContext is null, invoke fail!");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(12010));
                c2241c.mo6107M(i, mo73394j("fail:context is null", hashMap));
                AppMethodBeat.m2505o(94371);
                return;
            }
            C27138d.m43130cP(context);
            if (!C27140c.isWifiEnabled()) {
                C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "wifi is disable");
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_HANDSHAKE_FAIL));
                c2241c.mo6107M(i, mo73394j("fail:wifi is disable", hashMap));
                AppMethodBeat.m2505o(94371);
            } else if (c2241c.asD() != C45524b.FOREGROUND) {
                C4990ab.m7413e("MicroMsg.JsApiConenctWifi", "current state :%s isn't foreground", c2241c.asD());
                hashMap = new HashMap();
                hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_ERROR_CONNECT_FAILED));
                c2241c.mo6107M(i, mo73394j("fail:weapp in background", hashMap));
                AppMethodBeat.m2505o(94371);
            } else {
                final C31256a c31256a = (C31256a) C37384e.m62985B(C31256a.class);
                final C38571j av = c31256a.mo34802av(context);
                C5004al.m7441d(new Runnable() {
                    public final void run() {
                        AppMethodBeat.m2504i(94367);
                        c2241c.asF().mo6468b(av);
                        AppMethodBeat.m2505o(94367);
                    }
                });
                final C2241c c2241c2 = c2241c;
                final int i2 = i;
                C27138d.m43129a(new C10565a() {

                    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.a$2$1 */
                    class C195251 implements Runnable {
                        C195251() {
                        }

                        public final void run() {
                            AppMethodBeat.m2504i(94368);
                            if (av != null) {
                                c31256a.mo34801a(av);
                            }
                            AppMethodBeat.m2505o(94368);
                        }
                    }

                    /* renamed from: Ca */
                    public final void mo22072Ca(String str) {
                        AppMethodBeat.m2504i(94369);
                        C27138d.m43129a(null);
                        C5004al.m7441d(new C195251());
                        HashMap hashMap;
                        if (str.equals("ok")) {
                            C19528b aGy = C27138d.aGy();
                            C4990ab.m7417i("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]currentWifi:%s", aGy);
                            if (aGy == null) {
                                C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "[onWiFiConnect]currentWIfi is null");
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12006));
                                c2241c2.mo6107M(i2, C19523a.this.mo73394j("ok:can't gain current wifi may be not open GPS", hashMap));
                                AppMethodBeat.m2505o(94369);
                                return;
                            }
                            try {
                                HashMap hashMap2 = new HashMap();
                                hashMap2.put("wifi", aGy.toJSONObject());
                                hashMap2.put("errCode", Integer.valueOf(0));
                                c2241c2.mo6107M(i2, C19523a.this.mo73394j("ok", hashMap2));
                                AppMethodBeat.m2505o(94369);
                                return;
                            } catch (JSONException e) {
                                C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "IConnectWiFiCallback is error");
                                C4990ab.printErrStackTrace("MicroMsg.JsApiConenctWifi", e, "", new Object[0]);
                                hashMap = new HashMap();
                                hashMap.put("errCode", Integer.valueOf(12010));
                                c2241c2.mo6107M(i2, C19523a.this.mo73394j("fail:parse json err", hashMap));
                                AppMethodBeat.m2505o(94369);
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
                        C4990ab.m7413e("MicroMsg.JsApiConenctWifi", "[IConnectWiFiCallback]errMsg:%s", str);
                        c2241c2.mo6107M(i2, C19523a.this.mo73394j("fail:".concat(String.valueOf(str)), hashMap));
                        AppMethodBeat.m2505o(94369);
                    }
                });
                C33183g.m54274a(c2241c.getAppId(), new C33186c() {
                    public final void onDestroy() {
                        AppMethodBeat.m2504i(94370);
                        C4990ab.m7410d("MicroMsg.JsApiConenctWifi", "remove listener");
                        C27138d.m43129a(null);
                        C33183g.m54276b(c2241c.getAppId(), this);
                        AppMethodBeat.m2505o(94370);
                    }
                });
                String optString = jSONObject.optString("SSID");
                String optString2 = jSONObject.optString("BSSID");
                String optString3 = jSONObject.optString("password");
                if (optString.equals("")) {
                    C4990ab.m7412e("MicroMsg.JsApiConenctWifi", "params is invalid");
                    hashMap = new HashMap();
                    hashMap.put("errCode", Integer.valueOf(TXCStreamDownloader.TXE_DOWNLOAD_INFO_PLAY_BEGIN));
                    c2241c.mo6107M(i, mo73394j("fail:invalid data", hashMap));
                    AppMethodBeat.m2505o(94371);
                    return;
                }
                C4990ab.m7417i("MicroMsg.JsApiConenctWifi", "ssid:%s, bSsid:%s is connecting", optString, optString2);
                C27138d.m43128D(optString, optString2, optString3);
                AppMethodBeat.m2505o(94371);
            }
        }
    }
}
