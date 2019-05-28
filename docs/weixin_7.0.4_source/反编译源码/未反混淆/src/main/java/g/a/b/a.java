package g.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.smtt.sdk.WebView;
import java.io.InputStream;
import java.io.OutputStream;

public final class a {
    short[] BZA = new short[12];
    short[] BZB = new short[12];
    short[] BZC = new short[az.CTRL_INDEX];
    g.a.c.a[] BZD = new g.a.c.a[4];
    short[] BZE = new short[114];
    g.a.c.a BZF = new g.a.c.a(4);
    a BZG = new a();
    a BZH = new a();
    b BZI = new b();
    int BZJ = -1;
    int BZK = -1;
    int BZL;
    g.a.a.a BZv = new g.a.a.a();
    g.a.c.b BZw = new g.a.c.b();
    short[] BZx = new short[az.CTRL_INDEX];
    short[] BZy = new short[12];
    short[] BZz = new short[12];

    class a {
        short[] BZM = new short[2];
        g.a.c.a[] BZN = new g.a.c.a[16];
        g.a.c.a[] BZO = new g.a.c.a[16];
        g.a.c.a BZP = new g.a.c.a(8);
        int BZQ = 0;

        a() {
            AppMethodBeat.i(86237);
            AppMethodBeat.o(86237);
        }

        public final void Vo(int i) {
            AppMethodBeat.i(86238);
            while (this.BZQ < i) {
                this.BZN[this.BZQ] = new g.a.c.a(3);
                this.BZO[this.BZQ] = new g.a.c.a(3);
                this.BZQ++;
            }
            AppMethodBeat.o(86238);
        }

        public final void enq() {
            AppMethodBeat.i(86239);
            g.a.c.b.c(this.BZM);
            for (int i = 0; i < this.BZQ; i++) {
                g.a.c.b.c(this.BZN[i].BZY);
                g.a.c.b.c(this.BZO[i].BZY);
            }
            g.a.c.b.c(this.BZP.BZY);
            AppMethodBeat.o(86239);
        }

        public final int a(g.a.c.b bVar, int i) {
            AppMethodBeat.i(86240);
            int a;
            if (bVar.g(this.BZM, 0) == 0) {
                a = this.BZN[i].a(bVar);
                AppMethodBeat.o(86240);
                return a;
            }
            if (bVar.g(this.BZM, 1) == 0) {
                a = this.BZO[i].a(bVar) + 8;
            } else {
                a = (this.BZP.a(bVar) + 8) + 8;
            }
            AppMethodBeat.o(86240);
            return a;
        }
    }

    class b {
        a[] BZS;
        int BZT;
        int BZU;
        int BZV;

        class a {
            short[] BZW = new short[768];

            a() {
                AppMethodBeat.i(86241);
                AppMethodBeat.o(86241);
            }
        }

        b() {
        }
    }

    public a() {
        AppMethodBeat.i(86242);
        for (int i = 0; i < 4; i++) {
            this.BZD[i] = new g.a.c.a(6);
        }
        AppMethodBeat.o(86242);
    }

