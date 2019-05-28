package p1124g.p1125a.p1126b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;
import java.io.OutputStream;
import p1124g.p1125a.p1357a.C24579a;
import p1124g.p1125a.p1580c.C41149b;
import p1124g.p1125a.p1580c.C44606a;

/* renamed from: g.a.b.a */
public final class C46842a {
    short[] BZA = new short[12];
    short[] BZB = new short[12];
    short[] BZC = new short[C33250az.CTRL_INDEX];
    C44606a[] BZD = new C44606a[4];
    short[] BZE = new short[114];
    C44606a BZF = new C44606a(4);
    C16443a BZG = new C16443a();
    C16443a BZH = new C16443a();
    C31178b BZI = new C31178b();
    int BZJ = -1;
    int BZK = -1;
    int BZL;
    C24579a BZv = new C24579a();
    C41149b BZw = new C41149b();
    short[] BZx = new short[C33250az.CTRL_INDEX];
    short[] BZy = new short[12];
    short[] BZz = new short[12];

    /* renamed from: g.a.b.a$a */
    class C16443a {
        short[] BZM = new short[2];
        C44606a[] BZN = new C44606a[16];
        C44606a[] BZO = new C44606a[16];
        C44606a BZP = new C44606a(8);
        int BZQ = 0;

        C16443a() {
            AppMethodBeat.m2504i(86237);
            AppMethodBeat.m2505o(86237);
        }

        /* renamed from: Vo */
        public final void mo30306Vo(int i) {
            AppMethodBeat.m2504i(86238);
            while (this.BZQ < i) {
                this.BZN[this.BZQ] = new C44606a(3);
                this.BZO[this.BZQ] = new C44606a(3);
                this.BZQ++;
            }
            AppMethodBeat.m2505o(86238);
        }

        public final void enq() {
            AppMethodBeat.m2504i(86239);
            C41149b.m71582c(this.BZM);
            for (int i = 0; i < this.BZQ; i++) {
                C41149b.m71582c(this.BZN[i].BZY);
                C41149b.m71582c(this.BZO[i].BZY);
            }
            C41149b.m71582c(this.BZP.BZY);
            AppMethodBeat.m2505o(86239);
        }

        /* renamed from: a */
        public final int mo30307a(C41149b c41149b, int i) {
            AppMethodBeat.m2504i(86240);
            int a;
            if (c41149b.mo65730g(this.BZM, 0) == 0) {
                a = this.BZN[i].mo71474a(c41149b);
                AppMethodBeat.m2505o(86240);
                return a;
            }
            if (c41149b.mo65730g(this.BZM, 1) == 0) {
                a = this.BZO[i].mo71474a(c41149b) + 8;
            } else {
                a = (this.BZP.mo71474a(c41149b) + 8) + 8;
            }
            AppMethodBeat.m2505o(86240);
            return a;
        }
    }

    /* renamed from: g.a.b.a$b */
    class C31178b {
        C16444a[] BZS;
        int BZT;
        int BZU;
        int BZV;

        /* renamed from: g.a.b.a$b$a */
        class C16444a {
            short[] BZW = new short[768];

            C16444a() {
                AppMethodBeat.m2504i(86241);
                AppMethodBeat.m2505o(86241);
            }
        }

        C31178b() {
        }
    }

    public C46842a() {
        AppMethodBeat.m2504i(86242);
        for (int i = 0; i < 4; i++) {
            this.BZD[i] = new C44606a(6);
        }
        AppMethodBeat.m2505o(86242);
    }

