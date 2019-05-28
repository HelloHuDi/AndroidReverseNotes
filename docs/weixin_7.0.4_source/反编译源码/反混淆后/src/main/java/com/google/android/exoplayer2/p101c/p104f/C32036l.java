package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.f.l */
public final class C32036l implements C0845h {
    private C32041m aTw;
    private int aUy;
    private boolean bbH;
    private long bbJ;
    private final C32065l bcO = new C32065l(10);
    private int sampleSize;

    public C32036l() {
        AppMethodBeat.m2504i(95133);
        AppMethodBeat.m2505o(95133);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        this.bbH = false;
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95134);
        c8661d.mo19155rz();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        this.aTw.mo42836f(Format.m15288k(c8661d.mo19154rB(), "application/id3"));
        AppMethodBeat.m2505o(95134);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        if (z) {
            this.bbH = true;
            this.bbJ = j;
            this.sampleSize = 0;
            this.aUy = 0;
        }
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95135);
        if (this.bbH) {
            int tB = c32065l.mo52382tB();
            if (this.aUy < 10) {
                int min = Math.min(tB, 10 - this.aUy);
                System.arraycopy(c32065l.data, c32065l.position, this.bcO.data, this.aUy, min);
                if (min + this.aUy == 10) {
                    this.bcO.setPosition(0);
                    if (73 == this.bcO.readUnsignedByte() && 68 == this.bcO.readUnsignedByte() && 51 == this.bcO.readUnsignedByte()) {
                        this.bcO.mo52369eM(3);
                        this.sampleSize = this.bcO.mo52388tH() + 10;
                    } else {
                        this.bbH = false;
                        AppMethodBeat.m2505o(95135);
                        return;
                    }
                }
            }
            tB = Math.min(tB, this.sampleSize - this.aUy);
            this.aTw.mo42835a(c32065l, tB);
            this.aUy = tB + this.aUy;
            AppMethodBeat.m2505o(95135);
            return;
        }
        AppMethodBeat.m2505o(95135);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
        AppMethodBeat.m2504i(95136);
        if (this.bbH && this.sampleSize != 0 && this.aUy == this.sampleSize) {
            this.aTw.mo42834a(this.bbJ, 1, this.sampleSize, 0, null);
            this.bbH = false;
            AppMethodBeat.m2505o(95136);
            return;
        }
        AppMethodBeat.m2505o(95136);
    }
}
