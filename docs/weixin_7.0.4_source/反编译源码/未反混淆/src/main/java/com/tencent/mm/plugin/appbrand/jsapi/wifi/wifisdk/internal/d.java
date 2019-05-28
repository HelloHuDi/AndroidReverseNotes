package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    public static int idD = -1;

    public static String Cc(String str) {
        AppMethodBeat.i(94413);
        if (str == null) {
            str = "";
            AppMethodBeat.o(94413);
            return str;
        }
        int length = str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            str = str.substring(1, length - 1);
            AppMethodBeat.o(94413);
            return str;
        }
        AppMethodBeat.o(94413);
        return str;
    }

    public static int c(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(94414);
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            AppMethodBeat.o(94414);
            return 2;
        } else if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            AppMethodBeat.o(94414);
            return 3;
        } else if (wifiConfiguration.wepKeys[0] != null) {
            AppMethodBeat.o(94414);
            return 1;
        } else {
            AppMethodBeat.o(94414);
            return 0;
        }
    }

    public static int a(ScanResult scanResult) {
        AppMethodBeat.i(94415);
        if (scanResult == null || scanResult.capabilities == null) {
            AppMethodBeat.o(94415);
            return -1;
        } else if (scanResult.capabilities.contains("WEP")) {
            AppMethodBeat.o(94415);
            return 1;
        } else if (scanResult.capabilities.contains("PSK")) {
            AppMethodBeat.o(94415);
            return 2;
        } else if (scanResult.capabilities.contains("EAP")) {
            AppMethodBeat.o(94415);
            return 3;
        } else {
            AppMethodBeat.o(94415);
            return 0;
        }
    }
}
