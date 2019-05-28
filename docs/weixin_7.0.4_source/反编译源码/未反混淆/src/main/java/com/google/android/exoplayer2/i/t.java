package com.google.android.exoplayer2.i;

import android.os.Trace;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {
    public static void beginSection(String str) {
        AppMethodBeat.i(95946);
        if (v.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
        AppMethodBeat.o(95946);
    }

    public static void endSection() {
        AppMethodBeat.i(95947);
        if (v.SDK_INT >= 18) {
            Trace.endSection();
        }
        AppMethodBeat.o(95947);
    }
}
