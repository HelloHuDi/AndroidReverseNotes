package android.support.constraint.a.a;

import android.support.constraint.a.a.e.b;
import android.support.constraint.a.a.e.c;
import android.support.constraint.a.a.f.a;
import android.support.constraint.a.e;
import android.support.constraint.a.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class g extends q {
    public int dl = 7;
    public boolean hq = false;
    int jA;
    int jB = 0;
    int jC = 0;
    d[] jD = new d[4];
    d[] jE = new d[4];
    public List<h> jF = new ArrayList();
    public boolean jG = false;
    public boolean jH = false;
    public boolean jI = false;
    public int jJ = 0;
    public int jK = 0;
    public boolean jL = false;
    public boolean jM = false;
    public boolean jN = false;
    int jO = 0;
    protected e jv = new e();
    private p jw;
    int jx;
    int jy;
    int jz;

    public final boolean z(int i) {
        return (this.dl & i) == i;
    }

    public final void reset() {
        this.jv.reset();
        this.jx = 0;
        this.jz = 0;
        this.jy = 0;
        this.jA = 0;
        this.jF.clear();
        this.jL = false;
        super.reset();
    }

    public final void u(int i) {
        super.u(i);
        int size = this.kx.size();
        for (int i2 = 0; i2 < size; i2++) {
            ((f) this.kx.get(i2)).u(i);
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
    public final void aZ() {
        int i;
        Object obj;
        Object obj2;
        f fVar;
        int i2;
        Object obj3;
        int i3 = this.iJ;
        int i4 = this.iK;
        int max = Math.max(0, getWidth());
        int max2 = Math.max(0, getHeight());
        this.jM = false;
        this.jN = false;
        if (this.iG != null) {
            if (this.jw == null) {
                this.jw = new p(this);
            }
            p pVar = this.jw;
            pVar.iJ = getX();
            pVar.iK = getY();
            pVar.mWidth = getWidth();
            pVar.mHeight = getHeight();
            int size = pVar.ku.size();
            for (i = 0; i < size; i++) {
                a aVar = (a) pVar.ku.get(i);
                aVar.kc = a(aVar.kc.hx);
                if (aVar.kc != null) {
                    aVar.hy = aVar.kc.hy;
                    aVar.hz = aVar.kc.aH();
                    aVar.kv = aVar.kc.hB;
                    aVar.kw = aVar.kc.hD;
                } else {
                    aVar.hy = null;
                    aVar.hz = 0;
                    aVar.kv = b.STRONG;
                    aVar.kw = 0;
                }
            }
            setX(this.jx);
            setY(this.jy);
            aV();
            a(this.jv.fw);
        } else {
            this.iJ = 0;
            this.iK = 0;
        }
        if (this.dl != 0) {
            if (!z(8)) {
                bb();
            }
            if (!z(32)) {
                if (!z(8)) {
                    u(this.dl);
                }
                ba();
            }
            this.jv.fU = true;
        } else {
            this.jv.fU = false;
        }
        Object obj4 = null;
        a aVar2 = this.iF[1];
        a aVar3 = this.iF[0];
        bc();
        if (this.jF.size() == 0) {
            this.jF.clear();
            this.jF.add(0, new h(this.kx));
        }
        int size2 = this.jF.size();
        ArrayList arrayList = this.kx;
        if (aW() == a.WRAP_CONTENT || aX() == a.WRAP_CONTENT) {
            obj = 1;
        } else {
            obj = null;
        }
        int i5 = 0;
        while (i5 < size2 && !this.jL) {
            if (((h) this.jF.get(i5)).jL) {
                obj2 = obj4;
            } else {
                h hVar;
                int size3;
                int i6;
                f fVar2;
                if (z(32)) {
                    if (aW() == a.FIXED && aX() == a.FIXED) {
                        List list;
                        hVar = (h) this.jF.get(i5);
                        if (hVar.jX.isEmpty()) {
                            size3 = hVar.jP.size();
                            for (i6 = 0; i6 < size3; i6++) {
                                fVar = (f) hVar.jP.get(i6);
                                if (!fVar.jd) {
                                    hVar.a((ArrayList) hVar.jX, fVar);
                                }
                            }
                            hVar.jY.clear();
                            hVar.jY.addAll(hVar.jP);
                            hVar.jY.removeAll(hVar.jX);
                            list = hVar.jX;
                        } else {
                            list = hVar.jX;
                        }
                        this.kx = (ArrayList) list;
                    } else {
                        this.kx = (ArrayList) ((h) this.jF.get(i5)).jP;
                    }
                }
                bc();
                int size4 = this.kx.size();
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    if (i8 >= size4) {
                        break;
                    }
                    fVar2 = (f) this.kx.get(i8);
                    if (fVar2 instanceof q) {
                        ((q) fVar2).aZ();
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
                        this.jv.reset();
                        bc();
                        b(this.jv);
                        for (i = 0; i < size4; i++) {
                            ((f) this.kx.get(i)).b(this.jv);
                        }
                        e eVar = this.jv;
                        a(eVar);
                        size5 = this.kx.size();
                        for (i = 0; i < size5; i++) {
                            fVar2 = (f) this.kx.get(i);
                            if (fVar2 instanceof g) {
                                a aVar4 = fVar2.iF[0];
                                a aVar5 = fVar2.iF[1];
                                if (aVar4 == a.WRAP_CONTENT) {
                                    fVar2.a(a.FIXED);
                                }
                                if (aVar5 == a.WRAP_CONTENT) {
                                    fVar2.b(a.FIXED);
                                }
                                fVar2.a(eVar);
                                if (aVar4 == a.WRAP_CONTENT) {
                                    fVar2.a(aVar4);
                                }
                                if (aVar5 == a.WRAP_CONTENT) {
                                    fVar2.b(aVar5);
                                }
                            } else {
                                k.a(this, eVar, fVar2);
                                fVar2.a(eVar);
                            }
                        }
                        if (this.jB > 0) {
                            c.a(this, eVar, 0);
                        }
                        if (this.jC > 0) {
                            c.a(this, eVar, 1);
                        }
                        obj3 = 1;
                        try {
                            f fVar3;
                            eVar = this.jv;
                            if (e.gb != null) {
                                fVar3 = e.gb;
                                fVar3.gh++;
                            }
                            if (eVar.fU) {
                                if (e.gb != null) {
                                    fVar3 = e.gb;
                                    fVar3.gu++;
                                }
                                obj6 = 1;
                                for (i6 = 0; i6 < eVar.fW; i6++) {
                                    if (!eVar.fT[i6].fJ) {
                                        obj6 = null;
                                        break;
                                    }
                                }
                                if (obj6 == null) {
                                    eVar.b(eVar.fQ);
                                } else {
                                    if (e.gb != null) {
                                        fVar3 = e.gb;
                                        fVar3.gt++;
                                    }
                                    eVar.az();
                                }
                            } else {
                                eVar.b(eVar.fQ);
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
                                fVar2 = (f) this.kx.get(i6);
                                size3 = Math.max(size3, fVar2.iJ + fVar2.getWidth());
                                size5 = Math.max(size5, fVar2.getHeight() + fVar2.iK);
                                i7 = i6 + 1;
                            }
                            i7 = Math.max(this.dg, size3);
                            i6 = Math.max(this.dh, size5);
                            if (aVar3 == a.WRAP_CONTENT) {
                            }
                            obj6 = null;
                            if (aVar2 == a.WRAP_CONTENT) {
                            }
                            obj3 = obj6;
                            i7 = Math.max(this.dg, getWidth());
                            if (i7 > getWidth()) {
                            }
                            i7 = Math.max(this.dh, getHeight());
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
                            fVar2 = (f) this.kx.get(i6);
                            size3 = Math.max(size3, fVar2.iJ + fVar2.getWidth());
                            size5 = Math.max(size5, fVar2.getHeight() + fVar2.iK);
                            i7 = i6 + 1;
                        }
                        i7 = Math.max(this.dg, size3);
                        i6 = Math.max(this.dh, size5);
                        if (aVar3 == a.WRAP_CONTENT) {
                        }
                        obj6 = null;
                        if (aVar2 == a.WRAP_CONTENT) {
                        }
                        obj3 = obj6;
                        i7 = Math.max(this.dg, getWidth());
                        if (i7 > getWidth()) {
                        }
                        i7 = Math.max(this.dh, getHeight());
                        if (i7 > getHeight()) {
                        }
                        if (obj2 == null) {
                        }
                        obj5 = obj6;
                        size3 = i2;
                        obj2 = obj3;
                    }
                    if (obj3 == null) {
                        aY();
                        i7 = 0;
                        while (true) {
                            i = i7;
                            if (i >= size4) {
                                break;
                            }
                            fVar2 = (f) this.kx.get(i);
                            if (fVar2.iF[0] != a.MATCH_CONSTRAINT || fVar2.getWidth() >= fVar2.iS) {
                                if (fVar2.iF[1] == a.MATCH_CONSTRAINT && fVar2.getHeight() < fVar2.iT) {
                                    k.ki[2] = true;
                                    break;
                                }
                                i7 = i + 1;
                            } else {
                                k.ki[2] = true;
                                break;
                            }
                        }
                    }
                    boolean[] zArr = k.ki;
                    zArr[2] = false;
                    aY();
                    size3 = this.kx.size();
                    for (i = 0; i < size3; i++) {
                        fVar2 = (f) this.kx.get(i);
                        fVar2.aY();
                        if (fVar2.iF[0] == a.MATCH_CONSTRAINT && fVar2.getWidth() < fVar2.iS) {
                            zArr[2] = true;
                        }
                        if (fVar2.iF[1] == a.MATCH_CONSTRAINT && fVar2.getHeight() < fVar2.iT) {
                            zArr[2] = true;
                        }
                    }
                    obj3 = null;
                    if (obj != null && i2 < 8 && k.ki[2]) {
                        size3 = 0;
                        size5 = 0;
                        i7 = 0;
                        while (true) {
                            i6 = i7;
                            if (i6 >= size4) {
                                break;
                            }
                            fVar2 = (f) this.kx.get(i6);
                            size3 = Math.max(size3, fVar2.iJ + fVar2.getWidth());
                            size5 = Math.max(size5, fVar2.getHeight() + fVar2.iK);
                            i7 = i6 + 1;
                        }
                        i7 = Math.max(this.dg, size3);
                        i6 = Math.max(this.dh, size5);
                        if (aVar3 == a.WRAP_CONTENT || getWidth() >= i7) {
                            obj6 = null;
                        } else {
                            setWidth(i7);
                            this.iF[0] = a.WRAP_CONTENT;
                            obj6 = 1;
                            obj2 = 1;
                        }
                        if (aVar2 == a.WRAP_CONTENT || getHeight() >= i6) {
                            obj3 = obj6;
                        } else {
                            setHeight(i6);
                            this.iF[1] = a.WRAP_CONTENT;
                            obj2 = 1;
                            obj3 = 1;
                        }
                    }
                    i7 = Math.max(this.dg, getWidth());
                    if (i7 > getWidth()) {
                        setWidth(i7);
                        this.iF[0] = a.FIXED;
                        obj2 = 1;
                        obj3 = 1;
                    }
                    i7 = Math.max(this.dh, getHeight());
                    if (i7 > getHeight()) {
                        setHeight(i7);
                        this.iF[1] = a.FIXED;
                        obj2 = 1;
                        obj6 = 1;
                    } else {
                        obj6 = obj3;
                    }
                    if (obj2 == null) {
                        if (this.iF[0] != a.WRAP_CONTENT || max <= 0 || getWidth() <= max) {
                            obj3 = obj2;
                        } else {
                            this.jM = true;
                            obj3 = 1;
                            this.iF[0] = a.FIXED;
                            setWidth(max);
                            obj6 = 1;
                        }
                        if (this.iF[1] == a.WRAP_CONTENT && max2 > 0 && getHeight() > max2) {
                            this.jN = true;
                            obj3 = 1;
                            this.iF[1] = a.FIXED;
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
                hVar = (h) this.jF.get(i5);
                size3 = hVar.jY.size();
                for (i6 = 0; i6 < size3; i6++) {
                    hVar.d((f) hVar.jY.get(i6));
                }
            }
            i5++;
            obj4 = obj2;
        }
        this.kx = arrayList;
        if (this.iG != null) {
            i5 = Math.max(this.dg, getWidth());
            i3 = Math.max(this.dh, getHeight());
            p pVar2 = this.jw;
            setX(pVar2.iJ);
            setY(pVar2.iK);
            setWidth(pVar2.mWidth);
            setHeight(pVar2.mHeight);
            max = pVar2.ku.size();
            for (i2 = 0; i2 < max; i2++) {
                a aVar6 = (a) pVar2.ku.get(i2);
                a(aVar6.kc.hx).a(aVar6.hy, aVar6.hz, -1, aVar6.kv, aVar6.kw, false);
            }
            setWidth((this.jx + i5) + this.jz);
            setHeight((this.jy + i3) + this.jA);
        } else {
            this.iJ = i3;
            this.iK = i4;
        }
        if (obj4 != null) {
            this.iF[0] = aVar3;
            this.iF[1] = aVar2;
        }
        a(this.jv.fw);
        fVar = this.iG;
        g gVar = this;
        while (fVar != null) {
            f fVar4 = fVar.iG;
            if (fVar instanceof g) {
                gVar = (g) fVar;
                fVar = fVar4;
            } else {
                fVar = fVar4;
            }
        }
        if (this == gVar) {
            aU();
        }
    }

    public final void ba() {
        m mVar = a(c.LEFT).hv;
        m mVar2 = a(c.TOP).hv;
        mVar.a(null, 0.0f);
        mVar2.a(null, 0.0f);
    }

    public final void j(int i, int i2) {
        if (!(this.iF[0] == a.WRAP_CONTENT || this.hZ == null)) {
            this.hZ.E(i);
        }
        if (this.iF[1] != a.WRAP_CONTENT && this.ia != null) {
            this.ia.E(i2);
        }
    }

    public final void bb() {
        int size = this.kx.size();
        aD();
        for (int i = 0; i < size; i++) {
            ((f) this.kx.get(i)).aD();
        }
    }

    private void bc() {
        this.jB = 0;
        this.jC = 0;
    }

    /* Access modifiers changed, original: final */
    public final void b(f fVar, int i) {
        if (i == 0) {
            b(fVar);
        } else if (i == 1) {
            c(fVar);
        }
    }

    private void b(f fVar) {
        if (this.jB + 1 >= this.jE.length) {
            this.jE = (d[]) Arrays.copyOf(this.jE, this.jE.length * 2);
        }
        this.jE[this.jB] = new d(fVar, 0, this.hq);
        this.jB++;
    }

    private void c(f fVar) {
        if (this.jC + 1 >= this.jD.length) {
            this.jD = (d[]) Arrays.copyOf(this.jD, this.jD.length * 2);
        }
        this.jD[this.jC] = new d(fVar, 1, this.hq);
        this.jC++;
    }
}
