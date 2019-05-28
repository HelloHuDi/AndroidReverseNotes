package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.e;
import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.h;
import com.google.android.exoplayer2.c.k;
import com.google.android.exoplayer2.c.l;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a implements e, l {
    public static final h aTh = new h() {
        public final e[] ra() {
            AppMethodBeat.i(95184);
            e[] eVarArr = new e[]{new a()};
            AppMethodBeat.o(95184);
            return eVarArr;
        }
    };
    private g aTn;
    private m aVw;
    private b bdP;
    private int bdQ;
    private int bdR;

    static {
        AppMethodBeat.i(95189);
        AppMethodBeat.o(95189);
    }

    public final boolean a(f fVar) {
        AppMethodBeat.i(95185);
        if (c.m(fVar) != null) {
            AppMethodBeat.o(95185);
            return true;
        }
        AppMethodBeat.o(95185);
        return false;
    }

    public final void a(g gVar) {
        AppMethodBeat.i(95186);
        this.aTn = gVar;
        this.aVw = gVar.dM(0);
        this.bdP = null;
        gVar.rb();
        AppMethodBeat.o(95186);
    }

    public final void g(long j, long j2) {
        this.bdR = 0;
    }

    public final int a(f fVar, k kVar) {
        Object obj;
        long j;
        AppMethodBeat.i(95187);
        if (this.bdP == null) {
            this.bdP = c.m(fVar);
            if (this.bdP == null) {
                o oVar = new o("Unsupported or unrecognized wav header.");
                AppMethodBeat.o(95187);
                throw oVar;
            }
            b bVar = this.bdP;
            this.aVw.f(Format.a(null, "audio/raw", bVar.aRy * (bVar.aRj * bVar.bdU), 32768, this.bdP.aRy, this.bdP.aRj, this.bdP.encoding, null, null, 0, null));
            this.bdQ = this.bdP.bdT;
        }
        b bVar2 = this.bdP;
        if (bVar2.bdV == 0 || bVar2.dataSize == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            b bVar3 = this.bdP;
            com.google.android.exoplayer2.i.a.checkNotNull(fVar);
            com.google.android.exoplayer2.i.a.checkNotNull(bVar3);
            fVar.qY();
            com.google.android.exoplayer2.i.l lVar = new com.google.android.exoplayer2.i.l(8);
            a a = a.a(fVar, lVar);
            while (a.id != v.aT("data")) {
                new StringBuilder("Ignoring unknown WAV chunk: ").append(a.id);
                j = 8 + a.size;
                if (a.id == v.aT("RIFF")) {
                    j = 12;
                }
                if (j > 2147483647L) {
                    o oVar2 = new o("Chunk is too large (~2GB+) to skip; id: " + a.id);
                    AppMethodBeat.o(95187);
                    throw oVar2;
                }
                fVar.dG((int) j);
                a = a.a(fVar, lVar);
            }
            fVar.dG(8);
            j = fVar.getPosition();
            long j2 = a.size;
            bVar3.bdV = j;
            bVar3.dataSize = j2;
            this.aTn.a(this);
        }
        int a2 = this.aVw.a(fVar, 32768 - this.bdR, true);
        if (a2 != -1) {
            this.bdR += a2;
        }
        int i = this.bdR / this.bdQ;
        if (i > 0) {
            j = ((fVar.getPosition() - ((long) this.bdR)) * 1000000) / ((long) this.bdP.bdS);
            int i2 = i * this.bdQ;
            this.bdR -= i2;
            this.aVw.a(j, 1, i2, this.bdR, null);
        }
        if (a2 == -1) {
            AppMethodBeat.o(95187);
            return -1;
        }
        AppMethodBeat.o(95187);
        return 0;
    }

    public final long getDurationUs() {
        b bVar = this.bdP;
        return ((bVar.dataSize / ((long) bVar.bdT)) * 1000000) / ((long) bVar.aRj);
    }

    public final boolean qX() {
        return true;
    }

    public final long M(long j) {
        AppMethodBeat.i(95188);
        b bVar = this.bdP;
        long min = bVar.bdV + Math.min((((((long) bVar.bdS) * j) / 1000000) / ((long) bVar.bdT)) * ((long) bVar.bdT), bVar.dataSize - ((long) bVar.bdT));
        AppMethodBeat.o(95188);
        return min;
    }
}
