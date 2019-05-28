package com.tencent.p177mm.plugin.freewifi.model;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.freewifi.model.h */
public final class C34191h {
    boolean jER;
    C28083a mvZ;
    BroadcastReceiver mwa;

    /* renamed from: com.tencent.mm.plugin.freewifi.model.h$b */
    public static class C20801b {
        private static C34191h mwc = new C34191h();

        static {
            AppMethodBeat.m2504i(20731);
            AppMethodBeat.m2505o(20731);
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.h$a */
    public interface C28083a {
        /* renamed from: bU */
        void mo23813bU(List<ScanResult> list);
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.h$2 */
    class C341922 implements Comparator<ScanResult> {
        C341922() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            ScanResult scanResult = (ScanResult) obj;
            ScanResult scanResult2 = (ScanResult) obj2;
            if (scanResult.level < scanResult2.level) {
                return 1;
            }
            return scanResult.level == scanResult2.level ? 0 : -1;
        }
    }

    /* renamed from: com.tencent.mm.plugin.freewifi.model.h$1 */
    class C341931 extends BroadcastReceiver {
        C341931() {
        }

        public final void onReceive(Context context, Intent intent) {
            int i = 0;
            AppMethodBeat.m2504i(20730);
            if (context == null || intent == null) {
                C4990ab.m7412e("MicroMsg.FreeWifi.WifiScanReceiver", "context is null or intent null");
                AppMethodBeat.m2505o(20730);
                return;
            }
            C34191h.this.jER = false;
            context.unregisterReceiver(C34191h.this.mwa);
            if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
                if (wifiManager == null) {
                    C4990ab.m7412e("MicroMsg.FreeWifi.WifiScanReceiver", "bran, WifiScanReceiver onReceive, get wifi manager failed");
                    AppMethodBeat.m2505o(20730);
                    return;
                }
                List scanResults;
                try {
                    scanResults = wifiManager.getScanResults();
                } catch (SecurityException e) {
                    scanResults = new ArrayList(0);
                    C4990ab.m7412e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiManager.getScanResults() throws security exception. " + e.getMessage());
                }
                C34191h c34191h = C34191h.this;
                if (scanResults != null && scanResults.size() > 20) {
                    Collections.sort(scanResults, new C341922());
                    scanResults = scanResults.subList(0, 20);
                }
                String str = "MicroMsg.FreeWifi.WifiScanReceiver";
                StringBuilder stringBuilder = new StringBuilder("wifiManager scanResults size = ");
                if (scanResults != null) {
                    i = scanResults.size();
                }
                C4990ab.m7416i(str, stringBuilder.append(i).toString());
                if (C34191h.this.mvZ != null) {
                    C34191h.this.mvZ.mo23813bU(scanResults);
                }
            }
            AppMethodBeat.m2505o(20730);
        }
    }

    /* synthetic */ C34191h(byte b) {
        this();
    }

    private C34191h() {
        AppMethodBeat.m2504i(20732);
        this.jER = false;
        this.mwa = new C341931();
        AppMethodBeat.m2505o(20732);
    }

    /* renamed from: a */
    public final boolean mo54766a(C28083a c28083a) {
        AppMethodBeat.m2504i(20733);
        if (this.jER) {
            AppMethodBeat.m2505o(20733);
            return false;
        }
        this.jER = true;
        this.mvZ = c28083a;
        WifiManager wifiManager = (WifiManager) C4996ah.getContext().getSystemService("wifi");
        if (wifiManager == null) {
            C4990ab.m7412e("MicroMsg.FreeWifi.WifiScanReceiver", "wifiDetectingTask, get wifi manager failed");
            AppMethodBeat.m2505o(20733);
            return false;
        }
        C4996ah.getContext().registerReceiver(this.mwa, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
        wifiManager.startScan();
        AppMethodBeat.m2505o(20733);
        return true;
    }
}
