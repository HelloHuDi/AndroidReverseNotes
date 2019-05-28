package android.support.p069v7.widget;

import android.support.p057v4.p065f.C37122k.C16505b;
import android.support.p057v4.p065f.C37122k.C8387a;
import android.support.p069v7.widget.C17486al.C0689a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v7.widget.f */
final class C41540f implements C0689a {
    private C8387a<C41539b> aeW;
    final ArrayList<C41539b> aeX;
    final ArrayList<C41539b> aeY;
    final C37146a aeZ;
    Runnable afa;
    final boolean afb;
    final C17486al afc;
    int afd;

    /* renamed from: android.support.v7.widget.f$a */
    interface C37146a {
        /* renamed from: O */
        void mo59222O(int i, int i2);

        /* renamed from: P */
        void mo59223P(int i, int i2);

        /* renamed from: Q */
        void mo59224Q(int i, int i2);

        /* renamed from: R */
        void mo59225R(int i, int i2);

        /* renamed from: b */
        void mo59226b(int i, int i2, Object obj);

        /* renamed from: bC */
        C41531v mo59227bC(int i);

        /* renamed from: d */
        void mo59228d(C41539b c41539b);

        /* renamed from: e */
        void mo59229e(C41539b c41539b);
    }

    /* renamed from: android.support.v7.widget.f$b */
    static class C41539b {
        /* renamed from: Cn */
        int f16871Cn;
        int afe;
        Object aff;
        int afg;

        C41539b(int i, int i2, int i3, Object obj) {
            this.f16871Cn = i;
            this.afe = i2;
            this.afg = i3;
            this.aff = obj;
        }

        public final String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.f16871Cn) {
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
            C41539b c41539b = (C41539b) obj;
            if (this.f16871Cn != c41539b.f16871Cn) {
                return false;
            }
            if (this.f16871Cn == 8 && Math.abs(this.afg - this.afe) == 1 && this.afg == c41539b.afe && this.afe == c41539b.afg) {
                return true;
            }
            if (this.afg != c41539b.afg) {
                return false;
            }
            if (this.afe != c41539b.afe) {
                return false;
            }
            if (this.aff != null) {
                if (this.aff.equals(c41539b.aff)) {
                    return true;
                }
                return false;
            } else if (c41539b.aff != null) {
                return false;
            } else {
                return true;
            }
        }

