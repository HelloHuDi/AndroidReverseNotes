package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C36667b;
import android.support.constraint.p780a.C41479h;
import android.support.constraint.p780a.p781a.C17368f.C17370a;
import java.util.ArrayList;

/* renamed from: android.support.constraint.a.a.c */
final class C44943c {
    /* JADX WARNING: Removed duplicated region for block: B:237:0x056e  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x04d9  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x04ed  */
    /* JADX WARNING: Removed duplicated region for block: B:209:0x04f4  */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x050f  */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x051f  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x052e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    static void m82168a(C31242g c31242g, C17377e c17377e, int i) {
        int i2;
        C37094d[] c37094dArr;
        int i3;
        int i4;
        if (i == 0) {
            i2 = c31242g.f14373jB;
            c37094dArr = c31242g.f14376jE;
            i3 = i2;
            i4 = 0;
        } else {
            i2 = c31242g.f14374jC;
            c37094dArr = c31242g.f14375jD;
            i3 = i2;
            i4 = 2;
        }
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 < i3) {
                C37094d c37094d = c37094dArr[i6];
                if (!c37094d.f15654hu) {
                    c37094d.mo59119aF();
                }
                c37094d.f15654hu = true;
                if (!c31242g.mo51199z(4) || !C41474k.m72391a(c17377e, i, i4, c37094d)) {
                    Object obj;
                    Object obj2;
                    Object obj3;
                    C17368f c17368f;
                    C25284e c25284e;
                    C25284e c25284e2;
                    C17368f c17368f2;
                    C25284e c25284e3;
                    C41479h c41479h;
                    C41479h c41479h2;
                    C25284e c25284e4;
                    int aH;
                    C25284e c25284e5;
                    C17368f c17368f3 = c37094d.f15639hf;
                    C17368f c17368f4 = c37094d.f15641hh;
                    C17368f c17368f5 = c37094d.f15640hg;
                    C17368f c17368f6 = c37094d.f15642hi;
                    C17368f c17368f7 = c37094d.f15643hj;
                    Object obj4 = null;
                    float f = c37094d.f15649hp;
                    Object obj5 = c31242g.f3619iF[i] == C17370a.WRAP_CONTENT ? 1 : null;
                    if (i == 0) {
                        Object obj6;
                        Object obj7 = c17368f7.f3667jg == 0 ? 1 : null;
                        Object obj8 = c17368f7.f3667jg == 1 ? 1 : null;
                        if (c17368f7.f3667jg == 2) {
                            obj6 = 1;
                        } else {
                            obj6 = null;
                        }
                        obj = obj6;
                        obj2 = obj8;
                        obj3 = obj7;
                        c17368f = c17368f3;
                    } else {
                        obj = c17368f7.f3668jh == 2 ? 1 : null;
                        obj2 = c17368f7.f3668jh == 1 ? 1 : null;
                        obj3 = c17368f7.f3668jh == 0 ? 1 : null;
                        c17368f = c17368f3;
                    }
                    while (obj4 == null) {
                        c25284e = c17368f.f3617iD[i4];
                        i5 = 4;
                        if (!(obj5 == null && obj == null)) {
                            i5 = 1;
                        }
                        i2 = c25284e.mo42138aH();
                        if (!(c25284e.f5032hy == null || c17368f == c17368f3)) {
                            i2 += c25284e.f5032hy.mo42138aH();
                        }
                        if (obj != null && c17368f != c17368f3 && c17368f != c17368f5) {
                            i5 = 6;
                        } else if (!(obj3 == null || obj5 == null)) {
                            i5 = 4;
                        }
                        if (c25284e.f5032hy != null) {
                            if (c17368f == c17368f5) {
                                c17377e.mo31517a(c25284e.f5028hE, c25284e.f5032hy.f5028hE, i2, 5);
                            } else {
                                c17377e.mo31517a(c25284e.f5028hE, c25284e.f5032hy.f5028hE, i2, 6);
                            }
                            c17377e.mo31524c(c25284e.f5028hE, c25284e.f5032hy.f5028hE, i2, i5);
                        }
                        if (obj5 != null) {
                            if (c17368f.f3638iZ != 8 && c17368f.f3619iF[i] == C17370a.MATCH_CONSTRAINT) {
                                c17377e.mo31517a(c17368f.f3617iD[i4 + 1].f5028hE, c17368f.f3617iD[i4].f5028hE, 0, 5);
                            }
                            c17377e.mo31517a(c17368f.f3617iD[i4].f5028hE, c31242g.f3617iD[i4].f5028hE, 0, 6);
                        }
                        c25284e2 = c17368f.f3617iD[i4 + 1].f5032hy;
                        if (c25284e2 != null) {
                            c17368f2 = c25284e2.f5030hw;
                            if (c17368f2.f3617iD[i4].f5032hy == null || c17368f2.f3617iD[i4].f5032hy.f5030hw != c17368f) {
                                c17368f2 = null;
                            }
                        } else {
                            c17368f2 = null;
                        }
                        if (c17368f2 != null) {
                            c17368f = c17368f2;
                        } else {
                            obj4 = 1;
                        }
                    }
                    if (!(c17368f6 == null || c17368f4.f3617iD[i4 + 1].f5032hy == null)) {
                        c25284e2 = c17368f6.f3617iD[i4 + 1];
                        c17377e.mo31523b(c25284e2.f5028hE, c17368f4.f3617iD[i4 + 1].f5032hy.f5028hE, -c25284e2.mo42138aH(), 5);
                    }
                    if (obj5 != null) {
                        c17377e.mo31517a(c31242g.f3617iD[i4 + 1].f5028hE, c17368f4.f3617iD[i4 + 1].f5028hE, c17368f4.f3617iD[i4 + 1].mo42138aH(), 6);
                    }
                    ArrayList arrayList = c37094d.f15646hm;
                    if (arrayList != null) {
                        int size = arrayList.size();
                        if (size > 1) {
                            float f2;
                            C17368f c17368f8 = null;
                            float f3 = 0.0f;
                            if (!c37094d.f15651hr || c37094d.f15653ht) {
                                f2 = f;
                            } else {
                                f2 = (float) c37094d.f15648ho;
                            }
                            for (int i7 = 0; i7 < size; i7++) {
                                c17368f2 = (C17368f) arrayList.get(i7);
                                f = c17368f2.f3671jk[i];
                                if (f < 0.0f) {
                                    if (c37094d.f15653ht) {
                                        c17377e.mo31524c(c17368f2.f3617iD[i4 + 1].f5028hE, c17368f2.f3617iD[i4].f5028hE, 0, 4);
                                        c17368f2 = c17368f8;
                                        c17368f8 = c17368f2;
                                    } else {
                                        f = 1.0f;
                                    }
                                }
                                if (f == 0.0f) {
                                    c17377e.mo31524c(c17368f2.f3617iD[i4 + 1].f5028hE, c17368f2.f3617iD[i4].f5028hE, 0, 6);
                                    c17368f2 = c17368f8;
                                } else {
                                    if (c17368f8 != null) {
                                        C41479h c41479h3 = c17368f8.f3617iD[i4].f5028hE;
                                        C41479h c41479h4 = c17368f8.f3617iD[i4 + 1].f5028hE;
                                        C41479h c41479h5 = c17368f2.f3617iD[i4].f5028hE;
                                        C41479h c41479h6 = c17368f2.f3617iD[i4 + 1].f5028hE;
                                        C36667b ax = c17377e.mo31518ax();
                                        ax.f15471fG = 0.0f;
                                        if (f2 == 0.0f || f3 == f) {
                                            ax.f15473fI.mo31506a(c41479h3, 1.0f);
                                            ax.f15473fI.mo31506a(c41479h4, -1.0f);
                                            ax.f15473fI.mo31506a(c41479h6, 1.0f);
                                            ax.f15473fI.mo31506a(c41479h5, -1.0f);
                                        } else if (f3 == 0.0f) {
                                            ax.f15473fI.mo31506a(c41479h3, 1.0f);
                                            ax.f15473fI.mo31506a(c41479h4, -1.0f);
                                        } else if (f == 0.0f) {
                                            ax.f15473fI.mo31506a(c41479h5, 1.0f);
                                            ax.f15473fI.mo31506a(c41479h6, -1.0f);
                                        } else {
                                            f3 = (f3 / f2) / (f / f2);
                                            ax.f15473fI.mo31506a(c41479h3, 1.0f);
                                            ax.f15473fI.mo31506a(c41479h4, -1.0f);
                                            ax.f15473fI.mo31506a(c41479h6, f3);
                                            ax.f15473fI.mo31506a(c41479h5, -f3);
                                        }
                                        c17377e.mo31521b(ax);
                                    }
                                    f3 = f;
                                }
                                c17368f8 = c17368f2;
                            }
                        }
                    }
                    Object obj9;
                    C17368f c17368f9;
                    C17368f c17368f10;
                    C17368f c17368f11;
                    C41479h c41479h7;
                    C41479h c41479h8;
                    int aH2;
                    C41479h c41479h9;
                    int i8;
                    if (c17368f5 != null && (c17368f5 == c17368f6 || obj != null)) {
                        c25284e3 = c17368f3.f3617iD[i4];
                        c25284e2 = c17368f4.f3617iD[i4 + 1];
                        c41479h = c17368f3.f3617iD[i4].f5032hy != null ? c17368f3.f3617iD[i4].f5032hy.f5028hE : null;
                        c41479h2 = c17368f4.f3617iD[i4 + 1].f5032hy != null ? c17368f4.f3617iD[i4 + 1].f5032hy.f5028hE : null;
                        if (c17368f5 == c17368f6) {
                            c25284e3 = c17368f5.f3617iD[i4];
                            c25284e2 = c17368f5.f3617iD[i4 + 1];
                        }
                        if (!(c41479h == null || c41479h2 == null)) {
                            float f4;
                            if (i == 0) {
                                f4 = c17368f7.f3634iV;
                            } else {
                                f4 = c17368f7.f3635iW;
                            }
                            c17377e.mo31516a(c25284e3.f5028hE, c41479h, c25284e3.mo42138aH(), f4, c41479h2, c25284e2.f5028hE, c25284e2.mo42138aH(), 5);
                        }
                    } else if (obj3 != null && c17368f5 != null) {
                        obj9 = (c37094d.f15648ho <= 0 || c37094d.f15647hn != c37094d.f15648ho) ? null : 1;
                        c17368f9 = c17368f5;
                        c17368f10 = c17368f5;
                        while (c17368f10 != null) {
                            c17368f11 = c17368f10.f3673jm[i];
                            while (c17368f11 != null && c17368f11.f3638iZ == 8) {
                                c17368f11 = c17368f11.f3673jm[i];
                            }
                            if (c17368f11 != null || c17368f10 == c17368f6) {
                                c25284e4 = c17368f10.f3617iD[i4];
                                c41479h7 = c25284e4.f5028hE;
                                c41479h = c25284e4.f5032hy != null ? c25284e4.f5032hy.f5028hE : null;
                                if (c17368f9 != c17368f10) {
                                    c41479h8 = c17368f9.f3617iD[i4 + 1].f5028hE;
                                } else {
                                    if (c17368f10 == c17368f5 && c17368f9 == c17368f10) {
                                        c41479h8 = c17368f3.f3617iD[i4].f5032hy != null ? c17368f3.f3617iD[i4].f5032hy.f5028hE : null;
                                    }
                                    c41479h2 = null;
                                    aH = c25284e4.mo42138aH();
                                    aH2 = c17368f10.f3617iD[i4 + 1].mo42138aH();
                                    if (c17368f11 == null) {
                                        c25284e2 = c17368f11.f3617iD[i4];
                                        c41479h2 = c25284e2.f5028hE;
                                    } else {
                                        c25284e2 = c17368f4.f3617iD[i4 + 1].f5032hy;
                                        if (c25284e2 != null) {
                                            c41479h2 = c25284e2.f5028hE;
                                        }
                                    }
                                    c41479h9 = c17368f10.f3617iD[i4 + 1].f5028hE;
                                    if (c25284e2 != null) {
                                        aH2 += c25284e2.mo42138aH();
                                    }
                                    if (c17368f9 != null) {
                                        aH += c17368f9.f3617iD[i4 + 1].mo42138aH();
                                    }
                                    if (!(c41479h7 == null || c41479h == null || c41479h2 == null || c41479h9 == null)) {
                                        if (c17368f10 == c17368f5) {
                                            aH = c17368f5.f3617iD[i4].mo42138aH();
                                        }
                                        if (c17368f10 == c17368f6) {
                                            aH2 = c17368f6.f3617iD[i4 + 1].mo42138aH();
                                        }
                                        i8 = 4;
                                        if (obj9 != null) {
                                            i8 = 6;
                                        }
                                        c17377e.mo31516a(c41479h7, c41479h, aH, 0.5f, c41479h2, c41479h9, aH2, i8);
                                    }
                                }
                                c41479h = c41479h8;
                                c41479h2 = null;
                                aH = c25284e4.mo42138aH();
                                aH2 = c17368f10.f3617iD[i4 + 1].mo42138aH();
                                if (c17368f11 == null) {
                                }
                                c41479h9 = c17368f10.f3617iD[i4 + 1].f5028hE;
                                if (c25284e2 != null) {
                                }
                                if (c17368f9 != null) {
                                }
                                if (c17368f10 == c17368f5) {
                                }
                                if (c17368f10 == c17368f6) {
                                }
                                i8 = 4;
                                if (obj9 != null) {
                                }
                                c17377e.mo31516a(c41479h7, c41479h, aH, 0.5f, c41479h2, c41479h9, aH2, i8);
                            }
                            if (c17368f10.f3638iZ != 8) {
                                c17368f2 = c17368f10;
                            } else {
                                c17368f2 = c17368f9;
                            }
                            c17368f9 = c17368f2;
                            c17368f10 = c17368f11;
                        }
                    } else if (!(obj2 == null || c17368f5 == null)) {
                        obj9 = (c37094d.f15648ho <= 0 || c37094d.f15647hn != c37094d.f15648ho) ? null : 1;
                        c17368f11 = c17368f5;
                        c17368f9 = c17368f5;
                        while (c17368f9 != null) {
                            c17368f2 = c17368f9.f3673jm[i];
                            while (c17368f2 != null && c17368f2.f3638iZ == 8) {
                                c17368f2 = c17368f2.f3673jm[i];
                            }
                            if (c17368f9 == c17368f5 || c17368f9 == c17368f6 || c17368f2 == null) {
                                c17368f10 = c17368f2;
                            } else {
                                if (c17368f2 == c17368f6) {
                                    c17368f10 = null;
                                } else {
                                    c17368f10 = c17368f2;
                                }
                                c25284e4 = c17368f9.f3617iD[i4];
                                c41479h7 = c25284e4.f5028hE;
                                c41479h = c17368f11.f3617iD[i4 + 1].f5028hE;
                                c41479h8 = null;
                                aH = c25284e4.mo42138aH();
                                aH2 = c17368f9.f3617iD[i4 + 1].mo42138aH();
                                if (c17368f10 != null) {
                                    c25284e5 = c17368f10.f3617iD[i4];
                                    c41479h2 = c25284e5.f5028hE;
                                    c41479h9 = c25284e5.f5032hy != null ? c25284e5.f5032hy.f5028hE : null;
                                } else {
                                    c25284e5 = c17368f9.f3617iD[i4 + 1].f5032hy;
                                    if (c25284e5 != null) {
                                        c41479h8 = c25284e5.f5028hE;
                                    }
                                    c41479h9 = c17368f9.f3617iD[i4 + 1].f5028hE;
                                    c41479h2 = c41479h8;
                                }
                                if (c25284e5 != null) {
                                    aH2 += c25284e5.mo42138aH();
                                }
                                if (c17368f11 != null) {
                                    aH += c17368f11.f3617iD[i4 + 1].mo42138aH();
                                }
                                i8 = 4;
                                if (obj9 != null) {
                                    i8 = 6;
                                }
                                if (!(c41479h7 == null || c41479h == null || c41479h2 == null || c41479h9 == null)) {
                                    c17377e.mo31516a(c41479h7, c41479h, aH, 0.5f, c41479h2, c41479h9, aH2, i8);
                                }
                            }
                            if (c17368f9.f3638iZ != 8) {
                                c17368f2 = c17368f9;
                            } else {
                                c17368f2 = c17368f11;
                            }
                            c17368f11 = c17368f2;
                            c17368f9 = c17368f10;
                        }
                        c25284e2 = c17368f5.f3617iD[i4];
                        c25284e = c17368f3.f3617iD[i4].f5032hy;
                        C25284e c25284e6 = c17368f6.f3617iD[i4 + 1];
                        C25284e c25284e7 = c17368f4.f3617iD[i4 + 1].f5032hy;
                        if (c25284e != null) {
                            if (c17368f5 != c17368f6) {
                                c17377e.mo31524c(c25284e2.f5028hE, c25284e.f5028hE, c25284e2.mo42138aH(), 5);
                            } else if (c25284e7 != null) {
                                c17377e.mo31516a(c25284e2.f5028hE, c25284e.f5028hE, c25284e2.mo42138aH(), 0.5f, c25284e6.f5028hE, c25284e7.f5028hE, c25284e6.mo42138aH(), 5);
                            }
                        }
                        if (!(c25284e7 == null || c17368f5 == c17368f6)) {
                            c17377e.mo31524c(c25284e6.f5028hE, c25284e7.f5028hE, -c25284e6.mo42138aH(), 5);
                        }
                    }
                    if (!((obj3 == null && obj2 == null) || c17368f5 == null)) {
                        C25284e c25284e8;
                        c25284e4 = c17368f5.f3617iD[i4];
                        c25284e3 = c17368f6.f3617iD[i4 + 1];
                        c41479h = c25284e4.f5032hy != null ? c25284e4.f5032hy.f5028hE : null;
                        c41479h2 = c25284e3.f5032hy != null ? c25284e3.f5032hy.f5028hE : null;
                        if (c17368f4 != c17368f6) {
                            c25284e2 = c17368f4.f3617iD[i4 + 1];
                            c41479h2 = c25284e2.f5032hy != null ? c25284e2.f5032hy.f5028hE : null;
                        }
                        if (c17368f5 == c17368f6) {
                            c25284e3 = c17368f5.f3617iD[i4];
                            c25284e8 = c17368f5.f3617iD[i4 + 1];
                            c25284e5 = c25284e3;
                        } else {
                            c25284e8 = c25284e3;
                            c25284e5 = c25284e4;
                        }
                        if (!(c41479h == null || c41479h2 == null)) {
                            aH = c25284e5.mo42138aH();
                            if (c17368f6 == null) {
                                c17368f2 = c17368f4;
                            } else {
                                c17368f2 = c17368f6;
                            }
                            c17377e.mo31516a(c25284e5.f5028hE, c41479h, aH, 0.5f, c41479h2, c25284e8.f5028hE, c17368f2.f3617iD[i4 + 1].mo42138aH(), 5);
                        }
                    }
                }
                i5 = i6 + 1;
            } else {
                return;
            }
        }
    }
}
