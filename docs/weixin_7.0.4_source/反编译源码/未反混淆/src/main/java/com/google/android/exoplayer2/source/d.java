package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.f;
import com.google.android.exoplayer2.w;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class d implements i, com.google.android.exoplayer2.source.i.a {
    private final i aNu;
    private a bgA;
    private final long bgr;
    private final long bgs;
    private final boolean bgx;
    private final ArrayList<c> bgy;
    private com.google.android.exoplayer2.source.i.a bgz;

    static final class a extends w {
        private final w aNc;
        private final long bgr;
        private final long bgs;

        public a(w wVar, long j, long j2) {
            AppMethodBeat.i(95462);
            com.google.android.exoplayer2.i.a.checkArgument(wVar.qg() == 1);
            com.google.android.exoplayer2.i.a.checkArgument(wVar.qh() == 1);
            b a = wVar.a(0, new b());
            com.google.android.exoplayer2.i.a.checkArgument(!a.aPn);
            if (j2 == Long.MIN_VALUE) {
                j2 = a.aOz;
            }
            if (a.aOz != -9223372036854775807L) {
                if (j2 > a.aOz) {
                    j2 = a.aOz;
                }
                boolean z = j == 0 || a.aPm;
                com.google.android.exoplayer2.i.a.checkArgument(z);
                com.google.android.exoplayer2.i.a.checkArgument(j <= j2);
            }
            com.google.android.exoplayer2.i.a.checkArgument(wVar.a(0, new com.google.android.exoplayer2.w.a(), false).aPd == 0);
            this.aNc = wVar;
            this.bgr = j;
            this.bgs = j2;
            AppMethodBeat.o(95462);
        }

        public final int qg() {
            return 1;
        }

        public final int aZ(int i, int i2) {
            AppMethodBeat.i(95463);
            int aZ = this.aNc.aZ(i, i2);
            AppMethodBeat.o(95463);
            return aZ;
        }

        public final b a(int i, b bVar, boolean z, long j) {
            long j2;
            AppMethodBeat.i(95464);
            b a = this.aNc.a(0, bVar, z, j);
            a.aOz = this.bgs != -9223372036854775807L ? this.bgs - this.bgr : -9223372036854775807L;
            if (a.aPq != -9223372036854775807L) {
                a.aPq = Math.max(a.aPq, this.bgr);
                if (this.bgs == -9223372036854775807L) {
                    j2 = a.aPq;
                } else {
                    j2 = Math.min(a.aPq, this.bgs);
                }
                a.aPq = j2;
                a.aPq -= this.bgr;
            }
            j2 = com.google.android.exoplayer2.b.w(this.bgr);
            if (a.aPk != -9223372036854775807L) {
                a.aPk += j2;
            }
            if (a.aPl != -9223372036854775807L) {
                a.aPl = j2 + a.aPl;
            }
            AppMethodBeat.o(95464);
            return a;
        }

        public final int qh() {
            return 1;
        }

        public final com.google.android.exoplayer2.w.a a(int i, com.google.android.exoplayer2.w.a aVar, boolean z) {
            long j = -9223372036854775807L;
            AppMethodBeat.i(95465);
            com.google.android.exoplayer2.w.a a = this.aNc.a(0, aVar, z);
            if (this.bgs != -9223372036854775807L) {
                j = this.bgs - this.bgr;
            }
            a.aOz = j;
            AppMethodBeat.o(95465);
            return a;
        }

        public final int ac(Object obj) {
            AppMethodBeat.i(95466);
            int ac = this.aNc.ac(obj);
            AppMethodBeat.o(95466);
            return ac;
        }
    }

    public d(i iVar, long j, long j2) {
        this(iVar, j, j2, (byte) 0);
    }

    private d(i iVar, long j, long j2, byte b) {
        AppMethodBeat.i(95467);
        com.google.android.exoplayer2.i.a.checkArgument(j >= 0);
        this.aNu = (i) com.google.android.exoplayer2.i.a.checkNotNull(iVar);
        this.bgr = j;
        this.bgs = j2;
        this.bgx = true;
        this.bgy = new ArrayList();
        AppMethodBeat.o(95467);
    }

    public final void a(f fVar, com.google.android.exoplayer2.source.i.a aVar) {
        AppMethodBeat.i(95468);
        this.bgz = aVar;
        this.aNu.a(fVar, (com.google.android.exoplayer2.source.i.a) this);
        AppMethodBeat.o(95468);
    }

    public final void rX() {
        AppMethodBeat.i(95469);
        this.aNu.rX();
        AppMethodBeat.o(95469);
    }

    public final h a(i.b bVar, com.google.android.exoplayer2.h.b bVar2) {
        AppMethodBeat.i(95470);
        c cVar = new c(this.aNu.a(bVar, bVar2), this.bgx);
        this.bgy.add(cVar);
        cVar.i(this.bgA.bgr, this.bgA.bgs);
        AppMethodBeat.o(95470);
        return cVar;
    }

    public final void b(h hVar) {
        AppMethodBeat.i(95471);
        com.google.android.exoplayer2.i.a.checkState(this.bgy.remove(hVar));
        this.aNu.b(((c) hVar).aNG);
        AppMethodBeat.o(95471);
    }

    public final void rY() {
        AppMethodBeat.i(95472);
        this.aNu.rY();
        AppMethodBeat.o(95472);
    }

    public final void a(w wVar, Object obj) {
        long j;
        AppMethodBeat.i(95473);
        this.bgA = new a(wVar, this.bgr, this.bgs);
        this.bgz.a(this.bgA, obj);
        long a = this.bgA.bgr;
        if (this.bgA.bgs == -9223372036854775807L) {
            j = Long.MIN_VALUE;
        } else {
            j = this.bgA.bgs;
        }
        int size = this.bgy.size();
        for (int i = 0; i < size; i++) {
            ((c) this.bgy.get(i)).i(a, j);
        }
        AppMethodBeat.o(95473);
    }
}
