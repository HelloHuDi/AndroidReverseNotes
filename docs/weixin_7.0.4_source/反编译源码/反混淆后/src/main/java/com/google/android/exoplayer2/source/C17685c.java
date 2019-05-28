package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p111i.C37265i;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C37279h.C37280a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.source.c */
public final class C17685c implements C37279h, C37280a {
    public final C37279h aNG;
    private C37280a bgq;
    private long bgr = -9223372036854775807L;
    private long bgs = -9223372036854775807L;
    private C17686a[] bgt = new C17686a[0];
    private boolean bgu;

    /* renamed from: com.google.android.exoplayer2.source.c$a */
    static final class C17686a implements C17688l {
        final C17688l aMt;
        private final C37279h aNG;
        private final long bgr;
        private final long bgs;
        boolean bgv;
        boolean bgw;

        public C17686a(C37279h c37279h, C17688l c17688l, long j, long j2, boolean z) {
            this.aNG = c37279h;
            this.aMt = c17688l;
            this.bgr = j;
            this.bgs = j2;
            this.bgv = z;
        }

        public final boolean isReady() {
            AppMethodBeat.m2504i(95445);
            boolean isReady = this.aMt.isReady();
            AppMethodBeat.m2505o(95445);
            return isReady;
        }

        /* renamed from: rW */
        public final void mo19295rW() {
            AppMethodBeat.m2504i(95446);
            this.aMt.mo19295rW();
            AppMethodBeat.m2505o(95446);
        }

        /* renamed from: b */
        public final int mo19293b(C8692k c8692k, C32022e c32022e, boolean z) {
            AppMethodBeat.m2504i(95447);
            if (this.bgv) {
                AppMethodBeat.m2505o(95447);
                return -3;
            } else if (this.bgw) {
                c32022e.flags = 4;
                AppMethodBeat.m2505o(95447);
                return -4;
            } else {
                int b = this.aMt.mo19293b(c8692k, c32022e, z);
                if (this.bgs == Long.MIN_VALUE || ((b != -4 || c32022e.aSk < this.bgs) && !(b == -3 && this.aNG.mo19284rU() == Long.MIN_VALUE))) {
                    if (b == -4 && !c32022e.mo42774qG()) {
                        c32022e.aSk -= this.bgr;
                    }
                    AppMethodBeat.m2505o(95447);
                    return b;
                }
                c32022e.clear();
                c32022e.flags = 4;
                this.bgw = true;
                AppMethodBeat.m2505o(95447);
                return -4;
            }
        }

        /* renamed from: Z */
        public final void mo19292Z(long j) {
            AppMethodBeat.m2504i(95448);
            this.aMt.mo19292Z(this.bgr + j);
            AppMethodBeat.m2505o(95448);
        }
    }

    public C17685c(C37279h c37279h, boolean z) {
        AppMethodBeat.m2504i(95449);
        this.aNG = c37279h;
        this.bgu = z;
        AppMethodBeat.m2505o(95449);
    }

    /* renamed from: i */
    public final void mo32389i(long j, long j2) {
        this.bgr = j;
        this.bgs = j2;
    }

    /* renamed from: a */
    public final void mo19278a(C37280a c37280a, long j) {
        AppMethodBeat.m2504i(95450);
        this.bgq = c37280a;
        this.aNG.mo19278a(this, this.bgr + j);
        AppMethodBeat.m2505o(95450);
    }

    /* renamed from: rR */
    public final void mo19281rR() {
        AppMethodBeat.m2504i(95451);
        this.aNG.mo19281rR();
        AppMethodBeat.m2505o(95451);
    }

    /* renamed from: rS */
    public final C41631p mo19282rS() {
        AppMethodBeat.m2504i(95452);
        C41631p rS = this.aNG.mo19282rS();
        AppMethodBeat.m2505o(95452);
        return rS;
    }

