package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class n extends w {
    private static final Object bhU = new Object();
    private final long aPk;
    private final long aPl;
    private final boolean aPm;
    private final boolean aPn;
    private final long bhV;
    private final long bhW;
    private final long bhX;
    private final long bhY;

    static {
        AppMethodBeat.i(95551);
        AppMethodBeat.o(95551);
    }

    public n(long j, boolean z) {
        this(j, j, z);
        AppMethodBeat.i(95547);
        AppMethodBeat.o(95547);
    }

    private n(long j, long j2, boolean z) {
        this(-9223372036854775807L, -9223372036854775807L, j, j2, 0, 0, z, false);
    }

    public n(long j, long j2, long j3, long j4, long j5, long j6, boolean z, boolean z2) {
        this.aPk = j;
        this.aPl = j2;
        this.bhV = j3;
        this.bhW = j4;
        this.bhX = j5;
        this.bhY = j6;
        this.aPm = z;
        this.aPn = z2;
    }

    public final int qg() {
        return 1;
    }

    public final b a(int i, b bVar, boolean z, long j) {
        AppMethodBeat.i(95548);
        a.bh(i, 1);
        Object obj = z ? bhU : null;
        long j2 = this.bhY;
        if (this.aPn) {
            j2 += j;
            if (j2 > this.bhW) {
                j2 = -9223372036854775807L;
            }
        }
        long j3 = this.aPk;
        long j4 = this.aPl;
        boolean z2 = this.aPm;
        boolean z3 = this.aPn;
        long j5 = this.bhW;
        long j6 = this.bhX;
        bVar.aPc = obj;
        bVar.aPk = j3;
        bVar.aPl = j4;
        bVar.aPm = z2;
        bVar.aPn = z3;
        bVar.aPq = j2;
        bVar.aOz = j5;
        bVar.aPo = 0;
        bVar.aPp = 0;
        bVar.aPr = j6;
        AppMethodBeat.o(95548);
        return bVar;
    }

    public final int qh() {
        return 1;
    }

    public final w.a a(int i, w.a aVar, boolean z) {
        Object obj;
        AppMethodBeat.i(95549);
        a.bh(i, 1);
        if (z) {
            obj = bhU;
        } else {
            obj = null;
        }
        long j = this.bhV;
        long j2 = -this.bhX;
        aVar.aPc = obj;
        aVar.aNH = obj;
        aVar.aNV = 0;
        aVar.aOz = j;
        aVar.aPd = j2;
        aVar.aPe = null;
        aVar.aPf = null;
        aVar.aPg = null;
        aVar.aPh = null;
        aVar.aPi = null;
        aVar.aPj = -9223372036854775807L;
        AppMethodBeat.o(95549);
        return aVar;
    }

    public final int ac(Object obj) {
        AppMethodBeat.i(95550);
        if (bhU.equals(obj)) {
            AppMethodBeat.o(95550);
            return 0;
        }
        AppMethodBeat.o(95550);
        return -1;
    }
}
