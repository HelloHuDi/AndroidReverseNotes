package com.google.p114b.p1162a.p1163a;

import com.google.p114b.p1162a.p1163a.C41635d.C372901;
import com.google.p114b.p801b.C45061b;
import com.google.p114b.p801b.C8727a;
import com.google.p114b.p801b.p1521a.C37293c;
import com.google.p114b.p801b.p1521a.C41637a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C42464aa;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/* renamed from: com.google.b.a.a.c */
public final class C25571c {
    private static final int[] byq = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    /* renamed from: n */
    public static C17698a m40543n(byte[] bArr, int i, int i2) {
        int i3;
        int abs;
        int t;
        int i4;
        C8727a c8727a;
        boolean z;
        C8727a c8727a2;
        C8727a a;
        int i5;
        AppMethodBeat.m2504i(57195);
        C41635d c41635d = new C41635d(bArr);
        Iterable singletonList = Collections.singletonList(C37291f.byy);
        int i6 = 0;
        while (i6 < c41635d.byv.length) {
            byte b = i6 + 1 < c41635d.byv.length ? c41635d.byv[i6 + 1] : (byte) 0;
            switch (c41635d.byv[i6]) {
                case (byte) 13:
                    if (b != (byte) 10) {
                        i3 = 0;
                        break;
                    }
                    i3 = 2;
                    break;
                case WavFileHeader.WAV_FILE_HEADER_SIZE /*44*/:
                    if (b != (byte) 32) {
                        i3 = 0;
                        break;
                    }
                    i3 = 4;
                    break;
                case (byte) 46:
                    if (b != (byte) 32) {
                        i3 = 0;
                        break;
                    }
                    i3 = 3;
                    break;
                case C42464aa.CTRL_INDEX /*58*/:
                    if (b != (byte) 32) {
                        i3 = 0;
                        break;
                    }
                    i3 = 5;
                    break;
                default:
                    i3 = 0;
                    break;
            }
            if (i3 > 0) {
                singletonList = C41635d.m72992a((Iterable) singletonList, i6, i3);
                i3 = i6 + 1;
            } else {
                Collection linkedList = new LinkedList();
                for (C37291f a2 : singletonList) {
                    c41635d.mo67031a(a2, i6, linkedList);
                }
                singletonList = C41635d.m72993c(linkedList);
                i3 = i6;
            }
            i6 = i3 + 1;
        }
        C8727a r = ((C37291f) Collections.min(singletonList, new C372901())).mo59986r(c41635d.byv);
        int i7 = ((r.size * i) / 100) + 11;
        int i8 = r.size + i7;
        IllegalArgumentException illegalArgumentException;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            abs = Math.abs(i2);
            if (abs > (z2 ? 4 : 32)) {
                illegalArgumentException = new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
                AppMethodBeat.m2505o(57195);
                throw illegalArgumentException;
            }
            t = C25571c.m40544t(abs, z2);
            i8 = byq[abs];
            i4 = t - (t % i8);
            C8727a a3 = C25571c.m40538a(r, i8);
            if (a3.size + i7 > i4) {
                illegalArgumentException = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.m2505o(57195);
                throw illegalArgumentException;
            } else if (!z2 || a3.size <= (i8 << 6)) {
                c8727a = a3;
                z = z2;
            } else {
                illegalArgumentException = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.m2505o(57195);
                throw illegalArgumentException;
            }
        }
        i6 = 0;
        c8727a2 = null;
        i4 = 0;
        while (i4 <= 32) {
            z = i4 <= 3;
            if (z) {
                abs = i4 + 1;
            } else {
                abs = i4;
            }
            t = C25571c.m40544t(abs, z);
            if (i8 <= t) {
                if (i6 != byq[abs]) {
                    i6 = byq[abs];
                    c8727a2 = C25571c.m40538a(r, i6);
                }
                int i9 = t - (t % i6);
                if ((!z || c8727a2.size <= (i6 << 6)) && c8727a2.size + i7 <= i9) {
                    c8727a = c8727a2;
                    i8 = i6;
                }
            }
            i4++;
        }
        illegalArgumentException = new IllegalArgumentException("Data too large for an Aztec code");
        AppMethodBeat.m2505o(57195);
        throw illegalArgumentException;
        C8727a a4 = C25571c.m40539a(c8727a, t, i8);
        int i10 = c8727a.size / i8;
        c8727a2 = new C8727a();
        if (z) {
            c8727a2.mo19742bA(abs - 1, 2);
            c8727a2.mo19742bA(i10 - 1, 6);
            a = C25571c.m40539a(c8727a2, 28, 4);
        } else {
            c8727a2.mo19742bA(abs - 1, 5);
            c8727a2.mo19742bA(i10 - 1, 11);
            a = C25571c.m40539a(c8727a2, 40, 4);
        }
        i6 = (abs << 2) + (z ? 11 : 14);
        int[] iArr = new int[i6];
        if (z) {
            for (i3 = 0; i3 < iArr.length; i3++) {
                iArr[i3] = i3;
            }
            i3 = i6;
        } else {
            i3 = (i6 + 1) + ((((i6 / 2) - 1) / 15) * 2);
            i8 = i6 / 2;
            t = i3 / 2;
            for (i4 = 0; i4 < i8; i4++) {
                i5 = (i4 / 15) + i4;
                iArr[(i8 - i4) - 1] = (t - i5) - 1;
                iArr[i8 + i4] = (i5 + t) + 1;
            }
        }
        C45061b c45061b = new C45061b(i3);
        t = 0;
        i5 = 0;
        while (t < abs) {
            int i11 = ((abs - t) << 2) + (z ? 9 : 12);
            for (i8 = 0; i8 < i11; i8++) {
                int i12 = i8 << 1;
                for (i4 = 0; i4 < 2; i4++) {
                    if (a4.get((i5 + i12) + i4)) {
                        c45061b.set(iArr[(t << 1) + i4], iArr[(t << 1) + i8]);
                    }
                    if (a4.get((((i11 << 1) + i5) + i12) + i4)) {
                        c45061b.set(iArr[(t << 1) + i8], iArr[((i6 - 1) - (t << 1)) - i4]);
                    }
                    if (a4.get((((i11 << 2) + i5) + i12) + i4)) {
                        c45061b.set(iArr[((i6 - 1) - (t << 1)) - i4], iArr[((i6 - 1) - (t << 1)) - i8]);
                    }
                    if (a4.get((((i11 * 6) + i5) + i12) + i4)) {
                        c45061b.set(iArr[((i6 - 1) - (t << 1)) - i8], iArr[(t << 1) + i4]);
                    }
                }
            }
            t++;
            i5 += i11 << 3;
        }
        C25571c.m40541a(c45061b, z, i3, a);
        if (z) {
            C25571c.m40540a(c45061b, i3 / 2, 5);
        } else {
            C25571c.m40540a(c45061b, i3 / 2, 7);
            i4 = 0;
            i8 = 0;
            while (i4 < (i6 / 2) - 1) {
                for (t = (i3 / 2) & 1; t < i3; t += 2) {
                    c45061b.set((i3 / 2) - i8, t);
                    c45061b.set((i3 / 2) + i8, t);
                    c45061b.set(t, (i3 / 2) - i8);
                    c45061b.set(t, (i3 / 2) + i8);
                }
                i4 += 15;
                i8 += 16;
            }
        }
        C17698a c17698a = new C17698a();
        c17698a.byk = z;
        c17698a.size = i3;
        c17698a.byl = abs;
        c17698a.bym = i10;
        c17698a.byn = c45061b;
        AppMethodBeat.m2505o(57195);
        return c17698a;
    }

    /* renamed from: a */
    private static void m40540a(C45061b c45061b, int i, int i2) {
        AppMethodBeat.m2504i(57196);
        for (int i3 = 0; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                c45061b.set(i4, i - i3);
                c45061b.set(i4, i + i3);
                c45061b.set(i - i3, i4);
                c45061b.set(i + i3, i4);
            }
        }
        c45061b.set(i - i2, i - i2);
        c45061b.set((i - i2) + 1, i - i2);
        c45061b.set(i - i2, (i - i2) + 1);
        c45061b.set(i + i2, i - i2);
        c45061b.set(i + i2, (i - i2) + 1);
        c45061b.set(i + i2, (i + i2) - 1);
        AppMethodBeat.m2505o(57196);
    }

    /* renamed from: a */
    private static void m40541a(C45061b c45061b, boolean z, int i, C8727a c8727a) {
        int i2 = 0;
        AppMethodBeat.m2504i(57197);
        int i3 = i / 2;
        int i4;
        if (z) {
            while (i2 < 7) {
                i4 = (i3 - 3) + i2;
                if (c8727a.get(i2)) {
                    c45061b.set(i4, i3 - 5);
                }
                if (c8727a.get(i2 + 7)) {
                    c45061b.set(i3 + 5, i4);
                }
                if (c8727a.get(20 - i2)) {
                    c45061b.set(i4, i3 + 5);
                }
                if (c8727a.get(27 - i2)) {
                    c45061b.set(i3 - 5, i4);
                }
                i2++;
            }
            AppMethodBeat.m2505o(57197);
            return;
        }
        while (i2 < 10) {
            i4 = ((i3 - 5) + i2) + (i2 / 5);
            if (c8727a.get(i2)) {
                c45061b.set(i4, i3 - 7);
            }
            if (c8727a.get(i2 + 10)) {
                c45061b.set(i3 + 7, i4);
            }
            if (c8727a.get(29 - i2)) {
                c45061b.set(i4, i3 + 7);
            }
            if (c8727a.get(39 - i2)) {
                c45061b.set(i3 - 7, i4);
            }
            i2++;
        }
        AppMethodBeat.m2505o(57197);
    }

    /* renamed from: b */
    private static int[] m40542b(C8727a c8727a, int i, int i2) {
        AppMethodBeat.m2504i(57199);
        int[] iArr = new int[i2];
        int i3 = c8727a.size / i;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7;
                if (c8727a.get((i4 * i) + i6)) {
                    i7 = 1 << ((i - i6) - 1);
                } else {
                    i7 = 0;
                }
                i5 |= i7;
            }
            iArr[i4] = i5;
        }
        AppMethodBeat.m2505o(57199);
        return iArr;
    }

    /* renamed from: a */
    private static C8727a m40538a(C8727a c8727a, int i) {
        AppMethodBeat.m2504i(57200);
        C8727a c8727a2 = new C8727a();
        int i2 = c8727a.size;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < i) {
                if (i4 + i5 >= i2 || c8727a.get(i4 + i5)) {
                    i6 |= 1 << ((i - 1) - i5);
                }
                i5++;
            }
            if ((i6 & i3) == i3) {
                c8727a2.mo19742bA(i6 & i3, i);
                i6 = i4 - 1;
            } else if ((i6 & i3) == 0) {
                c8727a2.mo19742bA(i6 | 1, i);
                i6 = i4 - 1;
            } else {
                c8727a2.mo19742bA(i6, i);
                i6 = i4;
            }
            i4 = i6 + i;
        }
        AppMethodBeat.m2505o(57200);
        return c8727a2;
    }

    /* renamed from: t */
    private static int m40544t(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    /* renamed from: a */
    private static C8727a m40539a(C8727a c8727a, int i, int i2) {
        C41637a c41637a;
        AppMethodBeat.m2504i(57198);
        int i3 = c8727a.size / i2;
        switch (i2) {
            case 4:
                c41637a = C41637a.bzp;
                break;
            case 6:
                c41637a = C41637a.bzo;
                break;
            case 8:
                c41637a = C41637a.bzs;
                break;
            case 10:
                c41637a = C41637a.bzn;
                break;
            case 12:
                c41637a = C41637a.bzm;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
                AppMethodBeat.m2505o(57198);
                throw illegalArgumentException;
        }
        C37293c c37293c = new C37293c(c41637a);
        int i4 = i / i2;
        int[] b = C25571c.m40542b(c8727a, i2, i4);
        c37293c.mo59988e(b, i4 - i3);
        i4 = i % i2;
        C8727a c8727a2 = new C8727a();
        c8727a2.mo19742bA(0, i4);
        for (int bA : b) {
            c8727a2.mo19742bA(bA, i2);
        }
        AppMethodBeat.m2505o(57198);
        return c8727a2;
    }
}
