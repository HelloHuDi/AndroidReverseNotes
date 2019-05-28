package android.support.p069v7.p075h;

import android.support.p069v7.widget.RecyclerView.C41523a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* renamed from: android.support.v7.h.c */
public final class C0595c {
    /* renamed from: Yw */
    private static final Comparator<C0600e> f921Yw = new C05961();

    /* renamed from: android.support.v7.h.c$1 */
    static class C05961 implements Comparator<C0600e> {
        C05961() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            C0600e c0600e = (C0600e) obj;
            C0600e c0600e2 = (C0600e) obj2;
            int i = c0600e.f931x - c0600e2.f931x;
            return i == 0 ? c0600e.f932y - c0600e2.f932y : i;
        }
    }

    /* renamed from: android.support.v7.h.c$a */
    public static abstract class C0597a {
        /* renamed from: J */
        public abstract boolean mo1474J(int i, int i2);

        /* renamed from: K */
        public abstract boolean mo1475K(int i, int i2);

        /* renamed from: fV */
        public abstract int mo1477fV();

        /* renamed from: fW */
        public abstract int mo1478fW();

        /* renamed from: L */
        public Object mo1476L(int i, int i2) {
            return null;
        }
    }

    /* renamed from: android.support.v7.h.c$c */
    static class C0598c {
        /* renamed from: YE */
        int f922YE;
        /* renamed from: YF */
        int f923YF;
        /* renamed from: YG */
        boolean f924YG;

        public C0598c(int i, int i2, boolean z) {
            this.f922YE = i;
            this.f923YF = i2;
            this.f924YG = z;
        }
    }

    /* renamed from: android.support.v7.h.c$d */
    static class C0599d {
        /* renamed from: YH */
        int f925YH;
        /* renamed from: YI */
        int f926YI;
        /* renamed from: YJ */
        int f927YJ;
        /* renamed from: YK */
        int f928YK;

        public C0599d(int i, int i2) {
            this.f925YH = 0;
            this.f926YI = i;
            this.f927YJ = 0;
            this.f928YK = i2;
        }
    }

    /* renamed from: android.support.v7.h.c$e */
    static class C0600e {
        /* renamed from: YG */
        boolean f929YG;
        /* renamed from: YL */
        boolean f930YL;
        int size;
        /* renamed from: x */
        int f931x;
        /* renamed from: y */
        int f932y;

        C0600e() {
        }
    }

    /* renamed from: android.support.v7.h.c$b */
    public static class C0601b {
        /* renamed from: YA */
        private final C0597a f933YA;
        /* renamed from: YB */
        private final int f934YB;
        /* renamed from: YC */
        private final int f935YC;
        /* renamed from: YD */
        private final boolean f936YD;
        /* renamed from: Yx */
        private final List<C0600e> f937Yx;
        /* renamed from: Yy */
        private final int[] f938Yy;
        /* renamed from: Yz */
        private final int[] f939Yz;

        C0601b(C0597a c0597a, List<C0600e> list, int[] iArr, int[] iArr2, boolean z) {
            this.f937Yx = list;
            this.f938Yy = iArr;
            this.f939Yz = iArr2;
            Arrays.fill(this.f938Yy, 0);
            Arrays.fill(this.f939Yz, 0);
            this.f933YA = c0597a;
            this.f934YB = c0597a.mo1477fV();
            this.f935YC = c0597a.mo1478fW();
            this.f936YD = z;
            C0600e c0600e = this.f937Yx.isEmpty() ? null : (C0600e) this.f937Yx.get(0);
            if (!(c0600e != null && c0600e.f931x == 0 && c0600e.f932y == 0)) {
                c0600e = new C0600e();
                c0600e.f931x = 0;
                c0600e.f932y = 0;
                c0600e.f929YG = false;
                c0600e.size = 0;
                c0600e.f930YL = false;
                this.f937Yx.add(0, c0600e);
            }
            m1300fX();
        }

        /* renamed from: fX */
        private void m1300fX() {
            int i = this.f934YB;
            int i2 = this.f935YC;
            for (int size = this.f937Yx.size() - 1; size >= 0; size--) {
                C0600e c0600e = (C0600e) this.f937Yx.get(size);
                int i3 = c0600e.f931x + c0600e.size;
                int i4 = c0600e.f932y + c0600e.size;
                if (this.f936YD) {
                    while (i > i3) {
                        if (this.f938Yy[i - 1] == 0) {
                            m1299b(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.f939Yz[i2 - 1] == 0) {
                            m1299b(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < c0600e.size; i2++) {
                    i3 = c0600e.f931x + i2;
                    i4 = c0600e.f932y + i2;
                    i = this.f933YA.mo1475K(i3, i4) ? 1 : 2;
                    this.f938Yy[i3] = (i4 << 5) | i;
                    this.f939Yz[i4] = i | (i3 << 5);
                }
                i = c0600e.f931x;
                i2 = c0600e.f932y;
            }
        }

        /* renamed from: b */
        private boolean m1299b(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6;
            int i7 = 8;
            if (z) {
                i4 = i2 - 1;
                i2--;
                i5 = i;
                i6 = i4;
            } else {
                i6 = i - 1;
                i5 = i - 1;
            }
            while (i3 >= 0) {
                C0600e c0600e = (C0600e) this.f937Yx.get(i3);
                int i8 = c0600e.f931x + c0600e.size;
                int i9 = c0600e.f932y + c0600e.size;
                if (z) {
                    for (i5--; i5 >= i8; i5--) {
                        if (this.f933YA.mo1474J(i5, i6)) {
                            i4 = this.f933YA.mo1475K(i5, i6) ? 8 : 4;
                            this.f939Yz[i6] = (i5 << 5) | 16;
                            this.f938Yy[i5] = i4 | (i6 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i5 = i2 - 1; i5 >= i9; i5--) {
                        if (this.f933YA.mo1474J(i6, i5)) {
                            if (!this.f933YA.mo1475K(i6, i5)) {
                                i7 = 4;
                            }
                            this.f938Yy[i - 1] = (i5 << 5) | 16;
                            this.f939Yz[i5] = i7 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i5 = c0600e.f931x;
                i2 = c0600e.f932y;
                i3--;
            }
            return false;
        }

        /* renamed from: a */
        public final void mo1480a(C41523a c41523a) {
            mo1479a(new C0594a(c41523a));
        }

        /* renamed from: a */
        public final void mo1479a(C44964d c44964d) {
            C44964d c44964d2;
            if (c44964d instanceof C8421b) {
                c44964d2 = (C8421b) c44964d;
            } else {
                c44964d2 = new C8421b(c44964d);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.f934YB;
            int size = this.f937Yx.size() - 1;
            int i2 = this.f935YC;
            while (size >= 0) {
                C0600e c0600e = (C0600e) this.f937Yx.get(size);
                int i3 = c0600e.size;
                int i4 = c0600e.f931x + i3;
                int i5 = c0600e.f932y + i3;
                if (i4 < i) {
                    m1298b(arrayList, c44964d2, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    m1296a(arrayList, c44964d2, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.f938Yy[c0600e.f931x + i6] & 31) == 2) {
                        c44964d2.mo1472a(c0600e.f931x + i6, 1, this.f933YA.mo1476L(c0600e.f931x + i6, c0600e.f932y + i6));
                    }
                }
                i = c0600e.f931x;
                size--;
                i2 = c0600e.f932y;
            }
            c44964d2.mo18390fU();
        }

        /* renamed from: b */
        private static C0598c m1297b(List<C0598c> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                C0598c c0598c = (C0598c) list.get(size);
                if (c0598c.f922YE == i && c0598c.f924YG == z) {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return c0598c;
                        }
                        C0598c c0598c2 = (C0598c) list.get(i2);
                        c0598c2.f923YF = (z ? 1 : -1) + c0598c2.f923YF;
                        size = i2 + 1;
                    }
                } else {
                    size--;
                }
            }
            return null;
        }

        /* renamed from: a */
        private void m1296a(List<C0598c> list, C44964d c44964d, int i, int i2, int i3) {
            if (this.f936YD) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.f939Yz[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            c44964d.mo1469G(i, 1);
                            for (C0598c c0598c : list) {
                                c0598c.f923YF++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.f939Yz[i3 + i4] >> 5;
                            c44964d.mo1471I(C0601b.m1297b(list, i6, true).f923YF, i);
                            if (i5 != 4) {
                                break;
                            }
                            c44964d.mo1472a(i, 1, this.f933YA.mo1476L(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new C0598c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            c44964d.mo1469G(i, i2);
        }

        /* renamed from: b */
        private void m1298b(List<C0598c> list, C44964d c44964d, int i, int i2, int i3) {
            if (this.f936YD) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.f938Yy[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            c44964d.mo1470H(i + i4, 1);
                            for (C0598c c0598c : list) {
                                c0598c.f923YF--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.f938Yy[i3 + i4] >> 5;
                            C0598c b = C0601b.m1297b(list, i6, false);
                            c44964d.mo1471I(i + i4, b.f923YF - 1);
                            if (i5 != 4) {
                                break;
                            }
                            c44964d.mo1472a(b.f923YF - 1, 1, this.f933YA.mo1476L(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new C0598c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            c44964d.mo1470H(i, i2);
        }
    }

    /* renamed from: a */
    public static C0601b m1288a(C0597a c0597a) {
        return C0595c.m1289a(c0597a, true);
    }

    /* renamed from: a */
    public static C0601b m1289a(C0597a c0597a, boolean z) {
        int fV = c0597a.mo1477fV();
        int fW = c0597a.mo1478fW();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new C0599d(fV, fW));
        int abs = (fV + fW) + Math.abs(fV - fW);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            C0599d c0599d = (C0599d) arrayList2.remove(arrayList2.size() - 1);
            C0600e a = C0595c.m1290a(c0597a, c0599d.f925YH, c0599d.f926YI, c0599d.f927YJ, c0599d.f928YK, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.f931x += c0599d.f925YH;
                a.f932y += c0599d.f927YJ;
                C0599d c0599d2 = arrayList3.isEmpty() ? new C0599d() : (C0599d) arrayList3.remove(arrayList3.size() - 1);
                c0599d2.f925YH = c0599d.f925YH;
                c0599d2.f927YJ = c0599d.f927YJ;
                if (a.f930YL) {
                    c0599d2.f926YI = a.f931x;
                    c0599d2.f928YK = a.f932y;
                } else if (a.f929YG) {
                    c0599d2.f926YI = a.f931x - 1;
                    c0599d2.f928YK = a.f932y;
                } else {
                    c0599d2.f926YI = a.f931x;
                    c0599d2.f928YK = a.f932y - 1;
                }
                arrayList2.add(c0599d2);
                if (!a.f930YL) {
                    c0599d.f925YH = a.f931x + a.size;
                    c0599d.f927YJ = a.f932y + a.size;
                } else if (a.f929YG) {
                    c0599d.f925YH = (a.f931x + a.size) + 1;
                    c0599d.f927YJ = a.f932y + a.size;
                } else {
                    c0599d.f925YH = a.f931x + a.size;
                    c0599d.f927YJ = (a.f932y + a.size) + 1;
                }
                arrayList2.add(c0599d);
            } else {
                arrayList3.add(c0599d);
            }
        }
        Collections.sort(arrayList, f921Yw);
        return new C0601b(c0597a, arrayList, iArr, iArr2, z);
    }

    /* renamed from: a */
    private static C0600e m1290a(C0597a c0597a, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11;
            boolean z;
            int i12;
            int i13;
            C0600e c0600e;
            int i14 = -i10;
            while (i14 <= i10) {
                if (i14 == (-i10) || (i14 != i10 && iArr[(i5 + i14) - 1] < iArr[(i5 + i14) + 1])) {
                    i11 = iArr[(i5 + i14) + 1];
                    z = false;
                } else {
                    i11 = iArr[(i5 + i14) - 1] + 1;
                    z = true;
                }
                i12 = i11 - i14;
                i13 = i11;
                while (i13 < i6 && i12 < i7 && c0597a.mo1474J(i + i13, i3 + i12)) {
                    i13++;
                    i12++;
                }
                iArr[i5 + i14] = i13;
                if (obj == null || i14 < (i8 - i10) + 1 || i14 > (i8 + i10) - 1 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i14 += 2;
                } else {
                    c0600e = new C0600e();
                    c0600e.f931x = iArr2[i5 + i14];
                    c0600e.f932y = c0600e.f931x - i14;
                    c0600e.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    c0600e.f929YG = z;
                    c0600e.f930YL = false;
                    return c0600e;
                }
            }
            i14 = -i10;
            while (i14 <= i10) {
                int i15 = i14 + i8;
                if (i15 == i10 + i8 || (i15 != (-i10) + i8 && iArr2[(i5 + i15) - 1] < iArr2[(i5 + i15) + 1])) {
                    i11 = iArr2[(i5 + i15) - 1];
                    z = false;
                } else {
                    i11 = iArr2[(i5 + i15) + 1] - 1;
                    z = true;
                }
                i12 = i11 - i15;
                i13 = i11;
                while (i13 > 0 && i12 > 0 && c0597a.mo1474J((i + i13) - 1, (i3 + i12) - 1)) {
                    i13--;
                    i12--;
                }
                iArr2[i5 + i15] = i13;
                if (obj != null || i14 + i8 < (-i10) || i14 + i8 > i10 || iArr[i5 + i15] < iArr2[i5 + i15]) {
                    i14 += 2;
                } else {
                    c0600e = new C0600e();
                    c0600e.f931x = iArr2[i5 + i15];
                    c0600e.f932y = c0600e.f931x - i15;
                    c0600e.size = iArr[i5 + i15] - iArr2[i5 + i15];
                    c0600e.f929YG = z;
                    c0600e.f930YL = true;
                    return c0600e;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
