package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.p781a.C17368f.C17370a;

/* renamed from: android.support.constraint.a.a.k */
public final class C41474k {
    /* renamed from: ki */
    static boolean[] f16637ki = new boolean[3];

    /* renamed from: a */
    static void m72390a(C31242g c31242g, C17377e c17377e, C17368f c17368f) {
        int i;
        int width;
        if (c31242g.f3619iF[0] != C17370a.WRAP_CONTENT && c17368f.f3619iF[0] == C17370a.MATCH_PARENT) {
            i = c17368f.f3656iu.f5033hz;
            width = c31242g.getWidth() - c17368f.f3658ix.f5033hz;
            c17368f.f3656iu.f5028hE = c17377e.mo31526g(c17368f.f3656iu);
            c17368f.f3658ix.f5028hE = c17377e.mo31526g(c17368f.f3658ix);
            c17377e.mo31515a(c17368f.f3656iu.f5028hE, i);
            c17377e.mo31515a(c17368f.f3658ix.f5028hE, width);
            c17368f.f3611hX = 2;
            c17368f.mo31474g(i, width);
        }
        if (c31242g.f3619iF[1] != C17370a.WRAP_CONTENT && c17368f.f3619iF[1] == C17370a.MATCH_PARENT) {
            i = c17368f.f3657iw.f5033hz;
            width = c31242g.getHeight() - c17368f.f3659iy.f5033hz;
            c17368f.f3657iw.f5028hE = c17377e.mo31526g(c17368f.f3657iw);
            c17368f.f3659iy.f5028hE = c17377e.mo31526g(c17368f.f3659iy);
            c17377e.mo31515a(c17368f.f3657iw.f5028hE, i);
            c17377e.mo31515a(c17368f.f3659iy.f5028hE, width);
            if (c17368f.f3631iR > 0 || c17368f.f3638iZ == 8) {
                c17368f.f3660iz.f5028hE = c17377e.mo31526g(c17368f.f3660iz);
                c17377e.mo31515a(c17368f.f3660iz.f5028hE, c17368f.f3631iR + i);
            }
            c17368f.f3612hY = 2;
            c17368f.mo31481h(i, width);
        }
    }

