package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static b zYx = new b();
    public HandlerThread a = new HandlerThread("Vending-LogicThread");
    private Handler b;

    private b() {
        AppMethodBeat.i(126145);
        this.a.start();
        this.b = new Handler(this.a.getLooper());
        AppMethodBeat.o(126145);
    }

    static {
        AppMethodBeat.i(126146);
        AppMethodBeat.o(126146);
    }

    public static b dMs() {
        return zYx;
    }
}
