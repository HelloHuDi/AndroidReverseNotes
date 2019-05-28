package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.p781a.C17368f.C17370a;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: android.support.constraint.a.a.a */
public final class C41470a {
    /* renamed from: a */
    public static void m72373a(C31242g c31242g) {
        if ((c31242g.f14370dl & 32) != 32) {
            C41470a.m72377b(c31242g);
            return;
        }
        boolean z;
        boolean z2;
        c31242g.f14383jL = true;
        c31242g.f14378jG = false;
        c31242g.f14379jH = false;
        c31242g.f14380jI = false;
        ArrayList<C17368f> arrayList = c31242g.f5052kx;
        List<C17371h> list = c31242g.f14377jF;
        boolean z3 = c31242g.mo31467aW() == C17370a.WRAP_CONTENT;
        if (c31242g.mo31468aX() == C17370a.WRAP_CONTENT) {
            z = true;
        } else {
            z = false;
        }
        if (z3 || z) {
            z2 = true;
        } else {
            z2 = false;
        }
        list.clear();
        for (C17368f c17368f : arrayList) {
            c17368f.f3653ir = null;
            c17368f.f3666jf = false;
            c17368f.mo31451aD();
        }
        for (C17368f c17368f2 : arrayList) {
            if (c17368f2.f3653ir == null) {
                C17371h c17371h = new C17371h(new ArrayList(), (byte) 0);
                list.add(c17371h);
                if (!C41470a.m72376a(c17368f2, c17371h, (List) list, z2)) {
                    C41470a.m72377b(c31242g);
                    c31242g.f14383jL = false;
                    return;
                }
            }
        }
        int i = 0;
        int i2 = 0;
        for (C17371h c17371h2 : list) {
            i2 = Math.max(i2, C41470a.m72371a(c17371h2, 0));
            i = Math.max(i, C41470a.m72371a(c17371h2, 1));
        }
        if (z3) {
            c31242g.mo31447a(C17370a.FIXED);
            c31242g.setWidth(i2);
            c31242g.f14378jG = true;
            c31242g.f14379jH = true;
            c31242g.f14381jJ = i2;
        }
        if (z) {
            c31242g.mo31470b(C17370a.FIXED);
            c31242g.setHeight(i);
            c31242g.f14378jG = true;
            c31242g.f14380jI = true;
            c31242g.f14382jK = i;
        }
        C41470a.m72375a((List) list, 0, c31242g.getWidth());
        C41470a.m72375a((List) list, 1, c31242g.getHeight());
    }

