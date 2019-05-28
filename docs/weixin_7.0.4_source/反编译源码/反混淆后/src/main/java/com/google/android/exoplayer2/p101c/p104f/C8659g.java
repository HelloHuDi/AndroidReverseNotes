package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C25529a;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.g */
public final class C8659g implements C0845h {
    private int aUG;
    private final List<C25529a> bbF;
    private final C32041m[] bbG;
    private boolean bbH;
    private int bbI;
    private long bbJ;

    public C8659g(List<C25529a> list) {
        AppMethodBeat.m2504i(95106);
        this.bbF = list;
        this.bbG = new C32041m[list.size()];
        AppMethodBeat.m2505o(95106);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        this.bbH = false;
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95107);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.bbG.length) {
                C25529a c25529a = (C25529a) this.bbF.get(i2);
                c8661d.mo19155rz();
                C32041m dM = c8662g.mo19157dM(c8661d.mo19153rA());
                dM.mo42836f(Format.m15282a(c8661d.mo19154rB(), "application/dvbsubs", Collections.singletonList(c25529a.bdI), c25529a.aOt, null));
                this.bbG[i2] = dM;
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(95107);
                return;
            }
        }
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        if (z) {
            this.bbH = true;
            this.bbJ = j;
            this.aUG = 0;
            this.bbI = 2;
        }
    }

    /* renamed from: ro */
    public final void mo2558ro() {
        AppMethodBeat.m2504i(95108);
        if (this.bbH) {
            for (C32041m a : this.bbG) {
                a.mo42834a(this.bbJ, 1, this.aUG, 0, null);
            }
            this.bbH = false;
        }
        AppMethodBeat.m2505o(95108);
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        int i = 0;
        AppMethodBeat.m2504i(95109);
        if (this.bbH) {
            if (this.bbI == 2 && !m15354e(c32065l, 32)) {
                AppMethodBeat.m2505o(95109);
                return;
            } else if (this.bbI != 1 || m15354e(c32065l, 0)) {
                int i2 = c32065l.position;
                int tB = c32065l.mo52382tB();
                C32041m[] c32041mArr = this.bbG;
                int length = c32041mArr.length;
                while (i < length) {
                    C32041m c32041m = c32041mArr[i];
                    c32065l.setPosition(i2);
                    c32041m.mo42835a(c32065l, tB);
                    i++;
                }
                this.aUG += tB;
            } else {
                AppMethodBeat.m2505o(95109);
                return;
            }
        }
        AppMethodBeat.m2505o(95109);
    }

    /* renamed from: e */
    private boolean m15354e(C32065l c32065l, int i) {
        AppMethodBeat.m2504i(95110);
        if (c32065l.mo52382tB() == 0) {
            AppMethodBeat.m2505o(95110);
            return false;
        }
        if (c32065l.readUnsignedByte() != i) {
            this.bbH = false;
        }
        this.bbI--;
        boolean z = this.bbH;
        AppMethodBeat.m2505o(95110);
        return z;
    }
}
