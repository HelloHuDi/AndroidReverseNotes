package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a zYw = new a();
    public HandlerThread a = new HandlerThread("Vending-HeavyWorkThread", 10);
    private Handler b;

    private a() {
        AppMethodBeat.i(126143);
        this.a.start();
        this.b = new Handler(this.a.getLooper());
        AppMethodBeat.o(126143);
    }

    static {
        AppMethodBeat.i(126144);
        AppMethodBeat.o(126144);
    }

    public static a dMr() {
        return zYw;
    }
}
