package android.support.constraint.p780a;

import android.support.constraint.p780a.C41479h.C41480a;
import android.support.constraint.p780a.p781a.C25284e;
import java.util.Arrays;
import java.util.HashMap;

/* renamed from: android.support.constraint.a.e */
public final class C17377e {
    /* renamed from: fN */
    private static int f3711fN = 1000;
    /* renamed from: gb */
    public static C41477f f3712gb;
    /* renamed from: fO */
    int f3713fO;
    /* renamed from: fP */
    private HashMap<String, C41479h> f3714fP;
    /* renamed from: fQ */
    public C17378a f3715fQ;
    /* renamed from: fR */
    private int f3716fR;
    /* renamed from: fS */
    private int f3717fS;
    /* renamed from: fT */
    public C36667b[] f3718fT;
    /* renamed from: fU */
    public boolean f3719fU;
    /* renamed from: fV */
    private boolean[] f3720fV;
    /* renamed from: fW */
    public int f3721fW;
    /* renamed from: fX */
    private int f3722fX;
    /* renamed from: fY */
    private C41479h[] f3723fY;
    /* renamed from: fZ */
    private int f3724fZ;
    /* renamed from: fw */
    public final C17375c f3725fw;
    /* renamed from: ga */
    private C36667b[] f3726ga;
    /* renamed from: gc */
    private final C17378a f3727gc;
    int mNumColumns;

    /* renamed from: android.support.constraint.a.e$a */
    interface C17378a {
        /* renamed from: a */
        C41479h mo31529a(boolean[] zArr);

        /* renamed from: a */
        void mo31530a(C17378a c17378a);

        /* renamed from: at */
        C41479h mo31531at();

        void clear();

        /* renamed from: e */
        void mo31513e(C41479h c41479h);
    }

    public C17377e() {
        this.f3713fO = 0;
        this.f3714fP = null;
        this.f3716fR = 32;
        this.f3717fS = this.f3716fR;
        this.f3718fT = null;
        this.f3719fU = false;
        this.f3720fV = new boolean[this.f3716fR];
        this.mNumColumns = 1;
        this.f3721fW = 0;
        this.f3722fX = this.f3716fR;
        this.f3723fY = new C41479h[f3711fN];
        this.f3724fZ = 0;
        this.f3726ga = new C36667b[this.f3716fR];
        this.f3718fT = new C36667b[this.f3716fR];
        m26936aw();
        this.f3725fw = new C17375c();
        this.f3715fQ = new C17376d(this.f3725fw);
        this.f3727gc = new C36667b(this.f3725fw);
    }

    /* renamed from: au */
    public static C41477f m26934au() {
        return f3712gb;
    }

    /* renamed from: av */
    private void m26935av() {
        this.f3716fR *= 2;
        this.f3718fT = (C36667b[]) Arrays.copyOf(this.f3718fT, this.f3716fR);
        this.f3725fw.f3710fM = (C41479h[]) Arrays.copyOf(this.f3725fw.f3710fM, this.f3716fR);
        this.f3720fV = new boolean[this.f3716fR];
        this.f3717fS = this.f3716fR;
        this.f3722fX = this.f3716fR;
        if (f3712gb != null) {
            C41477f c41477f = f3712gb;
            c41477f.f16659gg++;
            c41477f = f3712gb;
            c41477f.f16671gs = Math.max(c41477f.f16671gs, (long) this.f3716fR);
            c41477f = f3712gb;
            c41477f.f16655gG = c41477f.f16671gs;
        }
    }

    /* renamed from: aw */
    private void m26936aw() {
        for (int i = 0; i < this.f3718fT.length; i++) {
            Object obj = this.f3718fT[i];
            if (obj != null) {
                this.f3725fw.f3708fK.release(obj);
            }
            this.f3718fT[i] = null;
        }
    }

    public final void reset() {
        int i;
        for (C41479h c41479h : this.f3725fw.f3710fM) {
            if (c41479h != null) {
                c41479h.reset();
            }
        }
        this.f3725fw.f3709fL.mo18099b(this.f3723fY, this.f3724fZ);
        this.f3724fZ = 0;
        Arrays.fill(this.f3725fw.f3710fM, null);
        if (this.f3714fP != null) {
            this.f3714fP.clear();
        }
        this.f3713fO = 0;
        this.f3715fQ.clear();
        this.mNumColumns = 1;
        for (i = 0; i < this.f3721fW; i++) {
            this.f3718fT[i].f15472fH = false;
        }
        m26936aw();
        this.f3721fW = 0;
    }

