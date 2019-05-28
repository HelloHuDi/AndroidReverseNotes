package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.v;
import java.util.ArrayList;
import java.util.List;

final class f implements a {
    private android.support.v4.f.k.a<b> aeW;
    final ArrayList<b> aeX;
    final ArrayList<b> aeY;
    final a aeZ;
    Runnable afa;
    final boolean afb;
    final al afc;
    int afd;

    interface a {
        void O(int i, int i2);

        void P(int i, int i2);

        void Q(int i, int i2);

        void R(int i, int i2);

        void b(int i, int i2, Object obj);

        v bC(int i);

        void d(b bVar);

        void e(b bVar);
    }

    static class b {
        int Cn;
        int afe;
        Object aff;
        int afg;

        b(int i, int i2, int i3, Object obj) {
            this.Cn = i;
            this.afe = i2;
            this.afg = i3;
            this.aff = obj;
        }

        public final String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.Cn) {
                case 1:
                    str = "add";
                    break;
                case 2:
                    str = "rm";
                    break;
                case 4:
                    str = "up";
                    break;
                case 8:
                    str = "mv";
                    break;
                default:
                    str = "??";
                    break;
            }
            return append.append(str).append(",s:").append(this.afe).append("c:").append(this.afg).append(",p:").append(this.aff).append("]").toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.Cn != bVar.Cn) {
                return false;
            }
            if (this.Cn == 8 && Math.abs(this.afg - this.afe) == 1 && this.afg == bVar.afe && this.afe == bVar.afg) {
                return true;
            }
            if (this.afg != bVar.afg) {
                return false;
            }
            if (this.afe != bVar.afe) {
                return false;
            }
            if (this.aff != null) {
                if (this.aff.equals(bVar.aff)) {
                    return true;
                }
                return false;
            } else if (bVar.aff != null) {
                return false;
            } else {
                return true;
            }
        }

        public final int hashCode() {
            return (((this.Cn * 31) + this.afe) * 31) + this.afg;
        }
    }

    f(a aVar) {
        this(aVar, (byte) 0);
    }

    private f(a aVar, byte b) {
        this.aeW = new android.support.v4.f.k.b(30);
        this.aeX = new ArrayList();
        this.aeY = new ArrayList();
        this.afd = 0;
        this.aeZ = aVar;
        this.afb = false;
        this.afc = new al(this);
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        n(this.aeX);
        n(this.aeY);
        this.afd = 0;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x020e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void hu() {
        al alVar = this.afc;
        ArrayList arrayList = this.aeX;
        while (true) {
            int i;
            Object obj = null;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                Object obj2;
                if (((b) arrayList.get(size)).Cn != 8) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size;
                    int i2;
                    b bVar;
                    Object obj3;
                    int i3;
                    if (i == -1) {
                        i2 = i + 1;
                        bVar = (b) arrayList.get(i);
                        b bVar2 = (b) arrayList.get(i2);
                        Object obj4;
                        switch (bVar2.Cn) {
                            case 1:
                                size = 0;
                                if (bVar.afg < bVar2.afe) {
                                    size = -1;
                                }
                                if (bVar.afe < bVar2.afe) {
                                    size++;
                                }
                                if (bVar2.afe <= bVar.afe) {
                                    bVar.afe += bVar2.afg;
                                }
                                if (bVar2.afe <= bVar.afg) {
                                    bVar.afg += bVar2.afg;
                                }
                                bVar2.afe = size + bVar2.afe;
                                arrayList.set(i, bVar2);
                                arrayList.set(i2, bVar);
                                break;
                            case 2:
                                b bVar3 = null;
                                obj4 = null;
                                if (bVar.afe < bVar.afg) {
                                    obj3 = null;
                                    if (bVar2.afe == bVar.afe && bVar2.afg == bVar.afg - bVar.afe) {
                                        obj4 = 1;
                                    }
                                } else {
                                    obj3 = 1;
                                    if (bVar2.afe == bVar.afg + 1 && bVar2.afg == bVar.afe - bVar.afg) {
                                        obj4 = 1;
                                    }
                                }
                                if (bVar.afg >= bVar2.afe) {
                                    if (bVar.afg < bVar2.afe + bVar2.afg) {
                                        bVar2.afg--;
                                        bVar.Cn = 2;
                                        bVar.afg = 1;
                                        if (bVar2.afg != 0) {
                                            break;
                                        }
                                        arrayList.remove(i2);
                                        alVar.amO.c(bVar2);
                                        break;
                                    }
                                }
                                bVar2.afe--;
                                if (bVar.afe <= bVar2.afe) {
                                    bVar2.afe++;
                                } else if (bVar.afe < bVar2.afe + bVar2.afg) {
                                    bVar3 = alVar.amO.a(2, bVar.afe + 1, (bVar2.afe + bVar2.afg) - bVar.afe, null);
                                    bVar2.afg = bVar.afe - bVar2.afe;
                                }
                                if (obj4 == null) {
                                    if (obj3 != null) {
                                        if (bVar3 != null) {
                                            if (bVar.afe > bVar3.afe) {
                                                bVar.afe -= bVar3.afg;
                                            }
                                            if (bVar.afg > bVar3.afe) {
                                                bVar.afg -= bVar3.afg;
                                            }
                                        }
                                        if (bVar.afe > bVar2.afe) {
                                            bVar.afe -= bVar2.afg;
                                        }
                                        if (bVar.afg > bVar2.afe) {
                                            bVar.afg -= bVar2.afg;
                                        }
                                    } else {
                                        if (bVar3 != null) {
                                            if (bVar.afe >= bVar3.afe) {
                                                bVar.afe -= bVar3.afg;
                                            }
                                            if (bVar.afg >= bVar3.afe) {
                                                bVar.afg -= bVar3.afg;
                                            }
                                        }
                                        if (bVar.afe >= bVar2.afe) {
                                            bVar.afe -= bVar2.afg;
                                        }
                                        if (bVar.afg >= bVar2.afe) {
                                            bVar.afg -= bVar2.afg;
                                        }
                                    }
                                    arrayList.set(i, bVar2);
                                    if (bVar.afe != bVar.afg) {
                                        arrayList.set(i2, bVar);
                                    } else {
                                        arrayList.remove(i2);
                                    }
                                    if (bVar3 == null) {
                                        break;
                                    }
                                    arrayList.add(i, bVar3);
                                    break;
                                }
                                arrayList.set(i, bVar2);
                                arrayList.remove(i2);
                                alVar.amO.c(bVar);
                                break;
                            case 4:
                                obj3 = null;
                                obj4 = null;
                                if (bVar.afg < bVar2.afe) {
                                    bVar2.afe--;
                                } else if (bVar.afg < bVar2.afe + bVar2.afg) {
                                    bVar2.afg--;
                                    obj3 = alVar.amO.a(4, bVar.afe, 1, bVar2.aff);
                                }
                                if (bVar.afe <= bVar2.afe) {
                                    bVar2.afe++;
                                } else if (bVar.afe < bVar2.afe + bVar2.afg) {
                                    i3 = (bVar2.afe + bVar2.afg) - bVar.afe;
                                    obj4 = alVar.amO.a(4, bVar.afe + 1, i3, bVar2.aff);
                                    bVar2.afg -= i3;
                                }
                                arrayList.set(i2, bVar);
                                if (bVar2.afg > 0) {
                                    arrayList.set(i, bVar2);
                                } else {
                                    arrayList.remove(i);
                                    alVar.amO.c(bVar2);
                                }
                                if (obj3 != null) {
                                    arrayList.add(i, obj3);
                                }
                                if (obj4 == null) {
                                    break;
                                }
                                arrayList.add(i, obj4);
                                break;
                            default:
                                break;
                        }
                    }
                    i2 = this.aeX.size();
                    for (i = 0; i < i2; i++) {
                        bVar = (b) this.aeX.get(i);
                        int i4;
                        int i5;
                        int i6;
                        switch (bVar.Cn) {
                            case 1:
                                b(bVar);
                                break;
                            case 2:
                                int i7 = bVar.afe;
                                size = bVar.afg + bVar.afe;
                                i4 = -1;
                                i5 = bVar.afe;
                                int i8 = 0;
                                while (i5 < size) {
                                    obj = null;
                                    if (this.aeZ.bC(i5) != null || by(i5)) {
                                        if (i4 == 0) {
                                            a(a(2, i7, i8, null));
                                            obj = 1;
                                        }
                                        i4 = 1;
                                    } else {
                                        if (i4 == 1) {
                                            b(a(2, i7, i8, null));
                                            obj = 1;
                                        }
                                        i4 = 0;
                                    }
                                    if (obj != null) {
                                        i5 -= i8;
                                        i6 = size - i8;
                                        i3 = 1;
                                    } else {
                                        i3 = i8 + 1;
                                        i6 = size;
                                    }
                                    i5++;
                                    size = i6;
                                    i8 = i3;
                                }
                                if (i8 != bVar.afg) {
                                    c(bVar);
                                    bVar = a(2, i7, i8, null);
                                }
                                if (i4 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                i6 = bVar.afe;
                                i5 = 0;
                                i4 = bVar.afe + bVar.afg;
                                i3 = -1;
                                size = bVar.afe;
                                while (size < i4) {
                                    if (this.aeZ.bC(size) != null || by(size)) {
                                        if (i3 == 0) {
                                            a(a(4, i6, i5, bVar.aff));
                                            i5 = 0;
                                            i6 = size;
                                        }
                                        i3 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(4, i6, i5, bVar.aff));
                                            i5 = 0;
                                            i6 = size;
                                        }
                                        i3 = 0;
                                    }
                                    i5++;
                                    size++;
                                }
                                if (i5 != bVar.afg) {
                                    obj3 = bVar.aff;
                                    c(bVar);
                                    bVar = a(4, i6, i5, obj3);
                                }
                                if (i3 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                b(bVar);
                                break;
                        }
                        if (this.afa != null) {
                            this.afa.run();
                        }
                    }
                    this.aeX.clear();
                    return;
                } else {
                    obj2 = obj;
                }
                size--;
                obj = obj2;
            }
            i = -1;
            if (i == -1) {
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void hv() {
        int size = this.aeY.size();
        for (int i = 0; i < size; i++) {
            this.aeZ.e((b) this.aeY.get(i));
        }
        n(this.aeY);
        this.afd = 0;
    }

    private void a(b bVar) {
        if (bVar.Cn == 1 || bVar.Cn == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int M = M(bVar.afe, bVar.Cn);
        int i2 = bVar.afe;
        switch (bVar.Cn) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(bVar)));
        }
        int i3 = 1;
        for (int i4 = 1; i4 < bVar.afg; i4++) {
            Object obj;
            int M2 = M(bVar.afe + (i * i4), bVar.Cn);
            int obj2;
            switch (bVar.Cn) {
                case 2:
                    if (M2 != M) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                case 4:
                    if (M2 != M + 1) {
                        obj2 = null;
                        break;
                    } else {
                        obj2 = 1;
                        break;
                    }
                default:
                    obj2 = null;
                    break;
            }
            if (obj2 != null) {
                i3++;
            } else {
                b a = a(bVar.Cn, M, i3, bVar.aff);
                a(a, i2);
                c(a);
                if (bVar.Cn == 4) {
                    i2 += i3;
                }
                i3 = 1;
                M = M2;
            }
        }
        Object obj3 = bVar.aff;
        c(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.Cn, M, i3, obj3);
            a(a2, i2);
            c(a2);
        }
    }

    private void a(b bVar, int i) {
        this.aeZ.d(bVar);
        switch (bVar.Cn) {
            case 2:
                this.aeZ.O(i, bVar.afg);
                return;
            case 4:
                this.aeZ.b(i, bVar.afg, bVar.aff);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int M(int i, int i2) {
        b bVar;
        int i3;
        int size = this.aeY.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            bVar = (b) this.aeY.get(size);
            if (bVar.Cn == 8) {
                int i6;
                if (bVar.afe < bVar.afg) {
                    i6 = bVar.afe;
                    i3 = bVar.afg;
                } else {
                    i6 = bVar.afg;
                    i3 = bVar.afe;
                }
                if (i4 < i6 || i4 > i3) {
                    if (i4 < bVar.afe) {
                        if (i2 == 1) {
                            bVar.afe++;
                            bVar.afg++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.afe--;
                            bVar.afg--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.afe) {
                    if (i2 == 1) {
                        bVar.afg++;
                    } else if (i2 == 2) {
                        bVar.afg--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.afe++;
                    } else if (i2 == 2) {
                        bVar.afe--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.afe <= i4) {
                    if (bVar.Cn == 1) {
                        i5 = i4 - bVar.afg;
                    } else if (bVar.Cn == 2) {
                        i5 = bVar.afg + i4;
                    }
                } else if (i2 == 1) {
                    bVar.afe++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.afe--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.aeY.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.aeY.get(i3);
            if (bVar.Cn == 8) {
                if (bVar.afg == bVar.afe || bVar.afg < 0) {
                    this.aeY.remove(i3);
                    c(bVar);
                }
            } else if (bVar.afg <= 0) {
                this.aeY.remove(i3);
                c(bVar);
            }
        }
        return i4;
    }

    private boolean by(int i) {
        int size = this.aeY.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.aeY.get(i2);
            if (bVar.Cn == 8) {
                if (N(bVar.afg, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.Cn == 1) {
                int i3 = bVar.afe + bVar.afg;
                for (int i4 = bVar.afe; i4 < i3; i4++) {
                    if (N(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.aeY.add(bVar);
        switch (bVar.Cn) {
            case 1:
                this.aeZ.Q(bVar.afe, bVar.afg);
                return;
            case 2:
                this.aeZ.P(bVar.afe, bVar.afg);
                return;
            case 4:
                this.aeZ.b(bVar.afe, bVar.afg, bVar.aff);
                return;
            case 8:
                this.aeZ.R(bVar.afe, bVar.afg);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(bVar)));
        }
    }

    /* Access modifiers changed, original: final */
    public final boolean hw() {
        return this.aeX.size() > 0;
    }

    /* Access modifiers changed, original: final */
    public final boolean bz(int i) {
        return (this.afd & i) != 0;
    }

    /* Access modifiers changed, original: final */
    public final int bA(int i) {
        return N(i, 0);
    }

    /* Access modifiers changed, original: final */
    public final int N(int i, int i2) {
        int size = this.aeY.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = (b) this.aeY.get(i2);
            if (bVar.Cn == 8) {
                if (bVar.afe == i3) {
                    i3 = bVar.afg;
                } else {
                    if (bVar.afe < i3) {
                        i3--;
                    }
                    if (bVar.afg <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.afe > i3) {
                continue;
            } else if (bVar.Cn == 2) {
                if (i3 < bVar.afe + bVar.afg) {
                    return -1;
                }
                i3 -= bVar.afg;
            } else if (bVar.Cn == 1) {
                i3 += bVar.afg;
            }
            i2++;
        }
        return i3;
    }

    /* Access modifiers changed, original: final */
    public final void hx() {
        hv();
        int size = this.aeX.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.aeX.get(i);
            switch (bVar.Cn) {
                case 1:
                    this.aeZ.e(bVar);
                    this.aeZ.Q(bVar.afe, bVar.afg);
                    break;
                case 2:
                    this.aeZ.e(bVar);
                    this.aeZ.O(bVar.afe, bVar.afg);
                    break;
                case 4:
                    this.aeZ.e(bVar);
                    this.aeZ.b(bVar.afe, bVar.afg, bVar.aff);
                    break;
                case 8:
                    this.aeZ.e(bVar);
                    this.aeZ.R(bVar.afe, bVar.afg);
                    break;
            }
            if (this.afa != null) {
                this.afa.run();
            }
        }
        n(this.aeX);
        this.afd = 0;
    }

    public final int bB(int i) {
        int size = this.aeX.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) this.aeX.get(i3);
            switch (bVar.Cn) {
                case 1:
                    if (bVar.afe > i2) {
                        break;
                    }
                    i2 += bVar.afg;
                    break;
                case 2:
                    if (bVar.afe <= i2) {
                        if (bVar.afe + bVar.afg <= i2) {
                            i2 -= bVar.afg;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (bVar.afe != i2) {
                        if (bVar.afe < i2) {
                            i2--;
                        }
                        if (bVar.afg > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = bVar.afg;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    public final boolean hy() {
        return (this.aeY.isEmpty() || this.aeX.isEmpty()) ? false : true;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.aeW.aA();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.Cn = i;
        bVar.afe = i2;
        bVar.afg = i3;
        bVar.aff = obj;
        return bVar;
    }

    public final void c(b bVar) {
        if (!this.afb) {
            bVar.aff = null;
            this.aeW.release(bVar);
        }
    }

    private void n(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c((b) list.get(i));
        }
        list.clear();
    }
}
