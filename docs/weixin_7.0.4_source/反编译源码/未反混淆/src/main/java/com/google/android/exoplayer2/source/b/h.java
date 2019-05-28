package com.google.android.exoplayer2.source.b;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.h.t;
import com.google.android.exoplayer2.j;
import com.google.android.exoplayer2.source.b.a.c;
import com.google.android.exoplayer2.source.b.a.d;
import com.google.android.exoplayer2.source.b.a.e.e;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.source.i.a;
import com.google.android.exoplayer2.source.i.b;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.n;
import com.google.android.exoplayer2.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

public final class h implements e, i {
    private final int bgC;
    private a bgz;
    private com.google.android.exoplayer2.source.b.a.e bir;
    private final d bjb;
    private final com.google.android.exoplayer2.source.a.a bjc;
    private final Uri bjj;
    private final t.a<c> bjk;

    static {
        AppMethodBeat.i(125936);
        j.ar("goog.exo.hls");
        AppMethodBeat.o(125936);
    }

    public h(Uri uri, f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2) {
        this(uri, aVar, handler, aVar2, (byte) 0);
    }

    private h(Uri uri, f.a aVar, Handler handler, com.google.android.exoplayer2.source.a aVar2, byte b) {
        this(uri, new b(aVar), handler, aVar2);
        AppMethodBeat.i(125927);
        AppMethodBeat.o(125927);
    }

    private h(Uri uri, d dVar, Handler handler, com.google.android.exoplayer2.source.a aVar) {
        this(uri, dVar, handler, aVar, new d());
        AppMethodBeat.i(125928);
        AppMethodBeat.o(125928);
    }

    private h(Uri uri, d dVar, Handler handler, com.google.android.exoplayer2.source.a aVar, t.a<c> aVar2) {
        AppMethodBeat.i(125929);
        this.bjj = uri;
        this.bjb = dVar;
        this.bgC = 3;
        this.bjk = aVar2;
        this.bjc = new com.google.android.exoplayer2.source.a.a(handler, aVar);
        AppMethodBeat.o(125929);
    }

    public final void a(com.google.android.exoplayer2.f fVar, a aVar) {
        AppMethodBeat.i(125930);
        com.google.android.exoplayer2.i.a.checkState(this.bir == null);
        this.bir = new com.google.android.exoplayer2.source.b.a.e(this.bjj, this.bjb, this.bjc, this.bgC, this, this.bjk);
        this.bgz = aVar;
        com.google.android.exoplayer2.source.b.a.e eVar = this.bir;
        eVar.bkG.a(new t(eVar.bjb.st(), eVar.bkA, eVar.bjk), eVar, eVar.bkB);
        AppMethodBeat.o(125930);
    }

    public final void rX() {
        AppMethodBeat.i(125931);
        com.google.android.exoplayer2.source.b.a.e eVar = this.bir;
        if (eVar.bkH != null) {
            eVar.d(eVar.bkH);
        }
        AppMethodBeat.o(125931);
    }

    public final com.google.android.exoplayer2.source.h a(b bVar, com.google.android.exoplayer2.h.b bVar2) {
        AppMethodBeat.i(125932);
        com.google.android.exoplayer2.i.a.checkArgument(bVar.bhq == 0);
        g gVar = new g(this.bir, this.bjb, this.bgC, this.bjc, bVar2);
        AppMethodBeat.o(125932);
        return gVar;
    }

    public final void b(com.google.android.exoplayer2.source.h hVar) {
        AppMethodBeat.i(125933);
        g gVar = (g) hVar;
        gVar.bir.bkF.remove(gVar);
        gVar.bje.removeCallbacksAndMessages(null);
        for (j jVar : gVar.bjg) {
            boolean a = jVar.bgI.a(jVar);
            if (jVar.prepared && !a) {
                for (k sq : jVar.bgO) {
                    sq.sq();
                }
            }
            jVar.handler.removeCallbacksAndMessages(null);
            jVar.released = true;
        }
        AppMethodBeat.o(125933);
    }

    public final void rY() {
        AppMethodBeat.i(125934);
        if (this.bir != null) {
            com.google.android.exoplayer2.source.b.a.e eVar = this.bir;
            eVar.bkG.a(null);
            for (com.google.android.exoplayer2.source.b.a.e.a aVar : eVar.bkC.values()) {
                aVar.bkL.a(null);
            }
            eVar.bkD.removeCallbacksAndMessages(null);
            eVar.bkC.clear();
            this.bir = null;
        }
        this.bgz = null;
        AppMethodBeat.o(125934);
    }

    public final void a(com.google.android.exoplayer2.source.b.a.b bVar) {
        w nVar;
        AppMethodBeat.i(125935);
        long j = bVar.bjQ ? 0 : -9223372036854775807L;
        long w = bVar.bjQ ? com.google.android.exoplayer2.b.w(bVar.bif) : -9223372036854775807L;
        long j2 = bVar.bjJ;
        if (this.bir.bkJ) {
            boolean z;
            long j3 = bVar.bjP ? bVar.aOz + bVar.bif : -9223372036854775807L;
            List list = bVar.bjS;
            if (j2 == -9223372036854775807L) {
                long j4;
                if (list.isEmpty()) {
                    j4 = 0;
                } else {
                    j4 = ((com.google.android.exoplayer2.source.b.a.b.a) list.get(Math.max(0, list.size() - 3))).bjU;
                }
                j2 = j4;
            }
            long j5 = bVar.aOz;
            long j6 = bVar.bif;
            if (bVar.bjP) {
                z = false;
            } else {
                z = true;
            }
            nVar = new n(j, w, j3, j5, j6, j2, true, z);
        } else {
            if (j2 == -9223372036854775807L) {
                j2 = 0;
            }
            nVar = new n(j, w, bVar.bif + bVar.aOz, bVar.aOz, bVar.bif, j2, true, false);
        }
        this.bgz.a(nVar, new e(this.bir.biH, bVar));
        AppMethodBeat.o(125935);
    }
}