    /* JADX WARNING: Missing block: B:148:?, code skipped:
            return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(InputStream inputStream, OutputStream outputStream, long j) {
        int i;
        AppMethodBeat.i(86243);
        this.BZw.Cab = inputStream;
        g.a.a.a aVar = this.BZv;
        aVar.eno();
        aVar.BZu = outputStream;
        aVar = this.BZv;
        aVar.BZt = 0;
        aVar.BUo = 0;
        g.a.c.b.c(this.BZx);
        g.a.c.b.c(this.BZC);
        g.a.c.b.c(this.BZy);
        g.a.c.b.c(this.BZz);
        g.a.c.b.c(this.BZA);
        g.a.c.b.c(this.BZB);
        g.a.c.b.c(this.BZE);
        b bVar = this.BZI;
        int i2 = 1 << (bVar.BZT + bVar.BZU);
        for (i = 0; i < i2; i++) {
            g.a.c.b.c(bVar.BZS[i].BZW);
        }
        for (i = 0; i < 4; i++) {
            g.a.c.b.c(this.BZD[i].BZY);
        }
        this.BZG.enq();
        this.BZH.enq();
        g.a.c.b.c(this.BZF.BZY);
        g.a.c.b bVar2 = this.BZw;
        bVar2.xcZ = 0;
        bVar2.Caa = -1;
        for (i = 0; i < 5; i++) {
            bVar2.xcZ = (bVar2.xcZ << 8) | bVar2.Cab.read();
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
            if (this.BZw.g(this.BZx, (i3 << 4) + i7) == 0) {
                Object obj;
                bVar = this.BZI;
                i8 = (int) j2;
                a aVar2 = bVar.BZS[((i & 255) >>> (8 - bVar.BZT)) + ((i8 & bVar.BZV) << bVar.BZT)];
                if (i3 < 7) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    g.a.c.b bVar3 = this.BZw;
                    Vn = this.BZv.Vn(i4);
                    i = 1;
                    do {
                        i9 = (Vn >> 7) & 1;
                        Vn = (byte) (Vn << 1);
                        g = bVar3.g(aVar2.BZW, ((i9 + 1) << 8) + i);
                        i = (i << 1) | g;
                        if (i9 != g) {
                            while (i < 256) {
                                i = bVar3.g(aVar2.BZW, i) | (i << 1);
                            }
                        }
                        i = (byte) i;
                    } while (i < 256);
                    i = (byte) i;
                } else {
                    bVar2 = this.BZw;
                    i = 1;
                    do {
                        i = bVar2.g(aVar2.BZW, i) | (i << 1);
                    } while (i < 256);
                    i = (byte) i;
                }
                g.a.a.a aVar3 = this.BZv;
                byte[] bArr = aVar3.BZr;
                i7 = aVar3.BUo;
                aVar3.BUo = i7 + 1;
                bArr[i7] = i;
                if (aVar3.BUo >= aVar3.BZs) {
                    aVar3.enp();
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
                if (this.BZw.g(this.BZy, i3) == 1) {
                    i8 = 0;
                    if (this.BZw.g(this.BZz, i3) != 0) {
                        if (this.BZw.g(this.BZA, i3) == 0) {
                            Vn = i5;
                        } else {
                            if (this.BZw.g(this.BZB, i3) == 0) {
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
                    } else if (this.BZw.g(this.BZC, (i3 << 4) + i7) == 0) {
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
                        i8 = this.BZH.a(this.BZw, i7) + 2;
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
                    i7 = this.BZG.a(this.BZw, i7) + 2;
                    if (i3 < 7) {
                        i = 7;
                    } else {
                        i = 10;
                    }
                    g.a.c.a[] aVarArr = this.BZD;
                    Vn = i7 - 2;
                    if (Vn >= 4) {
                        Vn = 3;
                    }
                    Vn = aVarArr[Vn].a(this.BZw);
                    if (Vn >= 4) {
                        i9 = (Vn >> 1) - 1;
                        g = ((Vn & 1) | 2) << i9;
                        if (Vn < 14) {
                            short[] sArr = this.BZE;
                            i11 = (g - Vn) - 1;
                            g.a.c.b bVar4 = this.BZw;
                            i2 = 1;
                            Vn = 0;
                            for (i8 = 0; i8 < i9; i8++) {
                                int g2 = bVar4.g(sArr, i11 + i2);
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
                            g.a.c.b bVar5 = this.BZw;
                            i2 = 0;
                            for (Vn = i9 - 4; Vn != 0; Vn--) {
                                bVar5.Caa >>>= 1;
                                i9 = (bVar5.xcZ - bVar5.Caa) >>> 31;
                                bVar5.xcZ -= bVar5.Caa & (i9 - 1);
                                i2 = (i2 << 1) | (1 - i9);
                                if ((bVar5.Caa & WebView.NIGHT_MODE_COLOR) == 0) {
                                    bVar5.xcZ = (bVar5.xcZ << 8) | bVar5.Cab.read();
                                    bVar5.Caa <<= 8;
                                }
                            }
                            i9 = g + (i2 << 4);
                            g.a.c.a aVar4 = this.BZF;
                            g.a.c.b bVar6 = this.BZw;
                            i8 = 1;
                            i2 = 0;
                            for (Vn = 0; Vn < aVar4.BZZ; Vn++) {
                                i11 = bVar6.g(aVar4.BZY, i8);
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
                                AppMethodBeat.o(86243);
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
                    AppMethodBeat.o(86243);
                } else {
                    g.a.a.a aVar5 = this.BZv;
                    i = (aVar5.BUo - i11) - 1;
                    if (i < 0) {
                        i += aVar5.BZs;
                        i2 = i8;
                    } else {
                        i2 = i8;
                    }
                    while (i2 != 0) {
                        if (i >= aVar5.BZs) {
                            i = 0;
                        }
                        byte[] bArr2 = aVar5.BZr;
                        i7 = aVar5.BUo;
                        aVar5.BUo = i7 + 1;
                        Vn = i + 1;
                        bArr2[i7] = aVar5.BZr[i];
                        if (aVar5.BUo >= aVar5.BZs) {
                            aVar5.enp();
                        }
                        i2--;
                        i = Vn;
                    }
                    j2 += (long) i8;
                    i = this.BZv.Vn(0);
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
        AppMethodBeat.o(86243);
        return true;
    }

    public final boolean cR(byte[] bArr) {
        AppMethodBeat.i(86244);
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
            b bVar = this.BZI;
            if (!(bVar.BZS != null && bVar.BZT == i2 && bVar.BZU == i3)) {
                bVar.BZU = i3;
                bVar.BZV = (1 << i3) - 1;
                bVar.BZT = i2;
                i2 = 1 << (bVar.BZT + bVar.BZU);
                bVar.BZS = new a[i2];
                for (i = 0; i < i2; i++) {
                    bVar.BZS[i] = new a();
                }
            }
            i = 1 << i4;
            this.BZG.Vo(i);
            this.BZH.Vo(i);
            this.BZL = i - 1;
            i = 1;
        }
        if (i == 0) {
            AppMethodBeat.o(86244);
            return false;
        } else if (i5 < 0) {
            AppMethodBeat.o(86244);
            return false;
        } else {
            if (this.BZJ != i5) {
                this.BZJ = i5;
                this.BZK = Math.max(this.BZJ, 1);
                g.a.a.a aVar = this.BZv;
                i5 = Math.max(this.BZK, 4096);
                if (aVar.BZr == null || aVar.BZs != i5) {
                    aVar.BZr = new byte[i5];
                }
                aVar.BZs = i5;
                aVar.BUo = 0;
                aVar.BZt = 0;
            }
            AppMethodBeat.o(86244);
            return true;
        }
    }
}