    /* renamed from: g */
    public final C41479h mo31526g(Object obj) {
        C41479h c41479h = null;
        if (obj != null) {
            if (this.mNumColumns + 1 >= this.f3717fS) {
                m26935av();
            }
            if (obj instanceof C25284e) {
                c41479h = ((C25284e) obj).f5028hE;
                if (c41479h == null) {
                    ((C25284e) obj).mo42137aG();
                    c41479h = ((C25284e) obj).f5028hE;
                }
                if (c41479h.f16692id == -1 || c41479h.f16692id > this.f3713fO || this.f3725fw.f3710fM[c41479h.f16692id] == null) {
                    if (c41479h.f16692id != -1) {
                        c41479h.reset();
                    }
                    this.f3713fO++;
                    this.mNumColumns++;
                    c41479h.f16692id = this.f3713fO;
                    c41479h.f16688gS = C41480a.UNRESTRICTED;
                    this.f3725fw.f3710fM[this.f3713fO] = c41479h;
                }
            }
        }
        return c41479h;
    }

    /* renamed from: ax */
    public final C36667b mo31518ax() {
        C36667b c36667b = (C36667b) this.f3725fw.f3708fK.mo18098aA();
        if (c36667b == null) {
            c36667b = new C36667b(this.f3725fw);
        } else {
            c36667b.f15470fF = null;
            c36667b.f15473fI.clear();
            c36667b.f15471fG = 0.0f;
            c36667b.f15474fJ = false;
        }
        C41479h.m72403aB();
        return c36667b;
    }

    /* renamed from: ay */
    public final C41479h mo31519ay() {
        if (f3712gb != null) {
            C41477f c41477f = f3712gb;
            c41477f.f16669gq++;
        }
        if (this.mNumColumns + 1 >= this.f3717fS) {
            m26935av();
        }
        C41479h a = m26932a(C41480a.SLACK);
        this.f3713fO++;
        this.mNumColumns++;
        a.f16692id = this.f3713fO;
        this.f3725fw.f3710fM[this.f3713fO] = a;
        return a;
    }

    /* renamed from: a */
    public final void mo31514a(C36667b c36667b, int i, int i2) {
        c36667b.f15473fI.mo31506a(mo31528t(i2), (float) i);
    }

    /* renamed from: t */
    public final C41479h mo31528t(int i) {
        if (f3712gb != null) {
            C41477f c41477f = f3712gb;
            c41477f.f16668gp++;
        }
        if (this.mNumColumns + 1 >= this.f3717fS) {
            m26935av();
        }
        C41479h a = m26932a(C41480a.ERROR);
        this.f3713fO++;
        this.mNumColumns++;
        a.f16692id = this.f3713fO;
        a.f16685gP = i;
        this.f3725fw.f3710fM[this.f3713fO] = a;
        this.f3715fQ.mo31513e(a);
        return a;
    }

    /* renamed from: a */
    private C41479h m26932a(C41480a c41480a) {
        C41479h c41479h;
        C41479h c41479h2 = (C41479h) this.f3725fw.f3709fL.mo18098aA();
        if (c41479h2 == null) {
            c41479h2 = new C41479h(c41480a);
            c41479h2.f16688gS = c41480a;
            c41479h = c41479h2;
        } else {
            c41479h2.reset();
            c41479h2.f16688gS = c41480a;
            c41479h = c41479h2;
        }
        if (this.f3724fZ >= f3711fN) {
            f3711fN *= 2;
            this.f3723fY = (C41479h[]) Arrays.copyOf(this.f3723fY, f3711fN);
        }
        C41479h[] c41479hArr = this.f3723fY;
        int i = this.f3724fZ;
        this.f3724fZ = i + 1;
        c41479hArr[i] = c41479h;
        return c41479h;
    }

    /* renamed from: h */
    public static int m26939h(Object obj) {
        C41479h c41479h = ((C25284e) obj).f5028hE;
        if (c41479h != null) {
            return (int) (c41479h.f16686gQ + 0.5f);
        }
        return 0;
    }

