package com.google.android.exoplayer2.source.b;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.b.e;
import com.google.android.exoplayer2.k;
import com.google.android.exoplayer2.source.a.a;
import com.google.android.exoplayer2.source.a.a.AnonymousClass5;
import com.google.android.exoplayer2.source.j;
import com.google.android.exoplayer2.source.l;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i implements l {
    public final int bjl;
    private final j bjm;

    public i(j jVar, int i) {
        this.bjm = jVar;
        this.bjl = i;
    }

    public final boolean isReady() {
        AppMethodBeat.i(125937);
        j jVar = this.bjm;
        int i = this.bjl;
        if (jVar.bhc || (!jVar.sd() && jVar.bgO[i].bhG.sk())) {
            AppMethodBeat.o(125937);
            return true;
        }
        AppMethodBeat.o(125937);
        return false;
    }

    public final void rW() {
        AppMethodBeat.i(125938);
        this.bjm.bjo.rW();
        AppMethodBeat.o(125938);
    }

    public final int b(k kVar, e eVar, boolean z) {
        AppMethodBeat.i(125939);
        j jVar = this.bjm;
        int i = this.bjl;
        if (jVar.sd()) {
            AppMethodBeat.o(125939);
            return -3;
        }
        int i2;
        if (!jVar.bjr.isEmpty()) {
            int i3;
            while (jVar.bjr.size() > 1) {
                Object obj;
                i3 = ((f) jVar.bjr.getFirst()).uid;
                for (i2 = 0; i2 < jVar.bgO.length; i2++) {
                    if (jVar.bjw[i2]) {
                        int i4;
                        j jVar2 = jVar.bgO[i2].bhG;
                        int ep = jVar2.ep(jVar2.bhy);
                        if (jVar2.sk()) {
                            i4 = jVar2.bht[ep];
                        } else {
                            i4 = jVar2.bhE;
                        }
                        if (i4 == i3) {
                            obj = null;
                            break;
                        }
                    }
                }
                i2 = 1;
                if (obj == null) {
                    break;
                }
                jVar.bjr.removeFirst();
            }
            f fVar = (f) jVar.bjr.getFirst();
            Format format = fVar.bic;
            if (!format.equals(jVar.bjs)) {
                a aVar = jVar.bjc;
                int i5 = jVar.aMr;
                i3 = fVar.bid;
                Object obj2 = fVar.bie;
                long j = fVar.bif;
                if (aVar.bfZ != null) {
                    aVar.handler.post(new AnonymousClass5(i5, format, i3, obj2, j));
                }
            }
            jVar.bjs = format;
        }
        i2 = jVar.bgO[i].a(kVar, eVar, z, jVar.bhc, jVar.bgZ);
        AppMethodBeat.o(125939);
        return i2;
    }

    public final void Z(long j) {
        AppMethodBeat.i(125940);
        j jVar = this.bjm;
        com.google.android.exoplayer2.source.k kVar = jVar.bgO[this.bjl];
        if (!jVar.bhc || j <= kVar.bhG.sc()) {
            kVar.g(j, true);
            AppMethodBeat.o(125940);
            return;
        }
        kVar.bhG.sm();
        AppMethodBeat.o(125940);
    }
}
