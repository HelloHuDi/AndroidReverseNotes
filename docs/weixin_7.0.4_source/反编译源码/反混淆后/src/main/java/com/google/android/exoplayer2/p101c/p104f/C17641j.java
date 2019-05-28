package com.google.android.exoplayer2.p101c.p104f;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p101c.C32041m;
import com.google.android.exoplayer2.p101c.C8662g;
import com.google.android.exoplayer2.p101c.p104f.C37245v.C8661d;
import com.google.android.exoplayer2.p111i.C32065l;
import com.google.android.exoplayer2.p111i.C45041j;
import com.google.android.exoplayer2.p111i.C45041j.C41617b;
import com.google.android.exoplayer2.p111i.C45041j.C45040a;
import com.google.android.exoplayer2.p111i.C8685m;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.c.f.j */
public final class C17641j implements C0845h {
    private boolean aTf;
    private C32041m aTw;
    private final boolean[] bbM = new boolean[3];
    private long bbO;
    private long bbQ;
    private final C17643s bbX;
    private final boolean bbY;
    private final boolean bbZ;
    private String bbx;
    private final C37241n bca = new C37241n(7);
    private final C37241n bcb = new C37241n(8);
    private final C37241n bcc = new C37241n(6);
    private C0847a bcd;
    private final C32065l bce = new C32065l();

    /* renamed from: com.google.android.exoplayer2.c.f.j$a */
    static final class C0847a {
        final C32041m aTw;
        long bbJ;
        long bbR;
        boolean bbS;
        boolean bbV;
        final boolean bbY;
        final boolean bbZ;
        private final SparseArray<C41617b> bcf = new SparseArray();
        private final SparseArray<C45040a> bcg = new SparseArray();
        private final C8685m bch = new C8685m(this.buffer, 0, 0);
        int bci;
        int bcj;
        long bck;
        long bcl;
        C0848a bcm = new C0848a();
        C0848a bcn = new C0848a();
        boolean bco;
        private byte[] buffer = new byte[128];

        /* renamed from: com.google.android.exoplayer2.c.f.j$a$a */
        static final class C0848a {
            int bcA;
            int bcB;
            int bcC;
            int bcD;
            boolean bcp;
            boolean bcq;
            C41617b bcr;
            int bcs;
            int bct;
            int bcu;
            boolean bcv;
            boolean bcw;
            boolean bcx;
            boolean bcy;
            int bcz;
            int frameNum;

            private C0848a() {
            }

            /* synthetic */ C0848a(byte b) {
                this();
            }

            public final void clear() {
                this.bcq = false;
                this.bcp = false;
            }

            /* renamed from: eg */
            public final void mo2567eg(int i) {
                this.bct = i;
                this.bcq = true;
            }

