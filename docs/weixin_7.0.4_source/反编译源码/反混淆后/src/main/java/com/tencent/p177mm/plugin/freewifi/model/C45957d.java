package com.tencent.p177mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C1443d;
import com.tencent.p177mm.plugin.freewifi.C34189m;
import com.tencent.p177mm.plugin.freewifi.p417g.C3137c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import com.tencent.p177mm.sdk.platformtools.C5023at;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.freewifi.model.d */
public final class C45957d {
    private static Map<Integer, String> mvJ = new C459561();

    /* renamed from: com.tencent.mm.plugin.freewifi.model.d$1 */
    static class C459561 extends HashMap<Integer, String> {
        C459561() {
            AppMethodBeat.m2504i(20698);
            put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
            put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
            put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
            put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
            put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
            AppMethodBeat.m2505o(20698);
        }
    }

    /* renamed from: MC */
    public static int m85347MC(String str) {
        AppMethodBeat.m2504i(20699);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7410d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            AppMethodBeat.m2505o(20699);
            return 0;
        }
        C3137c ML = C11976j.byW().mo17045ML(str);
        if (ML == null || !str.equalsIgnoreCase(ML.field_ssid)) {
            AppMethodBeat.m2505o(20699);
            return 0;
        }
        if (ML.field_connectState == 2 && ML.field_expiredTime > 0 && ML.field_expiredTime - C5046bo.anT() <= 0) {
            ML.field_connectState = 1;
            boolean c = C11976j.byW().mo10103c(ML, new String[0]);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", Long.valueOf(ML.field_expiredTime), Long.valueOf(C5046bo.anT()), Boolean.valueOf(c));
        }
        int i = ML.field_connectState;
        AppMethodBeat.m2505o(20699);
        return i;
    }

    /* renamed from: MD */
    public static boolean m85348MD(String str) {
        AppMethodBeat.m2504i(20700);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", str);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            AppMethodBeat.m2505o(20700);
            return false;
        }
        String gE = C5023at.m7474gE(C4996ah.getContext());
        if (C5046bo.isNullOrNil(gE) || !gE.equals(str)) {
            AppMethodBeat.m2505o(20700);
            return false;
        }
        AppMethodBeat.m2505o(20700);
        return true;
    }

    /* renamed from: ME */
    public static int m85349ME(String str) {
        AppMethodBeat.m2504i(20701);
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            AppMethodBeat.m2505o(20701);
            return -11;
        }
        int MG = C45957d.m85351MG(str);
        if (MG > 0) {
            C4990ab.m7416i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", Boolean.valueOf(C45957d.m85350MF(str)));
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            MG = wifiManager.addNetwork(wifiConfiguration);
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", Integer.valueOf(MG), Boolean.valueOf(wifiManager.enableNetwork(MG, true)));
        if (wifiManager.enableNetwork(MG, true)) {
            AppMethodBeat.m2505o(20701);
            return 0;
        }
        AppMethodBeat.m2505o(20701);
        return -14;
    }

    /* renamed from: c */
    public static int m85353c(String str, String str2, int i, boolean z) {
        AppMethodBeat.m2504i(20702);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", str, str2, Integer.valueOf(i), Boolean.valueOf(z));
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            AppMethodBeat.m2505o(20702);
            return -12;
        } else if (i == 0) {
            int ME = C45957d.m85349ME(str);
            AppMethodBeat.m2505o(20702);
            return ME;
        } else if (C5046bo.isNullOrNil(str2)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
            AppMethodBeat.m2505o(20702);
            return -15;
        } else {
            WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                AppMethodBeat.m2505o(20702);
                return -11;
            }
            int addNetwork;
            WifiConfiguration wifiConfiguration;
            if (C1443d.m3068iW(21)) {
                if (!C5046bo.isNullOrNil(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) C4996ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
                        for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                            if (wifiConfiguration2.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    }
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                } else {
                    C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                wifiConfiguration2 = null;
                if (wifiConfiguration2 == null) {
                    wifiConfiguration2 = C45957d.m85355y(str, str2, i);
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                } else {
                    if (wifiConfiguration2 != null) {
                        wifiConfiguration2.SSID = "\"" + str + "\"";
                        wifiConfiguration2.status = 2;
                        switch (i) {
                            case 1:
                                wifiConfiguration2.wepKeys = new String[]{"\"" + str2 + "\""};
                                wifiConfiguration2.allowedKeyManagement.set(0);
                                break;
                            case 2:
                            case 3:
                                wifiConfiguration2.preSharedKey = "\"" + str2 + "\"";
                                wifiConfiguration2.allowedKeyManagement.set(1);
                                break;
                            default:
                                C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i));
                                break;
                        }
                    }
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiConfiguration2.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                addNetwork = C45957d.m85351MG(str);
                if (addNetwork > 0) {
                    boolean removeNetwork = wifiManager.removeNetwork(addNetwork);
                    C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", str, Boolean.valueOf(removeNetwork));
                }
                wifiConfiguration2 = C45957d.m85355y(str, str2, i);
                wifiConfiguration2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                wifiManager.saveConfiguration();
            }
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", Integer.valueOf(addNetwork), Boolean.valueOf(wifiManager.enableNetwork(addNetwork, true)));
            if (wifiManager.enableNetwork(addNetwork, true)) {
                AppMethodBeat.m2505o(20702);
                return 0;
            }
            AppMethodBeat.m2505o(20702);
            return -14;
        }
    }

    /* renamed from: y */
    private static WifiConfiguration m85355y(String str, String str2, int i) {
        AppMethodBeat.m2504i(20703);
        WifiConfiguration wifiConfiguration = new WifiConfiguration();
        wifiConfiguration.SSID = "\"" + str + "\"";
        wifiConfiguration.status = 2;
        switch (i) {
            case 1:
                wifiConfiguration.wepKeys = new String[]{"\"" + str2 + "\""};
                wifiConfiguration.allowedKeyManagement.set(0);
                break;
            case 2:
            case 3:
                wifiConfiguration.preSharedKey = "\"" + str2 + "\"";
                wifiConfiguration.allowedKeyManagement.set(1);
                break;
            default:
                C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i));
                break;
        }
        AppMethodBeat.m2505o(20703);
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        AppMethodBeat.m2504i(20704);
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.m2505o(20704);
            return false;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", Boolean.valueOf(wifiManager.isWifiEnabled()));
        AppMethodBeat.m2505o(20704);
        return wifiManager.isWifiEnabled();
    }

    public static boolean byJ() {
        AppMethodBeat.m2504i(20705);
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.m2505o(20705);
            return false;
        }
        boolean wifiEnabled = wifiManager.setWifiEnabled(true);
        AppMethodBeat.m2505o(20705);
        return wifiEnabled;
    }

    /* renamed from: MF */
    public static boolean m85350MF(String str) {
        AppMethodBeat.m2504i(20706);
        int MG = C45957d.m85351MG(str);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", str, Integer.valueOf(MG));
        if (MG == -1) {
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", str);
            AppMethodBeat.m2505o(20706);
            return false;
        }
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(MG);
        wifiManager.saveConfiguration();
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", str, Boolean.valueOf(removeNetwork));
        AppMethodBeat.m2505o(20706);
        return removeNetwork;
    }

    /* renamed from: MG */
    private static int m85351MG(String str) {
        AppMethodBeat.m2504i(20707);
        if (C5046bo.isNullOrNil(str)) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            AppMethodBeat.m2505o(20707);
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) C4996ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            AppMethodBeat.m2505o(20707);
            return -1;
        }
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                int i = wifiConfiguration.networkId;
                AppMethodBeat.m2505o(20707);
                return i;
            }
        }
        AppMethodBeat.m2505o(20707);
        return -1;
    }

    static {
        AppMethodBeat.m2504i(20716);
        AppMethodBeat.m2505o(20716);
    }

    /* renamed from: vR */
    public static String m85354vR(int i) {
        AppMethodBeat.m2504i(20708);
        String str = (String) mvJ.get(Integer.valueOf(i));
        if (str == null) {
            str = "";
            AppMethodBeat.m2505o(20708);
            return str;
        }
        AppMethodBeat.m2505o(20708);
        return str;
    }

    /* renamed from: a */
    public static void m85352a(String str, int i, Intent intent) {
        AppMethodBeat.m2504i(20709);
        C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", C34189m.m56063V(intent), Integer.valueOf(C34189m.m56064W(intent)), C45957d.m85354vR(i), Integer.valueOf(i));
        C3137c ML = C11976j.byW().mo17045ML(str);
        if (ML != null) {
            ML.field_connectState = i;
            boolean c = C11976j.byW().mo10103c(ML, new String[0]);
            C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", str, Integer.valueOf(i), Boolean.valueOf(c));
        }
        AppMethodBeat.m2505o(20709);
    }

    public static WifiInfo byM() {
        AppMethodBeat.m2504i(20712);
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.m2505o(20712);
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.m2505o(20712);
            return connectionInfo;
        } catch (Exception e) {
            C4990ab.m7413e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", e.getMessage());
            AppMethodBeat.m2505o(20712);
            return null;
        }
    }

    public static String byN() {
        AppMethodBeat.m2504i(20713);
        String gF = C5023at.m7475gF(C4996ah.getContext());
        AppMethodBeat.m2505o(20713);
        return gF;
    }

    public static String byO() {
        AppMethodBeat.m2504i(139018);
        String gE = C5023at.m7474gE(C4996ah.getContext());
        AppMethodBeat.m2505o(139018);
        return gE;
    }

    public static int getNetworkType() {
        AppMethodBeat.m2504i(139019);
        int netType = C5023at.getNetType(C4996ah.getContext());
        AppMethodBeat.m2505o(139019);
        return netType;
    }

    public static String byK() {
        AppMethodBeat.m2504i(20710);
        if (C5023at.getNetType(C4996ah.getContext()) == 0) {
            WifiInfo byM = C45957d.byM();
            if (!(byM == null || byM.getBSSID() == null)) {
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", byM.getBSSID());
                AppMethodBeat.m2505o(20710);
                return byM.getBSSID();
            }
        }
        AppMethodBeat.m2505o(20710);
        return null;
    }

    public static int byL() {
        AppMethodBeat.m2504i(20711);
        if (C5023at.getNetType(C4996ah.getContext()) == 0) {
            WifiInfo byM = C45957d.byM();
            if (byM != null) {
                C4990ab.m7417i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", Integer.valueOf(byM.getRssi()));
                AppMethodBeat.m2505o(20711);
                return byM.getRssi();
            }
        }
        AppMethodBeat.m2505o(20711);
        return 0;
    }
}
