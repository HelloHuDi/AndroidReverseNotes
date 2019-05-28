package com.b.a.a;

import android.net.wifi.WifiManager;
import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class ac extends e {
    private final WifiManager bJj;

    ac(WifiManager wifiManager, Handler handler) {
        super(handler);
        this.bJj = wifiManager;
    }

    /* Access modifiers changed, original: final */
    public final void vZ() {
        AppMethodBeat.i(55615);
        this.bJj.startScan();
        AppMethodBeat.o(55615);
    }
}
