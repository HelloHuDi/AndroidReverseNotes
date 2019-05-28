package com.tencent.mm.pluginsdk.g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;

public final class b extends IOException {
    private final long aHW;
    private final long veU;

    public b() {
        this(0, 0);
    }

    public b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        AppMethodBeat.i(79564);
        this.aHW = j;
        this.veU = j2;
        AppMethodBeat.o(79564);
    }

    public final String toString() {
        AppMethodBeat.i(79565);
        String str = "FileSizeOutOfRangeException{contentLength=" + this.aHW + ", requestRange=" + this.veU + '}';
        AppMethodBeat.o(79565);
        return str;
    }
}
