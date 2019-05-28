package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector$2;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.a;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b;
import com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public final class d {
    private static boolean idp = false;
    private static WeakReference<a> idq = null;
    private static b idr = null;
    private static a ids;
    private static Context mContext;

    public static void cP(Context context) {
        AppMethodBeat.i(94383);
        if (!(idp || context == null)) {
            Context context2 = ah.getContext();
            mContext = context2;
            WifiManager wifiManager = (WifiManager) context2.getSystemService("wifi");
            if (wifiManager != null) {
                c.bCU = wifiManager;
                idp = true;
            }
        }
        AppMethodBeat.o(94383);
    }

    public static b aGy() {
        AppMethodBeat.i(94384);
        WifiInfo connectionInfo = c.getConnectionInfo();
        String str = "";
        String str2 = "";
        if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()))) {
            str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Cc(connectionInfo.getSSID());
            str2 = bo.bc(connectionInfo.getBSSID(), "");
        }
        b bVar;
        if (idr != null && idr.idi.compareTo(str) == 0 && idr.idj.compareTo(str2) == 0) {
            bVar = idr;
            AppMethodBeat.o(94384);
            return bVar;
        } else if (connectionInfo != null) {
            aGz();
            bVar = idr;
            AppMethodBeat.o(94384);
            return bVar;
        } else {
            AppMethodBeat.o(94384);
            return null;
        }
    }

    public static c aGz() {
        AppMethodBeat.i(94385);
        c cVar = new c();
        idr = null;
        if (idp && c.isWifiEnabled()) {
            c.startScan();
            List<ScanResult> scanResults = c.getScanResults();
            cVar.ido = new ArrayList();
            cVar.hAa = "ok";
            if (scanResults != null) {
                String str;
                ab.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", scanResults, Integer.valueOf(scanResults.size()));
                WifiInfo connectionInfo = c.getConnectionInfo();
                ab.d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", connectionInfo);
                String str2;
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str2 = null;
                    str = null;
                } else {
                    str = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Cc(connectionInfo.getSSID());
                    str2 = bo.bc(connectionInfo.getBSSID(), "");
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.a(scanResult);
                        if (a == 0 || a == 2) {
                            int i;
                            b bVar = new b();
                            bVar.idi = com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.Cc(scanResult.SSID);
                            bVar.idj = bo.bc(scanResult.BSSID, "");
                            bVar.idk = c.oI(scanResult.level);
                            bVar.idl = a == 2;
                            if (str == null || str2 == null || bVar.idi.compareTo(str) != 0 || bVar.idj.compareTo(str2) != 0) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                idr = bVar;
                            }
                            cVar.ido.add(bVar);
                        }
                    }
                }
            } else {
                ab.e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (idp) {
            cVar.hAa = "wifi is disable";
        } else {
            cVar.hAa = "sdk not init";
        }
        AppMethodBeat.o(94385);
        return cVar;
    }

    public static void D(String str, String str2, String str3) {
        int i;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2 = null;
        AppMethodBeat.i(94386);
        if (idq != null) {
            a aVar = (a) idq.get();
            if (!(aVar == null || aVar.aGB())) {
                aVar.Cb("duplicated request");
            }
        }
        a aVar2 = new a(ids, mContext);
        ab.i("MicroMsg.WiFiConnector", "ssid:" + str + " bssid:" + str2 + " psw:" + str3);
        aVar2.idi = str;
        aVar2.idj = str2;
        if (TextUtils.isEmpty(str3)) {
            i = 0;
        } else {
            i = 2;
        }
        if (str == null || str.length() <= 0) {
            wifiConfiguration = null;
        } else {
            wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            wifiConfiguration.hiddenSSID = true;
            switch (i) {
                case 2:
                    if (str3.length() != 0) {
                        if (!str3.matches("[0-9A-Fa-f]{64}")) {
                            wifiConfiguration.preSharedKey = "\"" + str3 + '\"';
                            break;
                        } else {
                            wifiConfiguration.preSharedKey = str3;
                            break;
                        }
                    }
                    break;
                default:
                    wifiConfiguration.allowedKeyManagement.set(0);
                    break;
            }
            wifiConfiguration.status = 2;
        }
        List configuredNetworks = c.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration2 = b.a(str, i, configuredNetworks);
        }
        if (wifiConfiguration != null) {
            if (wifiConfiguration2 != null) {
                boolean z;
                if (b.bl(str, i)) {
                    c.saveConfiguration();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    wifiConfiguration.networkId = b.b(wifiConfiguration);
                    if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.idD) {
                        aVar2.idA = true;
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
            }
            if (wifiConfiguration.networkId == com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.idD) {
                wifiConfiguration.networkId = b.b(wifiConfiguration);
            }
            if (wifiConfiguration.networkId != com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d.idD && aVar2.a(wifiConfiguration)) {
                ab.i("MicroMsg.wifi_event", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING);
                aVar2.oE(1);
                aVar2.idw = wifiConfiguration;
                if (!aVar2.ide) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
                    aVar2.idf = new WiFiConnector$2(aVar2);
                    aVar2.idt.registerReceiver(aVar2.idf, intentFilter);
                    aVar2.ide = true;
                    ab.i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
                }
                aVar2.mHandler.sendEmptyMessageDelayed(1, 13000);
                idq = new WeakReference(aVar2);
                AppMethodBeat.o(94386);
            }
        }
        aVar2.i(false, "fail to connect wifi:invalid network id");
        ab.i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        idq = new WeakReference(aVar2);
        AppMethodBeat.o(94386);
    }

    public static void a(a aVar) {
        ids = aVar;
    }
}
