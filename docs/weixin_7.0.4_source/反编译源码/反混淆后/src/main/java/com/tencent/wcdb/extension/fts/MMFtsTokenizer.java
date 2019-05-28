package com.tencent.wcdb.extension.fts;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.extension.SQLiteExtension;

public final class MMFtsTokenizer implements SQLiteExtension {
    public static final SQLiteExtension EXTENSION = new MMFtsTokenizer();

    private static native void nativeInitialize(long j, long j2);

    static {
        AppMethodBeat.m2504i(12641);
        AppMethodBeat.m2505o(12641);
    }

    private MMFtsTokenizer() {
    }

    public final void initialize(long j, long j2) {
        AppMethodBeat.m2504i(12640);
        nativeInitialize(j, j2);
        AppMethodBeat.m2505o(12640);
    }
}
