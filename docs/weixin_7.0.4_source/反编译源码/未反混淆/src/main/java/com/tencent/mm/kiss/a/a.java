package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a eMK = new a();
    public HandlerThread eMJ = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        AppMethodBeat.i(105674);
        this.eMJ.start();
        this.mHandler = new Handler(this.eMJ.getLooper());
        AppMethodBeat.o(105674);
    }

    static {
        AppMethodBeat.i(105675);
        AppMethodBeat.o(105675);
    }

    public static a SL() {
        return eMK;
    }
}
