package com.google.android.exoplayer2.source.p112b;

import android.os.Handler;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p109g.C45035f;
import com.google.android.exoplayer2.p110h.C32053b;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.p111i.C45039a;
import com.google.android.exoplayer2.source.C17688l;
import com.google.android.exoplayer2.source.C25560k;
import com.google.android.exoplayer2.source.C37271a.C8705a;
import com.google.android.exoplayer2.source.C37279h;
import com.google.android.exoplayer2.source.C37279h.C37280a;
import com.google.android.exoplayer2.source.C41630o;
import com.google.android.exoplayer2.source.C41631p;
import com.google.android.exoplayer2.source.C8712e;
import com.google.android.exoplayer2.source.p112b.C41626j.C41627a;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a;
import com.google.android.exoplayer2.source.p112b.p113a.C25553a.C25552a;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e.C0878a;
import com.google.android.exoplayer2.source.p112b.p113a.C45049e.C0879b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;

/* renamed from: com.google.android.exoplayer2.source.b.g */
public final class C8711g implements C0879b, C41627a, C37279h {
    private C41631p aNe;
    private final int bgC;
    private final C32053b bgF;
    private C37280a bgq;
    private final C41628k bip = new C41628k();
    final C45049e bir;
    private final C25555d bjb;
    private final C8705a bjc;
    private final IdentityHashMap<C17688l, Integer> bjd = new IdentityHashMap();
    final Handler bje = new Handler();
    private int bjf;
    C41626j[] bjg = new C41626j[0];
    private C41626j[] bjh = new C41626j[0];
    private C8712e bji;

    public C8711g(C45049e c45049e, C25555d c25555d, int i, C8705a c8705a, C32053b c32053b) {
        AppMethodBeat.m2504i(125910);
        this.bir = c45049e;
        this.bjb = c25555d;
        this.bgC = i;
        this.bjc = c8705a;
        this.bgF = c32053b;
        AppMethodBeat.m2505o(125910);
    }

