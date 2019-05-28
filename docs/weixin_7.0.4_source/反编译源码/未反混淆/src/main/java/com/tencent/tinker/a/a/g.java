package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class g extends com.tencent.tinker.a.a.t.a.a<g> {
    public int AxH;
    public int AxI;
    public int AxJ;
    public int AxK;
    public short[] AxL;
    public b[] AxM;
    public a[] AxN;

    public static class a implements Comparable<a> {
        public int[] AxO;
        public int[] AxP;
        public int AxQ;
        public int offset;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int b = c.b(this.AxO, aVar.AxO);
            if (b != 0) {
                return b;
            }
            b = c.b(this.AxP, aVar.AxP);
            if (b == 0) {
                return c.hY(this.AxQ, aVar.AxQ);
            }
            return b;
        }

        public a(int[] iArr, int[] iArr2, int i, int i2) {
            this.AxO = iArr;
            this.AxP = iArr2;
            this.AxQ = i;
            this.offset = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int AxR;
        public int AxS;
        public int AxT;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int hY = c.hY(this.AxR, bVar.AxR);
            if (hY != 0) {
                return hY;
            }
            hY = c.hY(this.AxS, bVar.AxS);
            if (hY == 0) {
                return c.hY(this.AxT, bVar.AxT);
            }
            return hY;
        }

        public b(int i, int i2, int i3) {
            this.AxR = i;
            this.AxS = i2;
            this.AxT = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        g gVar = (g) obj;
        int hY = c.hY(this.AxH, gVar.AxH);
        if (hY != 0) {
            return hY;
        }
        hY = c.hY(this.AxI, gVar.AxI);
        if (hY != 0) {
            return hY;
        }
        hY = c.hY(this.AxJ, gVar.AxJ);
        if (hY != 0) {
            return hY;
        }
        hY = c.hY(this.AxK, gVar.AxK);
        if (hY != 0) {
            return hY;
        }
        hY = c.a(this.AxL, gVar.AxL);
        if (hY != 0) {
            return hY;
        }
        hY = c.a(this.AxM, gVar.AxM);
        if (hY == 0) {
            return c.a(this.AxN, gVar.AxN);
        }
        return hY;
    }

    public g(int i, int i2, int i3, int i4, int i5, short[] sArr, b[] bVarArr, a[] aVarArr) {
        super(i);
        this.AxH = i2;
        this.AxI = i3;
        this.AxJ = i4;
        this.AxK = i5;
        this.AxL = sArr;
        this.AxM = bVarArr;
        this.AxN = aVarArr;
    }
}
