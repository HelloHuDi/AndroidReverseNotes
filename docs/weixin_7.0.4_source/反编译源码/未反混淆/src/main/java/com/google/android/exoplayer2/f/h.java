package com.google.android.exoplayer2.f;

import com.google.android.exoplayer2.b.e;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class h extends e implements Comparable<h> {
    public long aOr;

    public final /* synthetic */ int compareTo(Object obj) {
        AppMethodBeat.i(95656);
        h hVar = (h) obj;
        if (qG() == hVar.qG()) {
            long j = this.aSk - hVar.aSk;
            if (j == 0) {
                AppMethodBeat.o(95656);
                return 0;
            } else if (j > 0) {
                AppMethodBeat.o(95656);
                return 1;
            } else {
                AppMethodBeat.o(95656);
                return -1;
            }
        } else if (qG()) {
            AppMethodBeat.o(95656);
            return 1;
        } else {
            AppMethodBeat.o(95656);
            return -1;
        }
    }

    public h() {
        super(1);
    }
}
