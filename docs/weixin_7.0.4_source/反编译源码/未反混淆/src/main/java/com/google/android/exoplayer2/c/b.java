package com.google.android.exoplayer2.c;

import com.google.android.exoplayer2.h.f;
import com.google.android.exoplayer2.i.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.EOFException;
import java.util.Arrays;

public final class b implements f {
    private static final byte[] aSE = new byte[4096];
    private final f aSF;
    private final long aSG;
    private byte[] aSH = new byte[65536];
    private int aSI;
    private int aSJ;
    private long position;

    public b(f fVar, long j, long j2) {
        AppMethodBeat.i(94842);
        this.aSF = fVar;
        this.position = j;
        this.aSG = j2;
        AppMethodBeat.o(94842);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(94843);
        int c = c(bArr, i, i2);
        if (c == 0) {
            c = a(bArr, i, i2, 0, true);
        }
        dL(c);
        AppMethodBeat.o(94843);
        return c;
    }

    public final boolean a(byte[] bArr, int i, int i2, boolean z) {
        AppMethodBeat.i(94844);
        int c = c(bArr, i, i2);
        while (c < i2 && c != -1) {
            c = a(bArr, i, i2, c, z);
        }
        dL(c);
        if (c != -1) {
            AppMethodBeat.o(94844);
            return true;
        }
        AppMethodBeat.o(94844);
        return false;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(94845);
        a(bArr, i, i2, false);
        AppMethodBeat.o(94845);
    }

    public final int dF(int i) {
        AppMethodBeat.i(94846);
        int dJ = dJ(i);
        if (dJ == 0) {
            dJ = a(aSE, 0, Math.min(i, aSE.length), 0, true);
        }
        dL(dJ);
        AppMethodBeat.o(94846);
        return dJ;
    }

    public final boolean b(byte[] bArr, int i, int i2, boolean z) {
        AppMethodBeat.i(94848);
        if (q(i2, z)) {
            System.arraycopy(this.aSH, this.aSI - i2, bArr, i, i2);
            AppMethodBeat.o(94848);
            return true;
        }
        AppMethodBeat.o(94848);
        return false;
    }

    public final void b(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(94849);
        b(bArr, i, i2, false);
        AppMethodBeat.o(94849);
    }

    private boolean q(int i, boolean z) {
        AppMethodBeat.i(94850);
        dI(i);
        int min = Math.min(this.aSJ - this.aSI, i);
        while (min < i) {
            min = a(this.aSH, this.aSI, i, min, z);
            if (min == -1) {
                AppMethodBeat.o(94850);
                return false;
            }
        }
        this.aSI += i;
        this.aSJ = Math.max(this.aSJ, this.aSI);
        AppMethodBeat.o(94850);
        return true;
    }

    public final void dH(int i) {
        AppMethodBeat.i(94851);
        q(i, false);
        AppMethodBeat.o(94851);
    }

    public final void qY() {
        this.aSI = 0;
    }

    public final long qZ() {
        return this.position + ((long) this.aSI);
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getLength() {
        return this.aSG;
    }

    private void dI(int i) {
        AppMethodBeat.i(94852);
        int i2 = this.aSI + i;
        if (i2 > this.aSH.length) {
            this.aSH = Arrays.copyOf(this.aSH, v.u(this.aSH.length * 2, 65536 + i2, i2 + SQLiteGlobal.journalSizeLimit));
        }
        AppMethodBeat.o(94852);
    }

    private int dJ(int i) {
        AppMethodBeat.i(94853);
        int min = Math.min(this.aSJ, i);
        dK(min);
        AppMethodBeat.o(94853);
        return min;
    }

    private int c(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(94854);
        if (this.aSJ == 0) {
            AppMethodBeat.o(94854);
            return 0;
        }
        int min = Math.min(this.aSJ, i2);
        System.arraycopy(this.aSH, 0, bArr, i, min);
        dK(min);
        AppMethodBeat.o(94854);
        return min;
    }

    private void dK(int i) {
        AppMethodBeat.i(94855);
        this.aSJ -= i;
        this.aSI = 0;
        Object obj = this.aSH;
        if (this.aSJ < this.aSH.length - SQLiteGlobal.journalSizeLimit) {
            obj = new byte[(this.aSJ + 65536)];
        }
        System.arraycopy(this.aSH, i, obj, 0, this.aSJ);
        this.aSH = obj;
        AppMethodBeat.o(94855);
    }

    private int a(byte[] bArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.i(94856);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException();
            AppMethodBeat.o(94856);
            throw interruptedException;
        }
        int read = this.aSF.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            int i4 = i3 + read;
            AppMethodBeat.o(94856);
            return i4;
        } else if (i3 == 0 && z) {
            AppMethodBeat.o(94856);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.o(94856);
            throw eOFException;
        }
    }

    private void dL(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    public final void dG(int i) {
        AppMethodBeat.i(94847);
        int dJ = dJ(i);
        while (dJ < i && dJ != -1) {
            dJ = a(aSE, -dJ, Math.min(i, aSE.length + dJ), dJ, false);
        }
        dL(dJ);
        AppMethodBeat.o(94847);
    }
}
