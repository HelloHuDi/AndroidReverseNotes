package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.i;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c implements h, com.google.android.exoplayer2.source.h.a {
    public final h aNG;
    private com.google.android.exoplayer2.source.h.a bgq;
    private long bgr = -9223372036854775807L;
    private long bgs = -9223372036854775807L;
    private a[] bgt = new a[0];
    private boolean bgu;

    static final class a implements l {
        final l aMt;
        private final h aNG;
        private final long bgr;
        private final long bgs;
        boolean bgv;
        boolean bgw;

        public a(h hVar, l lVar, long j, long j2, boolean z) {
            this.aNG = hVar;
            this.aMt = lVar;
            this.bgr = j;
            this.bgs = j2;
            this.bgv = z;
        }

        public final boolean isReady() {
            AppMethodBeat.i(95445);
            boolean isReady = this.aMt.isReady();
            AppMethodBeat.o(95445);
            return isReady;
        }

        public final void rW() {
            AppMethodBeat.i(95446);
            this.aMt.rW();
            AppMethodBeat.o(95446);
        }

        public final int b(k kVar, e eVar, boolean z) {
            AppMethodBeat.i(95447);
            if (this.bgv) {
                AppMethodBeat.o(95447);
                return -3;
            } else if (this.bgw) {
                eVar.flags = 4;
                AppMethodBeat.o(95447);
                return -4;
            } else {
                int b = this.aMt.b(kVar, eVar, z);
                if (this.bgs == Long.MIN_VALUE || ((b != -4 || eVar.aSk < this.bgs) && !(b == -3 && this.aNG.rU() == Long.MIN_VALUE))) {
                    if (b == -4 && !eVar.qG()) {
                        eVar.aSk -= this.bgr;
                    }
                    AppMethodBeat.o(95447);
                    return b;
                }
                eVar.clear();
                eVar.flags = 4;
                this.bgw = true;
                AppMethodBeat.o(95447);
                return -4;
            }
        }

        public final void Z(long j) {
            AppMethodBeat.i(95448);
            this.aMt.Z(this.bgr + j);
            AppMethodBeat.o(95448);
        }
    }

    public c(h hVar, boolean z) {
        AppMethodBeat.i(95449);
        this.aNG = hVar;
        this.bgu = z;
        AppMethodBeat.o(95449);
    }

    public final void i(long j, long j2) {
        this.bgr = j;
        this.bgs = j2;
    }

    public final void a(com.google.android.exoplayer2.source.h.a aVar, long j) {
        AppMethodBeat.i(95450);
        this.bgq = aVar;
        this.aNG.a(this, this.bgr + j);
        AppMethodBeat.o(95450);
    }

    public final void rR() {
        AppMethodBeat.i(95451);
        this.aNG.rR();
        AppMethodBeat.o(95451);
    }

    public final p rS() {
        AppMethodBeat.i(95452);
        p rS = this.aNG.rS();
        AppMethodBeat.o(95452);
        return rS;
    }

    public final long a(f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        AppMethodBeat.i(95453);
        this.bgt = new a[lVarArr.length];
        l[] lVarArr2 = new l[lVarArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= lVarArr.length) {
                break;
            }
            l lVar;
            this.bgt[i] = (a) lVarArr[i];
            if (this.bgt[i] != null) {
                lVar = this.bgt[i].aMt;
            } else {
                lVar = null;
            }
            lVarArr2[i] = lVar;
            i2 = i + 1;
        }
        long a = this.aNG.a(fVarArr, zArr, lVarArr2, zArr2, j + this.bgr);
        if (this.bgu) {
            if (this.bgr != 0) {
                Object obj;
                for (f fVar : fVarArr) {
                    if (fVar != null && !i.aH(fVar.tg().aOd)) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj != null) {
                    z = true;
                    this.bgu = z;
                }
            }
            z = false;
            this.bgu = z;
        }
        z = a == this.bgr + j || (a >= this.bgr && (this.bgs == Long.MIN_VALUE || a <= this.bgs));
        com.google.android.exoplayer2.i.a.checkState(z);
        i2 = 0;
        while (i2 < lVarArr.length) {
            if (lVarArr2[i2] == null) {
                this.bgt[i2] = null;
            } else if (lVarArr[i2] == null || this.bgt[i2].aMt != lVarArr2[i2]) {
                this.bgt[i2] = new a(this, lVarArr2[i2], this.bgr, this.bgs, this.bgu);
            }
            lVarArr[i2] = this.bgt[i2];
            i2++;
        }
        long j2 = a - this.bgr;
        AppMethodBeat.o(95453);
        return j2;
    }

    public final void W(long j) {
        AppMethodBeat.i(95454);
        this.aNG.W(this.bgr + j);
        AppMethodBeat.o(95454);
    }

    public final long rT() {
        boolean z = false;
        AppMethodBeat.i(95455);
        long rT;
        if (this.bgu) {
            for (a aVar : this.bgt) {
                if (aVar != null) {
                    aVar.bgv = false;
                }
            }
            this.bgu = false;
            rT = rT();
            if (rT != -9223372036854775807L) {
                AppMethodBeat.o(95455);
                return rT;
            }
            AppMethodBeat.o(95455);
            return 0;
        }
        long rT2 = this.aNG.rT();
        if (rT2 == -9223372036854775807L) {
            AppMethodBeat.o(95455);
            return -9223372036854775807L;
        }
        boolean z2;
        if (rT2 >= this.bgr) {
            z2 = true;
        } else {
            z2 = false;
        }
        com.google.android.exoplayer2.i.a.checkState(z2);
        if (this.bgs == Long.MIN_VALUE || rT2 <= this.bgs) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        rT = rT2 - this.bgr;
        AppMethodBeat.o(95455);
        return rT;
    }

    public final long rU() {
        AppMethodBeat.i(95456);
        long rU = this.aNG.rU();
        if (rU == Long.MIN_VALUE || (this.bgs != Long.MIN_VALUE && rU >= this.bgs)) {
            AppMethodBeat.o(95456);
            return Long.MIN_VALUE;
        }
        long max = Math.max(0, rU - this.bgr);
        AppMethodBeat.o(95456);
        return max;
    }

    public final long X(long j) {
        boolean z = false;
        AppMethodBeat.i(95457);
        for (a aVar : this.bgt) {
            if (aVar != null) {
                aVar.bgw = false;
            }
        }
        long X = this.aNG.X(this.bgr + j);
        if (X == this.bgr + j || (X >= this.bgr && (this.bgs == Long.MIN_VALUE || X <= this.bgs))) {
            z = true;
        }
        com.google.android.exoplayer2.i.a.checkState(z);
        long j2 = X - this.bgr;
        AppMethodBeat.o(95457);
        return j2;
    }

    public final long rV() {
        AppMethodBeat.i(95458);
        long rV = this.aNG.rV();
        if (rV == Long.MIN_VALUE || (this.bgs != Long.MIN_VALUE && rV >= this.bgs)) {
            AppMethodBeat.o(95458);
            return Long.MIN_VALUE;
        }
        long j = rV - this.bgr;
        AppMethodBeat.o(95458);
        return j;
    }

    public final boolean Y(long j) {
        AppMethodBeat.i(95459);
        boolean Y = this.aNG.Y(this.bgr + j);
        AppMethodBeat.o(95459);
        return Y;
    }

    public final void a(h hVar) {
        AppMethodBeat.i(95460);
        boolean z = (this.bgr == -9223372036854775807L || this.bgs == -9223372036854775807L) ? false : true;
        com.google.android.exoplayer2.i.a.checkState(z);
        this.bgq.a(this);
        AppMethodBeat.o(95460);
    }
}
