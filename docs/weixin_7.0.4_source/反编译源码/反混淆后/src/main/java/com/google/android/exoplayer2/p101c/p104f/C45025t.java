package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45042s;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.t */
public final class C45025t implements C17642q {
    private C32041m aTw;
    private C45042s aYf;
    private boolean bdq;

    /* renamed from: a */
    public final void mo32324a(C45042s c45042s, C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95163);
        this.aYf = c45042s;
        c8661d.mo19155rz();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        this.aTw.mo42836f(Format.m15288k(c8661d.mo19154rB(), "application/x-scte35"));
        AppMethodBeat.m2505o(95163);
    }

    /* renamed from: t */
    public final void mo32325t(C32065l c32065l) {
        long j = -9223372036854775807L;
        AppMethodBeat.m2504i(95164);
        if (!this.bdq) {
            if (this.aYf.mo72553tQ() == -9223372036854775807L) {
                AppMethodBeat.m2505o(95164);
                return;
            } else {
                this.aTw.mo42836f(Format.m15286c("application/x-scte35", this.aYf.mo72553tQ()));
                this.bdq = true;
            }
        }
        int tB = c32065l.mo52382tB();
        this.aTw.mo42835a(c32065l, tB);
        C32041m c32041m = this.aTw;
        C45042s c45042s = this.aYf;
        if (c45042s.brL != -9223372036854775807L) {
            j = c45042s.brL;
        } else if (c45042s.bbh != Long.MAX_VALUE) {
            j = c45042s.bbh;
        }
        c32041m.mo42834a(j, 1, tB, 0, null);
        AppMethodBeat.m2505o(95164);
    }
}
