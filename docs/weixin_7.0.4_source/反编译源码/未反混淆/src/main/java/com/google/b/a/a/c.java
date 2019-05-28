package com.google.b.a.a;

import com.google.b.b.a;
import com.google.b.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.aa;
import com.tencent.ttpic.wav.WavFileHeader;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public final class c {
    private static final int[] byq = new int[]{4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static a n(byte[] bArr, int i, int i2) {
        int i3;
        int abs;
        int t;
        int i4;
        a aVar;
        boolean z;
        a aVar2;
        a a;
        int i5;
        AppMethodBeat.i(57195);
        d dVar = new d(bArr);
        Iterable singletonList = Collections.singletonList(f.byy);
        int i6 = 0;
        while (i6 < dVar.byv.length) {
            byte b = i6 + 1 < dVar.byv.length ? dVar.byv[i6 + 1] : (byte) 0;
            switch (dVar.byv[i6]) {
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
                case aa.CTRL_INDEX /*58*/:
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
                singletonList = d.a((Iterable) singletonList, i6, i3);
                i3 = i6 + 1;
            } else {
                Collection linkedList = new LinkedList();
                for (f a2 : singletonList) {
                    dVar.a(a2, i6, linkedList);
                }
                singletonList = d.c(linkedList);
                i3 = i6;
            }
            i6 = i3 + 1;
        }
        a r = ((f) Collections.min(singletonList, new Comparator<f>() {
            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                return ((f) obj).byB - ((f) obj2).byB;
            }
        })).r(dVar.byv);
        int i7 = ((r.size * i) / 100) + 11;
        int i8 = r.size + i7;
        IllegalArgumentException illegalArgumentException;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            abs = Math.abs(i2);
            if (abs > (z2 ? 4 : 32)) {
                illegalArgumentException = new IllegalArgumentException(String.format("Illegal value %s for layers", new Object[]{Integer.valueOf(i2)}));
                AppMethodBeat.o(57195);
                throw illegalArgumentException;
            }
            t = t(abs, z2);
            i8 = byq[abs];
            i4 = t - (t % i8);
            a a3 = a(r, i8);
            if (a3.size + i7 > i4) {
                illegalArgumentException = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.o(57195);
                throw illegalArgumentException;
            } else if (!z2 || a3.size <= (i8 << 6)) {
                aVar = a3;
                z = z2;
            } else {
                illegalArgumentException = new IllegalArgumentException("Data to large for user specified layer");
                AppMethodBeat.o(57195);
                throw illegalArgumentException;
            }
        }
        i6 = 0;
        aVar2 = null;
        i4 = 0;
        while (i4 <= 32) {
            z = i4 <= 3;
            if (z) {
                abs = i4 + 1;
            } else {
                abs = i4;
            }
            t = t(abs, z);
            if (i8 <= t) {
                if (i6 != byq[abs]) {
                    i6 = byq[abs];
                    aVar2 = a(r, i6);
                }
                int i9 = t - (t % i6);
                if ((!z || aVar2.size <= (i6 << 6)) && aVar2.size + i7 <= i9) {
                    aVar = aVar2;
                    i8 = i6;
                }
            }
            i4++;
        }
        illegalArgumentException = new IllegalArgumentException("Data too large for an Aztec code");
        AppMethodBeat.o(57195);
        throw illegalArgumentException;
        a a4 = a(aVar, t, i8);
        int i10 = aVar.size / i8;
        aVar2 = new a();
        if (z) {
            aVar2.bA(abs - 1, 2);
            aVar2.bA(i10 - 1, 6);
            a = a(aVar2, 28, 4);
        } else {
            aVar2.bA(abs - 1, 5);
            aVar2.bA(i10 - 1, 11);
            a = a(aVar2, 40, 4);
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
        b bVar = new b(i3);
        t = 0;
        i5 = 0;
        while (t < abs) {
            int i11 = ((abs - t) << 2) + (z ? 9 : 12);
            for (i8 = 0; i8 < i11; i8++) {
                int i12 = i8 << 1;
                for (i4 = 0; i4 < 2; i4++) {
                    if (a4.get((i5 + i12) + i4)) {
                        bVar.set(iArr[(t << 1) + i4], iArr[(t << 1) + i8]);
                    }
                    if (a4.get((((i11 << 1) + i5) + i12) + i4)) {
                        bVar.set(iArr[(t << 1) + i8], iArr[((i6 - 1) - (t << 1)) - i4]);
                    }
                    if (a4.get((((i11 << 2) + i5) + i12) + i4)) {
                        bVar.set(iArr[((i6 - 1) - (t << 1)) - i4], iArr[((i6 - 1) - (t << 1)) - i8]);
                    }
                    if (a4.get((((i11 * 6) + i5) + i12) + i4)) {
                        bVar.set(iArr[((i6 - 1) - (t << 1)) - i8], iArr[(t << 1) + i4]);
                    }
                }
            }
            t++;
            i5 += i11 << 3;
        }
        a(bVar, z, i3, a);
        if (z) {
            a(bVar, i3 / 2, 5);
        } else {
            a(bVar, i3 / 2, 7);
            i4 = 0;
            i8 = 0;
            while (i4 < (i6 / 2) - 1) {
                for (t = (i3 / 2) & 1; t < i3; t += 2) {
                    bVar.set((i3 / 2) - i8, t);
                    bVar.set((i3 / 2) + i8, t);
                    bVar.set(t, (i3 / 2) - i8);
                    bVar.set(t, (i3 / 2) + i8);
                }
                i4 += 15;
                i8 += 16;
            }
        }
        a aVar3 = new a();
        aVar3.byk = z;
        aVar3.size = i3;
        aVar3.byl = abs;
        aVar3.bym = i10;
        aVar3.byn = bVar;
        AppMethodBeat.o(57195);
        return aVar3;
    }

    private static void a(b bVar, int i, int i2) {
        AppMethodBeat.i(57196);
        for (int i3 = 0; i3 < i2; i3 += 2) {
            for (int i4 = i - i3; i4 <= i + i3; i4++) {
                bVar.set(i4, i - i3);
                bVar.set(i4, i + i3);
                bVar.set(i - i3, i4);
                bVar.set(i + i3, i4);
            }
        }
        bVar.set(i - i2, i - i2);
        bVar.set((i - i2) + 1, i - i2);
        bVar.set(i - i2, (i - i2) + 1);
        bVar.set(i + i2, i - i2);
        bVar.set(i + i2, (i - i2) + 1);
        bVar.set(i + i2, (i + i2) - 1);
        AppMethodBeat.o(57196);
    }

    private static void a(b bVar, boolean z, int i, a aVar) {
        int i2 = 0;
        AppMethodBeat.i(57197);
        int i3 = i / 2;
        int i4;
        if (z) {
            while (i2 < 7) {
                i4 = (i3 - 3) + i2;
                if (aVar.get(i2)) {
                    bVar.set(i4, i3 - 5);
                }
                if (aVar.get(i2 + 7)) {
                    bVar.set(i3 + 5, i4);
                }
                if (aVar.get(20 - i2)) {
                    bVar.set(i4, i3 + 5);
                }
                if (aVar.get(27 - i2)) {
                    bVar.set(i3 - 5, i4);
                }
                i2++;
            }
            AppMethodBeat.o(57197);
            return;
        }
        while (i2 < 10) {
            i4 = ((i3 - 5) + i2) + (i2 / 5);
            if (aVar.get(i2)) {
                bVar.set(i4, i3 - 7);
            }
            if (aVar.get(i2 + 10)) {
                bVar.set(i3 + 7, i4);
            }
            if (aVar.get(29 - i2)) {
                bVar.set(i4, i3 + 7);
            }
            if (aVar.get(39 - i2)) {
                bVar.set(i3 - 7, i4);
            }
            i2++;
        }
        AppMethodBeat.o(57197);
    }

    private static int[] b(a aVar, int i, int i2) {
        AppMethodBeat.i(57199);
        int[] iArr = new int[i2];
        int i3 = aVar.size / i;
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < i; i6++) {
                int i7;
                if (aVar.get((i4 * i) + i6)) {
                    i7 = 1 << ((i - i6) - 1);
                } else {
                    i7 = 0;
                }
                i5 |= i7;
            }
            iArr[i4] = i5;
        }
        AppMethodBeat.o(57199);
        return iArr;
    }

    private static a a(a aVar, int i) {
        AppMethodBeat.i(57200);
        a aVar2 = new a();
        int i2 = aVar.size;
        int i3 = (1 << i) - 2;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = 0;
            int i6 = 0;
            while (i5 < i) {
                if (i4 + i5 >= i2 || aVar.get(i4 + i5)) {
                    i6 |= 1 << ((i - 1) - i5);
                }
                i5++;
            }
            if ((i6 & i3) == i3) {
                aVar2.bA(i6 & i3, i);
                i6 = i4 - 1;
            } else if ((i6 & i3) == 0) {
                aVar2.bA(i6 | 1, i);
                i6 = i4 - 1;
            } else {
                aVar2.bA(i6, i);
                i6 = i4;
            }
            i4 = i6 + i;
        }
        AppMethodBeat.o(57200);
        return aVar2;
    }

    private static int t(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    private static a a(a aVar, int i, int i2) {
        com.google.b.b.a.a aVar2;
        AppMethodBeat.i(57198);
        int i3 = aVar.size / i2;
        switch (i2) {
            case 4:
                aVar2 = com.google.b.b.a.a.bzp;
                break;
            case 6:
                aVar2 = com.google.b.b.a.a.bzo;
                break;
            case 8:
                aVar2 = com.google.b.b.a.a.bzs;
                break;
            case 10:
                aVar2 = com.google.b.b.a.a.bzn;
                break;
            case 12:
                aVar2 = com.google.b.b.a.a.bzm;
                break;
            default:
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i2)));
                AppMethodBeat.o(57198);
                throw illegalArgumentException;
        }
        com.google.b.b.a.c cVar = new com.google.b.b.a.c(aVar2);
        int i4 = i / i2;
        int[] b = b(aVar, i2, i4);
        cVar.e(b, i4 - i3);
        i4 = i % i2;
        a aVar3 = new a();
        aVar3.bA(0, i4);
        for (int bA : b) {
            aVar3.bA(bA, i2);
        }
        AppMethodBeat.o(57198);
        return aVar3;
    }
}
