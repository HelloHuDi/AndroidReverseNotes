package android.support.constraint.p780a.p781a;

import android.support.constraint.p780a.C17377e;
import android.support.constraint.p780a.C41477f;
import android.support.constraint.p780a.p781a.C17368f.C17370a;
import android.support.constraint.p780a.p781a.C17373p.C8313a;
import android.support.constraint.p780a.p781a.C25284e.C25285b;
import android.support.constraint.p780a.p781a.C25284e.C25287c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: android.support.constraint.a.a.g */
public final class C31242g extends C25289q {
    /* renamed from: dl */
    public int f14370dl = 7;
    /* renamed from: hq */
    public boolean f14371hq = false;
    /* renamed from: jA */
    int f14372jA;
    /* renamed from: jB */
    int f14373jB = 0;
    /* renamed from: jC */
    int f14374jC = 0;
    /* renamed from: jD */
    C37094d[] f14375jD = new C37094d[4];
    /* renamed from: jE */
    C37094d[] f14376jE = new C37094d[4];
    /* renamed from: jF */
    public List<C17371h> f14377jF = new ArrayList();
    /* renamed from: jG */
    public boolean f14378jG = false;
    /* renamed from: jH */
    public boolean f14379jH = false;
    /* renamed from: jI */
    public boolean f14380jI = false;
    /* renamed from: jJ */
    public int f14381jJ = 0;
    /* renamed from: jK */
    public int f14382jK = 0;
    /* renamed from: jL */
    public boolean f14383jL = false;
    /* renamed from: jM */
    public boolean f14384jM = false;
    /* renamed from: jN */
    public boolean f14385jN = false;
    /* renamed from: jO */
    int f14386jO = 0;
    /* renamed from: jv */
    protected C17377e f14387jv = new C17377e();
    /* renamed from: jw */
    private C17373p f14388jw;
    /* renamed from: jx */
    int f14389jx;
    /* renamed from: jy */
    int f14390jy;
    /* renamed from: jz */
    int f14391jz;

    /* renamed from: z */
    public final boolean mo51199z(int i) {
        return (this.f14370dl & i) == i;
    }

    public final void reset() {
        this.f14387jv.reset();
        this.f14389jx = 0;
        this.f14391jz = 0;
        this.f14390jy = 0;
        this.f14372jA = 0;
        this.f14377jF.clear();
        this.f14383jL = false;
        super.reset();
    }

