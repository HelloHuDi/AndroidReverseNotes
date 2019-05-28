package com.google.android.exoplayer2.p101c.p796b;

import com.google.android.exoplayer2.C37269o;
import com.google.android.exoplayer2.p101c.C45026f;
import com.google.android.exoplayer2.p111i.C45039a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

/* renamed from: com.google.android.exoplayer2.c.b.a */
final class C17633a implements C45020b {
    private final byte[] aTA = new byte[8];
    private final Stack<C8645a> aTB = new Stack();
    private final C17634f aTC = new C17634f();
    private C37231c aTD;
    private int aTE;
    private int aTF;
    private long aTG;

    /* renamed from: com.google.android.exoplayer2.c.b.a$a */
    static final class C8645a {
        final int aTF;
        final long aTH;

        /* synthetic */ C8645a(int i, long j, byte b) {
            this(i, j);
        }

        private C8645a(int i, long j) {
            this.aTF = i;
            this.aTH = j;
        }
    }

    C17633a() {
        AppMethodBeat.m2504i(94884);
        AppMethodBeat.m2505o(94884);
    }

    /* renamed from: a */
    public final void mo32315a(C37231c c37231c) {
        this.aTD = c37231c;
    }

    public final void reset() {
        AppMethodBeat.m2504i(94885);
        this.aTE = 0;
        this.aTB.clear();
        this.aTC.reset();
        AppMethodBeat.m2505o(94885);
    }

    /* renamed from: c */
    public final boolean mo32316c(C45026f c45026f) {
        AppMethodBeat.m2504i(94886);
        C45039a.checkState(this.aTD != null);
        while (true) {
            if (this.aTB.isEmpty() || c45026f.getPosition() < ((C8645a) this.aTB.peek()).aTH) {
                int dR;
                if (this.aTE == 0) {
                    long a = this.aTC.mo32318a(c45026f, true, false, 4);
                    if (a == -2) {
                        c45026f.mo59486qY();
                        while (true) {
                            c45026f.mo59479b(this.aTA, 0, 4);
                            dR = C17634f.m27459dR(this.aTA[0]);
                            if (dR != -1 && dR <= 4) {
                                int b = (int) C17634f.m27458b(this.aTA, dR, false);
                                if (this.aTD.mo59474dP(b)) {
                                    c45026f.mo59482dG(dR);
                                    a = (long) b;
                                }
                            }
                            c45026f.mo59482dG(1);
                        }
                    }
                    if (a == -1) {
                        AppMethodBeat.m2505o(94886);
                        return false;
                    }
                    this.aTF = (int) a;
                    this.aTE = 1;
                }
                if (this.aTE == 1) {
                    this.aTG = this.aTC.mo32318a(c45026f, false, true, 8);
                    this.aTE = 2;
                }
                dR = this.aTD.mo59473dO(this.aTF);
                C37269o c37269o;
                switch (dR) {
                    case 0:
                        c45026f.mo59482dG((int) this.aTG);
                        this.aTE = 0;
                    case 1:
                        long position = c45026f.getPosition();
                        this.aTB.add(new C8645a(this.aTF, this.aTG + position, (byte) 0));
                        this.aTD.mo59476f(this.aTF, position, this.aTG);
                        this.aTE = 0;
                        AppMethodBeat.m2505o(94886);
                        return true;
                    case 2:
                        if (this.aTG > 8) {
                            c37269o = new C37269o("Invalid integer size: " + this.aTG);
                            AppMethodBeat.m2505o(94886);
                            throw c37269o;
                        }
                        this.aTD.mo59477h(this.aTF, m27455a(c45026f, (int) this.aTG));
                        this.aTE = 0;
                        AppMethodBeat.m2505o(94886);
                        return true;
                    case 3:
                        if (this.aTG > 2147483647L) {
                            c37269o = new C37269o("String element size: " + this.aTG);
                            AppMethodBeat.m2505o(94886);
                            throw c37269o;
                        }
                        String str;
                        C37231c c37231c = this.aTD;
                        int i = this.aTF;
                        dR = (int) this.aTG;
                        if (dR == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[dR];
                            c45026f.readFully(bArr, 0, dR);
                            str = new String(bArr);
                        }
                        c37231c.mo59472d(i, str);
                        this.aTE = 0;
                        AppMethodBeat.m2505o(94886);
                        return true;
                    case 4:
                        this.aTD.mo59470a(this.aTF, (int) this.aTG, c45026f);
                        this.aTE = 0;
                        AppMethodBeat.m2505o(94886);
                        return true;
                    case 5:
                        if (this.aTG == 4 || this.aTG == 8) {
                            double intBitsToFloat;
                            C37231c c37231c2 = this.aTD;
                            int i2 = this.aTF;
                            dR = (int) this.aTG;
                            long a2 = m27455a(c45026f, dR);
                            if (dR == 4) {
                                intBitsToFloat = (double) Float.intBitsToFloat((int) a2);
                            } else {
                                intBitsToFloat = Double.longBitsToDouble(a2);
                            }
                            c37231c2.mo59471c(i2, intBitsToFloat);
                            this.aTE = 0;
                            AppMethodBeat.m2505o(94886);
                            return true;
                        }
                        c37269o = new C37269o("Invalid float size: " + this.aTG);
                        AppMethodBeat.m2505o(94886);
                        throw c37269o;
                    default:
                        C37269o c37269o2 = new C37269o("Invalid element type ".concat(String.valueOf(dR)));
                        AppMethodBeat.m2505o(94886);
                        throw c37269o2;
                }
            }
            this.aTD.mo59475dQ(((C8645a) this.aTB.pop()).aTF);
            AppMethodBeat.m2505o(94886);
            return true;
        }
    }

    /* renamed from: a */
    private long m27455a(C45026f c45026f, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(94887);
        c45026f.readFully(this.aTA, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.aTA[i2] & 255));
            i2++;
        }
        AppMethodBeat.m2505o(94887);
        return j;
    }
}
