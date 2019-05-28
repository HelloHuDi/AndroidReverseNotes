package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.a;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class s {
    private final List<Format> bbD;
    private final m[] bbG;

    public s(List<Format> list) {
        AppMethodBeat.i(95160);
        this.bbD = list;
        this.bbG = new m[list.size()];
        AppMethodBeat.o(95160);
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95161);
        for (int i = 0; i < this.bbG.length; i++) {
            boolean z;
            dVar.rz();
            m dM = gVar.dM(dVar.rA());
            Format format = (Format) this.bbD.get(i);
            String str = format.aOd;
            if ("application/cea-608".equals(str) || "application/cea-708".equals(str)) {
                z = true;
            } else {
                z = false;
            }
            a.checkArgument(z, "Invalid closed caption mime type provided: ".concat(String.valueOf(str)));
            dM.f(Format.a(format.id != null ? format.id : dVar.rB(), str, format.aOs, format.aOt, format.aOu));
            this.bbG[i] = dM;
        }
        AppMethodBeat.o(95161);
    }

    public final void a(long j, l lVar) {
        AppMethodBeat.i(95162);
        com.google.android.exoplayer2.f.a.g.a(j, lVar, this.bbG);
        AppMethodBeat.o(95162);
    }
}
