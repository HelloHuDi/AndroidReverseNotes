package android.support.constraint.a;

import java.util.Arrays;
import java.util.HashMap;

public final class e {
    private static int fN = 1000;
    public static f gb;
    int fO;
    private HashMap<String, h> fP;
    public a fQ;
    private int fR;
    private int fS;
    public b[] fT;
    public boolean fU;
    private boolean[] fV;
    public int fW;
    private int fX;
    private h[] fY;
    private int fZ;
    public final c fw;
    private b[] ga;
    private final a gc;
    int mNumColumns;

    interface a {
        h a(boolean[] zArr);

        void a(a aVar);

        h at();

        void clear();

        void e(h hVar);
    }

    public e() {
        this.fO = 0;
        this.fP = null;
        this.fR = 32;
        this.fS = this.fR;
        this.fT = null;
        this.fU = false;
        this.fV = new boolean[this.fR];
        this.mNumColumns = 1;
        this.fW = 0;
        this.fX = this.fR;
        this.fY = new h[fN];
        this.fZ = 0;
        this.ga = new b[this.fR];
        this.fT = new b[this.fR];
        aw();
        this.fw = new c();
        this.fQ = new d(this.fw);
        this.gc = new b(this.fw);
    }

    public static f au() {
        return gb;
    }

    private void av() {
        this.fR *= 2;
        this.fT = (b[]) Arrays.copyOf(this.fT, this.fR);
        this.fw.fM = (h[]) Arrays.copyOf(this.fw.fM, this.fR);
        this.fV = new boolean[this.fR];
        this.fS = this.fR;
        this.fX = this.fR;
        if (gb != null) {
            f fVar = gb;
            fVar.gg++;
            fVar = gb;
            fVar.gs = Math.max(fVar.gs, (long) this.fR);
            fVar = gb;
            fVar.gG = fVar.gs;
        }
    }

    private void aw() {
        for (int i = 0; i < this.fT.length; i++) {
            Object obj = this.fT[i];
            if (obj != null) {
                this.fw.fK.release(obj);
            }
            this.fT[i] = null;
        }
    }

    public final void reset() {
        int i;
        for (h hVar : this.fw.fM) {
            if (hVar != null) {
                hVar.reset();
            }
        }
        this.fw.fL.b(this.fY, this.fZ);
        this.fZ = 0;
        Arrays.fill(this.fw.fM, null);
        if (this.fP != null) {
            this.fP.clear();
        }
        this.fO = 0;
        this.fQ.clear();
        this.mNumColumns = 1;
        for (i = 0; i < this.fW; i++) {
            this.fT[i].fH = false;
        }
        aw();
        this.fW = 0;
    }

    public final h g(Object obj) {
        h hVar = null;
        if (obj != null) {
            if (this.mNumColumns + 1 >= this.fS) {
                av();
            }
            if (obj instanceof android.support.constraint.a.a.e) {
                hVar = ((android.support.constraint.a.a.e) obj).hE;
                if (hVar == null) {
                    ((android.support.constraint.a.a.e) obj).aG();
                    hVar = ((android.support.constraint.a.a.e) obj).hE;
                }
                if (hVar.id == -1 || hVar.id > this.fO || this.fw.fM[hVar.id] == null) {
                    if (hVar.id != -1) {
                        hVar.reset();
                    }
                    this.fO++;
                    this.mNumColumns++;
                    hVar.id = this.fO;
                    hVar.gS = android.support.constraint.a.h.a.UNRESTRICTED;
                    this.fw.fM[this.fO] = hVar;
                }
            }
        }
        return hVar;
    }

    public final b ax() {
        b bVar = (b) this.fw.fK.aA();
        if (bVar == null) {
            bVar = new b(this.fw);
        } else {
            bVar.fF = null;
            bVar.fI.clear();
            bVar.fG = 0.0f;
            bVar.fJ = false;
        }
        h.aB();
        return bVar;
    }

    public final h ay() {
        if (gb != null) {
            f fVar = gb;
            fVar.gq++;
        }
        if (this.mNumColumns + 1 >= this.fS) {
            av();
        }
        h a = a(android.support.constraint.a.h.a.SLACK);
        this.fO++;
        this.mNumColumns++;
        a.id = this.fO;
        this.fw.fM[this.fO] = a;
        return a;
    }

    public final void a(b bVar, int i, int i2) {
        bVar.fI.a(t(i2), (float) i);
    }

    public final h t(int i) {
        if (gb != null) {
            f fVar = gb;
            fVar.gp++;
        }
        if (this.mNumColumns + 1 >= this.fS) {
            av();
        }
        h a = a(android.support.constraint.a.h.a.ERROR);
        this.fO++;
        this.mNumColumns++;
        a.id = this.fO;
        a.gP = i;
        this.fw.fM[this.fO] = a;
        this.fQ.e(a);
        return a;
    }

