package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.d */
public final class C19531d {
    public static int idD = -1;

    /* renamed from: Cc */
    public static String m30248Cc(String str) {
        AppMethodBeat.m2504i(94413);
        if (str == null) {
            str = "";
            AppMethodBeat.m2505o(94413);
            return str;
        }
        int length = str.length();
        if (length > 1 && str.charAt(0) == '\"' && str.charAt(length - 1) == '\"') {
            str = str.substring(1, length - 1);
            AppMethodBeat.m2505o(94413);
            return str;
        }
        AppMethodBeat.m2505o(94413);
        return str;
    }

    /* renamed from: c */
    public static int m30250c(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.m2504i(94414);
        if (wifiConfiguration.allowedKeyManagement.get(1)) {
            AppMethodBeat.m2505o(94414);
            return 2;
        } else if (wifiConfiguration.allowedKeyManagement.get(2) || wifiConfiguration.allowedKeyManagement.get(3)) {
            AppMethodBeat.m2505o(94414);
            return 3;
        } else if (wifiConfiguration.wepKeys[0] != null) {
            AppMethodBeat.m2505o(94414);
            return 1;
        } else {
            AppMethodBeat.m2505o(94414);
            return 0;
        }
    }

    /* renamed from: a */
    public static int m30249a(ScanResult scanResult) {
        AppMethodBeat.m2504i(94415);
        if (scanResult == null || scanResult.capabilities == null) {
            AppMethodBeat.m2505o(94415);
            return -1;
        } else if (scanResult.capabilities.contains("WEP")) {
            AppMethodBeat.m2505o(94415);
            return 1;
        } else if (scanResult.capabilities.contains("PSK")) {
            AppMethodBeat.m2505o(94415);
            return 2;
        } else if (scanResult.capabilities.contains("EAP")) {
            AppMethodBeat.m2505o(94415);
            return 3;
        } else {
            AppMethodBeat.m2505o(94415);
            return 0;
        }
    }
}
