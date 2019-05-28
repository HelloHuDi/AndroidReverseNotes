package com.google.android.exoplayer2.c.g;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.i.l;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.BitUtils;

final class c {

    static final class a {
        public final int id;
        public final long size;

        private a(int i, long j) {
            this.id = i;
            this.size = j;
        }

        public static a a(f fVar, l lVar) {
            AppMethodBeat.i(95190);
            fVar.b(lVar.data, 0, 8);
            lVar.setPosition(0);
            a aVar = new a(lVar.readInt(), lVar.tE());
            AppMethodBeat.o(95190);
            return aVar;
        }
    }

    public static b m(f fVar) {
        AppMethodBeat.i(95191);
        com.google.android.exoplayer2.i.a.checkNotNull(fVar);
        l lVar = new l(16);
        if (a.a(fVar, lVar).id != v.aT("RIFF")) {
            AppMethodBeat.o(95191);
            return null;
        }
        fVar.b(lVar.data, 0, 4);
        lVar.setPosition(0);
        if (lVar.readInt() != v.aT("WAVE")) {
            AppMethodBeat.o(95191);
            return null;
        }
        a a;
        while (true) {
            a = a.a(fVar, lVar);
            if (a.id == v.aT("fmt ")) {
                break;
            }
            fVar.dH((int) a.size);
        }
        com.google.android.exoplayer2.i.a.checkState(a.size >= 16);
        fVar.b(lVar.data, 0, 16);
        lVar.setPosition(0);
        int tC = lVar.tC();
        int tC2 = lVar.tC();
        int tJ = lVar.tJ();
        int tJ2 = lVar.tJ();
        int tC3 = lVar.tC();
        int tC4 = lVar.tC();
        int i = (tC2 * tC4) / 8;
        if (tC3 != i) {
            o oVar = new o("Expected block alignment: " + i + "; got: " + tC3);
            AppMethodBeat.o(95191);
            throw oVar;
        }
        i = v.eR(tC4);
        if (i == 0) {
            AppMethodBeat.o(95191);
            return null;
        } else if (tC == 1 || tC == BitUtils.BIT_TURN_ZERO_1) {
            fVar.dH(((int) a.size) - 16);
            b bVar = new b(tC2, tJ, tJ2, tC3, tC4, i);
            AppMethodBeat.o(95191);
            return bVar;
        } else {
            AppMethodBeat.o(95191);
            return null;
        }
    }
}
