package com.google.android.exoplayer2.p101c.p1370g;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32034e;
import com.google.android.exoplayer2.p101c.C32039h;
import com.google.android.exoplayer2.p101c.C32040k;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C37247l;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p1370g.C37246c.C25531a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.c.g.a */
public final class C41598a implements C32034e, C37247l {
    public static final C32039h aTh = new C366851();
    private C8662g aTn;
    private C32041m aVw;
    private C45027b bdP;
    private int bdQ;
    private int bdR;

    /* renamed from: com.google.android.exoplayer2.c.g.a$1 */
    static class C366851 implements C32039h {
        C366851() {
        }

        /* renamed from: ra */
        public final C32034e[] mo2572ra() {
            AppMethodBeat.m2504i(95184);
            C32034e[] c32034eArr = new C32034e[]{new C41598a()};
            AppMethodBeat.m2505o(95184);
            return c32034eArr;
        }
    }

    static {
        AppMethodBeat.m2504i(95189);
        AppMethodBeat.m2505o(95189);
    }

    /* renamed from: a */
    public final boolean mo2570a(C45026f c45026f) {
        AppMethodBeat.m2504i(95185);
        if (C37246c.m62494m(c45026f) != null) {
            AppMethodBeat.m2505o(95185);
            return true;
        }
        AppMethodBeat.m2505o(95185);
        return false;
    }

    /* renamed from: a */
    public final void mo2569a(C8662g c8662g) {
        AppMethodBeat.m2504i(95186);
        this.aTn = c8662g;
        this.aVw = c8662g.mo19157dM(0);
        this.bdP = null;
        c8662g.mo19158rb();
        AppMethodBeat.m2505o(95186);
    }

    /* renamed from: g */
    public final void mo2571g(long j, long j2) {
        this.bdR = 0;
    }

    /* renamed from: a */
    public final int mo2568a(C45026f c45026f, C32040k c32040k) {
        Object obj;
        long j;
        AppMethodBeat.m2504i(95187);
        if (this.bdP == null) {
            this.bdP = C37246c.m62494m(c45026f);
            if (this.bdP == null) {
                C37269o c37269o = new C37269o("Unsupported or unrecognized wav header.");
                AppMethodBeat.m2505o(95187);
                throw c37269o;
            }
            C45027b c45027b = this.bdP;
            this.aVw.mo42836f(Format.m15270a(null, "audio/raw", c45027b.aRy * (c45027b.aRj * c45027b.bdU), 32768, this.bdP.aRy, this.bdP.aRj, this.bdP.encoding, null, null, 0, null));
            this.bdQ = this.bdP.bdT;
        }
        C45027b c45027b2 = this.bdP;
        if (c45027b2.bdV == 0 || c45027b2.dataSize == 0) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            C45027b c45027b3 = this.bdP;
            C45039a.checkNotNull(c45026f);
            C45039a.checkNotNull(c45027b3);
            c45026f.mo59486qY();
            C32065l c32065l = new C32065l(8);
            C25531a a = C25531a.m40349a(c45026f, c32065l);
            while (a.f5221id != C17675v.m27562aT("data")) {
                new StringBuilder("Ignoring unknown WAV chunk: ").append(a.f5221id);
                j = 8 + a.size;
                if (a.f5221id == C17675v.m27562aT("RIFF")) {
                    j = 12;
                }
                if (j > 2147483647L) {
                    C37269o c37269o2 = new C37269o("Chunk is too large (~2GB+) to skip; id: " + a.f5221id);
                    AppMethodBeat.m2505o(95187);
                    throw c37269o2;
                }
                c45026f.mo59482dG((int) j);
                a = C25531a.m40349a(c45026f, c32065l);
            }
            c45026f.mo59482dG(8);
            j = c45026f.getPosition();
            long j2 = a.size;
            c45027b3.bdV = j;
            c45027b3.dataSize = j2;
            this.aTn.mo19156a(this);
        }
        int a2 = this.aVw.mo42832a(c45026f, 32768 - this.bdR, true);
        if (a2 != -1) {
            this.bdR += a2;
        }
        int i = this.bdR / this.bdQ;
        if (i > 0) {
            j = ((c45026f.getPosition() - ((long) this.bdR)) * 1000000) / ((long) this.bdP.bdS);
            int i2 = i * this.bdQ;
            this.bdR -= i2;
            this.aVw.mo42834a(j, 1, i2, this.bdR, null);
        }
        if (a2 == -1) {
            AppMethodBeat.m2505o(95187);
            return -1;
        }
        AppMethodBeat.m2505o(95187);
        return 0;
    }

    public final long getDurationUs() {
        C45027b c45027b = this.bdP;
        return ((c45027b.dataSize / ((long) c45027b.bdT)) * 1000000) / ((long) c45027b.aRj);
    }

    /* renamed from: qX */
    public final boolean mo2552qX() {
        return true;
    }

    /* renamed from: M */
    public final long mo2548M(long j) {
        AppMethodBeat.m2504i(95188);
        C45027b c45027b = this.bdP;
        long min = c45027b.bdV + Math.min((((((long) c45027b.bdS) * j) / 1000000) / ((long) c45027b.bdT)) * ((long) c45027b.bdT), c45027b.dataSize - ((long) c45027b.bdT));
        AppMethodBeat.m2505o(95188);
        return min;
    }
}
