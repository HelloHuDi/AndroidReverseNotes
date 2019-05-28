package android.support.constraint.a.a;

import android.support.constraint.a.a.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a {
    public static void a(g gVar) {
        if ((gVar.dl & 32) != 32) {
            b(gVar);
            return;
        }
        boolean z;
        boolean z2;
        gVar.jL = true;
        gVar.jG = false;
        gVar.jH = false;
        gVar.jI = false;
        ArrayList<f> arrayList = gVar.kx;
        List<h> list = gVar.jF;
        boolean z3 = gVar.aW() == android.support.constraint.a.a.f.a.WRAP_CONTENT;
        if (gVar.aX() == android.support.constraint.a.a.f.a.WRAP_CONTENT) {
            z = true;
        } else {
            z = false;
        }
        if (z3 || z) {
            z2 = true;
        } else {
            z2 = false;
        }
        list.clear();
        for (f fVar : arrayList) {
            fVar.ir = null;
            fVar.jf = false;
            fVar.aD();
        }
        for (f fVar2 : arrayList) {
            if (fVar2.ir == null) {
                h hVar = new h(new ArrayList(), (byte) 0);
                list.add(hVar);
                if (!a(fVar2, hVar, (List) list, z2)) {
                    b(gVar);
                    gVar.jL = false;
                    return;
                }
            }
        }
        int i = 0;
        int i2 = 0;
        for (h hVar2 : list) {
            i2 = Math.max(i2, a(hVar2, 0));
            i = Math.max(i, a(hVar2, 1));
        }
        if (z3) {
            gVar.a(android.support.constraint.a.a.f.a.FIXED);
            gVar.setWidth(i2);
            gVar.jG = true;
            gVar.jH = true;
            gVar.jJ = i2;
        }
        if (z) {
            gVar.b(android.support.constraint.a.a.f.a.FIXED);
            gVar.setHeight(i);
            gVar.jG = true;
            gVar.jI = true;
            gVar.jK = i;
        }
        a((List) list, 0, gVar.getWidth());
        a((List) list, 1, gVar.getHeight());
    }

    private static boolean a(f fVar, h hVar, List<h> list, boolean z) {
        if (fVar == null) {
            return true;
        }
        fVar.je = false;
        g gVar = (g) fVar.iG;
        if (fVar.ir == null) {
            android.support.constraint.a.a.f.a aVar;
            int i;
            fVar.jd = true;
            hVar.jP.add(fVar);
            fVar.ir = hVar;
            if (fVar.iu.hy == null && fVar.ix.hy == null && fVar.iw.hy == null && fVar.iy.hy == null && fVar.iz.hy == null && fVar.iC.hy == null) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (!(fVar.iw.hy == null || fVar.iy.hy == null)) {
                aVar = android.support.constraint.a.a.f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.iw.hy.hw == fVar.iG && fVar.iy.hy.hw == fVar.iG)) {
                    a(gVar, fVar, hVar);
                }
            }
            if (!(fVar.iu.hy == null || fVar.ix.hy == null)) {
                aVar = android.support.constraint.a.a.f.a.WRAP_CONTENT;
                if (z) {
                    a(gVar, fVar, hVar);
                    return false;
                } else if (!(fVar.iu.hy.hw == fVar.iG && fVar.ix.hy.hw == fVar.iG)) {
                    a(gVar, fVar, hVar);
                }
            }
            int i2 = fVar.aW() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT ? 1 : 0;
            if (fVar.aX() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT) {
                i = 1;
            } else {
                i = 0;
            }
            if ((i2 ^ i) != 0 && fVar.iH != 0.0f) {
                a(fVar);
            } else if (fVar.aW() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT || fVar.aX() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
            }
            if (((fVar.iu.hy == null && fVar.ix.hy == null) || ((fVar.iu.hy != null && fVar.iu.hy.hw == fVar.iG && fVar.ix.hy == null) || ((fVar.ix.hy != null && fVar.ix.hy.hw == fVar.iG && fVar.iu.hy == null) || (fVar.iu.hy != null && fVar.iu.hy.hw == fVar.iG && fVar.ix.hy != null && fVar.ix.hy.hw == fVar.iG)))) && fVar.iC.hy == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.jT.add(fVar);
            }
            if (((fVar.iw.hy == null && fVar.iy.hy == null) || ((fVar.iw.hy != null && fVar.iw.hy.hw == fVar.iG && fVar.iy.hy == null) || ((fVar.iy.hy != null && fVar.iy.hy.hw == fVar.iG && fVar.iw.hy == null) || (fVar.iw.hy != null && fVar.iw.hy.hw == fVar.iG && fVar.iy.hy != null && fVar.iy.hy.hw == fVar.iG)))) && fVar.iC.hy == null && fVar.iz.hy == null && !(fVar instanceof i) && !(fVar instanceof j)) {
                hVar.jU.add(fVar);
            }
            if (fVar instanceof j) {
                a(gVar, fVar, hVar);
                if (z) {
                    return false;
                }
                j jVar = (j) fVar;
                for (i = 0; i < jVar.hn; i++) {
                    if (!a(jVar.kh[i], hVar, (List) list, z)) {
                        return false;
                    }
                }
            }
            for (e eVar : fVar.iD) {
                if (!(eVar.hy == null || eVar.hy.hw == fVar.iG)) {
                    if (eVar.hx == c.CENTER) {
                        a(gVar, fVar, hVar);
                        if (z) {
                            return false;
                        }
                    }
                    m mVar = eVar.hv;
                    if (!(eVar.hy == null || eVar.hy.hy == eVar)) {
                        eVar.hy.hv.a(mVar);
                    }
                    if (!a(eVar.hy.hw, hVar, (List) list, z)) {
                        return false;
                    }
                }
            }
            return true;
        }
        if (fVar.ir != hVar) {
            hVar.jP.addAll(fVar.ir.jP);
            hVar.jT.addAll(fVar.ir.jT);
            hVar.jU.addAll(fVar.ir.jU);
            if (!fVar.ir.jL) {
                hVar.jL = false;
            }
            list.remove(fVar.ir);
            for (f fVar2 : fVar.ir.jP) {
                fVar2.ir = hVar;
            }
        }
        return true;
    }

    private static void a(g gVar, f fVar, h hVar) {
        hVar.jL = false;
        gVar.jL = false;
        fVar.jd = false;
    }

    private static int a(h hVar, int i) {
        List list;
        int i2 = i * 2;
        if (i == 0) {
            list = hVar.jT;
        } else if (i == 1) {
            list = hVar.jU;
        } else {
            list = null;
        }
        int size = list.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size) {
            f fVar = (f) list.get(i3);
            boolean z = fVar.iD[i2 + 1].hy == null || !(fVar.iD[i2].hy == null || fVar.iD[i2 + 1].hy == null);
            i3++;
            i4 = Math.max(i4, a(fVar, i, z, 0));
        }
        hVar.jS[i] = i4;
        return i4;
    }

    private static int a(f fVar, int i, boolean z, int i2) {
        if (!fVar.jd) {
            return 0;
        }
        int i3;
        int height;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        Object obj = (fVar.iz.hy == null || i != 1) ? null : 1;
        if (z) {
            i3 = fVar.iR;
            height = fVar.getHeight() - fVar.iR;
            i4 = i * 2;
            i5 = i4 + 1;
        } else {
            i3 = fVar.getHeight() - fVar.iR;
            height = fVar.iR;
            i5 = i * 2;
            i4 = i5 + 1;
        }
        if (fVar.iD[i5].hy == null || fVar.iD[i4].hy != null) {
            i6 = 1;
            i7 = i5;
            i8 = i4;
        } else {
            i6 = -1;
            i7 = i4;
            i8 = i5;
        }
        if (obj != null) {
            i2 -= i3;
        }
        int aH = (fVar.iD[i8].aH() * i6) + a(fVar, i);
        int i10 = aH + i2;
        int width = (i == 0 ? fVar.getWidth() : fVar.getHeight()) * i6;
        Iterator it = fVar.iD[i8].hv.kt.iterator();
        i4 = 0;
        while (it.hasNext()) {
            i4 = Math.max(i4, a(((m) ((o) it.next())).kj.hw, i, z, i10));
        }
        it = fVar.iD[i7].hv.kt.iterator();
        int i11 = 0;
        while (it.hasNext()) {
            i11 = Math.max(i11, a(((m) ((o) it.next())).kj.hw, i, z, width + i10));
        }
        if (obj != null) {
            i11 += height;
            i9 = i4 - i3;
        } else {
            i11 = ((i == 0 ? fVar.getWidth() : fVar.getHeight()) * i6) + i11;
            i9 = i4;
        }
        i5 = 0;
        if (i == 1) {
            it = fVar.iz.hv.kt.iterator();
            while (true) {
                i4 = i5;
                if (!it.hasNext()) {
                    break;
                }
                m mVar = (m) ((o) it.next());
                if (i6 == 1) {
                    i5 = Math.max(i4, a(mVar.kj.hw, i, z, i3 + i10));
                } else {
                    i5 = Math.max(i4, a(mVar.kj.hw, i, z, (height * i6) + i10));
                }
            }
            if (fVar.iz.hv.kt.size() > 0 && obj == null) {
                i4 = i6 == 1 ? i4 + i3 : i4 - height;
            }
        } else {
            i4 = 0;
        }
        i5 = Math.max(i9, Math.max(i11, i4)) + aH;
        height = i2 + aH;
        i3 = height + width;
        if (i6 == -1) {
            i4 = height;
            i11 = i3;
        } else {
            i4 = i3;
            i11 = height;
        }
        if (z) {
            k.b(fVar, i, i11);
            fVar.e(i11, i4, i);
        } else {
            fVar.ir.c(fVar, i);
            fVar.i(i11, i);
        }
        if (fVar.x(i) == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT && fVar.iH != 0.0f) {
            fVar.ir.c(fVar, i);
        }
        if (fVar.iD[i8].hy == null || fVar.iD[i7].hy == null) {
            return i5;
        }
        f fVar2 = fVar.iG;
        if (fVar.iD[i8].hy.hw != fVar2 || fVar.iD[i7].hy.hw != fVar2) {
            return i5;
        }
        fVar.ir.c(fVar, i);
        return i5;
    }

    private static void b(g gVar) {
        gVar.jF.clear();
        gVar.jF.add(0, new h(gVar.kx));
    }

    public static void a(List<h> list, int i, int i2) {
        int size = list.size();
        for (int i3 = 0; i3 < size; i3++) {
            for (f fVar : ((h) list.get(i3)).A(i)) {
                if (fVar.jd) {
                    a(fVar, i, i2);
                }
            }
        }
    }

    private static void a(f fVar, int i, int i2) {
        int i3 = i * 2;
        e eVar = fVar.iD[i3];
        e eVar2 = fVar.iD[i3 + 1];
        int i4 = (eVar.hy == null || eVar2.hy == null) ? 0 : 1;
        if (i4 != 0) {
            k.b(fVar, i, a(fVar, i) + eVar.aH());
        } else if (fVar.iH == 0.0f || fVar.x(i) != android.support.constraint.a.a.f.a.MATCH_CONSTRAINT) {
            i4 = i2 - fVar.w(i);
            int v = i4 - fVar.v(i);
            fVar.e(v, i4, i);
            k.b(fVar, i, v);
        } else {
            i4 = a(fVar);
            i3 = (int) fVar.iD[i3].hv.km;
            int i5 = i3 + i4;
            eVar2.hv.kl = eVar.hv;
            eVar2.hv.km = (float) i4;
            eVar2.hv.state = 1;
            fVar.e(i3, i5, i);
        }
    }

    private static int a(f fVar, int i) {
        int i2 = i * 2;
        e eVar = fVar.iD[i2];
        e eVar2 = fVar.iD[i2 + 1];
        if (eVar.hy == null || eVar.hy.hw != fVar.iG || eVar2.hy == null || eVar2.hy.hw != fVar.iG) {
            return 0;
        }
        return (int) ((i == 0 ? fVar.iV : fVar.iW) * ((float) (((fVar.iG.v(i) - eVar.aH()) - eVar2.aH()) - fVar.v(i))));
    }

    private static int a(f fVar) {
        int i = -1;
        if (fVar.aW() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT) {
            if (fVar.iI == 0) {
                i = (int) (((float) fVar.getHeight()) * fVar.iH);
            } else {
                i = (int) (((float) fVar.getHeight()) / fVar.iH);
            }
            fVar.setWidth(i);
        } else if (fVar.aX() == android.support.constraint.a.a.f.a.MATCH_CONSTRAINT) {
            if (fVar.iI == 1) {
                i = (int) (((float) fVar.getWidth()) * fVar.iH);
            } else {
                i = (int) (((float) fVar.getWidth()) / fVar.iH);
            }
            fVar.setHeight(i);
        }
        return i;
    }
}
