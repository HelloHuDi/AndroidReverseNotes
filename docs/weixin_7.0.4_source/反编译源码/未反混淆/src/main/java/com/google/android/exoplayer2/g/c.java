package com.google.android.exoplayer2.g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.i.v;
import com.google.android.exoplayer2.s;
import com.google.android.exoplayer2.source.o;
import com.google.android.exoplayer2.source.p;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class c extends e {
    private static final int[] bpg = new int[0];
    private final com.google.android.exoplayer2.g.f.a bph;
    private final AtomicReference<b> bpi;

    public static final class b {
        public final String bpj;
        public final String bpk;
        public final int bpl;
        public final int bpm;
        public final int bpn;
        public final boolean bpo;
        public final boolean bpp;
        public final boolean bpq;
        public final boolean bpr;
        public final boolean bpt;
        public final int viewportHeight;
        public final int viewportWidth;

        public b() {
            this((byte) 0);
        }

        private b(byte b) {
            this.bpj = null;
            this.bpk = null;
            this.bpq = false;
            this.bpr = true;
            this.bpl = BaseClientBuilder.API_PRIORITY_OTHER;
            this.bpm = BaseClientBuilder.API_PRIORITY_OTHER;
            this.bpn = BaseClientBuilder.API_PRIORITY_OTHER;
            this.bpo = true;
            this.bpt = true;
            this.viewportWidth = BaseClientBuilder.API_PRIORITY_OTHER;
            this.viewportHeight = BaseClientBuilder.API_PRIORITY_OTHER;
            this.bpp = true;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95763);
            if (this == obj) {
                AppMethodBeat.o(95763);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(95763);
                return false;
            } else {
                b bVar = (b) obj;
                if (this.bpq == bVar.bpq && this.bpr == bVar.bpr && this.bpl == bVar.bpl && this.bpm == bVar.bpm && this.bpo == bVar.bpo && this.bpt == bVar.bpt && this.bpp == bVar.bpp && this.viewportWidth == bVar.viewportWidth && this.viewportHeight == bVar.viewportHeight && this.bpn == bVar.bpn && TextUtils.equals(this.bpj, bVar.bpj) && TextUtils.equals(this.bpk, bVar.bpk)) {
                    AppMethodBeat.o(95763);
                    return true;
                }
                AppMethodBeat.o(95763);
                return false;
            }
        }

        public final int hashCode() {
            int i;
            int i2 = 1;
            AppMethodBeat.i(95764);
            int hashCode = ((this.bpq ? 1 : 0) + (((this.bpj.hashCode() * 31) + this.bpk.hashCode()) * 31)) * 31;
            if (this.bpr) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (((((((i + hashCode) * 31) + this.bpl) * 31) + this.bpm) * 31) + this.bpn) * 31;
            if (this.bpo) {
                i = 1;
            } else {
                i = 0;
            }
            hashCode = (i + hashCode) * 31;
            if (this.bpt) {
                i = 1;
            } else {
                i = 0;
            }
            i = (i + hashCode) * 31;
            if (!this.bpp) {
                i2 = 0;
            }
            i = ((((i + i2) * 31) + this.viewportWidth) * 31) + this.viewportHeight;
            AppMethodBeat.o(95764);
            return i;
        }
    }

    static final class a {
        public final int aOn;
        public final String mimeType;
        public final int sampleRate;

        public a(int i, int i2, String str) {
            this.aOn = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(95761);
            if (this == obj) {
                AppMethodBeat.o(95761);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.o(95761);
                return false;
            } else {
                a aVar = (a) obj;
                if (this.aOn == aVar.aOn && this.sampleRate == aVar.sampleRate && TextUtils.equals(this.mimeType, aVar.mimeType)) {
                    AppMethodBeat.o(95761);
                    return true;
                }
                AppMethodBeat.o(95761);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.i(95762);
            int hashCode = (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.aOn * 31) + this.sampleRate) * 31);
            AppMethodBeat.o(95762);
            return hashCode;
        }
    }

    public c() {
        this(null);
    }

    public c(com.google.android.exoplayer2.g.f.a aVar) {
        AppMethodBeat.i(95765);
        this.bph = aVar;
        this.bpi = new AtomicReference(new b());
        AppMethodBeat.o(95765);
    }

    /* Access modifiers changed, original: protected|final */
    public final f[] a(s[] sVarArr, p[] pVarArr, int[][][] iArr) {
        int i;
        int i2;
        AppMethodBeat.i(95766);
        int length = sVarArr.length;
        f[] fVarArr = new f[length];
        b bVar = (b) this.bpi.get();
        int i3 = 0;
        Object obj = null;
        int i4 = 0;
        while (i4 < length) {
            int i5;
            if (2 == sVarArr[i4].getTrackType()) {
                if (obj == null) {
                    s sVar = sVarArr[i4];
                    p pVar = pVarArr[i4];
                    int[][] iArr2 = iArr[i4];
                    com.google.android.exoplayer2.g.f.a aVar = this.bph;
                    f fVar = null;
                    if (aVar != null) {
                        Object obj2;
                        int i6 = bVar.bpr ? 24 : 16;
                        if (!bVar.bpq || (sVar.pJ() & i6) == 0) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        i = 0;
                        while (true) {
                            int i7 = i;
                            if (i7 >= pVar.length) {
                                fVar = null;
                                break;
                            }
                            o oVar = pVar.bia[i7];
                            int[] iArr3 = iArr2[i7];
                            int i8 = bVar.bpl;
                            int i9 = bVar.bpm;
                            int i10 = bVar.bpn;
                            i2 = bVar.viewportWidth;
                            int i11 = bVar.viewportHeight;
                            boolean z = bVar.bpp;
                            if (oVar.length < 2) {
                                iArr3 = bpg;
                            } else {
                                List a = a(oVar, i2, i11, z);
                                if (a.size() < 2) {
                                    iArr3 = bpg;
                                } else {
                                    String str;
                                    String str2 = null;
                                    if (obj2 == null) {
                                        HashSet hashSet = new HashSet();
                                        int i12 = 0;
                                        int i13 = 0;
                                        while (i13 < a.size()) {
                                            int a2;
                                            str = oVar.bhv[((Integer) a.get(i13)).intValue()].aOd;
                                            if (hashSet.add(str)) {
                                                a2 = a(oVar, iArr3, i6, str, i8, i9, i10, a);
                                                if (a2 > i12) {
                                                    i13++;
                                                    str2 = str;
                                                    i12 = a2;
                                                }
                                            }
                                            str = str2;
                                            a2 = i12;
                                            i13++;
                                            str2 = str;
                                            i12 = a2;
                                        }
                                        str = str2;
                                    } else {
                                        str = null;
                                    }
                                    b(oVar, iArr3, i6, str, i8, i9, i10, a);
                                    iArr3 = a.size() < 2 ? bpg : v.z(a);
                                }
                            }
                            if (iArr3.length > 0) {
                                fVar = aVar.a(oVar, iArr3);
                                break;
                            }
                            i = i7 + 1;
                        }
                    }
                    if (fVar == null) {
                        fVar = a(pVar, iArr2, bVar);
                    }
                    fVarArr[i4] = fVar;
                    obj = fVarArr[i4] != null ? 1 : null;
                }
                if (pVarArr[i4].length > 0) {
                    i5 = 1;
                } else {
                    i5 = 0;
                }
                i5 |= i3;
            } else {
                i5 = i3;
            }
            i4++;
            i3 = i5;
        }
        Object obj3 = null;
        Object obj4 = null;
        i = 0;
        while (true) {
            i2 = i;
            if (i2 < length) {
                switch (sVarArr[i2].getTrackType()) {
                    case 1:
                        if (obj3 != null) {
                            break;
                        }
                        fVarArr[i2] = a(pVarArr[i2], iArr[i2], bVar, i3 != 0 ? null : this.bph);
                        obj3 = fVarArr[i2] != null ? 1 : null;
                        break;
                    case 2:
                        break;
                    case 3:
                        if (obj4 != null) {
                            break;
                        }
                        fVarArr[i2] = b(pVarArr[i2], iArr[i2], bVar);
                        obj4 = fVarArr[i2] != null ? 1 : null;
                        break;
                    default:
                        fVarArr[i2] = c(pVarArr[i2], iArr[i2], bVar);
                        break;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.o(95766);
                return fVarArr;
            }
        }
    }

    private static int a(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        AppMethodBeat.i(95767);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < list.size()) {
                i5 = ((Integer) list.get(i7)).intValue();
                if (a(oVar.bhv[i5], str, iArr[i5], i, i2, i3, i4)) {
                    i5 = i8 + 1;
                } else {
                    i5 = i8;
                }
                i6 = i7 + 1;
            } else {
                AppMethodBeat.o(95767);
                return i8;
            }
        }
    }

    private static void b(o oVar, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        AppMethodBeat.i(95768);
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!a(oVar.bhv[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
        AppMethodBeat.o(95768);
    }

    private static boolean a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(95769);
        if (!s(i, false) || (i & i2) == 0 || (!(str == null || v.j(format.aOd, str)) || ((format.width != -1 && format.width > i3) || ((format.height != -1 && format.height > i4) || (format.bitrate != -1 && format.bitrate > i5))))) {
            AppMethodBeat.o(95769);
            return false;
        }
        AppMethodBeat.o(95769);
        return true;
    }

    private static f a(p pVar, int[][] iArr, b bVar) {
        AppMethodBeat.i(95770);
        o oVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= pVar.length) {
                break;
            }
            o oVar2 = pVar.bia[i6];
            List a = a(oVar2, bVar.viewportWidth, bVar.viewportHeight, bVar.bpp);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < oVar2.length; i7++) {
                if (s(iArr2[i7], bVar.bpt)) {
                    Format format = oVar2.bhv[i7];
                    Object obj = (!a.contains(Integer.valueOf(i7)) || ((format.width != -1 && format.width > bVar.bpl) || ((format.height != -1 && format.height > bVar.bpm) || (format.bitrate != -1 && format.bitrate > bVar.bpn)))) ? null : 1;
                    if (obj != null || bVar.bpo) {
                        i5 = obj != null ? 2 : 1;
                        boolean s = s(iArr2[i7], false);
                        if (s) {
                            i5 += 1000;
                        }
                        Object obj2 = i5 > i2 ? 1 : null;
                        if (i5 == i2) {
                            int bg;
                            if (format.qb() != i4) {
                                bg = bg(format.qb(), i4);
                            } else {
                                bg = bg(format.bitrate, i3);
                            }
                            obj2 = (!s || obj == null) ? bg < 0 ? 1 : null : bg > 0 ? 1 : null;
                        }
                        if (obj2 != null) {
                            i3 = format.bitrate;
                            i4 = format.qb();
                            i2 = i5;
                            i = i7;
                            oVar = oVar2;
                        }
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (oVar == null) {
            AppMethodBeat.o(95770);
            return null;
        }
        f dVar = new d(oVar, i);
        AppMethodBeat.o(95770);
        return dVar;
    }

    private static int bg(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    private static f a(p pVar, int[][] iArr, b bVar, com.google.android.exoplayer2.g.f.a aVar) {
        int i;
        o oVar;
        int[] iArr2;
        int i2;
        int i3;
        AppMethodBeat.i(95771);
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (i = 0; i < pVar.length; i++) {
            oVar = pVar.bia[i];
            iArr2 = iArr[i];
            for (i2 = 0; i2 < oVar.length; i2++) {
                if (s(iArr2[i2], bVar.bpt)) {
                    Format format = oVar.bhv[i2];
                    int i7 = iArr2[i2];
                    String str = bVar.bpj;
                    Object obj = (format.aOs & 1) != 0 ? 1 : null;
                    if (a(format, str)) {
                        if (obj != null) {
                            i3 = 4;
                        } else {
                            i3 = 3;
                        }
                    } else if (obj != null) {
                        i3 = 2;
                    } else {
                        i3 = 1;
                    }
                    if (s(i7, false)) {
                        i3 += 1000;
                    }
                    if (i3 > i6) {
                        i6 = i3;
                        i5 = i2;
                        i4 = i;
                    }
                }
            }
        }
        if (i4 == -1) {
            AppMethodBeat.o(95771);
            return null;
        }
        f a;
        oVar = pVar.bia[i4];
        if (aVar != null) {
            int[] iArr3;
            iArr2 = iArr[i4];
            boolean z = bVar.bpq;
            i2 = 0;
            a aVar2 = null;
            HashSet hashSet = new HashSet();
            i3 = 0;
            while (i3 < oVar.length) {
                Format format2 = oVar.bhv[i3];
                a aVar3 = new a(format2.aOn, format2.sampleRate, z ? null : format2.aOd);
                if (hashSet.add(aVar3)) {
                    i4 = a(oVar, iArr2, aVar3);
                    if (i4 > i2) {
                        i3++;
                        aVar2 = aVar3;
                        i2 = i4;
                    }
                }
                aVar3 = aVar2;
                i4 = i2;
                i3++;
                aVar2 = aVar3;
                i2 = i4;
            }
            if (i2 > 1) {
                int[] iArr4 = new int[i2];
                i4 = 0;
                for (i = 0; i < oVar.length; i++) {
                    if (a(oVar.bhv[i], iArr2[i], aVar2)) {
                        i2 = i4 + 1;
                        iArr4[i4] = i;
                        i4 = i2;
                    }
                }
                iArr3 = iArr4;
            } else {
                iArr3 = bpg;
            }
            if (iArr3.length > 0) {
                a = aVar.a(oVar, iArr3);
                AppMethodBeat.o(95771);
                return a;
            }
        }
        a = new d(oVar, i5);
        AppMethodBeat.o(95771);
        return a;
    }

    private static int a(o oVar, int[] iArr, a aVar) {
        int i = 0;
        AppMethodBeat.i(95772);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < oVar.length) {
                if (a(oVar.bhv[i2], iArr[i2], aVar)) {
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
            } else {
                AppMethodBeat.o(95772);
                return i3;
            }
        }
    }

    private static boolean a(Format format, int i, a aVar) {
        AppMethodBeat.i(95773);
        if (s(i, false) && format.aOn == aVar.aOn && format.sampleRate == aVar.sampleRate && (aVar.mimeType == null || TextUtils.equals(aVar.mimeType, format.aOd))) {
            AppMethodBeat.o(95773);
            return true;
        }
        AppMethodBeat.o(95773);
        return false;
    }

    private static f b(p pVar, int[][] iArr, b bVar) {
        AppMethodBeat.i(95774);
        o oVar = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= pVar.length) {
                break;
            }
            o oVar2 = pVar.bia[i4];
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < oVar2.length; i5++) {
                if (s(iArr2[i5], bVar.bpt)) {
                    Format format = oVar2.bhv[i5];
                    Object obj = (format.aOs & 1) != 0 ? 1 : null;
                    Object obj2 = (format.aOs & 2) != 0 ? 1 : null;
                    if (a(format, bVar.bpk)) {
                        if (obj != null) {
                            i3 = 6;
                        } else if (obj2 == null) {
                            i3 = 5;
                        } else {
                            i3 = 4;
                        }
                    } else if (obj != null) {
                        i3 = 3;
                    } else if (obj2 != null) {
                        if (a(format, bVar.bpj)) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                    }
                    if (s(iArr2[i5], false)) {
                        i3 += 1000;
                    }
                    if (i3 > i2) {
                        i2 = i3;
                        i = i5;
                        oVar = oVar2;
                    }
                }
            }
            i3 = i4 + 1;
        }
        if (oVar == null) {
            AppMethodBeat.o(95774);
            return null;
        }
        f dVar = new d(oVar, i);
        AppMethodBeat.o(95774);
        return dVar;
    }

    private static f c(p pVar, int[][] iArr, b bVar) {
        AppMethodBeat.i(95775);
        boolean z = false;
        int i = 0;
        o oVar = null;
        for (int i2 = 0; i2 < pVar.length; i2++) {
            o oVar2 = pVar.bia[i2];
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < oVar2.length) {
                boolean z2;
                if (s(iArr2[i3], bVar.bpt)) {
                    if ((oVar2.bhv[i3].aOs & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (s(iArr2[i3], false)) {
                        z2 += 1000;
                    }
                    if (z2 > z) {
                        i = i3;
                        oVar = oVar2;
                        i3++;
                        z = z2;
                    }
                }
                z2 = z;
                i3++;
                z = z2;
            }
        }
        if (oVar == null) {
            AppMethodBeat.o(95775);
            return null;
        }
        f dVar = new d(oVar, i);
        AppMethodBeat.o(95775);
        return dVar;
    }

    private static boolean s(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    private static boolean a(Format format, String str) {
        AppMethodBeat.i(95776);
        if (str == null || !TextUtils.equals(str, v.aP(format.aOt))) {
            AppMethodBeat.o(95776);
            return false;
        }
        AppMethodBeat.o(95776);
        return true;
    }

    private static List<Integer> a(o oVar, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        AppMethodBeat.i(95777);
        ArrayList arrayList = new ArrayList(oVar.length);
        for (i3 = 0; i3 < oVar.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.o(95777);
            return arrayList;
        }
        int i5 = Integer.MAX_VALUE;
        while (i4 < oVar.length) {
            Format format = oVar.bhv[i4];
            if (format.width > 0 && format.height > 0) {
                Point a = a(z, i, i2, format.width, format.height);
                i3 = format.width * format.height;
                if (format.width >= ((int) (((float) a.x) * 0.98f)) && format.height >= ((int) (((float) a.y) * 0.98f)) && i3 < i5) {
                    i4++;
                    i5 = i3;
                }
            }
            i3 = i5;
            i4++;
            i5 = i3;
        }
        if (i5 != Integer.MAX_VALUE) {
            for (i4 = arrayList.size() - 1; i4 >= 0; i4--) {
                i3 = oVar.bhv[((Integer) arrayList.get(i4)).intValue()].qb();
                if (i3 == -1 || i3 > i5) {
                    arrayList.remove(i4);
                }
            }
        }
        AppMethodBeat.o(95777);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static Point a(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Object obj = 1;
        AppMethodBeat.i(95778);
        if (z) {
            Object obj2 = i3 > i4 ? 1 : null;
            if (i <= i2) {
                obj = null;
            }
            if (obj2 != obj) {
                i5 = i;
                i6 = i2;
                Point point;
                if (i3 * i5 < i4 * i6) {
                    point = new Point(i6, v.bi(i6 * i4, i3));
                    AppMethodBeat.o(95778);
                    return point;
                }
                point = new Point(v.bi(i5 * i3, i4), i5);
                AppMethodBeat.o(95778);
                return point;
            }
        }
        i5 = i2;
        i6 = i;
        if (i3 * i5 < i4 * i6) {
        }
    }
}
