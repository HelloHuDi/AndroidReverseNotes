package com.google.android.exoplayer2.f.f;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b implements d {
    public static final b boq = new b();
    private final List<a> blz;

    static {
        AppMethodBeat.i(95707);
        AppMethodBeat.o(95707);
    }

    public b(a aVar) {
        AppMethodBeat.i(95703);
        this.blz = Collections.singletonList(aVar);
        AppMethodBeat.o(95703);
    }

    private b() {
        AppMethodBeat.i(95704);
        this.blz = Collections.emptyList();
        AppMethodBeat.o(95704);
    }

    public final int aj(long j) {
        return j < 0 ? 0 : -1;
    }

    public final int sG() {
        return 1;
    }

    public final long et(int i) {
        AppMethodBeat.i(95705);
        com.google.android.exoplayer2.i.a.checkArgument(i == 0);
        AppMethodBeat.o(95705);
        return 0;
    }

    public final List<a> ak(long j) {
        AppMethodBeat.i(95706);
        if (j >= 0) {
            List list = this.blz;
            AppMethodBeat.o(95706);
            return list;
        }
        List<a> emptyList = Collections.emptyList();
        AppMethodBeat.o(95706);
        return emptyList;
    }
}