    /* renamed from: a */
    private static boolean m72376a(C17368f c17368f, C17371h c17371h, List<C17371h> list, boolean z) {
        if (c17368f == null) {
            return true;
        }
        c17368f.f3665je = false;
        C31242g c31242g = (C31242g) c17368f.f3620iG;
        if (c17368f.f3653ir == null) {
            C17370a c17370a;
            int i;
            c17368f.f3664jd = true;
            c17371h.f3684jP.add(c17368f);
            c17368f.f3653ir = c17371h;
            if (c17368f.f3656iu.f5032hy == null && c17368f.f3658ix.f5032hy == null && c17368f.f3657iw.f5032hy == null && c17368f.f3659iy.f5032hy == null && c17368f.f3660iz.f5032hy == null && c17368f.f3616iC.f5032hy == null) {
                C41470a.m72374a(c31242g, c17368f, c17371h);
                if (z) {
                    return false;
                }
            }
            if (!(c17368f.f3657iw.f5032hy == null || c17368f.f3659iy.f5032hy == null)) {
                c17370a = C17370a.WRAP_CONTENT;
                if (z) {
                    C41470a.m72374a(c31242g, c17368f, c17371h);
                    return false;
                } else if (!(c17368f.f3657iw.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3659iy.f5032hy.f5030hw == c17368f.f3620iG)) {
                    C41470a.m72374a(c31242g, c17368f, c17371h);
                }
            }
            if (!(c17368f.f3656iu.f5032hy == null || c17368f.f3658ix.f5032hy == null)) {
                c17370a = C17370a.WRAP_CONTENT;
                if (z) {
                    C41470a.m72374a(c31242g, c17368f, c17371h);
                    return false;
                } else if (!(c17368f.f3656iu.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3658ix.f5032hy.f5030hw == c17368f.f3620iG)) {
                    C41470a.m72374a(c31242g, c17368f, c17371h);
                }
            }
            int i2 = c17368f.mo31467aW() == C17370a.MATCH_CONSTRAINT ? 1 : 0;
            if (c17368f.mo31468aX() == C17370a.MATCH_CONSTRAINT) {
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 ^ i) != 0 && c17368f.f3621iH != 0.0f) {
                C41470a.m72368a(c17368f);
            } else if (c17368f.mo31467aW() == C17370a.MATCH_CONSTRAINT || c17368f.mo31468aX() == C17370a.MATCH_CONSTRAINT) {
                C41470a.m72374a(c31242g, c17368f, c17371h);
                if (z) {
                    return false;
                }
            }
            if (((c17368f.f3656iu.f5032hy == null && c17368f.f3658ix.f5032hy == null) || ((c17368f.f3656iu.f5032hy != null && c17368f.f3656iu.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3658ix.f5032hy == null) || ((c17368f.f3658ix.f5032hy != null && c17368f.f3658ix.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3656iu.f5032hy == null) || (c17368f.f3656iu.f5032hy != null && c17368f.f3656iu.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3658ix.f5032hy != null && c17368f.f3658ix.f5032hy.f5030hw == c17368f.f3620iG)))) && c17368f.f3616iC.f5032hy == null && !(c17368f instanceof C41471i) && !(c17368f instanceof C41473j)) {
                c17371h.f3688jT.add(c17368f);
            }
            if (((c17368f.f3657iw.f5032hy == null && c17368f.f3659iy.f5032hy == null) || ((c17368f.f3657iw.f5032hy != null && c17368f.f3657iw.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3659iy.f5032hy == null) || ((c17368f.f3659iy.f5032hy != null && c17368f.f3659iy.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3657iw.f5032hy == null) || (c17368f.f3657iw.f5032hy != null && c17368f.f3657iw.f5032hy.f5030hw == c17368f.f3620iG && c17368f.f3659iy.f5032hy != null && c17368f.f3659iy.f5032hy.f5030hw == c17368f.f3620iG)))) && c17368f.f3616iC.f5032hy == null && c17368f.f3660iz.f5032hy == null && !(c17368f instanceof C41471i) && !(c17368f instanceof C41473j)) {
                c17371h.f3689jU.add(c17368f);
            }
            if (c17368f instanceof C41473j) {
                C41470a.m72374a(c31242g, c17368f, c17371h);
                if (z) {
                    return false;
                }
                C41473j c41473j = (C41473j) c17368f;
                for (i = 0; i < c41473j.f16635hn; i++) {
                    if (!C41470a.m72376a(c41473j.f16636kh[i], c17371h, (List) list, z)) {
                        return false;
                    }
                }
            }
            for (C25284e c25284e : c17368f.f3617iD) {
                if (!(c25284e.f5032hy == null || c25284e.f5032hy.f5030hw == c17368f.f3620iG)) {
                    if (c25284e.f5031hx == C25287c.CENTER) {
                        C41470a.m72374a(c31242g, c17368f, c17371h);
                        if (z) {
                            return false;
                        }
                    }
                    C41476m c41476m = c25284e.f5029hv;
                    if (!(c25284e.f5032hy == null || c25284e.f5032hy.f5032hy == c25284e)) {
                        c25284e.f5032hy.f5029hv.mo42142a(c41476m);
                    }
                    if (!C41470a.m72376a(c25284e.f5032hy.f5030hw, c17371h, (List) list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (c17368f.f3653ir != c17371h) {
            c17371h.f3684jP.addAll(c17368f.f3653ir.f3684jP);
            c17371h.f3688jT.addAll(c17368f.f3653ir.f3688jT);
            c17371h.f3689jU.addAll(c17368f.f3653ir.f3689jU);
            if (!c17368f.f3653ir.f3683jL) {
                c17371h.f3683jL = false;
            }
            list.remove(c17368f.f3653ir);
            for (C17368f c17368f2 : c17368f.f3653ir.f3684jP) {
                c17368f2.f3653ir = c17371h;
            }
        }
        return true;
    }

    /* renamed from: a */
    private static void m72374a(C31242g c31242g, C17368f c17368f, C17371h c17371h) {
        c17371h.f3683jL = false;
        c31242g.f14383jL = false;
        c17368f.f3664jd = false;
    }

    /* renamed from: a */
    private static int m72371a(C17371h c17371h, int i) {
        List list;
        int i2 = i * 2;
        if (i == 0) {
            list = c17371h.f3688jT;
        } else if (i == 1) {
            list = c17371h.f3689jU;
        } else {
            list = null;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            C17368f c17368f = (C17368f) list.get(i3);
            boolean z = c17368f.f3617iD[i2 + 1].f5032hy == null || !(c17368f.f3617iD[i2].f5032hy == null || c17368f.f3617iD[i2 + 1].f5032hy == null);
            i3++;
            i4 = Math.max(i4, C41470a.m72370a(c17368f, i, z, 0));
        }
        c17371h.f3687jS[i] = i4;
        return i4;
    }

    /* renamed from: a */
    private static int m72370a(C17368f c17368f, int i, boolean z, int i2) {
        if (!c17368f.f3664jd) {
            return 0;
        }
        int i3;
        int height;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Object obj = (c17368f.f3660iz.f5032hy == null || i != 1) ? null : 1;
        if (z) {
            i3 = c17368f.f3631iR;
            height = c17368f.getHeight() - c17368f.f3631iR;
            i4 = i * 2;
            i5 = i4 + 1;
        } else {
            i3 = c17368f.getHeight() - c17368f.f3631iR;
            height = c17368f.f3631iR;
            i5 = i * 2;
            i4 = i5 + 1;
        }
        if (c17368f.f3617iD[i5].f5032hy == null || c17368f.f3617iD[i4].f5032hy != null) {
            i6 = 1;
            i7 = i5;
            i8 = i4;
        } else {
            i6 = -1;
            i7 = i4;
            i8 = i5;
        }
        if (obj != null) {
            i2 -= i3;
        }
        int aH = (c17368f.f3617iD[i8].mo42138aH() * i6) + C41470a.m72369a(c17368f, i);
        int i10 = aH + i2;
        int width = (i == 0 ? c17368f.getWidth() : c17368f.getHeight()) * i6;
        Iterator it = c17368f.f3617iD[i8].f5029hv.f5051kt.iterator();
        i4 = 0;
        while (it.hasNext()) {
            i4 = Math.max(i4, C41470a.m72370a(((C41476m) ((C25288o) it.next())).f16639kj.f5030hw, i, z, i10));
        }
        it = c17368f.f3617iD[i7].f5029hv.f5051kt.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 = Math.max(i11, C41470a.m72370a(((C41476m) ((C25288o) it.next())).f16639kj.f5030hw, i, z, width + i10));
        }
        if (obj != null) {
            i11 += height;
            i9 = i4 - i3;
        } else {
            i11 = ((i == 0 ? c17368f.getWidth() : c17368f.getHeight()) * i6) + i11;
            i9 = i4;
        }
        i5 = 0;
        if (i == 1) {
            it = c17368f.f3660iz.f5029hv.f5051kt.iterator();
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                C41476m c41476m = (C41476m) ((C25288o) it.next());
                if (i6 == 1) {
                    i5 = Math.max(i4, C41470a.m72370a(c41476m.f16639kj.f5030hw, i, z, i3 + i10));
                } else {
                    i5 = Math.max(i4, C41470a.m72370a(c41476m.f16639kj.f5030hw, i, z, (height * i6) + i10));
                }
            }
            if (c17368f.f3660iz.f5029hv.f5051kt.size() > 0 && obj == null) {
                i4 = i6 == 1 ? i4 + i3 : i4 - height;
            }
        } else {
            i4 = 0;
        }
        i5 = Math.max(i9, Math.max(i11, i4)) + aH;
        height = i2 + aH;
        i3 = height + width;
        if (i6 == -1) {
            i4 = height;
            i11 = i3;
        } else {
            i4 = i3;
            i11 = height;
        }
        if (z) {
            C41474k.m72392b(c17368f, i, i11);
            c17368f.mo31472e(i11, i4, i);
        } else {
            c17368f.f3653ir.mo31498c(c17368f, i);
            c17368f.mo31482i(i11, i);
        }
        if (c17368f.mo31495x(i) == C17370a.MATCH_CONSTRAINT && c17368f.f3621iH != 0.0f) {
            c17368f.f3653ir.mo31498c(c17368f, i);
        }
        if (c17368f.f3617iD[i8].f5032hy == null || c17368f.f3617iD[i7].f5032hy == null) {
            return i5;
        }
        C17368f c17368f2 = c17368f.f3620iG;
        if (c17368f.f3617iD[i8].f5032hy.f5030hw != c17368f2 || c17368f.f3617iD[i7].f5032hy.f5030hw != c17368f2) {
            return i5;
        }
        c17368f.f3653ir.mo31498c(c17368f, i);
        return i5;
    }

    /* renamed from: b */
    private static void m72377b(C31242g c31242g) {
        c31242g.f14377jF.clear();
        c31242g.f14377jF.add(0, new C17371h(c31242g.f5052kx));
    }

    /* renamed from: a */
    public static void m72375a(List<C17371h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (C17368f c17368f : ((C17371h) list.get(i3)).mo31496A(i)) {
                if (c17368f.f3664jd) {
                    C41470a.m72372a(c17368f, i, i2);
                }
            }
        }
    }

    /* renamed from: a */
    private static void m72372a(C17368f c17368f, int i, int i2) {
        int i3 = i * 2;
        C25284e c25284e = c17368f.f3617iD[i3];
        C25284e c25284e2 = c17368f.f3617iD[i3 + 1];
        int i4 = (c25284e.f5032hy == null || c25284e2.f5032hy == null) ? 0 : 1;
        if (i4 != 0) {
            C41474k.m72392b(c17368f, i, C41470a.m72369a(c17368f, i) + c25284e.mo42138aH());
        } else if (c17368f.f3621iH == 0.0f || c17368f.mo31495x(i) != C17370a.MATCH_CONSTRAINT) {
            i4 = i2 - c17368f.mo31494w(i);
            int v = i4 - c17368f.mo31493v(i);
            c17368f.mo31472e(v, i4, i);
            C41474k.m72392b(c17368f, i, v);
        } else {
            i4 = C41470a.m72368a(c17368f);
            i3 = (int) c17368f.f3617iD[i3].f5029hv.f16642km;
            int i5 = i3 + i4;
            c25284e2.f5029hv.f16641kl = c25284e.f5029hv;
            c25284e2.f5029hv.f16642km = (float) i4;
            c25284e2.f5029hv.state = 1;
            c17368f.mo31472e(i3, i5, i);
        }
    }

    /* renamed from: a */
    private static int m72369a(C17368f c17368f, int i) {
        int i2 = i * 2;
        C25284e c25284e = c17368f.f3617iD[i2];
        C25284e c25284e2 = c17368f.f3617iD[i2 + 1];
        if (c25284e.f5032hy == null || c25284e.f5032hy.f5030hw != c17368f.f3620iG || c25284e2.f5032hy == null || c25284e2.f5032hy.f5030hw != c17368f.f3620iG) {
            return 0;
        }
        return (int) ((i == 0 ? c17368f.f3634iV : c17368f.f3635iW) * ((float) (((c17368f.f3620iG.mo31493v(i) - c25284e.mo42138aH()) - c25284e2.mo42138aH()) - c17368f.mo31493v(i))));
    }

    /* renamed from: a */
    private static int m72368a(C17368f c17368f) {
        int i = -1;
        if (c17368f.mo31467aW() == C17370a.MATCH_CONSTRAINT) {
            if (c17368f.f3622iI == 0) {
                i = (int) (((float) c17368f.getHeight()) * c17368f.f3621iH);
            } else {
                i = (int) (((float) c17368f.getHeight()) / c17368f.f3621iH);
            }
            c17368f.setWidth(i);
        } else if (c17368f.mo31468aX() == C17370a.MATCH_CONSTRAINT) {
            if (c17368f.f3622iI == 1) {
                i = (int) (((float) c17368f.getWidth()) * c17368f.f3621iH);
            } else {
                i = (int) (((float) c17368f.getWidth()) / c17368f.f3621iH);
            }
            c17368f.setHeight(i);
        }
        return i;
    }
}
