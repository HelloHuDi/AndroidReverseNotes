package android.support.constraint.p780a;

import android.support.constraint.p780a.C41479h.C41480a;
import java.util.Arrays;

/* renamed from: android.support.constraint.a.a */
public final class C17374a {
    /* renamed from: fA */
    int[] f3697fA = new int[this.f3705fx];
    /* renamed from: fB */
    float[] f3698fB = new float[this.f3705fx];
    /* renamed from: fC */
    int f3699fC = -1;
    /* renamed from: fD */
    private int f3700fD = -1;
    /* renamed from: fE */
    private boolean f3701fE = false;
    /* renamed from: fu */
    int f3702fu = 0;
    /* renamed from: fv */
    final C36667b f3703fv;
    /* renamed from: fw */
    final C17375c f3704fw;
    /* renamed from: fx */
    private int f3705fx = 8;
    /* renamed from: fy */
    private C41479h f3706fy = null;
    /* renamed from: fz */
    int[] f3707fz = new int[this.f3705fx];

    C17374a(C36667b c36667b, C17375c c17375c) {
        this.f3703fv = c36667b;
        this.f3704fw = c17375c;
    }

    /* renamed from: a */
    public final void mo31506a(C41479h c41479h, float f) {
        if (f == 0.0f) {
            mo31502a(c41479h, true);
        } else if (this.f3699fC == -1) {
            this.f3699fC = 0;
            this.f3698fB[this.f3699fC] = f;
            this.f3707fz[this.f3699fC] = c41479h.f16692id;
            this.f3697fA[this.f3699fC] = -1;
            c41479h.f16691gV++;
            c41479h.mo66156d(this.f3703fv);
            this.f3702fu++;
            if (!this.f3701fE) {
                this.f3700fD++;
                if (this.f3700fD >= this.f3707fz.length) {
                    this.f3701fE = true;
                    this.f3700fD = this.f3707fz.length - 1;
                }
            }
        } else {
            int i = this.f3699fC;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f3702fu) {
                if (this.f3707fz[i] == c41479h.f16692id) {
                    this.f3698fB[i] = f;
                    return;
                }
                if (this.f3707fz[i] < c41479h.f16692id) {
                    i3 = i;
                }
                i = this.f3697fA[i];
                i2++;
            }
            i = this.f3700fD + 1;
            if (this.f3701fE) {
                if (this.f3707fz[this.f3700fD] == -1) {
                    i = this.f3700fD;
                } else {
                    i = this.f3707fz.length;
                }
            }
            if (i >= this.f3707fz.length && this.f3702fu < this.f3707fz.length) {
                for (i2 = 0; i2 < this.f3707fz.length; i2++) {
                    if (this.f3707fz[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f3707fz.length) {
                i = this.f3707fz.length;
                this.f3705fx *= 2;
                this.f3701fE = false;
                this.f3700fD = i - 1;
                this.f3698fB = Arrays.copyOf(this.f3698fB, this.f3705fx);
                this.f3707fz = Arrays.copyOf(this.f3707fz, this.f3705fx);
                this.f3697fA = Arrays.copyOf(this.f3697fA, this.f3705fx);
            }
            this.f3707fz[i] = c41479h.f16692id;
            this.f3698fB[i] = f;
            if (i3 != -1) {
                int[] iArr = this.f3697fA;
                iArr[i] = iArr[i3];
                this.f3697fA[i3] = i;
            } else {
                this.f3697fA[i] = this.f3699fC;
                this.f3699fC = i;
            }
            c41479h.f16691gV++;
            c41479h.mo66156d(this.f3703fv);
            this.f3702fu++;
            if (!this.f3701fE) {
                this.f3700fD++;
            }
            if (this.f3702fu >= this.f3707fz.length) {
                this.f3701fE = true;
            }
            if (this.f3700fD >= this.f3707fz.length) {
                this.f3701fE = true;
                this.f3700fD = this.f3707fz.length - 1;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31507a(C41479h c41479h, float f, boolean z) {
        if (f != 0.0f) {
            if (this.f3699fC == -1) {
                this.f3699fC = 0;
                this.f3698fB[this.f3699fC] = f;
                this.f3707fz[this.f3699fC] = c41479h.f16692id;
                this.f3697fA[this.f3699fC] = -1;
                c41479h.f16691gV++;
                c41479h.mo66156d(this.f3703fv);
                this.f3702fu++;
                if (!this.f3701fE) {
                    this.f3700fD++;
                    if (this.f3700fD >= this.f3707fz.length) {
                        this.f3701fE = true;
                        this.f3700fD = this.f3707fz.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int[] iArr;
            int i = this.f3699fC;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.f3702fu) {
                if (this.f3707fz[i] == c41479h.f16692id) {
                    float[] fArr = this.f3698fB;
                    fArr[i] = fArr[i] + f;
                    if (this.f3698fB[i] == 0.0f) {
                        if (i == this.f3699fC) {
                            this.f3699fC = this.f3697fA[i];
                        } else {
                            iArr = this.f3697fA;
                            iArr[i3] = iArr[i];
                        }
                        if (z) {
                            c41479h.mo66157e(this.f3703fv);
                        }
                        if (this.f3701fE) {
                            this.f3700fD = i;
                        }
                        c41479h.f16691gV--;
                        this.f3702fu--;
                        return;
                    }
                    return;
                }
                if (this.f3707fz[i] < c41479h.f16692id) {
                    i3 = i;
                }
                i = this.f3697fA[i];
                i2++;
            }
            i = this.f3700fD + 1;
            if (this.f3701fE) {
                if (this.f3707fz[this.f3700fD] == -1) {
                    i = this.f3700fD;
                } else {
                    i = this.f3707fz.length;
                }
            }
            if (i >= this.f3707fz.length && this.f3702fu < this.f3707fz.length) {
                for (i2 = 0; i2 < this.f3707fz.length; i2++) {
                    if (this.f3707fz[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.f3707fz.length) {
                i = this.f3707fz.length;
                this.f3705fx *= 2;
                this.f3701fE = false;
                this.f3700fD = i - 1;
                this.f3698fB = Arrays.copyOf(this.f3698fB, this.f3705fx);
                this.f3707fz = Arrays.copyOf(this.f3707fz, this.f3705fx);
                this.f3697fA = Arrays.copyOf(this.f3697fA, this.f3705fx);
            }
            this.f3707fz[i] = c41479h.f16692id;
            this.f3698fB[i] = f;
            if (i3 != -1) {
                iArr = this.f3697fA;
                iArr[i] = iArr[i3];
                this.f3697fA[i3] = i;
            } else {
                this.f3697fA[i] = this.f3699fC;
                this.f3699fC = i;
            }
            c41479h.f16691gV++;
            c41479h.mo66156d(this.f3703fv);
            this.f3702fu++;
            if (!this.f3701fE) {
                this.f3700fD++;
            }
            if (this.f3700fD >= this.f3707fz.length) {
                this.f3701fE = true;
                this.f3700fD = this.f3707fz.length - 1;
            }
        }
    }

    /* renamed from: a */
    public final float mo31502a(C41479h c41479h, boolean z) {
        if (this.f3706fy == c41479h) {
            this.f3706fy = null;
        }
        if (this.f3699fC == -1) {
            return 0.0f;
        }
        int i = this.f3699fC;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.f3702fu) {
            if (this.f3707fz[i] == c41479h.f16692id) {
                if (i == this.f3699fC) {
                    this.f3699fC = this.f3697fA[i];
                } else {
                    int[] iArr = this.f3697fA;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    c41479h.mo66157e(this.f3703fv);
                }
                c41479h.f16691gV--;
                this.f3702fu--;
                this.f3707fz[i] = -1;
                if (this.f3701fE) {
                    this.f3700fD = i;
                }
                return this.f3698fB[i];
            }
            i2++;
            i3 = i;
            i = this.f3697fA[i];
        }
        return 0.0f;
    }

    public final void clear() {
        int i = this.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < this.f3702fu) {
            C41479h c41479h = this.f3704fw.f3710fM[this.f3707fz[i]];
            if (c41479h != null) {
                c41479h.mo66157e(this.f3703fv);
            }
            i = this.f3697fA[i];
            i2++;
        }
        this.f3699fC = -1;
        this.f3700fD = -1;
        this.f3701fE = false;
        this.f3702fu = 0;
    }

    /* renamed from: a */
    static boolean m26920a(C41479h c41479h) {
        return c41479h.f16691gV <= 1;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31504a(C36667b c36667b, C36667b c36667b2) {
        int i = this.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < this.f3702fu) {
            if (this.f3707fz[i] == c36667b2.f15470fF.f16692id) {
                float f = this.f3698fB[i];
                mo31502a(c36667b2.f15470fF, false);
                C17374a c17374a = c36667b2.f15473fI;
                int i3 = c17374a.f3699fC;
                i = 0;
                while (i3 != -1 && i < c17374a.f3702fu) {
                    mo31507a(this.f3704fw.f3710fM[c17374a.f3707fz[i3]], c17374a.f3698fB[i3] * f, false);
                    i3 = c17374a.f3697fA[i3];
                    i++;
                }
                c36667b.f15471fG += c36667b2.f15471fG * f;
                i = this.f3699fC;
                i2 = 0;
            } else {
                i = this.f3697fA[i];
                i2++;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo31505a(C36667b c36667b, C36667b[] c36667bArr) {
        int i = this.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < this.f3702fu) {
            C41479h c41479h = this.f3704fw.f3710fM[this.f3707fz[i]];
            if (c41479h.f16684gO != -1) {
                float f = this.f3698fB[i];
                mo31502a(c41479h, true);
                C36667b c36667b2 = c36667bArr[c41479h.f16684gO];
                if (!c36667b2.f15474fJ) {
                    C17374a c17374a = c36667b2.f15473fI;
                    int i3 = c17374a.f3699fC;
                    i = 0;
                    while (i3 != -1 && i < c17374a.f3702fu) {
                        mo31507a(this.f3704fw.f3710fM[c17374a.f3707fz[i3]], c17374a.f3698fB[i3] * f, true);
                        i3 = c17374a.f3697fA[i3];
                        i++;
                    }
                }
                c36667b.f15471fG += c36667b2.f15471fG * f;
                c36667b2.f15470fF.mo66157e(c36667b);
                i = this.f3699fC;
                i2 = 0;
            } else {
                i = this.f3697fA[i];
                i2++;
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final C41479h mo31503a(boolean[] zArr, C41479h c41479h) {
        int i = this.f3699fC;
        int i2 = 0;
        C41479h c41479h2 = null;
        float f = 0.0f;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i4 == -1 || i3 >= this.f3702fu) {
                return c41479h2;
            }
            if (this.f3698fB[i4] < 0.0f) {
                C41479h c41479h3 = this.f3704fw.f3710fM[this.f3707fz[i4]];
                if ((zArr == null || !zArr[c41479h3.f16692id]) && c41479h3 != c41479h && (c41479h3.f16688gS == C41480a.SLACK || c41479h3.f16688gS == C41480a.ERROR)) {
                    float f2 = this.f3698fB[i4];
                    if (f2 < f) {
                        f = f2;
                        c41479h2 = c41479h3;
                    }
                }
            }
            i = this.f3697fA[i4];
            i2 = i3 + 1;
        }
        return c41479h2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: r */
    public final C41479h mo31510r(int i) {
        int i2 = this.f3699fC;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3702fu) {
            if (i3 == i) {
                return this.f3704fw.f3710fM[this.f3707fz[i2]];
            }
            i2 = this.f3697fA[i2];
            i3++;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: s */
    public final float mo31511s(int i) {
        int i2 = this.f3699fC;
        int i3 = 0;
        while (i2 != -1 && i3 < this.f3702fu) {
            if (i3 == i) {
                return this.f3698fB[i2];
            }
            i2 = this.f3697fA[i2];
            i3++;
        }
        return 0.0f;
    }

    /* renamed from: b */
    public final float mo31508b(C41479h c41479h) {
        int i = this.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < this.f3702fu) {
            if (this.f3707fz[i] == c41479h.f16692id) {
                return this.f3698fB[i];
            }
            i = this.f3697fA[i];
            i2++;
        }
        return 0.0f;
    }

    public final String toString() {
        String str = "";
        int i = this.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < this.f3702fu) {
            str = ((str + " -> ") + this.f3698fB[i] + " : ") + this.f3704fw.f3710fM[this.f3707fz[i]];
            i = this.f3697fA[i];
            i2++;
        }
        return str;
    }
}
