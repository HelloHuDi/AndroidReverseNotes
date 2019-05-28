package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.WifiConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.List;

public final class b {
    public static int b(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(94399);
        if (wifiConfiguration == null || wifiConfiguration.networkId >= 0) {
            AppMethodBeat.o(94399);
            return -1;
        }
        wifiConfiguration.networkId = c.addNetwork(wifiConfiguration);
        int i = wifiConfiguration.networkId;
        AppMethodBeat.o(94399);
        return i;
    }

    public static boolean bl(String str, int i) {
        boolean z = false;
        AppMethodBeat.i(94400);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(94400);
        } else {
            List configuredNetworks = c.getConfiguredNetworks();
            if (configuredNetworks != null) {
                boolean z2;
                Iterator it = configuredNetworks.iterator();
                while (true) {
                    z2 = z;
                    if (!it.hasNext()) {
                        break;
                    }
                    WifiConfiguration wifiConfiguration = (WifiConfiguration) it.next();
                    if (d.Cc(wifiConfiguration.SSID).compareTo(str) == 0 && d.c(wifiConfiguration) == i) {
                        z2 |= c.removeNetwork(wifiConfiguration.networkId);
                    }
                    z = z2;
                }
                z = z2;
            }
            if (z) {
                c.saveConfiguration();
            }
            AppMethodBeat.o(94400);
        }
        return z;
    }

    public static WifiConfiguration a(String str, int i, List<WifiConfiguration> list) {
        AppMethodBeat.i(94401);
        if (list != null) {
            for (WifiConfiguration wifiConfiguration : list) {
                if (d.Cc(wifiConfiguration.SSID).compareTo(str) == 0 && d.c(wifiConfiguration) == i) {
                    AppMethodBeat.o(94401);
                    return wifiConfiguration;
                }
            }
        }
        AppMethodBeat.o(94401);
        return null;
    }

    public static boolean oG(int i) {
        AppMethodBeat.i(94402);
        boolean z = false;
        if (c.removeNetwork(i) || c.disableNetwork(i)) {
            z = true;
            c.saveConfiguration();
        }
        AppMethodBeat.o(94402);
        return z;
    }
}