    /* renamed from: b */
    public final void mo31522b(C17378a c17378a) {
        C41477f c41477f;
        Object obj;
        if (f3712gb != null) {
            c41477f = f3712gb;
            c41477f.f16675gw++;
            c41477f = f3712gb;
            c41477f.f16676gx = Math.max(c41477f.f16676gx, (long) this.mNumColumns);
            c41477f = f3712gb;
            c41477f.f16677gy = Math.max(c41477f.f16677gy, (long) this.f3721fW);
        }
        m26933a((C36667b) c17378a);
        int i = 0;
        while (i < this.f3721fW) {
            if (this.f3718fT[i].f15470fF.f16688gS != C41480a.UNRESTRICTED && this.f3718fT[i].f15471fG < 0.0f) {
                obj = 1;
                break;
            }
            i++;
        }
        obj = null;
        if (obj != null) {
            int i2 = 0;
            for (Object obj2 = null; obj2 == null; obj2 = obj) {
                if (f3712gb != null) {
                    c41477f = f3712gb;
                    c41477f.f16666gn++;
                }
                int i3 = i2 + 1;
                float f = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                i2 = -1;
                for (i = 0; i < this.f3721fW; i++) {
                    C36667b c36667b = this.f3718fT[i];
                    if (!(c36667b.f15470fF.f16688gS == C41480a.UNRESTRICTED || c36667b.f15474fJ || c36667b.f15471fG >= 0.0f)) {
                        int i6 = 1;
                        int i7 = i2;
                        int i8 = i5;
                        int i9 = i4;
                        float f2 = f;
                        while (i6 < this.mNumColumns) {
                            int i10;
                            C41479h c41479h = this.f3725fw.f3710fM[i6];
                            float b = c36667b.f15473fI.mo31508b(c41479h);
                            if (b > 0.0f) {
                                int i11 = 0;
                                i2 = i7;
                                i4 = i8;
                                i10 = i9;
                                while (i11 < 7) {
                                    float f3 = c41479h.f16687gR[i11] / b;
                                    if ((f3 >= f2 || i11 != r6) && i11 <= r6) {
                                        i5 = i4;
                                        f3 = f2;
                                    } else {
                                        i2 = i6;
                                        i5 = i;
                                        i10 = i11;
                                    }
                                    i11++;
                                    i4 = i5;
                                    f2 = f3;
                                }
                                i5 = i2;
                            } else {
                                i5 = i7;
                                i4 = i8;
                                i10 = i9;
                            }
                            i6++;
                            i7 = i5;
                            i8 = i4;
                            i9 = i10;
                        }
                        i2 = i7;
                        i5 = i8;
                        i4 = i9;
                        f = f2;
                    }
                }
                if (i5 != -1) {
                    C36667b c36667b2 = this.f3718fT[i5];
                    c36667b2.f15470fF.f16684gO = -1;
                    if (f3712gb != null) {
                        C41477f c41477f2 = f3712gb;
                        c41477f2.f16665gm++;
                    }
                    c36667b2.mo58533d(this.f3725fw.f3710fM[i2]);
                    c36667b2.f15470fF.f16684gO = i5;
                    c36667b2.f15470fF.mo66158f(c36667b2);
                    obj = obj2;
                } else {
                    obj = 1;
                }
                if (i3 > this.mNumColumns / 2) {
                    obj = 1;
                }
                i2 = i3;
            }
        }
        m26937c(c17378a);
        mo31520az();
    }

