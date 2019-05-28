package com.google.android.exoplayer2.g;

import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.source.p;
import com.google.android.exoplayer2.t;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i {
    public final p bpG;
    public final g bpH;
    public final t[] bpI;
    public final Object info;

    public i(p pVar, g gVar, Object obj, t[] tVarArr) {
        this.bpG = pVar;
        this.bpH = gVar;
        this.info = obj;
        this.bpI = tVarArr;
    }

    public final boolean a(i iVar) {
        AppMethodBeat.i(95785);
        if (iVar == null) {
            AppMethodBeat.o(95785);
            return false;
        }
        int i = 0;
        while (i < this.bpH.length) {
            if (a(iVar, i)) {
                i++;
            } else {
                AppMethodBeat.o(95785);
                return false;
            }
        }
        AppMethodBeat.o(95785);
        return true;
    }

    public final boolean a(i iVar, int i) {
        AppMethodBeat.i(95786);
        if (iVar == null) {
            AppMethodBeat.o(95786);
            return false;
        } else if (v.j(this.bpH.bpE[i], iVar.bpH.bpE[i]) && v.j(this.bpI[i], iVar.bpI[i])) {
            AppMethodBeat.o(95786);
            return true;
        } else {
            AppMethodBeat.o(95786);
            return false;
        }
    }
}
