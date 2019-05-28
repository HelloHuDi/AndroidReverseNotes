package android.support.constraint.a.a;

import android.support.constraint.a.a.e.c;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class h {
    public boolean jL = false;
    public List<f> jP;
    int jQ = -1;
    int jR = -1;
    public final int[] jS = new int[]{this.jQ, this.jR};
    List<f> jT = new ArrayList();
    List<f> jU = new ArrayList();
    HashSet<f> jV = new HashSet();
    HashSet<f> jW = new HashSet();
    List<f> jX = new ArrayList();
    List<f> jY = new ArrayList();

    h(List<f> list) {
        this.jP = list;
    }

    h(List<f> list, byte b) {
        this.jP = list;
        this.jL = true;
    }

    /* Access modifiers changed, original: final */
    public final Set<f> A(int i) {
        if (i == 0) {
            return this.jV;
        }
        if (i == 1) {
            return this.jW;
        }
        return null;
    }

    /* Access modifiers changed, original: final */
    public final void c(f fVar, int i) {
        if (i == 0) {
            this.jV.add(fVar);
        } else if (i == 1) {
            this.jW.add(fVar);
        }
    }

    /* Access modifiers changed, original: final */
    public final void a(ArrayList<f> arrayList, f fVar) {
        if (!fVar.jf) {
            arrayList.add(fVar);
            fVar.jf = true;
            if (!fVar.aL()) {
                int i;
                if (fVar instanceof j) {
                    j jVar = (j) fVar;
                    int i2 = jVar.hn;
                    for (i = 0; i < i2; i++) {
                        a(arrayList, jVar.kh[i]);
                    }
                }
                for (e eVar : fVar.iD) {
                    e eVar2 = eVar2.hy;
                    if (eVar2 != null) {
                        f fVar2 = eVar2.hw;
                        if (!(eVar2 == null || fVar2 == fVar.iG)) {
                            a(arrayList, fVar2);
                        }
                    }
                }
            }
        }
    }

    /* Access modifiers changed, original: final */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(f fVar) {
        if (fVar.jd && !fVar.aL()) {
            e eVar;
            int width;
            boolean z = fVar.ix.hy != null;
            if (z) {
                eVar = fVar.ix.hy;
            } else {
                eVar = fVar.iu.hy;
            }
            if (eVar != null) {
                if (!eVar.hw.je) {
                    d(eVar.hw);
                }
                if (eVar.hx == c.RIGHT) {
                    width = eVar.hw.getWidth() + eVar.hw.iJ;
                } else if (eVar.hx == c.LEFT) {
                    width = eVar.hw.iJ;
                }
                if (z) {
                    width += fVar.iu.aH() + fVar.getWidth();
                } else {
                    width -= fVar.ix.aH();
                }
                fVar.g(width - fVar.getWidth(), width);
                if (fVar.iz.hy == null) {
                    eVar = fVar.iz.hy;
                    if (!eVar.hw.je) {
                        d(eVar.hw);
                    }
                    width = (eVar.hw.iR + eVar.hw.iK) - fVar.iR;
                    fVar.h(width, fVar.mHeight + width);
                    fVar.je = true;
                    return;
                }
                e eVar2;
                z = fVar.iy.hy != null;
                if (z) {
                    eVar2 = fVar.iy.hy;
                } else {
                    eVar2 = fVar.iw.hy;
                }
                if (eVar2 != null) {
                    if (!eVar2.hw.je) {
                        d(eVar2.hw);
                    }
                    if (eVar2.hx == c.BOTTOM) {
                        width = eVar2.hw.iK + eVar2.hw.getHeight();
                    } else if (eVar2.hx == c.TOP) {
                        width = eVar2.hw.iK;
                    }
                }
                if (z) {
                    width -= fVar.iy.aH();
                } else {
                    width += fVar.iw.aH() + fVar.getHeight();
                }
                fVar.h(width - fVar.getHeight(), width);
                fVar.je = true;
                return;
            }
            width = 0;
            if (z) {
            }
            fVar.g(width - fVar.getWidth(), width);
            if (fVar.iz.hy == null) {
            }
        }
    }
}
