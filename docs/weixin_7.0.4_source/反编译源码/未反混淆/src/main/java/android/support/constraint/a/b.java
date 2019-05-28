package android.support.constraint.a;

import com.facebook.appevents.AppEventsConstants;

public class b implements a {
    h fF = null;
    public float fG = 0.0f;
    boolean fH = false;
    public final a fI;
    public boolean fJ = false;

    public b(c cVar) {
        this.fI = new a(this, cVar);
    }

    public String toString() {
        Object obj;
        String str = "";
        if (this.fF == null) {
            str = str + AppEventsConstants.EVENT_PARAM_VALUE_NO;
        } else {
            str = str + this.fF;
        }
        String str2 = str + " = ";
        if (this.fG != 0.0f) {
            str2 = str2 + this.fG;
            obj = 1;
        } else {
            obj = null;
        }
        int i = this.fI.fu;
        int i2 = 0;
        while (i2 < i) {
            Object obj2;
            h r = this.fI.r(i2);
            if (r != null) {
                float s = this.fI.s(i2);
                if (s != 0.0f) {
                    float f;
                    String hVar = r.toString();
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
                        str = str2 + hVar;
                    } else {
                        str = str2 + f + " " + hVar;
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
    public final boolean c(h hVar) {
        a aVar = this.fI;
        if (aVar.fC == -1) {
            return false;
        }
        int i = aVar.fC;
        int i2 = 0;
        while (i != -1 && i2 < aVar.fu) {
            if (aVar.fz[i] == hVar.id) {
                return true;
            }
            i = aVar.fA[i];
            i2++;
        }
        return false;
    }

    public final b a(h hVar, h hVar2, h hVar3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.fG = (float) i;
        }
        if (obj == null) {
            this.fI.a(hVar, -1.0f);
            this.fI.a(hVar2, 1.0f);
            this.fI.a(hVar3, 1.0f);
        } else {
            this.fI.a(hVar, 1.0f);
            this.fI.a(hVar2, -1.0f);
            this.fI.a(hVar3, -1.0f);
        }
        return this;
    }

    public final b b(h hVar, h hVar2, h hVar3, int i) {
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            this.fG = (float) i;
        }
        if (obj == null) {
            this.fI.a(hVar, -1.0f);
            this.fI.a(hVar2, 1.0f);
            this.fI.a(hVar3, -1.0f);
        } else {
            this.fI.a(hVar, 1.0f);
            this.fI.a(hVar2, -1.0f);
            this.fI.a(hVar3, 1.0f);
        }
        return this;
    }

    public final b a(e eVar, int i) {
        this.fI.a(eVar.t(i), 1.0f);
        this.fI.a(eVar.t(i), -1.0f);
        return this;
    }

    public final b a(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.fI.a(hVar, -1.0f);
        this.fI.a(hVar2, 1.0f);
        this.fI.a(hVar3, f);
        this.fI.a(hVar4, -f);
        return this;
    }

    public final b b(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        this.fI.a(hVar3, 0.5f);
        this.fI.a(hVar4, 0.5f);
        this.fI.a(hVar, -0.5f);
        this.fI.a(hVar2, -0.5f);
        this.fG = -f;
        return this;
    }

    /* Access modifiers changed, original: final */
    public final void d(h hVar) {
        if (this.fF != null) {
            this.fI.a(this.fF, -1.0f);
            this.fF = null;
        }
        float a = -1.0f * this.fI.a(hVar, true);
        this.fF = hVar;
        if (a != 1.0f) {
            this.fG /= a;
            a aVar = this.fI;
            int i = aVar.fC;
            int i2 = 0;
            while (i != -1 && i2 < aVar.fu) {
                float[] fArr = aVar.fB;
                fArr[i] = fArr[i] / a;
                i = aVar.fA[i];
                i2++;
            }
        }
    }

    public final h a(boolean[] zArr) {
        return this.fI.a(zArr, null);
    }

    public final void clear() {
        this.fI.clear();
        this.fF = null;
        this.fG = 0.0f;
    }

    public final void a(a aVar) {
        if (aVar instanceof b) {
            b bVar = (b) aVar;
            this.fF = null;
            this.fI.clear();
            for (int i = 0; i < bVar.fI.fu; i++) {
                this.fI.a(bVar.fI.r(i), bVar.fI.s(i), true);
            }
        }
    }

    public void e(h hVar) {
        float f = 1.0f;
        if (hVar.gP != 1) {
            if (hVar.gP == 2) {
                f = 1000.0f;
            } else if (hVar.gP == 3) {
                f = 1000000.0f;
            } else if (hVar.gP == 4) {
                f = 1.0E9f;
            } else if (hVar.gP == 5) {
                f = 1.0E12f;
            }
        }
        this.fI.a(hVar, f);
    }

    public final h at() {
        return this.fF;
    }
}
