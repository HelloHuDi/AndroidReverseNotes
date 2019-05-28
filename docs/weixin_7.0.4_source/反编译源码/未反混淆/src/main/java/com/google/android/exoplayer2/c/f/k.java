package com.google.android.exoplayer2.c.f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.j;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

public final class k implements h {
    private boolean aTf;
    private m aTw;
    private final boolean[] bbM = new boolean[3];
    private long bbO;
    private long bbQ;
    private final s bbX;
    private String bbx;
    private a bcE;
    private final n bcF = new n(32);
    private final n bcG = new n(39);
    private final n bcH = new n(40);
    private final n bca = new n(33);
    private final n bcb = new n(34);
    private final l bce = new l();

    static final class a {
        private final m aTw;
        long bbJ;
        long bbR;
        boolean bbS;
        boolean bcI;
        int bcJ;
        boolean bcK;
        boolean bcL;
        boolean bcM;
        boolean bcN;
        long bck;
        long bcl;
        boolean bco;

        public a(m mVar) {
            this.aTw = mVar;
        }

        public final void g(byte[] bArr, int i, int i2) {
            if (this.bcK) {
                int i3 = (i + 2) - this.bcJ;
                if (i3 < i2) {
                    this.bcL = (bArr[i3] & 128) != 0;
                    this.bcK = false;
                    return;
                }
                this.bcJ += i2 - i;
            }
        }

        /* Access modifiers changed, original: final */
        public final void eh(int i) {
            AppMethodBeat.i(95127);
            this.aTw.a(this.bbJ, this.bbS ? 1 : 0, (int) (this.bck - this.bbR), i, null);
            AppMethodBeat.o(95127);
        }
    }

    public k(s sVar) {
        AppMethodBeat.i(95128);
        this.bbX = sVar;
        AppMethodBeat.o(95128);
    }

