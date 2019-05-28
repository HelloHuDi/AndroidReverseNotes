package com.google.android.exoplayer2.f.c;

import com.google.android.exoplayer2.f.a;
import com.google.android.exoplayer2.f.d;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

final class b implements d {
    private final long[] bnA;
    private final a[] bnz;

    public b(a[] aVarArr, long[] jArr) {
        this.bnz = aVarArr;
        this.bnA = jArr;
    }

    public final int aj(long j) {
        AppMethodBeat.i(95643);
        int a = v.a(this.bnA, j, false, false);
        if (a < this.bnA.length) {
            AppMethodBeat.o(95643);
            return a;
        }
        AppMethodBeat.o(95643);
        return -1;
    }

    public final int sG() {
        return this.bnA.length;
    }

    public final long et(int i) {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(95644);
        if (i >= 0) {
            z = true;
        } else {
            z = false;
        }
        com.google.android.exoplayer2.i.a.checkArgument(z);
        if (i >= this.bnA.length) {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.checkArgument(z2);
        long j = this.bnA[i];
        AppMethodBeat.o(95644);
        return j;
    }

    public final List<a> ak(long j) {
        AppMethodBeat.i(95645);
        int a = v.a(this.bnA, j, false);
        if (a == -1 || this.bnz[a] == null) {
            List emptyList = Collections.emptyList();
            AppMethodBeat.o(95645);
            return emptyList;
        }
        List<a> singletonList = Collections.singletonList(this.bnz[a]);
        AppMethodBeat.o(95645);
        return singletonList;
    }
}
