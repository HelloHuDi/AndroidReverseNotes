package com.google.b.f.b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.b.f.a.a;
import com.google.b.f.a.b;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.view.d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

public final class c {
    private static final int[] bBK = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static f a(String str, a aVar, Map<com.google.b.c, ?> map) {
        b bVar;
        int i;
        int i2;
        int charAt;
        h hVar;
        h hVar2;
        com.google.b.f.a.c a;
        int i3 = 0;
        AppMethodBeat.i(57249);
        Object obj = "ISO-8859-1";
        if (map != null && map.containsKey(com.google.b.c.CHARACTER_SET)) {
            obj = map.get(com.google.b.c.CHARACTER_SET).toString();
        }
        if ("Shift_JIS".equals(obj) && bl(str)) {
            bVar = b.KANJI;
        } else {
            i = 0;
            i2 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt2 = str.charAt(i4);
                if (charAt2 < '0' || charAt2 > '9') {
                    if (fI(charAt2) == -1) {
                        bVar = b.BYTE;
                        break;
                    }
                    i = 1;
                } else {
                    i2 = 1;
                }
            }
            if (i != 0) {
                bVar = b.ALPHANUMERIC;
            } else if (i2 != 0) {
                bVar = b.NUMERIC;
            } else {
                bVar = b.BYTE;
            }
        }
        com.google.b.b.a aVar2 = new com.google.b.b.a();
        if (bVar == b.BYTE && !"ISO-8859-1".equals(obj)) {
            com.google.b.b.c bh = com.google.b.b.c.bh(obj);
            if (bh != null) {
                aVar2.bA(b.ECI.bBk, 4);
                aVar2.bA(bh.bzj[0], 8);
            }
        }
        aVar2.bA(bVar.bBk, 4);
        com.google.b.b.a aVar3 = new com.google.b.b.a();
        int length;
        int fI;
        switch (bVar) {
            case NUMERIC:
                length = str.length();
                while (i3 < length) {
                    charAt = str.charAt(i3) - 48;
                    if (i3 + 2 < length) {
                        aVar3.bA(((charAt * 100) + ((str.charAt(i3 + 1) - 48) * 10)) + (str.charAt(i3 + 2) - 48), 10);
                        i3 += 3;
                    } else if (i3 + 1 < length) {
                        aVar3.bA((charAt * 10) + (str.charAt(i3 + 1) - 48), 7);
                        i3 += 2;
                    } else {
                        aVar3.bA(charAt, 4);
                        i3++;
                    }
                }
                break;
            case ALPHANUMERIC:
                length = str.length();
                while (i3 < length) {
                    int fI2 = fI(str.charAt(i3));
                    if (fI2 == -1) {
                        hVar = new h();
                        AppMethodBeat.o(57249);
                        throw hVar;
                    } else if (i3 + 1 < length) {
                        fI = fI(str.charAt(i3 + 1));
                        if (fI == -1) {
                            hVar = new h();
                            AppMethodBeat.o(57249);
                            throw hVar;
                        }
                        aVar3.bA((fI2 * 45) + fI, 11);
                        i3 += 2;
                    } else {
                        aVar3.bA(fI2, 6);
                        i3++;
                    }
                }
                break;
            case BYTE:
                try {
                    byte[] bytes = str.getBytes(obj);
                    charAt = bytes.length;
                    while (i3 < charAt) {
                        aVar3.bA(bytes[i3], 8);
                        i3++;
                    }
                    break;
                } catch (UnsupportedEncodingException e) {
                    hVar2 = new h(e);
                    AppMethodBeat.o(57249);
                    throw hVar2;
                }
            case KANJI:
                try {
                    byte[] bytes2 = str.getBytes("Shift_JIS");
                    fI = bytes2.length;
                    while (i3 < fI) {
                        length = ((bytes2[i3] & 255) << 8) | (bytes2[i3 + 1] & 255);
                        if (length >= 33088 && length <= 40956) {
                            length -= 33088;
                        } else if (length < 57408 || length > 60351) {
                            length = -1;
                        } else {
                            length -= 49472;
                        }
                        if (length == -1) {
                            hVar = new h("Invalid byte sequence");
                            AppMethodBeat.o(57249);
                            throw hVar;
                        }
                        aVar3.bA((length & 255) + ((length >> 8) * az.CTRL_INDEX), 13);
                        i3 += 2;
                    }
                    break;
                } catch (UnsupportedEncodingException e2) {
                    hVar2 = new h(e2);
                    AppMethodBeat.o(57249);
                    throw hVar2;
                }
                break;
            default:
                hVar = new h("Invalid mode: ".concat(String.valueOf(bVar)));
                AppMethodBeat.o(57249);
                throw hVar;
        }
        if (map == null || !map.containsKey(com.google.b.c.QR_VERSION)) {
            a = a(a(bVar, aVar2, aVar3, a(a(bVar, aVar2, aVar3, com.google.b.f.a.c.fH(1)), aVar)), aVar);
        } else {
            a = com.google.b.f.a.c.fH(Integer.parseInt(map.get(com.google.b.c.QR_VERSION).toString()));
            if (!a(a(bVar, aVar2, aVar3, a), a, aVar)) {
                hVar = new h("Data too big for requested version");
                AppMethodBeat.o(57249);
                throw hVar;
            }
        }
        com.google.b.b.a aVar4 = new com.google.b.b.a();
        aVar4.a(aVar2);
        if (bVar == b.BYTE) {
            i2 = aVar3.vt();
        } else {
            i2 = str.length();
        }
        charAt = bVar.a(a);
        if (i2 >= (1 << charAt)) {
            hVar = new h(i2 + " is bigger than " + ((1 << charAt) - 1));
            AppMethodBeat.o(57249);
            throw hVar;
        }
        aVar4.bA(i2, charAt);
        aVar4.a(aVar3);
        com.google.b.f.a.c.b a2 = a.a(aVar);
        i2 = a.bBD - a2.vM();
        a(i2, aVar4);
        com.google.b.b.a a3 = a(aVar4, a.bBD, i2, a2.vL());
        f fVar = new f();
        fVar.bBR = aVar;
        fVar.bBQ = bVar;
        fVar.bBS = a;
        i = (a.bBA * 4) + 17;
        b bVar2 = new b(i, i);
        i = a(a3, aVar, a, bVar2);
        fVar.bBT = i;
        e.a(a3, aVar, a, i, bVar2);
        fVar.bBU = bVar2;
        AppMethodBeat.o(57249);
        return fVar;
    }

    private static int fI(int i) {
        if (i < bBK.length) {
            return bBK[i];
        }
        return -1;
    }

    private static boolean bl(String str) {
        AppMethodBeat.i(57251);
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                AppMethodBeat.o(57251);
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < GmsClientSupervisor.DEFAULT_BIND_FLAGS || i2 > JsApiGetBackgroundAudioState.CTRL_INDEX) && (i2 < 224 || i2 > d.MIC_PTU_AUTOLEVEL)) {
                    AppMethodBeat.o(57251);
                    return false;
                }
            }
            AppMethodBeat.o(57251);
            return true;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(57251);
            return false;
        }
    }

    private static int a(com.google.b.b.a aVar, a aVar2, com.google.b.f.a.c cVar, b bVar) {
        AppMethodBeat.i(57252);
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            int i4;
            byte[] bArr;
            e.a(aVar, aVar2, cVar, i3, bVar);
            int a = d.a(bVar, true) + d.a(bVar, false);
            int i5 = 0;
            byte[][] bArr2 = bVar.bBJ;
            int i6 = bVar.width;
            int i7 = bVar.height;
            int i8 = 0;
            while (true) {
                i4 = i8;
                if (i4 >= i7 - 1) {
                    break;
                }
                i8 = 0;
                while (i8 < i6 - 1) {
                    byte b = bArr2[i4][i8];
                    if (b == bArr2[i4][i8 + 1] && b == bArr2[i4 + 1][i8] && b == bArr2[i4 + 1][i8 + 1]) {
                        i5++;
                    }
                    i8++;
                }
                i8 = i4 + 1;
            }
            a += i5 * 3;
            i5 = 0;
            bArr2 = bVar.bBJ;
            i6 = bVar.width;
            i7 = bVar.height;
            i4 = 0;
            while (i4 < i7) {
                i8 = 0;
                while (i8 < i6) {
                    bArr = bArr2[i4];
                    if (i8 + 6 < i6 && bArr[i8] == (byte) 1 && bArr[i8 + 1] == (byte) 0 && bArr[i8 + 2] == (byte) 1 && bArr[i8 + 3] == (byte) 1 && bArr[i8 + 4] == (byte) 1 && bArr[i8 + 5] == (byte) 0 && bArr[i8 + 6] == (byte) 1 && (d.o(bArr, i8 - 4, i8) || d.o(bArr, i8 + 7, i8 + 11))) {
                        i5++;
                    }
                    if (i4 + 6 < i7 && bArr2[i4][i8] == (byte) 1 && bArr2[i4 + 1][i8] == (byte) 0 && bArr2[i4 + 2][i8] == (byte) 1 && bArr2[i4 + 3][i8] == (byte) 1 && bArr2[i4 + 4][i8] == (byte) 1 && bArr2[i4 + 5][i8] == (byte) 0 && bArr2[i4 + 6][i8] == (byte) 1 && (d.a(bArr2, i8, i4 - 4, i4) || d.a(bArr2, i8, i4 + 7, i4 + 11))) {
                        i5++;
                    }
                    i8++;
                }
                i4++;
            }
            a += i5 * 40;
            i5 = 0;
            bArr2 = bVar.bBJ;
            i6 = bVar.width;
            i7 = bVar.height;
            for (i4 = 0; i4 < i7; i4++) {
                bArr = bArr2[i4];
                for (i8 = 0; i8 < i6; i8++) {
                    if (bArr[i8] == (byte) 1) {
                        i5++;
                    }
                }
            }
            i8 = bVar.height * bVar.width;
            i8 = a + (((Math.abs((i5 << 1) - i8) * 10) / i8) * 10);
            if (i8 < i) {
                i5 = i3;
            } else {
                i5 = i2;
                i8 = i;
            }
            i3++;
            i2 = i5;
            i = i8;
        }
        AppMethodBeat.o(57252);
        return i2;
    }

    private static com.google.b.f.a.c a(int i, a aVar) {
        AppMethodBeat.i(57253);
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.b.f.a.c fH = com.google.b.f.a.c.fH(i2);
            if (a(i, fH, aVar)) {
                AppMethodBeat.o(57253);
                return fH;
            }
        }
        h hVar = new h("Data too big");
        AppMethodBeat.o(57253);
        throw hVar;
    }

    private static void a(int i, com.google.b.b.a aVar) {
        AppMethodBeat.i(57255);
        int i2 = i << 3;
        h hVar;
        if (aVar.size > i2) {
            hVar = new h("data bits cannot fit in the QR Code" + aVar.size + " > " + i2);
            AppMethodBeat.o(57255);
            throw hVar;
        }
        int i3;
        for (i3 = 0; i3 < 4 && aVar.size < i2; i3++) {
            aVar.aT(false);
        }
        i3 = aVar.size & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                aVar.aT(false);
                i3++;
            }
        }
        int vt = i - aVar.vt();
        for (i3 = 0; i3 < vt; i3++) {
            aVar.bA((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (aVar.size != i2) {
            hVar = new h("Bits size does not equal capacity");
            AppMethodBeat.o(57255);
            throw hVar;
        }
        AppMethodBeat.o(57255);
    }

    private static com.google.b.b.a a(com.google.b.b.a aVar, int i, int i2, int i3) {
        AppMethodBeat.i(57256);
        h hVar;
        if (aVar.vt() != i2) {
            hVar = new h("Number of bits and data bytes does not match");
            AppMethodBeat.o(57256);
            throw hVar;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        ArrayList<a> arrayList = new ArrayList(i3);
        int i7 = 0;
        while (true) {
            int i8 = i6;
            if (i7 < i3) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                if (i7 >= i3) {
                    hVar = new h("Block ID too large");
                    AppMethodBeat.o(57256);
                    throw hVar;
                }
                int i9 = i % i3;
                int i10 = i3 - i9;
                int i11 = i / i3;
                int i12 = i11 + 1;
                int i13 = i2 / i3;
                int i14 = i13 + 1;
                i11 -= i13;
                i12 -= i14;
                if (i11 != i12) {
                    hVar = new h("EC bytes mismatch");
                    AppMethodBeat.o(57256);
                    throw hVar;
                } else if (i3 != i10 + i9) {
                    hVar = new h("RS blocks mismatch");
                    AppMethodBeat.o(57256);
                    throw hVar;
                } else {
                    if (i != (i9 * (i14 + i12)) + ((i13 + i11) * i10)) {
                        hVar = new h("Total bytes mismatch");
                        AppMethodBeat.o(57256);
                        throw hVar;
                    }
                    if (i7 < i10) {
                        iArr[0] = i13;
                        iArr2[0] = i11;
                    } else {
                        iArr[0] = i14;
                        iArr2[0] = i12;
                    }
                    i9 = iArr[0];
                    byte[] bArr = new byte[i9];
                    aVar.a(i4 << 3, bArr, i9);
                    byte[] r = r(bArr, iArr2[0]);
                    arrayList.add(new a(bArr, r));
                    i5 = Math.max(i5, i9);
                    i6 = Math.max(i8, r.length);
                    i4 += iArr[0];
                    i7++;
                }
            } else if (i2 != i4) {
                hVar = new h("Data bytes does not match offset");
                AppMethodBeat.o(57256);
                throw hVar;
            } else {
                byte[] bArr2;
                com.google.b.b.a aVar2 = new com.google.b.b.a();
                for (i6 = 0; i6 < i5; i6++) {
                    for (a aVar3 : arrayList) {
                        bArr2 = aVar3.bBH;
                        if (i6 < bArr2.length) {
                            aVar2.bA(bArr2[i6], 8);
                        }
                    }
                }
                for (i6 = 0; i6 < i8; i6++) {
                    for (a aVar32 : arrayList) {
                        bArr2 = aVar32.bBI;
                        if (i6 < bArr2.length) {
                            aVar2.bA(bArr2[i6], 8);
                        }
                    }
                }
                if (i != aVar2.vt()) {
                    hVar = new h("Interleaving error: " + i + " and " + aVar2.vt() + " differ.");
                    AppMethodBeat.o(57256);
                    throw hVar;
                }
                AppMethodBeat.o(57256);
                return aVar2;
            }
        }
    }

    private static byte[] r(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.i(57257);
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new com.google.b.b.a.c(com.google.b.b.a.a.bzq).e(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        AppMethodBeat.o(57257);
        return bArr2;
    }

    private static int a(b bVar, com.google.b.b.a aVar, com.google.b.b.a aVar2, com.google.b.f.a.c cVar) {
        AppMethodBeat.i(57250);
        int a = (aVar.size + bVar.a(cVar)) + aVar2.size;
        AppMethodBeat.o(57250);
        return a;
    }

    private static boolean a(int i, com.google.b.f.a.c cVar, a aVar) {
        AppMethodBeat.i(57254);
        if (cVar.bBD - cVar.a(aVar).vM() >= (i + 7) / 8) {
            AppMethodBeat.o(57254);
            return true;
        }
        AppMethodBeat.o(57254);
        return false;
    }
}
