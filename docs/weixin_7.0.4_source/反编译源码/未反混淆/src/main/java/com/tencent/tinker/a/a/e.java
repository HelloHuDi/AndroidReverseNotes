package com.tencent.tinker.a.a;

import com.tencent.tinker.a.a.b.c;

public final class e extends com.tencent.tinker.a.a.t.a.a<e> {
    public a[] Axs;
    public a[] Axt;
    public b[] Axu;
    public b[] Axv;

    public static class a implements Comparable<a> {
        public int Axw;
        public int Axx;

        public final /* synthetic */ int compareTo(Object obj) {
            a aVar = (a) obj;
            int hX = c.hX(this.Axw, aVar.Axw);
            if (hX != 0) {
                return hX;
            }
            return c.hY(this.Axx, aVar.Axx);
        }

        public a(int i, int i2) {
            this.Axw = i;
            this.Axx = i2;
        }
    }

    public static class b implements Comparable<b> {
        public int Axx;
        public int Axy;
        public int Axz;

        public final /* synthetic */ int compareTo(Object obj) {
            b bVar = (b) obj;
            int hX = c.hX(this.Axy, bVar.Axy);
            if (hX != 0) {
                return hX;
            }
            hX = c.hY(this.Axx, bVar.Axx);
            if (hX == 0) {
                return c.hY(this.Axz, bVar.Axz);
            }
            return hX;
        }

        public b(int i, int i2, int i3) {
            this.Axy = i;
            this.Axx = i2;
            this.Axz = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        e eVar = (e) obj;
        int a = c.a(this.Axs, eVar.Axs);
        if (a != 0) {
            return a;
        }
        a = c.a(this.Axt, eVar.Axt);
        if (a != 0) {
            return a;
        }
        a = c.a(this.Axu, eVar.Axu);
        if (a == 0) {
            return c.a(this.Axv, eVar.Axv);
        }
        return a;
    }

    public e(int i, a[] aVarArr, a[] aVarArr2, b[] bVarArr, b[] bVarArr2) {
        super(i);
        this.Axs = aVarArr;
        this.Axt = aVarArr2;
        this.Axu = bVarArr;
        this.Axv = bVarArr2;
    }
}
