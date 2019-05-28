package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class e extends Exception {
    public final int aMM;
    public final int type;

    public static e b(Exception exception, int i) {
        AppMethodBeat.i(94771);
        e eVar = new e(1, exception, i);
        AppMethodBeat.o(94771);
        return eVar;
    }

    public static e a(IOException iOException) {
        AppMethodBeat.i(94772);
        e eVar = new e(0, iOException, -1);
        AppMethodBeat.o(94772);
        return eVar;
    }

    static e a(RuntimeException runtimeException) {
        AppMethodBeat.i(94773);
        e eVar = new e(2, runtimeException, -1);
        AppMethodBeat.o(94773);
        return eVar;
    }

    private e(int i, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.aMM = i2;
    }
}