            /* renamed from: a */
            public final void mo2565a(C41617b c41617b, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.bcr = c41617b;
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

        public C0847a(C32041m c32041m, boolean z, boolean z2) {
            AppMethodBeat.m2504i(95117);
            this.aTw = c32041m;
            this.bbY = z;
            this.bbZ = z2;
            reset();
            AppMethodBeat.m2505o(95117);
        }

        /* renamed from: a */
        public final void mo2562a(C41617b c41617b) {
            AppMethodBeat.m2504i(95118);
            this.bcf.append(c41617b.bro, c41617b);
            AppMethodBeat.m2505o(95118);
        }

        /* renamed from: a */
        public final void mo2561a(C45040a c45040a) {
            AppMethodBeat.m2504i(95119);
            this.bcg.append(c45040a.bcu, c45040a);
            AppMethodBeat.m2505o(95119);
        }

        public final void reset() {
            AppMethodBeat.m2504i(95120);
            this.bbV = false;
            this.bco = false;
            this.bcn.clear();
            AppMethodBeat.m2505o(95120);
        }

        /* renamed from: f */
        public final void mo2563f(byte[] bArr, int i, int i2) {
            AppMethodBeat.m2504i(95121);
            if (this.bbV) {
                int i3 = i2 - i;
                if (this.buffer.length < this.bci + i3) {
                    this.buffer = Arrays.copyOf(this.buffer, (this.bci + i3) * 2);
                }
                System.arraycopy(bArr, i, this.buffer, this.bci, i3);
                this.bci = i3 + this.bci;
                this.bch.mo19218l(this.buffer, 0, this.bci);
                if (this.bch.mo19215eO(8)) {
                    this.bch.mo19223tz();
                    int ed = this.bch.mo19216ed(2);
                    this.bch.mo19217ee(5);
                    if (this.bch.mo19220tM()) {
                        this.bch.mo19222tO();
                        if (this.bch.mo19220tM()) {
                            int tO = this.bch.mo19222tO();
                            if (!this.bbZ) {
                                this.bbV = false;
                                this.bcn.mo2567eg(tO);
                                AppMethodBeat.m2505o(95121);
                                return;
                            } else if (this.bch.mo19220tM()) {
                                int tO2 = this.bch.mo19222tO();
                                if (this.bcg.indexOfKey(tO2) < 0) {
                                    this.bbV = false;
                                    AppMethodBeat.m2505o(95121);
                                    return;
                                }
                                C45040a c45040a = (C45040a) this.bcg.get(tO2);
                                C41617b c41617b = (C41617b) this.bcf.get(c45040a.bro);
                                if (c41617b.brr) {
                                    if (this.bch.mo19215eO(2)) {
                                        this.bch.mo19217ee(2);
                                    } else {
                                        AppMethodBeat.m2505o(95121);
                                        return;
                                    }
                                }
                                if (this.bch.mo19215eO(c41617b.brt)) {
                                    boolean z = false;
                                    boolean z2 = false;
                                    boolean z3 = false;
                                    int ed2 = this.bch.mo19216ed(c41617b.brt);
                                    if (!c41617b.brs) {
                                        if (this.bch.mo19215eO(1)) {
                                            z = this.bch.mo19219rl();
                                            if (z) {
                                                if (this.bch.mo19215eO(1)) {
                                                    z3 = this.bch.mo19219rl();
                                                    z2 = true;
                                                } else {
                                                    AppMethodBeat.m2505o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.m2505o(95121);
                                        return;
                                    }
                                    boolean z4 = this.bcj == 5;
                                    int i4 = 0;
                                    if (z4) {
                                        if (this.bch.mo19220tM()) {
                                            i4 = this.bch.mo19222tO();
                                        } else {
                                            AppMethodBeat.m2505o(95121);
                                            return;
                                        }
                                    }
                                    int i5 = 0;
                                    int i6 = 0;
                                    int i7 = 0;
                                    int i8 = 0;
                                    if (c41617b.bru == 0) {
                                        if (this.bch.mo19215eO(c41617b.brv)) {
                                            i5 = this.bch.mo19216ed(c41617b.brv);
                                            if (c45040a.brp && !z) {
                                                if (this.bch.mo19220tM()) {
                                                    i6 = this.bch.mo19221tN();
                                                } else {
                                                    AppMethodBeat.m2505o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.m2505o(95121);
                                        return;
                                    } else if (c41617b.bru == 1 && !c41617b.brw) {
                                        if (this.bch.mo19220tM()) {
                                            i7 = this.bch.mo19221tN();
                                            if (c45040a.brp && !z) {
                                                if (this.bch.mo19220tM()) {
                                                    i8 = this.bch.mo19221tN();
                                                } else {
                                                    AppMethodBeat.m2505o(95121);
                                                    return;
                                                }
                                            }
                                        }
                                        AppMethodBeat.m2505o(95121);
                                        return;
                                    }
                                    this.bcn.mo2565a(c41617b, ed, tO, ed2, tO2, z, z2, z3, z4, i4, i5, i6, i7, i8);
                                    this.bbV = false;
                                    AppMethodBeat.m2505o(95121);
                                    return;
                                }
                                AppMethodBeat.m2505o(95121);
                                return;
                            } else {
                                AppMethodBeat.m2505o(95121);
                                return;
                            }
                        }
                        AppMethodBeat.m2505o(95121);
                        return;
                    }
                    AppMethodBeat.m2505o(95121);
                    return;
                }
                AppMethodBeat.m2505o(95121);
                return;
            }
            AppMethodBeat.m2505o(95121);
        }
    }

    public C17641j(C17643s c17643s, boolean z, boolean z2) {
        AppMethodBeat.m2504i(95122);
        this.bbX = c17643s;
        this.bbY = z;
        this.bbZ = z2;
        AppMethodBeat.m2505o(95122);
    }

    /* renamed from: rn */
    public final void mo2557rn() {
        AppMethodBeat.m2504i(95123);
        C45041j.m82575b(this.bbM);
        this.bca.reset();
        this.bcb.reset();
        this.bcc.reset();
        this.bcd.reset();
        this.bbO = 0;
        AppMethodBeat.m2505o(95123);
    }

    /* renamed from: a */
    public final void mo2555a(C8662g c8662g, C8661d c8661d) {
        AppMethodBeat.m2504i(95124);
        c8661d.mo19155rz();
        this.bbx = c8661d.mo19154rB();
        this.aTw = c8662g.mo19157dM(c8661d.mo19153rA());
        this.bcd = new C0847a(this.aTw, this.bbY, this.bbZ);
        this.bbX.mo32327a(c8662g, c8661d);
        AppMethodBeat.m2505o(95124);
    }

    /* renamed from: d */
    public final void mo2556d(long j, boolean z) {
        this.bbQ = j;
    }

    /* renamed from: ro */
    public final void mo2558ro() {
    }

    /* renamed from: e */
    private void m27479e(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(95126);
        if (!this.aTf || this.bcd.bbZ) {
            this.bca.mo59493f(bArr, i, i2);
            this.bcb.mo59493f(bArr, i, i2);
        }
        this.bcc.mo59493f(bArr, i, i2);
        this.bcd.mo2563f(bArr, i, i2);
        AppMethodBeat.m2505o(95126);
    }

    /* JADX WARNING: Removed duplicated region for block: B:86:0x0250  */
    /* JADX WARNING: Missing block: B:76:0x01fd, code skipped:
            if (r2 != null) goto L_0x01ff;
     */
    /* JADX WARNING: Missing block: B:97:0x0270, code skipped:
            if (r2 != null) goto L_0x0272;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: t */
    public final void mo2559t(C32065l c32065l) {
        AppMethodBeat.m2504i(95125);
        int i = c32065l.position;
        int i2 = c32065l.limit;
        byte[] bArr = c32065l.data;
        this.bbO += (long) c32065l.mo52382tB();
        this.aTw.mo42835a(c32065l, c32065l.mo52382tB());
        while (true) {
            int a = C45041j.m82574a(bArr, i, i2, this.bbM);
            if (a == i2) {
                m27479e(bArr, i, i2);
                AppMethodBeat.m2505o(95125);
                return;
            }
            int i3;
            C0848a c0848a;
            boolean z;
            long j;
            C0847a c0847a;
            int k = C45041j.m82579k(bArr, a);
            int i4 = a - i;
            if (i4 > 0) {
                m27479e(bArr, i, a);
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
                this.bca.mo59492ej(i3);
                this.bcb.mo59492ej(i3);
                if (this.aTf) {
                    if (this.bca.bcU) {
                        this.bcd.mo2562a(C45041j.m82580k(this.bca.bcV, 3, this.bca.bcW));
                        this.bca.reset();
                    } else if (this.bcb.bcU) {
                        this.bcd.mo2561a(C45041j.m82582m(this.bcb.bcV, this.bcb.bcW));
                        this.bcb.reset();
                    }
                } else if (this.bca.bcU && this.bcb.bcU) {
                    List arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.bca.bcV, this.bca.bcW));
                    arrayList.add(Arrays.copyOf(this.bcb.bcV, this.bcb.bcW));
                    C41617b k2 = C45041j.m82580k(this.bca.bcV, 3, this.bca.bcW);
                    C45040a m = C45041j.m82582m(this.bcb.bcV, this.bcb.bcW);
                    this.aTw.mo42836f(Format.m15273a(this.bbx, "video/avc", k2.width, k2.height, arrayList, k2.brq));
                    this.aTf = true;
                    this.bcd.mo2562a(k2);
                    this.bcd.mo2561a(m);
                    this.bca.reset();
                    this.bcb.reset();
                }
            }
            if (this.bcc.mo59492ej(i3)) {
                this.bce.mo52371n(this.bcc.bcV, C45041j.m82578j(this.bcc.bcV, this.bcc.bcW));
                this.bce.setPosition(4);
                this.bbX.mo32326a(j3, this.bce);
            }
            C0847a c0847a2 = this.bcd;
            if (c0847a2.bcj != 9) {
                Object obj;
                if (c0847a2.bbZ) {
                    c0848a = c0847a2.bcn;
                    C0848a c0848a2 = c0847a2.bcm;
                    if (!c0848a.bcp || (c0848a2.bcp && c0848a.frameNum == c0848a2.frameNum && c0848a.bcu == c0848a2.bcu && c0848a.bcv == c0848a2.bcv && (!(c0848a.bcw && c0848a2.bcw && c0848a.bcx != c0848a2.bcx) && ((c0848a.bcs == c0848a2.bcs || !(c0848a.bcs == 0 || c0848a2.bcs == 0)) && !((c0848a.bcr.bru == 0 && c0848a2.bcr.bru == 0 && (c0848a.bcA != c0848a2.bcA || c0848a.bcB != c0848a2.bcB)) || ((c0848a.bcr.bru == 1 && c0848a2.bcr.bru == 1 && (c0848a.bcC != c0848a2.bcC || c0848a.bcD != c0848a2.bcD)) || c0848a.bcy != c0848a2.bcy || (c0848a.bcy && c0848a2.bcy && c0848a.bcz != c0848a2.bcz))))))) {
                        obj = null;
                    } else {
                        obj = 1;
                    }
                }
                z = c0847a2.bbS;
                if (c0847a2.bcj != 5) {
                    if (c0847a2.bbY && c0847a2.bcj == 1) {
                        c0848a = c0847a2.bcn;
                        if (c0848a.bcq && (c0848a.bct == 7 || c0848a.bct == 2)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                    }
                    i = 0;
                    c0847a2.bbS = i | z;
                    j = this.bbQ;
                    if (!this.aTf || this.bcd.bbZ) {
                        this.bca.mo59491ei(k);
                        this.bcb.mo59491ei(k);
                    }
                    this.bcc.mo59491ei(k);
                    c0847a = this.bcd;
                    c0847a.bcj = k;
                    c0847a.bcl = j;
                    c0847a.bck = j2;
                    if ((c0847a.bbY && c0847a.bcj == 1) || (c0847a.bbZ && (c0847a.bcj == 5 || c0847a.bcj == 1 || c0847a.bcj == 2))) {
                        c0848a = c0847a.bcm;
                        c0847a.bcm = c0847a.bcn;
                        c0847a.bcn = c0848a;
                        c0847a.bcn.clear();
                        c0847a.bci = 0;
                        c0847a.bbV = true;
                    }
                    i = a + 3;
                }
                i = 1;
                c0847a2.bbS = i | z;
                j = this.bbQ;
                this.bca.mo59491ei(k);
                this.bcb.mo59491ei(k);
                this.bcc.mo59491ei(k);
                c0847a = this.bcd;
                c0847a.bcj = k;
                c0847a.bcl = j;
                c0847a.bck = j2;
                c0848a = c0847a.bcm;
                c0847a.bcm = c0847a.bcn;
                c0847a.bcn = c0848a;
                c0847a.bcn.clear();
                c0847a.bci = 0;
                c0847a.bbV = true;
                i = a + 3;
            }
            if (c0847a2.bco) {
                c0847a2.aTw.mo42834a(c0847a2.bbJ, c0847a2.bbS ? 1 : 0, (int) (c0847a2.bck - c0847a2.bbR), i5 + ((int) (j2 - c0847a2.bck)), null);
            }
            c0847a2.bbR = c0847a2.bck;
            c0847a2.bbJ = c0847a2.bcl;
            c0847a2.bbS = false;
            c0847a2.bco = true;
            z = c0847a2.bbS;
            if (c0847a2.bcj != 5) {
            }
            i = 1;
            c0847a2.bbS = i | z;
            j = this.bbQ;
            this.bca.mo59491ei(k);
            this.bcb.mo59491ei(k);
            this.bcc.mo59491ei(k);
            c0847a = this.bcd;
            c0847a.bcj = k;
            c0847a.bcl = j;
            c0847a.bck = j2;
            c0848a = c0847a.bcm;
            c0847a.bcm = c0847a.bcn;
            c0847a.bcn = c0848a;
            c0847a.bcn.clear();
            c0847a.bci = 0;
            c0847a.bbV = true;
            i = a + 3;
        }
    }
}
