package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.C17628b;
import com.google.android.exoplayer2.C37253f;
import com.google.android.exoplayer2.C45054w;
import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.C45054w.C17695b;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C45052i.C37281a;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

/* renamed from: com.google.android.exoplayer2.source.d */
public final class C25558d implements C45052i, C37281a {
    private final C45052i aNu;
    private C25559a bgA;
    private final long bgr;
    private final long bgs;
    private final boolean bgx;
    private final ArrayList<C17685c> bgy;
    private C37281a bgz;

    /* renamed from: com.google.android.exoplayer2.source.d$a */
    static final class C25559a extends C45054w {
        private final C45054w aNc;
        private final long bgr;
        private final long bgs;

        public C25559a(C45054w c45054w, long j, long j2) {
            AppMethodBeat.m2504i(95462);
            C45039a.checkArgument(c45054w.mo42830qg() == 1);
            C45039a.checkArgument(c45054w.mo42831qh() == 1);
            C17695b a = c45054w.mo72574a(0, new C17695b());
            C45039a.checkArgument(!a.aPn);
            if (j2 == Long.MIN_VALUE) {
                j2 = a.aOz;
            }
            if (a.aOz != -9223372036854775807L) {
                if (j2 > a.aOz) {
                    j2 = a.aOz;
                }
                boolean z = j == 0 || a.aPm;
                C45039a.checkArgument(z);
                C45039a.checkArgument(j <= j2);
            }
            C45039a.checkArgument(c45054w.mo42826a(0, new C17694a(), false).aPd == 0);
            this.aNc = c45054w;
            this.bgr = j;
            this.bgs = j2;
            AppMethodBeat.m2505o(95462);
        }

        /* renamed from: qg */
        public final int mo42830qg() {
            return 1;
        }

        /* renamed from: aZ */
        public final int mo42828aZ(int i, int i2) {
            AppMethodBeat.m2504i(95463);
            int aZ = this.aNc.mo42828aZ(i, i2);
            AppMethodBeat.m2505o(95463);
            return aZ;
        }

        /* renamed from: a */
        public final C17695b mo42827a(int i, C17695b c17695b, boolean z, long j) {
            long j2;
            AppMethodBeat.m2504i(95464);
            C17695b a = this.aNc.mo42827a(0, c17695b, z, j);
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
            j2 = C17628b.m27433w(this.bgr);
            if (a.aPk != -9223372036854775807L) {
                a.aPk += j2;
            }
            if (a.aPl != -9223372036854775807L) {
                a.aPl = j2 + a.aPl;
            }
            AppMethodBeat.m2505o(95464);
            return a;
        }

        /* renamed from: qh */
        public final int mo42831qh() {
            return 1;
        }

        /* renamed from: a */
        public final C17694a mo42826a(int i, C17694a c17694a, boolean z) {
            long j = -9223372036854775807L;
            AppMethodBeat.m2504i(95465);
            C17694a a = this.aNc.mo42826a(0, c17694a, z);
            if (this.bgs != -9223372036854775807L) {
                j = this.bgs - this.bgr;
            }
            a.aOz = j;
            AppMethodBeat.m2505o(95465);
            return a;
        }

        /* renamed from: ac */
        public final int mo42829ac(Object obj) {
            AppMethodBeat.m2504i(95466);
            int ac = this.aNc.mo42829ac(obj);
            AppMethodBeat.m2505o(95466);
            return ac;
        }
    }

    public C25558d(C45052i c45052i, long j, long j2) {
        this(c45052i, j, j2, (byte) 0);
    }

    private C25558d(C45052i c45052i, long j, long j2, byte b) {
        AppMethodBeat.m2504i(95467);
        C45039a.checkArgument(j >= 0);
        this.aNu = (C45052i) C45039a.checkNotNull(c45052i);
        this.bgr = j;
        this.bgs = j2;
        this.bgx = true;
        this.bgy = new ArrayList();
        AppMethodBeat.m2505o(95467);
    }

    /* renamed from: a */
    public final void mo42821a(C37253f c37253f, C37281a c37281a) {
        AppMethodBeat.m2504i(95468);
        this.bgz = c37281a;
        this.aNu.mo42821a(c37253f, (C37281a) this);
        AppMethodBeat.m2505o(95468);
    }

    /* renamed from: rX */
    public final void mo42824rX() {
        AppMethodBeat.m2504i(95469);
        this.aNu.mo42824rX();
        AppMethodBeat.m2505o(95469);
    }

    /* renamed from: a */
    public final C37279h mo42820a(C45051b c45051b, C32053b c32053b) {
        AppMethodBeat.m2504i(95470);
        C17685c c17685c = new C17685c(this.aNu.mo42820a(c45051b, c32053b), this.bgx);
        this.bgy.add(c17685c);
        c17685c.mo32389i(this.bgA.bgr, this.bgA.bgs);
        AppMethodBeat.m2505o(95470);
        return c17685c;
    }

    /* renamed from: b */
    public final void mo42823b(C37279h c37279h) {
        AppMethodBeat.m2504i(95471);
        C45039a.checkState(this.bgy.remove(c37279h));
        this.aNu.mo42823b(((C17685c) c37279h).aNG);
        AppMethodBeat.m2505o(95471);
    }

    /* renamed from: rY */
    public final void mo42825rY() {
        AppMethodBeat.m2504i(95472);
        this.aNu.mo42825rY();
        AppMethodBeat.m2505o(95472);
    }

    /* renamed from: a */
    public final void mo42822a(C45054w c45054w, Object obj) {
        long j;
        AppMethodBeat.m2504i(95473);
        this.bgA = new C25559a(c45054w, this.bgr, this.bgs);
        this.bgz.mo42822a(this.bgA, obj);
        long a = this.bgA.bgr;
        if (this.bgA.bgs == -9223372036854775807L) {
            j = Long.MIN_VALUE;
        } else {
            j = this.bgA.bgs;
        }
        int size = this.bgy.size();
        for (int i = 0; i < size; i++) {
            ((C17685c) this.bgy.get(i)).mo32389i(a, j);
        }
        AppMethodBeat.m2505o(95473);
    }
}