    /* renamed from: a */
    public final long mo19276a(C45035f[] c45035fArr, boolean[] zArr, C17688l[] c17688lArr, boolean[] zArr2, long j) {
        int i;
        boolean z;
        AppMethodBeat.m2504i(95453);
        this.bgt = new C17686a[c17688lArr.length];
        C17688l[] c17688lArr2 = new C17688l[c17688lArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= c17688lArr.length) {
                break;
            }
            C17688l c17688l;
            this.bgt[i] = (C17686a) c17688lArr[i];
            if (this.bgt[i] != null) {
                c17688l = this.bgt[i].aMt;
            } else {
                c17688l = null;
            }
            c17688lArr2[i] = c17688l;
            i2 = i + 1;
        }
        long a = this.aNG.mo19276a(c45035fArr, zArr, c17688lArr2, zArr2, j + this.bgr);
        if (this.bgu) {
            if (this.bgr != 0) {
                Object obj;
                for (C45035f c45035f : c45035fArr) {
                    if (c45035f != null && !C37265i.m62522aH(c45035f.mo19207tg().aOd)) {
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
        C45039a.checkState(z);
        i2 = 0;
        while (i2 < c17688lArr.length) {
            if (c17688lArr2[i2] == null) {
                this.bgt[i2] = null;
            } else if (c17688lArr[i2] == null || this.bgt[i2].aMt != c17688lArr2[i2]) {
                this.bgt[i2] = new C17686a(this, c17688lArr2[i2], this.bgr, this.bgs, this.bgu);
            }
            c17688lArr[i2] = this.bgt[i2];
            i2++;
        }
        long j2 = a - this.bgr;
        AppMethodBeat.m2505o(95453);
        return j2;
    }

    /* renamed from: W */
    public final void mo19273W(long j) {
        AppMethodBeat.m2504i(95454);
        this.aNG.mo19273W(this.bgr + j);
        AppMethodBeat.m2505o(95454);
    }

    /* renamed from: rT */
    public final long mo19283rT() {
        boolean z = false;
        AppMethodBeat.m2504i(95455);
        long rT;
        if (this.bgu) {
            for (C17686a c17686a : this.bgt) {
                if (c17686a != null) {
                    c17686a.bgv = false;
                }
            }
            this.bgu = false;
            rT = mo19283rT();
            if (rT != -9223372036854775807L) {
                AppMethodBeat.m2505o(95455);
                return rT;
            }
            AppMethodBeat.m2505o(95455);
            return 0;
        }
        long rT2 = this.aNG.mo19283rT();
        if (rT2 == -9223372036854775807L) {
            AppMethodBeat.m2505o(95455);
            return -9223372036854775807L;
        }
        boolean z2;
        if (rT2 >= this.bgr) {
            z2 = true;
        } else {
            z2 = false;
        }
        C45039a.checkState(z2);
        if (this.bgs == Long.MIN_VALUE || rT2 <= this.bgs) {
            z = true;
        }
        C45039a.checkState(z);
        rT = rT2 - this.bgr;
        AppMethodBeat.m2505o(95455);
        return rT;
    }

    /* renamed from: rU */
    public final long mo19284rU() {
        AppMethodBeat.m2504i(95456);
        long rU = this.aNG.mo19284rU();
        if (rU == Long.MIN_VALUE || (this.bgs != Long.MIN_VALUE && rU >= this.bgs)) {
            AppMethodBeat.m2505o(95456);
            return Long.MIN_VALUE;
        }
        long max = Math.max(0, rU - this.bgr);
        AppMethodBeat.m2505o(95456);
        return max;
    }

    /* renamed from: X */
    public final long mo19274X(long j) {
        boolean z = false;
        AppMethodBeat.m2504i(95457);
        for (C17686a c17686a : this.bgt) {
            if (c17686a != null) {
                c17686a.bgw = false;
            }
        }
        long X = this.aNG.mo19274X(this.bgr + j);
        if (X == this.bgr + j || (X >= this.bgr && (this.bgs == Long.MIN_VALUE || X <= this.bgs))) {
            z = true;
        }
        C45039a.checkState(z);
        long j2 = X - this.bgr;
        AppMethodBeat.m2505o(95457);
        return j2;
    }

    /* renamed from: rV */
    public final long mo19285rV() {
        AppMethodBeat.m2504i(95458);
        long rV = this.aNG.mo19285rV();
        if (rV == Long.MIN_VALUE || (this.bgs != Long.MIN_VALUE && rV >= this.bgs)) {
            AppMethodBeat.m2505o(95458);
            return Long.MIN_VALUE;
        }
        long j = rV - this.bgr;
        AppMethodBeat.m2505o(95458);
        return j;
    }

    /* renamed from: Y */
    public final boolean mo19275Y(long j) {
        AppMethodBeat.m2504i(95459);
        boolean Y = this.aNG.mo19275Y(this.bgr + j);
        AppMethodBeat.m2505o(95459);
        return Y;
    }

    /* renamed from: a */
    public final void mo32388a(C37279h c37279h) {
        AppMethodBeat.m2504i(95460);
        boolean z = (this.bgr == -9223372036854775807L || this.bgs == -9223372036854775807L) ? false : true;
        C45039a.checkState(z);
        this.bgq.mo32388a(this);
        AppMethodBeat.m2505o(95460);
    }
}
