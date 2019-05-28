package com.google.android.exoplayer2.source.b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.g.f;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.source.b.a.e;
import com.google.android.exoplayer2.source.b.a.e.b;
import com.google.android.exoplayer2.source.b.j.a;
import com.google.android.exoplayer2.source.h;
import com.google.android.exoplayer2.source.k;
import com.google.android.exoplayer2.source.l;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

public final class g implements b, a, h {
    private p aNe;
    private final int bgC;
    private final com.google.android.exoplayer2.h.b bgF;
    private h.a bgq;
    private final k bip = new k();
    final e bir;
    private final d bjb;
    private final com.google.android.exoplayer2.source.a.a bjc;
    private final IdentityHashMap<l, Integer> bjd = new IdentityHashMap();
    final Handler bje = new Handler();
    private int bjf;
    j[] bjg = new j[0];
    private j[] bjh = new j[0];
    private com.google.android.exoplayer2.source.e bji;

    public g(e eVar, d dVar, int i, com.google.android.exoplayer2.source.a.a aVar, com.google.android.exoplayer2.h.b bVar) {
        AppMethodBeat.i(125910);
        this.bir = eVar;
        this.bjb = dVar;
        this.bgC = i;
        this.bjc = aVar;
        this.bgF = bVar;
        AppMethodBeat.o(125910);
    }

