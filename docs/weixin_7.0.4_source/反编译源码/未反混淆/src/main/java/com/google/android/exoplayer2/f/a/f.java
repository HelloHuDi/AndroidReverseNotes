package com.google.android.exoplayer2.f.a;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class f implements d {
    private final List<a> blz;

    public f(List<a> list) {
        this.blz = list;
    }

    public final int aj(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int sG() {
        return 1;
    }

    public final long et(int i) {
        AppMethodBeat.i(95617);
        com.google.android.exoplayer2.i.a.checkArgument(i == 0);
        AppMethodBeat.o(95617);
        return 0;
    }

    public final List<a> ak(long j) {
        AppMethodBeat.i(95618);
        if (j >= 0) {
            List list = this.blz;
            AppMethodBeat.o(95618);
            return list;
        }
        List<a> emptyList = Collections.emptyList();
        AppMethodBeat.o(95618);
        return emptyList;
    }
}
