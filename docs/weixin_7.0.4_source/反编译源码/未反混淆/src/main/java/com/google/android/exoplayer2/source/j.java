package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.k;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j {
    private int[] aSB = new int[this.capacity];
    private long[] aSD = new long[this.capacity];
    private int[] aXW = new int[this.capacity];
    private long bhA = Long.MIN_VALUE;
    private boolean bhB = true;
    private boolean bhC = true;
    private Format bhD;
    public int bhE;
    public int[] bht = new int[this.capacity];
    private com.google.android.exoplayer2.c.m.a[] bhu = new com.google.android.exoplayer2.c.m.a[this.capacity];
    private Format[] bhv = new Format[this.capacity];
    private int bhw;
    private int bhx;
    public int bhy;
    private long bhz = Long.MIN_VALUE;
    private int capacity = 1000;
    private int length;
    private long[] offsets = new long[this.capacity];

    public static final class a {
        public com.google.android.exoplayer2.c.m.a aUO;
        public int size;
        public long xb;
    }

    public j() {
        AppMethodBeat.i(95515);
        AppMethodBeat.o(95515);
    }

    public final void reset(boolean z) {
        this.length = 0;
        this.bhw = 0;
        this.bhx = 0;
        this.bhy = 0;
        this.bhB = true;
        this.bhz = Long.MIN_VALUE;
        this.bhA = Long.MIN_VALUE;
        if (z) {
            this.bhD = null;
            this.bhC = true;
        }
    }

    public final int si() {
        return this.bhw + this.length;
    }

    public final int sj() {
        return this.bhw + this.bhy;
    }

    public final synchronized boolean sk() {
        return this.bhy != this.length;
    }

    public final synchronized Format sl() {
        return this.bhC ? null : this.bhD;
    }

    public final synchronized long sc() {
        return this.bhA;
    }

    public final synchronized void rewind() {
        this.bhy = 0;
    }

    public final synchronized int a(k kVar, e eVar, boolean z, boolean z2, Format format, a aVar) {
        int i = -4;
        synchronized (this) {
            AppMethodBeat.i(95516);
            if (sk()) {
                int ep = ep(this.bhy);
                if (z || this.bhv[ep] != format) {
                    kVar.aOv = this.bhv[ep];
                    AppMethodBeat.o(95516);
                    i = -5;
                } else {
                    Object obj;
                    if (eVar.aEY == null && eVar.aSl == 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        AppMethodBeat.o(95516);
                        i = -3;
                    } else {
                        eVar.aSk = this.aSD[ep];
                        eVar.flags = this.aXW[ep];
                        aVar.size = this.aSB[ep];
                        aVar.xb = this.offsets[ep];
                        aVar.aUO = this.bhu[ep];
                        this.bhy++;
                        AppMethodBeat.o(95516);
                    }
                }
            } else if (z2) {
                eVar.flags = 4;
                AppMethodBeat.o(95516);
            } else if (this.bhD == null || (!z && this.bhD == format)) {
                AppMethodBeat.o(95516);
                i = -3;
            } else {
                kVar.aOv = this.bhD;
                AppMethodBeat.o(95516);
                i = -5;
            }
        }
        return i;
    }

    public final synchronized boolean g(long j, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(95517);
            int ep = ep(this.bhy);
            if (!sk() || j < this.aSD[ep] || (j > this.bhA && !z)) {
                AppMethodBeat.o(95517);
            } else {
                int a = a(ep, this.length - this.bhy, j, true);
                if (a == -1) {
                    AppMethodBeat.o(95517);
                } else {
                    this.bhy += a;
                    AppMethodBeat.o(95517);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    public final synchronized void sm() {
        AppMethodBeat.i(95518);
        if (sk()) {
            this.bhy = this.length;
            AppMethodBeat.o(95518);
        } else {
            AppMethodBeat.o(95518);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized long h(long j, boolean z) {
        long j2;
        AppMethodBeat.i(95519);
        if (this.length == 0 || j < this.aSD[this.bhx]) {
            AppMethodBeat.o(95519);
            j2 = -1;
        } else {
            int i;
            int a;
            if (z) {
                if (this.bhy != this.length) {
                    i = this.bhy + 1;
                    a = a(this.bhx, i, j, false);
                    if (a != -1) {
                        AppMethodBeat.o(95519);
                        j2 = -1;
                    } else {
                        j2 = en(a);
                        AppMethodBeat.o(95519);
                    }
                }
            }
            i = this.length;
            a = a(this.bhx, i, j, false);
            if (a != -1) {
            }
        }
        return j2;
    }

    public final synchronized long sn() {
        long j;
        AppMethodBeat.i(95520);
        if (this.bhy == 0) {
            j = -1;
            AppMethodBeat.o(95520);
        } else {
            j = en(this.bhy);
            AppMethodBeat.o(95520);
        }
        return j;
    }

    public final synchronized long so() {
        long j;
        AppMethodBeat.i(95521);
        if (this.length == 0) {
            j = -1;
            AppMethodBeat.o(95521);
        } else {
            j = en(this.length);
            AppMethodBeat.o(95521);
        }
        return j;
    }

    public final synchronized boolean i(Format format) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.i(95522);
            if (format == null) {
                this.bhC = true;
                AppMethodBeat.o(95522);
            } else {
                this.bhC = false;
                if (v.j(format, this.bhD)) {
                    AppMethodBeat.o(95522);
                } else {
                    this.bhD = format;
                    AppMethodBeat.o(95522);
                    z = true;
                }
            }
        }
        return z;
    }

    public final synchronized void a(long j, int i, long j2, int i2, com.google.android.exoplayer2.c.m.a aVar) {
        AppMethodBeat.i(95523);
        if (this.bhB) {
            if ((i & 1) == 0) {
                AppMethodBeat.o(95523);
            } else {
                this.bhB = false;
            }
        }
        com.google.android.exoplayer2.i.a.checkState(!this.bhC);
        ab(j);
        int ep = ep(this.length);
        this.aSD[ep] = j;
        this.offsets[ep] = j2;
        this.aSB[ep] = i2;
        this.aXW[ep] = i;
        this.bhu[ep] = aVar;
        this.bhv[ep] = this.bhD;
        this.bht[ep] = this.bhE;
        this.length++;
        if (this.length == this.capacity) {
            ep = this.capacity + 1000;
            int[] iArr = new int[ep];
            long[] jArr = new long[ep];
            long[] jArr2 = new long[ep];
            int[] iArr2 = new int[ep];
            int[] iArr3 = new int[ep];
            com.google.android.exoplayer2.c.m.a[] aVarArr = new com.google.android.exoplayer2.c.m.a[ep];
            Format[] formatArr = new Format[ep];
            int i3 = this.capacity - this.bhx;
            System.arraycopy(this.offsets, this.bhx, jArr, 0, i3);
            System.arraycopy(this.aSD, this.bhx, jArr2, 0, i3);
            System.arraycopy(this.aXW, this.bhx, iArr2, 0, i3);
            System.arraycopy(this.aSB, this.bhx, iArr3, 0, i3);
            System.arraycopy(this.bhu, this.bhx, aVarArr, 0, i3);
            System.arraycopy(this.bhv, this.bhx, formatArr, 0, i3);
            System.arraycopy(this.bht, this.bhx, iArr, 0, i3);
            int i4 = this.bhx;
            System.arraycopy(this.offsets, 0, jArr, i3, i4);
            System.arraycopy(this.aSD, 0, jArr2, i3, i4);
            System.arraycopy(this.aXW, 0, iArr2, i3, i4);
            System.arraycopy(this.aSB, 0, iArr3, i3, i4);
            System.arraycopy(this.bhu, 0, aVarArr, i3, i4);
            System.arraycopy(this.bhv, 0, formatArr, i3, i4);
            System.arraycopy(this.bht, 0, iArr, i3, i4);
            this.offsets = jArr;
            this.aSD = jArr2;
            this.aXW = iArr2;
            this.aSB = iArr3;
            this.bhu = aVarArr;
            this.bhv = formatArr;
            this.bht = iArr;
            this.bhx = 0;
            this.length = this.capacity;
            this.capacity = ep;
        }
        AppMethodBeat.o(95523);
    }

    private synchronized void ab(long j) {
        AppMethodBeat.i(95524);
        this.bhA = Math.max(this.bhA, j);
        AppMethodBeat.o(95524);
    }

    public final synchronized boolean ac(long j) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.i(95525);
            if (this.length == 0) {
                if (j > this.bhz) {
                    AppMethodBeat.o(95525);
                } else {
                    AppMethodBeat.o(95525);
                    z = false;
                }
            } else if (Math.max(this.bhz, eo(this.bhy)) >= j) {
                AppMethodBeat.o(95525);
                z = false;
            } else {
                int i = this.length;
                int ep = ep(this.length - 1);
                while (i > this.bhy && this.aSD[ep] >= j) {
                    i--;
                    ep--;
                    if (ep == -1) {
                        ep = this.capacity - 1;
                    }
                }
                ep = si() - (this.bhw + i);
                if (ep >= 0 && ep <= this.length - this.bhy) {
                    z2 = true;
                }
                com.google.android.exoplayer2.i.a.checkArgument(z2);
                this.length -= ep;
                this.bhA = Math.max(this.bhz, eo(this.length));
                AppMethodBeat.o(95525);
            }
        }
        return z;
    }

    private int a(int i, int i2, long j, boolean z) {
        int i3 = -1;
        int i4 = 0;
        while (i4 < i2 && this.aSD[i] <= j) {
            if (!(z && (this.aXW[i] & 1) == 0)) {
                i3 = i4;
            }
            int i5 = i + 1;
            if (i5 == this.capacity) {
                i5 = 0;
            }
            i4++;
            i = i5;
        }
        return i3;
    }

    private long en(int i) {
        AppMethodBeat.i(95526);
        this.bhz = Math.max(this.bhz, eo(i));
        this.length -= i;
        this.bhw += i;
        this.bhx += i;
        if (this.bhx >= this.capacity) {
            this.bhx -= this.capacity;
        }
        this.bhy -= i;
        if (this.bhy < 0) {
            this.bhy = 0;
        }
        long j;
        if (this.length == 0) {
            int i2 = (this.bhx == 0 ? this.capacity : this.bhx) - 1;
            j = ((long) this.aSB[i2]) + this.offsets[i2];
            AppMethodBeat.o(95526);
            return j;
        }
        j = this.offsets[this.bhx];
        AppMethodBeat.o(95526);
        return j;
    }

    private long eo(int i) {
        AppMethodBeat.i(95527);
        if (i == 0) {
            AppMethodBeat.o(95527);
            return Long.MIN_VALUE;
        }
        int ep = ep(i - 1);
        int i2 = 0;
        long j = Long.MIN_VALUE;
        while (i2 < i) {
            j = Math.max(j, this.aSD[ep]);
            if ((this.aXW[ep] & 1) != 0) {
                break;
            }
            int i3 = ep - 1;
            if (i3 == -1) {
                i3 = this.capacity - 1;
            }
            i2++;
            ep = i3;
        }
        long j2 = j;
        AppMethodBeat.o(95527);
        return j2;
    }

    public final int ep(int i) {
        int i2 = this.bhx + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
