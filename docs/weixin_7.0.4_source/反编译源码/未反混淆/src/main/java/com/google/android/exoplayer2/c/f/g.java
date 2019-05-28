package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.a;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

public final class g implements h {
    private int aUG;
    private final List<a> bbF;
    private final m[] bbG;
    private boolean bbH;
    private int bbI;
    private long bbJ;

    public g(List<a> list) {
        AppMethodBeat.i(95106);
        this.bbF = list;
        this.bbG = new m[list.size()];
        AppMethodBeat.o(95106);
    }

    public final void rn() {
        this.bbH = false;
    }

    public final void a(com.google.android.exoplayer2.c.g gVar, d dVar) {
        AppMethodBeat.i(95107);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbG.length) {
                a aVar = (a) this.bbF.get(i2);
                dVar.rz();
                m dM = gVar.dM(dVar.rA());
                dM.f(Format.a(dVar.rB(), "application/dvbsubs", Collections.singletonList(aVar.bdI), aVar.aOt, null));
                this.bbG[i2] = dM;
                i = i2 + 1;
            } else {
                AppMethodBeat.o(95107);
                return;
            }
        }
    }

    public final void d(long j, boolean z) {
        if (z) {
            this.bbH = true;
            this.bbJ = j;
            this.aUG = 0;
            this.bbI = 2;
        }
    }

    public final void ro() {
        AppMethodBeat.i(95108);
        if (this.bbH) {
            for (m a : this.bbG) {
                a.a(this.bbJ, 1, this.aUG, 0, null);
            }
            this.bbH = false;
        }
        AppMethodBeat.o(95108);
    }

    public final void t(l lVar) {
        int i = 0;
        AppMethodBeat.i(95109);
        if (this.bbH) {
            if (this.bbI == 2 && !e(lVar, 32)) {
                AppMethodBeat.o(95109);
                return;
            } else if (this.bbI != 1 || e(lVar, 0)) {
                int i2 = lVar.position;
                int tB = lVar.tB();
                m[] mVarArr = this.bbG;
                int length = mVarArr.length;
                while (i < length) {
                    m mVar = mVarArr[i];
                    lVar.setPosition(i2);
                    mVar.a(lVar, tB);
                    i++;
                }
                this.aUG += tB;
            } else {
                AppMethodBeat.o(95109);
                return;
            }
        }
        AppMethodBeat.o(95109);
    }

    private boolean e(l lVar, int i) {
        AppMethodBeat.i(95110);
        if (lVar.tB() == 0) {
            AppMethodBeat.o(95110);
            return false;
        }
        if (lVar.readUnsignedByte() != i) {
            this.bbH = false;
        }
        this.bbI--;
        boolean z = this.bbH;
        AppMethodBeat.o(95110);
        return z;
    }
}
