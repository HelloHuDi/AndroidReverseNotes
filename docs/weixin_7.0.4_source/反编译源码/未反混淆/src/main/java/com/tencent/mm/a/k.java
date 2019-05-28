package com.tencent.mm.a;

import com.tencent.wxmm.v2encoder;

public final class k {
    private static void a(j jVar, j jVar2, j jVar3, j jVar4, j jVar5, j jVar6) {
        jVar3.ccb = 0;
        jVar3.cca = jVar2.cca;
        jVar4.ccb = 28;
        jVar4.cca = jVar2.cca;
        jVar5.ccb = 0;
        jVar5.cca = jVar.cca;
        jVar6.ccb = 32;
        jVar6.cca = jVar.cca;
    }

    private static void a(j jVar, j jVar2, j jVar3) {
        for (int i = 0; i < 8; i++) {
            jVar.cca[jVar.ccb + i] = (byte) (jVar2.cca[jVar2.ccb + i] ^ jVar3.cca[jVar3.ccb + i]);
        }
    }

    private static void a(j jVar, j jVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = jVar.cca;
            int i3 = jVar.ccb + i2;
            bArr[i3] = (byte) (bArr[i3] ^ jVar2.cca[jVar2.ccb + i2]);
        }
    }

    private static void b(j jVar, j jVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            jVar.cca[jVar.ccb + i2] = (byte) ((jVar2.cca[(i2 >> 3) + jVar2.ccb] >> (i2 & 7)) & 1);
        }
    }

    private static void c(j jVar, j jVar2, int i) {
        int i2 = 0;
        d(jVar2, jVar, i);
        for (int i3 = 0; i3 < 28 - i; i3++) {
            jVar.cca[jVar.ccb + i3] = jVar.cca[(jVar.ccb + i3) + i];
        }
        while (i2 < i) {
            jVar.cca[((jVar.ccb + i2) + 28) - i] = jVar2.cca[jVar2.ccb + i2];
            i2++;
        }
    }

    private static void a(j jVar, j jVar2, byte[] bArr, int i, j jVar3) {
        for (int i2 = 0; i2 < i; i2++) {
            jVar3.cca[jVar3.ccb + i2] = jVar2.cca[(jVar2.ccb + bArr[i2]) - 1];
        }
        d(jVar, jVar3, i);
    }

    private static void a(j[] jVarArr, j jVar, byte[] bArr, int i, j jVar2, j jVar3, j jVar4, j jVar5) {
        a(jVar, 24);
        j jVar6 = new j(bArr);
        if (i > 24) {
            i = 24;
        }
        d(jVar, jVar6, i);
        byte[] bArr2 = new byte[]{(byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 28, (byte) 20, (byte) 12, (byte) 4};
        byte[] bArr3 = new byte[]{(byte) 14, (byte) 17, (byte) 11, (byte) 24, (byte) 1, (byte) 5, (byte) 3, (byte) 28, (byte) 15, (byte) 6, (byte) 21, (byte) 10, (byte) 23, (byte) 19, (byte) 12, (byte) 4, (byte) 26, (byte) 8, v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 27, (byte) 20, (byte) 13, (byte) 2, (byte) 41, (byte) 52, (byte) 31, (byte) 37, (byte) 47, (byte) 55, (byte) 30, (byte) 40, (byte) 51, (byte) 45, (byte) 33, (byte) 48, (byte) 44, (byte) 49, (byte) 39, (byte) 56, (byte) 34, (byte) 53, (byte) 46, (byte) 42, (byte) 50, (byte) 36, (byte) 29, (byte) 32};
        byte[] bArr4 = new byte[]{(byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1};
        b(jVar2, jVar, 64);
        a(jVar2, jVar2, bArr2, 56, jVar5);
        for (int i2 = 0; i2 < 16; i2++) {
            c(jVar3, jVar5, bArr4[i2]);
            c(jVar4, jVar5, bArr4[i2]);
            a(jVarArr[i2], jVar2, bArr3, 48, jVar5);
        }
    }

    private static void a(j jVar, j jVar2, j jVar3, j jVar4) {
        int i = 0;
        byte[] bArr = new byte[]{v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 20, (byte) 21, (byte) 29, (byte) 12, (byte) 28, (byte) 17, (byte) 1, (byte) 15, (byte) 23, (byte) 26, (byte) 5, (byte) 18, (byte) 31, (byte) 10, (byte) 2, (byte) 8, (byte) 24, (byte) 14, (byte) 32, (byte) 27, (byte) 3, (byte) 9, (byte) 19, (byte) 13, (byte) 30, (byte) 6, (byte) 22, (byte) 11, (byte) 4, (byte) 25};
        a(jVar3, jVar, new byte[]{(byte) 32, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 12, (byte) 13, (byte) 14, (byte) 15, v2encoder.enumCODEC_vcodec2, (byte) 17, v2encoder.enumCODEC_vcodec2, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 1}, 48, jVar4);
        a(jVar3, jVar2, 48);
        r1 = new byte[8][][];
        r1[0] = new byte[][]{new byte[]{(byte) 14, (byte) 4, (byte) 13, (byte) 1, (byte) 2, (byte) 15, (byte) 11, (byte) 8, (byte) 3, (byte) 10, (byte) 6, (byte) 12, (byte) 5, (byte) 9, (byte) 0, (byte) 7}, new byte[]{(byte) 0, (byte) 15, (byte) 7, (byte) 4, (byte) 14, (byte) 2, (byte) 13, (byte) 1, (byte) 10, (byte) 6, (byte) 12, (byte) 11, (byte) 9, (byte) 5, (byte) 3, (byte) 8}, new byte[]{(byte) 4, (byte) 1, (byte) 14, (byte) 8, (byte) 13, (byte) 6, (byte) 2, (byte) 11, (byte) 15, (byte) 12, (byte) 9, (byte) 7, (byte) 3, (byte) 10, (byte) 5, (byte) 0}, new byte[]{(byte) 15, (byte) 12, (byte) 8, (byte) 2, (byte) 4, (byte) 9, (byte) 1, (byte) 7, (byte) 5, (byte) 11, (byte) 3, (byte) 14, (byte) 10, (byte) 0, (byte) 6, (byte) 13}};
        r1[1] = new byte[][]{new byte[]{(byte) 15, (byte) 1, (byte) 8, (byte) 14, (byte) 6, (byte) 11, (byte) 3, (byte) 4, (byte) 9, (byte) 7, (byte) 2, (byte) 13, (byte) 12, (byte) 0, (byte) 5, (byte) 10}, new byte[]{(byte) 3, (byte) 13, (byte) 4, (byte) 7, (byte) 15, (byte) 2, (byte) 8, (byte) 14, (byte) 12, (byte) 0, (byte) 1, (byte) 10, (byte) 6, (byte) 9, (byte) 11, (byte) 5}, new byte[]{(byte) 0, (byte) 14, (byte) 7, (byte) 11, (byte) 10, (byte) 4, (byte) 13, (byte) 1, (byte) 5, (byte) 8, (byte) 12, (byte) 6, (byte) 9, (byte) 3, (byte) 2, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 10, (byte) 1, (byte) 3, (byte) 15, (byte) 4, (byte) 2, (byte) 11, (byte) 6, (byte) 7, (byte) 12, (byte) 0, (byte) 5, (byte) 14, (byte) 9}};
        r1[2] = new byte[][]{new byte[]{(byte) 10, (byte) 0, (byte) 9, (byte) 14, (byte) 6, (byte) 3, (byte) 15, (byte) 5, (byte) 1, (byte) 13, (byte) 12, (byte) 7, (byte) 11, (byte) 4, (byte) 2, (byte) 8}, new byte[]{(byte) 13, (byte) 7, (byte) 0, (byte) 9, (byte) 3, (byte) 4, (byte) 6, (byte) 10, (byte) 2, (byte) 8, (byte) 5, (byte) 14, (byte) 12, (byte) 11, (byte) 15, (byte) 1}, new byte[]{(byte) 13, (byte) 6, (byte) 4, (byte) 9, (byte) 8, (byte) 15, (byte) 3, (byte) 0, (byte) 11, (byte) 1, (byte) 2, (byte) 12, (byte) 5, (byte) 10, (byte) 14, (byte) 7}, new byte[]{(byte) 1, (byte) 10, (byte) 13, (byte) 0, (byte) 6, (byte) 9, (byte) 8, (byte) 7, (byte) 4, (byte) 15, (byte) 14, (byte) 3, (byte) 11, (byte) 5, (byte) 2, (byte) 12}};
        r1[3] = new byte[][]{new byte[]{(byte) 7, (byte) 13, (byte) 14, (byte) 3, (byte) 0, (byte) 6, (byte) 9, (byte) 10, (byte) 1, (byte) 2, (byte) 8, (byte) 5, (byte) 11, (byte) 12, (byte) 4, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 11, (byte) 5, (byte) 6, (byte) 15, (byte) 0, (byte) 3, (byte) 4, (byte) 7, (byte) 2, (byte) 12, (byte) 1, (byte) 10, (byte) 14, (byte) 9}, new byte[]{(byte) 10, (byte) 6, (byte) 9, (byte) 0, (byte) 12, (byte) 11, (byte) 7, (byte) 13, (byte) 15, (byte) 1, (byte) 3, (byte) 14, (byte) 5, (byte) 2, (byte) 8, (byte) 4}, new byte[]{(byte) 3, (byte) 15, (byte) 0, (byte) 6, (byte) 10, (byte) 1, (byte) 13, (byte) 8, (byte) 9, (byte) 4, (byte) 5, (byte) 11, (byte) 12, (byte) 7, (byte) 2, (byte) 14}};
        r1[4] = new byte[][]{new byte[]{(byte) 2, (byte) 12, (byte) 4, (byte) 1, (byte) 7, (byte) 10, (byte) 11, (byte) 6, (byte) 8, (byte) 5, (byte) 3, (byte) 15, (byte) 13, (byte) 0, (byte) 14, (byte) 9}, new byte[]{(byte) 14, (byte) 11, (byte) 2, (byte) 12, (byte) 4, (byte) 7, (byte) 13, (byte) 1, (byte) 5, (byte) 0, (byte) 15, (byte) 10, (byte) 3, (byte) 9, (byte) 8, (byte) 6}, new byte[]{(byte) 4, (byte) 2, (byte) 1, (byte) 11, (byte) 10, (byte) 13, (byte) 7, (byte) 8, (byte) 15, (byte) 9, (byte) 12, (byte) 5, (byte) 6, (byte) 3, (byte) 0, (byte) 14}, new byte[]{(byte) 11, (byte) 8, (byte) 12, (byte) 7, (byte) 1, (byte) 14, (byte) 2, (byte) 13, (byte) 6, (byte) 15, (byte) 0, (byte) 9, (byte) 10, (byte) 4, (byte) 5, (byte) 3}};
        r1[5] = new byte[][]{new byte[]{(byte) 12, (byte) 1, (byte) 10, (byte) 15, (byte) 9, (byte) 2, (byte) 6, (byte) 8, (byte) 0, (byte) 13, (byte) 3, (byte) 4, (byte) 14, (byte) 7, (byte) 5, (byte) 11}, new byte[]{(byte) 10, (byte) 15, (byte) 4, (byte) 2, (byte) 7, (byte) 12, (byte) 9, (byte) 5, (byte) 6, (byte) 1, (byte) 13, (byte) 14, (byte) 0, (byte) 11, (byte) 3, (byte) 8}, new byte[]{(byte) 9, (byte) 14, (byte) 15, (byte) 5, (byte) 2, (byte) 8, (byte) 12, (byte) 3, (byte) 7, (byte) 0, (byte) 4, (byte) 10, (byte) 1, (byte) 13, (byte) 11, (byte) 6}, new byte[]{(byte) 4, (byte) 3, (byte) 2, (byte) 12, (byte) 9, (byte) 5, (byte) 15, (byte) 10, (byte) 11, (byte) 14, (byte) 1, (byte) 7, (byte) 6, (byte) 0, (byte) 8, (byte) 13}};
        r1[6] = new byte[][]{new byte[]{(byte) 4, (byte) 11, (byte) 2, (byte) 14, (byte) 15, (byte) 0, (byte) 8, (byte) 13, (byte) 3, (byte) 12, (byte) 9, (byte) 7, (byte) 5, (byte) 10, (byte) 6, (byte) 1}, new byte[]{(byte) 13, (byte) 0, (byte) 11, (byte) 7, (byte) 4, (byte) 9, (byte) 1, (byte) 10, (byte) 14, (byte) 3, (byte) 5, (byte) 12, (byte) 2, (byte) 15, (byte) 8, (byte) 6}, new byte[]{(byte) 1, (byte) 4, (byte) 11, (byte) 13, (byte) 12, (byte) 3, (byte) 7, (byte) 14, (byte) 10, (byte) 15, (byte) 6, (byte) 8, (byte) 0, (byte) 5, (byte) 9, (byte) 2}, new byte[]{(byte) 6, (byte) 11, (byte) 13, (byte) 8, (byte) 1, (byte) 4, (byte) 10, (byte) 7, (byte) 9, (byte) 5, (byte) 0, (byte) 15, (byte) 14, (byte) 2, (byte) 3, (byte) 12}};
        r1[7] = new byte[][]{new byte[]{(byte) 13, (byte) 2, (byte) 8, (byte) 4, (byte) 6, (byte) 15, (byte) 11, (byte) 1, (byte) 10, (byte) 9, (byte) 3, (byte) 14, (byte) 5, (byte) 0, (byte) 12, (byte) 7}, new byte[]{(byte) 1, (byte) 15, (byte) 13, (byte) 8, (byte) 10, (byte) 3, (byte) 7, (byte) 4, (byte) 12, (byte) 5, (byte) 6, (byte) 11, (byte) 0, (byte) 14, (byte) 9, (byte) 2}, new byte[]{(byte) 7, (byte) 11, (byte) 4, (byte) 1, (byte) 9, (byte) 12, (byte) 14, (byte) 2, (byte) 0, (byte) 6, (byte) 10, (byte) 13, (byte) 15, (byte) 3, (byte) 5, (byte) 8}, new byte[]{(byte) 2, (byte) 1, (byte) 14, (byte) 7, (byte) 4, (byte) 10, (byte) 8, (byte) 13, (byte) 15, (byte) 12, (byte) 9, (byte) 0, (byte) 3, (byte) 5, (byte) 6, (byte) 11}};
        int i2 = jVar3.ccb;
        int i3 = jVar.ccb;
        while (i < 8) {
            byte b = (byte) ((((jVar3.cca[jVar3.ccb + 1] << 3) + (jVar3.cca[jVar3.ccb + 2] << 2)) + (jVar3.cca[jVar3.ccb + 3] << 1)) + jVar3.cca[jVar3.ccb + 4]);
            b(jVar, new j(r1[i][(byte) ((jVar3.cca[jVar3.ccb + 0] << 1) + jVar3.cca[jVar3.ccb + 5])][b]), 4);
            i = (byte) (i + 1);
            jVar3.ccb += 6;
            jVar.ccb += 4;
        }
        jVar3.ccb = i2;
        jVar.ccb = i3;
        a(jVar, jVar, bArr, 32, jVar4);
    }

    private static void a(j jVar, j jVar2, j[] jVarArr, int i, j jVar3, j jVar4, j jVar5, j jVar6, j jVar7, j jVar8) {
        int i2;
        byte[] bArr = new byte[]{(byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28, (byte) 20, (byte) 12, (byte) 4, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 64, (byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, v2encoder.enumCODEC_vcodec2, (byte) 8, (byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7};
        byte[] bArr2 = new byte[]{(byte) 40, (byte) 8, (byte) 48, v2encoder.enumCODEC_vcodec2, (byte) 56, (byte) 24, (byte) 64, (byte) 32, (byte) 39, (byte) 7, (byte) 47, (byte) 15, (byte) 55, (byte) 23, (byte) 63, (byte) 31, (byte) 38, (byte) 6, (byte) 46, (byte) 14, (byte) 54, (byte) 22, (byte) 62, (byte) 30, (byte) 37, (byte) 5, (byte) 45, (byte) 13, (byte) 53, (byte) 21, (byte) 61, (byte) 29, (byte) 36, (byte) 4, (byte) 44, (byte) 12, (byte) 52, (byte) 20, (byte) 60, (byte) 28, (byte) 35, (byte) 3, (byte) 43, (byte) 11, (byte) 51, (byte) 19, (byte) 59, (byte) 27, (byte) 34, (byte) 2, (byte) 42, (byte) 10, (byte) 50, (byte) 18, (byte) 58, (byte) 26, (byte) 33, (byte) 1, (byte) 41, (byte) 9, (byte) 49, (byte) 17, (byte) 57, (byte) 25};
        b(jVar3, jVar2, 64);
        a(jVar3, jVar3, bArr, 64, jVar8);
        if (i == 0) {
            for (i2 = 0; i2 < 16; i2++) {
                d(jVar5, jVar7, 32);
                a(jVar7, jVarArr[i2], jVar4, jVar8);
                a(jVar7, jVar6, 32);
                d(jVar6, jVar5, 32);
            }
        } else {
            for (i2 = 15; i2 >= 0; i2--) {
                d(jVar5, jVar6, 32);
                a(jVar6, jVarArr[i2], jVar4, jVar8);
                a(jVar6, jVar7, 32);
                d(jVar7, jVar5, 32);
            }
        }
        a(jVar3, jVar3, bArr2, 64, jVar8);
        a(jVar, 8);
        for (i2 = 0; i2 < 64; i2++) {
            bArr2 = jVar.cca;
            int i3 = jVar.ccb + (i2 >> 3);
            bArr2[i3] = (byte) (bArr2[i3] | (jVar3.cca[jVar3.ccb + i2] << (i2 & 7)));
        }
    }

    public static char a(byte[] bArr, byte[] bArr2, long j, int i, byte[] bArr3, int i2) {
        j jVar = new j(bArr);
        jVar = new j(bArr2);
        j[] jVarArr = new j[16];
        for (int i3 = 0; i3 < 16; i3++) {
            jVarArr[i3] = new j(new byte[48]);
        }
        jVar = new j(new byte[256]);
        j jVar2 = new j(new byte[24]);
        j jVar3 = new j(new byte[64]);
        j jVar4 = new j();
        j jVar5 = new j();
        j jVar6 = new j();
        j jVar7 = new j();
        j jVar8 = new j(new byte[64]);
        jVar = new j(new byte[48]);
        jVar = new j(new byte[32]);
        jVar = new j(new byte[9]);
        jVar = new j(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j2 = (7 + j) & -8;
            if (j2 != 0) {
                a(jVar8, jVar3, jVar4, jVar5, jVar6, jVar7);
                a(jVarArr, jVar2, bArr3, i, jVar3, jVar4, jVar5, jVar);
                int i4 = jVar.ccb;
                int i5 = jVar.ccb;
                long j3;
                long j4;
                if (i2 == 0) {
                    a(jVar, jVar, jVarArr, i2, jVar8, jVar, jVar, jVar6, jVar7, jVar);
                    d(jVar, jVar, 8);
                    jVar.ccb += 8;
                    j3 = 0;
                    j4 = j2 >> 3;
                    while (j3 < j4) {
                        a(jVar, jVar, jVar);
                        a(jVar, jVar, jVarArr, i2, jVar8, jVar, jVar, jVar6, jVar7, jVar);
                        d(jVar, jVar, 8);
                        j3++;
                        jVar.ccb += 8;
                        jVar.ccb += 8;
                    }
                } else {
                    d(jVar, jVar, 8);
                    jVar.ccb += 8;
                    j3 = 1;
                    j4 = j2 >> 3;
                    while (j3 < j4) {
                        a(jVar, jVar, jVarArr, i2, jVar8, jVar, jVar, jVar6, jVar7, jVar);
                        a(jVar, jVar, jVar);
                        d(jVar, jVar, 8);
                        j3++;
                        jVar.ccb += 8;
                        jVar.ccb += 8;
                    }
                }
                jVar.ccb = i4;
                jVar.ccb = i5;
                return 1;
            }
        }
        return 0;
    }

    private static void d(j jVar, j jVar2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            jVar.cca[jVar.ccb + i2] = jVar2.cca[jVar2.ccb + i2];
        }
    }

    private static void a(j jVar, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            jVar.cca[jVar.ccb + i2] = (byte) 0;
        }
    }
}
