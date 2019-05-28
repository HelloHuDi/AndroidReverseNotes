package com.google.android.exoplayer2.e;

import com.tencent.matrix.trace.core.AppMethodBeat;

public interface c {
    public static final c beM = new c() {
        public final a e(String str, boolean z) {
            AppMethodBeat.i(95237);
            a e = d.e(str, z);
            AppMethodBeat.o(95237);
            return e;
        }

        public final a rJ() {
            AppMethodBeat.i(95238);
            a rJ = d.rJ();
            AppMethodBeat.o(95238);
            return rJ;
        }
    };

    a e(String str, boolean z);

    a rJ();
}
