package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C8692k;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p100b.C32022e;
import com.google.android.exoplayer2.p101c.C32041m.C8663a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.source.j */
public final class C37282j {
    private int[] aSB = new int[this.capacity];
    private long[] aSD = new long[this.capacity];
    private int[] aXW = new int[this.capacity];
    private long bhA = Long.MIN_VALUE;
    private boolean bhB = true;
    private boolean bhC = true;
    private Format bhD;
    public int bhE;
    public int[] bht = new int[this.capacity];
    private C8663a[] bhu = new C8663a[this.capacity];
    private Format[] bhv = new Format[this.capacity];
    private int bhw;
    private int bhx;
    public int bhy;
    private long bhz = Long.MIN_VALUE;
    private int capacity = 1000;
    private int length;
    private long[] offsets = new long[this.capacity];

    /* renamed from: com.google.android.exoplayer2.source.j$a */
    public static final class C37283a {
        public C8663a aUO;
        public int size;
        /* renamed from: xb */
        public long f15849xb;
    }

    public C37282j() {
        AppMethodBeat.m2504i(95515);
        AppMethodBeat.m2505o(95515);
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

    /* renamed from: si */
    public final int mo59538si() {
        return this.bhw + this.length;
    }

    /* renamed from: sj */
    public final int mo59539sj() {
        return this.bhw + this.bhy;
    }

    /* renamed from: sk */
    public final synchronized boolean mo59540sk() {
        return this.bhy != this.length;
    }

    /* renamed from: sl */
    public final synchronized Format mo59541sl() {
        return this.bhC ? null : this.bhD;
    }

    /* renamed from: sc */
    public final synchronized long mo59537sc() {
        return this.bhA;
    }

    public final synchronized void rewind() {
        this.bhy = 0;
    }

    /* renamed from: a */
    public final synchronized int mo59528a(C8692k c8692k, C32022e c32022e, boolean z, boolean z2, Format format, C37283a c37283a) {
        int i = -4;
        synchronized (this) {
            AppMethodBeat.m2504i(95516);
            if (mo59540sk()) {
                int ep = mo59531ep(this.bhy);
                if (z || this.bhv[ep] != format) {
                    c8692k.aOv = this.bhv[ep];
                    AppMethodBeat.m2505o(95516);
                    i = -5;
                } else {
                    Object obj;
                    if (c32022e.aEY == null && c32022e.aSl == 0) {
                        obj = 1;
                    } else {
                        obj = null;
                    }
                    if (obj != null) {
                        AppMethodBeat.m2505o(95516);
                        i = -3;
                    } else {
                        c32022e.aSk = this.aSD[ep];
                        c32022e.flags = this.aXW[ep];
                        c37283a.size = this.aSB[ep];
                        c37283a.f15849xb = this.offsets[ep];
                        c37283a.aUO = this.bhu[ep];
                        this.bhy++;
                        AppMethodBeat.m2505o(95516);
                    }
                }
            } else if (z2) {
                c32022e.flags = 4;
                AppMethodBeat.m2505o(95516);
            } else if (this.bhD == null || (!z && this.bhD == format)) {
                AppMethodBeat.m2505o(95516);
                i = -3;
            } else {
                c8692k.aOv = this.bhD;
                AppMethodBeat.m2505o(95516);
                i = -5;
            }
        }
        return i;
    }

    /* renamed from: g */
    public final synchronized boolean mo59532g(long j, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(95517);
            int ep = mo59531ep(this.bhy);
            if (!mo59540sk() || j < this.aSD[ep] || (j > this.bhA && !z)) {
                AppMethodBeat.m2505o(95517);
            } else {
                int a = m62569a(ep, this.length - this.bhy, j, true);
                if (a == -1) {
                    AppMethodBeat.m2505o(95517);
                } else {
                    this.bhy += a;
                    AppMethodBeat.m2505o(95517);
                    z2 = true;
                }
            }
        }
        return z2;
    }

