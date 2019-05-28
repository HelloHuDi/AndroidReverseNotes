package com.google.android.exoplayer2.p101c.p104f;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.p111i.C8685m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Collections;

/* renamed from: com.google.android.exoplayer2.c.f.k */
public final class C6265k implements C0845h {
    private boolean aTf;
    private C32041m aTw;
    private final boolean[] bbM = new boolean[3];
    private long bbO;
    private long bbQ;
    private final C17643s bbX;
    private String bbx;
    private C6266a bcE;
    private final C37241n bcF = new C37241n(32);
    private final C37241n bcG = new C37241n(39);
    private final C37241n bcH = new C37241n(40);
    private final C37241n bca = new C37241n(33);
    private final C37241n bcb = new C37241n(34);
    private final C32065l bce = new C32065l();

    /* renamed from: com.google.android.exoplayer2.c.f.k$a */
    static final class C6266a {
        private final C32041m aTw;
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

        public C6266a(C32041m c32041m) {
            this.aTw = c32041m;
        }

        /* renamed from: g */
        public final void mo14405g(byte[] bArr, int i, int i2) {
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
        /* renamed from: eh */
        public final void mo14404eh(int i) {
            AppMethodBeat.m2504i(95127);
            this.aTw.mo42834a(this.bbJ, this.bbS ? 1 : 0, (int) (this.bck - this.bbR), i, null);
            AppMethodBeat.m2505o(95127);
        }
    }

