package com.google.android.exoplayer2.c.e;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

abstract class h {
    private g aTn;
    private m aVw;
    private long aZU;
    private a baA;
    private long baB;
    private boolean baC;
    private boolean baD;
    private final d baw = new d();
    private f bax;
    long bay;
    private long baz;
    private int sampleRate;
    int state;

    static class a {
        Format aOv;
        f bax;

        a() {
        }
    }

    static final class b implements f {
        private b() {
        }

        /* synthetic */ b(byte b) {
            this();
        }

        public final long i(f fVar) {
            return -1;
        }

        public final long S(long j) {
            return 0;
        }

        public final l rk() {
            AppMethodBeat.i(95050);
            com.google.android.exoplayer2.c.l.a aVar = new com.google.android.exoplayer2.c.l.a(-9223372036854775807L);
            AppMethodBeat.o(95050);
            return aVar;
        }
    }

    public abstract boolean a(com.google.android.exoplayer2.i.l lVar, long j, a aVar);

    public abstract long s(com.google.android.exoplayer2.i.l lVar);

    /* Access modifiers changed, original: final */
    public final void a(g gVar, m mVar) {
        this.aTn = gVar;
        this.aVw = mVar;
        reset(true);
    }

    /* Access modifiers changed, original: protected */
    public void reset(boolean z) {
        if (z) {
            this.baA = new a();
            this.bay = 0;
            this.state = 0;
        } else {
            this.state = 1;
        }
        this.aZU = -1;
        this.baz = 0;
    }

    /* Access modifiers changed, original: final */
    public final void g(long j, long j2) {
        boolean z = false;
        d dVar = this.baw;
        dVar.aZP.reset();
        dVar.bah.reset();
        dVar.bai = -1;
        dVar.baj = false;
        if (j == 0) {
            if (!this.baC) {
                z = true;
            }
            reset(z);
        } else if (this.state != 0) {
            this.aZU = this.bax.S(j2);
            this.state = 2;
        }
    }

    /* Access modifiers changed, original: final */
    public final int l(f fVar) {
        boolean z = true;
        while (z) {
            if (this.baw.k(fVar)) {
                this.baB = fVar.getPosition() - this.bay;
                z = a(this.baw.bah, this.bay, this.baA);
                if (z) {
                    this.bay = fVar.getPosition();
                }
            } else {
                this.state = 3;
                return -1;
            }
        }
        this.sampleRate = this.baA.aOv.sampleRate;
        if (!this.baD) {
            this.aVw.f(this.baA.aOv);
            this.baD = true;
        }
        if (this.baA.bax != null) {
            this.bax = this.baA.bax;
        } else if (fVar.getLength() == -1) {
            this.bax = new b();
        } else {
            e eVar = this.baw.aZP;
            this.bax = new a(this.bay, fVar.getLength(), this, eVar.aVG + eVar.bar, eVar.bam);
        }
        this.baA = null;
        this.state = 2;
        d dVar = this.baw;
        if (dVar.bah.data.length == 65025) {
            return 0;
        }
        dVar.bah.data = Arrays.copyOf(dVar.bah.data, Math.max(65025, dVar.bah.limit));
        return 0;
    }

    /* Access modifiers changed, original: final */
    public final int b(f fVar, k kVar) {
        long i = this.bax.i(fVar);
        if (i >= 0) {
            kVar.position = i;
            return 1;
        }
        if (i < -1) {
            V(-(i + 2));
        }
        if (!this.baC) {
            this.aTn.a(this.bax.rk());
            this.baC = true;
        }
        if (this.baB > 0 || this.baw.k(fVar)) {
            this.baB = 0;
            com.google.android.exoplayer2.i.l lVar = this.baw.bah;
            long s = s(lVar);
            if (s >= 0 && this.baz + s >= this.aZU) {
                long T = T(this.baz);
                this.aVw.a(lVar, lVar.limit);
                this.aVw.a(T, 1, lVar.limit, 0, null);
                this.aZU = -1;
            }
            this.baz += s;
            return 0;
        }
        this.state = 3;
        return -1;
    }

    /* Access modifiers changed, original: protected|final */
    public final long T(long j) {
        return (1000000 * j) / ((long) this.sampleRate);
    }

    /* Access modifiers changed, original: protected|final */
    public final long U(long j) {
        return (((long) this.sampleRate) * j) / 1000000;
    }

    /* Access modifiers changed, original: protected */
    public void V(long j) {
        this.baz = j;
    }
}