    /* renamed from: a */
    public final void mo19278a(C37280a c37280a, long j) {
        int i;
        C25552a c25552a;
        List list;
        int i2;
        int i3;
        AppMethodBeat.m2504i(125911);
        this.bgq = c37280a;
        this.bir.bkF.add(this);
        C25553a c25553a = this.bir.biH;
        ArrayList arrayList = new ArrayList(c25553a.bjF);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        int i4 = 0;
        while (true) {
            i = i4;
            if (i >= arrayList.size()) {
                break;
            }
            c25552a = (C25552a) arrayList.get(i);
            if (c25552a.aOv.height > 0 || C8711g.m15452a(c25552a, "avc")) {
                arrayList2.add(c25552a);
            } else if (C8711g.m15452a(c25552a, "mp4a")) {
                arrayList3.add(c25552a);
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
        List list3 = c25553a.bjG;
        List list4 = c25553a.bjH;
        this.bjg = new C41626j[((list3.size() + 1) + list4.size())];
        this.bjf = this.bjg.length;
        C45039a.checkArgument(!list2.isEmpty());
        C25552a[] c25552aArr = new C25552a[list2.size()];
        list2.toArray(c25552aArr);
        C41626j a = m15451a(0, c25552aArr, c25553a.bjp, c25553a.bit, j);
        i4 = 1;
        this.bjg[0] = a;
        a.mo66754aJ(true);
        a.mo66761sz();
        i = 0;
        while (true) {
            i2 = i4;
            i3 = i;
            if (i3 >= list3.size()) {
                break;
            }
            a = m15451a(1, new C25552a[]{(C25552a) list3.get(i3)}, null, Collections.emptyList(), j);
            i4 = i2 + 1;
            this.bjg[i2] = a;
            a.mo66761sz();
            i = i3 + 1;
        }
        for (i3 = 0; i3 < list4.size(); i3++) {
            a = m15451a(3, new C25552a[]{(C25552a) list4.get(i3)}, null, Collections.emptyList(), j);
            a.mo66755es(0).mo42836f(c25552a.aOv);
            a.bgQ = true;
            a.mo66759sB();
            i4 = i2 + 1;
            this.bjg[i2] = a;
            i2 = i4;
        }
        this.bjh = this.bjg;
        AppMethodBeat.m2505o(125911);
    }

    /* renamed from: rR */
    public final void mo19281rR() {
        AppMethodBeat.m2504i(125912);
        for (C41626j c41626j : this.bjg) {
            c41626j.bjo.mo59520rW();
        }
        AppMethodBeat.m2505o(125912);
    }

    /* renamed from: rS */
    public final C41631p mo19282rS() {
        return this.aNe;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x0213  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public final long mo19276a(C45035f[] c45035fArr, boolean[] zArr, C17688l[] c17688lArr, boolean[] zArr2, long j) {
        int i;
        AppMethodBeat.m2504i(125913);
        int[] iArr = new int[c45035fArr.length];
        int[] iArr2 = new int[c45035fArr.length];
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= c45035fArr.length) {
                break;
            }
            if (c17688lArr[i] == null) {
                i2 = -1;
            } else {
                i2 = ((Integer) this.bjd.get(c17688lArr[i])).intValue();
            }
            iArr[i] = i2;
            iArr2[i] = -1;
            if (c45035fArr[i] != null) {
                C41630o tf = c45035fArr[i].mo19206tf();
                for (i2 = 0; i2 < this.bjg.length; i2++) {
                    if (this.bjg[i2].aNe.mo66766a(tf) != -1) {
                        iArr2[i] = i2;
                        break;
                    }
                }
            }
            i2 = i + 1;
        }
        boolean z = false;
        this.bjd.clear();
        C17688l[] c17688lArr2 = new C17688l[c45035fArr.length];
        C17688l[] c17688lArr3 = new C17688l[c45035fArr.length];
        C45035f[] c45035fArr2 = new C45035f[c45035fArr.length];
        int i3 = 0;
        C41626j[] c41626jArr = new C41626j[this.bjg.length];
        i2 = 0;
        while (true) {
            i = i2;
            if (i < this.bjg.length) {
                Object obj;
                i2 = 0;
                while (i2 < c45035fArr.length) {
                    c17688lArr3[i2] = iArr[i2] == i ? c17688lArr[i2] : null;
                    c45035fArr2[i2] = iArr2[i2] == i ? c45035fArr[i2] : null;
                    i2++;
                }
                C41626j c41626j = this.bjg[i];
                C45039a.checkState(c41626j.prepared);
                int i4 = c41626j.bgT;
                i2 = 0;
                while (true) {
                    int i5 = i2;
                    if (i5 >= c45035fArr2.length) {
                        break;
                    }
                    if (c17688lArr3[i5] != null && (c45035fArr2[i5] == null || !zArr[i5])) {
                        c41626j.mo66757r(((C41625i) c17688lArr3[i5]).bjl, false);
                        c17688lArr3[i5] = null;
                    }
                    i2 = i5 + 1;
                }
                if (z || (c41626j.bgR ? i4 == 0 : j != c41626j.bgZ)) {
                    obj = 1;
                } else {
                    obj = null;
                }
                C45035f c45035f = c41626j.bjo.biB;
                i4 = 0;
                Object obj2 = obj;
                Object obj3 = c45035f;
                while (i4 < c45035fArr2.length) {
                    if (c17688lArr3[i4] == null && c45035fArr2[i4] != null) {
                        C45035f c45035f2 = c45035fArr2[i4];
                        int a = c41626j.aNe.mo66766a(c45035f2.mo19206tf());
                        c41626j.mo66757r(a, true);
                        if (a == c41626j.bju) {
                            c41626j.bjo.biB = c45035f2;
                            obj3 = c45035f2;
                        }
                        c17688lArr3[i4] = new C41625i(c41626j, a);
                        zArr2[i4] = true;
                        if (obj2 == null) {
                            C25560k c25560k = c41626j.bgO[a];
                            c25560k.rewind();
                            if (c25560k.mo42837g(j, true) || c25560k.bhG.mo59539sj() == 0) {
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
                if (c41626j.bgT == 0) {
                    c41626j.bjo.biw = null;
                    c41626j.bjs = null;
                    c41626j.bjr.clear();
                    if (c41626j.bgI.isLoading()) {
                        for (C25560k sq : c41626j.bgO) {
                            sq.mo42842sq();
                        }
                        c41626j.bgI.cancelLoading();
                    } else {
                        c41626j.mo66758sA();
                    }
                } else {
                    boolean z2;
                    if (!(c41626j.bjr.isEmpty() || C17675v.m27574j(obj3, c45035f))) {
                        if (c41626j.bgR) {
                            obj = 1;
                        } else {
                            obj3.mo52334ag(0);
                            if (obj3.mo19208th() != c41626j.bjo.bis.mo66765j(((C25556f) c41626j.bjr.getLast()).bic)) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                        }
                        if (obj != null) {
                            z2 = true;
                            obj2 = 1;
                            c41626j.bjy = true;
                            if (obj2 != null) {
                                c41626j.mo66756j(j, z2);
                                for (i2 = 0; i2 < c17688lArr3.length; i2++) {
                                    if (c17688lArr3[i2] != null) {
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
                c41626j.bgR = true;
                obj = null;
                for (i4 = 0; i4 < c45035fArr.length; i4++) {
                    if (iArr2[i4] == i) {
                        C45039a.checkState(c17688lArr3[i4] != null);
                        c17688lArr2[i4] = c17688lArr3[i4];
                        obj = 1;
                        this.bjd.put(c17688lArr3[i4], Integer.valueOf(i));
                    } else if (iArr[i4] == i) {
                        C45039a.checkState(c17688lArr3[i4] == null);
                    }
                }
                if (obj != null) {
                    c41626jArr[i3] = c41626j;
                    i2 = i3 + 1;
                    if (i3 == 0) {
                        c41626j.mo66754aJ(true);
                        if (!(obj2 == null && this.bjh.length != 0 && c41626j == this.bjh[0])) {
                            this.bip.bjA.clear();
                            z = true;
                            i3 = i2;
                        }
                    } else {
                        c41626j.mo66754aJ(false);
                    }
                    i3 = i2;
                }
                i2 = i + 1;
            } else {
                System.arraycopy(c17688lArr2, 0, c17688lArr, 0, c17688lArr2.length);
                this.bjh = (C41626j[]) Arrays.copyOf(c41626jArr, i3);
                this.bji = new C8712e(this.bjh);
                AppMethodBeat.m2505o(125913);
                return j;
            }
        }
    }

    /* renamed from: W */
    public final void mo19273W(long j) {
        AppMethodBeat.m2504i(125914);
        for (C41626j c41626j : this.bjh) {
            int length = c41626j.bgO.length;
            for (int i = 0; i < length; i++) {
                c41626j.bgO[i].mo42838i(j, c41626j.bjw[i]);
            }
        }
        AppMethodBeat.m2505o(125914);
    }

    /* renamed from: Y */
    public final boolean mo19275Y(long j) {
        AppMethodBeat.m2504i(125915);
        boolean Y = this.bji.mo19275Y(j);
        AppMethodBeat.m2505o(125915);
        return Y;
    }

    /* renamed from: rV */
    public final long mo19285rV() {
        AppMethodBeat.m2504i(125916);
        long rV = this.bji.mo19285rV();
        AppMethodBeat.m2505o(125916);
        return rV;
    }

    /* renamed from: rT */
    public final long mo19283rT() {
        return -9223372036854775807L;
    }

    /* renamed from: rU */
    public final long mo19284rU() {
        AppMethodBeat.m2504i(125917);
        long rU = this.bji.mo19284rU();
        AppMethodBeat.m2505o(125917);
        return rU;
    }

    /* renamed from: X */
    public final long mo19274X(long j) {
        AppMethodBeat.m2504i(125918);
        if (this.bjh.length > 0) {
            boolean j2 = this.bjh[0].mo66756j(j, false);
            for (int i = 1; i < this.bjh.length; i++) {
                this.bjh[i].mo66756j(j, j2);
            }
            if (j2) {
                this.bip.bjA.clear();
            }
        }
        AppMethodBeat.m2505o(125918);
        return j;
    }

    /* renamed from: pL */
    public final void mo19280pL() {
        AppMethodBeat.m2504i(125919);
        int i = this.bjf - 1;
        this.bjf = i;
        if (i > 0) {
            AppMethodBeat.m2505o(125919);
            return;
        }
        int i2 = 0;
        for (C41626j c41626j : this.bjg) {
            i2 += c41626j.aNe.length;
        }
        C41630o[] c41630oArr = new C41630o[i2];
        i2 = 0;
        for (C41626j c41626j2 : this.bjg) {
            int i3 = c41626j2.aNe.length;
            i = 0;
            while (i < i3) {
                int i4 = i2 + 1;
                c41630oArr[i2] = c41626j2.aNe.bia[i];
                i++;
                i2 = i4;
            }
        }
        this.aNe = new C41631p(c41630oArr);
        this.bgq.mo32388a(this);
        AppMethodBeat.m2505o(125919);
    }

    /* renamed from: a */
    public final void mo19277a(C25552a c25552a) {
        AppMethodBeat.m2504i(125920);
        ((C0878a) this.bir.bkC.get(c25552a)).mo2607sD();
        AppMethodBeat.m2505o(125920);
    }

    /* renamed from: sx */
    public final void mo2609sx() {
        AppMethodBeat.m2504i(125921);
        m15453sy();
        AppMethodBeat.m2505o(125921);
    }

    /* renamed from: b */
    public final void mo2608b(C25552a c25552a) {
        AppMethodBeat.m2504i(125922);
        for (C41626j c41626j : this.bjg) {
            C37275c c37275c = c41626j.bjo;
            int j = c37275c.bis.mo66765j(c25552a.aOv);
            if (j != -1) {
                j = c37275c.biB.indexOf(j);
                if (j != -1) {
                    c37275c.biB.mo19199eI(j);
                }
            }
        }
        m15453sy();
        AppMethodBeat.m2505o(125922);
    }

    /* renamed from: a */
    private C41626j m15451a(int i, C25552a[] c25552aArr, Format format, List<Format> list, long j) {
        AppMethodBeat.m2504i(125923);
        C37275c c37275c = new C37275c(this.bir, c25552aArr, this.bjb, this.bip, list);
        C41626j c41626j = new C41626j(i, this, c37275c, this.bgF, j, format, this.bgC, this.bjc);
        AppMethodBeat.m2505o(125923);
        return c41626j;
    }

    /* renamed from: sy */
    private void m15453sy() {
        AppMethodBeat.m2504i(125924);
        if (this.aNe != null) {
            this.bgq.mo19279a(this);
            AppMethodBeat.m2505o(125924);
            return;
        }
        for (C41626j sz : this.bjg) {
            sz.mo66761sz();
        }
        AppMethodBeat.m2505o(125924);
    }

    /* renamed from: a */
    private static boolean m15452a(C25552a c25552a, String str) {
        AppMethodBeat.m2504i(125925);
        String str2 = c25552a.aOv.aOa;
        if (TextUtils.isEmpty(str2)) {
            AppMethodBeat.m2505o(125925);
            return false;
        }
        for (String startsWith : str2.split("(\\s*,\\s*)|(\\s*$)")) {
            if (startsWith.startsWith(str)) {
                AppMethodBeat.m2505o(125925);
                return true;
            }
        }
        AppMethodBeat.m2505o(125925);
        return false;
    }
}
