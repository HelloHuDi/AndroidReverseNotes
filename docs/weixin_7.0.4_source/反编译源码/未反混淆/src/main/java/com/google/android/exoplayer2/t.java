package com.google.android.exoplayer2;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class t {
    public static final t aOE = new t(0);
    public final int aOF;

    static {
        AppMethodBeat.i(95392);
        AppMethodBeat.o(95392);
    }

    public t(int i) {
        this.aOF = i;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(95391);
        if (this == obj) {
            AppMethodBeat.o(95391);
            return true;
        } else if (obj == null || getClass() != obj.getClass()) {
            AppMethodBeat.o(95391);
            return false;
        } else {
            if (this.aOF == ((t) obj).aOF) {
                AppMethodBeat.o(95391);
                return true;
            }
            AppMethodBeat.o(95391);
            return false;
        }
    }

    public final int hashCode() {
        return this.aOF;
    }
}
