package com.google.android.exoplayer2.p101c;

import com.google.android.exoplayer2.p110h.C0867f;
import com.google.android.exoplayer2.p111i.C17675v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.EOFException;
import java.util.Arrays;

/* renamed from: com.google.android.exoplayer2.c.b */
public final class C37232b implements C45026f {
    private static final byte[] aSE = new byte[4096];
    private final C0867f aSF;
    private final long aSG;
    private byte[] aSH = new byte[65536];
    private int aSI;
    private int aSJ;
    private long position;

    public C37232b(C0867f c0867f, long j, long j2) {
        AppMethodBeat.m2504i(94842);
        this.aSF = c0867f;
        this.position = j;
        this.aSG = j2;
        AppMethodBeat.m2505o(94842);
    }

    public final int read(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(94843);
        int c = m62426c(bArr, i, i2);
        if (c == 0) {
            c = m62425a(bArr, i, i2, 0, true);
        }
        m62430dL(c);
        AppMethodBeat.m2505o(94843);
        return c;
    }

    /* renamed from: a */
    public final boolean mo59478a(byte[] bArr, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(94844);
        int c = m62426c(bArr, i, i2);
        while (c < i2 && c != -1) {
            c = m62425a(bArr, i, i2, c, z);
        }
        m62430dL(c);
        if (c != -1) {
            AppMethodBeat.m2505o(94844);
            return true;
        }
        AppMethodBeat.m2505o(94844);
        return false;
    }

    public final void readFully(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(94845);
        mo59478a(bArr, i, i2, false);
        AppMethodBeat.m2505o(94845);
    }

    /* renamed from: dF */
    public final int mo59481dF(int i) {
        AppMethodBeat.m2504i(94846);
        int dJ = m62428dJ(i);
        if (dJ == 0) {
            dJ = m62425a(aSE, 0, Math.min(i, aSE.length), 0, true);
        }
        m62430dL(dJ);
        AppMethodBeat.m2505o(94846);
        return dJ;
    }

    /* renamed from: b */
    public final boolean mo59480b(byte[] bArr, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(94848);
        if (m62431q(i2, z)) {
            System.arraycopy(this.aSH, this.aSI - i2, bArr, i, i2);
            AppMethodBeat.m2505o(94848);
            return true;
        }
        AppMethodBeat.m2505o(94848);
        return false;
    }

    /* renamed from: b */
    public final void mo59479b(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(94849);
        mo59480b(bArr, i, i2, false);
        AppMethodBeat.m2505o(94849);
    }

    /* renamed from: q */
    private boolean m62431q(int i, boolean z) {
        AppMethodBeat.m2504i(94850);
        m62427dI(i);
        int min = Math.min(this.aSJ - this.aSI, i);
        while (min < i) {
            min = m62425a(this.aSH, this.aSI, i, min, z);
            if (min == -1) {
                AppMethodBeat.m2505o(94850);
                return false;
            }
        }
        this.aSI += i;
        this.aSJ = Math.max(this.aSJ, this.aSI);
        AppMethodBeat.m2505o(94850);
        return true;
    }

    /* renamed from: dH */
    public final void mo59483dH(int i) {
        AppMethodBeat.m2504i(94851);
        m62431q(i, false);
        AppMethodBeat.m2505o(94851);
    }

    /* renamed from: qY */
    public final void mo59486qY() {
        this.aSI = 0;
    }

    /* renamed from: qZ */
    public final long mo59487qZ() {
        return this.position + ((long) this.aSI);
    }

    public final long getPosition() {
        return this.position;
    }

    public final long getLength() {
        return this.aSG;
    }

    /* renamed from: dI */
    private void m62427dI(int i) {
        AppMethodBeat.m2504i(94852);
        int i2 = this.aSI + i;
        if (i2 > this.aSH.length) {
            this.aSH = Arrays.copyOf(this.aSH, C17675v.m27578u(this.aSH.length * 2, 65536 + i2, i2 + SQLiteGlobal.journalSizeLimit));
        }
        AppMethodBeat.m2505o(94852);
    }

    /* renamed from: dJ */
    private int m62428dJ(int i) {
        AppMethodBeat.m2504i(94853);
        int min = Math.min(this.aSJ, i);
        m62429dK(min);
        AppMethodBeat.m2505o(94853);
        return min;
    }

    /* renamed from: c */
    private int m62426c(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(94854);
        if (this.aSJ == 0) {
            AppMethodBeat.m2505o(94854);
            return 0;
        }
        int min = Math.min(this.aSJ, i2);
        System.arraycopy(this.aSH, 0, bArr, i, min);
        m62429dK(min);
        AppMethodBeat.m2505o(94854);
        return min;
    }

    /* renamed from: dK */
    private void m62429dK(int i) {
        AppMethodBeat.m2504i(94855);
        this.aSJ -= i;
        this.aSI = 0;
        Object obj = this.aSH;
        if (this.aSJ < this.aSH.length - SQLiteGlobal.journalSizeLimit) {
            obj = new byte[(this.aSJ + 65536)];
        }
        System.arraycopy(this.aSH, i, obj, 0, this.aSJ);
        this.aSH = obj;
        AppMethodBeat.m2505o(94855);
    }

    /* renamed from: a */
    private int m62425a(byte[] bArr, int i, int i2, int i3, boolean z) {
        AppMethodBeat.m2504i(94856);
        if (Thread.interrupted()) {
            InterruptedException interruptedException = new InterruptedException();
            AppMethodBeat.m2505o(94856);
            throw interruptedException;
        }
        int read = this.aSF.read(bArr, i + i3, i2 - i3);
        if (read != -1) {
            int i4 = i3 + read;
            AppMethodBeat.m2505o(94856);
            return i4;
        } else if (i3 == 0 && z) {
            AppMethodBeat.m2505o(94856);
            return -1;
        } else {
            EOFException eOFException = new EOFException();
            AppMethodBeat.m2505o(94856);
            throw eOFException;
        }
    }

    /* renamed from: dL */
    private void m62430dL(int i) {
        if (i != -1) {
            this.position += (long) i;
        }
    }

    /* renamed from: dG */
    public final void mo59482dG(int i) {
        AppMethodBeat.m2504i(94847);
        int dJ = m62428dJ(i);
        while (dJ < i && dJ != -1) {
            dJ = m62425a(aSE, -dJ, Math.min(i, aSE.length + dJ), dJ, false);
        }
        m62430dL(dJ);
        AppMethodBeat.m2505o(94847);
    }
}
