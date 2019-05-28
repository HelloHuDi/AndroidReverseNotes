package com.google.android.exoplayer2;

import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.w.b;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class n {
    final b aMV = new b();
    final com.google.android.exoplayer2.w.a aMW = new com.google.android.exoplayer2.w.a();
    w aNc;
    int repeatMode;

    public static final class a {
        public final long aNR;
        public final long aNS;
        public final boolean aOA;
        public final boolean aOB;
        public final i.b aOx;
        public final long aOy;
        public final long aOz;

        /* synthetic */ a(i.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2, byte b) {
            this(bVar, j, j2, j3, j4, z, z2);
        }

        a(i.b bVar, long j, long j2, long j3, long j4, boolean z, boolean z2) {
            this.aOx = bVar;
            this.aNR = j;
            this.aOy = j2;
            this.aNS = j3;
            this.aOz = j4;
            this.aOA = z;
            this.aOB = z2;
        }

        public final a qd() {
            AppMethodBeat.i(95257);
            a aVar = new a(this.aOx.em(-1), this.aNR, this.aOy, this.aNS, this.aOz, this.aOA, this.aOB);
            AppMethodBeat.o(95257);
            return aVar;
        }
    }

    public n() {
        AppMethodBeat.i(95258);
        AppMethodBeat.o(95258);
    }

    public final i.b g(int i, long j) {
        AppMethodBeat.i(95259);
        this.aNc.a(i, this.aMW, false);
        int F = this.aMW.F(j);
        i.b bVar;
        if (F == -1) {
            bVar = new i.b(i);
            AppMethodBeat.o(95259);
            return bVar;
        }
        bVar = new i.b(i, F, this.aMW.aPh[F]);
        AppMethodBeat.o(95259);
        return bVar;
    }

    public final a a(a aVar, int i) {
        AppMethodBeat.i(95260);
        a a = a(aVar, aVar.aOx.em(i));
        AppMethodBeat.o(95260);
        return a;
    }

    /* Access modifiers changed, original: final */
    public final a a(a aVar, i.b bVar) {
        long bb;
        AppMethodBeat.i(95261);
        long j = aVar.aNR;
        long j2 = aVar.aOy;
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.aNc.a(bVar.bhq, this.aMW, false);
        if (bVar.sh()) {
            bb = this.aMW.bb(bVar.bhr, bVar.bhs);
        } else if (j2 == Long.MIN_VALUE) {
            bb = this.aMW.aOz;
        } else {
            bb = j2;
        }
        a aVar2 = new a(bVar, j, j2, aVar.aNS, bb, b, a, (byte) 0);
        AppMethodBeat.o(95261);
        return aVar2;
    }

    /* Access modifiers changed, original: final */
    public final a a(i.b bVar, long j, long j2) {
        AppMethodBeat.i(95262);
        this.aNc.a(bVar.bhq, this.aMW, false);
        a c;
        if (!bVar.sh()) {
            long j3;
            int G = this.aMW.G(j2);
            if (G == -1) {
                j3 = Long.MIN_VALUE;
            } else {
                j3 = this.aMW.aPe[G];
            }
            c = c(bVar.bhq, j2, j3);
            AppMethodBeat.o(95262);
            return c;
        } else if (this.aMW.ba(bVar.bhr, bVar.bhs)) {
            c = b(bVar.bhq, bVar.bhr, bVar.bhs, j);
            AppMethodBeat.o(95262);
            return c;
        } else {
            AppMethodBeat.o(95262);
            return null;
        }
    }

    /* Access modifiers changed, original: final */
    public final a b(int i, int i2, int i3, long j) {
        long j2;
        AppMethodBeat.i(95263);
        i.b bVar = new i.b(i, i2, i3);
        boolean b = b(bVar, Long.MIN_VALUE);
        boolean a = a(bVar, b);
        long bb = this.aNc.a(bVar.bhq, this.aMW, false).bb(bVar.bhr, bVar.bhs);
        if (i3 == this.aMW.aPh[i2]) {
            j2 = this.aMW.aPj;
        } else {
            j2 = 0;
        }
        a aVar = new a(bVar, j2, Long.MIN_VALUE, j, bb, b, a, (byte) 0);
        AppMethodBeat.o(95263);
        return aVar;
    }

    /* Access modifiers changed, original: final */
    public final a c(int i, long j, long j2) {
        long j3;
        AppMethodBeat.i(95264);
        i.b bVar = new i.b(i);
        boolean b = b(bVar, j2);
        boolean a = a(bVar, b);
        this.aNc.a(bVar.bhq, this.aMW, false);
        if (j2 == Long.MIN_VALUE) {
            j3 = this.aMW.aOz;
        } else {
            j3 = j2;
        }
        a aVar = new a(bVar, j, j2, -9223372036854775807L, j3, b, a, (byte) 0);
        AppMethodBeat.o(95264);
        return aVar;
    }

    private boolean b(i.b bVar, long j) {
        AppMethodBeat.i(95265);
        int qi = this.aNc.a(bVar.bhq, this.aMW, false).qi();
        if (qi == 0) {
            AppMethodBeat.o(95265);
            return true;
        }
        int i = qi - 1;
        boolean sh = bVar.sh();
        if (this.aMW.aPe[i] == Long.MIN_VALUE) {
            int i2 = this.aMW.aPf[i];
            if (i2 == -1) {
                AppMethodBeat.o(95265);
                return false;
            }
            boolean z;
            if (sh && bVar.bhr == i && bVar.bhs == i2 - 1) {
                z = true;
            } else {
                z = false;
            }
            if (z || (!sh && this.aMW.aPh[i] == i2)) {
                AppMethodBeat.o(95265);
                return true;
            }
            AppMethodBeat.o(95265);
            return false;
        } else if (sh || j != Long.MIN_VALUE) {
            AppMethodBeat.o(95265);
            return false;
        } else {
            AppMethodBeat.o(95265);
            return true;
        }
    }

    private boolean a(i.b bVar, boolean z) {
        AppMethodBeat.i(95266);
        if (!this.aNc.a(this.aNc.a(bVar.bhq, this.aMW, false).aNV, this.aMV).aPn && this.aNc.b(bVar.bhq, this.aMW, this.aMV, this.repeatMode) && z) {
            AppMethodBeat.o(95266);
            return true;
        }
        AppMethodBeat.o(95266);
        return false;
    }
}
