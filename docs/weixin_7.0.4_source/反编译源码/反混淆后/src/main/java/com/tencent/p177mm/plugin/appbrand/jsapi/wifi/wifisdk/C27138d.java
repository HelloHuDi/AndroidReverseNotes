package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk;

import android.content.Context;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C19531d;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C27139b;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C27140c;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.C38407a;
import com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.WiFiConnector$2;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClientBase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.d */
public final class C27138d {
    private static boolean idp = false;
    private static WeakReference<C38407a> idq = null;
    private static C19528b idr = null;
    private static C10565a ids;
    private static Context mContext;

    /* renamed from: cP */
    public static void m43130cP(Context context) {
        AppMethodBeat.m2504i(94383);
        if (!(idp || context == null)) {
            Context context2 = C4996ah.getContext();
            mContext = context2;
            WifiManager wifiManager = (WifiManager) context2.getSystemService("wifi");
            if (wifiManager != null) {
                C27140c.bCU = wifiManager;
                idp = true;
            }
        }
        AppMethodBeat.m2505o(94383);
    }

    public static C19528b aGy() {
        AppMethodBeat.m2504i(94384);
        WifiInfo connectionInfo = C27140c.getConnectionInfo();
        String str = "";
        String str2 = "";
        if (!(connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID()))) {
            str = C19531d.m30248Cc(connectionInfo.getSSID());
            str2 = C5046bo.m7532bc(connectionInfo.getBSSID(), "");
        }
        C19528b c19528b;
        if (idr != null && idr.idi.compareTo(str) == 0 && idr.idj.compareTo(str2) == 0) {
            c19528b = idr;
            AppMethodBeat.m2505o(94384);
            return c19528b;
        } else if (connectionInfo != null) {
            C27138d.aGz();
            c19528b = idr;
            AppMethodBeat.m2505o(94384);
            return c19528b;
        } else {
            AppMethodBeat.m2505o(94384);
            return null;
        }
    }

    public static C27137c aGz() {
        AppMethodBeat.m2504i(94385);
        C27137c c27137c = new C27137c();
        idr = null;
        if (idp && C27140c.isWifiEnabled()) {
            C27140c.startScan();
            List<ScanResult> scanResults = C27140c.getScanResults();
            c27137c.ido = new ArrayList();
            c27137c.hAa = "ok";
            if (scanResults != null) {
                String str;
                C4990ab.m7411d("MicroMsg.WiFiManagerWrapper", "[getWifiList] ScanResult:%s, size:%d", scanResults, Integer.valueOf(scanResults.size()));
                WifiInfo connectionInfo = C27140c.getConnectionInfo();
                C4990ab.m7411d("MicroMsg.WiFiManagerWrapper", "[getWifiList] currentWiFiInfo:%s", connectionInfo);
                String str2;
                if (connectionInfo == null || TextUtils.isEmpty(connectionInfo.getSSID())) {
                    str2 = null;
                    str = null;
                } else {
                    str = C19531d.m30248Cc(connectionInfo.getSSID());
                    str2 = C5046bo.m7532bc(connectionInfo.getBSSID(), "");
                }
                for (ScanResult scanResult : scanResults) {
                    if (scanResult != null) {
                        int a = C19531d.m30249a(scanResult);
                        if (a == 0 || a == 2) {
                            int i;
                            C19528b c19528b = new C19528b();
                            c19528b.idi = C19531d.m30248Cc(scanResult.SSID);
                            c19528b.idj = C5046bo.m7532bc(scanResult.BSSID, "");
                            c19528b.idk = C27140c.m43136oI(scanResult.level);
                            c19528b.idl = a == 2;
                            if (str == null || str2 == null || c19528b.idi.compareTo(str) != 0 || c19528b.idj.compareTo(str2) != 0) {
                                i = 0;
                            } else {
                                i = 1;
                            }
                            if (i != 0) {
                                idr = c19528b;
                            }
                            c27137c.ido.add(c19528b);
                        }
                    }
                }
            } else {
                C4990ab.m7412e("MicroMsg.WiFiManagerWrapper", "wifiList is null");
            }
        } else if (idp) {
            c27137c.hAa = "wifi is disable";
        } else {
            c27137c.hAa = "sdk not init";
        }
        AppMethodBeat.m2505o(94385);
        return c27137c;
    }

    /* renamed from: D */
    public static void m43128D(String str, String str2, String str3) {
        int i;
        WifiConfiguration wifiConfiguration;
        WifiConfiguration wifiConfiguration2 = null;
        AppMethodBeat.m2504i(94386);
        if (idq != null) {
            C38407a c38407a = (C38407a) idq.get();
            if (!(c38407a == null || c38407a.aGB())) {
                c38407a.mo61113Cb("duplicated request");
            }
        }
        C38407a c38407a2 = new C38407a(ids, mContext);
        C4990ab.m7416i("MicroMsg.WiFiConnector", "ssid:" + str + " bssid:" + str2 + " psw:" + str3);
        c38407a2.idi = str;
        c38407a2.idj = str2;
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
        List configuredNetworks = C27140c.getConfiguredNetworks();
        if (configuredNetworks != null) {
            wifiConfiguration2 = C27139b.m43131a(str, i, configuredNetworks);
        }
        if (wifiConfiguration != null) {
            if (wifiConfiguration2 != null) {
                boolean z;
                if (C27139b.m43133bl(str, i)) {
                    C27140c.saveConfiguration();
                    z = true;
                } else {
                    z = false;
                }
                if (!z) {
                    wifiConfiguration.networkId = C27139b.m43132b(wifiConfiguration);
                    if (wifiConfiguration.networkId == C19531d.idD) {
                        c38407a2.idA = true;
                        wifiConfiguration = wifiConfiguration2;
                    }
                }
            }
            if (wifiConfiguration.networkId == C19531d.idD) {
                wifiConfiguration.networkId = C27139b.m43132b(wifiConfiguration);
            }
            if (wifiConfiguration.networkId != C19531d.idD && c38407a2.mo61114a(wifiConfiguration)) {
                C4990ab.m7416i("MicroMsg.wifi_event", TMAssistantDownloadSDKClientBase.CONNTECTSTATE_CONNECTING);
                c38407a2.mo61117oE(1);
                c38407a2.idw = wifiConfiguration;
                if (!c38407a2.ide) {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.net.wifi.supplicant.STATE_CHANGE");
                    intentFilter.addAction("android.net.wifi.STATE_CHANGE");
                    intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                    intentFilter.setPriority(BaseClientBuilder.API_PRIORITY_OTHER);
                    c38407a2.idf = new WiFiConnector$2(c38407a2);
                    c38407a2.idt.registerReceiver(c38407a2.idf, intentFilter);
                    c38407a2.ide = true;
                    C4990ab.m7416i("MicroMsg.WiFiConnector", "startMonitorWiFiEvent");
                }
                c38407a2.mHandler.sendEmptyMessageDelayed(1, 13000);
                idq = new WeakReference(c38407a2);
                AppMethodBeat.m2505o(94386);
            }
        }
        c38407a2.mo61116i(false, "fail to connect wifi:invalid network id");
        C4990ab.m7416i("MicroMsg.wifi_event", "connect args wrong FAIL.");
        idq = new WeakReference(c38407a2);
        AppMethodBeat.m2505o(94386);
    }

    /* renamed from: a */
    public static void m43129a(C10565a c10565a) {
        ids = c10565a;
    }
}
