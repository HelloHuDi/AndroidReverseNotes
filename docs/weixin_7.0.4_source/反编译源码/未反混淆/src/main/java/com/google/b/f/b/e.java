package com.google.b.f.b;

import com.google.b.b.a;
import com.google.b.f.a.c;
import com.google.b.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.g.d;
import com.tencent.mm.plugin.appbrand.jsapi.g.n;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.ttpic.baseutils.IOUtils;

final class e {
    private static final int[][] bBM = new int[][]{new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] bBN = new int[][]{new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] bBO = new int[][]{new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, d.CTRL_INDEX, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, JsApiMakeVoIPCall.CTRL_INDEX}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, n.CTRL_INDEX, ErrorCode.STARTDOWNLOAD_3}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, ErrorCode.NEEDDOWNLOAD_3, ErrorCode.NEEDDOWNLOAD_TRUE}};
    private static final int[][] bBP = new int[][]{new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    private static int bI(int i, int i2) {
        AppMethodBeat.i(57185);
        if (i2 == 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("0 polynomial");
            AppMethodBeat.o(57185);
            throw illegalArgumentException;
        }
        int numberOfLeadingZeros = 32 - Integer.numberOfLeadingZeros(i2);
        int i3 = i << (numberOfLeadingZeros - 1);
        while (32 - Integer.numberOfLeadingZeros(i3) >= numberOfLeadingZeros) {
            i3 ^= i2 << ((32 - Integer.numberOfLeadingZeros(i3)) - numberOfLeadingZeros);
        }
        AppMethodBeat.o(57185);
        return i3;
    }

    private static boolean fJ(int i) {
        return i == -1;
    }

    private static void a(int i, int i2, b bVar) {
        AppMethodBeat.i(57186);
        int i3 = 0;
        while (i3 < 8) {
            if (fJ(bVar.bH(i + i3, i2))) {
                bVar.set(i + i3, i2, 0);
                i3++;
            } else {
                h hVar = new h();
                AppMethodBeat.o(57186);
                throw hVar;
            }
        }
        AppMethodBeat.o(57186);
    }

    private static void b(int i, int i2, b bVar) {
        AppMethodBeat.i(57187);
        int i3 = 0;
        while (i3 < 7) {
            if (fJ(bVar.bH(i, i2 + i3))) {
                bVar.set(i, i2 + i3, 0);
                i3++;
            } else {
                h hVar = new h();
                AppMethodBeat.o(57187);
                throw hVar;
            }
        }
        AppMethodBeat.o(57187);
    }

    private static void c(int i, int i2, b bVar) {
        AppMethodBeat.i(57188);
        for (int i3 = 0; i3 < 7; i3++) {
            for (int i4 = 0; i4 < 7; i4++) {
                bVar.set(i + i4, i2 + i3, bBM[i3][i4]);
            }
        }
        AppMethodBeat.o(57188);
    }

    static void a(a aVar, com.google.b.f.a.a aVar2, c cVar, int i, b bVar) {
        int i2;
        int i3;
        AppMethodBeat.i(57182);
        for (i2 = 0; i2 < bVar.height; i2++) {
            for (i3 = 0; i3 < bVar.width; i3++) {
                bVar.bBJ[i2][i3] = (byte) -1;
            }
        }
        i2 = bBM[0].length;
        c(0, 0, bVar);
        c(bVar.width - i2, 0, bVar);
        c(0, bVar.width - i2, bVar);
        a(0, 7, bVar);
        a(bVar.width - 8, 7, bVar);
        a(0, bVar.width - 8, bVar);
        b(7, 0, bVar);
        b((bVar.height - 7) - 1, 0, bVar);
        b(7, bVar.height - 7, bVar);
        h hVar;
        if (bVar.bH(8, bVar.height - 8) == (byte) 0) {
            hVar = new h();
            AppMethodBeat.o(57182);
            throw hVar;
        }
        Object obj;
        bVar.set(8, bVar.height - 8, 1);
        if (cVar.bBA >= 2) {
            i2 = cVar.bBA - 1;
            int[] iArr = bBO[i2];
            int length = bBO[i2].length;
            for (i2 = 0; i2 < length; i2++) {
                for (i3 = 0; i3 < length; i3++) {
                    int i4 = iArr[i2];
                    int i5 = iArr[i3];
                    if (i5 != -1 && i4 != -1 && fJ(bVar.bH(i5, i4))) {
                        int i6 = i5 - 2;
                        int i7 = i4 - 2;
                        i4 = 0;
                        while (true) {
                            i5 = i4;
                            if (i5 >= 5) {
                                break;
                            }
                            for (i4 = 0; i4 < 5; i4++) {
                                bVar.set(i6 + i4, i7 + i5, bBN[i5][i4]);
                            }
                            i4 = i5 + 1;
                        }
                    }
                }
            }
        }
        for (i2 = 8; i2 < bVar.width - 8; i2++) {
            i3 = (i2 + 1) % 2;
            if (fJ(bVar.bH(i2, 6))) {
                bVar.set(i2, 6, i3);
            }
            if (fJ(bVar.bH(6, i2))) {
                bVar.set(6, i2, i3);
            }
        }
        a aVar3 = new a();
        if (i < 0 || i >= 8) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            hVar = new h("Invalid mask pattern");
            AppMethodBeat.o(57182);
            throw hVar;
        }
        i2 = (aVar2.bBk << 3) | i;
        aVar3.bA(i2, 5);
        aVar3.bA(bI(i2, 1335), 10);
        a aVar4 = new a();
        aVar4.bA(21522, 15);
        if (aVar3.size != aVar4.size) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Sizes don't match");
            AppMethodBeat.o(57182);
            throw illegalArgumentException;
        }
        for (i2 = 0; i2 < aVar3.byE.length; i2++) {
            int[] iArr2 = aVar3.byE;
            iArr2[i2] = iArr2[i2] ^ aVar4.byE[i2];
        }
        if (aVar3.size != 15) {
            hVar = new h("should not happen but we got: " + aVar3.size);
            AppMethodBeat.o(57182);
            throw hVar;
        }
        for (i2 = 0; i2 < aVar3.size; i2++) {
            boolean z = aVar3.get((aVar3.size - 1) - i2);
            bVar.set(bBP[i2][0], bBP[i2][1], z);
            if (i2 < 8) {
                bVar.set((bVar.width - i2) - 1, 8, z);
            } else {
                bVar.set(8, (bVar.height - 7) + (i2 - 8), z);
            }
        }
        a(cVar, bVar);
        a(aVar, i, bVar);
        AppMethodBeat.o(57182);
    }

    private static void a(c cVar, b bVar) {
        AppMethodBeat.i(57183);
        if (cVar.bBA < 7) {
            AppMethodBeat.o(57183);
            return;
        }
        a aVar = new a();
        aVar.bA(cVar.bBA, 6);
        aVar.bA(bI(cVar.bBA, 7973), 12);
        if (aVar.size != 18) {
            h hVar = new h("should not happen but we got: " + aVar.size);
            AppMethodBeat.o(57183);
            throw hVar;
        }
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean z = aVar.get(i);
                i--;
                bVar.set(i2, (bVar.height - 11) + i3, z);
                bVar.set((bVar.height - 11) + i3, i2, z);
            }
        }
        AppMethodBeat.o(57183);
    }

    private static void a(a aVar, int i, b bVar) {
        AppMethodBeat.i(57184);
        int i2 = bVar.width - 1;
        int i3 = bVar.height - 1;
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
            while (i6 >= 0 && i6 < bVar.height) {
                i8 = 0;
                while (i8 < 2) {
                    int i9 = i7 - i8;
                    if (fJ(bVar.bH(i9, i6))) {
                        boolean z;
                        if (i5 < aVar.size) {
                            z = aVar.get(i5);
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
                                    AppMethodBeat.o(57184);
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
                        bVar.set(i9, i6, z);
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
        if (i5 != aVar.size) {
            h hVar = new h("Not all bits consumed: " + i5 + IOUtils.DIR_SEPARATOR_UNIX + aVar.size);
            AppMethodBeat.o(57184);
            throw hVar;
        }
        AppMethodBeat.o(57184);
    }
}