    public final void rn() {
        AppMethodBeat.i(95129);
        j.b(this.bbM);
        this.bcF.reset();
        this.bca.reset();
        this.bcb.reset();
        this.bcG.reset();
        this.bcH.reset();
        a aVar = this.bcE;
        aVar.bcK = false;
        aVar.bcL = false;
        aVar.bcM = false;
        aVar.bco = false;
        aVar.bcN = false;
        this.bbO = 0;
        AppMethodBeat.o(95129);
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95130);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        this.bcE = new a(this.aTw);
        this.bbX.a(gVar, dVar);
        AppMethodBeat.o(95130);
    }

    public final void d(long j, boolean z) {
        this.bbQ = j;
    }

    public final void t(l lVar) {
        AppMethodBeat.i(95131);
        while (lVar.tB() > 0) {
            int i = lVar.position;
            int i2 = lVar.limit;
            byte[] bArr = lVar.data;
            this.bbO += (long) lVar.tB();
            this.aTw.a(lVar, lVar.tB());
            while (i < i2) {
                int a = j.a(bArr, i, i2, this.bbM);
                if (a == i2) {
                    e(bArr, i, i2);
                    AppMethodBeat.o(95131);
                    return;
                }
                int i3;
                int l = j.l(bArr, a);
                int i4 = a - i;
                if (i4 > 0) {
                    e(bArr, i, a);
                }
                int i5 = i2 - a;
                long j = this.bbO - ((long) i5);
                if (i4 < 0) {
                    i3 = -i4;
                } else {
                    i3 = 0;
                }
                long j2 = this.bbQ;
                if (this.aTf) {
                    a aVar = this.bcE;
                    if (aVar.bcN && aVar.bcL) {
                        aVar.bbS = aVar.bcI;
                        aVar.bcN = false;
                    } else if (aVar.bcM || aVar.bcL) {
                        if (aVar.bco) {
                            aVar.eh(((int) (j - aVar.bck)) + i5);
                        }
                        aVar.bbR = aVar.bck;
                        aVar.bbJ = aVar.bcl;
                        aVar.bco = true;
                        aVar.bbS = aVar.bcI;
                    }
                } else {
                    this.bcF.ej(i3);
                    this.bca.ej(i3);
                    this.bcb.ej(i3);
                    if (this.bcF.bcU && this.bca.bcU && this.bcb.bcU) {
                        int i6;
                        int tO;
                        int tO2;
                        int tO3;
                        int tO4;
                        int i7;
                        float f;
                        m mVar = this.aTw;
                        String str = this.bbx;
                        n nVar = this.bcF;
                        n nVar2 = this.bca;
                        n nVar3 = this.bcb;
                        Object obj = new byte[((nVar.bcW + nVar2.bcW) + nVar3.bcW)];
                        System.arraycopy(nVar.bcV, 0, obj, 0, nVar.bcW);
                        System.arraycopy(nVar2.bcV, 0, obj, nVar.bcW, nVar2.bcW);
                        System.arraycopy(nVar3.bcV, 0, obj, nVar.bcW + nVar2.bcW, nVar3.bcW);
                        com.google.android.exoplayer2.i.m mVar2 = new com.google.android.exoplayer2.i.m(nVar2.bcV, 0, nVar2.bcW);
                        mVar2.ee(44);
                        int ed = mVar2.ed(3);
                        mVar2.tz();
                        mVar2.ee(88);
                        mVar2.ee(8);
                        i4 = 0;
                        for (i6 = 0; i6 < ed; i6++) {
                            if (mVar2.rl()) {
                                i4 += 89;
                            }
                            if (mVar2.rl()) {
                                i4 += 8;
                            }
                        }
                        mVar2.ee(i4);
                        if (ed > 0) {
                            mVar2.ee((8 - ed) * 2);
                        }
                        mVar2.tO();
                        int tO5 = mVar2.tO();
                        if (tO5 == 3) {
                            mVar2.tz();
                        }
                        i6 = mVar2.tO();
                        int tO6 = mVar2.tO();
                        if (mVar2.rl()) {
                            tO = mVar2.tO();
                            tO2 = mVar2.tO();
                            tO3 = mVar2.tO();
                            tO4 = mVar2.tO();
                            i7 = (tO5 == 1 || tO5 == 2) ? 2 : 1;
                            i6 -= i7 * (tO + tO2);
                            tO6 -= (tO5 == 1 ? 2 : 1) * (tO3 + tO4);
                        }
                        mVar2.tO();
                        mVar2.tO();
                        tO = mVar2.tO();
                        if (mVar2.rl()) {
                            i4 = 0;
                        } else {
                            i4 = ed;
                        }
                        while (i4 <= ed) {
                            mVar2.tO();
                            mVar2.tO();
                            mVar2.tO();
                            i4++;
                        }
                        mVar2.tO();
                        mVar2.tO();
                        mVar2.tO();
                        mVar2.tO();
                        mVar2.tO();
                        mVar2.tO();
                        if (mVar2.rl() && mVar2.rl()) {
                            i4 = 0;
                            while (true) {
                                i7 = i4;
                                if (i7 >= 4) {
                                    break;
                                }
                                i4 = 0;
                                while (true) {
                                    ed = i4;
                                    if (ed >= 6) {
                                        break;
                                    }
                                    if (mVar2.rl()) {
                                        tO5 = Math.min(64, 1 << ((i7 << 1) + 4));
                                        if (i7 > 1) {
                                            mVar2.tN();
                                        }
                                        for (i4 = 0; i4 < tO5; i4++) {
                                            mVar2.tN();
                                        }
                                    } else {
                                        mVar2.tO();
                                    }
                                    i4 = (i7 == 3 ? 3 : 1) + ed;
                                }
                                i4 = i7 + 1;
                            }
                        }
                        mVar2.ee(2);
                        if (mVar2.rl()) {
                            mVar2.ee(8);
                            mVar2.tO();
                            mVar2.tO();
                            mVar2.tz();
                        }
                        tO2 = mVar2.tO();
                        boolean z = false;
                        i4 = 0;
                        tO5 = 0;
                        while (tO5 < tO2) {
                            boolean rl;
                            if (tO5 != 0) {
                                rl = mVar2.rl();
                            } else {
                                rl = z;
                            }
                            if (rl) {
                                mVar2.tz();
                                mVar2.tO();
                                for (ed = 0; ed <= i4; ed++) {
                                    if (mVar2.rl()) {
                                        mVar2.tz();
                                    }
                                }
                            } else {
                                tO3 = mVar2.tO();
                                tO4 = mVar2.tO();
                                i4 = tO3 + tO4;
                                for (ed = 0; ed < tO3; ed++) {
                                    mVar2.tO();
                                    mVar2.tz();
                                }
                                for (ed = 0; ed < tO4; ed++) {
                                    mVar2.tO();
                                    mVar2.tz();
                                }
                            }
                            tO5++;
                            z = rl;
                        }
                        if (mVar2.rl()) {
                            for (i4 = 0; i4 < mVar2.tO(); i4++) {
                                mVar2.ee((tO + 4) + 1);
                            }
                        }
                        mVar2.ee(2);
                        float f2 = 1.0f;
                        if (mVar2.rl() && mVar2.rl()) {
                            ed = mVar2.ed(8);
                            if (ed == 255) {
                                ed = mVar2.ed(16);
                                i7 = mVar2.ed(16);
                                if (!(ed == 0 || i7 == 0)) {
                                    f2 = ((float) ed) / ((float) i7);
                                }
                                f = f2;
                            } else if (ed < j.brl.length) {
                                f = j.brl[ed];
                            }
                            mVar.f(Format.a(str, "video/hevc", i6, tO6, Collections.singletonList(obj), f));
                            this.aTf = true;
                        }
                        f = 1.0f;
                        mVar.f(Format.a(str, "video/hevc", i6, tO6, Collections.singletonList(obj), f));
                        this.aTf = true;
                    }
                }
                if (this.bcG.ej(i3)) {
                    this.bce.n(this.bcG.bcV, j.j(this.bcG.bcV, this.bcG.bcW));
                    this.bce.eM(5);
                    this.bbX.a(j2, this.bce);
                }
                if (this.bcH.ej(i3)) {
                    this.bce.n(this.bcH.bcV, j.j(this.bcH.bcV, this.bcH.bcW));
                    this.bce.eM(5);
                    this.bbX.a(j2, this.bce);
                }
                long j3 = this.bbQ;
                if (this.aTf) {
                    a aVar2 = this.bcE;
                    aVar2.bcL = false;
                    aVar2.bcM = false;
                    aVar2.bcl = j3;
                    aVar2.bcJ = 0;
                    aVar2.bck = j;
                    if (l >= 32) {
                        if (!aVar2.bcN && aVar2.bco) {
                            aVar2.eh(i5);
                            aVar2.bco = false;
                        }
                        if (l <= 34) {
                            aVar2.bcM = !aVar2.bcN;
                            aVar2.bcN = true;
                        }
                    }
                    boolean z2 = l >= 16 && l <= 21;
                    aVar2.bcI = z2;
                    if (aVar2.bcI || l <= 9) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    aVar2.bcK = z2;
                } else {
                    this.bcF.ei(l);
                    this.bca.ei(l);
                    this.bcb.ei(l);
                }
                this.bcG.ei(l);
                this.bcH.ei(l);
                i = a + 3;
            }
        }
        AppMethodBeat.o(95131);
    }

    public final void ro() {
    }

    private void e(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95132);
        if (this.aTf) {
            this.bcE.g(bArr, i, i2);
        } else {
            this.bcF.f(bArr, i, i2);
            this.bca.f(bArr, i, i2);
            this.bcb.f(bArr, i, i2);
        }
        this.bcG.f(bArr, i, i2);
        this.bcH.f(bArr, i, i2);
        AppMethodBeat.o(95132);
    }
}