    private h a(android.support.constraint.a.h.a aVar) {
        h hVar;
        h hVar2 = (h) this.fw.fL.aA();
        if (hVar2 == null) {
            hVar2 = new h(aVar);
            hVar2.gS = aVar;
            hVar = hVar2;
        } else {
            hVar2.reset();
            hVar2.gS = aVar;
            hVar = hVar2;
        }
        if (this.fZ >= fN) {
            fN *= 2;
            this.fY = (h[]) Arrays.copyOf(this.fY, fN);
        }
        h[] hVarArr = this.fY;
        int i = this.fZ;
        this.fZ = i + 1;
        hVarArr[i] = hVar;
        return hVar;
    }

    public static int h(Object obj) {
        h hVar = ((android.support.constraint.a.a.e) obj).hE;
        if (hVar != null) {
            return (int) (hVar.gQ + 0.5f);
        }
        return 0;
    }

    public final void b(a aVar) {
        f fVar;
        Object obj;
        if (gb != null) {
            fVar = gb;
            fVar.gw++;
            fVar = gb;
            fVar.gx = Math.max(fVar.gx, (long) this.mNumColumns);
            fVar = gb;
            fVar.gy = Math.max(fVar.gy, (long) this.fW);
        }
        a((b) aVar);
        int i = 0;
        while (i < this.fW) {
            if (this.fT[i].fF.gS != android.support.constraint.a.h.a.UNRESTRICTED && this.fT[i].fG < 0.0f) {
                obj = 1;
                break;
            }
            i++;
        }
        obj = null;
        if (obj != null) {
            int i2 = 0;
            for (Object obj2 = null; obj2 == null; obj2 = obj) {
                if (gb != null) {
                    fVar = gb;
                    fVar.gn++;
                }
                int i3 = i2 + 1;
                float f = Float.MAX_VALUE;
                int i4 = 0;
                int i5 = -1;
                i2 = -1;
                for (i = 0; i < this.fW; i++) {
                    b bVar = this.fT[i];
                    if (!(bVar.fF.gS == android.support.constraint.a.h.a.UNRESTRICTED || bVar.fJ || bVar.fG >= 0.0f)) {
                        int i6 = 1;
                        int i7 = i2;
                        int i8 = i5;
                        int i9 = i4;
                        float f2 = f;
                        while (i6 < this.mNumColumns) {
                            int i10;
                            h hVar = this.fw.fM[i6];
                            float b = bVar.fI.b(hVar);
                            if (b > 0.0f) {
                                int i11 = 0;
                                i2 = i7;
                                i4 = i8;
                                i10 = i9;
                                while (i11 < 7) {
                                    float f3 = hVar.gR[i11] / b;
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
                    b bVar2 = this.fT[i5];
                    bVar2.fF.gO = -1;
                    if (gb != null) {
                        f fVar2 = gb;
                        fVar2.gm++;
                    }
                    bVar2.d(this.fw.fM[i2]);
                    bVar2.fF.gO = i5;
                    bVar2.fF.f(bVar2);
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
        c(aVar);
        az();
    }

    private final void a(b bVar) {
        if (this.fW > 0) {
            bVar.fI.a(bVar, this.fT);
            if (bVar.fI.fu == 0) {
                bVar.fJ = true;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0219  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(b bVar) {
        if (bVar != null) {
            f fVar;
            Object obj;
            if (gb != null) {
                fVar = gb;
                fVar.gi++;
                if (bVar.fJ) {
                    fVar = gb;
                    fVar.gj++;
                }
            }
            if (this.fW + 1 >= this.fX || this.mNumColumns + 1 >= this.fS) {
                av();
            }
            if (bVar.fJ) {
                obj = null;
            } else {
                a(bVar);
                if (bVar.fF == null && bVar.fG == 0.0f && bVar.fI.fu == 0) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj == null) {
                    Object obj2;
                    if (bVar.fG < 0.0f) {
                        bVar.fG *= -1.0f;
                        a aVar = bVar.fI;
                        int i = aVar.fC;
                        int i2 = 0;
                        while (i != -1 && i2 < aVar.fu) {
                            float[] fArr = aVar.fB;
                            fArr[i] = fArr[i] * -1.0f;
                            i = aVar.fA[i];
                            i2++;
                        }
                    }
                    a aVar2 = bVar.fI;
                    h hVar = null;
                    h hVar2 = null;
                    float f = 0.0f;
                    float f2 = 0.0f;
                    boolean z = false;
                    boolean z2 = false;
                    int i3 = aVar2.fC;
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        int i6 = i3;
                        if (i6 != -1 && i5 < aVar2.fu) {
                            float f3 = aVar2.fB[i6];
                            h hVar3 = aVar2.fw.fM[aVar2.fz[i6]];
                            if (f3 < 0.0f) {
                                if (f3 > -0.001f) {
                                    aVar2.fB[i6] = 0.0f;
                                    f3 = 0.0f;
                                    hVar3.e(aVar2.fv);
                                }
                            } else if (f3 < 0.001f) {
                                aVar2.fB[i6] = 0.0f;
                                f3 = 0.0f;
                                hVar3.e(aVar2.fv);
                            }
                            if (f3 != 0.0f) {
                                if (hVar3.gS == android.support.constraint.a.h.a.UNRESTRICTED) {
                                    if (hVar2 == null) {
                                        z = a.a(hVar3);
                                        f = f3;
                                        hVar2 = hVar3;
                                    } else if (f > f3) {
                                        z = a.a(hVar3);
                                        f = f3;
                                        hVar2 = hVar3;
                                    } else if (!z && a.a(hVar3)) {
                                        z = true;
                                        f = f3;
                                        hVar2 = hVar3;
                                    }
                                } else if (hVar2 == null && f3 < 0.0f) {
                                    if (hVar == null) {
                                        z2 = a.a(hVar3);
                                        f2 = f3;
                                        hVar = hVar3;
                                    } else if (f2 > f3) {
                                        z2 = a.a(hVar3);
                                        f2 = f3;
                                        hVar = hVar3;
                                    } else if (!z2 && a.a(hVar3)) {
                                        z2 = true;
                                        f2 = f3;
                                        hVar = hVar3;
                                    }
                                }
                            }
                            i3 = aVar2.fA[i6];
                            i4 = i5 + 1;
                        } else if (hVar2 == null) {
                            hVar2 = hVar;
                        }
                    }
                    if (hVar2 == null) {
                    }
                    if (hVar2 == null) {
                        obj = 1;
                    } else {
                        bVar.d(hVar2);
                        obj = null;
                    }
                    if (bVar.fI.fu == 0) {
                        bVar.fJ = true;
                    }
                    if (obj != null) {
                        if (gb != null) {
                            fVar = gb;
                            fVar.gr++;
                        }
                        if (this.mNumColumns + 1 >= this.fS) {
                            av();
                        }
                        h a = a(android.support.constraint.a.h.a.SLACK);
                        this.fO++;
                        this.mNumColumns++;
                        a.id = this.fO;
                        this.fw.fM[this.fO] = a;
                        bVar.fF = a;
                        c(bVar);
                        obj = 1;
                        this.gc.a((a) bVar);
                        c(this.gc);
                        if (a.gO == -1) {
                            if (bVar.fF == a) {
                                a = bVar.fI.a(null, a);
                                if (a != null) {
                                    if (gb != null) {
                                        f fVar2 = gb;
                                        fVar2.gm++;
                                    }
                                    bVar.d(a);
                                }
                            }
                            if (!bVar.fJ) {
                                bVar.fF.f(bVar);
                            }
                            this.fW--;
                        }
                    } else {
                        obj = null;
                    }
                    if (bVar.fF == null || (bVar.fF.gS != android.support.constraint.a.h.a.UNRESTRICTED && bVar.fG < 0.0f)) {
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
                c(bVar);
            }
        }
    }

    private final void c(b bVar) {
        if (this.fT[this.fW] != null) {
            this.fw.fK.release(this.fT[this.fW]);
        }
        this.fT[this.fW] = bVar;
        bVar.fF.gO = this.fW;
        this.fW++;
        bVar.fF.f(bVar);
    }

    private final int c(a aVar) {
        int i;
        if (gb != null) {
            f fVar = gb;
            fVar.gk++;
        }
        for (i = 0; i < this.mNumColumns; i++) {
            this.fV[i] = false;
        }
        i = 0;
        boolean z = false;
        while (!z) {
            if (gb != null) {
                f fVar2 = gb;
                fVar2.gl++;
            }
            int i2 = i + 1;
            if (i2 >= this.mNumColumns * 2) {
                return i2;
            }
            if (aVar.at() != null) {
                this.fV[aVar.at().id] = true;
            }
            h a = aVar.a(this.fV);
            if (a != null) {
                if (this.fV[a.id]) {
                    return i2;
                }
                this.fV[a.id] = true;
            }
            if (a != null) {
                float f = Float.MAX_VALUE;
                int i3 = -1;
                for (i = 0; i < this.fW; i++) {
                    b bVar = this.fT[i];
                    if (!(bVar.fF.gS == android.support.constraint.a.h.a.UNRESTRICTED || bVar.fJ || !bVar.c(a))) {
                        float b = bVar.fI.b(a);
                        if (b < 0.0f) {
                            float f2 = (-bVar.fG) / b;
                            if (f2 < f) {
                                i3 = i;
                                f = f2;
                            }
                        }
                    }
                }
                if (i3 >= 0) {
                    b bVar2 = this.fT[i3];
                    bVar2.fF.gO = -1;
                    if (gb != null) {
                        f fVar3 = gb;
                        fVar3.gm++;
                    }
                    bVar2.d(a);
                    bVar2.fF.gO = i3;
                    bVar2.fF.f(bVar2);
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

    public final void az() {
        for (int i = 0; i < this.fW; i++) {
            b bVar = this.fT[i];
            bVar.fF.gQ = bVar.fG;
        }
    }

    public final void a(h hVar, h hVar2, int i, int i2) {
        b ax = ax();
        h ay = ay();
        ay.gP = 0;
        ax.a(hVar, hVar2, ay, i);
        if (i2 != 6) {
            a(ax, (int) (ax.fI.b(ay) * -1.0f), i2);
        }
        b(ax);
    }

    public final void b(h hVar, h hVar2, int i, int i2) {
        b ax = ax();
        h ay = ay();
        ay.gP = 0;
        ax.b(hVar, hVar2, ay, i);
        if (i2 != 6) {
            a(ax, (int) (ax.fI.b(ay) * -1.0f), i2);
        }
        b(ax);
    }

    public final void a(h hVar, h hVar2, int i, float f, h hVar3, h hVar4, int i2, int i3) {
        b ax = ax();
        if (hVar2 == hVar3) {
            ax.fI.a(hVar, 1.0f);
            ax.fI.a(hVar4, 1.0f);
            ax.fI.a(hVar2, -2.0f);
        } else if (f == 0.5f) {
            ax.fI.a(hVar, 1.0f);
            ax.fI.a(hVar2, -1.0f);
            ax.fI.a(hVar3, -1.0f);
            ax.fI.a(hVar4, 1.0f);
            if (i > 0 || i2 > 0) {
                ax.fG = (float) ((-i) + i2);
            }
        } else if (f <= 0.0f) {
            ax.fI.a(hVar, -1.0f);
            ax.fI.a(hVar2, 1.0f);
            ax.fG = (float) i;
        } else if (f >= 1.0f) {
            ax.fI.a(hVar3, -1.0f);
            ax.fI.a(hVar4, 1.0f);
            ax.fG = (float) i2;
        } else {
            ax.fI.a(hVar, (1.0f - f) * 1.0f);
            ax.fI.a(hVar2, (1.0f - f) * -1.0f);
            ax.fI.a(hVar3, -1.0f * f);
            ax.fI.a(hVar4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                ax.fG = (((float) (-i)) * (1.0f - f)) + (((float) i2) * f);
            }
        }
        if (i3 != 6) {
            ax.a(this, i3);
        }
        b(ax);
    }

    public final void c(h hVar, h hVar2, h hVar3, h hVar4, float f) {
        b ax = ax();
        ax.a(hVar, hVar2, hVar3, hVar4, f);
        b(ax);
    }

    public final b c(h hVar, h hVar2, int i, int i2) {
        b ax = ax();
        Object obj = null;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                obj = 1;
            }
            ax.fG = (float) i;
        }
        if (obj == null) {
            ax.fI.a(hVar, -1.0f);
            ax.fI.a(hVar2, 1.0f);
        } else {
            ax.fI.a(hVar, 1.0f);
            ax.fI.a(hVar2, -1.0f);
        }
        if (i2 != 6) {
            ax.a(this, i2);
        }
        b(ax);
        return ax;
    }

    public final void a(h hVar, int i) {
        int i2 = hVar.gO;
        b bVar;
        if (hVar.gO != -1) {
            bVar = this.fT[i2];
            if (bVar.fJ) {
                bVar.fG = (float) i;
                return;
            } else if (bVar.fI.fu == 0) {
                bVar.fJ = true;
                bVar.fG = (float) i;
                return;
            } else {
                bVar = ax();
                if (i < 0) {
                    bVar.fG = (float) (i * -1);
                    bVar.fI.a(hVar, 1.0f);
                } else {
                    bVar.fG = (float) i;
                    bVar.fI.a(hVar, -1.0f);
                }
                b(bVar);
                return;
            }
        }
        bVar = ax();
        bVar.fF = hVar;
        hVar.gQ = (float) i;
        bVar.fG = (float) i;
        bVar.fJ = true;
        b(bVar);
    }

    public static b a(e eVar, h hVar, h hVar2, h hVar3, float f, boolean z) {
        b ax = eVar.ax();
        if (z) {
            ax.a(eVar, 0);
        }
        ax.fI.a(hVar, -1.0f);
        ax.fI.a(hVar2, 1.0f - f);
        ax.fI.a(hVar3, f);
        return ax;
    }
}
