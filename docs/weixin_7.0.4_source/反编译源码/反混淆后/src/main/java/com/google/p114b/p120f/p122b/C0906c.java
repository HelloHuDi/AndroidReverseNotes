package com.google.p114b.p120f.p122b;

import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.p114b.C37300h;
import com.google.p114b.C41638c;
import com.google.p114b.p120f.p121a.C0902c;
import com.google.p114b.p120f.p121a.C0902c.C0903b;
import com.google.p114b.p120f.p121a.C32089a;
import com.google.p114b.p120f.p121a.C8737b;
import com.google.p114b.p801b.C37294c;
import com.google.p114b.p801b.C8727a;
import com.google.p114b.p801b.p1521a.C37293c;
import com.google.p114b.p801b.p1521a.C41637a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.C33250az;
import com.tencent.p177mm.plugin.appbrand.jsapi.audio.JsApiGetBackgroundAudioState;
import com.tencent.view.C31128d;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

/* renamed from: com.google.b.f.b.c */
public final class C0906c {
    private static final int[] bBK = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: a */
    public static C45066f m2059a(String str, C32089a c32089a, Map<C41638c, ?> map) {
        C8737b c8737b;
        int i;
        int i2;
        int charAt;
        C37300h c37300h;
        C37300h c37300h2;
        C0902c a;
        int i3 = 0;
        AppMethodBeat.m2504i(57249);
        Object obj = "ISO-8859-1";
        if (map != null && map.containsKey(C41638c.CHARACTER_SET)) {
            obj = map.get(C41638c.CHARACTER_SET).toString();
        }
        if ("Shift_JIS".equals(obj) && C0906c.m2062bl(str)) {
            c8737b = C8737b.KANJI;
        } else {
            i = 0;
            i2 = 0;
            for (int i4 = 0; i4 < str.length(); i4++) {
                char charAt2 = str.charAt(i4);
                if (charAt2 < '0' || charAt2 > '9') {
                    if (C0906c.m2063fI(charAt2) == -1) {
                        c8737b = C8737b.BYTE;
                        break;
                    }
                    i = 1;
                } else {
                    i2 = 1;
                }
            }
            if (i != 0) {
                c8737b = C8737b.ALPHANUMERIC;
            } else if (i2 != 0) {
                c8737b = C8737b.NUMERIC;
            } else {
                c8737b = C8737b.BYTE;
            }
        }
        C8727a c8727a = new C8727a();
        if (c8737b == C8737b.BYTE && !"ISO-8859-1".equals(obj)) {
            C37294c bh = C37294c.m62695bh(obj);
            if (bh != null) {
                c8727a.mo19742bA(C8737b.ECI.bBk, 4);
                c8727a.mo19742bA(bh.bzj[0], 8);
            }
        }
        c8727a.mo19742bA(c8737b.bBk, 4);
        C8727a c8727a2 = new C8727a();
        int length;
        int fI;
        switch (c8737b) {
            case NUMERIC:
                length = str.length();
                while (i3 < length) {
                    charAt = str.charAt(i3) - 48;
                    if (i3 + 2 < length) {
                        c8727a2.mo19742bA(((charAt * 100) + ((str.charAt(i3 + 1) - 48) * 10)) + (str.charAt(i3 + 2) - 48), 10);
                        i3 += 3;
                    } else if (i3 + 1 < length) {
                        c8727a2.mo19742bA((charAt * 10) + (str.charAt(i3 + 1) - 48), 7);
                        i3 += 2;
                    } else {
                        c8727a2.mo19742bA(charAt, 4);
                        i3++;
                    }
                }
                break;
            case ALPHANUMERIC:
                length = str.length();
                while (i3 < length) {
                    int fI2 = C0906c.m2063fI(str.charAt(i3));
                    if (fI2 == -1) {
                        c37300h = new C37300h();
                        AppMethodBeat.m2505o(57249);
                        throw c37300h;
                    } else if (i3 + 1 < length) {
                        fI = C0906c.m2063fI(str.charAt(i3 + 1));
                        if (fI == -1) {
                            c37300h = new C37300h();
                            AppMethodBeat.m2505o(57249);
                            throw c37300h;
                        }
                        c8727a2.mo19742bA((fI2 * 45) + fI, 11);
                        i3 += 2;
                    } else {
                        c8727a2.mo19742bA(fI2, 6);
                        i3++;
                    }
                }
                break;
            case BYTE:
                try {
                    byte[] bytes = str.getBytes(obj);
                    charAt = bytes.length;
                    while (i3 < charAt) {
                        c8727a2.mo19742bA(bytes[i3], 8);
                        i3++;
                    }
                    break;
                } catch (UnsupportedEncodingException e) {
                    c37300h2 = new C37300h(e);
                    AppMethodBeat.m2505o(57249);
                    throw c37300h2;
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
                            c37300h = new C37300h("Invalid byte sequence");
                            AppMethodBeat.m2505o(57249);
                            throw c37300h;
                        }
                        c8727a2.mo19742bA((length & 255) + ((length >> 8) * C33250az.CTRL_INDEX), 13);
                        i3 += 2;
                    }
                    break;
                } catch (UnsupportedEncodingException e2) {
                    c37300h2 = new C37300h(e2);
                    AppMethodBeat.m2505o(57249);
                    throw c37300h2;
                }
                break;
            default:
                c37300h = new C37300h("Invalid mode: ".concat(String.valueOf(c8737b)));
                AppMethodBeat.m2505o(57249);
                throw c37300h;
        }
        if (map == null || !map.containsKey(C41638c.QR_VERSION)) {
            a = C0906c.m2058a(C0906c.m2056a(c8737b, c8727a, c8727a2, C0906c.m2058a(C0906c.m2056a(c8737b, c8727a, c8727a2, C0902c.m2050fH(1)), c32089a)), c32089a);
        } else {
            a = C0902c.m2050fH(Integer.parseInt(map.get(C41638c.QR_VERSION).toString()));
            if (!C0906c.m2061a(C0906c.m2056a(c8737b, c8727a, c8727a2, a), a, c32089a)) {
                c37300h = new C37300h("Data too big for requested version");
                AppMethodBeat.m2505o(57249);
                throw c37300h;
            }
        }
        C8727a c8727a3 = new C8727a();
        c8727a3.mo19740a(c8727a);
        if (c8737b == C8737b.BYTE) {
            i2 = c8727a2.mo19748vt();
        } else {
            i2 = str.length();
        }
        charAt = c8737b.mo19751a(a);
        if (i2 >= (1 << charAt)) {
            c37300h = new C37300h(i2 + " is bigger than " + ((1 << charAt) - 1));
            AppMethodBeat.m2505o(57249);
            throw c37300h;
        }
        c8727a3.mo19742bA(i2, charAt);
        c8727a3.mo19740a(c8727a2);
        C0903b a2 = a.mo3689a(c32089a);
        i2 = a.bBD - a2.mo3692vM();
        C0906c.m2060a(i2, c8727a3);
        C8727a a3 = C0906c.m2057a(c8727a3, a.bBD, i2, a2.mo3691vL());
        C45066f c45066f = new C45066f();
        c45066f.bBR = c32089a;
        c45066f.bBQ = c8737b;
        c45066f.bBS = a;
        i = (a.bBA * 4) + 17;
        C8738b c8738b = new C8738b(i, i);
        i = C0906c.m2055a(a3, c32089a, a, c8738b);
        c45066f.bBT = i;
        C32091e.m52213a(a3, c32089a, a, i, c8738b);
        c45066f.bBU = c8738b;
        AppMethodBeat.m2505o(57249);
        return c45066f;
    }

    /* renamed from: fI */
    private static int m2063fI(int i) {
        if (i < bBK.length) {
            return bBK[i];
        }
        return -1;
    }

    /* renamed from: bl */
    private static boolean m2062bl(String str) {
        AppMethodBeat.m2504i(57251);
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                AppMethodBeat.m2505o(57251);
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < GmsClientSupervisor.DEFAULT_BIND_FLAGS || i2 > JsApiGetBackgroundAudioState.CTRL_INDEX) && (i2 < 224 || i2 > C31128d.MIC_PTU_AUTOLEVEL)) {
                    AppMethodBeat.m2505o(57251);
                    return false;
                }
            }
            AppMethodBeat.m2505o(57251);
            return true;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.m2505o(57251);
            return false;
        }
    }

    /* renamed from: a */
    private static int m2055a(C8727a c8727a, C32089a c32089a, C0902c c0902c, C8738b c8738b) {
        AppMethodBeat.m2504i(57252);
        int i = BaseClientBuilder.API_PRIORITY_OTHER;
        int i2 = -1;
        int i3 = 0;
        while (i3 < 8) {
            int i4;
            byte[] bArr;
            C32091e.m52213a(c8727a, c32089a, c0902c, i3, c8738b);
            int a = C32090d.m52208a(c8738b, true) + C32090d.m52208a(c8738b, false);
            int i5 = 0;
            byte[][] bArr2 = c8738b.bBJ;
            int i6 = c8738b.width;
            int i7 = c8738b.height;
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
            bArr2 = c8738b.bBJ;
            i6 = c8738b.width;
            i7 = c8738b.height;
            i4 = 0;
            while (i4 < i7) {
                i8 = 0;
                while (i8 < i6) {
                    bArr = bArr2[i4];
                    if (i8 + 6 < i6 && bArr[i8] == (byte) 1 && bArr[i8 + 1] == (byte) 0 && bArr[i8 + 2] == (byte) 1 && bArr[i8 + 3] == (byte) 1 && bArr[i8 + 4] == (byte) 1 && bArr[i8 + 5] == (byte) 0 && bArr[i8 + 6] == (byte) 1 && (C32090d.m52210o(bArr, i8 - 4, i8) || C32090d.m52210o(bArr, i8 + 7, i8 + 11))) {
                        i5++;
                    }
                    if (i4 + 6 < i7 && bArr2[i4][i8] == (byte) 1 && bArr2[i4 + 1][i8] == (byte) 0 && bArr2[i4 + 2][i8] == (byte) 1 && bArr2[i4 + 3][i8] == (byte) 1 && bArr2[i4 + 4][i8] == (byte) 1 && bArr2[i4 + 5][i8] == (byte) 0 && bArr2[i4 + 6][i8] == (byte) 1 && (C32090d.m52209a(bArr2, i8, i4 - 4, i4) || C32090d.m52209a(bArr2, i8, i4 + 7, i4 + 11))) {
                        i5++;
                    }
                    i8++;
                }
                i4++;
            }
            a += i5 * 40;
            i5 = 0;
            bArr2 = c8738b.bBJ;
            i6 = c8738b.width;
            i7 = c8738b.height;
            for (i4 = 0; i4 < i7; i4++) {
                bArr = bArr2[i4];
                for (i8 = 0; i8 < i6; i8++) {
                    if (bArr[i8] == (byte) 1) {
                        i5++;
                    }
                }
            }
            i8 = c8738b.height * c8738b.width;
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
        AppMethodBeat.m2505o(57252);
        return i2;
    }

    /* renamed from: a */
    private static C0902c m2058a(int i, C32089a c32089a) {
        AppMethodBeat.m2504i(57253);
        for (int i2 = 1; i2 <= 40; i2++) {
            C0902c fH = C0902c.m2050fH(i2);
            if (C0906c.m2061a(i, fH, c32089a)) {
                AppMethodBeat.m2505o(57253);
                return fH;
            }
        }
        C37300h c37300h = new C37300h("Data too big");
        AppMethodBeat.m2505o(57253);
        throw c37300h;
    }

    /* renamed from: a */
    private static void m2060a(int i, C8727a c8727a) {
        AppMethodBeat.m2504i(57255);
        int i2 = i << 3;
        C37300h c37300h;
        if (c8727a.size > i2) {
            c37300h = new C37300h("data bits cannot fit in the QR Code" + c8727a.size + " > " + i2);
            AppMethodBeat.m2505o(57255);
            throw c37300h;
        }
        int i3;
        for (i3 = 0; i3 < 4 && c8727a.size < i2; i3++) {
            c8727a.mo19741aT(false);
        }
        i3 = c8727a.size & 7;
        if (i3 > 0) {
            while (i3 < 8) {
                c8727a.mo19741aT(false);
                i3++;
            }
        }
        int vt = i - c8727a.mo19748vt();
        for (i3 = 0; i3 < vt; i3++) {
            c8727a.mo19742bA((i3 & 1) == 0 ? 236 : 17, 8);
        }
        if (c8727a.size != i2) {
            c37300h = new C37300h("Bits size does not equal capacity");
            AppMethodBeat.m2505o(57255);
            throw c37300h;
        }
        AppMethodBeat.m2505o(57255);
    }

    /* renamed from: a */
    private static C8727a m2057a(C8727a c8727a, int i, int i2, int i3) {
        AppMethodBeat.m2504i(57256);
        C37300h c37300h;
        if (c8727a.mo19748vt() != i2) {
            c37300h = new C37300h("Number of bits and data bytes does not match");
            AppMethodBeat.m2505o(57256);
            throw c37300h;
        }
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        ArrayList<C0905a> arrayList = new ArrayList(i3);
        int i7 = 0;
        while (true) {
            int i8 = i6;
            if (i7 < i3) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                if (i7 >= i3) {
                    c37300h = new C37300h("Block ID too large");
                    AppMethodBeat.m2505o(57256);
                    throw c37300h;
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
                    c37300h = new C37300h("EC bytes mismatch");
                    AppMethodBeat.m2505o(57256);
                    throw c37300h;
                } else if (i3 != i10 + i9) {
                    c37300h = new C37300h("RS blocks mismatch");
                    AppMethodBeat.m2505o(57256);
                    throw c37300h;
                } else {
                    if (i != (i9 * (i14 + i12)) + ((i13 + i11) * i10)) {
                        c37300h = new C37300h("Total bytes mismatch");
                        AppMethodBeat.m2505o(57256);
                        throw c37300h;
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
                    c8727a.mo19739a(i4 << 3, bArr, i9);
                    byte[] r = C0906c.m2064r(bArr, iArr2[0]);
                    arrayList.add(new C0905a(bArr, r));
                    i5 = Math.max(i5, i9);
                    i6 = Math.max(i8, r.length);
                    i4 += iArr[0];
                    i7++;
                }
            } else if (i2 != i4) {
                c37300h = new C37300h("Data bytes does not match offset");
                AppMethodBeat.m2505o(57256);
                throw c37300h;
            } else {
                byte[] bArr2;
                C8727a c8727a2 = new C8727a();
                for (i6 = 0; i6 < i5; i6++) {
                    for (C0905a c0905a : arrayList) {
                        bArr2 = c0905a.bBH;
                        if (i6 < bArr2.length) {
                            c8727a2.mo19742bA(bArr2[i6], 8);
                        }
                    }
                }
                for (i6 = 0; i6 < i8; i6++) {
                    for (C0905a c0905a2 : arrayList) {
                        bArr2 = c0905a2.bBI;
                        if (i6 < bArr2.length) {
                            c8727a2.mo19742bA(bArr2[i6], 8);
                        }
                    }
                }
                if (i != c8727a2.mo19748vt()) {
                    c37300h = new C37300h("Interleaving error: " + i + " and " + c8727a2.mo19748vt() + " differ.");
                    AppMethodBeat.m2505o(57256);
                    throw c37300h;
                }
                AppMethodBeat.m2505o(57256);
                return c8727a2;
            }
        }
    }

    /* renamed from: r */
    private static byte[] m2064r(byte[] bArr, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(57257);
        int length = bArr.length;
        int[] iArr = new int[(length + i)];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new C37293c(C41637a.bzq).mo59988e(iArr, i);
        byte[] bArr2 = new byte[i];
        while (i2 < i) {
            bArr2[i2] = (byte) iArr[length + i2];
            i2++;
        }
        AppMethodBeat.m2505o(57257);
        return bArr2;
    }

    /* renamed from: a */
    private static int m2056a(C8737b c8737b, C8727a c8727a, C8727a c8727a2, C0902c c0902c) {
        AppMethodBeat.m2504i(57250);
        int a = (c8727a.size + c8737b.mo19751a(c0902c)) + c8727a2.size;
        AppMethodBeat.m2505o(57250);
        return a;
    }

    /* renamed from: a */
    private static boolean m2061a(int i, C0902c c0902c, C32089a c32089a) {
        AppMethodBeat.m2504i(57254);
        if (c0902c.bBD - c0902c.mo3689a(c32089a).mo3692vM() >= (i + 7) / 8) {
            AppMethodBeat.m2505o(57254);
            return true;
        }
        AppMethodBeat.m2505o(57254);
        return false;
    }
}