        public final int hashCode() {
            return (((this.f16871Cn * 31) + this.afe) * 31) + this.afg;
        }
    }

    C41540f(C37146a c37146a) {
        this(c37146a, (byte) 0);
    }

    private C41540f(C37146a c37146a, byte b) {
        this.aeW = new C16505b(30);
        this.aeX = new ArrayList();
        this.aeY = new ArrayList();
        this.afd = 0;
        this.aeZ = c37146a;
        this.afb = false;
        this.afc = new C17486al(this);
    }

    /* Access modifiers changed, original: final */
    public final void reset() {
        m72711n(this.aeX);
        m72711n(this.aeY);
        this.afd = 0;
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x020e A:{SYNTHETIC} */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: hu */
    public final void mo66567hu() {
        C17486al c17486al = this.afc;
        ArrayList arrayList = this.aeX;
        while (true) {
            int i;
            Object obj = null;
            int size = arrayList.size() - 1;
            while (size >= 0) {
                Object obj2;
                if (((C41539b) arrayList.get(size)).f16871Cn != 8) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size;
                    int i2;
                    C41539b c41539b;
                    Object obj3;
                    int i3;
                    if (i == -1) {
                        i2 = i + 1;
                        c41539b = (C41539b) arrayList.get(i);
                        C41539b c41539b2 = (C41539b) arrayList.get(i2);
                        Object obj4;
                        switch (c41539b2.f16871Cn) {
                            case 1:
                                size = 0;
                                if (c41539b.afg < c41539b2.afe) {
                                    size = -1;
                                }
                                if (c41539b.afe < c41539b2.afe) {
                                    size++;
                                }
                                if (c41539b2.afe <= c41539b.afe) {
                                    c41539b.afe += c41539b2.afg;
                                }
                                if (c41539b2.afe <= c41539b.afg) {
                                    c41539b.afg += c41539b2.afg;
                                }
                                c41539b2.afe = size + c41539b2.afe;
                                arrayList.set(i, c41539b2);
                                arrayList.set(i2, c41539b);
                                break;
                            case 2:
                                C41539b c41539b3 = null;
                                obj4 = null;
                                if (c41539b.afe < c41539b.afg) {
                                    obj3 = null;
                                    if (c41539b2.afe == c41539b.afe && c41539b2.afg == c41539b.afg - c41539b.afe) {
                                        obj4 = 1;
                                    }
                                } else {
                                    obj3 = 1;
                                    if (c41539b2.afe == c41539b.afg + 1 && c41539b2.afg == c41539b.afe - c41539b.afg) {
                                        obj4 = 1;
                                    }
                                }
                                if (c41539b.afg >= c41539b2.afe) {
                                    if (c41539b.afg < c41539b2.afe + c41539b2.afg) {
                                        c41539b2.afg--;
                                        c41539b.f16871Cn = 2;
                                        c41539b.afg = 1;
                                        if (c41539b2.afg != 0) {
                                            break;
                                        }
                                        arrayList.remove(i2);
                                        c17486al.amO.mo1958c(c41539b2);
                                        break;
                                    }
                                }
                                c41539b2.afe--;
                                if (c41539b.afe <= c41539b2.afe) {
                                    c41539b2.afe++;
                                } else if (c41539b.afe < c41539b2.afe + c41539b2.afg) {
                                    c41539b3 = c17486al.amO.mo1957a(2, c41539b.afe + 1, (c41539b2.afe + c41539b2.afg) - c41539b.afe, null);
                                    c41539b2.afg = c41539b.afe - c41539b2.afe;
                                }
                                if (obj4 == null) {
                                    if (obj3 != null) {
                                        if (c41539b3 != null) {
                                            if (c41539b.afe > c41539b3.afe) {
                                                c41539b.afe -= c41539b3.afg;
                                            }
                                            if (c41539b.afg > c41539b3.afe) {
                                                c41539b.afg -= c41539b3.afg;
                                            }
                                        }
                                        if (c41539b.afe > c41539b2.afe) {
                                            c41539b.afe -= c41539b2.afg;
                                        }
                                        if (c41539b.afg > c41539b2.afe) {
                                            c41539b.afg -= c41539b2.afg;
                                        }
                                    } else {
                                        if (c41539b3 != null) {
                                            if (c41539b.afe >= c41539b3.afe) {
                                                c41539b.afe -= c41539b3.afg;
                                            }
                                            if (c41539b.afg >= c41539b3.afe) {
                                                c41539b.afg -= c41539b3.afg;
                                            }
                                        }
                                        if (c41539b.afe >= c41539b2.afe) {
                                            c41539b.afe -= c41539b2.afg;
                                        }
                                        if (c41539b.afg >= c41539b2.afe) {
                                            c41539b.afg -= c41539b2.afg;
                                        }
                                    }
                                    arrayList.set(i, c41539b2);
                                    if (c41539b.afe != c41539b.afg) {
                                        arrayList.set(i2, c41539b);
                                    } else {
                                        arrayList.remove(i2);
                                    }
                                    if (c41539b3 == null) {
                                        break;
                                    }
                                    arrayList.add(i, c41539b3);
                                    break;
                                }
                                arrayList.set(i, c41539b2);
                                arrayList.remove(i2);
                                c17486al.amO.mo1958c(c41539b);
                                break;
                            case 4:
                                obj3 = null;
                                obj4 = null;
                                if (c41539b.afg < c41539b2.afe) {
                                    c41539b2.afe--;
                                } else if (c41539b.afg < c41539b2.afe + c41539b2.afg) {
                                    c41539b2.afg--;
                                    obj3 = c17486al.amO.mo1957a(4, c41539b.afe, 1, c41539b2.aff);
                                }
                                if (c41539b.afe <= c41539b2.afe) {
                                    c41539b2.afe++;
                                } else if (c41539b.afe < c41539b2.afe + c41539b2.afg) {
                                    i3 = (c41539b2.afe + c41539b2.afg) - c41539b.afe;
                                    obj4 = c17486al.amO.mo1957a(4, c41539b.afe + 1, i3, c41539b2.aff);
                                    c41539b2.afg -= i3;
                                }
                                arrayList.set(i2, c41539b);
                                if (c41539b2.afg > 0) {
                                    arrayList.set(i, c41539b2);
                                } else {
                                    arrayList.remove(i);
                                    c17486al.amO.mo1958c(c41539b2);
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
                        c41539b = (C41539b) this.aeX.get(i);
                        int i4;
                        int i5;
                        int i6;
                        switch (c41539b.f16871Cn) {
                            case 1:
                                m72709b(c41539b);
                                break;
                            case 2:
                                int i7 = c41539b.afe;
                                size = c41539b.afg + c41539b.afe;
                                i4 = -1;
                                i5 = c41539b.afe;
                                int i8 = 0;
                                while (i5 < size) {
                                    obj = null;
                                    if (this.aeZ.mo59227bC(i5) != null || m72710by(i5)) {
                                        if (i4 == 0) {
                                            m72707a(mo1957a(2, i7, i8, null));
                                            obj = 1;
                                        }
                                        i4 = 1;
                                    } else {
                                        if (i4 == 1) {
                                            m72709b(mo1957a(2, i7, i8, null));
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
                                if (i8 != c41539b.afg) {
                                    mo1958c(c41539b);
                                    c41539b = mo1957a(2, i7, i8, null);
                                }
                                if (i4 != 0) {
                                    m72709b(c41539b);
                                    break;
                                } else {
                                    m72707a(c41539b);
                                    break;
                                }
                                break;
                            case 4:
                                i6 = c41539b.afe;
                                i5 = 0;
                                i4 = c41539b.afe + c41539b.afg;
                                i3 = -1;
                                size = c41539b.afe;
                                while (size < i4) {
                                    if (this.aeZ.mo59227bC(size) != null || m72710by(size)) {
                                        if (i3 == 0) {
                                            m72707a(mo1957a(4, i6, i5, c41539b.aff));
                                            i5 = 0;
                                            i6 = size;
                                        }
                                        i3 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            m72709b(mo1957a(4, i6, i5, c41539b.aff));
                                            i5 = 0;
                                            i6 = size;
                                        }
                                        i3 = 0;
                                    }
                                    i5++;
                                    size++;
                                }
                                if (i5 != c41539b.afg) {
                                    obj3 = c41539b.aff;
                                    mo1958c(c41539b);
                                    c41539b = mo1957a(4, i6, i5, obj3);
                                }
                                if (i3 != 0) {
                                    m72709b(c41539b);
                                    break;
                                } else {
                                    m72707a(c41539b);
                                    break;
                                }
                                break;
                            case 8:
                                m72709b(c41539b);
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
    /* renamed from: hv */
    public final void mo66568hv() {
        int size = this.aeY.size();
        for (int i = 0; i < size; i++) {
            this.aeZ.mo59229e((C41539b) this.aeY.get(i));
        }
        m72711n(this.aeY);
        this.afd = 0;
    }

    /* renamed from: a */
    private void m72707a(C41539b c41539b) {
        if (c41539b.f16871Cn == 1 || c41539b.f16871Cn == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int M = m72706M(c41539b.afe, c41539b.f16871Cn);
        int i2 = c41539b.afe;
        switch (c41539b.f16871Cn) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update.".concat(String.valueOf(c41539b)));
        }
        int i3 = 1;
        for (int i4 = 1; i4 < c41539b.afg; i4++) {
            Object obj;
            int M2 = m72706M(c41539b.afe + (i * i4), c41539b.f16871Cn);
            int obj2;
            switch (c41539b.f16871Cn) {
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
                C41539b a = mo1957a(c41539b.f16871Cn, M, i3, c41539b.aff);
                m72708a(a, i2);
                mo1958c(a);
                if (c41539b.f16871Cn == 4) {
                    i2 += i3;
                }
                i3 = 1;
                M = M2;
            }
        }
        Object obj3 = c41539b.aff;
        mo1958c(c41539b);
        if (i3 > 0) {
            C41539b a2 = mo1957a(c41539b.f16871Cn, M, i3, obj3);
            m72708a(a2, i2);
            mo1958c(a2);
        }
    }

    /* renamed from: a */
    private void m72708a(C41539b c41539b, int i) {
        this.aeZ.mo59228d(c41539b);
        switch (c41539b.f16871Cn) {
            case 2:
                this.aeZ.mo59222O(i, c41539b.afg);
                return;
            case 4:
                this.aeZ.mo59226b(i, c41539b.afg, c41539b.aff);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* renamed from: M */
    private int m72706M(int i, int i2) {
        C41539b c41539b;
        int i3;
        int size = this.aeY.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            c41539b = (C41539b) this.aeY.get(size);
            if (c41539b.f16871Cn == 8) {
                int i6;
                if (c41539b.afe < c41539b.afg) {
                    i6 = c41539b.afe;
                    i3 = c41539b.afg;
                } else {
                    i6 = c41539b.afg;
                    i3 = c41539b.afe;
                }
                if (i4 < i6 || i4 > i3) {
                    if (i4 < c41539b.afe) {
                        if (i2 == 1) {
                            c41539b.afe++;
                            c41539b.afg++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            c41539b.afe--;
                            c41539b.afg--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == c41539b.afe) {
                    if (i2 == 1) {
                        c41539b.afg++;
                    } else if (i2 == 2) {
                        c41539b.afg--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        c41539b.afe++;
                    } else if (i2 == 2) {
                        c41539b.afe--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (c41539b.afe <= i4) {
                    if (c41539b.f16871Cn == 1) {
                        i5 = i4 - c41539b.afg;
                    } else if (c41539b.f16871Cn == 2) {
                        i5 = c41539b.afg + i4;
                    }
                } else if (i2 == 1) {
                    c41539b.afe++;
                    i5 = i4;
                } else if (i2 == 2) {
                    c41539b.afe--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.aeY.size() - 1; i3 >= 0; i3--) {
            c41539b = (C41539b) this.aeY.get(i3);
            if (c41539b.f16871Cn == 8) {
                if (c41539b.afg == c41539b.afe || c41539b.afg < 0) {
                    this.aeY.remove(i3);
                    mo1958c(c41539b);
                }
            } else if (c41539b.afg <= 0) {
                this.aeY.remove(i3);
                mo1958c(c41539b);
            }
        }
        return i4;
    }

    /* renamed from: by */
    private boolean m72710by(int i) {
        int size = this.aeY.size();
        for (int i2 = 0; i2 < size; i2++) {
            C41539b c41539b = (C41539b) this.aeY.get(i2);
            if (c41539b.f16871Cn == 8) {
                if (mo66563N(c41539b.afg, i2 + 1) == i) {
                    return true;
                }
            } else if (c41539b.f16871Cn == 1) {
                int i3 = c41539b.afe + c41539b.afg;
                for (int i4 = c41539b.afe; i4 < i3; i4++) {
                    if (mo66563N(i4, i2 + 1) == i) {
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

    /* renamed from: b */
    private void m72709b(C41539b c41539b) {
        this.aeY.add(c41539b);
        switch (c41539b.f16871Cn) {
            case 1:
                this.aeZ.mo59224Q(c41539b.afe, c41539b.afg);
                return;
            case 2:
                this.aeZ.mo59223P(c41539b.afe, c41539b.afg);
                return;
            case 4:
                this.aeZ.mo59226b(c41539b.afe, c41539b.afg, c41539b.aff);
                return;
            case 8:
                this.aeZ.mo59225R(c41539b.afe, c41539b.afg);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for ".concat(String.valueOf(c41539b)));
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hw */
    public final boolean mo66569hw() {
        return this.aeX.size() > 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bz */
    public final boolean mo66566bz(int i) {
        return (this.afd & i) != 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: bA */
    public final int mo66564bA(int i) {
        return mo66563N(i, 0);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: N */
    public final int mo66563N(int i, int i2) {
        int size = this.aeY.size();
        int i3 = i;
        while (i2 < size) {
            C41539b c41539b = (C41539b) this.aeY.get(i2);
            if (c41539b.f16871Cn == 8) {
                if (c41539b.afe == i3) {
                    i3 = c41539b.afg;
                } else {
                    if (c41539b.afe < i3) {
                        i3--;
                    }
                    if (c41539b.afg <= i3) {
                        i3++;
                    }
                }
            } else if (c41539b.afe > i3) {
                continue;
            } else if (c41539b.f16871Cn == 2) {
                if (i3 < c41539b.afe + c41539b.afg) {
                    return -1;
                }
                i3 -= c41539b.afg;
            } else if (c41539b.f16871Cn == 1) {
                i3 += c41539b.afg;
            }
            i2++;
        }
        return i3;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hx */
    public final void mo66570hx() {
        mo66568hv();
        int size = this.aeX.size();
        for (int i = 0; i < size; i++) {
            C41539b c41539b = (C41539b) this.aeX.get(i);
            switch (c41539b.f16871Cn) {
                case 1:
                    this.aeZ.mo59229e(c41539b);
                    this.aeZ.mo59224Q(c41539b.afe, c41539b.afg);
                    break;
                case 2:
                    this.aeZ.mo59229e(c41539b);
                    this.aeZ.mo59222O(c41539b.afe, c41539b.afg);
                    break;
                case 4:
                    this.aeZ.mo59229e(c41539b);
                    this.aeZ.mo59226b(c41539b.afe, c41539b.afg, c41539b.aff);
                    break;
                case 8:
                    this.aeZ.mo59229e(c41539b);
                    this.aeZ.mo59225R(c41539b.afe, c41539b.afg);
                    break;
            }
            if (this.afa != null) {
                this.afa.run();
            }
        }
        m72711n(this.aeX);
        this.afd = 0;
    }

    /* renamed from: bB */
    public final int mo66565bB(int i) {
        int size = this.aeX.size();
        int i2 = i;
        for (int i3 = 0; i3 < size; i3++) {
            C41539b c41539b = (C41539b) this.aeX.get(i3);
            switch (c41539b.f16871Cn) {
                case 1:
                    if (c41539b.afe > i2) {
                        break;
                    }
                    i2 += c41539b.afg;
                    break;
                case 2:
                    if (c41539b.afe <= i2) {
                        if (c41539b.afe + c41539b.afg <= i2) {
                            i2 -= c41539b.afg;
                            break;
                        }
                        return -1;
                    }
                    continue;
                case 8:
                    if (c41539b.afe != i2) {
                        if (c41539b.afe < i2) {
                            i2--;
                        }
                        if (c41539b.afg > i2) {
                            break;
                        }
                        i2++;
                        break;
                    }
                    i2 = c41539b.afg;
                    break;
                default:
                    break;
            }
        }
        return i2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: hy */
    public final boolean mo66571hy() {
        return (this.aeY.isEmpty() || this.aeX.isEmpty()) ? false : true;
    }

    /* renamed from: a */
    public final C41539b mo1957a(int i, int i2, int i3, Object obj) {
        C41539b c41539b = (C41539b) this.aeW.mo6364aA();
        if (c41539b == null) {
            return new C41539b(i, i2, i3, obj);
        }
        c41539b.f16871Cn = i;
        c41539b.afe = i2;
        c41539b.afg = i3;
        c41539b.aff = obj;
        return c41539b;
    }

    /* renamed from: c */
    public final void mo1958c(C41539b c41539b) {
        if (!this.afb) {
            c41539b.aff = null;
            this.aeW.release(c41539b);
        }
    }

    /* renamed from: n */
    private void m72711n(List<C41539b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo1958c((C41539b) list.get(i));
        }
        list.clear();
    }
}
