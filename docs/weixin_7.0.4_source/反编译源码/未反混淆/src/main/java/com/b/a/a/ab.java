package com.b.a.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class ab extends c {
    private static ab bJc;
    WifiManager bCU;
    private final BroadcastReceiver bJd = new BroadcastReceiver() {
        public final void onReceive(Context context, Intent intent) {
            AppMethodBeat.i(55584);
            if (intent.getAction().equals("android.net.wifi.SCAN_RESULTS")) {
                ab abVar = ab.this;
                try {
                    List scanResults = abVar.bCU.getScanResults();
                    if (scanResults == null || scanResults.isEmpty()) {
                        Exception exception = new Exception("WifiScanMsg: null or empty scan result list");
                        AppMethodBeat.o(55584);
                        throw exception;
                    }
                    abVar.c(new a(scanResults));
                    AppMethodBeat.o(55584);
                    return;
                } catch (Exception e) {
                }
            }
            AppMethodBeat.o(55584);
        }
    };
    private final IntentFilter bJe = new IntentFilter("android.net.wifi.SCAN_RESULTS");
    private ac bJf;
    private long bJg = 10000;

    static class a extends p {
        final List<ScanResult> bJi;

        a(List<ScanResult> list) {
            super(101);
            this.bJi = list;
        }
    }

    private ab() {
        AppMethodBeat.i(55585);
        AppMethodBeat.o(55585);
    }

    static ab wD() {
        AppMethodBeat.i(55586);
        if (bJc == null) {
            bJc = new ab();
        }
        ab abVar = bJc;
        AppMethodBeat.o(55586);
        return abVar;
    }

    private boolean isAvailable() {
        return this.bCU != null;
    }

    /* Access modifiers changed, original: final|declared_synchronized */
    public final synchronized void a(Handler handler, a aVar) {
        AppMethodBeat.i(55587);
        if (aVar == null) {
            aVar = new a(10000);
        }
        super.a(handler, aVar);
        AppMethodBeat.o(55587);
    }

    /* Access modifiers changed, original: final */
    public final void at(Context context) {
        AppMethodBeat.i(55588);
        this.bCU = (WifiManager) context.getSystemService("wifi");
        AppMethodBeat.o(55588);
    }

    /* Access modifiers changed, original: final */
    public final void a(Context context, Handler handler, a aVar) {
        AppMethodBeat.i(55589);
        if (isAvailable()) {
            context.registerReceiver(this.bJd, this.bJe, null, handler);
            this.bJg = aVar.bCP;
            WifiManager wifiManager = this.bCU;
            if (handler == null) {
                handler = new Handler(context.getMainLooper());
            }
            this.bJf = new ac(wifiManager, handler);
            this.bJf.n(this.bJg, 0);
            AppMethodBeat.o(55589);
            return;
        }
        AppMethodBeat.o(55589);
    }

    /* Access modifiers changed, original: final */
    public final void au(Context context) {
        AppMethodBeat.i(55590);
        if (isAvailable()) {
            context.unregisterReceiver(this.bJd);
            this.bJf.stop();
            AppMethodBeat.o(55590);
            return;
        }
        AppMethodBeat.o(55590);
    }

    /* Access modifiers changed, original: final */
    public final void vV() {
    }

    /* Access modifiers changed, original: final */
    public final void vW() {
        AppMethodBeat.i(55591);
        if (isAvailable() && this.isRunning && this.bJg < 90000) {
            this.bJf.n(90000, 0);
            AppMethodBeat.o(55591);
            return;
        }
        AppMethodBeat.o(55591);
    }

    /* Access modifiers changed, original: final */
    public final void vX() {
        AppMethodBeat.i(55592);
        if (isAvailable() && this.isRunning && this.bJg < 90000) {
            this.bJf.n(this.bJg, 0);
            AppMethodBeat.o(55592);
            return;
        }
        AppMethodBeat.o(55592);
    }
}
