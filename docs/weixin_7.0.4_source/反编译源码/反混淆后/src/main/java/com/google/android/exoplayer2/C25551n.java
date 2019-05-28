package com.google.android.exoplayer2;

import com.google.android.exoplayer2.C45054w.C17694a;
import com.google.android.exoplayer2.C45054w.C17695b;
import com.google.android.exoplayer2.source.C45052i.C45051b;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.google.android.exoplayer2.n */
final class C25551n {
    final C17695b aMV = new C17695b();
    final C17694a aMW = new C17694a();
    C45054w aNc;
    int repeatMode;

    /* renamed from: com.google.android.exoplayer2.n$a */
    public static final class C17683a {
        public final long aNR;
        public final long aNS;
        public final boolean aOA;
        public final boolean aOB;
        public final C45051b aOx;
        public final long aOy;
        public final long aOz;

        /* synthetic */ C17683a(C45051b c45051b, long j, long j2, long j3, long j4, boolean z, boolean z2, byte b) {
            this(c45051b, j, j2, j3, j4, z, z2);
        }

        C17683a(C45051b c45051b, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.aOx = c45051b;
            this.aNR = j;
            this.aOy = j2;
            this.aNS = j3;
            this.aOz = j4;
            this.aOA = z;
            this.aOB = z2;
        }

        /* renamed from: qd */
        public final C17683a mo32387qd() {
            AppMethodBeat.m2504i(95257);
            C17683a c17683a = new C17683a(this.aOx.mo72567em(-1), this.aNR, this.aOy, this.aNS, this.aOz, this.aOA, this.aOB);
            AppMethodBeat.m2505o(95257);
            return c17683a;
        }
    }

    public C25551n() {
        AppMethodBeat.m2504i(95258);
        AppMethodBeat.m2505o(95258);
    }

    /* renamed from: g */
    public final C45051b mo42813g(int i, long j) {
        AppMethodBeat.m2504i(95259);
        this.aNc.mo42826a(i, this.aMW, false);
        int F = this.aMW.mo32394F(j);
        C45051b c45051b;
        if (F == -1) {
            c45051b = new C45051b(i);
            AppMethodBeat.m2505o(95259);
            return c45051b;
        }
        c45051b = new C45051b(i, F, this.aMW.aPh[F]);
        AppMethodBeat.m2505o(95259);
        return c45051b;
    }

    /* renamed from: a */
    public final C17683a mo42808a(C17683a c17683a, int i) {
        AppMethodBeat.m2504i(95260);
        C17683a a = mo42809a(c17683a, c17683a.aOx.mo72567em(i));
        AppMethodBeat.m2505o(95260);
        return a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C17683a mo42809a(C17683a c17683a, C45051b c45051b) {
        long bb;
        AppMethodBeat.m2504i(95261);
        long j = c17683a.aNR;
        long j2 = c17683a.aOy;
        boolean b = m40389b(c45051b, j2);
        boolean a = m40388a(c45051b, b);
        this.aNc.mo42826a(c45051b.bhq, this.aMW, false);
        if (c45051b.mo72570sh()) {
            bb = this.aMW.mo32397bb(c45051b.bhr, c45051b.bhs);
        } else if (j2 == Long.MIN_VALUE) {
            bb = this.aMW.aOz;
        } else {
            bb = j2;
        }
        C17683a c17683a2 = new C17683a(c45051b, j, j2, c17683a.aNS, bb, b, a, (byte) 0);
        AppMethodBeat.m2505o(95261);
        return c17683a2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C17683a mo42810a(C45051b c45051b, long j, long j2) {
        AppMethodBeat.m2504i(95262);
        this.aNc.mo42826a(c45051b.bhq, this.aMW, false);
        C17683a c;
        if (!c45051b.mo72570sh()) {
            long j3;
            int G = this.aMW.mo32395G(j2);
            if (G == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = this.aMW.aPe[G];
            }
            c = mo42812c(c45051b.bhq, j2, j3);
            AppMethodBeat.m2505o(95262);
            return c;
        } else if (this.aMW.mo32396ba(c45051b.bhr, c45051b.bhs)) {
            c = mo42811b(c45051b.bhq, c45051b.bhr, c45051b.bhs, j);
            AppMethodBeat.m2505o(95262);
            return c;
        } else {
            AppMethodBeat.m2505o(95262);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final C17683a mo42811b(int i, int i2, int i3, long j) {
        long j2;
        AppMethodBeat.m2504i(95263);
        C45051b c45051b = new C45051b(i, i2, i3);
        boolean b = m40389b(c45051b, Long.MIN_VALUE);
        boolean a = m40388a(c45051b, b);
        long bb = this.aNc.mo42826a(c45051b.bhq, this.aMW, false).mo32397bb(c45051b.bhr, c45051b.bhs);
        if (i3 == this.aMW.aPh[i2]) {
            j2 = this.aMW.aPj;
        } else {
            j2 = 0;
        }
        C17683a c17683a = new C17683a(c45051b, j2, Long.MIN_VALUE, j, bb, b, a, (byte) 0);
        AppMethodBeat.m2505o(95263);
        return c17683a;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final C17683a mo42812c(int i, long j, long j2) {
        long j3;
        AppMethodBeat.m2504i(95264);
        C45051b c45051b = new C45051b(i);
        boolean b = m40389b(c45051b, j2);
        boolean a = m40388a(c45051b, b);
        this.aNc.mo42826a(c45051b.bhq, this.aMW, false);
        if (j2 == Long.MIN_VALUE) {
            j3 = this.aMW.aOz;
        } else {
            j3 = j2;
        }
        C17683a c17683a = new C17683a(c45051b, j, j2, -9223372036854775807L, j3, b, a, (byte) 0);
        AppMethodBeat.m2505o(95264);
        return c17683a;
    }

    /* renamed from: b */
    private boolean m40389b(C45051b c45051b, long j) {
        AppMethodBeat.m2504i(95265);
        int qi = this.aNc.mo42826a(c45051b.bhq, this.aMW, false).mo32399qi();
        if (qi == 0) {
            AppMethodBeat.m2505o(95265);
            return true;
        }
        int i = qi - 1;
        boolean sh = c45051b.mo72570sh();
        if (this.aMW.aPe[i] == Long.MIN_VALUE) {
            int i2 = this.aMW.aPf[i];
            if (i2 == -1) {
                AppMethodBeat.m2505o(95265);
                return false;
            }
            boolean z;
            if (sh && c45051b.bhr == i && c45051b.bhs == i2 - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z || (!sh && this.aMW.aPh[i] == i2)) {
                AppMethodBeat.m2505o(95265);
                return true;
            }
            AppMethodBeat.m2505o(95265);
            return false;
        } else if (sh || j != Long.MIN_VALUE) {
            AppMethodBeat.m2505o(95265);
            return false;
        } else {
            AppMethodBeat.m2505o(95265);
            return true;
        }
    }

    /* renamed from: a */
    private boolean m40388a(C45051b c45051b, boolean z) {
        AppMethodBeat.m2504i(95266);
        if (!this.aNc.mo72574a(this.aNc.mo42826a(c45051b.bhq, this.aMW, false).aNV, this.aMV).aPn && this.aNc.mo72575b(c45051b.bhq, this.aMW, this.aMV, this.repeatMode) && z) {
            AppMethodBeat.m2505o(95266);
            return true;
        }
        AppMethodBeat.m2505o(95266);
        return false;
    }
}
