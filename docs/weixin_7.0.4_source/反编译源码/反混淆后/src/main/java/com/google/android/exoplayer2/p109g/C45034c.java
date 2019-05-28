package com.google.android.exoplayer2.p109g;

import android.graphics.Point;
import android.text.TextUtils;
import com.google.android.exoplayer2.C8703s;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.p109g.C45035f.C8678a;
import com.google.android.exoplayer2.p111i.C17675v;
import com.google.android.exoplayer2.source.C41630o;
import com.google.android.exoplayer2.source.C41631p;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: com.google.android.exoplayer2.g.c */
public final class C45034c extends C37258e {
    private static final int[] bpg = new int[0];
    private final C8678a bph;
    private final AtomicReference<C32052b> bpi;

    /* renamed from: com.google.android.exoplayer2.g.c$b */
    public static final class C32052b {
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

        public C32052b() {
            this((byte) 0);
        }

        private C32052b(byte b) {
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
            AppMethodBeat.m2504i(95763);
            if (this == obj) {
                AppMethodBeat.m2505o(95763);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(95763);
                return false;
            } else {
                C32052b c32052b = (C32052b) obj;
                if (this.bpq == c32052b.bpq && this.bpr == c32052b.bpr && this.bpl == c32052b.bpl && this.bpm == c32052b.bpm && this.bpo == c32052b.bpo && this.bpt == c32052b.bpt && this.bpp == c32052b.bpp && this.viewportWidth == c32052b.viewportWidth && this.viewportHeight == c32052b.viewportHeight && this.bpn == c32052b.bpn && TextUtils.equals(this.bpj, c32052b.bpj) && TextUtils.equals(this.bpk, c32052b.bpk)) {
                    AppMethodBeat.m2505o(95763);
                    return true;
                }
                AppMethodBeat.m2505o(95763);
                return false;
            }
        }

        public final int hashCode() {
            int i;
            int i2 = 1;
            AppMethodBeat.m2504i(95764);
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
            AppMethodBeat.m2505o(95764);
            return i;
        }
    }

    /* renamed from: com.google.android.exoplayer2.g.c$a */
    static final class C37256a {
        public final int aOn;
        public final String mimeType;
        public final int sampleRate;

        public C37256a(int i, int i2, String str) {
            this.aOn = i;
            this.sampleRate = i2;
            this.mimeType = str;
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.m2504i(95761);
            if (this == obj) {
                AppMethodBeat.m2505o(95761);
                return true;
            } else if (obj == null || getClass() != obj.getClass()) {
                AppMethodBeat.m2505o(95761);
                return false;
            } else {
                C37256a c37256a = (C37256a) obj;
                if (this.aOn == c37256a.aOn && this.sampleRate == c37256a.sampleRate && TextUtils.equals(this.mimeType, c37256a.mimeType)) {
                    AppMethodBeat.m2505o(95761);
                    return true;
                }
                AppMethodBeat.m2505o(95761);
                return false;
            }
        }

        public final int hashCode() {
            AppMethodBeat.m2504i(95762);
            int hashCode = (this.mimeType != null ? this.mimeType.hashCode() : 0) + (((this.aOn * 31) + this.sampleRate) * 31);
            AppMethodBeat.m2505o(95762);
            return hashCode;
        }
    }

    public C45034c() {
        this(null);
    }

