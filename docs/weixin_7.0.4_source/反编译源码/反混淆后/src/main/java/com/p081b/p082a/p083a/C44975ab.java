package com.p081b.p082a.p083a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.p081b.p082a.p083a.C8482d.C8483a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

/* renamed from: com.b.a.a.ab */
final class C44975ab extends C25391c {
    private static C44975ab bJc;
    WifiManager bCU;
    private final BroadcastReceiver bJd = new C371511();
    private final IntentFilter bJe = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private C41542ac bJf;
    private long bJg = 10000;

    /* renamed from: com.b.a.a.ab$a */
    static class C17503a extends C31914p {
        final List<ScanResult> bJi;

        C17503a(List<ScanResult> list) {
            super(101);
            this.bJi = list;
        }
    }

    /* renamed from: com.b.a.a.ab$1 */
    class C371511 extends BroadcastReceiver {
        C371511() {
        }

        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.m2504i(55584);
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                C44975ab c44975ab = C44975ab.this;
                try {
                    List scanResults = c44975ab.bCU.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        Exception exception = new Exception("WifiScanMsg: null or empty scan result list");
                        AppMethodBeat.m2505o(55584);
                        throw exception;
                    }
                    c44975ab.mo18562c(new C17503a(scanResults));
                    AppMethodBeat.m2505o(55584);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.m2505o(55584);
        }
    }

    private C44975ab() {
        AppMethodBeat.m2504i(55585);
        AppMethodBeat.m2505o(55585);
    }

    /* renamed from: wD */
    static C44975ab m82345wD() {
        AppMethodBeat.m2504i(55586);
        if (bJc == null) {
            bJc = new C44975ab();
        }
        C44975ab c44975ab = bJc;
        AppMethodBeat.m2505o(55586);
        return c44975ab;
    }

    private boolean isAvailable() {
        return this.bCU != null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    /* renamed from: a */
    public final synchronized void mo18559a(Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55587);
        if (c8483a == null) {
            c8483a = new C8483a(10000);
        }
        super.mo18559a(handler, c8483a);
        AppMethodBeat.m2505o(55587);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: at */
    public final void mo18560at(Context context) {
        AppMethodBeat.m2504i(55588);
        this.bCU = (WifiManager) context.getSystemService("wifi");
        AppMethodBeat.m2505o(55588);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo18557a(Context context, Handler handler, C8483a c8483a) {
        AppMethodBeat.m2504i(55589);
        if (isAvailable()) {
            context.registerReceiver(this.bJd, this.bJe, null, handler);
            this.bJg = c8483a.bCP;
            WifiManager wifiManager = this.bCU;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.bJf = new C41542ac(wifiManager, handler);
            this.bJf.mo42420n(this.bJg, 0);
            AppMethodBeat.m2505o(55589);
            return;
        }
        AppMethodBeat.m2505o(55589);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: au */
    public final void mo18561au(Context context) {
        AppMethodBeat.m2504i(55590);
        if (isAvailable()) {
            context.unregisterReceiver(this.bJd);
            this.bJf.stop();
            AppMethodBeat.m2505o(55590);
            return;
        }
        AppMethodBeat.m2505o(55590);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vV */
    public final void mo18564vV() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vW */
    public final void mo18576vW() {
        AppMethodBeat.m2504i(55591);
        if (isAvailable() && this.isRunning && this.bJg < 90000) {
            this.bJf.mo42420n(90000, 0);
            AppMethodBeat.m2505o(55591);
            return;
        }
        AppMethodBeat.m2505o(55591);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vX */
    public final void mo18577vX() {
        AppMethodBeat.m2504i(55592);
        if (isAvailable() && this.isRunning && this.bJg < 90000) {
            this.bJf.mo42420n(this.bJg, 0);
            AppMethodBeat.m2505o(55592);
            return;
        }
        AppMethodBeat.m2505o(55592);
    }
}