    /* renamed from: d */
    private static boolean m72393d(C17368f c17368f, int i) {
        int i2 = 1;
        if (c17368f.f3619iF[i] != C17370a.MATCH_CONSTRAINT) {
            return false;
        }
        if (c17368f.f3621iH != 0.0f) {
            C17370a[] c17370aArr = c17368f.f3619iF;
            if (i != 0) {
                i2 = 0;
            }
            if (c17370aArr[i2] == C17370a.MATCH_CONSTRAINT) {
            }
            return false;
        }
        if (i == 0) {
            if (!(c17368f.f3640ib == 0 && c17368f.f3643if == 0 && c17368f.f3644ig == 0)) {
                return false;
            }
        } else if (!(c17368f.f3641ic == 0 && c17368f.f3646ii == 0 && c17368f.f3647ij == 0)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    static void m72389a(int i, C17368f c17368f) {
        int i2;
        int i3 = 0;
        c17368f.mo31455aK();
        C41476m c41476m = c17368f.f3656iu.f5029hv;
        C41476m c41476m2 = c17368f.f3657iw.f5029hv;
        C41476m c41476m3 = c17368f.f3658ix.f5029hv;
        C41476m c41476m4 = c17368f.f3659iy.f5029hv;
        int i4 = (i & 8) == 8 ? 1 : 0;
        if (c17368f.f3619iF[0] == C17370a.MATCH_CONSTRAINT && C41474k.m72393d(c17368f, 0)) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (!(c41476m.type == 4 || c41476m3.type == 4)) {
            if (c17368f.f3619iF[0] == C17370a.FIXED || (i2 != 0 && c17368f.f3638iZ == 8)) {
                if (c17368f.f3656iu.f5032hy == null && c17368f.f3658ix.f5032hy == null) {
                    c41476m.type = 1;
                    c41476m3.type = 1;
                    if (i4 != 0) {
                        c41476m3.mo66149a(c41476m, 1, c17368f.mo31457aM());
                    } else {
                        c41476m3.mo66151b(c41476m, c17368f.getWidth());
                    }
                } else if (c17368f.f3656iu.f5032hy != null && c17368f.f3658ix.f5032hy == null) {
                    c41476m.type = 1;
                    c41476m3.type = 1;
                    if (i4 != 0) {
                        c41476m3.mo66149a(c41476m, 1, c17368f.mo31457aM());
                    } else {
                        c41476m3.mo66151b(c41476m, c17368f.getWidth());
                    }
                } else if (c17368f.f3656iu.f5032hy == null && c17368f.f3658ix.f5032hy != null) {
                    c41476m.type = 1;
                    c41476m3.type = 1;
                    c41476m.mo66151b(c41476m3, -c17368f.getWidth());
                    if (i4 != 0) {
                        c41476m.mo66149a(c41476m3, -1, c17368f.mo31457aM());
                    } else {
                        c41476m.mo66151b(c41476m3, -c17368f.getWidth());
                    }
                } else if (!(c17368f.f3656iu.f5032hy == null || c17368f.f3658ix.f5032hy == null)) {
                    c41476m.type = 2;
                    c41476m3.type = 2;
                    if (i4 != 0) {
                        c17368f.mo31457aM().mo42142a(c41476m);
                        c17368f.mo31457aM().mo42142a(c41476m3);
                        c41476m.mo66152b(c41476m3, -1, c17368f.mo31457aM());
                        c41476m3.mo66152b(c41476m, 1, c17368f.mo31457aM());
                    } else {
                        c41476m.mo66150b(c41476m3, (float) (-c17368f.getWidth()));
                        c41476m3.mo66150b(c41476m, (float) c17368f.getWidth());
                    }
                }
            } else if (i2 != 0) {
                i2 = c17368f.getWidth();
                c41476m.type = 1;
                c41476m3.type = 1;
                if (c17368f.f3656iu.f5032hy == null && c17368f.f3658ix.f5032hy == null) {
                    if (i4 != 0) {
                        c41476m3.mo66149a(c41476m, 1, c17368f.mo31457aM());
                    } else {
                        c41476m3.mo66151b(c41476m, i2);
                    }
                } else if (c17368f.f3656iu.f5032hy == null || c17368f.f3658ix.f5032hy != null) {
                    if (c17368f.f3656iu.f5032hy != null || c17368f.f3658ix.f5032hy == null) {
                        if (!(c17368f.f3656iu.f5032hy == null || c17368f.f3658ix.f5032hy == null)) {
                            if (i4 != 0) {
                                c17368f.mo31457aM().mo42142a(c41476m);
                                c17368f.mo31457aM().mo42142a(c41476m3);
                            }
                            if (c17368f.f3621iH == 0.0f) {
                                c41476m.type = 3;
                                c41476m3.type = 3;
                                c41476m.mo66150b(c41476m3, 0.0f);
                                c41476m3.mo66150b(c41476m, 0.0f);
                            } else {
                                c41476m.type = 2;
                                c41476m3.type = 2;
                                c41476m.mo66150b(c41476m3, (float) (-i2));
                                c41476m3.mo66150b(c41476m, (float) i2);
                                c17368f.setWidth(i2);
                            }
                        }
                    } else if (i4 != 0) {
                        c41476m.mo66149a(c41476m3, -1, c17368f.mo31457aM());
                    } else {
                        c41476m.mo66151b(c41476m3, -i2);
                    }
                } else if (i4 != 0) {
                    c41476m3.mo66149a(c41476m, 1, c17368f.mo31457aM());
                } else {
                    c41476m3.mo66151b(c41476m, i2);
                }
            }
        }
        if (c17368f.f3619iF[1] == C17370a.MATCH_CONSTRAINT && C41474k.m72393d(c17368f, 1)) {
            i3 = 1;
        }
        if (c41476m2.type != 4 && c41476m4.type != 4) {
            if (c17368f.f3619iF[1] == C17370a.FIXED || (i3 != 0 && c17368f.f3638iZ == 8)) {
                if (c17368f.f3657iw.f5032hy == null && c17368f.f3659iy.f5032hy == null) {
                    c41476m2.type = 1;
                    c41476m4.type = 1;
                    if (i4 != 0) {
                        c41476m4.mo66149a(c41476m2, 1, c17368f.mo31458aN());
                    } else {
                        c41476m4.mo66151b(c41476m2, c17368f.getHeight());
                    }
                    if (c17368f.f3660iz.f5032hy != null) {
                        c17368f.f3660iz.f5029hv.type = 1;
                        c41476m2.mo66148a(c17368f.f3660iz.f5029hv, -c17368f.f3631iR);
                    }
                } else if (c17368f.f3657iw.f5032hy != null && c17368f.f3659iy.f5032hy == null) {
                    c41476m2.type = 1;
                    c41476m4.type = 1;
                    if (i4 != 0) {
                        c41476m4.mo66149a(c41476m2, 1, c17368f.mo31458aN());
                    } else {
                        c41476m4.mo66151b(c41476m2, c17368f.getHeight());
                    }
                    if (c17368f.f3631iR > 0) {
                        c17368f.f3660iz.f5029hv.mo66148a(c41476m2, c17368f.f3631iR);
                    }
                } else if (c17368f.f3657iw.f5032hy == null && c17368f.f3659iy.f5032hy != null) {
                    c41476m2.type = 1;
                    c41476m4.type = 1;
                    if (i4 != 0) {
                        c41476m2.mo66149a(c41476m4, -1, c17368f.mo31458aN());
                    } else {
                        c41476m2.mo66151b(c41476m4, -c17368f.getHeight());
                    }
                    if (c17368f.f3631iR > 0) {
                        c17368f.f3660iz.f5029hv.mo66148a(c41476m2, c17368f.f3631iR);
                    }
                } else if (c17368f.f3657iw.f5032hy != null && c17368f.f3659iy.f5032hy != null) {
                    c41476m2.type = 2;
                    c41476m4.type = 2;
                    if (i4 != 0) {
                        c41476m2.mo66152b(c41476m4, -1, c17368f.mo31458aN());
                        c41476m4.mo66152b(c41476m2, 1, c17368f.mo31458aN());
                        c17368f.mo31458aN().mo42142a(c41476m2);
                        c17368f.mo31457aM().mo42142a(c41476m4);
                    } else {
                        c41476m2.mo66150b(c41476m4, (float) (-c17368f.getHeight()));
                        c41476m4.mo66150b(c41476m2, (float) c17368f.getHeight());
                    }
                    if (c17368f.f3631iR > 0) {
                        c17368f.f3660iz.f5029hv.mo66148a(c41476m2, c17368f.f3631iR);
                    }
                }
            } else if (i3 != 0) {
                i3 = c17368f.getHeight();
                c41476m2.type = 1;
                c41476m4.type = 1;
                if (c17368f.f3657iw.f5032hy == null && c17368f.f3659iy.f5032hy == null) {
                    if (i4 != 0) {
                        c41476m4.mo66149a(c41476m2, 1, c17368f.mo31458aN());
                    } else {
                        c41476m4.mo66151b(c41476m2, i3);
                    }
                } else if (c17368f.f3657iw.f5032hy == null || c17368f.f3659iy.f5032hy != null) {
                    if (c17368f.f3657iw.f5032hy != null || c17368f.f3659iy.f5032hy == null) {
                        if (c17368f.f3657iw.f5032hy != null && c17368f.f3659iy.f5032hy != null) {
                            if (i4 != 0) {
                                c17368f.mo31458aN().mo42142a(c41476m2);
                                c17368f.mo31457aM().mo42142a(c41476m4);
                            }
                            if (c17368f.f3621iH == 0.0f) {
                                c41476m2.type = 3;
                                c41476m4.type = 3;
                                c41476m2.mo66150b(c41476m4, 0.0f);
                                c41476m4.mo66150b(c41476m2, 0.0f);
                                return;
                            }
                            c41476m2.type = 2;
                            c41476m4.type = 2;
                            c41476m2.mo66150b(c41476m4, (float) (-i3));
                            c41476m4.mo66150b(c41476m2, (float) i3);
                            c17368f.setHeight(i3);
                            if (c17368f.f3631iR > 0) {
                                c17368f.f3660iz.f5029hv.mo66148a(c41476m2, c17368f.f3631iR);
                            }
                        }
                    } else if (i4 != 0) {
                        c41476m2.mo66149a(c41476m4, -1, c17368f.mo31458aN());
                    } else {
                        c41476m2.mo66151b(c41476m4, -i3);
                    }
                } else if (i4 != 0) {
                    c41476m4.mo66149a(c41476m2, 1, c17368f.mo31458aN());
                } else {
                    c41476m4.mo66151b(c41476m2, i3);
                }
            }
        }
    }

    /* renamed from: a */
    static boolean m72391a(C17377e c17377e, int i, int i2, C37094d c37094d) {
        Object obj;
        Object obj2;
        Object obj3;
        float width;
        C17368f c17368f = c37094d.f15639hf;
        C17368f c17368f2 = c37094d.f15641hh;
        C17368f c17368f3 = c37094d.f15640hg;
        C17368f c17368f4 = c37094d.f15642hi;
        C17368f c17368f5 = c37094d.f15643hj;
        Object obj4 = null;
        int i3 = 0;
        float f = c37094d.f15649hp;
        C17370a c17370a = C17370a.WRAP_CONTENT;
        if (i == 0) {
            obj = c17368f5.f3667jg == 0 ? 1 : null;
            obj2 = c17368f5.f3667jg == 1 ? 1 : null;
            obj3 = c17368f5.f3667jg == 2 ? 1 : null;
        } else {
            obj = c17368f5.f3668jh == 0 ? 1 : null;
            obj2 = c17368f5.f3668jh == 1 ? 1 : null;
            obj3 = c17368f5.f3668jh == 2 ? 1 : null;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i4 = 0;
        C17368f c17368f6 = c17368f;
        while (obj4 == null) {
            int i5;
            C17368f c17368f7;
            if (c17368f6.f3638iZ != 8) {
                i5 = i4 + 1;
                if (i == 0) {
                    width = ((float) c17368f6.getWidth()) + f2;
                } else {
                    width = ((float) c17368f6.getHeight()) + f2;
                }
                if (c17368f6 != c17368f3) {
                    width += (float) c17368f6.f3617iD[i2].mo42138aH();
                }
                if (c17368f6 != c17368f4) {
                    width += (float) c17368f6.f3617iD[i2 + 1].mo42138aH();
                }
                f3 = (f3 + ((float) c17368f6.f3617iD[i2].mo42138aH())) + ((float) c17368f6.f3617iD[i2 + 1].mo42138aH());
                f2 = width;
            } else {
                i5 = i4;
            }
            if (c17368f6.f3638iZ != 8 && c17368f6.f3619iF[i] == C17370a.MATCH_CONSTRAINT) {
                i4 = i3 + 1;
                if (i == 0) {
                    if (c17368f6.f3640ib != 0) {
                        return false;
                    }
                    if (!(c17368f6.f3643if == 0 && c17368f6.f3644ig == 0)) {
                        return false;
                    }
                } else if (c17368f6.f3641ic != 0) {
                    return false;
                } else {
                    if (!(c17368f6.f3646ii == 0 && c17368f6.f3647ij == 0)) {
                        return false;
                    }
                }
                if (c17368f6.f3621iH != 0.0f) {
                    return false;
                }
                i3 = i4;
            }
            C25284e c25284e = c17368f6.f3617iD[i2 + 1].f5032hy;
            if (c25284e != null) {
                c17368f7 = c25284e.f5030hw;
                if (c17368f7.f3617iD[i2].f5032hy == null || c17368f7.f3617iD[i2].f5032hy.f5030hw != c17368f6) {
                    c17368f7 = null;
                }
            } else {
                c17368f7 = null;
            }
            if (c17368f7 != null) {
                i4 = i5;
                c17368f6 = c17368f7;
            } else {
                obj4 = 1;
                i4 = i5;
            }
        }
        C41476m c41476m = c17368f.f3617iD[i2].f5029hv;
        C41476m c41476m2 = c17368f2.f3617iD[i2 + 1].f5029hv;
        if (c41476m.f16640kk == null || c41476m2.f16640kk == null) {
            return false;
        }
        if (c41476m.f16640kk.state != 1 || c41476m2.f16640kk.state != 1) {
            return false;
        }
        if (i3 > 0 && i3 != i4) {
            return false;
        }
        float f4 = 0.0f;
        if (!(obj3 == null && obj == null && obj2 == null)) {
            if (c17368f3 != null) {
                f4 = (float) c17368f3.f3617iD[i2].mo42138aH();
            }
            if (c17368f4 != null) {
                f4 += (float) c17368f4.f3617iD[i2 + 1].mo42138aH();
            }
        }
        float f5 = c41476m.f16640kk.f16642km;
        float f6 = c41476m2.f16640kk.f16642km;
        if (f5 < f6) {
            f6 = (f6 - f5) - f2;
        } else {
            f6 = (f5 - f6) - f2;
        }
        float f7;
        float f8;
        C41477f c41477f;
        if (i3 <= 0 || i3 != i4) {
            Object obj5;
            Object obj6;
            if (f6 < 0.0f) {
                obj3 = 1;
                obj5 = null;
                obj6 = null;
            } else {
                obj5 = obj2;
                obj6 = obj;
            }
            if (obj3 != null) {
                f7 = f6 - f4;
                if (i == 0) {
                    f8 = c17368f.f3634iV;
                } else if (i == 1) {
                    f8 = c17368f.f3635iW;
                } else {
                    f8 = -1.0f;
                }
                f7 = f5 + (f8 * f7);
                while (c17368f != null) {
                    if (C17377e.f3712gb != null) {
                        c41477f = C17377e.f3712gb;
                        c41477f.f16653gE--;
                        c41477f = C17377e.f3712gb;
                        c41477f.f16674gv++;
                        c41477f = C17377e.f3712gb;
                        c41477f.f16650gB++;
                    }
                    c17368f5 = c17368f.f3673jm[i];
                    if (c17368f5 != null || c17368f == c17368f2) {
                        if (i == 0) {
                            f8 = (float) c17368f.getWidth();
                        } else {
                            f8 = (float) c17368f.getHeight();
                        }
                        f7 += (float) c17368f.f3617iD[i2].mo42138aH();
                        c17368f.f3617iD[i2].f5029hv.mo66147a(c41476m.f16641kl, f7);
                        c17368f.f3617iD[i2 + 1].f5029hv.mo66147a(c41476m.f16641kl, f7 + f8);
                        c17368f.f3617iD[i2].f5029hv.mo66153c(c17377e);
                        c17368f.f3617iD[i2 + 1].f5029hv.mo66153c(c17377e);
                        f8 = (f8 + f7) + ((float) c17368f.f3617iD[i2 + 1].mo42138aH());
                    } else {
                        f8 = f7;
                    }
                    f7 = f8;
                    c17368f = c17368f5;
                }
            } else if (!(obj6 == null && obj5 == null)) {
                if (obj6 != null) {
                    f7 = f6 - f4;
                } else if (obj5 != null) {
                    f7 = f6 - f4;
                } else {
                    f7 = f6;
                }
                f8 = f7 / ((float) (i4 + 1));
                if (obj5 != null) {
                    if (i4 > 1) {
                        f8 = f7 / ((float) (i4 - 1));
                    } else {
                        f8 = f7 / 2.0f;
                    }
                }
                if (c17368f.f3638iZ != 8) {
                    f7 = f5 + f8;
                } else {
                    f7 = f5;
                }
                if (obj5 != null && i4 > 1) {
                    f7 = ((float) c17368f3.f3617iD[i2].mo42138aH()) + f5;
                }
                if (obj6 == null || c17368f3 == null) {
                    c17368f5 = c17368f;
                } else {
                    f7 += (float) c17368f3.f3617iD[i2].mo42138aH();
                    c17368f5 = c17368f;
                }
                while (c17368f5 != null) {
                    if (C17377e.f3712gb != null) {
                        C41477f c41477f2 = C17377e.f3712gb;
                        c41477f2.f16653gE--;
                        c41477f2 = C17377e.f3712gb;
                        c41477f2.f16674gv++;
                        c41477f2 = C17377e.f3712gb;
                        c41477f2.f16650gB++;
                    }
                    C17368f c17368f8 = c17368f5.f3673jm[i];
                    if (c17368f8 != null || c17368f5 == c17368f2) {
                        if (i == 0) {
                            f4 = (float) c17368f5.getWidth();
                        } else {
                            f4 = (float) c17368f5.getHeight();
                        }
                        if (c17368f5 != c17368f3) {
                            f7 += (float) c17368f5.f3617iD[i2].mo42138aH();
                        }
                        c17368f5.f3617iD[i2].f5029hv.mo66147a(c41476m.f16641kl, f7);
                        c17368f5.f3617iD[i2 + 1].f5029hv.mo66147a(c41476m.f16641kl, f7 + f4);
                        c17368f5.f3617iD[i2].f5029hv.mo66153c(c17377e);
                        c17368f5.f3617iD[i2 + 1].f5029hv.mo66153c(c17377e);
                        f7 += ((float) c17368f5.f3617iD[i2 + 1].mo42138aH()) + f4;
                        if (!(c17368f8 == null || c17368f8.f3638iZ == 8)) {
                            f7 += f8;
                        }
                    }
                    c17368f5 = c17368f8;
                }
            }
            return true;
        } else if (c17368f6.f3620iG != null && c17368f6.f3620iG.f3619iF[i] == C17370a.WRAP_CONTENT) {
            return false;
        } else {
            width = (f6 + f2) - f3;
            f7 = f5;
            while (c17368f != null) {
                if (C17377e.f3712gb != null) {
                    c41477f = C17377e.f3712gb;
                    c41477f.f16653gE--;
                    c41477f = C17377e.f3712gb;
                    c41477f.f16674gv++;
                    c41477f = C17377e.f3712gb;
                    c41477f.f16650gB++;
                }
                c17368f5 = c17368f.f3673jm[i];
                if (c17368f5 != null || c17368f == c17368f2) {
                    f8 = width / ((float) i3);
                    if (f > 0.0f) {
                        if (c17368f.f3671jk[i] == -1.0f) {
                            f8 = 0.0f;
                        } else {
                            f8 = (c17368f.f3671jk[i] * width) / f;
                        }
                    }
                    if (c17368f.f3638iZ == 8) {
                        f8 = 0.0f;
                    }
                    f7 += (float) c17368f.f3617iD[i2].mo42138aH();
                    c17368f.f3617iD[i2].f5029hv.mo66147a(c41476m.f16641kl, f7);
                    c17368f.f3617iD[i2 + 1].f5029hv.mo66147a(c41476m.f16641kl, f7 + f8);
                    c17368f.f3617iD[i2].f5029hv.mo66153c(c17377e);
                    c17368f.f3617iD[i2 + 1].f5029hv.mo66153c(c17377e);
                    f8 = (f8 + f7) + ((float) c17368f.f3617iD[i2 + 1].mo42138aH());
                } else {
                    f8 = f7;
                }
                c17368f = c17368f5;
                f7 = f8;
            }
            return true;
        }
    }

    /* renamed from: b */
    static void m72392b(C17368f c17368f, int i, int i2) {
        int i3 = i * 2;
        int i4 = i3 + 1;
        c17368f.f3617iD[i3].f5029hv.f16641kl = c17368f.f3620iG.f3656iu.f5029hv;
        c17368f.f3617iD[i3].f5029hv.f16642km = (float) i2;
        c17368f.f3617iD[i3].f5029hv.state = 1;
        c17368f.f3617iD[i4].f5029hv.f16641kl = c17368f.f3617iD[i3].f5029hv;
        c17368f.f3617iD[i4].f5029hv.f16642km = (float) c17368f.mo31493v(i);
        c17368f.f3617iD[i4].f5029hv.state = 1;
    }
}
