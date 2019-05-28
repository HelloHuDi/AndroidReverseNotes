package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.g */
public final class C16313g extends C31087a<C16313g> {
    public int AxH;
    public int AxI;
    public int AxJ;
    public int AxK;
    public short[] AxL;
    public C16315b[] AxM;
    public C16314a[] AxN;

    /* renamed from: com.tencent.tinker.a.a.g$a */
    public static class C16314a implements Comparable<C16314a> {
        public int[] AxO;
        public int[] AxP;
        public int AxQ;
        public int offset;

        public final /* synthetic */ int compareTo(Object obj) {
            C16314a c16314a = (C16314a) obj;
            int b = C5910c.m9193b(this.AxO, c16314a.AxO);
            if (b != 0) {
                return b;
            }
            b = C5910c.m9193b(this.AxP, c16314a.AxP);
            if (b == 0) {
                return C5910c.m9195hY(this.AxQ, c16314a.AxQ);
            }
            return b;
        }

        public C16314a(int[] iArr, int[] iArr2, int i, int i2) {
            this.AxO = iArr;
            this.AxP = iArr2;
            this.AxQ = i;
            this.offset = i2;
        }
    }

    /* renamed from: com.tencent.tinker.a.a.g$b */
    public static class C16315b implements Comparable<C16315b> {
        public int AxR;
        public int AxS;
        public int AxT;

        public final /* synthetic */ int compareTo(Object obj) {
            C16315b c16315b = (C16315b) obj;
            int hY = C5910c.m9195hY(this.AxR, c16315b.AxR);
            if (hY != 0) {
                return hY;
            }
            hY = C5910c.m9195hY(this.AxS, c16315b.AxS);
            if (hY == 0) {
                return C5910c.m9195hY(this.AxT, c16315b.AxT);
            }
            return hY;
        }

        public C16315b(int i, int i2, int i3) {
            this.AxR = i;
            this.AxS = i2;
            this.AxT = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        C16313g c16313g = (C16313g) obj;
        int hY = C5910c.m9195hY(this.AxH, c16313g.AxH);
        if (hY != 0) {
            return hY;
        }
        hY = C5910c.m9195hY(this.AxI, c16313g.AxI);
        if (hY != 0) {
            return hY;
        }
        hY = C5910c.m9195hY(this.AxJ, c16313g.AxJ);
        if (hY != 0) {
            return hY;
        }
        hY = C5910c.m9195hY(this.AxK, c16313g.AxK);
        if (hY != 0) {
            return hY;
        }
        hY = C5910c.m9191a(this.AxL, c16313g.AxL);
        if (hY != 0) {
            return hY;
        }
        hY = C5910c.m9190a(this.AxM, c16313g.AxM);
        if (hY == 0) {
            return C5910c.m9190a(this.AxN, c16313g.AxN);
        }
        return hY;
    }

    public C16313g(int i, int i2, int i3, int i4, int i5, short[] sArr, C16315b[] c16315bArr, C16314a[] c16314aArr) {
        super(i);
        this.AxH = i2;
        this.AxI = i3;
        this.AxJ = i4;
        this.AxK = i5;
        this.AxL = sArr;
        this.AxM = c16315bArr;
        this.AxN = c16314aArr;
    }
}
