package com.tencent.mm.plugin.appbrand.jsapi.wifi.wifisdk.internal;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class c {
    public static WifiManager bCU;

    public static List<WifiConfiguration> getConfiguredNetworks() {
        AppMethodBeat.i(94403);
        try {
            List configuredNetworks = bCU.getConfiguredNetworks();
            AppMethodBeat.o(94403);
            return configuredNetworks;
        } catch (Throwable th) {
            AppMethodBeat.o(94403);
            return null;
        }
    }

    public static int addNetwork(WifiConfiguration wifiConfiguration) {
        AppMethodBeat.i(94404);
        int addNetwork;
        try {
            addNetwork = bCU.addNetwork(wifiConfiguration);
            AppMethodBeat.o(94404);
            return addNetwork;
        } catch (Throwable th) {
            addNetwork = d.idD;
            AppMethodBeat.o(94404);
            return addNetwork;
        }
    }

    public static boolean removeNetwork(int i) {
        AppMethodBeat.i(94405);
        try {
            boolean removeNetwork = bCU.removeNetwork(i);
            AppMethodBeat.o(94405);
            return removeNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(94405);
            return false;
        }
    }

    public static boolean oH(int i) {
        AppMethodBeat.i(94406);
        try {
            boolean enableNetwork = bCU.enableNetwork(i, true);
            AppMethodBeat.o(94406);
            return enableNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(94406);
            return false;
        }
    }

    public static boolean disableNetwork(int i) {
        AppMethodBeat.i(94407);
        try {
            boolean disableNetwork = bCU.disableNetwork(i);
            AppMethodBeat.o(94407);
            return disableNetwork;
        } catch (Throwable th) {
            AppMethodBeat.o(94407);
            return false;
        }
    }

    public static boolean startScan() {
        AppMethodBeat.i(94408);
        try {
            boolean startScan = bCU.startScan();
            AppMethodBeat.o(94408);
            return startScan;
        } catch (Throwable th) {
            AppMethodBeat.o(94408);
            return false;
        }
    }

    public static WifiInfo getConnectionInfo() {
        AppMethodBeat.i(94409);
        try {
            WifiInfo connectionInfo = bCU.getConnectionInfo();
            AppMethodBeat.o(94409);
            return connectionInfo;
        } catch (Throwable th) {
            AppMethodBeat.o(94409);
            return null;
        }
    }

    public static List<ScanResult> getScanResults() {
        AppMethodBeat.i(94410);
        try {
            List scanResults = bCU.getScanResults();
            AppMethodBeat.o(94410);
            return scanResults;
        } catch (Throwable th) {
            AppMethodBeat.o(94410);
            return null;
        }
    }

    public static boolean saveConfiguration() {
        AppMethodBeat.i(94411);
        try {
            boolean saveConfiguration = bCU.saveConfiguration();
            AppMethodBeat.o(94411);
            return saveConfiguration;
        } catch (Throwable th) {
            AppMethodBeat.o(94411);
            return false;
        }
    }

    public static boolean isWifiEnabled() {
        AppMethodBeat.i(94412);
        try {
            boolean isWifiEnabled = bCU.isWifiEnabled();
            AppMethodBeat.o(94412);
            return isWifiEnabled;
        } catch (Throwable th) {
            AppMethodBeat.o(94412);
            return false;
        }
    }

    public static int oI(int i) {
        if (i <= -100) {
            return 0;
        }
        if (i >= -55) {
            return 99;
        }
        return (int) ((((float) (i + 100)) * 99.0f) / 45.0f);
    }
}
