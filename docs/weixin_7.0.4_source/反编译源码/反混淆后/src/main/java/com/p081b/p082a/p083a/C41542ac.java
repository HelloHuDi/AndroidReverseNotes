package com.p081b.p082a.p083a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.b.a.a.ac */
final class C41542ac extends C25393e {
    private final WifiManager bJj;

    C41542ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.bJj = wifiManager;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: vZ */
    public final void mo42422vZ() {
        AppMethodBeat.m2504i(55615);
        this.bJj.startScan();
        AppMethodBeat.m2505o(55615);
    }
}
