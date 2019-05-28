package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.c.f;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Stack;

final class a implements b {
    private final byte[] aTA = new byte[8];
    private final Stack<a> aTB = new Stack();
    private final f aTC = new f();
    private c aTD;
    private int aTE;
    private int aTF;
    private long aTG;

    static final class a {
        final int aTF;
        final long aTH;

        /* synthetic */ a(int i, long j, byte b) {
            this(i, j);
        }

        private a(int i, long j) {
            this.aTF = i;
            this.aTH = j;
        }
    }

    a() {
        AppMethodBeat.i(94884);
        AppMethodBeat.o(94884);
    }

    public final void a(c cVar) {
        this.aTD = cVar;
    }

    public final void reset() {
        AppMethodBeat.i(94885);
        this.aTE = 0;
        this.aTB.clear();
        this.aTC.reset();
        AppMethodBeat.o(94885);
    }

    public final boolean c(f fVar) {
        AppMethodBeat.i(94886);
        com.google.android.exoplayer2.i.a.checkState(this.aTD != null);
        while (true) {
            if (this.aTB.isEmpty() || fVar.getPosition() < ((a) this.aTB.peek()).aTH) {
                int dR;
                if (this.aTE == 0) {
                    long a = this.aTC.a(fVar, true, false, 4);
                    if (a == -2) {
                        fVar.qY();
                        while (true) {
                            fVar.b(this.aTA, 0, 4);
                            dR = f.dR(this.aTA[0]);
                            if (dR != -1 && dR <= 4) {
                                int b = (int) f.b(this.aTA, dR, false);
                                if (this.aTD.dP(b)) {
                                    fVar.dG(dR);
                                    a = (long) b;
                                }
                            }
                            fVar.dG(1);
                        }
                    }
                    if (a == -1) {
                        AppMethodBeat.o(94886);
                        return false;
                    }
                    this.aTF = (int) a;
                    this.aTE = 1;
                }
                if (this.aTE == 1) {
                    this.aTG = this.aTC.a(fVar, false, true, 8);
                    this.aTE = 2;
                }
                dR = this.aTD.dO(this.aTF);
                o oVar;
                switch (dR) {
                    case 0:
                        fVar.dG((int) this.aTG);
                        this.aTE = 0;
                    case 1:
                        long position = fVar.getPosition();
                        this.aTB.add(new a(this.aTF, this.aTG + position, (byte) 0));
                        this.aTD.f(this.aTF, position, this.aTG);
                        this.aTE = 0;
                        AppMethodBeat.o(94886);
                        return true;
                    case 2:
                        if (this.aTG > 8) {
                            oVar = new o("Invalid integer size: " + this.aTG);
                            AppMethodBeat.o(94886);
                            throw oVar;
                        }
                        this.aTD.h(this.aTF, a(fVar, (int) this.aTG));
                        this.aTE = 0;
                        AppMethodBeat.o(94886);
                        return true;
                    case 3:
                        if (this.aTG > 2147483647L) {
                            oVar = new o("String element size: " + this.aTG);
                            AppMethodBeat.o(94886);
                            throw oVar;
                        }
                        String str;
                        c cVar = this.aTD;
                        int i = this.aTF;
                        dR = (int) this.aTG;
                        if (dR == 0) {
                            str = "";
                        } else {
                            byte[] bArr = new byte[dR];
                            fVar.readFully(bArr, 0, dR);
                            str = new String(bArr);
                        }
                        cVar.d(i, str);
                        this.aTE = 0;
                        AppMethodBeat.o(94886);
                        return true;
                    case 4:
                        this.aTD.a(this.aTF, (int) this.aTG, fVar);
                        this.aTE = 0;
                        AppMethodBeat.o(94886);
                        return true;
                    case 5:
                        if (this.aTG == 4 || this.aTG == 8) {
                            double intBitsToFloat;
                            c cVar2 = this.aTD;
                            int i2 = this.aTF;
                            dR = (int) this.aTG;
                            long a2 = a(fVar, dR);
                            if (dR == 4) {
                                intBitsToFloat = (double) Float.intBitsToFloat((int) a2);
                            } else {
                                intBitsToFloat = Double.longBitsToDouble(a2);
                            }
                            cVar2.c(i2, intBitsToFloat);
                            this.aTE = 0;
                            AppMethodBeat.o(94886);
                            return true;
                        }
                        oVar = new o("Invalid float size: " + this.aTG);
                        AppMethodBeat.o(94886);
                        throw oVar;
                    default:
                        o oVar2 = new o("Invalid element type ".concat(String.valueOf(dR)));
                        AppMethodBeat.o(94886);
                        throw oVar2;
                }
            }
            this.aTD.dQ(((a) this.aTB.pop()).aTF);
            AppMethodBeat.o(94886);
            return true;
        }
    }

    private long a(f fVar, int i) {
        int i2 = 0;
        AppMethodBeat.i(94887);
        fVar.readFully(this.aTA, 0, i);
        long j = 0;
        while (i2 < i) {
            j = (j << 8) | ((long) (this.aTA[i2] & 255));
            i2++;
        }
        AppMethodBeat.o(94887);
        return j;
    }
}