    public C45034c(C8678a c8678a) {
        AppMethodBeat.m2504i(95765);
        this.bph = c8678a;
        this.bpi = new AtomicReference(new C32052b());
        AppMethodBeat.m2505o(95765);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: a */
    public final C45035f[] mo59497a(C8703s[] c8703sArr, C41631p[] c41631pArr, int[][][] iArr) {
        int i;
        int i2;
        AppMethodBeat.m2504i(95766);
        int length = c8703sArr.length;
        C45035f[] c45035fArr = new C45035f[length];
        C32052b c32052b = (C32052b) this.bpi.get();
        int i3 = 0;
        Object obj = null;
        int i4 = 0;
        while (i4 < length) {
            int i5;
            if (2 == c8703sArr[i4].getTrackType()) {
                if (obj == null) {
                    C8703s c8703s = c8703sArr[i4];
                    C41631p c41631p = c41631pArr[i4];
                    int[][] iArr2 = iArr[i4];
                    C8678a c8678a = this.bph;
                    C45035f c45035f = null;
                    if (c8678a != null) {
                        Object obj2;
                        int i6 = c32052b.bpr ? 24 : 16;
                        if (!c32052b.bpq || (c8703s.mo19258pJ() & i6) == 0) {
                            obj2 = null;
                        } else {
                            obj2 = 1;
                        }
                        i = 0;
                        while (true) {
                            int i7 = i;
                            if (i7 >= c41631p.length) {
                                c45035f = null;
                                break;
                            }
                            C41630o c41630o = c41631p.bia[i7];
                            int[] iArr3 = iArr2[i7];
                            int i8 = c32052b.bpl;
                            int i9 = c32052b.bpm;
                            int i10 = c32052b.bpn;
                            i2 = c32052b.viewportWidth;
                            int i11 = c32052b.viewportHeight;
                            boolean z = c32052b.bpp;
                            if (c41630o.length < 2) {
                                iArr3 = bpg;
                            } else {
                                List a = C45034c.m82541a(c41630o, i2, i11, z);
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
                                            str = c41630o.bhv[((Integer) a.get(i13)).intValue()].aOd;
                                            if (hashSet.add(str)) {
                                                a2 = C45034c.m82536a(c41630o, iArr3, i6, str, i8, i9, i10, a);
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
                                    C45034c.m82546b(c41630o, iArr3, i6, str, i8, i9, i10, a);
                                    iArr3 = a.size() < 2 ? bpg : C17675v.m27579z(a);
                                }
                            }
                            if (iArr3.length > 0) {
                                c45035f = c8678a.mo19210a(c41630o, iArr3);
                                break;
                            }
                            i = i7 + 1;
                        }
                    }
                    if (c45035f == null) {
                        c45035f = C45034c.m82539a(c41631p, iArr2, c32052b);
                    }
                    c45035fArr[i4] = c45035f;
                    obj = c45035fArr[i4] != null ? 1 : null;
                }
                if (c41631pArr[i4].length > 0) {
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
                switch (c8703sArr[i2].getTrackType()) {
                    case 1:
                        if (obj3 != null) {
                            break;
                        }
                        c45035fArr[i2] = C45034c.m82540a(c41631pArr[i2], iArr[i2], c32052b, i3 != 0 ? null : this.bph);
                        obj3 = c45035fArr[i2] != null ? 1 : null;
                        break;
                    case 2:
                        break;
                    case 3:
                        if (obj4 != null) {
                            break;
                        }
                        c45035fArr[i2] = C45034c.m82545b(c41631pArr[i2], iArr[i2], c32052b);
                        obj4 = c45035fArr[i2] != null ? 1 : null;
                        break;
                    default:
                        c45035fArr[i2] = C45034c.m82548c(c41631pArr[i2], iArr[i2], c32052b);
                        break;
                }
                i = i2 + 1;
            } else {
                AppMethodBeat.m2505o(95766);
                return c45035fArr;
            }
        }
    }

    /* renamed from: a */
    private static int m82536a(C41630o c41630o, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        AppMethodBeat.m2504i(95767);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = i6;
            int i8 = i5;
            if (i7 < list.size()) {
                i5 = ((Integer) list.get(i7)).intValue();
                if (C45034c.m82544a(c41630o.bhv[i5], str, iArr[i5], i, i2, i3, i4)) {
                    i5 = i8 + 1;
                } else {
                    i5 = i8;
                }
                i6 = i7 + 1;
            } else {
                AppMethodBeat.m2505o(95767);
                return i8;
            }
        }
    }

    /* renamed from: b */
    private static void m82546b(C41630o c41630o, int[] iArr, int i, String str, int i2, int i3, int i4, List<Integer> list) {
        AppMethodBeat.m2504i(95768);
        for (int size = list.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) list.get(size)).intValue();
            if (!C45034c.m82544a(c41630o.bhv[intValue], str, iArr[intValue], i, i2, i3, i4)) {
                list.remove(size);
            }
        }
        AppMethodBeat.m2505o(95768);
    }

    /* renamed from: a */
    private static boolean m82544a(Format format, String str, int i, int i2, int i3, int i4, int i5) {
        AppMethodBeat.m2504i(95769);
        if (!C45034c.m82549s(i, false) || (i & i2) == 0 || (!(str == null || C17675v.m27574j(format.aOd, str)) || ((format.width != -1 && format.width > i3) || ((format.height != -1 && format.height > i4) || (format.bitrate != -1 && format.bitrate > i5))))) {
            AppMethodBeat.m2505o(95769);
            return false;
        }
        AppMethodBeat.m2505o(95769);
        return true;
    }

    /* renamed from: a */
    private static C45035f m82539a(C41631p c41631p, int[][] iArr, C32052b c32052b) {
        AppMethodBeat.m2504i(95770);
        C41630o c41630o = null;
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = -1;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= c41631p.length) {
                break;
            }
            C41630o c41630o2 = c41631p.bia[i6];
            List a = C45034c.m82541a(c41630o2, c32052b.viewportWidth, c32052b.viewportHeight, c32052b.bpp);
            int[] iArr2 = iArr[i6];
            for (int i7 = 0; i7 < c41630o2.length; i7++) {
                if (C45034c.m82549s(iArr2[i7], c32052b.bpt)) {
                    Format format = c41630o2.bhv[i7];
                    Object obj = (!a.contains(Integer.valueOf(i7)) || ((format.width != -1 && format.width > c32052b.bpl) || ((format.height != -1 && format.height > c32052b.bpm) || (format.bitrate != -1 && format.bitrate > c32052b.bpn)))) ? null : 1;
                    if (obj != null || c32052b.bpo) {
                        i5 = obj != null ? 2 : 1;
                        boolean s = C45034c.m82549s(iArr2[i7], false);
                        if (s) {
                            i5 += 1000;
                        }
                        Object obj2 = i5 > i2 ? 1 : null;
                        if (i5 == i2) {
                            int bg;
                            if (format.mo19120qb() != i4) {
                                bg = C45034c.m82547bg(format.mo19120qb(), i4);
                            } else {
                                bg = C45034c.m82547bg(format.bitrate, i3);
                            }
                            obj2 = (!s || obj == null) ? bg < 0 ? 1 : null : bg > 0 ? 1 : null;
                        }
                        if (obj2 != null) {
                            i3 = format.bitrate;
                            i4 = format.mo19120qb();
                            i2 = i5;
                            i = i7;
                            c41630o = c41630o2;
                        }
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (c41630o == null) {
            AppMethodBeat.m2505o(95770);
            return null;
        }
        C45035f c37257d = new C37257d(c41630o, i);
        AppMethodBeat.m2505o(95770);
        return c37257d;
    }

    /* renamed from: bg */
    private static int m82547bg(int i, int i2) {
        return i == -1 ? i2 == -1 ? 0 : -1 : i2 == -1 ? 1 : i - i2;
    }

    /* renamed from: a */
    private static C45035f m82540a(C41631p c41631p, int[][] iArr, C32052b c32052b, C8678a c8678a) {
        int i;
        C41630o c41630o;
        int[] iArr2;
        int i2;
        int i3;
        AppMethodBeat.m2504i(95771);
        int i4 = -1;
        int i5 = -1;
        int i6 = 0;
        for (i = 0; i < c41631p.length; i++) {
            c41630o = c41631p.bia[i];
            iArr2 = iArr[i];
            for (i2 = 0; i2 < c41630o.length; i2++) {
                if (C45034c.m82549s(iArr2[i2], c32052b.bpt)) {
                    Format format = c41630o.bhv[i2];
                    int i7 = iArr2[i2];
                    String str = c32052b.bpj;
                    Object obj = (format.aOs & 1) != 0 ? 1 : null;
                    if (C45034c.m82543a(format, str)) {
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
                    if (C45034c.m82549s(i7, false)) {
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
            AppMethodBeat.m2505o(95771);
            return null;
        }
        C45035f a;
        c41630o = c41631p.bia[i4];
        if (c8678a != null) {
            int[] iArr3;
            iArr2 = iArr[i4];
            boolean z = c32052b.bpq;
            i2 = 0;
            C37256a c37256a = null;
            HashSet hashSet = new HashSet();
            i3 = 0;
            while (i3 < c41630o.length) {
                Format format2 = c41630o.bhv[i3];
                C37256a c37256a2 = new C37256a(format2.aOn, format2.sampleRate, z ? null : format2.aOd);
                if (hashSet.add(c37256a2)) {
                    i4 = C45034c.m82537a(c41630o, iArr2, c37256a2);
                    if (i4 > i2) {
                        i3++;
                        c37256a = c37256a2;
                        i2 = i4;
                    }
                }
                c37256a2 = c37256a;
                i4 = i2;
                i3++;
                c37256a = c37256a2;
                i2 = i4;
            }
            if (i2 > 1) {
                int[] iArr4 = new int[i2];
                i4 = 0;
                for (i = 0; i < c41630o.length; i++) {
                    if (C45034c.m82542a(c41630o.bhv[i], iArr2[i], c37256a)) {
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
                a = c8678a.mo19210a(c41630o, iArr3);
                AppMethodBeat.m2505o(95771);
                return a;
            }
        }
        a = new C37257d(c41630o, i5);
        AppMethodBeat.m2505o(95771);
        return a;
    }

    /* renamed from: a */
    private static int m82537a(C41630o c41630o, int[] iArr, C37256a c37256a) {
        int i = 0;
        AppMethodBeat.m2504i(95772);
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < c41630o.length) {
                if (C45034c.m82542a(c41630o.bhv[i2], iArr[i2], c37256a)) {
                    i = i3 + 1;
                } else {
                    i = i3;
                }
                i2++;
            } else {
                AppMethodBeat.m2505o(95772);
                return i3;
            }
        }
    }

    /* renamed from: a */
    private static boolean m82542a(Format format, int i, C37256a c37256a) {
        AppMethodBeat.m2504i(95773);
        if (C45034c.m82549s(i, false) && format.aOn == c37256a.aOn && format.sampleRate == c37256a.sampleRate && (c37256a.mimeType == null || TextUtils.equals(c37256a.mimeType, format.aOd))) {
            AppMethodBeat.m2505o(95773);
            return true;
        }
        AppMethodBeat.m2505o(95773);
        return false;
    }

    /* renamed from: b */
    private static C45035f m82545b(C41631p c41631p, int[][] iArr, C32052b c32052b) {
        AppMethodBeat.m2504i(95774);
        C41630o c41630o = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= c41631p.length) {
                break;
            }
            C41630o c41630o2 = c41631p.bia[i4];
            int[] iArr2 = iArr[i4];
            for (int i5 = 0; i5 < c41630o2.length; i5++) {
                if (C45034c.m82549s(iArr2[i5], c32052b.bpt)) {
                    Format format = c41630o2.bhv[i5];
                    Object obj = (format.aOs & 1) != 0 ? 1 : null;
                    Object obj2 = (format.aOs & 2) != 0 ? 1 : null;
                    if (C45034c.m82543a(format, c32052b.bpk)) {
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
                        if (C45034c.m82543a(format, c32052b.bpj)) {
                            i3 = 2;
                        } else {
                            i3 = 1;
                        }
                    }
                    if (C45034c.m82549s(iArr2[i5], false)) {
                        i3 += 1000;
                    }
                    if (i3 > i2) {
                        i2 = i3;
                        i = i5;
                        c41630o = c41630o2;
                    }
                }
            }
            i3 = i4 + 1;
        }
        if (c41630o == null) {
            AppMethodBeat.m2505o(95774);
            return null;
        }
        C45035f c37257d = new C37257d(c41630o, i);
        AppMethodBeat.m2505o(95774);
        return c37257d;
    }

    /* renamed from: c */
    private static C45035f m82548c(C41631p c41631p, int[][] iArr, C32052b c32052b) {
        AppMethodBeat.m2504i(95775);
        boolean z = false;
        int i = 0;
        C41630o c41630o = null;
        for (int i2 = 0; i2 < c41631p.length; i2++) {
            C41630o c41630o2 = c41631p.bia[i2];
            int[] iArr2 = iArr[i2];
            int i3 = 0;
            while (i3 < c41630o2.length) {
                boolean z2;
                if (C45034c.m82549s(iArr2[i3], c32052b.bpt)) {
                    if ((c41630o2.bhv[i3].aOs & 1) != 0) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        z2 = true;
                    } else {
                        z2 = true;
                    }
                    if (C45034c.m82549s(iArr2[i3], false)) {
                        z2 += 1000;
                    }
                    if (z2 > z) {
                        i = i3;
                        c41630o = c41630o2;
                        i3++;
                        z = z2;
                    }
                }
                z2 = z;
                i3++;
                z = z2;
            }
        }
        if (c41630o == null) {
            AppMethodBeat.m2505o(95775);
            return null;
        }
        C45035f c37257d = new C37257d(c41630o, i);
        AppMethodBeat.m2505o(95775);
        return c37257d;
    }

    /* renamed from: s */
    private static boolean m82549s(int i, boolean z) {
        int i2 = i & 7;
        return i2 == 4 || (z && i2 == 3);
    }

    /* renamed from: a */
    private static boolean m82543a(Format format, String str) {
        AppMethodBeat.m2504i(95776);
        if (str == null || !TextUtils.equals(str, C17675v.m27558aP(format.aOt))) {
            AppMethodBeat.m2505o(95776);
            return false;
        }
        AppMethodBeat.m2505o(95776);
        return true;
    }

    /* renamed from: a */
    private static List<Integer> m82541a(C41630o c41630o, int i, int i2, boolean z) {
        int i3;
        int i4 = 0;
        AppMethodBeat.m2504i(95777);
        ArrayList arrayList = new ArrayList(c41630o.length);
        for (i3 = 0; i3 < c41630o.length; i3++) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (i == BaseClientBuilder.API_PRIORITY_OTHER || i2 == BaseClientBuilder.API_PRIORITY_OTHER) {
            AppMethodBeat.m2505o(95777);
            return arrayList;
        }
        int i5 = Integer.MAX_VALUE;
        while (i4 < c41630o.length) {
            Format format = c41630o.bhv[i4];
            if (format.width > 0 && format.height > 0) {
                Point a = C45034c.m82538a(z, i, i2, format.width, format.height);
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
                i3 = c41630o.bhv[((Integer) arrayList.get(i4)).intValue()].mo19120qb();
                if (i3 == -1 || i3 > i5) {
                    arrayList.remove(i4);
                }
            }
        }
        AppMethodBeat.m2505o(95777);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x002c  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0019  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    private static Point m82538a(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        Object obj = 1;
        AppMethodBeat.m2504i(95778);
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
                    point = new Point(i6, C17675v.m27565bi(i6 * i4, i3));
                    AppMethodBeat.m2505o(95778);
                    return point;
                }
                point = new Point(C17675v.m27565bi(i5 * i3, i4), i5);
                AppMethodBeat.m2505o(95778);
                return point;
            }
        }
        i5 = i2;
        i6 = i;
        if (i3 * i5 < i4 * i6) {
        }
    }
}
