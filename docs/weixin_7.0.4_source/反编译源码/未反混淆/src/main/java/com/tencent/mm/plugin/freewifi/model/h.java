package com.tencent.mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class h {
    boolean jER;
    a mvZ;
    BroadcastReceiver mwa;

    public static class b {
        private static h mwc = new h();

        static {
            AppMethodBeat.i(20731);
            AppMethodBeat.o(20731);
        }
    }

    public interface a {
        void bU(List<ScanResult> list);
    }

    /* synthetic */ h(byte b) {
        this();
    }

    private h() {
        AppMethodBeat.i(20732);
        this.jER = false;
        this.mwa = new BroadcastReceiver() {
            public final void onReceive(Context context, Intent intent) {
                int i = 0;
                AppMethodBeat.i(20730);
                if (context == null || intent == null) {
                    ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                    AppMethodBeat.o(20730);
                    return;
                }
                h.this.jER = false;
                context.unregisterReceiver(h.this.mwa);
                if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                    WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
                    if (wifiManager == null) {
                        ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                        AppMethodBeat.o(20730);
                        return;
                    }
                    List scanResults;
                    try {
                        scanResults = wifiManager.getScanResults();
                    } catch (SecurityException e) {
                        scanResults = new ArrayList(0);
                        ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
                    }
                    h hVar = h.this;
                    if (scanResults != null && scanResults.size() > 20) {
                        Collections.sort(scanResults, new Comparator<ScanResult>() {
                            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                                ScanResult scanResult = (ScanResult) obj;
                                ScanResult scanResult2 = (ScanResult) obj2;
                                if (scanResult.level < scanResult2.level) {
                                    return 1;
                                }
                                return scanResult.level == scanResult2.level ? 0 : -1;
                            }
                        });
                        scanResults = scanResults.subList(0, 20);
                    }
                    String str = "MicroMsg.FreeWifi.WifiScanReceiver";
                    StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
                    if (scanResults != null) {
                        i = scanResults.size();
                    }
                    ab.i(str, stringBuilder.append(i).toString());
                    if (h.this.mvZ != null) {
                        h.this.mvZ.bU(scanResults);
                    }
                }
                AppMethodBeat.o(20730);
            }
        };
        AppMethodBeat.o(20732);
    }

    public final boolean a(a aVar) {
        AppMethodBeat.i(20733);
        if (this.jER) {
            AppMethodBeat.o(20733);
            return false;
        }
        this.jER = true;
        this.mvZ = aVar;
        WifiManager wifiManager = (WifiManager) ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            ab.e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            AppMethodBeat.o(20733);
            return false;
        }
        ah.getContext().registerReceiver(this.mwa, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        AppMethodBeat.o(20733);
        return true;
    }
}
