package android.support.constraint.a;

import java.util.Arrays;

public final class a {
    int[] fA = new int[this.fx];
    float[] fB = new float[this.fx];
    int fC = -1;
    private int fD = -1;
    private boolean fE = false;
    int fu = 0;
    final b fv;
    final c fw;
    private int fx = 8;
    private h fy = null;
    int[] fz = new int[this.fx];

    a(b bVar, c cVar) {
        this.fv = bVar;
        this.fw = cVar;
    }

    public final void a(h hVar, float f) {
        if (f == 0.0f) {
            a(hVar, true);
        } else if (this.fC == -1) {
            this.fC = 0;
            this.fB[this.fC] = f;
            this.fz[this.fC] = hVar.id;
            this.fA[this.fC] = -1;
            hVar.gV++;
            hVar.d(this.fv);
            this.fu++;
            if (!this.fE) {
                this.fD++;
                if (this.fD >= this.fz.length) {
                    this.fE = true;
                    this.fD = this.fz.length - 1;
                }
            }
        } else {
            int i = this.fC;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.fu) {
                if (this.fz[i] == hVar.id) {
                    this.fB[i] = f;
                    return;
                }
                if (this.fz[i] < hVar.id) {
                    i3 = i;
                }
                i = this.fA[i];
                i2++;
            }
            i = this.fD + 1;
            if (this.fE) {
                if (this.fz[this.fD] == -1) {
                    i = this.fD;
                } else {
                    i = this.fz.length;
                }
            }
            if (i >= this.fz.length && this.fu < this.fz.length) {
                for (i2 = 0; i2 < this.fz.length; i2++) {
                    if (this.fz[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.fz.length) {
                i = this.fz.length;
                this.fx *= 2;
                this.fE = false;
                this.fD = i - 1;
                this.fB = Arrays.copyOf(this.fB, this.fx);
                this.fz = Arrays.copyOf(this.fz, this.fx);
                this.fA = Arrays.copyOf(this.fA, this.fx);
            }
            this.fz[i] = hVar.id;
            this.fB[i] = f;
            if (i3 != -1) {
                int[] iArr = this.fA;
                iArr[i] = iArr[i3];
                this.fA[i3] = i;
            } else {
                this.fA[i] = this.fC;
                this.fC = i;
            }
            hVar.gV++;
            hVar.d(this.fv);
            this.fu++;
            if (!this.fE) {
                this.fD++;
            }
            if (this.fu >= this.fz.length) {
                this.fE = true;
            }
            if (this.fD >= this.fz.length) {
                this.fE = true;
                this.fD = this.fz.length - 1;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(h hVar, float f, boolean z) {
        if (f != 0.0f) {
            if (this.fC == -1) {
                this.fC = 0;
                this.fB[this.fC] = f;
                this.fz[this.fC] = hVar.id;
                this.fA[this.fC] = -1;
                hVar.gV++;
                hVar.d(this.fv);
                this.fu++;
                if (!this.fE) {
                    this.fD++;
                    if (this.fD >= this.fz.length) {
                        this.fE = true;
                        this.fD = this.fz.length - 1;
                        return;
                    }
                    return;
                }
                return;
            }
            int[] iArr;
            int i = this.fC;
            int i2 = 0;
            int i3 = -1;
            while (i != -1 && i2 < this.fu) {
                if (this.fz[i] == hVar.id) {
                    float[] fArr = this.fB;
                    fArr[i] = fArr[i] + f;
                    if (this.fB[i] == 0.0f) {
                        if (i == this.fC) {
                            this.fC = this.fA[i];
                        } else {
                            iArr = this.fA;
                            iArr[i3] = iArr[i];
                        }
                        if (z) {
                            hVar.e(this.fv);
                        }
                        if (this.fE) {
                            this.fD = i;
                        }
                        hVar.gV--;
                        this.fu--;
                        return;
                    }
                    return;
                }
                if (this.fz[i] < hVar.id) {
                    i3 = i;
                }
                i = this.fA[i];
                i2++;
            }
            i = this.fD + 1;
            if (this.fE) {
                if (this.fz[this.fD] == -1) {
                    i = this.fD;
                } else {
                    i = this.fz.length;
                }
            }
            if (i >= this.fz.length && this.fu < this.fz.length) {
                for (i2 = 0; i2 < this.fz.length; i2++) {
                    if (this.fz[i2] == -1) {
                        i = i2;
                        break;
                    }
                }
            }
            if (i >= this.fz.length) {
                i = this.fz.length;
                this.fx *= 2;
                this.fE = false;
                this.fD = i - 1;
                this.fB = Arrays.copyOf(this.fB, this.fx);
                this.fz = Arrays.copyOf(this.fz, this.fx);
                this.fA = Arrays.copyOf(this.fA, this.fx);
            }
            this.fz[i] = hVar.id;
            this.fB[i] = f;
            if (i3 != -1) {
                iArr = this.fA;
                iArr[i] = iArr[i3];
                this.fA[i3] = i;
            } else {
                this.fA[i] = this.fC;
                this.fC = i;
            }
            hVar.gV++;
            hVar.d(this.fv);
            this.fu++;
            if (!this.fE) {
                this.fD++;
            }
            if (this.fD >= this.fz.length) {
                this.fE = true;
                this.fD = this.fz.length - 1;
            }
        }
    }

    public final float a(h hVar, boolean z) {
        if (this.fy == hVar) {
            this.fy = null;
        }
        if (this.fC == -1) {
            return 0.0f;
        }
        int i = this.fC;
        int i2 = 0;
        int i3 = -1;
        while (i != -1 && i2 < this.fu) {
            if (this.fz[i] == hVar.id) {
                if (i == this.fC) {
                    this.fC = this.fA[i];
                } else {
                    int[] iArr = this.fA;
                    iArr[i3] = iArr[i];
                }
                if (z) {
                    hVar.e(this.fv);
                }
                hVar.gV--;
                this.fu--;
                this.fz[i] = -1;
                if (this.fE) {
                    this.fD = i;
                }
                return this.fB[i];
            }
            i2++;
            i3 = i;
            i = this.fA[i];
        }
        return 0.0f;
    }

    public final void clear() {
        int i = this.fC;
        int i2 = 0;
        while (i != -1 && i2 < this.fu) {
            h hVar = this.fw.fM[this.fz[i]];
            if (hVar != null) {
                hVar.e(this.fv);
            }
            i = this.fA[i];
            i2++;
        }
        this.fC = -1;
        this.fD = -1;
        this.fE = false;
        this.fu = 0;
    }

    static boolean a(h hVar) {
        return hVar.gV <= 1;
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar, b bVar2) {
        int i = this.fC;
        int i2 = 0;
        while (i != -1 && i2 < this.fu) {
            if (this.fz[i] == bVar2.fF.id) {
                float f = this.fB[i];
                a(bVar2.fF, false);
                a aVar = bVar2.fI;
                int i3 = aVar.fC;
                i = 0;
                while (i3 != -1 && i < aVar.fu) {
                    a(this.fw.fM[aVar.fz[i3]], aVar.fB[i3] * f, false);
                    i3 = aVar.fA[i3];
                    i++;
                }
                bVar.fG += bVar2.fG * f;
                i = this.fC;
                i2 = 0;
            } else {
                i = this.fA[i];
                i2++;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(b bVar, b[] bVarArr) {
        int i = this.fC;
        int i2 = 0;
        while (i != -1 && i2 < this.fu) {
            h hVar = this.fw.fM[this.fz[i]];
            if (hVar.gO != -1) {
                float f = this.fB[i];
                a(hVar, true);
                b bVar2 = bVarArr[hVar.gO];
                if (!bVar2.fJ) {
                    a aVar = bVar2.fI;
                    int i3 = aVar.fC;
                    i = 0;
                    while (i3 != -1 && i < aVar.fu) {
                        a(this.fw.fM[aVar.fz[i3]], aVar.fB[i3] * f, true);
                        i3 = aVar.fA[i3];
                        i++;
                    }
                }
                bVar.fG += bVar2.fG * f;
                bVar2.fF.e(bVar);
                i = this.fC;
                i2 = 0;
            } else {
                i = this.fA[i];
                i2++;
            }
        }
    }

    /* Access modifiers changed, original: final */
    public final h a(boolean[] zArr, h hVar) {
        int i = this.fC;
        int i2 = 0;
        h hVar2 = null;
        float f = 0.0f;
        while (true) {
            int i3 = i2;
            int i4 = i;
            if (i4 == -1 || i3 >= this.fu) {
                return hVar2;
            }
            if (this.fB[i4] < 0.0f) {
                h hVar3 = this.fw.fM[this.fz[i4]];
                if ((zArr == null || !zArr[hVar3.id]) && hVar3 != hVar && (hVar3.gS == android.support.constraint.a.h.a.SLACK || hVar3.gS == android.support.constraint.a.h.a.ERROR)) {
                    float f2 = this.fB[i4];
                    if (f2 < f) {
                        f = f2;
                        hVar2 = hVar3;
                    }
                }
            }
            i = this.fA[i4];
            i2 = i3 + 1;
        }
        return hVar2;
    }

    /* Access modifiers changed, original: final */
    public final h r(int i) {
        int i2 = this.fC;
        int i3 = 0;
        while (i2 != -1 && i3 < this.fu) {
            if (i3 == i) {
                return this.fw.fM[this.fz[i2]];
            }
            i2 = this.fA[i2];
            i3++;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final float s(int i) {
        int i2 = this.fC;
        int i3 = 0;
        while (i2 != -1 && i3 < this.fu) {
            if (i3 == i) {
                return this.fB[i2];
            }
            i2 = this.fA[i2];
            i3++;
        }
        return 0.0f;
    }

    public final float b(h hVar) {
        int i = this.fC;
        int i2 = 0;
        while (i != -1 && i2 < this.fu) {
            if (this.fz[i] == hVar.id) {
                return this.fB[i];
            }
            i = this.fA[i];
            i2++;
        }
        return 0.0f;
    }

    public final String toString() {
        String str = "";
        int i = this.fC;
        int i2 = 0;
        while (i != -1 && i2 < this.fu) {
            str = ((str + " -> ") + this.fB[i] + " : ") + this.fw.fM[this.fz[i]];
            i = this.fA[i];
            i2++;
        }
        return str;
    }
}
