package com.tencent.mm.plugin.freewifi.model;

import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.freewifi.g.c;
import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class d {
    private static Map<Integer, String> mvJ = new HashMap<Integer, String>() {
        {
            AppMethodBeat.i(20698);
            put(Integer.valueOf(-1), "CONNECT_STATE_NOT_CONNECT");
            put(Integer.valueOf(0), "CONNECT_STATE_NOT_WECHAT_WIFI");
            put(Integer.valueOf(1), "CONNECT_STATE_CONNECTING");
            put(Integer.valueOf(2), "CONNECT_STATE_CONNECT_SUCCESS");
            put(Integer.valueOf(3), "CONNECT_STATE_CONNECT_FAILED");
            put(Integer.valueOf(4), "CONNECT_STATE_WAIT_START");
            AppMethodBeat.o(20698);
        }
    };

    public static int MC(String str) {
        AppMethodBeat.i(20699);
        if (bo.isNullOrNil(str)) {
            ab.d("MicroMsg.FreeWifi.FreeWifiManager", "Illegal SSID");
            AppMethodBeat.o(20699);
            return 0;
        }
        c ML = j.byW().ML(str);
        if (ML == null || !str.equalsIgnoreCase(ML.field_ssid)) {
            AppMethodBeat.o(20699);
            return 0;
        }
        if (ML.field_connectState == 2 && ML.field_expiredTime > 0 && ML.field_expiredTime - bo.anT() <= 0) {
            ML.field_connectState = 1;
            boolean c = j.byW().c(ML, new String[0]);
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "Expired, re-auth, expired time : %d, current time : %d, ret : %b", Long.valueOf(ML.field_expiredTime), Long.valueOf(bo.anT()), Boolean.valueOf(c));
        }
        int i = ML.field_connectState;
        AppMethodBeat.o(20699);
        return i;
    }

    public static boolean MD(String str) {
        AppMethodBeat.i(20700);
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "check is wechat free wifi, ssid : %s", str);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "ssid is null or nil");
            AppMethodBeat.o(20700);
            return false;
        }
        String gE = at.gE(ah.getContext());
        if (bo.isNullOrNil(gE) || !gE.equals(str)) {
            AppMethodBeat.o(20700);
            return false;
        }
        AppMethodBeat.o(20700);
        return true;
    }

    public static int ME(String str) {
        AppMethodBeat.i(20701);
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, get wifi manager failed");
            AppMethodBeat.o(20701);
            return -11;
        }
        int MG = MG(str);
        if (MG > 0) {
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork, the network has exsited, just enable it");
        } else {
            WifiConfiguration wifiConfiguration = new WifiConfiguration();
            wifiConfiguration.allowedAuthAlgorithms.clear();
            wifiConfiguration.allowedGroupCiphers.clear();
            wifiConfiguration.allowedKeyManagement.clear();
            wifiConfiguration.allowedPairwiseCiphers.clear();
            wifiConfiguration.allowedProtocols.clear();
            wifiConfiguration.SSID = "\"" + str + "\"";
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "check is the same ssid is exist, %b", Boolean.valueOf(MF(str)));
            wifiConfiguration.allowedKeyManagement.set(0);
            wifiConfiguration.wepTxKeyIndex = 0;
            MG = wifiManager.addNetwork(wifiConfiguration);
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork netid : %d, result : %b", Integer.valueOf(MG), Boolean.valueOf(wifiManager.enableNetwork(MG, true)));
        if (wifiManager.enableNetwork(MG, true)) {
            AppMethodBeat.o(20701);
            return 0;
        }
        AppMethodBeat.o(20701);
        return -14;
    }

    public static int c(String str, String str2, int i, boolean z) {
        AppMethodBeat.i(20702);
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt, ssid is : %s, password : %s, cryptType :%d, hideSSID = %b", str, str2, Integer.valueOf(i), Boolean.valueOf(z));
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg failed, ssid is null");
            AppMethodBeat.o(20702);
            return -12;
        } else if (i == 0) {
            int ME = ME(str);
            AppMethodBeat.o(20702);
            return ME;
        } else if (bo.isNullOrNil(str2)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "encrypt type is not none, while password is null");
            AppMethodBeat.o(20702);
            return -15;
        } else {
            WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
            if (wifiManager == null) {
                ab.e("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, get wifi manager failed");
                AppMethodBeat.o(20702);
                return -11;
            }
            int addNetwork;
            WifiConfiguration wifiConfiguration;
            if (com.tencent.mm.compatible.util.d.iW(21)) {
                if (!bo.isNullOrNil(str)) {
                    List<WifiConfiguration> configuredNetworks = ((WifiManager) ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
                    if (configuredNetworks != null) {
                        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
                        for (WifiConfiguration wifiConfiguration2 : configuredNetworks) {
                            if (wifiConfiguration2.SSID.equals("\"" + str + "\"")) {
                                break;
                            }
                        }
                    }
                    ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
                } else {
                    ab.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
                }
                wifiConfiguration2 = null;
                if (wifiConfiguration2 == null) {
                    wifiConfiguration2 = y(str, str2, i);
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
                                ab.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i));
                                break;
                        }
                    }
                    wifiConfiguration2.hiddenSSID = z;
                    addNetwork = wifiConfiguration2.networkId;
                }
                wifiManager.saveConfiguration();
            } else {
                addNetwork = MG(str);
                if (addNetwork > 0) {
                    boolean removeNetwork = wifiManager.removeNetwork(addNetwork);
                    ab.i("MicroMsg.FreeWifi.FreeWifiManager", "this network has exist : %s, try to remove it : %b", str, Boolean.valueOf(removeNetwork));
                }
                wifiConfiguration2 = y(str, str2, i);
                wifiConfiguration2.hiddenSSID = z;
                addNetwork = wifiManager.addNetwork(wifiConfiguration2);
                wifiManager.saveConfiguration();
            }
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "addWifiNetWork by encrypt alg, netid : %d, result : %b", Integer.valueOf(addNetwork), Boolean.valueOf(wifiManager.enableNetwork(addNetwork, true)));
            if (wifiManager.enableNetwork(addNetwork, true)) {
                AppMethodBeat.o(20702);
                return 0;
            }
            AppMethodBeat.o(20702);
            return -14;
        }
    }

    private static WifiConfiguration y(String str, String str2, int i) {
        AppMethodBeat.i(20703);
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
                ab.e("MicroMsg.FreeWifi.FreeWifiManager", "unsupport encrypt type : %d", Integer.valueOf(i));
                break;
        }
        AppMethodBeat.o(20703);
        return wifiConfiguration;
    }

    public static boolean isWifiEnabled() {
        AppMethodBeat.i(20704);
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(20704);
            return false;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "is wifi enalbe now : %b", Boolean.valueOf(wifiManager.isWifiEnabled()));
        AppMethodBeat.o(20704);
        return wifiManager.isWifiEnabled();
    }

    public static boolean byJ() {
        AppMethodBeat.i(20705);
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(20705);
            return false;
        }
        boolean wifiEnabled = wifiManager.setWifiEnabled(true);
        AppMethodBeat.o(20705);
        return wifiEnabled;
    }

    public static boolean MF(String str) {
        AppMethodBeat.i(20706);
        int MG = MG(str);
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get network id by ssid :%s, netid is %d", str, Integer.valueOf(MG));
        if (MG == -1) {
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "ssid is not exist : %s", str);
            AppMethodBeat.o(20706);
            return false;
        }
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        boolean removeNetwork = wifiManager.removeNetwork(MG);
        wifiManager.saveConfiguration();
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "remove ssid : %s, ret = %b", str, Boolean.valueOf(removeNetwork));
        AppMethodBeat.o(20706);
        return removeNetwork;
    }

    private static int MG(String str) {
        AppMethodBeat.i(20707);
        if (bo.isNullOrNil(str)) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "null or nill ssid");
            AppMethodBeat.o(20707);
            return -1;
        }
        List<WifiConfiguration> configuredNetworks = ((WifiManager) ah.getContext().getSystemService("wifi")).getConfiguredNetworks();
        if (configuredNetworks == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi list is null");
            AppMethodBeat.o(20707);
            return -1;
        }
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "get wificonfiguration list size : %d", Integer.valueOf(configuredNetworks.size()));
        for (WifiConfiguration wifiConfiguration : configuredNetworks) {
            if (wifiConfiguration.SSID.equals("\"" + str + "\"")) {
                int i = wifiConfiguration.networkId;
                AppMethodBeat.o(20707);
                return i;
            }
        }
        AppMethodBeat.o(20707);
        return -1;
    }

    static {
        AppMethodBeat.i(20716);
        AppMethodBeat.o(20716);
    }

    public static String vR(int i) {
        AppMethodBeat.i(20708);
        String str = (String) mvJ.get(Integer.valueOf(i));
        if (str == null) {
            str = "";
            AppMethodBeat.o(20708);
            return str;
        }
        AppMethodBeat.o(20708);
        return str;
    }

    public static void a(String str, int i, Intent intent) {
        AppMethodBeat.i(20709);
        ab.i("MicroMsg.FreeWifi.FreeWifiManager", "sessionKey=%s, step=%d, method=FreeWifiManager.updateConnectState, desc=it changes the connect state of the model to %s. state=%d", m.V(intent), Integer.valueOf(m.W(intent)), vR(i), Integer.valueOf(i));
        c ML = j.byW().ML(str);
        if (ML != null) {
            ML.field_connectState = i;
            boolean c = j.byW().c(ML, new String[0]);
            ab.i("MicroMsg.FreeWifi.FreeWifiManager", "update %s, connect state : %d, return : %b", str, Integer.valueOf(i), Boolean.valueOf(c));
        }
        AppMethodBeat.o(20709);
    }

    public static WifiInfo byM() {
        AppMethodBeat.i(20712);
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "get wifi manager failed");
            AppMethodBeat.o(20712);
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            AppMethodBeat.o(20712);
            return connectionInfo;
        } catch (Exception e) {
            ab.e("MicroMsg.FreeWifi.FreeWifiManager", "getConnectionInfo failed : %s", e.getMessage());
            AppMethodBeat.o(20712);
            return null;
        }
    }

    public static String byN() {
        AppMethodBeat.i(20713);
        String gF = at.gF(ah.getContext());
        AppMethodBeat.o(20713);
        return gF;
    }

    public static String byO() {
        AppMethodBeat.i(139018);
        String gE = at.gE(ah.getContext());
        AppMethodBeat.o(139018);
        return gE;
    }

    public static int getNetworkType() {
        AppMethodBeat.i(139019);
        int netType = at.getNetType(ah.getContext());
        AppMethodBeat.o(139019);
        return netType;
    }

    public static String byK() {
        AppMethodBeat.i(20710);
        if (at.getNetType(ah.getContext()) == 0) {
            WifiInfo byM = byM();
            if (!(byM == null || byM.getBSSID() == null)) {
                ab.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiMacAddress, get bssid now : %s", byM.getBSSID());
                AppMethodBeat.o(20710);
                return byM.getBSSID();
            }
        }
        AppMethodBeat.o(20710);
        return null;
    }

    public static int byL() {
        AppMethodBeat.i(20711);
        if (at.getNetType(ah.getContext()) == 0) {
            WifiInfo byM = byM();
            if (byM != null) {
                ab.i("MicroMsg.FreeWifi.FreeWifiManager", "getConnectWifiSignal, get rssi now : %d", Integer.valueOf(byM.getRssi()));
                AppMethodBeat.o(20711);
                return byM.getRssi();
            }
        }
        AppMethodBeat.o(20711);
        return 0;
    }
}
