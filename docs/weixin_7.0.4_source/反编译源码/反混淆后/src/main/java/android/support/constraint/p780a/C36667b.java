package android.support.constraint.p780a;

import android.support.constraint.p780a.C17377e.C17378a;
import com.facebook.appevents.AppEventsConstants;

/* renamed from: android.support.constraint.a.b */
public class C36667b implements C17378a {
    /* renamed from: fF */
    C41479h f15470fF = null;
    /* renamed from: fG */
    public float f15471fG = 0.0f;
    /* renamed from: fH */
    boolean f15472fH = false;
    /* renamed from: fI */
    public final C17374a f15473fI;
    /* renamed from: fJ */
    public boolean f15474fJ = false;

    public C36667b(C17375c c17375c) {
        this.f15473fI = new C17374a(this, c17375c);
    }

    public String toString() {
        Object obj;
        String str = "";
        if (this.f15470fF == null) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = str + this.f15470fF;
        }
        String str2 = str + " = ";
        if (this.f15471fG != 0.0f) {
            str2 = str2 + this.f15471fG;
            obj = 1;
        } else {
            obj = null;
        }
        int i = this.f15473fI.f3702fu;
        int i2 = 0;
        while (i2 < i) {
            Object obj2;
            C41479h r = this.f15473fI.mo31510r(i2);
            if (r != null) {
                float s = this.f15473fI.mo31511s(i2);
                if (s != 0.0f) {
                    float f;
                    String c41479h = r.toString();
                    if (obj == null) {
                        if (s < 0.0f) {
                            str2 = str2 + "- ";
                            f = s * -1.0f;
                        } else {
                            f = s;
                        }
                    } else if (s > 0.0f) {
                        str2 = str2 + " + ";
                        f = s;
                    } else {
                        str2 = str2 + " - ";
                        f = s * -1.0f;
                    }
                    if (f == 1.0f) {
                        str = str2 + c41479h;
                    } else {
                        str = str2 + f + " " + c41479h;
                    }
                    obj2 = 1;
                    str2 = str;
                    i2++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            i2++;
            obj = obj2;
        }
        return obj == null ? str2 + "0.0" : str2;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final boolean mo58532c(C41479h c41479h) {
        C17374a c17374a = this.f15473fI;
        if (c17374a.f3699fC == -1) {
            return false;
        }
        int i = c17374a.f3699fC;
        int i2 = 0;
        while (i != -1 && i2 < c17374a.f3702fu) {
            if (c17374a.f3707fz[i] == c41479h.f16692id) {
                return true;
            }
            i = c17374a.f3697fA[i];
            i2++;
        }
        return false;
    }

    /* renamed from: a */
    public final C36667b mo58528a(C41479h c41479h, C41479h c41479h2, C41479h c41479h3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f15471fG = (float) i;
        }
        if (obj == null) {
            this.f15473fI.mo31506a(c41479h, -1.0f);
            this.f15473fI.mo31506a(c41479h2, 1.0f);
            this.f15473fI.mo31506a(c41479h3, 1.0f);
        } else {
            this.f15473fI.mo31506a(c41479h, 1.0f);
            this.f15473fI.mo31506a(c41479h2, -1.0f);
            this.f15473fI.mo31506a(c41479h3, -1.0f);
        }
        return this;
    }

    /* renamed from: b */
    public final C36667b mo58530b(C41479h c41479h, C41479h c41479h2, C41479h c41479h3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.f15471fG = (float) i;
        }
        if (obj == null) {
            this.f15473fI.mo31506a(c41479h, -1.0f);
            this.f15473fI.mo31506a(c41479h2, 1.0f);
            this.f15473fI.mo31506a(c41479h3, -1.0f);
        } else {
            this.f15473fI.mo31506a(c41479h, 1.0f);
            this.f15473fI.mo31506a(c41479h2, -1.0f);
            this.f15473fI.mo31506a(c41479h3, 1.0f);
        }
        return this;
    }

    /* renamed from: a */
    public final C36667b mo58527a(C17377e c17377e, int i) {
        this.f15473fI.mo31506a(c17377e.mo31528t(i), 1.0f);
        this.f15473fI.mo31506a(c17377e.mo31528t(i), -1.0f);
        return this;
    }

    /* renamed from: a */
    public final C36667b mo58529a(C41479h c41479h, C41479h c41479h2, C41479h c41479h3, C41479h c41479h4, float f) {
        this.f15473fI.mo31506a(c41479h, -1.0f);
        this.f15473fI.mo31506a(c41479h2, 1.0f);
        this.f15473fI.mo31506a(c41479h3, f);
        this.f15473fI.mo31506a(c41479h4, -f);
        return this;
    }

    /* renamed from: b */
    public final C36667b mo58531b(C41479h c41479h, C41479h c41479h2, C41479h c41479h3, C41479h c41479h4, float f) {
        this.f15473fI.mo31506a(c41479h3, 0.5f);
        this.f15473fI.mo31506a(c41479h4, 0.5f);
        this.f15473fI.mo31506a(c41479h, -0.5f);
        this.f15473fI.mo31506a(c41479h2, -0.5f);
        this.f15471fG = -f;
        return this;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final void mo58533d(C41479h c41479h) {
        if (this.f15470fF != null) {
            this.f15473fI.mo31506a(this.f15470fF, -1.0f);
            this.f15470fF = null;
        }
        float a = -1.0f * this.f15473fI.mo31502a(c41479h, true);
        this.f15470fF = c41479h;
        if (a != 1.0f) {
            this.f15471fG /= a;
            C17374a c17374a = this.f15473fI;
            int i = c17374a.f3699fC;
            int i2 = 0;
            while (i != -1 && i2 < c17374a.f3702fu) {
                float[] fArr = c17374a.f3698fB;
                fArr[i] = fArr[i] / a;
                i = c17374a.f3697fA[i];
                i2++;
            }
        }
    }

    /* renamed from: a */
    public final C41479h mo31529a(boolean[] zArr) {
        return this.f15473fI.mo31503a(zArr, null);
    }

    public final void clear() {
        this.f15473fI.clear();
        this.f15470fF = null;
        this.f15471fG = 0.0f;
    }

    /* renamed from: a */
    public final void mo31530a(C17378a c17378a) {
        if (c17378a instanceof C36667b) {
            C36667b c36667b = (C36667b) c17378a;
            this.f15470fF = null;
            this.f15473fI.clear();
            for (int i = 0; i < c36667b.f15473fI.f3702fu; i++) {
                this.f15473fI.mo31507a(c36667b.f15473fI.mo31510r(i), c36667b.f15473fI.mo31511s(i), true);
            }
        }
    }

    /* renamed from: e */
    public void mo31513e(C41479h c41479h) {
        float f = 1.0f;
        if (c41479h.f16685gP != 1) {
            if (c41479h.f16685gP == 2) {
                f = 1000.0f;
            } else if (c41479h.f16685gP == 3) {
                f = 1000000.0f;
            } else if (c41479h.f16685gP == 4) {
                f = 1.0E9f;
            } else if (c41479h.f16685gP == 5) {
                f = 1.0E12f;
            }
        }
        this.f15473fI.mo31506a(c41479h, f);
    }

    /* renamed from: at */
    public final C41479h mo31531at() {
        return this.f15470fF;
    }
}
