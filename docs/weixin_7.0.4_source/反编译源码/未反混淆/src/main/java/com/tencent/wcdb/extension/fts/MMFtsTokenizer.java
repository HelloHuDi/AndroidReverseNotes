package com.tencent.wcdb.extension.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;

public final class MMFtsTokenizer implements SQLiteExtension {
    public static final SQLiteExtension EXTENSION = new MMFtsTokenizer();

    private static native void nativeInitialize(long j, long j2);

    static {
        AppMethodBeat.i(12641);
        AppMethodBeat.o(12641);
    }

    private MMFtsTokenizer() {
    }

    public final void initialize(long j, long j2) {
        AppMethodBeat.i(12640);
        nativeInitialize(j, j2);
        AppMethodBeat.o(12640);
    }
}