    public C6265k(C17643s c17643s) {
        AppMethodBeat.m2504i(95128);
        this.bbX = c17643s;
        AppMethodBeat.m2505o(95128);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        AppMethodBeat.m2504i(95129);
        C45041j.m82575b(this.bbM);
        this.bcF.reset();
        this.bca.reset();
        this.bcb.reset();
        this.bcG.reset();
        this.bcH.reset();
        C6266a c6266a = this.bcE;
        c6266a.bcK = false;
        c6266a.bcL = false;
        c6266a.bcM = false;
        c6266a.bco = false;
        c6266a.bcN = false;
        this.bbO = 0;
        AppMethodBeat.m2505o(95129);
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95130);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        this.bcE = new C6266a(this.aTw);
        this.bbX.mo32327a(c8662g, c8661d);
        AppMethodBeat.m2505o(95130);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.bbQ = j;
    }

    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95131);
        while (c32065l.mo52382tB() > 0) {
            int i = c32065l.position;
            int i2 = c32065l.limit;
            byte[] bArr = c32065l.data;
            this.bbO += (long) c32065l.mo52382tB();
            this.aTw.mo42835a(c32065l, c32065l.mo52382tB());
            while (i < i2) {
                int a = C45041j.m82574a(bArr, i, i2, this.bbM);
                if (a == i2) {
                    m10239e(bArr, i, i2);
                    AppMethodBeat.m2505o(95131);
                    return;
                }
                int i3;
                int l = C45041j.m82581l(bArr, a);
                int i4 = a - i;
                if (i4 > 0) {
                    m10239e(bArr, i, a);
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
                    C6266a c6266a = this.bcE;
                    if (c6266a.bcN && c6266a.bcL) {
                        c6266a.bbS = c6266a.bcI;
                        c6266a.bcN = false;
                    } else if (c6266a.bcM || c6266a.bcL) {
                        if (c6266a.bco) {
                            c6266a.mo14404eh(((int) (j - c6266a.bck)) + i5);
                        }
                        c6266a.bbR = c6266a.bck;
                        c6266a.bbJ = c6266a.bcl;
                        c6266a.bco = true;
                        c6266a.bbS = c6266a.bcI;
                    }
                } else {
                    this.bcF.mo59492ej(i3);
                    this.bca.mo59492ej(i3);
                    this.bcb.mo59492ej(i3);
                    if (this.bcF.bcU && this.bca.bcU && this.bcb.bcU) {
                        int i6;
                        int tO;
                        int tO2;
                        int tO3;
                        int tO4;
                        int i7;
                        float f;
                        C32041m c32041m = this.aTw;
                        String str = this.bbx;
                        C37241n c37241n = this.bcF;
                        C37241n c37241n2 = this.bca;
                        C37241n c37241n3 = this.bcb;
                        Object obj = new byte[((c37241n.bcW + c37241n2.bcW) + c37241n3.bcW)];
                        System.arraycopy(c37241n.bcV, 0, obj, 0, c37241n.bcW);
                        System.arraycopy(c37241n2.bcV, 0, obj, c37241n.bcW, c37241n2.bcW);
                        System.arraycopy(c37241n3.bcV, 0, obj, c37241n.bcW + c37241n2.bcW, c37241n3.bcW);
                        C8685m c8685m = new C8685m(c37241n2.bcV, 0, c37241n2.bcW);
                        c8685m.mo19217ee(44);
                        int ed = c8685m.mo19216ed(3);
                        c8685m.mo19223tz();
                        c8685m.mo19217ee(88);
                        c8685m.mo19217ee(8);
                        i4 = 0;
                        for (i6 = 0; i6 < ed; i6++) {
                            if (c8685m.mo19219rl()) {
                                i4 += 89;
                            }
                            if (c8685m.mo19219rl()) {
                                i4 += 8;
                            }
                        }
                        c8685m.mo19217ee(i4);
                        if (ed > 0) {
                            c8685m.mo19217ee((8 - ed) * 2);
                        }
                        c8685m.mo19222tO();
                        int tO5 = c8685m.mo19222tO();
                        if (tO5 == 3) {
                            c8685m.mo19223tz();
                        }
                        i6 = c8685m.mo19222tO();
                        int tO6 = c8685m.mo19222tO();
                        if (c8685m.mo19219rl()) {
                            tO = c8685m.mo19222tO();
                            tO2 = c8685m.mo19222tO();
                            tO3 = c8685m.mo19222tO();
                            tO4 = c8685m.mo19222tO();
                            i7 = (tO5 == 1 || tO5 == 2) ? 2 : 1;
                            i6 -= i7 * (tO + tO2);
                            tO6 -= (tO5 == 1 ? 2 : 1) * (tO3 + tO4);
                        }
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        tO = c8685m.mo19222tO();
                        if (c8685m.mo19219rl()) {
                            i4 = 0;
                        } else {
                            i4 = ed;
                        }
                        while (i4 <= ed) {
                            c8685m.mo19222tO();
                            c8685m.mo19222tO();
                            c8685m.mo19222tO();
                            i4++;
                        }
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        c8685m.mo19222tO();
                        if (c8685m.mo19219rl() && c8685m.mo19219rl()) {
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
                                    if (c8685m.mo19219rl()) {
                                        tO5 = Math.min(64, 1 << ((i7 << 1) + 4));
                                        if (i7 > 1) {
                                            c8685m.mo19221tN();
                                        }
                                        for (i4 = 0; i4 < tO5; i4++) {
                                            c8685m.mo19221tN();
                                        }
                                    } else {
                                        c8685m.mo19222tO();
                                    }
                                    i4 = (i7 == 3 ? 3 : 1) + ed;
                                }
                                i4 = i7 + 1;
                            }
                        }
                        c8685m.mo19217ee(2);
                        if (c8685m.mo19219rl()) {
                            c8685m.mo19217ee(8);
                            c8685m.mo19222tO();
                            c8685m.mo19222tO();
                            c8685m.mo19223tz();
                        }
                        tO2 = c8685m.mo19222tO();
                        boolean z = false;
                        i4 = 0;
                        tO5 = 0;
                        while (tO5 < tO2) {
                            boolean rl;
                            if (tO5 != 0) {
                                rl = c8685m.mo19219rl();
                            } else {
                                rl = z;
                            }
                            if (rl) {
                                c8685m.mo19223tz();
                                c8685m.mo19222tO();
                                for (ed = 0; ed <= i4; ed++) {
                                    if (c8685m.mo19219rl()) {
                                        c8685m.mo19223tz();
                                    }
                                }
                            } else {
                                tO3 = c8685m.mo19222tO();
                                tO4 = c8685m.mo19222tO();
                                i4 = tO3 + tO4;
                                for (ed = 0; ed < tO3; ed++) {
                                    c8685m.mo19222tO();
                                    c8685m.mo19223tz();
                                }
                                for (ed = 0; ed < tO4; ed++) {
                                    c8685m.mo19222tO();
                                    c8685m.mo19223tz();
                                }
                            }
                            tO5++;
                            z = rl;
                        }
                        if (c8685m.mo19219rl()) {
                            for (i4 = 0; i4 < c8685m.mo19222tO(); i4++) {
                                c8685m.mo19217ee((tO + 4) + 1);
                            }
                        }
                        c8685m.mo19217ee(2);
                        float f2 = 1.0f;
                        if (c8685m.mo19219rl() && c8685m.mo19219rl()) {
                            ed = c8685m.mo19216ed(8);
                            if (ed == 255) {
                                ed = c8685m.mo19216ed(16);
                                i7 = c8685m.mo19216ed(16);
                                if (!(ed == 0 || i7 == 0)) {
                                    f2 = ((float) ed) / ((float) i7);
                                }
                                f = f2;
                            } else if (ed < C45041j.brl.length) {
                                f = C45041j.brl[ed];
                            }
                            c32041m.mo42836f(Format.m15273a(str, "video/hevc", i6, tO6, Collections.singletonList(obj), f));
                            this.aTf = true;
                        }
                        f = 1.0f;
                        c32041m.mo42836f(Format.m15273a(str, "video/hevc", i6, tO6, Collections.singletonList(obj), f));
                        this.aTf = true;
                    }
                }
                if (this.bcG.mo59492ej(i3)) {
                    this.bce.mo52371n(this.bcG.bcV, C45041j.m82578j(this.bcG.bcV, this.bcG.bcW));
                    this.bce.mo52369eM(5);
                    this.bbX.mo32326a(j2, this.bce);
                }
                if (this.bcH.mo59492ej(i3)) {
                    this.bce.mo52371n(this.bcH.bcV, C45041j.m82578j(this.bcH.bcV, this.bcH.bcW));
                    this.bce.mo52369eM(5);
                    this.bbX.mo32326a(j2, this.bce);
                }
                long j3 = this.bbQ;
                if (this.aTf) {
                    C6266a c6266a2 = this.bcE;
                    c6266a2.bcL = false;
                    c6266a2.bcM = false;
                    c6266a2.bcl = j3;
                    c6266a2.bcJ = 0;
                    c6266a2.bck = j;
                    if (l >= 32) {
                        if (!c6266a2.bcN && c6266a2.bco) {
                            c6266a2.mo14404eh(i5);
                            c6266a2.bco = false;
                        }
                        if (l <= 34) {
                            c6266a2.bcM = !c6266a2.bcN;
                            c6266a2.bcN = true;
                        }
                    }
                    boolean z2 = l >= 16 && l <= 21;
                    c6266a2.bcI = z2;
                    if (c6266a2.bcI || l <= 9) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    c6266a2.bcK = z2;
                } else {
                    this.bcF.mo59491ei(l);
                    this.bca.mo59491ei(l);
                    this.bcb.mo59491ei(l);
                }
                this.bcG.mo59491ei(l);
                this.bcH.mo59491ei(l);
                i = a + 3;
            }
        }
        AppMethodBeat.m2505o(95131);
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }

    /* renamed from: e */
    private void m10239e(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95132);
        if (this.aTf) {
            this.bcE.mo14405g(bArr, i, i2);
        } else {
            this.bcF.mo59493f(bArr, i, i2);
            this.bca.mo59493f(bArr, i, i2);
            this.bcb.mo59493f(bArr, i, i2);
        }
        this.bcG.mo59493f(bArr, i, i2);
        this.bcH.mo59493f(bArr, i, i2);
        AppMethodBeat.m2505o(95132);
    }
}
