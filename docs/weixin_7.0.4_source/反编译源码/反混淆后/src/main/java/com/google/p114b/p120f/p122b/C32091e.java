package com.google.p114b.p120f.p122b;

import com.google.p114b.C37300h;
import com.google.p114b.p120f.p121a.C0902c;
import com.google.p114b.p120f.p121a.C32089a;
import com.google.p114b.p801b.C8727a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19392d;
import com.tencent.p177mm.plugin.appbrand.jsapi.p306g.C19395n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;

/* renamed from: com.google.b.f.b.e */
final class C32091e {
    private static final int[][] bBM = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] bBN = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] bBO = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, C19392d.CTRL_INDEX, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, JsApiMakeVoIPCall.CTRL_INDEX}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, C19395n.CTRL_INDEX, ErrorCode.STARTDOWNLOAD_3}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_TRUE}};
    private static final int[][] bBP = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    /* renamed from: bI */
    private static int m52216bI(int i, int i2) {
        AppMethodBeat.m2504i(57185);
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("0 polynomial");
            AppMethodBeat.m2505o(57185);
            throw illegalArgumentException;
        }
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i2);
        int i3 = i << (numberOfLeadingZeros - 1);
        while (32 - Integer.numberOfLeadingZeros(i3) >= numberOfLeadingZeros) {
            i3 ^= i2 << ((32 - Integer.numberOfLeadingZeros(i3)) - numberOfLeadingZeros);
        }
        AppMethodBeat.m2505o(57185);
        return i3;
    }

    /* renamed from: fJ */
    private static boolean m52218fJ(int i) {
        return i == -1;
    }

    /* renamed from: a */
    private static void m52211a(int i, int i2, C8738b c8738b) {
        AppMethodBeat.m2504i(57186);
        int i3 = 0;
        while (i3 < 8) {
            if (C32091e.m52218fJ(c8738b.mo19752bH(i + i3, i2))) {
                c8738b.set(i + i3, i2, 0);
                i3++;
            } else {
                C37300h c37300h = new C37300h();
                AppMethodBeat.m2505o(57186);
                throw c37300h;
            }
        }
        AppMethodBeat.m2505o(57186);
    }

    /* renamed from: b */
    private static void m52215b(int i, int i2, C8738b c8738b) {
        AppMethodBeat.m2504i(57187);
        int i3 = 0;
        while (i3 < 7) {
            if (C32091e.m52218fJ(c8738b.mo19752bH(i, i2 + i3))) {
                c8738b.set(i, i2 + i3, 0);
                i3++;
            } else {
                C37300h c37300h = new C37300h();
                AppMethodBeat.m2505o(57187);
                throw c37300h;
            }
        }
        AppMethodBeat.m2505o(57187);
    }

    /* renamed from: c */
    private static void m52217c(int i, int i2, C8738b c8738b) {
        AppMethodBeat.m2504i(57188);
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                c8738b.set(i + i4, i2 + i3, bBM[i3][i4]);
            }
        }
        AppMethodBeat.m2505o(57188);
    }

    /* renamed from: a */
    static void m52213a(C8727a c8727a, C32089a c32089a, C0902c c0902c, int i, C8738b c8738b) {
        int i2;
        int i3;
        AppMethodBeat.m2504i(57182);
        for (i2 = 0; i2 < c8738b.height; i2++) {
            for (i3 = 0; i3 < c8738b.width; i3++) {
                c8738b.bBJ[i2][i3] = (byte) -1;
            }
        }
        i2 = bBM[0].length;
        C32091e.m52217c(0, 0, c8738b);
        C32091e.m52217c(c8738b.width - i2, 0, c8738b);
        C32091e.m52217c(0, c8738b.width - i2, c8738b);
        C32091e.m52211a(0, 7, c8738b);
        C32091e.m52211a(c8738b.width - 8, 7, c8738b);
        C32091e.m52211a(0, c8738b.width - 8, c8738b);
        C32091e.m52215b(7, 0, c8738b);
        C32091e.m52215b((c8738b.height - 7) - 1, 0, c8738b);
        C32091e.m52215b(7, c8738b.height - 7, c8738b);
        C37300h c37300h;
        if (c8738b.mo19752bH(8, c8738b.height - 8) == (byte) 0) {
            c37300h = new C37300h();
            AppMethodBeat.m2505o(57182);
            throw c37300h;
        }
        Object obj;
        c8738b.set(8, c8738b.height - 8, 1);
        if (c0902c.bBA >= 2) {
            i2 = c0902c.bBA - 1;
            int[] iArr = bBO[i2];
            int length = bBO[i2].length;
            for (i2 = 0; i2 < length; i2++) {
                for (i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i2];
                    int i5 = iArr[i3];
                    if (i5 != -1 && i4 != -1 && C32091e.m52218fJ(c8738b.mo19752bH(i5, i4))) {
                        int i6 = i5 - 2;
                        int i7 = i4 - 2;
                        i4 = 0;
                        while (true) {
                            i5 = i4;
                            if (i5 >= 5) {
                                break;
                            }
                            for (i4 = 0; i4 < 5; i4++) {
                                c8738b.set(i6 + i4, i7 + i5, bBN[i5][i4]);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            }
        }
        for (i2 = 8; i2 < c8738b.width - 8; i2++) {
            i3 = (i2 + 1) % 2;
            if (C32091e.m52218fJ(c8738b.mo19752bH(i2, 6))) {
                c8738b.set(i2, 6, i3);
            }
            if (C32091e.m52218fJ(c8738b.mo19752bH(6, i2))) {
                c8738b.set(6, i2, i3);
            }
        }
        C8727a c8727a2 = new C8727a();
        if (i < 0 || i >= 8) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            c37300h = new C37300h("Invalid mask pattern");
            AppMethodBeat.m2505o(57182);
            throw c37300h;
        }
        i2 = (c32089a.bBk << 3) | i;
        c8727a2.mo19742bA(i2, 5);
        c8727a2.mo19742bA(C32091e.m52216bI(i2, 1335), 10);
        C8727a c8727a3 = new C8727a();
        c8727a3.mo19742bA(21522, 15);
        if (c8727a2.size != c8727a3.size) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sizes don't match");
            AppMethodBeat.m2505o(57182);
            throw illegalArgumentException;
        }
        for (i2 = 0; i2 < c8727a2.byE.length; i2++) {
            int[] iArr2 = c8727a2.byE;
            iArr2[i2] = iArr2[i2] ^ c8727a3.byE[i2];
        }
        if (c8727a2.size != 15) {
            c37300h = new C37300h("should not happen but we got: " + c8727a2.size);
            AppMethodBeat.m2505o(57182);
            throw c37300h;
        }
        for (i2 = 0; i2 < c8727a2.size; i2++) {
            boolean z = c8727a2.get((c8727a2.size - 1) - i2);
            c8738b.set(bBP[i2][0], bBP[i2][1], z);
            if (i2 < 8) {
                c8738b.set((c8738b.width - i2) - 1, 8, z);
            } else {
                c8738b.set(8, (c8738b.height - 7) + (i2 - 8), z);
            }
        }
        C32091e.m52214a(c0902c, c8738b);
        C32091e.m52212a(c8727a, i, c8738b);
        AppMethodBeat.m2505o(57182);
    }

    /* renamed from: a */
    private static void m52214a(C0902c c0902c, C8738b c8738b) {
        AppMethodBeat.m2504i(57183);
        if (c0902c.bBA < 7) {
            AppMethodBeat.m2505o(57183);
            return;
        }
        C8727a c8727a = new C8727a();
        c8727a.mo19742bA(c0902c.bBA, 6);
        c8727a.mo19742bA(C32091e.m52216bI(c0902c.bBA, 7973), 12);
        if (c8727a.size != 18) {
            C37300h c37300h = new C37300h("should not happen but we got: " + c8727a.size);
            AppMethodBeat.m2505o(57183);
            throw c37300h;
        }
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean z = c8727a.get(i);
                i--;
                c8738b.set(i2, (c8738b.height - 11) + i3, z);
                c8738b.set((c8738b.height - 11) + i3, i2, z);
            }
        }
        AppMethodBeat.m2505o(57183);
    }

    /* renamed from: a */
    private static void m52212a(C8727a c8727a, int i, C8738b c8738b) {
        AppMethodBeat.m2504i(57184);
        int i2 = c8738b.width - 1;
        int i3 = c8738b.height - 1;
        int i4 = -1;
        int i5 = 0;
        while (i2 > 0) {
            int i6;
            int i7;
            int i8;
            if (i2 == 6) {
                i6 = i3;
                i7 = i2 - 1;
            } else {
                i6 = i3;
                i7 = i2;
            }
            while (i6 >= 0 && i6 < c8738b.height) {
                i8 = 0;
                while (i8 < 2) {
                    int i9 = i7 - i8;
                    if (C32091e.m52218fJ(c8738b.mo19752bH(i9, i6))) {
                        boolean z;
                        if (i5 < c8727a.size) {
                            z = c8727a.get(i5);
                            i5++;
                        } else {
                            z = false;
                        }
                        if (i != -1) {
                            Object obj;
                            switch (i) {
                                case 0:
                                    i2 = (i6 + i9) & 1;
                                    break;
                                case 1:
                                    i2 = i6 & 1;
                                    break;
                                case 2:
                                    i2 = i9 % 3;
                                    break;
                                case 3:
                                    i2 = (i6 + i9) % 3;
                                    break;
                                case 4:
                                    i2 = ((i6 / 2) + (i9 / 3)) & 1;
                                    break;
                                case 5:
                                    i2 = i6 * i9;
                                    i2 = (i2 % 3) + (i2 & 1);
                                    break;
                                case 6:
                                    i2 = i6 * i9;
                                    i2 = ((i2 % 3) + (i2 & 1)) & 1;
                                    break;
                                case 7:
                                    i2 = (((i6 * i9) % 3) + ((i6 + i9) & 1)) & 1;
                                    break;
                                default:
                                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Invalid mask pattern: ".concat(String.valueOf(i)));
                                    AppMethodBeat.m2505o(57184);
                                    throw illegalArgumentException;
                            }
                            if (i2 == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                z = !z;
                            }
                        }
                        c8738b.set(i9, i6, z);
                    }
                    i8++;
                    i5 = i5;
                }
                i6 += i4;
            }
            i8 = -i4;
            i3 = i6 + i8;
            i2 = i7 - 2;
            i4 = i8;
        }
        if (i5 != c8727a.size) {
            C37300h c37300h = new C37300h("Not all bits consumed: " + i5 + IOUtils.DIR_SEPARATOR_UNIX + c8727a.size);
            AppMethodBeat.m2505o(57184);
            throw c37300h;
        }
        AppMethodBeat.m2505o(57184);
    }
}