    /* renamed from: u */
    public final void mo31492u(int i) {
        super.mo31492u(i);
        int size = this.f5052kx.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((C17368f) this.f5052kx.get(i2)).mo31492u(i);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:144:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0457 A:{SYNTHETIC, EDGE_INSN: B:260:0x0457->B:168:0x0457 ?: BREAK  , EDGE_INSN: B:260:0x0457->B:168:0x0457 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x040e A:{LOOP_END, LOOP:10: B:159:0x040a->B:161:0x040e} */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x063c  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x02f2  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03ce  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x040e A:{LOOP_END, LOOP:10: B:159:0x040a->B:161:0x040e} */
    /* JADX WARNING: Removed duplicated region for block: B:260:0x0457 A:{SYNTHETIC, EDGE_INSN: B:260:0x0457->B:168:0x0457 ?: BREAK  , EDGE_INSN: B:260:0x0457->B:168:0x0457 ?: BREAK  , EDGE_INSN: B:260:0x0457->B:168:0x0457 ?: BREAK  } */
    /* JADX WARNING: Removed duplicated region for block: B:170:0x046d  */
    /* JADX WARNING: Removed duplicated region for block: B:175:0x048a  */
    /* JADX WARNING: Removed duplicated region for block: B:180:0x04b2  */
    /* JADX WARNING: Removed duplicated region for block: B:183:0x04d4  */
    /* JADX WARNING: Removed duplicated region for block: B:223:0x063f  */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x04e6  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x063c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: aZ */
    public final void mo42147aZ() {
        int i;
        Object obj;
        Object obj2;
        C17368f c17368f;
        int i2;
        Object obj3;
        int i3 = this.f3623iJ;
        int i4 = this.f3624iK;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.f14384jM = false;
        this.f14385jN = false;
        if (this.f3620iG != null) {
            if (this.f14388jw == null) {
                this.f14388jw = new C17373p(this);
            }
            C17373p c17373p = this.f14388jw;
            c17373p.f3694iJ = getX();
            c17373p.f3695iK = getY();
            c17373p.mWidth = getWidth();
            c17373p.mHeight = getHeight();
            int size = c17373p.f3696ku.size();
            for (i = 0; i < size; i++) {
                C8313a c8313a = (C8313a) c17373p.f3696ku.get(i);
                c8313a.f2154kc = mo31445a(c8313a.f2154kc.f5031hx);
                if (c8313a.f2154kc != null) {
                    c8313a.f2152hy = c8313a.f2154kc.f5032hy;
                    c8313a.f2153hz = c8313a.f2154kc.mo42138aH();
                    c8313a.f2155kv = c8313a.f2154kc.f5025hB;
                    c8313a.f2156kw = c8313a.f2154kc.f5027hD;
                } else {
                    c8313a.f2152hy = null;
                    c8313a.f2153hz = 0;
                    c8313a.f2155kv = C25285b.STRONG;
                    c8313a.f2156kw = 0;
                }
            }
            setX(this.f14389jx);
            setY(this.f14390jy);
            mo31466aV();
            mo31448a(this.f14387jv.f3725fw);
        } else {
            this.f3623iJ = 0;
            this.f3624iK = 0;
        }
        if (this.f14370dl != 0) {
            if (!mo51199z(8)) {
                mo51197bb();
            }
            if (!mo51199z(32)) {
                if (!mo51199z(8)) {
                    mo31492u(this.f14370dl);
                }
                mo51196ba();
            }
            this.f14387jv.f3719fU = true;
        } else {
            this.f14387jv.f3719fU = false;
        }
        Object obj4 = null;
        C17370a c17370a = this.f3619iF[1];
        C17370a c17370a2 = this.f3619iF[0];
        m50393bc();
        if (this.f14377jF.size() == 0) {
            this.f14377jF.clear();
            this.f14377jF.add(0, new C17371h(this.f5052kx));
        }
        int size2 = this.f14377jF.size();
        ArrayList arrayList = this.f5052kx;
        if (mo31467aW() == C17370a.WRAP_CONTENT || mo31468aX() == C17370a.WRAP_CONTENT) {
            obj = 1;
        } else {
            obj = null;
        }
        int i5 = 0;
        while (i5 < size2 && !this.f14383jL) {
            if (((C17371h) this.f14377jF.get(i5)).f3683jL) {
                obj2 = obj4;
            } else {
                C17371h c17371h;
                int size3;
                int i6;
                C17368f c17368f2;
                if (mo51199z(32)) {
                    if (mo31467aW() == C17370a.FIXED && mo31468aX() == C17370a.FIXED) {
                        List list;
                        c17371h = (C17371h) this.f14377jF.get(i5);
                        if (c17371h.f3692jX.isEmpty()) {
                            size3 = c17371h.f3684jP.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                c17368f = (C17368f) c17371h.f3684jP.get(i6);
                                if (!c17368f.f3664jd) {
                                    c17371h.mo31497a((ArrayList) c17371h.f3692jX, c17368f);
                                }
                            }
                            c17371h.f3693jY.clear();
                            c17371h.f3693jY.addAll(c17371h.f3684jP);
                            c17371h.f3693jY.removeAll(c17371h.f3692jX);
                            list = c17371h.f3692jX;
                        } else {
                            list = c17371h.f3692jX;
                        }
                        this.f5052kx = (ArrayList) list;
                    } else {
                        this.f5052kx = (ArrayList) ((C17371h) this.f14377jF.get(i5)).f3684jP;
                    }
                }
                m50393bc();
                int size4 = this.f5052kx.size();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= size4) {
                        break;
                    }
                    c17368f2 = (C17368f) this.f5052kx.get(i8);
                    if (c17368f2 instanceof C25289q) {
                        ((C25289q) c17368f2).mo42147aZ();
                    }
                    i7 = i8 + 1;
                }
                Object obj5 = 1;
                size3 = 0;
                obj2 = obj4;
                while (obj5 != null) {
                    int size5;
                    Object obj6;
                    i2 = size3 + 1;
                    try {
                        this.f14387jv.reset();
                        m50393bc();
                        mo31471b(this.f14387jv);
                        for (i = 0; i < size4; i++) {
                            ((C17368f) this.f5052kx.get(i)).mo31471b(this.f14387jv);
                        }
                        C17377e c17377e = this.f14387jv;
                        mo31449a(c17377e);
                        size5 = this.f5052kx.size();
                        for (i = 0; i < size5; i++) {
                            c17368f2 = (C17368f) this.f5052kx.get(i);
                            if (c17368f2 instanceof C31242g) {
                                C17370a c17370a3 = c17368f2.f3619iF[0];
                                C17370a c17370a4 = c17368f2.f3619iF[1];
                                if (c17370a3 == C17370a.WRAP_CONTENT) {
                                    c17368f2.mo31447a(C17370a.FIXED);
                                }
                                if (c17370a4 == C17370a.WRAP_CONTENT) {
                                    c17368f2.mo31470b(C17370a.FIXED);
                                }
                                c17368f2.mo31449a(c17377e);
                                if (c17370a3 == C17370a.WRAP_CONTENT) {
                                    c17368f2.mo31447a(c17370a3);
                                }
                                if (c17370a4 == C17370a.WRAP_CONTENT) {
                                    c17368f2.mo31470b(c17370a4);
                                }
                            } else {
                                C41474k.m72390a(this, c17377e, c17368f2);
                                c17368f2.mo31449a(c17377e);
                            }
                        }
                        if (this.f14373jB > 0) {
                            C44943c.m82168a(this, c17377e, 0);
                        }
                        if (this.f14374jC > 0) {
                            C44943c.m82168a(this, c17377e, 1);
                        }
                        obj3 = 1;
                        try {
                            C41477f c41477f;
                            c17377e = this.f14387jv;
                            if (C17377e.f3712gb != null) {
                                c41477f = C17377e.f3712gb;
                                c41477f.f16660gh++;
                            }
                            if (c17377e.f3719fU) {
                                if (C17377e.f3712gb != null) {
                                    c41477f = C17377e.f3712gb;
                                    c41477f.f16673gu++;
                                }
                                obj6 = 1;
                                for (i6 = 0; i6 < c17377e.f3721fW; i6++) {
                                    if (!c17377e.f3718fT[i6].f15474fJ) {
                                        obj6 = null;
                                        break;
                                    }
                                }
                                if (obj6 == null) {
                                    c17377e.mo31522b(c17377e.f3715fQ);
                                } else {
                                    if (C17377e.f3712gb != null) {
                                        c41477f = C17377e.f3712gb;
                                        c41477f.f16672gt++;
                                    }
                                    c17377e.mo31520az();
                                }
                            } else {
                                c17377e.mo31522b(c17377e.f3715fQ);
                            }
                        } catch (Exception e) {
                            obj6 = e;
                            System.out.println("EXCEPTION : ".concat(String.valueOf(obj6)));
                            if (obj3 == null) {
                            }
                            obj3 = null;
                            size3 = 0;
                            size5 = 0;
                            i7 = 0;
                            while (true) {
                                i6 = i7;
                                if (i6 >= size4) {
                                }
                                c17368f2 = (C17368f) this.f5052kx.get(i6);
                                size3 = Math.max(size3, c17368f2.f3623iJ + c17368f2.getWidth());
                                size5 = Math.max(size5, c17368f2.getHeight() + c17368f2.f3624iK);
                                i7 = i6 + 1;
                            }
                            i7 = Math.max(this.f3609dg, size3);
                            i6 = Math.max(this.f3610dh, size5);
                            if (c17370a2 == C17370a.WRAP_CONTENT) {
                            }
                            obj6 = null;
                            if (c17370a == C17370a.WRAP_CONTENT) {
                            }
                            obj3 = obj6;
                            i7 = Math.max(this.f3609dg, getWidth());
                            if (i7 > getWidth()) {
                            }
                            i7 = Math.max(this.f3610dh, getHeight());
                            if (i7 > getHeight()) {
                            }
                            if (obj2 == null) {
                            }
                            obj5 = obj6;
                            size3 = i2;
                            obj2 = obj3;
                        }
                    } catch (Exception e2) {
                        obj6 = e2;
                        obj3 = obj5;
                        System.out.println("EXCEPTION : ".concat(String.valueOf(obj6)));
                        if (obj3 == null) {
                        }
                        obj3 = null;
                        size3 = 0;
                        size5 = 0;
                        i7 = 0;
                        while (true) {
                            i6 = i7;
                            if (i6 >= size4) {
                            }
                            c17368f2 = (C17368f) this.f5052kx.get(i6);
                            size3 = Math.max(size3, c17368f2.f3623iJ + c17368f2.getWidth());
                            size5 = Math.max(size5, c17368f2.getHeight() + c17368f2.f3624iK);
                            i7 = i6 + 1;
                        }
                        i7 = Math.max(this.f3609dg, size3);
                        i6 = Math.max(this.f3610dh, size5);
                        if (c17370a2 == C17370a.WRAP_CONTENT) {
                        }
                        obj6 = null;
                        if (c17370a == C17370a.WRAP_CONTENT) {
                        }
                        obj3 = obj6;
                        i7 = Math.max(this.f3609dg, getWidth());
                        if (i7 > getWidth()) {
                        }
                        i7 = Math.max(this.f3610dh, getHeight());
                        if (i7 > getHeight()) {
                        }
                        if (obj2 == null) {
                        }
                        obj5 = obj6;
                        size3 = i2;
                        obj2 = obj3;
                    }
                    if (obj3 == null) {
                        mo31469aY();
                        i7 = 0;
                        while (true) {
                            i = i7;
                            if (i >= size4) {
                                break;
                            }
                            c17368f2 = (C17368f) this.f5052kx.get(i);
                            if (c17368f2.f3619iF[0] != C17370a.MATCH_CONSTRAINT || c17368f2.getWidth() >= c17368f2.f3632iS) {
                                if (c17368f2.f3619iF[1] == C17370a.MATCH_CONSTRAINT && c17368f2.getHeight() < c17368f2.f3633iT) {
                                    C41474k.f16637ki[2] = true;
                                    break;
                                }
                                i7 = i + 1;
                            } else {
                                C41474k.f16637ki[2] = true;
                                break;
                            }
                        }
                    }
                    boolean[] zArr = C41474k.f16637ki;
                    zArr[2] = false;
                    mo31469aY();
                    size3 = this.f5052kx.size();
                    for (i = 0; i < size3; i++) {
                        c17368f2 = (C17368f) this.f5052kx.get(i);
                        c17368f2.mo31469aY();
                        if (c17368f2.f3619iF[0] == C17370a.MATCH_CONSTRAINT && c17368f2.getWidth() < c17368f2.f3632iS) {
                            zArr[2] = true;
                        }
                        if (c17368f2.f3619iF[1] == C17370a.MATCH_CONSTRAINT && c17368f2.getHeight() < c17368f2.f3633iT) {
                            zArr[2] = true;
                        }
                    }
                    obj3 = null;
                    if (obj != null && i2 < 8 && C41474k.f16637ki[2]) {
                        size3 = 0;
                        size5 = 0;
                        i7 = 0;
                        while (true) {
                            i6 = i7;
                            if (i6 >= size4) {
                                break;
                            }
                            c17368f2 = (C17368f) this.f5052kx.get(i6);
                            size3 = Math.max(size3, c17368f2.f3623iJ + c17368f2.getWidth());
                            size5 = Math.max(size5, c17368f2.getHeight() + c17368f2.f3624iK);
                            i7 = i6 + 1;
                        }
                        i7 = Math.max(this.f3609dg, size3);
                        i6 = Math.max(this.f3610dh, size5);
                        if (c17370a2 == C17370a.WRAP_CONTENT || getWidth() >= i7) {
                            obj6 = null;
                        } else {
                            setWidth(i7);
                            this.f3619iF[0] = C17370a.WRAP_CONTENT;
                            obj6 = 1;
                            obj2 = 1;
                        }
                        if (c17370a == C17370a.WRAP_CONTENT || getHeight() >= i6) {
                            obj3 = obj6;
                        } else {
                            setHeight(i6);
                            this.f3619iF[1] = C17370a.WRAP_CONTENT;
                            obj2 = 1;
                            obj3 = 1;
                        }
                    }
                    i7 = Math.max(this.f3609dg, getWidth());
                    if (i7 > getWidth()) {
                        setWidth(i7);
                        this.f3619iF[0] = C17370a.FIXED;
                        obj2 = 1;
                        obj3 = 1;
                    }
                    i7 = Math.max(this.f3610dh, getHeight());
                    if (i7 > getHeight()) {
                        setHeight(i7);
                        this.f3619iF[1] = C17370a.FIXED;
                        obj2 = 1;
                        obj6 = 1;
                    } else {
                        obj6 = obj3;
                    }
                    if (obj2 == null) {
                        if (this.f3619iF[0] != C17370a.WRAP_CONTENT || max <= 0 || getWidth() <= max) {
                            obj3 = obj2;
                        } else {
                            this.f14384jM = true;
                            obj3 = 1;
                            this.f3619iF[0] = C17370a.FIXED;
                            setWidth(max);
                            obj6 = 1;
                        }
                        if (this.f3619iF[1] == C17370a.WRAP_CONTENT && max2 > 0 && getHeight() > max2) {
                            this.f14385jN = true;
                            obj3 = 1;
                            this.f3619iF[1] = C17370a.FIXED;
                            setHeight(max2);
                            obj6 = 1;
                        }
                    } else {
                        obj3 = obj2;
                    }
                    obj5 = obj6;
                    size3 = i2;
                    obj2 = obj3;
                }
                c17371h = (C17371h) this.f14377jF.get(i5);
                size3 = c17371h.f3693jY.size();
                for (i6 = 0; i6 < size3; i6++) {
                    c17371h.mo31499d((C17368f) c17371h.f3693jY.get(i6));
                }
            }
            i5++;
            obj4 = obj2;
        }
        this.f5052kx = arrayList;
        if (this.f3620iG != null) {
            i5 = Math.max(this.f3609dg, getWidth());
            i3 = Math.max(this.f3610dh, getHeight());
            C17373p c17373p2 = this.f14388jw;
            setX(c17373p2.f3694iJ);
            setY(c17373p2.f3695iK);
            setWidth(c17373p2.mWidth);
            setHeight(c17373p2.mHeight);
            max = c17373p2.f3696ku.size();
            for (i2 = 0; i2 < max; i2++) {
                C8313a c8313a2 = (C8313a) c17373p2.f3696ku.get(i2);
                mo31445a(c8313a2.f2154kc.f5031hx).mo42136a(c8313a2.f2152hy, c8313a2.f2153hz, -1, c8313a2.f2155kv, c8313a2.f2156kw, false);
            }
            setWidth((this.f14389jx + i5) + this.f14391jz);
            setHeight((this.f14390jy + i3) + this.f14372jA);
        } else {
            this.f3623iJ = i3;
            this.f3624iK = i4;
        }
        if (obj4 != null) {
            this.f3619iF[0] = c17370a2;
            this.f3619iF[1] = c17370a;
        }
        mo31448a(this.f14387jv.f3725fw);
        c17368f = this.f3620iG;
        C31242g c31242g = this;
        while (c17368f != null) {
            C17368f c17368f3 = c17368f.f3620iG;
            if (c17368f instanceof C31242g) {
                c31242g = (C31242g) c17368f;
                c17368f = c17368f3;
            } else {
                c17368f = c17368f3;
            }
        }
        if (this == c31242g) {
            mo31465aU();
        }
    }

    /* renamed from: ba */
    public final void mo51196ba() {
        C41476m c41476m = mo31445a(C25287c.LEFT).f5029hv;
        C41476m c41476m2 = mo31445a(C25287c.TOP).f5029hv;
        c41476m.mo66147a(null, 0.0f);
        c41476m2.mo66147a(null, 0.0f);
    }

    /* renamed from: j */
    public final void mo51198j(int i, int i2) {
        if (!(this.f3619iF[0] == C17370a.WRAP_CONTENT || this.f3613hZ == null)) {
            this.f3613hZ.mo31500E(i);
        }
        if (this.f3619iF[1] != C17370a.WRAP_CONTENT && this.f3639ia != null) {
            this.f3639ia.mo31500E(i2);
        }
    }

    /* renamed from: bb */
    public final void mo51197bb() {
        int size = this.f5052kx.size();
        mo31451aD();
        for (int i = 0; i < size; i++) {
            ((C17368f) this.f5052kx.get(i)).mo31451aD();
        }
    }

    /* renamed from: bc */
    private void m50393bc() {
        this.f14373jB = 0;
        this.f14374jC = 0;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: b */
    public final void mo51195b(C17368f c17368f, int i) {
        if (i == 0) {
            m50392b(c17368f);
        } else if (i == 1) {
            m50394c(c17368f);
        }
    }

    /* renamed from: b */
    private void m50392b(C17368f c17368f) {
        if (this.f14373jB + 1 >= this.f14376jE.length) {
            this.f14376jE = (C37094d[]) Arrays.copyOf(this.f14376jE, this.f14376jE.length * 2);
        }
        this.f14376jE[this.f14373jB] = new C37094d(c17368f, 0, this.f14371hq);
        this.f14373jB++;
    }

    /* renamed from: c */
    private void m50394c(C17368f c17368f) {
        if (this.f14374jC + 1 >= this.f14375jD.length) {
            this.f14375jD = (C37094d[]) Arrays.copyOf(this.f14375jD, this.f14375jD.length * 2);
        }
        this.f14375jD[this.f14374jC] = new C37094d(c17368f, 1, this.f14371hq);
        this.f14374jC++;
    }
}
