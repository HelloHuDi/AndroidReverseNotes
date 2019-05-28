package com.google.android.exoplayer2.c.f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.c.f.v.d;
import com.google.android.exoplayer2.c.g;
import com.google.android.exoplayer2.c.m;
import com.google.android.exoplayer2.i.j.b;
import com.google.android.exoplayer2.i.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class j implements h {
    private boolean aTf;
    private m aTw;
    private final boolean[] bbM = new boolean[3];
    private long bbO;
    private long bbQ;
    private final s bbX;
    private final boolean bbY;
    private final boolean bbZ;
    private String bbx;
    private final n bca = new n(7);
    private final n bcb = new n(8);
    private final n bcc = new n(6);
    private a bcd;
    private final l bce = new l();

    static final class a {
        final m aTw;
        long bbJ;
        long bbR;
        boolean bbS;
        boolean bbV;
        final boolean bbY;
        final boolean bbZ;
        private final SparseArray<b> bcf = new SparseArray();
        private final SparseArray<com.google.android.exoplayer2.i.j.a> bcg = new SparseArray();
        private final com.google.android.exoplayer2.i.m bch = new com.google.android.exoplayer2.i.m(this.buffer, 0, 0);
        int bci;
        int bcj;
        long bck;
        long bcl;
        a bcm = new a();
        a bcn = new a();
        boolean bco;
        private byte[] buffer = new byte[128];

        static final class a {
            int bcA;
            int bcB;
            int bcC;
            int bcD;
            boolean bcp;
            boolean bcq;
            b bcr;
            int bcs;
            int bct;
            int bcu;
            boolean bcv;
            boolean bcw;
            boolean bcx;
            boolean bcy;
            int bcz;
            int frameNum;

            private a() {
            }

            /* synthetic */ a(byte b) {
                this();
            }

            public final void clear() {
                this.bcq = false;
                this.bcp = false;
            }

            public final void eg(int i) {
                this.bct = i;
                this.bcq = true;
            }

            public final void a(b bVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.bcr = bVar;
                this.bcs = i;
                this.bct = i2;
                this.frameNum = i3;
                this.bcu = i4;
                this.bcv = z;
                this.bcw = z2;
                this.bcx = z3;
                this.bcy = z4;
                this.bcz = i5;
                this.bcA = i6;
                this.bcB = i7;
                this.bcC = i8;
                this.bcD = i9;
                this.bcp = true;
                this.bcq = true;
            }
        }

        public a(m mVar, boolean z, boolean z2) {
            AppMethodBeat.i(95117);
            this.aTw = mVar;
            this.bbY = z;
            this.bbZ = z2;
            reset();
            AppMethodBeat.o(95117);
        }

        public final void a(b bVar) {
            AppMethodBeat.i(95118);
            this.bcf.append(bVar.bro, bVar);
            AppMethodBeat.o(95118);
        }

        public final void a(com.google.android.exoplayer2.i.j.a aVar) {
            AppMethodBeat.i(95119);
            this.bcg.append(aVar.bcu, aVar);
            AppMethodBeat.o(95119);
        }

        public final void reset() {
            AppMethodBeat.i(95120);
            this.bbV = false;
            this.bco = false;
            this.bcn.clear();
            AppMethodBeat.o(95120);
        }

        public final void f(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(95121);
            if (this.bbV) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bci + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bci + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bci, i3);
                this.bci = i3 + this.bci;
                this.bch.l(this.buffer, 0, this.bci);
                if (this.bch.eO(8)) {
                    this.bch.tz();
                    int ed = this.bch.ed(2);
                    this.bch.ee(5);
                    if (this.bch.tM()) {
                        this.bch.tO();
                        if (this.bch.tM()) {
                            int tO = this.bch.tO();
                            if (!this.bbZ) {
                                this.bbV = false;
                                this.bcn.eg(tO);
                                AppMethodBeat.o(95121);
                                return;
                            } else if (this.bch.tM()) {
                                int tO2 = this.bch.tO();
                                if (this.bcg.indexOfKey(tO2) < 0) {
                                    this.bbV = false;
                                    AppMethodBeat.o(95121);
                                    return;
                                }
                                com.google.android.exoplayer2.i.j.a aVar = (com.google.android.exoplayer2.i.j.a) this.bcg.get(tO2);
                                b bVar = (b) this.bcf.get(aVar.bro);
                                if (bVar.brr) {
                                    if (this.bch.eO(2)) {
                                        this.bch.ee(2);
                                    } else {
                                        AppMethodBeat.o(95121);
                                        return;
                                    }
                                }
                                if (this.bch.eO(bVar.brt)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int ed2 = this.bch.ed(bVar.brt);
                                    if (!bVar.brs) {
                                        if (this.bch.eO(1)) {
                                            z = this.bch.rl();
                                            if (z) {
                                                if (this.bch.eO(1)) {
                                                    z3 = this.bch.rl();
                                                    z2 = true;
                                                } else {
                                                    AppMethodBeat.o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.o(95121);
                                        return;
                                    }
                                    boolean z4 = this.bcj == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.bch.tM()) {
                                            i4 = this.bch.tO();
                                        } else {
                                            AppMethodBeat.o(95121);
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (bVar.bru == 0) {
                                        if (this.bch.eO(bVar.brv)) {
                                            i5 = this.bch.ed(bVar.brv);
                                            if (aVar.brp && !z) {
                                                if (this.bch.tM()) {
                                                    i6 = this.bch.tN();
                                                } else {
                                                    AppMethodBeat.o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.o(95121);
                                        return;
                                    } else if (bVar.bru == 1 && !bVar.brw) {
                                        if (this.bch.tM()) {
                                            i7 = this.bch.tN();
                                            if (aVar.brp && !z) {
                                                if (this.bch.tM()) {
                                                    i8 = this.bch.tN();
                                                } else {
                                                    AppMethodBeat.o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.o(95121);
                                        return;
                                    }
                                    this.bcn.a(bVar, ed, tO, ed2, tO2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.bbV = false;
                                    AppMethodBeat.o(95121);
                                    return;
                                }
                                AppMethodBeat.o(95121);
                                return;
                            } else {
                                AppMethodBeat.o(95121);
                                return;
                            }
                        }
                        AppMethodBeat.o(95121);
                        return;
                    }
                    AppMethodBeat.o(95121);
                    return;
                }
                AppMethodBeat.o(95121);
                return;
            }
            AppMethodBeat.o(95121);
        }
    }

    public j(s sVar, boolean z, boolean z2) {
        AppMethodBeat.i(95122);
        this.bbX = sVar;
        this.bbY = z;
        this.bbZ = z2;
        AppMethodBeat.o(95122);
    }

    public final void rn() {
        AppMethodBeat.i(95123);
        com.google.android.exoplayer2.i.j.b(this.bbM);
        this.bca.reset();
        this.bcb.reset();
        this.bcc.reset();
        this.bcd.reset();
        this.bbO = 0;
        AppMethodBeat.o(95123);
    }

    public final void a(g gVar, d dVar) {
        AppMethodBeat.i(95124);
        dVar.rz();
        this.bbx = dVar.rB();
        this.aTw = gVar.dM(dVar.rA());
        this.bcd = new a(this.aTw, this.bbY, this.bbZ);
        this.bbX.a(gVar, dVar);
        AppMethodBeat.o(95124);
    }

    public final void d(long j, boolean z) {
        this.bbQ = j;
    }

    public final void ro() {
    }

    private void e(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(95126);
        if (!this.aTf || this.bcd.bbZ) {
            this.bca.f(bArr, i, i2);
            this.bcb.f(bArr, i, i2);
        }
        this.bcc.f(bArr, i, i2);
        this.bcd.f(bArr, i, i2);
        AppMethodBeat.o(95126);
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0250  */
    /* JADX WARNING: Missing block: B:76:0x01fd, code skipped:
            if (r2 != null) goto L_0x01ff;
     */
    /* JADX WARNING: Missing block: B:97:0x0270, code skipped:
            if (r2 != null) goto L_0x0272;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void t(l lVar) {
        AppMethodBeat.i(95125);
        int i = lVar.position;
        int i2 = lVar.limit;
        byte[] bArr = lVar.data;
        this.bbO += (long) lVar.tB();
        this.aTw.a(lVar, lVar.tB());
        while (true) {
            int a = com.google.android.exoplayer2.i.j.a(bArr, i, i2, this.bbM);
            if (a == i2) {
                e(bArr, i, i2);
                AppMethodBeat.o(95125);
                return;
            }
            int i3;
            a aVar;
            boolean z;
            long j;
            a aVar2;
            int k = com.google.android.exoplayer2.i.j.k(bArr, a);
            int i4 = a - i;
            if (i4 > 0) {
                e(bArr, i, a);
            }
            int i5 = i2 - a;
            long j2 = this.bbO - ((long) i5);
            if (i4 < 0) {
                i3 = -i4;
            } else {
                i3 = 0;
            }
            long j3 = this.bbQ;
            if (!this.aTf || this.bcd.bbZ) {
                this.bca.ej(i3);
                this.bcb.ej(i3);
                if (this.aTf) {
                    if (this.bca.bcU) {
                        this.bcd.a(com.google.android.exoplayer2.i.j.k(this.bca.bcV, 3, this.bca.bcW));
                        this.bca.reset();
                    } else if (this.bcb.bcU) {
                        this.bcd.a(com.google.android.exoplayer2.i.j.m(this.bcb.bcV, this.bcb.bcW));
                        this.bcb.reset();
                    }
                } else if (this.bca.bcU && this.bcb.bcU) {
                    List arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.bca.bcV, this.bca.bcW));
                    arrayList.add(Arrays.copyOf(this.bcb.bcV, this.bcb.bcW));
                    b k2 = com.google.android.exoplayer2.i.j.k(this.bca.bcV, 3, this.bca.bcW);
                    com.google.android.exoplayer2.i.j.a m = com.google.android.exoplayer2.i.j.m(this.bcb.bcV, this.bcb.bcW);
                    this.aTw.f(Format.a(this.bbx, "video/avc", k2.width, k2.height, arrayList, k2.brq));
                    this.aTf = true;
                    this.bcd.a(k2);
                    this.bcd.a(m);
                    this.bca.reset();
                    this.bcb.reset();
                }
            }
            if (this.bcc.ej(i3)) {
                this.bce.n(this.bcc.bcV, com.google.android.exoplayer2.i.j.j(this.bcc.bcV, this.bcc.bcW));
                this.bce.setPosition(4);
                this.bbX.a(j3, this.bce);
            }
            a aVar3 = this.bcd;
            if (aVar3.bcj != 9) {
                Object obj;
                if (aVar3.bbZ) {
                    aVar = aVar3.bcn;
                    a aVar4 = aVar3.bcm;
                    if (!aVar.bcp || (aVar4.bcp && aVar.frameNum == aVar4.frameNum && aVar.bcu == aVar4.bcu && aVar.bcv == aVar4.bcv && (!(aVar.bcw && aVar4.bcw && aVar.bcx != aVar4.bcx) && ((aVar.bcs == aVar4.bcs || !(aVar.bcs == 0 || aVar4.bcs == 0)) && !((aVar.bcr.bru == 0 && aVar4.bcr.bru == 0 && (aVar.bcA != aVar4.bcA || aVar.bcB != aVar4.bcB)) || ((aVar.bcr.bru == 1 && aVar4.bcr.bru == 1 && (aVar.bcC != aVar4.bcC || aVar.bcD != aVar4.bcD)) || aVar.bcy != aVar4.bcy || (aVar.bcy && aVar4.bcy && aVar.bcz != aVar4.bcz))))))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                }
                z = aVar3.bbS;
                if (aVar3.bcj != 5) {
                    if (aVar3.bbY && aVar3.bcj == 1) {
                        aVar = aVar3.bcn;
                        if (aVar.bcq && (aVar.bct == 7 || aVar.bct == 2)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    i = 0;
                    aVar3.bbS = i | z;
                    j = this.bbQ;
                    if (!this.aTf || this.bcd.bbZ) {
                        this.bca.ei(k);
                        this.bcb.ei(k);
                    }
                    this.bcc.ei(k);
                    aVar2 = this.bcd;
                    aVar2.bcj = k;
                    aVar2.bcl = j;
                    aVar2.bck = j2;
                    if ((aVar2.bbY && aVar2.bcj == 1) || (aVar2.bbZ && (aVar2.bcj == 5 || aVar2.bcj == 1 || aVar2.bcj == 2))) {
                        aVar = aVar2.bcm;
                        aVar2.bcm = aVar2.bcn;
                        aVar2.bcn = aVar;
                        aVar2.bcn.clear();
                        aVar2.bci = 0;
                        aVar2.bbV = true;
                    }
                    i = a + 3;
                }
                i = 1;
                aVar3.bbS = i | z;
                j = this.bbQ;
                this.bca.ei(k);
                this.bcb.ei(k);
                this.bcc.ei(k);
                aVar2 = this.bcd;
                aVar2.bcj = k;
                aVar2.bcl = j;
                aVar2.bck = j2;
                aVar = aVar2.bcm;
                aVar2.bcm = aVar2.bcn;
                aVar2.bcn = aVar;
                aVar2.bcn.clear();
                aVar2.bci = 0;
                aVar2.bbV = true;
                i = a + 3;
            }
            if (aVar3.bco) {
                aVar3.aTw.a(aVar3.bbJ, aVar3.bbS ? 1 : 0, (int) (aVar3.bck - aVar3.bbR), i5 + ((int) (j2 - aVar3.bck)), null);
            }
            aVar3.bbR = aVar3.bck;
            aVar3.bbJ = aVar3.bcl;
            aVar3.bbS = false;
            aVar3.bco = true;
            z = aVar3.bbS;
            if (aVar3.bcj != 5) {
            }
            i = 1;
            aVar3.bbS = i | z;
            j = this.bbQ;
            this.bca.ei(k);
            this.bcb.ei(k);
            this.bcc.ei(k);
            aVar2 = this.bcd;
            aVar2.bcj = k;
            aVar2.bcl = j;
            aVar2.bck = j2;
            aVar = aVar2.bcm;
            aVar2.bcm = aVar2.bcn;
            aVar2.bcn = aVar;
            aVar2.bcn.clear();
            aVar2.bci = 0;
            aVar2.bbV = true;
            i = a + 3;
        }
    }
}
