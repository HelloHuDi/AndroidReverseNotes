package com.tencent.p177mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal.b */
public final class C27139b {
    /* renamed from: b */
    public static int m43132b(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.m2504i(94399);
        if (wifiConfiguration == null || wifiConfiguration.networkId >= 0) {
            AppMethodBeat.m2505o(94399);
            return -1;
        }
        wifiConfiguration.networkId = C27140c.addNetwork(wifiConfiguration);
        int i = wifiConfiguration.networkId;
        AppMethodBeat.m2505o(94399);
        return i;
    }

    /* renamed from: bl */
    public static boolean m43133bl(String str, int i) {
        boolean z = false;
        AppMethodBeat.m2504i(94400);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(94400);
        } else {
            List configuredNetworks = C27140c.getConfiguredNetworks();
            if (configuredNetworks != null) {
                boolean z2;
                Iterator it = configuredNetworks.iterator();
                while (true) {
                    z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration wifiConfiguration = (WifiConfiguration) it.next();
                    if (C19531d.m30248Cc(wifiConfiguration.SSID).compareTo(str) == 0 && C19531d.m30250c(wifiConfiguration) == i) {
                        z2 |= C27140c.removeNetwork(wifiConfiguration.networkId);
                    }
                    z = z2;
                }
                z = z2;
            }
            if (z) {
                C27140c.saveConfiguration();
            }
            AppMethodBeat.m2505o(94400);
        }
        return z;
    }

    /* renamed from: a */
    public static WifiConfiguration m43131a(String str, int i, List<WifiConfiguration> list) {
        AppMethodBeat.m2504i(94401);
        if (list != null) {
            for (WifiConfiguration wifiConfiguration : list) {
                if (C19531d.m30248Cc(wifiConfiguration.SSID).compareTo(str) == 0 && C19531d.m30250c(wifiConfiguration) == i) {
                    AppMethodBeat.m2505o(94401);
                    return wifiConfiguration;
                }
            }
        }
        AppMethodBeat.m2505o(94401);
        return null;
    }

    /* renamed from: oG */
    public static boolean m43134oG(int i) {
        AppMethodBeat.m2504i(94402);
        boolean z = false;
        if (C27140c.removeNetwork(i) || C27140c.disableNetwork(i)) {
            z = true;
            C27140c.saveConfiguration();
        }
        AppMethodBeat.m2505o(94402);
        return z;
    }
}