    /* JADX WARNING: Missing block: B:148:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final boolean mo75984a(InputStream inputStream, OutputStream outputStream, long j) {
        int i;
        AppMethodBeat.m2504i(86243);
        this.BZw.Cab = inputStream;
        C24579a c24579a = this.BZv;
        c24579a.eno();
        c24579a.BZu = outputStream;
        c24579a = this.BZv;
        c24579a.BZt = 0;
        c24579a.BUo = 0;
        C41149b.m71582c(this.BZx);
        C41149b.m71582c(this.BZC);
        C41149b.m71582c(this.BZy);
        C41149b.m71582c(this.BZz);
        C41149b.m71582c(this.BZA);
        C41149b.m71582c(this.BZB);
        C41149b.m71582c(this.BZE);
        C31178b c31178b = this.BZI;
        int i2 = 1 << (c31178b.BZT + c31178b.BZU);
        for (i = 0; i < i2; i++) {
            C41149b.m71582c(c31178b.BZS[i].BZW);
        }
        for (i = 0; i < 4; i++) {
            C41149b.m71582c(this.BZD[i].BZY);
        }
        this.BZG.enq();
        this.BZH.enq();
        C41149b.m71582c(this.BZF.BZY);
        C41149b c41149b = this.BZw;
        c41149b.xcZ = 0;
        c41149b.Caa = -1;
        for (i = 0; i < 5; i++) {
            c41149b.xcZ = (c41149b.xcZ << 8) | c41149b.Cab.read();
        }
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        i2 = 0;
        i = 0;
        long j2 = 0;
        while (true) {
            if (j >= 0 && j2 >= j) {
                break;
            }
            int i7 = ((int) j2) & this.BZL;
            int i8;
            int Vn;
            int i9;
            int g;
            if (this.BZw.mo65730g(this.BZx, (i3 << 4) + i7) == 0) {
                Object obj;
                c31178b = this.BZI;
                i8 = (int) j2;
                C16444a c16444a = c31178b.BZS[((i & 255) >>> (8 - c31178b.BZT)) + ((i8 & c31178b.BZV) << c31178b.BZT)];
                if (i3 < 7) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    C41149b c41149b2 = this.BZw;
                    Vn = this.BZv.mo41362Vn(i4);
                    i = 1;
                    do {
                        i9 = (Vn >> 7) & 1;
                        Vn = (byte) (Vn << 1);
                        g = c41149b2.mo65730g(c16444a.BZW, ((i9 + 1) << 8) + i);
                        i = (i << 1) | g;
                        if (i9 != g) {
                            while (i < 256) {
                                i = c41149b2.mo65730g(c16444a.BZW, i) | (i << 1);
                            }
                        }
                        i = (byte) i;
                    } while (i < 256);
                    i = (byte) i;
                } else {
                    c41149b = this.BZw;
                    i = 1;
                    do {
                        i = c41149b.mo65730g(c16444a.BZW, i) | (i << 1);
                    } while (i < 256);
                    i = (byte) i;
                }
                C24579a c24579a2 = this.BZv;
                byte[] bArr = c24579a2.BZr;
                i7 = c24579a2.BUo;
                c24579a2.BUo = i7 + 1;
                bArr[i7] = i;
                if (c24579a2.BUo >= c24579a2.BZs) {
                    c24579a2.enp();
                }
                if (i3 < 4) {
                    Vn = 0;
                } else if (i3 < 10) {
                    Vn = i3 - 3;
                } else {
                    Vn = i3 - 6;
                }
                j2 = 1 + j2;
                i3 = Vn;
            } else {
                int i10;
                int i11;
                if (this.BZw.mo65730g(this.BZy, i3) == 1) {
                    i8 = 0;
                    if (this.BZw.mo65730g(this.BZz, i3) != 0) {
                        if (this.BZw.mo65730g(this.BZA, i3) == 0) {
                            Vn = i5;
                        } else {
                            if (this.BZw.mo65730g(this.BZB, i3) == 0) {
                                i = i2;
                                Vn = i6;
                            } else {
                                i = i6;
                                Vn = i2;
                            }
                            i2 = i;
                            i6 = i5;
                        }
                        i5 = i4;
                        i = i3;
                    } else if (this.BZw.mo65730g(this.BZC, (i3 << 4) + i7) == 0) {
                        if (i3 < 7) {
                            i = 9;
                        } else {
                            i = 11;
                        }
                        i8 = 1;
                        Vn = i4;
                    } else {
                        Vn = i4;
                        i = i3;
                    }
                    if (i8 == 0) {
                        i8 = this.BZH.mo30307a(this.BZw, i7) + 2;
                        if (i < 7) {
                            i = 8;
                        } else {
                            i = 11;
                        }
                        i9 = i2;
                        g = i6;
                        i10 = i5;
                        i11 = Vn;
                        i3 = i;
                    } else {
                        i9 = i2;
                        g = i6;
                        i10 = i5;
                        i11 = Vn;
                        i3 = i;
                    }
                } else {
                    i7 = this.BZG.mo30307a(this.BZw, i7) + 2;
                    if (i3 < 7) {
                        i = 7;
                    } else {
                        i = 10;
                    }
                    C44606a[] c44606aArr = this.BZD;
                    Vn = i7 - 2;
                    if (Vn >= 4) {
                        Vn = 3;
                    }
                    Vn = c44606aArr[Vn].mo71474a(this.BZw);
                    if (Vn >= 4) {
                        i9 = (Vn >> 1) - 1;
                        g = ((Vn & 1) | 2) << i9;
                        if (Vn < 14) {
                            short[] sArr = this.BZE;
                            i11 = (g - Vn) - 1;
                            C41149b c41149b3 = this.BZw;
                            i2 = 1;
                            Vn = 0;
                            for (i8 = 0; i8 < i9; i8++) {
                                int g2 = c41149b3.mo65730g(sArr, i11 + i2);
                                i2 = (i2 << 1) + g2;
                                Vn |= g2 << i8;
                            }
                            Vn += g;
                            i8 = i7;
                            i9 = i6;
                            g = i5;
                            i10 = i4;
                            i11 = Vn;
                            i3 = i;
                        } else {
                            C41149b c41149b4 = this.BZw;
                            i2 = 0;
                            for (Vn = i9 - 4; Vn != 0; Vn--) {
                                c41149b4.Caa >>>= 1;
                                i9 = (c41149b4.xcZ - c41149b4.Caa) >>> 31;
                                c41149b4.xcZ -= c41149b4.Caa & (i9 - 1);
                                i2 = (i2 << 1) | (1 - i9);
                                if ((c41149b4.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
                                    c41149b4.xcZ = (c41149b4.xcZ << 8) | c41149b4.Cab.read();
                                    c41149b4.Caa <<= 8;
                                }
                            }
                            i9 = g + (i2 << 4);
                            C44606a c44606a = this.BZF;
                            C41149b c41149b5 = this.BZw;
                            i8 = 1;
                            i2 = 0;
                            for (Vn = 0; Vn < c44606a.BZZ; Vn++) {
                                i11 = c41149b5.mo65730g(c44606a.BZY, i8);
                                i8 = (i8 << 1) + i11;
                                i2 |= i11 << Vn;
                            }
                            Vn = i9 + i2;
                            if (Vn >= 0) {
                                i8 = i7;
                                i9 = i6;
                                g = i5;
                                i10 = i4;
                                i11 = Vn;
                                i3 = i;
                            } else if (Vn != -1) {
                                AppMethodBeat.m2505o(86243);
                                return false;
                            }
                        }
                    } else {
                        i8 = i7;
                        i9 = i6;
                        g = i5;
                        i10 = i4;
                        i11 = Vn;
                        i3 = i;
                    }
                }
                if (((long) i11) >= j2 || i11 >= this.BZK) {
                    AppMethodBeat.m2505o(86243);
                } else {
                    C24579a c24579a3 = this.BZv;
                    i = (c24579a3.BUo - i11) - 1;
                    if (i < 0) {
                        i += c24579a3.BZs;
                        i2 = i8;
                    } else {
                        i2 = i8;
                    }
                    while (i2 != 0) {
                        if (i >= c24579a3.BZs) {
                            i = 0;
                        }
                        byte[] bArr2 = c24579a3.BZr;
                        i7 = c24579a3.BUo;
                        c24579a3.BUo = i7 + 1;
                        Vn = i + 1;
                        bArr2[i7] = c24579a3.BZr[i];
                        if (c24579a3.BUo >= c24579a3.BZs) {
                            c24579a3.enp();
                        }
                        i2--;
                        i = Vn;
                    }
                    j2 += (long) i8;
                    i = this.BZv.mo41362Vn(0);
                    i2 = i9;
                    i6 = g;
                    i5 = i10;
                    i4 = i11;
                }
            }
        }
        this.BZv.enp();
        this.BZv.eno();
        this.BZw.Cab = null;
        AppMethodBeat.m2505o(86243);
        return true;
    }

    /* renamed from: cR */
    public final boolean mo75985cR(byte[] bArr) {
        AppMethodBeat.m2504i(86244);
        int i = bArr[0] & 255;
        int i2 = i % 9;
        i /= 9;
        int i3 = i % 5;
        int i4 = i / 5;
        int i5 = 0;
        for (i = 0; i < 4; i++) {
            i5 += (bArr[i + 1] & 255) << (i * 8);
        }
        if (i2 > 8 || i3 > 4 || i4 > 4) {
            i = false;
        } else {
            C31178b c31178b = this.BZI;
            if (!(c31178b.BZS != null && c31178b.BZT == i2 && c31178b.BZU == i3)) {
                c31178b.BZU = i3;
                c31178b.BZV = (1 << i3) - 1;
                c31178b.BZT = i2;
                i2 = 1 << (c31178b.BZT + c31178b.BZU);
                c31178b.BZS = new C16444a[i2];
                for (i = 0; i < i2; i++) {
                    c31178b.BZS[i] = new C16444a();
                }
            }
            i = 1 << i4;
            this.BZG.mo30306Vo(i);
            this.BZH.mo30306Vo(i);
            this.BZL = i - 1;
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.m2505o(86244);
            return false;
        } else if (i5 < 0) {
            AppMethodBeat.m2505o(86244);
            return false;
        } else {
            if (this.BZJ != i5) {
                this.BZJ = i5;
                this.BZK = Math.max(this.BZJ, 1);
                C24579a c24579a = this.BZv;
                i5 = Math.max(this.BZK, 4096);
                if (c24579a.BZr == null || c24579a.BZs != i5) {
                    c24579a.BZr = new byte[i5];
                }
                c24579a.BZs = i5;
                c24579a.BUo = 0;
                c24579a.BZt = 0;
            }
            AppMethodBeat.m2505o(86244);
            return true;
        }
    }
}
