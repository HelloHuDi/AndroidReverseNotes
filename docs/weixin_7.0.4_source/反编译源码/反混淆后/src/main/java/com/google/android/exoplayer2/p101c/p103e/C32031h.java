package com.google.android.exoplayer2.p101c.p103e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C37247l.C17646a;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.e.h */
abstract class C32031h {
    private C8662g aTn;
    private C32041m aVw;
    private long aZU;
    private C32032a baA;
    private long baB;
    private boolean baC;
    private boolean baD;
    private final C0844d baw = new C0844d();
    private C37237f bax;
    long bay;
    private long baz;
    private int sampleRate;
    int state;

    /* renamed from: com.google.android.exoplayer2.c.e.h$a */
    static class C32032a {
        Format aOv;
        C37237f bax;

        C32032a() {
        }
    }

    /* renamed from: com.google.android.exoplayer2.c.e.h$b */
    static final class C32033b implements C37237f {
        private C32033b() {
        }

        /* synthetic */ C32033b(byte b) {
            this();
        }

        /* renamed from: i */
        public final long mo2551i(C45026f c45026f) {
            return -1;
        }

        /* renamed from: S */
        public final long mo2549S(long j) {
            return 0;
        }

        /* renamed from: rk */
        public final C37247l mo2553rk() {
            AppMethodBeat.m2504i(95050);
            C17646a c17646a = new C17646a(-9223372036854775807L);
            AppMethodBeat.m2505o(95050);
            return c17646a;
        }
    }

    /* renamed from: a */
    public abstract boolean mo32321a(C32065l c32065l, long j, C32032a c32032a);

    /* renamed from: s */
    public abstract long mo32323s(C32065l c32065l);

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo52328a(C8662g c8662g, C32041m c32041m) {
        this.aTn = c8662g;
        this.aVw = c32041m;
        reset(true);
    }

    /* Access modifiers changed, original: protected */
    public void reset(boolean z) {
        if (z) {
            this.baA = new C32032a();
            this.bay = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.aZU = -1;
        this.baz = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final void mo52330g(long j, long j2) {
        boolean z = false;
        C0844d c0844d = this.baw;
        c0844d.aZP.reset();
        c0844d.bah.reset();
        c0844d.bai = -1;
        c0844d.baj = false;
        if (j == 0) {
            if (!this.baC) {
                z = true;
            }
            reset(z);
        } else if (this.state != 0) {
            this.aZU = this.bax.mo2549S(j2);
            this.state = 2;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: l */
    public final int mo52331l(C45026f c45026f) {
        boolean z = true;
        while (z) {
            if (this.baw.mo2554k(c45026f)) {
                this.baB = c45026f.getPosition() - this.bay;
                z = mo32321a(this.baw.bah, this.bay, this.baA);
                if (z) {
                    this.bay = c45026f.getPosition();
                }
            } else {
                this.state = 3;
                return -1;
            }
        }
        this.sampleRate = this.baA.aOv.sampleRate;
        if (!this.baD) {
            this.aVw.mo42836f(this.baA.aOv);
            this.baD = true;
        }
        if (this.baA.bax != null) {
            this.bax = this.baA.bax;
        } else if (c45026f.getLength() == -1) {
            this.bax = new C32033b();
        } else {
            C32030e c32030e = this.baw.aZP;
            this.bax = new C17637a(this.bay, c45026f.getLength(), this, c32030e.aVG + c32030e.bar, c32030e.bam);
        }
        this.baA = null;
        this.state = 2;
        C0844d c0844d = this.baw;
        if (c0844d.bah.data.length == 65025) {
            return 0;
        }
        c0844d.bah.data = Arrays.copyOf(c0844d.bah.data, Math.max(65025, c0844d.bah.limit));
        return 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final int mo52329b(C45026f c45026f, C32040k c32040k) {
        long i = this.bax.mo2551i(c45026f);
        if (i >= 0) {
            c32040k.position = i;
            return 1;
        }
        if (i < -1) {
            mo32320V(-(i + 2));
        }
        if (!this.baC) {
            this.aTn.mo19156a(this.bax.mo2553rk());
            this.baC = true;
        }
        if (this.baB > 0 || this.baw.mo2554k(c45026f)) {
            this.baB = 0;
            C32065l c32065l = this.baw.bah;
            long s = mo32323s(c32065l);
            if (s >= 0 && this.baz + s >= this.aZU) {
                long T = mo52326T(this.baz);
                this.aVw.mo42835a(c32065l, c32065l.limit);
                this.aVw.mo42834a(T, 1, c32065l.limit, 0, null);
                this.aZU = -1;
            }
            this.baz += s;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: T */
    public final long mo52326T(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: U */
    public final long mo52327U(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: V */
    public void mo32320V(long j) {
        this.baz = j;
    }
}
