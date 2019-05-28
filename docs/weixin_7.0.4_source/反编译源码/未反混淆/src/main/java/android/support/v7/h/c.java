package android.support.v7.h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class c {
    private static final Comparator<e> Yw = new Comparator<e>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            int i = eVar.x - eVar2.x;
            return i == 0 ? eVar.y - eVar2.y : i;
        }
    };

    public static abstract class a {
        public abstract boolean J(int i, int i2);

        public abstract boolean K(int i, int i2);

        public abstract int fV();

        public abstract int fW();

        public Object L(int i, int i2) {
            return null;
        }
    }

    static class c {
        int YE;
        int YF;
        boolean YG;

        public c(int i, int i2, boolean z) {
            this.YE = i;
            this.YF = i2;
            this.YG = z;
        }
    }

    static class d {
        int YH;
        int YI;
        int YJ;
        int YK;

        public d(int i, int i2) {
            this.YH = 0;
            this.YI = i;
            this.YJ = 0;
            this.YK = i2;
        }
    }

    static class e {
        boolean YG;
        boolean YL;
        int size;
        int x;
        int y;

        e() {
        }
    }

    public static class b {
        private final a YA;
        private final int YB;
        private final int YC;
        private final boolean YD;
        private final List<e> Yx;
        private final int[] Yy;
        private final int[] Yz;

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.Yx = list;
            this.Yy = iArr;
            this.Yz = iArr2;
            Arrays.fill(this.Yy, 0);
            Arrays.fill(this.Yz, 0);
            this.YA = aVar;
            this.YB = aVar.fV();
            this.YC = aVar.fW();
            this.YD = z;
            e eVar = this.Yx.isEmpty() ? null : (e) this.Yx.get(0);
            if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
                eVar = new e();
                eVar.x = 0;
                eVar.y = 0;
                eVar.YG = false;
                eVar.size = 0;
                eVar.YL = false;
                this.Yx.add(0, eVar);
            }
            fX();
        }

        private void fX() {
            int i = this.YB;
            int i2 = this.YC;
            for (int size = this.Yx.size() - 1; size >= 0; size--) {
                e eVar = (e) this.Yx.get(size);
                int i3 = eVar.x + eVar.size;
                int i4 = eVar.y + eVar.size;
                if (this.YD) {
                    while (i > i3) {
                        if (this.Yy[i - 1] == 0) {
                            b(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.Yz[i2 - 1] == 0) {
                            b(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < eVar.size; i2++) {
                    i3 = eVar.x + i2;
                    i4 = eVar.y + i2;
                    i = this.YA.K(i3, i4) ? 1 : 2;
                    this.Yy[i3] = (i4 << 5) | i;
                    this.Yz[i4] = i | (i3 << 5);
                }
                i = eVar.x;
                i2 = eVar.y;
            }
        }

        private boolean b(int i, int i2, int i3, boolean z) {
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
                e eVar = (e) this.Yx.get(i3);
                int i8 = eVar.x + eVar.size;
                int i9 = eVar.y + eVar.size;
                if (z) {
                    for (i5--; i5 >= i8; i5--) {
                        if (this.YA.J(i5, i6)) {
                            i4 = this.YA.K(i5, i6) ? 8 : 4;
                            this.Yz[i6] = (i5 << 5) | 16;
                            this.Yy[i5] = i4 | (i6 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i5 = i2 - 1; i5 >= i9; i5--) {
                        if (this.YA.J(i6, i5)) {
                            if (!this.YA.K(i6, i5)) {
                                i7 = 4;
                            }
                            this.Yy[i - 1] = (i5 << 5) | 16;
                            this.Yz[i5] = i7 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i5 = eVar.x;
                i2 = eVar.y;
                i3--;
            }
            return false;
        }

        public final void a(android.support.v7.widget.RecyclerView.a aVar) {
            a(new a(aVar));
        }

        public final void a(d dVar) {
            d dVar2;
            if (dVar instanceof b) {
                dVar2 = (b) dVar;
            } else {
                dVar2 = new b(dVar);
            }
            ArrayList arrayList = new ArrayList();
            int i = this.YB;
            int size = this.Yx.size() - 1;
            int i2 = this.YC;
            while (size >= 0) {
                e eVar = (e) this.Yx.get(size);
                int i3 = eVar.size;
                int i4 = eVar.x + i3;
                int i5 = eVar.y + i3;
                if (i4 < i) {
                    b(arrayList, dVar2, i4, i - i4, i4);
                }
                if (i5 < i2) {
                    a(arrayList, dVar2, i4, i2 - i5, i5);
                }
                for (int i6 = i3 - 1; i6 >= 0; i6--) {
                    if ((this.Yy[eVar.x + i6] & 31) == 2) {
                        dVar2.a(eVar.x + i6, 1, this.YA.L(eVar.x + i6, eVar.y + i6));
                    }
                }
                i = eVar.x;
                size--;
                i2 = eVar.y;
            }
            dVar2.fU();
        }

        private static c b(List<c> list, int i, boolean z) {
            int size = list.size() - 1;
            while (size >= 0) {
                c cVar = (c) list.get(size);
                if (cVar.YE == i && cVar.YG == z) {
                    list.remove(size);
                    while (true) {
                        int i2 = size;
                        if (i2 >= list.size()) {
                            return cVar;
                        }
                        c cVar2 = (c) list.get(i2);
                        cVar2.YF = (z ? 1 : -1) + cVar2.YF;
                        size = i2 + 1;
                    }
                } else {
                    size--;
                }
            }
            return null;
        }

        private void a(List<c> list, d dVar, int i, int i2, int i3) {
            if (this.YD) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.Yz[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            dVar.G(i, 1);
                            for (c cVar : list) {
                                cVar.YF++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.Yz[i3 + i4] >> 5;
                            dVar.I(b(list, i6, true).YF, i);
                            if (i5 != 4) {
                                break;
                            }
                            dVar.a(i, 1, this.YA.L(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            dVar.G(i, i2);
        }

        private void b(List<c> list, d dVar, int i, int i2, int i3) {
            if (this.YD) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.Yy[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            dVar.H(i + i4, 1);
                            for (c cVar : list) {
                                cVar.YF--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.Yy[i3 + i4] >> 5;
                            c b = b(list, i6, false);
                            dVar.I(i + i4, b.YF - 1);
                            if (i5 != 4) {
                                break;
                            }
                            dVar.a(b.YF - 1, 1, this.YA.L(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            dVar.H(i, i2);
        }
    }

    public static b a(a aVar) {
        return a(aVar, true);
    }

    public static b a(a aVar, boolean z) {
        int fV = aVar.fV();
        int fW = aVar.fW();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new d(fV, fW));
        int abs = (fV + fW) + Math.abs(fV - fW);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.YH, dVar.YI, dVar.YJ, dVar.YK, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.YH;
                a.y += dVar.YJ;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.YH = dVar.YH;
                dVar2.YJ = dVar.YJ;
                if (a.YL) {
                    dVar2.YI = a.x;
                    dVar2.YK = a.y;
                } else if (a.YG) {
                    dVar2.YI = a.x - 1;
                    dVar2.YK = a.y;
                } else {
                    dVar2.YI = a.x;
                    dVar2.YK = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.YL) {
                    dVar.YH = a.x + a.size;
                    dVar.YJ = a.y + a.size;
                } else if (a.YG) {
                    dVar.YH = (a.x + a.size) + 1;
                    dVar.YJ = a.y + a.size;
                } else {
                    dVar.YH = a.x + a.size;
                    dVar.YJ = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, Yw);
        return new b(aVar, arrayList, iArr, iArr2, z);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
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
            e eVar;
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
                while (i13 < i6 && i12 < i7 && aVar.J(i + i13, i3 + i12)) {
                    i13++;
                    i12++;
                }
                iArr[i5 + i14] = i13;
                if (obj == null || i14 < (i8 - i10) + 1 || i14 > (i8 + i10) - 1 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i14 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.YG = z;
                    eVar.YL = false;
                    return eVar;
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
                while (i13 > 0 && i12 > 0 && aVar.J((i + i13) - 1, (i3 + i12) - 1)) {
                    i13--;
                    i12--;
                }
                iArr2[i5 + i15] = i13;
                if (obj != null || i14 + i8 < (-i10) || i14 + i8 > i10 || iArr[i5 + i15] < iArr2[i5 + i15]) {
                    i14 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i15];
                    eVar.y = eVar.x - i15;
                    eVar.size = iArr[i5 + i15] - iArr2[i5 + i15];
                    eVar.YG = z;
                    eVar.YL = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
