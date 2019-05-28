package com.tencent.tinker.p668a.p669a;

import com.tencent.tinker.p668a.p669a.C41083t.C31086a.C31087a;
import com.tencent.tinker.p668a.p669a.p670b.C5910c;

/* renamed from: com.tencent.tinker.a.a.e */
public final class C5914e extends C31087a<C5914e> {
    public C5912a[] Axs;
    public C5912a[] Axt;
    public C5913b[] Axu;
    public C5913b[] Axv;

    /* renamed from: com.tencent.tinker.a.a.e$a */
    public static class C5912a implements Comparable<C5912a> {
        public int Axw;
        public int Axx;

        public final /* synthetic */ int compareTo(Object obj) {
            C5912a c5912a = (C5912a) obj;
            int hX = C5910c.m9194hX(this.Axw, c5912a.Axw);
            if (hX != 0) {
                return hX;
            }
            return C5910c.m9195hY(this.Axx, c5912a.Axx);
        }

        public C5912a(int i, int i2) {
            this.Axw = i;
            this.Axx = i2;
        }
    }

    /* renamed from: com.tencent.tinker.a.a.e$b */
    public static class C5913b implements Comparable<C5913b> {
        public int Axx;
        public int Axy;
        public int Axz;

        public final /* synthetic */ int compareTo(Object obj) {
            C5913b c5913b = (C5913b) obj;
            int hX = C5910c.m9194hX(this.Axy, c5913b.Axy);
            if (hX != 0) {
                return hX;
            }
            hX = C5910c.m9195hY(this.Axx, c5913b.Axx);
            if (hX == 0) {
                return C5910c.m9195hY(this.Axz, c5913b.Axz);
            }
            return hX;
        }

        public C5913b(int i, int i2, int i3) {
            this.Axy = i;
            this.Axx = i2;
            this.Axz = i3;
        }
    }

    public final /* synthetic */ int compareTo(Object obj) {
        C5914e c5914e = (C5914e) obj;
        int a = C5910c.m9190a(this.Axs, c5914e.Axs);
        if (a != 0) {
            return a;
        }
        a = C5910c.m9190a(this.Axt, c5914e.Axt);
        if (a != 0) {
            return a;
        }
        a = C5910c.m9190a(this.Axu, c5914e.Axu);
        if (a == 0) {
            return C5910c.m9190a(this.Axv, c5914e.Axv);
        }
        return a;
    }

    public C5914e(int i, C5912a[] c5912aArr, C5912a[] c5912aArr2, C5913b[] c5913bArr, C5913b[] c5913bArr2) {
        super(i);
        this.Axs = c5912aArr;
        this.Axt = c5912aArr2;
        this.Axu = c5913bArr;
        this.Axv = c5913bArr2;
    }
}