    public final void a(h.a aVar, long j) {
        int i;
        com.google.android.exoplayer2.source.b.a.a.a aVar2;
        List list;
        int i2;
        int i3;
        AppMethodBeat.i(125911);
        this.bgq = aVar;
        this.bir.bkF.add(this);
        com.google.android.exoplayer2.source.b.a.a aVar3 = this.bir.biH;
        ArrayList arrayList = new ArrayList(aVar3.bjF);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            aVar2 = (com.google.android.exoplayer2.source.b.a.a.a) arrayList.get(i);
            if (aVar2.aOv.height > 0 || a(aVar2, "avc")) {
                arrayList2.add(aVar2);
            } else if (a(aVar2, "mp4a")) {
                arrayList3.add(aVar2);
            }
            i4 = i + 1;
        }
        if (arrayList2.isEmpty()) {
            if (arrayList3.size() < arrayList.size()) {
                arrayList.removeAll(arrayList3);
            }
            Object list2 = arrayList;
        } else {
            list2 = arrayList2;
        }
        List list3 = aVar3.bjG;
        List list4 = aVar3.bjH;
        this.bjg = new j[((list3.size() + 1) + list4.size())];
        this.bjf = this.bjg.length;
        com.google.android.exoplayer2.i.a.checkArgument(!list2.isEmpty());
        com.google.android.exoplayer2.source.b.a.a.a[] aVarArr = new com.google.android.exoplayer2.source.b.a.a.a[list2.size()];
        list2.toArray(aVarArr);
        j a = a(0, aVarArr, aVar3.bjp, aVar3.bit, j);
        i4 = 1;
        this.bjg[0] = a;
        a.aJ(true);
        a.sz();
        i = 0;
        while (true) {
            i2 = i4;
            i3 = i;
            if (i3 >= list3.size()) {
                break;
            }
            a = a(1, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list3.get(i3)}, null, Collections.emptyList(), j);
            i4 = i2 + 1;
            this.bjg[i2] = a;
            a.sz();
            i = i3 + 1;
        }
        for (i3 = 0; i3 < list4.size(); i3++) {
            a = a(3, new com.google.android.exoplayer2.source.b.a.a.a[]{(com.google.android.exoplayer2.source.b.a.a.a) list4.get(i3)}, null, Collections.emptyList(), j);
            a.es(0).f(aVar2.aOv);
            a.bgQ = true;
            a.sB();
            i4 = i2 + 1;
            this.bjg[i2] = a;
            i2 = i4;
        }
        this.bjh = this.bjg;
        AppMethodBeat.o(125911);
    }

    public final void rR() {
        AppMethodBeat.i(125912);
        for (j jVar : this.bjg) {
            jVar.bjo.rW();
        }
        AppMethodBeat.o(125912);
    }

    public final p rS() {
        return this.aNe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long a(f[] fVarArr, boolean[] zArr, l[] lVarArr, boolean[] zArr2, long j) {
        int i;
        AppMethodBeat.i(125913);
        int[] iArr = new int[fVarArr.length];
        int[] iArr2 = new int[fVarArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= fVarArr.length) {
                break;
            }
            if (lVarArr[i] == null) {
                i2 = -1;
            } else {
                i2 = ((Integer) this.bjd.get(lVarArr[i])).intValue();
            }
            iArr[i] = i2;
            iArr2[i] = -1;
            if (fVarArr[i] != null) {
                o tf = fVarArr[i].tf();
                for (i2 = 0; i2 < this.bjg.length; i2++) {
                    if (this.bjg[i2].aNe.a(tf) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                }
            }
            i2 = i + 1;
        }
        boolean z = false;
        this.bjd.clear();
        l[] lVarArr2 = new l[fVarArr.length];
        l[] lVarArr3 = new l[fVarArr.length];
        f[] fVarArr2 = new f[fVarArr.length];
        int i3 = 0;
        j[] jVarArr = new j[this.bjg.length];
        i2 = 0;
        while (true) {
            i = i2;
            if (i < this.bjg.length) {
                Object obj;
                i2 = 0;
                while (i2 < fVarArr.length) {
                    lVarArr3[i2] = iArr[i2] == i ? lVarArr[i2] : null;
                    fVarArr2[i2] = iArr2[i2] == i ? fVarArr[i2] : null;
                    i2++;
                }
                j jVar = this.bjg[i];
                com.google.android.exoplayer2.i.a.checkState(jVar.prepared);
                int i4 = jVar.bgT;
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= fVarArr2.length) {
                        break;
                    }
                    if (lVarArr3[i5] != null && (fVarArr2[i5] == null || !zArr[i5])) {
                        jVar.r(((i) lVarArr3[i5]).bjl, false);
                        lVarArr3[i5] = null;
                    }
                    i2 = i5 + 1;
                }
                if (z || (jVar.bgR ? i4 == 0 : j != jVar.bgZ)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                f fVar = jVar.bjo.biB;
                i4 = 0;
                Object obj2 = obj;
                Object obj3 = fVar;
                while (i4 < fVarArr2.length) {
                    if (lVarArr3[i4] == null && fVarArr2[i4] != null) {
                        f fVar2 = fVarArr2[i4];
                        int a = jVar.aNe.a(fVar2.tf());
                        jVar.r(a, true);
                        if (a == jVar.bju) {
                            jVar.bjo.biB = fVar2;
                            obj3 = fVar2;
                        }
                        lVarArr3[i4] = new i(jVar, a);
                        zArr2[i4] = true;
                        if (obj2 == null) {
                            k kVar = jVar.bgO[a];
                            kVar.rewind();
                            if (kVar.g(j, true) || kVar.bhG.sj() == 0) {
                                obj = null;
                                i4++;
                                obj2 = obj;
                            } else {
                                obj = 1;
                                i4++;
                                obj2 = obj;
                            }
                        }
                    }
                    obj = obj2;
                    i4++;
                    obj2 = obj;
                }
                if (jVar.bgT == 0) {
                    jVar.bjo.biw = null;
                    jVar.bjs = null;
                    jVar.bjr.clear();
                    if (jVar.bgI.isLoading()) {
                        for (k sq : jVar.bgO) {
                            sq.sq();
                        }
                        jVar.bgI.cancelLoading();
                    } else {
                        jVar.sA();
                    }
                } else {
                    boolean z2;
                    if (!(jVar.bjr.isEmpty() || v.j(obj3, fVar))) {
                        if (jVar.bgR) {
                            obj = 1;
                        } else {
                            obj3.ag(0);
                            if (obj3.th() != jVar.bjo.bis.j(((f) jVar.bjr.getLast()).bic)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            z2 = true;
                            obj2 = 1;
                            jVar.bjy = true;
                            if (obj2 != null) {
                                jVar.j(j, z2);
                                for (i2 = 0; i2 < lVarArr3.length; i2++) {
                                    if (lVarArr3[i2] != null) {
                                        zArr2[i2] = true;
                                    }
                                }
                            }
                        }
                    }
                    z2 = z;
                    if (obj2 != null) {
                    }
                }
                jVar.bgR = true;
                obj = null;
                for (i4 = 0; i4 < fVarArr.length; i4++) {
                    if (iArr2[i4] == i) {
                        com.google.android.exoplayer2.i.a.checkState(lVarArr3[i4] != null);
                        lVarArr2[i4] = lVarArr3[i4];
                        obj = 1;
                        this.bjd.put(lVarArr3[i4], Integer.valueOf(i));
                    } else if (iArr[i4] == i) {
                        com.google.android.exoplayer2.i.a.checkState(lVarArr3[i4] == null);
                    }
                }
                if (obj != null) {
                    jVarArr[i3] = jVar;
                    i2 = i3 + 1;
                    if (i3 == 0) {
                        jVar.aJ(true);
                        if (!(obj2 == null && this.bjh.length != 0 && jVar == this.bjh[0])) {
                            this.bip.bjA.clear();
                            z = true;
                            i3 = i2;
                        }
                    } else {
                        jVar.aJ(false);
                    }
                    i3 = i2;
                }
                i2 = i + 1;
            } else {
                System.arraycopy(lVarArr2, 0, lVarArr, 0, lVarArr2.length);
                this.bjh = (j[]) Arrays.copyOf(jVarArr, i3);
                this.bji = new com.google.android.exoplayer2.source.e(this.bjh);
                AppMethodBeat.o(125913);
                return j;
            }
        }
    }

    public final void W(long j) {
        AppMethodBeat.i(125914);
        for (j jVar : this.bjh) {
            int length = jVar.bgO.length;
            for (int i = 0; i < length; i++) {
                jVar.bgO[i].i(j, jVar.bjw[i]);
            }
        }
        AppMethodBeat.o(125914);
    }

    public final boolean Y(long j) {
        AppMethodBeat.i(125915);
        boolean Y = this.bji.Y(j);
        AppMethodBeat.o(125915);
        return Y;
    }

    public final long rV() {
        AppMethodBeat.i(125916);
        long rV = this.bji.rV();
        AppMethodBeat.o(125916);
        return rV;
    }

    public final long rT() {
        return -9223372036854775807L;
    }

    public final long rU() {
        AppMethodBeat.i(125917);
        long rU = this.bji.rU();
        AppMethodBeat.o(125917);
        return rU;
    }

    public final long X(long j) {
        AppMethodBeat.i(125918);
        if (this.bjh.length > 0) {
            boolean j2 = this.bjh[0].j(j, false);
            for (int i = 1; i < this.bjh.length; i++) {
                this.bjh[i].j(j, j2);
            }
            if (j2) {
                this.bip.bjA.clear();
            }
        }
        AppMethodBeat.o(125918);
        return j;
    }

    public final void pL() {
        AppMethodBeat.i(125919);
        int i = this.bjf - 1;
        this.bjf = i;
        if (i > 0) {
            AppMethodBeat.o(125919);
            return;
        }
        int i2 = 0;
        for (j jVar : this.bjg) {
            i2 += jVar.aNe.length;
        }
        o[] oVarArr = new o[i2];
        i2 = 0;
        for (j jVar2 : this.bjg) {
            int i3 = jVar2.aNe.length;
            i = 0;
            while (i < i3) {
                int i4 = i2 + 1;
                oVarArr[i2] = jVar2.aNe.bia[i];
                i++;
                i2 = i4;
            }
        }
        this.aNe = new p(oVarArr);
        this.bgq.a(this);
        AppMethodBeat.o(125919);
    }

    public final void a(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        AppMethodBeat.i(125920);
        ((e.a) this.bir.bkC.get(aVar)).sD();
        AppMethodBeat.o(125920);
    }

    public final void sx() {
        AppMethodBeat.i(125921);
        sy();
        AppMethodBeat.o(125921);
    }

    public final void b(com.google.android.exoplayer2.source.b.a.a.a aVar) {
        AppMethodBeat.i(125922);
        for (j jVar : this.bjg) {
            c cVar = jVar.bjo;
            int j = cVar.bis.j(aVar.aOv);
            if (j != -1) {
                j = cVar.biB.indexOf(j);
                if (j != -1) {
                    cVar.biB.eI(j);
                }
            }
        }
        sy();
        AppMethodBeat.o(125922);
    }

    private j a(int i, com.google.android.exoplayer2.source.b.a.a.a[] aVarArr, Format format, List<Format> list, long j) {
        AppMethodBeat.i(125923);
        c cVar = new c(this.bir, aVarArr, this.bjb, this.bip, list);
        j jVar = new j(i, this, cVar, this.bgF, j, format, this.bgC, this.bjc);
        AppMethodBeat.o(125923);
        return jVar;
    }

    private void sy() {
        AppMethodBeat.i(125924);
        if (this.aNe != null) {
            this.bgq.a(this);
            AppMethodBeat.o(125924);
            return;
        }
        for (j sz : this.bjg) {
            sz.sz();
        }
        AppMethodBeat.o(125924);
    }

    private static boolean a(com.google.android.exoplayer2.source.b.a.a.a aVar, String str) {
        AppMethodBeat.i(125925);
        String str2 = aVar.aOv.aOa;
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.o(125925);
            return false;
        }
        for (String startsWith : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                AppMethodBeat.o(125925);
                return true;
            }
        }
        AppMethodBeat.o(125925);
        return false;
    }
}