    /* renamed from: sm */
    public final synchronized void mo59542sm() {
        AppMethodBeat.m2504i(95518);
        if (mo59540sk()) {
            this.bhy = this.length;
            AppMethodBeat.m2505o(95518);
        } else {
            AppMethodBeat.m2505o(95518);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: h */
    public final synchronized long mo59533h(long j, boolean z) {
        long j2;
        AppMethodBeat.m2504i(95519);
        if (this.length == 0 || j < this.aSD[this.bhx]) {
            AppMethodBeat.m2505o(95519);
            j2 = -1;
        } else {
            int i;
            int a;
            if (z) {
                if (this.bhy != this.length) {
                    i = this.bhy + 1;
                    a = m62569a(this.bhx, i, j, false);
                    if (a != -1) {
                        AppMethodBeat.m2505o(95519);
                        j2 = -1;
                    } else {
                        j2 = m62571en(a);
                        AppMethodBeat.m2505o(95519);
                    }
                }
            }
            i = this.length;
            a = m62569a(this.bhx, i, j, false);
            if (a != -1) {
            }
        }
        return j2;
    }

    /* renamed from: sn */
    public final synchronized long mo59543sn() {
        long j;
        AppMethodBeat.m2504i(95520);
        if (this.bhy == 0) {
            j = -1;
            AppMethodBeat.m2505o(95520);
        } else {
            j = m62571en(this.bhy);
            AppMethodBeat.m2505o(95520);
        }
        return j;
    }

    /* renamed from: so */
    public final synchronized long mo59544so() {
        long j;
        AppMethodBeat.m2504i(95521);
        if (this.length == 0) {
            j = -1;
            AppMethodBeat.m2505o(95521);
        } else {
            j = m62571en(this.length);
            AppMethodBeat.m2505o(95521);
        }
        return j;
    }

    /* renamed from: i */
    public final synchronized boolean mo59534i(Format format) {
        boolean z = false;
        synchronized (this) {
            AppMethodBeat.m2504i(95522);
            if (format == null) {
                this.bhC = true;
                AppMethodBeat.m2505o(95522);
            } else {
                this.bhC = false;
                if (C17675v.m27574j(format, this.bhD)) {
                    AppMethodBeat.m2505o(95522);
                } else {
                    this.bhD = format;
                    AppMethodBeat.m2505o(95522);
                    z = true;
                }
            }
        }
        return z;
    }

    /* renamed from: a */
    public final synchronized void mo59529a(long j, int i, long j2, int i2, C8663a c8663a) {
        AppMethodBeat.m2504i(95523);
        if (this.bhB) {
            if ((i & 1) == 0) {
                AppMethodBeat.m2505o(95523);
            } else {
                this.bhB = false;
            }
        }
        C45039a.checkState(!this.bhC);
        m62570ab(j);
        int ep = mo59531ep(this.length);
        this.aSD[ep] = j;
        this.offsets[ep] = j2;
        this.aSB[ep] = i2;
        this.aXW[ep] = i;
        this.bhu[ep] = c8663a;
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
            C8663a[] c8663aArr = new C8663a[ep];
            Format[] formatArr = new Format[ep];
            int i3 = this.capacity - this.bhx;
            System.arraycopy(this.offsets, this.bhx, jArr, 0, i3);
            System.arraycopy(this.aSD, this.bhx, jArr2, 0, i3);
            System.arraycopy(this.aXW, this.bhx, iArr2, 0, i3);
            System.arraycopy(this.aSB, this.bhx, iArr3, 0, i3);
            System.arraycopy(this.bhu, this.bhx, c8663aArr, 0, i3);
            System.arraycopy(this.bhv, this.bhx, formatArr, 0, i3);
            System.arraycopy(this.bht, this.bhx, iArr, 0, i3);
            int i4 = this.bhx;
            System.arraycopy(this.offsets, 0, jArr, i3, i4);
            System.arraycopy(this.aSD, 0, jArr2, i3, i4);
            System.arraycopy(this.aXW, 0, iArr2, i3, i4);
            System.arraycopy(this.aSB, 0, iArr3, i3, i4);
            System.arraycopy(this.bhu, 0, c8663aArr, i3, i4);
            System.arraycopy(this.bhv, 0, formatArr, i3, i4);
            System.arraycopy(this.bht, 0, iArr, i3, i4);
            this.offsets = jArr;
            this.aSD = jArr2;
            this.aXW = iArr2;
            this.aSB = iArr3;
            this.bhu = c8663aArr;
            this.bhv = formatArr;
            this.bht = iArr;
            this.bhx = 0;
            this.length = this.capacity;
            this.capacity = ep;
        }
        AppMethodBeat.m2505o(95523);
    }

    /* renamed from: ab */
    private synchronized void m62570ab(long j) {
        AppMethodBeat.m2504i(95524);
        this.bhA = Math.max(this.bhA, j);
        AppMethodBeat.m2505o(95524);
    }

    /* renamed from: ac */
    public final synchronized boolean mo59530ac(long j) {
        boolean z = true;
        boolean z2 = false;
        synchronized (this) {
            AppMethodBeat.m2504i(95525);
            if (this.length == 0) {
                if (j > this.bhz) {
                    AppMethodBeat.m2505o(95525);
                } else {
                    AppMethodBeat.m2505o(95525);
                    z = false;
                }
            } else if (Math.max(this.bhz, m62572eo(this.bhy)) >= j) {
                AppMethodBeat.m2505o(95525);
                z = false;
            } else {
                int i = this.length;
                int ep = mo59531ep(this.length - 1);
                while (i > this.bhy && this.aSD[ep] >= j) {
                    i--;
                    ep--;
                    if (ep == -1) {
                        ep = this.capacity - 1;
                    }
                }
                ep = mo59538si() - (this.bhw + i);
                if (ep >= 0 && ep <= this.length - this.bhy) {
                    z2 = true;
                }
                C45039a.checkArgument(z2);
                this.length -= ep;
                this.bhA = Math.max(this.bhz, m62572eo(this.length));
                AppMethodBeat.m2505o(95525);
            }
        }
        return z;
    }

    /* renamed from: a */
    private int m62569a(int i, int i2, long j, boolean z) {
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

    /* renamed from: en */
    private long m62571en(int i) {
        AppMethodBeat.m2504i(95526);
        this.bhz = Math.max(this.bhz, m62572eo(i));
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
            AppMethodBeat.m2505o(95526);
            return j;
        }
        j = this.offsets[this.bhx];
        AppMethodBeat.m2505o(95526);
        return j;
    }

    /* renamed from: eo */
    private long m62572eo(int i) {
        AppMethodBeat.m2504i(95527);
        if (i == 0) {
            AppMethodBeat.m2505o(95527);
            return Long.MIN_VALUE;
        }
        int ep = mo59531ep(i - 1);
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
        AppMethodBeat.m2505o(95527);
        return j2;
    }

    /* renamed from: ep */
    public final int mo59531ep(int i) {
        int i2 = this.bhx + i;
        return i2 < this.capacity ? i2 : i2 - this.capacity;
    }
}
