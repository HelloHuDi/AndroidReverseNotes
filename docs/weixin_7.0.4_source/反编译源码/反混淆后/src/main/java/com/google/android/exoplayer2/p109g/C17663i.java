package com.google.android.exoplayer2.p109g;

import com.google.android.exoplayer2.C0882t;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.source.C41631p;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.g.i */
public final class C17663i {
    public final C41631p bpG;
    public final C37259g bpH;
    public final C0882t[] bpI;
    public final Object info;

    public C17663i(C41631p c41631p, C37259g c37259g, Object obj, C0882t[] c0882tArr) {
        this.bpG = c41631p;
        this.bpH = c37259g;
        this.info = obj;
        this.bpI = c0882tArr;
    }

    /* renamed from: a */
    public final boolean mo32355a(C17663i c17663i) {
        AppMethodBeat.m2504i(95785);
        if (c17663i == null) {
            AppMethodBeat.m2505o(95785);
            return false;
        }
        int i = 0;
        while (i < this.bpH.length) {
            if (mo32356a(c17663i, i)) {
                i++;
            } else {
                AppMethodBeat.m2505o(95785);
                return false;
            }
        }
        AppMethodBeat.m2505o(95785);
        return true;
    }

    /* renamed from: a */
    public final boolean mo32356a(C17663i c17663i, int i) {
        AppMethodBeat.m2504i(95786);
        if (c17663i == null) {
            AppMethodBeat.m2505o(95786);
            return false;
        } else if (C17675v.m27574j(this.bpH.bpE[i], c17663i.bpH.bpE[i]) && C17675v.m27574j(this.bpI[i], c17663i.bpI[i])) {
            AppMethodBeat.m2505o(95786);
            return true;
        } else {
            AppMethodBeat.m2505o(95786);
            return false;
        }
    }
}