    /* renamed from: a */
    private final void m26933a(C36667b c36667b) {
        if (this.f3721fW > 0) {
            c36667b.f15473fI.mo31505a(c36667b, this.f3718fT);
            if (c36667b.f15473fI.f3702fu == 0) {
                c36667b.f15474fJ = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: b */
    public final void mo31521b(C36667b c36667b) {
        if (c36667b != null) {
            C41477f c41477f;
            Object obj;
            if (f3712gb != null) {
                c41477f = f3712gb;
                c41477f.f16661gi++;
                if (c36667b.f15474fJ) {
                    c41477f = f3712gb;
                    c41477f.f16662gj++;
                }
            }
            if (this.f3721fW + 1 >= this.f3722fX || this.mNumColumns + 1 >= this.f3717fS) {
                m26935av();
            }
            if (c36667b.f15474fJ) {
                obj = null;
            } else {
                m26933a(c36667b);
                if (c36667b.f15470fF == null && c36667b.f15471fG == 0.0f && c36667b.f15473fI.f3702fu == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    Object obj2;
                    if (c36667b.f15471fG < 0.0f) {
                        c36667b.f15471fG *= -1.0f;
                        C17374a c17374a = c36667b.f15473fI;
                        int i = c17374a.f3699fC;
                        int i2 = 0;
                        while (i != -1 && i2 < c17374a.f3702fu) {
                            float[] fArr = c17374a.f3698fB;
                            fArr[i] = fArr[i] * -1.0f;
                            i = c17374a.f3697fA[i];
                            i2++;
                        }
                    }
                    C17374a c17374a2 = c36667b.f15473fI;
                    C41479h c41479h = null;
                    C41479h c41479h2 = null;
                    float f = 0.0f;
                    float f2 = 0.0f;
                    boolean z = false;
                    boolean z2 = false;
                    int i3 = c17374a2.f3699fC;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        int i6 = i3;
                        if (i6 != -1 && i5 < c17374a2.f3702fu) {
                            float f3 = c17374a2.f3698fB[i6];
                            C41479h c41479h3 = c17374a2.f3704fw.f3710fM[c17374a2.f3707fz[i6]];
                            if (f3 < 0.0f) {
                                if (f3 > -0.001f) {
                                    c17374a2.f3698fB[i6] = 0.0f;
                                    f3 = 0.0f;
                                    c41479h3.mo66157e(c17374a2.f3703fv);
                                }
                            } else if (f3 < 0.001f) {
                                c17374a2.f3698fB[i6] = 0.0f;
                                f3 = 0.0f;
                                c41479h3.mo66157e(c17374a2.f3703fv);
                            }
                            if (f3 != 0.0f) {
                                if (c41479h3.f16688gS == C41480a.UNRESTRICTED) {
                                    if (c41479h2 == null) {
                                        z = C17374a.m26920a(c41479h3);
                                        f = f3;
                                        c41479h2 = c41479h3;
                                    } else if (f > f3) {
                                        z = C17374a.m26920a(c41479h3);
                                        f = f3;
                                        c41479h2 = c41479h3;
                                    } else if (!z && C17374a.m26920a(c41479h3)) {
                                        z = true;
                                        f = f3;
                                        c41479h2 = c41479h3;
                                    }
                                } else if (c41479h2 == null && f3 < 0.0f) {
                                    if (c41479h == null) {
                                        z2 = C17374a.m26920a(c41479h3);
                                        f2 = f3;
                                        c41479h = c41479h3;
                                    } else if (f2 > f3) {
                                        z2 = C17374a.m26920a(c41479h3);
                                        f2 = f3;
                                        c41479h = c41479h3;
                                    } else if (!z2 && C17374a.m26920a(c41479h3)) {
                                        z2 = true;
                                        f2 = f3;
                                        c41479h = c41479h3;
                                    }
                                }
                            }
                            i3 = c17374a2.f3697fA[i6];
                            i4 = i5 + 1;
                        } else if (c41479h2 == null) {
                            c41479h2 = c41479h;
                        }
                    }
                    if (c41479h2 == null) {
                    }
                    if (c41479h2 == null) {
                        obj = 1;
                    } else {
                        c36667b.mo58533d(c41479h2);
                        obj = null;
                    }
                    if (c36667b.f15473fI.f3702fu == 0) {
                        c36667b.f15474fJ = true;
                    }
                    if (obj != null) {
                        if (f3712gb != null) {
                            c41477f = f3712gb;
                            c41477f.f16670gr++;
                        }
                        if (this.mNumColumns + 1 >= this.f3717fS) {
                            m26935av();
                        }
                        C41479h a = m26932a(C41480a.SLACK);
                        this.f3713fO++;
                        this.mNumColumns++;
                        a.f16692id = this.f3713fO;
                        this.f3725fw.f3710fM[this.f3713fO] = a;
                        c36667b.f15470fF = a;
                        m26938c(c36667b);
                        obj = 1;
                        this.f3727gc.mo31530a((C17378a) c36667b);
                        m26937c(this.f3727gc);
                        if (a.f16684gO == -1) {
                            if (c36667b.f15470fF == a) {
                                a = c36667b.f15473fI.mo31503a(null, a);
                                if (a != null) {
                                    if (f3712gb != null) {
                                        C41477f c41477f2 = f3712gb;
                                        c41477f2.f16665gm++;
                                    }
                                    c36667b.mo58533d(a);
                                }
                            }
                            if (!c36667b.f15474fJ) {
                                c36667b.f15470fF.mo66158f(c36667b);
                            }
                            this.f3721fW--;
                        }
                    } else {
                        obj = null;
                    }
                    if (c36667b.f15470fF == null || (c36667b.f15470fF.f16688gS != C41480a.UNRESTRICTED && c36667b.f15471fG < 0.0f)) {
                        obj2 = null;
                    } else {
                        obj2 = 1;
                    }
                    if (obj2 == null) {
                        return;
                    }
                }
                return;
            }
            if (obj == null) {
                m26938c(c36667b);
            }
        }
    }

    /* renamed from: c */
    private final void m26938c(C36667b c36667b) {
        if (this.f3718fT[this.f3721fW] != null) {
            this.f3725fw.f3708fK.release(this.f3718fT[this.f3721fW]);
        }
        this.f3718fT[this.f3721fW] = c36667b;
        c36667b.f15470fF.f16684gO = this.f3721fW;
        this.f3721fW++;
        c36667b.f15470fF.mo66158f(c36667b);
    }

    /* renamed from: c */
    private final int m26937c(C17378a c17378a) {
        int i;
        if (f3712gb != null) {
            C41477f c41477f = f3712gb;
            c41477f.f16663gk++;
        }
        for (i = 0; i < this.mNumColumns; i++) {
            this.f3720fV[i] = false;
        }
        i = 0;
        boolean z = false;
        while (!z) {
            if (f3712gb != null) {
                C41477f c41477f2 = f3712gb;
                c41477f2.f16664gl++;
            }
            int i2 = i + 1;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            if (c17378a.mo31531at() != null) {
                this.f3720fV[c17378a.mo31531at().f16692id] = true;
            }
            C41479h a = c17378a.mo31529a(this.f3720fV);
            if (a != null) {
                if (this.f3720fV[a.f16692id]) {
                    return i2;
                }
                this.f3720fV[a.f16692id] = true;
            }
            if (a != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (i = 0; i < this.f3721fW; i++) {
                    C36667b c36667b = this.f3718fT[i];
                    if (!(c36667b.f15470fF.f16688gS == C41480a.UNRESTRICTED || c36667b.f15474fJ || !c36667b.mo58532c(a))) {
                        float b = c36667b.f15473fI.mo31508b(a);
                        if (b < 0.0f) {
                            float f2 = (-c36667b.f15471fG) / b;
                            if (f2 < f) {
                                i3 = i;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 >= 0) {
                    C36667b c36667b2 = this.f3718fT[i3];
                    c36667b2.f15470fF.f16684gO = -1;
                    if (f3712gb != null) {
                        C41477f c41477f3 = f3712gb;
                        c41477f3.f16665gm++;
                    }
                    c36667b2.mo58533d(a);
                    c36667b2.f15470fF.f16684gO = i3;
                    c36667b2.f15470fF.mo66158f(c36667b2);
                    i = i2;
                } else {
                    i = i2;
                    z = true;
                }
            } else {
                i = i2;
                z = true;
            }
        }
        return i;
    }

    /* renamed from: az */
    public final void mo31520az() {
        for (int i = 0; i < this.f3721fW; i++) {
            C36667b c36667b = this.f3718fT[i];
            c36667b.f15470fF.f16686gQ = c36667b.f15471fG;
        }
    }

    /* renamed from: a */
    public final void mo31517a(C41479h c41479h, C41479h c41479h2, int i, int i2) {
        C36667b ax = mo31518ax();
        C41479h ay = mo31519ay();
        ay.f16685gP = 0;
        ax.mo58528a(c41479h, c41479h2, ay, i);
        if (i2 != 6) {
            mo31514a(ax, (int) (ax.f15473fI.mo31508b(ay) * -1.0f), i2);
        }
        mo31521b(ax);
    }

    /* renamed from: b */
    public final void mo31523b(C41479h c41479h, C41479h c41479h2, int i, int i2) {
        C36667b ax = mo31518ax();
        C41479h ay = mo31519ay();
        ay.f16685gP = 0;
        ax.mo58530b(c41479h, c41479h2, ay, i);
        if (i2 != 6) {
            mo31514a(ax, (int) (ax.f15473fI.mo31508b(ay) * -1.0f), i2);
        }
        mo31521b(ax);
    }

    /* renamed from: a */
    public final void mo31516a(C41479h c41479h, C41479h c41479h2, int i, float f, C41479h c41479h3, C41479h c41479h4, int i2, int i3) {
        C36667b ax = mo31518ax();
        if (c41479h2 == c41479h3) {
            ax.f15473fI.mo31506a(c41479h, 1.0f);
            ax.f15473fI.mo31506a(c41479h4, 1.0f);
            ax.f15473fI.mo31506a(c41479h2, -2.0f);
        } else if (f == 0.5f) {
            ax.f15473fI.mo31506a(c41479h, 1.0f);
            ax.f15473fI.mo31506a(c41479h2, -1.0f);
            ax.f15473fI.mo31506a(c41479h3, -1.0f);
            ax.f15473fI.mo31506a(c41479h4, 1.0f);
            if (i > 0 || i2 > 0) {
                ax.f15471fG = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            ax.f15473fI.mo31506a(c41479h, -1.0f);
            ax.f15473fI.mo31506a(c41479h2, 1.0f);
            ax.f15471fG = (float) i;
        } else if (f >= 1.0f) {
            ax.f15473fI.mo31506a(c41479h3, -1.0f);
            ax.f15473fI.mo31506a(c41479h4, 1.0f);
            ax.f15471fG = (float) i2;
        } else {
            ax.f15473fI.mo31506a(c41479h, (1.0f - f) * 1.0f);
            ax.f15473fI.mo31506a(c41479h2, (1.0f - f) * -1.0f);
            ax.f15473fI.mo31506a(c41479h3, -1.0f * f);
            ax.f15473fI.mo31506a(c41479h4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                ax.f15471fG = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        if (i3 != 6) {
            ax.mo58527a(this, i3);
        }
        mo31521b(ax);
    }

    /* renamed from: c */
    public final void mo31525c(C41479h c41479h, C41479h c41479h2, C41479h c41479h3, C41479h c41479h4, float f) {
        C36667b ax = mo31518ax();
        ax.mo58529a(c41479h, c41479h2, c41479h3, c41479h4, f);
        mo31521b(ax);
    }

    /* renamed from: c */
    public final C36667b mo31524c(C41479h c41479h, C41479h c41479h2, int i, int i2) {
        C36667b ax = mo31518ax();
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            ax.f15471fG = (float) i;
        }
        if (obj == null) {
            ax.f15473fI.mo31506a(c41479h, -1.0f);
            ax.f15473fI.mo31506a(c41479h2, 1.0f);
        } else {
            ax.f15473fI.mo31506a(c41479h, 1.0f);
            ax.f15473fI.mo31506a(c41479h2, -1.0f);
        }
        if (i2 != 6) {
            ax.mo58527a(this, i2);
        }
        mo31521b(ax);
        return ax;
    }

    /* renamed from: a */
    public final void mo31515a(C41479h c41479h, int i) {
        int i2 = c41479h.f16684gO;
        C36667b c36667b;
        if (c41479h.f16684gO != -1) {
            c36667b = this.f3718fT[i2];
            if (c36667b.f15474fJ) {
                c36667b.f15471fG = (float) i;
                return;
            } else if (c36667b.f15473fI.f3702fu == 0) {
                c36667b.f15474fJ = true;
                c36667b.f15471fG = (float) i;
                return;
            } else {
                c36667b = mo31518ax();
                if (i < 0) {
                    c36667b.f15471fG = (float) (i * -1);
                    c36667b.f15473fI.mo31506a(c41479h, 1.0f);
                } else {
                    c36667b.f15471fG = (float) i;
                    c36667b.f15473fI.mo31506a(c41479h, -1.0f);
                }
                mo31521b(c36667b);
                return;
            }
        }
        c36667b = mo31518ax();
        c36667b.f15470fF = c41479h;
        c41479h.f16686gQ = (float) i;
        c36667b.f15471fG = (float) i;
        c36667b.f15474fJ = true;
        mo31521b(c36667b);
    }

    /* renamed from: a */
    public static C36667b m26931a(C17377e c17377e, C41479h c41479h, C41479h c41479h2, C41479h c41479h3, float f, boolean z) {
        C36667b ax = c17377e.mo31518ax();
        if (z) {
            ax.mo58527a(c17377e, 0);
        }
        ax.f15473fI.mo31506a(c41479h, -1.0f);
        ax.f15473fI.mo31506a(c41479h2, 1.0f - f);
        ax.f15473fI.mo31506a(c41479h3, f);
        return ax;
    }
}
