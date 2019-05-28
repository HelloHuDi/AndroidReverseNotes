package com.tencent.p177mm.p178a;

import com.tencent.wxmm.v2encoder;

/* renamed from: com.tencent.mm.a.k */
public final class C1181k {
    /* renamed from: a */
    private static void m2600a(C1180j c1180j, C1180j c1180j2, C1180j c1180j3, C1180j c1180j4, C1180j c1180j5, C1180j c1180j6) {
        c1180j3.ccb = 0;
        c1180j3.cca = c1180j2.cca;
        c1180j4.ccb = 28;
        c1180j4.cca = c1180j2.cca;
        c1180j5.ccb = 0;
        c1180j5.cca = c1180j.cca;
        c1180j6.ccb = 32;
        c1180j6.cca = c1180j.cca;
    }

    /* renamed from: a */
    private static void m2598a(C1180j c1180j, C1180j c1180j2, C1180j c1180j3) {
        for (int i = 0; i < 8; i++) {
            c1180j.cca[c1180j.ccb + i] = (byte) (c1180j2.cca[c1180j2.ccb + i] ^ c1180j3.cca[c1180j3.ccb + i]);
        }
    }

    /* renamed from: a */
    private static void m2597a(C1180j c1180j, C1180j c1180j2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = c1180j.cca;
            int i3 = c1180j.ccb + i2;
            bArr[i3] = (byte) (bArr[i3] ^ c1180j2.cca[c1180j2.ccb + i2]);
        }
    }

    /* renamed from: b */
    private static void m2604b(C1180j c1180j, C1180j c1180j2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c1180j.cca[c1180j.ccb + i2] = (byte) ((c1180j2.cca[(i2 >> 3) + c1180j2.ccb] >> (i2 & 7)) & 1);
        }
    }

    /* renamed from: c */
    private static void m2605c(C1180j c1180j, C1180j c1180j2, int i) {
        int i2 = 0;
        C1181k.m2606d(c1180j2, c1180j, i);
        for (int i3 = 0; i3 < 28 - i; i3++) {
            c1180j.cca[c1180j.ccb + i3] = c1180j.cca[(c1180j.ccb + i3) + i];
        }
        while (i2 < i) {
            c1180j.cca[((c1180j.ccb + i2) + 28) - i] = c1180j2.cca[c1180j2.ccb + i2];
            i2++;
        }
    }

    /* renamed from: a */
    private static void m2601a(C1180j c1180j, C1180j c1180j2, byte[] bArr, int i, C1180j c1180j3) {
        for (int i2 = 0; i2 < i; i2++) {
            c1180j3.cca[c1180j3.ccb + i2] = c1180j2.cca[(c1180j2.ccb + bArr[i2]) - 1];
        }
        C1181k.m2606d(c1180j, c1180j3, i);
    }

    /* renamed from: a */
    private static void m2603a(C1180j[] c1180jArr, C1180j c1180j, byte[] bArr, int i, C1180j c1180j2, C1180j c1180j3, C1180j c1180j4, C1180j c1180j5) {
        C1181k.m2596a(c1180j, 24);
        C1180j c1180j6 = new C1180j(bArr);
        if (i > 24) {
            i = 24;
        }
        C1181k.m2606d(c1180j, c1180j6, i);
        byte[] bArr2 = new byte[]{(byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 28, (byte) 20, (byte) 12, (byte) 4};
        byte[] bArr3 = new byte[]{(byte) 14, (byte) 17, (byte) 11, (byte) 24, (byte) 1, (byte) 5, (byte) 3, (byte) 28, (byte) 15, (byte) 6, (byte) 21, (byte) 10, (byte) 23, (byte) 19, (byte) 12, (byte) 4, (byte) 26, (byte) 8, v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 27, (byte) 20, (byte) 13, (byte) 2, (byte) 41, (byte) 52, (byte) 31, (byte) 37, (byte) 47, (byte) 55, (byte) 30, (byte) 40, (byte) 51, (byte) 45, (byte) 33, (byte) 48, (byte) 44, (byte) 49, (byte) 39, (byte) 56, (byte) 34, (byte) 53, (byte) 46, (byte) 42, (byte) 50, (byte) 36, (byte) 29, (byte) 32};
        byte[] bArr4 = new byte[]{(byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1};
        C1181k.m2604b(c1180j2, c1180j, 64);
        C1181k.m2601a(c1180j2, c1180j2, bArr2, 56, c1180j5);
        for (int i2 = 0; i2 < 16; i2++) {
            C1181k.m2605c(c1180j3, c1180j5, bArr4[i2]);
            C1181k.m2605c(c1180j4, c1180j5, bArr4[i2]);
            C1181k.m2601a(c1180jArr[i2], c1180j2, bArr3, 48, c1180j5);
        }
    }

    /* renamed from: a */
    private static void m2599a(C1180j c1180j, C1180j c1180j2, C1180j c1180j3, C1180j c1180j4) {
        int i = 0;
        byte[] bArr = new byte[]{v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 20, (byte) 21, (byte) 29, (byte) 12, (byte) 28, (byte) 17, (byte) 1, (byte) 15, (byte) 23, (byte) 26, (byte) 5, (byte) 18, (byte) 31, (byte) 10, (byte) 2, (byte) 8, (byte) 24, (byte) 14, (byte) 32, (byte) 27, (byte) 3, (byte) 9, (byte) 19, (byte) 13, (byte) 30, (byte) 6, (byte) 22, (byte) 11, (byte) 4, (byte) 25};
        C1181k.m2601a(c1180j3, c1180j, new byte[]{(byte) 32, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 12, (byte) 13, (byte) 14, (byte) 15, v2encoder.enumCODEC_vcodec2, (byte) 17, v2encoder.enumCODEC_vcodec2, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 1}, 48, c1180j4);
        C1181k.m2597a(c1180j3, c1180j2, 48);
        r1 = new byte[8][][];
        r1[0] = new byte[][]{new byte[]{(byte) 14, (byte) 4, (byte) 13, (byte) 1, (byte) 2, (byte) 15, (byte) 11, (byte) 8, (byte) 3, (byte) 10, (byte) 6, (byte) 12, (byte) 5, (byte) 9, (byte) 0, (byte) 7}, new byte[]{(byte) 0, (byte) 15, (byte) 7, (byte) 4, (byte) 14, (byte) 2, (byte) 13, (byte) 1, (byte) 10, (byte) 6, (byte) 12, (byte) 11, (byte) 9, (byte) 5, (byte) 3, (byte) 8}, new byte[]{(byte) 4, (byte) 1, (byte) 14, (byte) 8, (byte) 13, (byte) 6, (byte) 2, (byte) 11, (byte) 15, (byte) 12, (byte) 9, (byte) 7, (byte) 3, (byte) 10, (byte) 5, (byte) 0}, new byte[]{(byte) 15, (byte) 12, (byte) 8, (byte) 2, (byte) 4, (byte) 9, (byte) 1, (byte) 7, (byte) 5, (byte) 11, (byte) 3, (byte) 14, (byte) 10, (byte) 0, (byte) 6, (byte) 13}};
        r1[1] = new byte[][]{new byte[]{(byte) 15, (byte) 1, (byte) 8, (byte) 14, (byte) 6, (byte) 11, (byte) 3, (byte) 4, (byte) 9, (byte) 7, (byte) 2, (byte) 13, (byte) 12, (byte) 0, (byte) 5, (byte) 10}, new byte[]{(byte) 3, (byte) 13, (byte) 4, (byte) 7, (byte) 15, (byte) 2, (byte) 8, (byte) 14, (byte) 12, (byte) 0, (byte) 1, (byte) 10, (byte) 6, (byte) 9, (byte) 11, (byte) 5}, new byte[]{(byte) 0, (byte) 14, (byte) 7, (byte) 11, (byte) 10, (byte) 4, (byte) 13, (byte) 1, (byte) 5, (byte) 8, (byte) 12, (byte) 6, (byte) 9, (byte) 3, (byte) 2, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 10, (byte) 1, (byte) 3, (byte) 15, (byte) 4, (byte) 2, (byte) 11, (byte) 6, (byte) 7, (byte) 12, (byte) 0, (byte) 5, (byte) 14, (byte) 9}};
        r1[2] = new byte[][]{new byte[]{(byte) 10, (byte) 0, (byte) 9, (byte) 14, (byte) 6, (byte) 3, (byte) 15, (byte) 5, (byte) 1, (byte) 13, (byte) 12, (byte) 7, (byte) 11, (byte) 4, (byte) 2, (byte) 8}, new byte[]{(byte) 13, (byte) 7, (byte) 0, (byte) 9, (byte) 3, (byte) 4, (byte) 6, (byte) 10, (byte) 2, (byte) 8, (byte) 5, (byte) 14, (byte) 12, (byte) 11, (byte) 15, (byte) 1}, new byte[]{(byte) 13, (byte) 6, (byte) 4, (byte) 9, (byte) 8, (byte) 15, (byte) 3, (byte) 0, (byte) 11, (byte) 1, (byte) 2, (byte) 12, (byte) 5, (byte) 10, (byte) 14, (byte) 7}, new byte[]{(byte) 1, (byte) 10, (byte) 13, (byte) 0, (byte) 6, (byte) 9, (byte) 8, (byte) 7, (byte) 4, (byte) 15, (byte) 14, (byte) 3, (byte) 11, (byte) 5, (byte) 2, (byte) 12}};
        r1[3] = new byte[][]{new byte[]{(byte) 7, (byte) 13, (byte) 14, (byte) 3, (byte) 0, (byte) 6, (byte) 9, (byte) 10, (byte) 1, (byte) 2, (byte) 8, (byte) 5, (byte) 11, (byte) 12, (byte) 4, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 11, (byte) 5, (byte) 6, (byte) 15, (byte) 0, (byte) 3, (byte) 4, (byte) 7, (byte) 2, (byte) 12, (byte) 1, (byte) 10, (byte) 14, (byte) 9}, new byte[]{(byte) 10, (byte) 6, (byte) 9, (byte) 0, (byte) 12, (byte) 11, (byte) 7, (byte) 13, (byte) 15, (byte) 1, (byte) 3, (byte) 14, (byte) 5, (byte) 2, (byte) 8, (byte) 4}, new byte[]{(byte) 3, (byte) 15, (byte) 0, (byte) 6, (byte) 10, (byte) 1, (byte) 13, (byte) 8, (byte) 9, (byte) 4, (byte) 5, (byte) 11, (byte) 12, (byte) 7, (byte) 2, (byte) 14}};
        r1[4] = new byte[][]{new byte[]{(byte) 2, (byte) 12, (byte) 4, (byte) 1, (byte) 7, (byte) 10, (byte) 11, (byte) 6, (byte) 8, (byte) 5, (byte) 3, (byte) 15, (byte) 13, (byte) 0, (byte) 14, (byte) 9}, new byte[]{(byte) 14, (byte) 11, (byte) 2, (byte) 12, (byte) 4, (byte) 7, (byte) 13, (byte) 1, (byte) 5, (byte) 0, (byte) 15, (byte) 10, (byte) 3, (byte) 9, (byte) 8, (byte) 6}, new byte[]{(byte) 4, (byte) 2, (byte) 1, (byte) 11, (byte) 10, (byte) 13, (byte) 7, (byte) 8, (byte) 15, (byte) 9, (byte) 12, (byte) 5, (byte) 6, (byte) 3, (byte) 0, (byte) 14}, new byte[]{(byte) 11, (byte) 8, (byte) 12, (byte) 7, (byte) 1, (byte) 14, (byte) 2, (byte) 13, (byte) 6, (byte) 15, (byte) 0, (byte) 9, (byte) 10, (byte) 4, (byte) 5, (byte) 3}};
        r1[5] = new byte[][]{new byte[]{(byte) 12, (byte) 1, (byte) 10, (byte) 15, (byte) 9, (byte) 2, (byte) 6, (byte) 8, (byte) 0, (byte) 13, (byte) 3, (byte) 4, (byte) 14, (byte) 7, (byte) 5, (byte) 11}, new byte[]{(byte) 10, (byte) 15, (byte) 4, (byte) 2, (byte) 7, (byte) 12, (byte) 9, (byte) 5, (byte) 6, (byte) 1, (byte) 13, (byte) 14, (byte) 0, (byte) 11, (byte) 3, (byte) 8}, new byte[]{(byte) 9, (byte) 14, (byte) 15, (byte) 5, (byte) 2, (byte) 8, (byte) 12, (byte) 3, (byte) 7, (byte) 0, (byte) 4, (byte) 10, (byte) 1, (byte) 13, (byte) 11, (byte) 6}, new byte[]{(byte) 4, (byte) 3, (byte) 2, (byte) 12, (byte) 9, (byte) 5, (byte) 15, (byte) 10, (byte) 11, (byte) 14, (byte) 1, (byte) 7, (byte) 6, (byte) 0, (byte) 8, (byte) 13}};
        r1[6] = new byte[][]{new byte[]{(byte) 4, (byte) 11, (byte) 2, (byte) 14, (byte) 15, (byte) 0, (byte) 8, (byte) 13, (byte) 3, (byte) 12, (byte) 9, (byte) 7, (byte) 5, (byte) 10, (byte) 6, (byte) 1}, new byte[]{(byte) 13, (byte) 0, (byte) 11, (byte) 7, (byte) 4, (byte) 9, (byte) 1, (byte) 10, (byte) 14, (byte) 3, (byte) 5, (byte) 12, (byte) 2, (byte) 15, (byte) 8, (byte) 6}, new byte[]{(byte) 1, (byte) 4, (byte) 11, (byte) 13, (byte) 12, (byte) 3, (byte) 7, (byte) 14, (byte) 10, (byte) 15, (byte) 6, (byte) 8, (byte) 0, (byte) 5, (byte) 9, (byte) 2}, new byte[]{(byte) 6, (byte) 11, (byte) 13, (byte) 8, (byte) 1, (byte) 4, (byte) 10, (byte) 7, (byte) 9, (byte) 5, (byte) 0, (byte) 15, (byte) 14, (byte) 2, (byte) 3, (byte) 12}};
        r1[7] = new byte[][]{new byte[]{(byte) 13, (byte) 2, (byte) 8, (byte) 4, (byte) 6, (byte) 15, (byte) 11, (byte) 1, (byte) 10, (byte) 9, (byte) 3, (byte) 14, (byte) 5, (byte) 0, (byte) 12, (byte) 7}, new byte[]{(byte) 1, (byte) 15, (byte) 13, (byte) 8, (byte) 10, (byte) 3, (byte) 7, (byte) 4, (byte) 12, (byte) 5, (byte) 6, (byte) 11, (byte) 0, (byte) 14, (byte) 9, (byte) 2}, new byte[]{(byte) 7, (byte) 11, (byte) 4, (byte) 1, (byte) 9, (byte) 12, (byte) 14, (byte) 2, (byte) 0, (byte) 6, (byte) 10, (byte) 13, (byte) 15, (byte) 3, (byte) 5, (byte) 8}, new byte[]{(byte) 2, (byte) 1, (byte) 14, (byte) 7, (byte) 4, (byte) 10, (byte) 8, (byte) 13, (byte) 15, (byte) 12, (byte) 9, (byte) 0, (byte) 3, (byte) 5, (byte) 6, (byte) 11}};
        int i2 = c1180j3.ccb;
        int i3 = c1180j.ccb;
        while (i < 8) {
            byte b = (byte) ((((c1180j3.cca[c1180j3.ccb + 1] << 3) + (c1180j3.cca[c1180j3.ccb + 2] << 2)) + (c1180j3.cca[c1180j3.ccb + 3] << 1)) + c1180j3.cca[c1180j3.ccb + 4]);
            C1181k.m2604b(c1180j, new C1180j(r1[i][(byte) ((c1180j3.cca[c1180j3.ccb + 0] << 1) + c1180j3.cca[c1180j3.ccb + 5])][b]), 4);
            i = (byte) (i + 1);
            c1180j3.ccb += 6;
            c1180j.ccb += 4;
        }
        c1180j3.ccb = i2;
        c1180j.ccb = i3;
        C1181k.m2601a(c1180j, c1180j, bArr, 32, c1180j4);
    }

    /* renamed from: a */
    private static void m2602a(C1180j c1180j, C1180j c1180j2, C1180j[] c1180jArr, int i, C1180j c1180j3, C1180j c1180j4, C1180j c1180j5, C1180j c1180j6, C1180j c1180j7, C1180j c1180j8) {
        int i2;
        byte[] bArr = new byte[]{(byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28, (byte) 20, (byte) 12, (byte) 4, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 64, (byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, v2encoder.enumCODEC_vcodec2, (byte) 8, (byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7};
        byte[] bArr2 = new byte[]{(byte) 40, (byte) 8, (byte) 48, v2encoder.enumCODEC_vcodec2, (byte) 56, (byte) 24, (byte) 64, (byte) 32, (byte) 39, (byte) 7, (byte) 47, (byte) 15, (byte) 55, (byte) 23, (byte) 63, (byte) 31, (byte) 38, (byte) 6, (byte) 46, (byte) 14, (byte) 54, (byte) 22, (byte) 62, (byte) 30, (byte) 37, (byte) 5, (byte) 45, (byte) 13, (byte) 53, (byte) 21, (byte) 61, (byte) 29, (byte) 36, (byte) 4, (byte) 44, (byte) 12, (byte) 52, (byte) 20, (byte) 60, (byte) 28, (byte) 35, (byte) 3, (byte) 43, (byte) 11, (byte) 51, (byte) 19, (byte) 59, (byte) 27, (byte) 34, (byte) 2, (byte) 42, (byte) 10, (byte) 50, (byte) 18, (byte) 58, (byte) 26, (byte) 33, (byte) 1, (byte) 41, (byte) 9, (byte) 49, (byte) 17, (byte) 57, (byte) 25};
        C1181k.m2604b(c1180j3, c1180j2, 64);
        C1181k.m2601a(c1180j3, c1180j3, bArr, 64, c1180j8);
        if (i == 0) {
            for (i2 = 0; i2 < 16; i2++) {
                C1181k.m2606d(c1180j5, c1180j7, 32);
                C1181k.m2599a(c1180j7, c1180jArr[i2], c1180j4, c1180j8);
                C1181k.m2597a(c1180j7, c1180j6, 32);
                C1181k.m2606d(c1180j6, c1180j5, 32);
            }
        } else {
            for (i2 = 15; i2 >= 0; i2--) {
                C1181k.m2606d(c1180j5, c1180j6, 32);
                C1181k.m2599a(c1180j6, c1180jArr[i2], c1180j4, c1180j8);
                C1181k.m2597a(c1180j6, c1180j7, 32);
                C1181k.m2606d(c1180j7, c1180j5, 32);
            }
        }
        C1181k.m2601a(c1180j3, c1180j3, bArr2, 64, c1180j8);
        C1181k.m2596a(c1180j, 8);
        for (i2 = 0; i2 < 64; i2++) {
            bArr2 = c1180j.cca;
            int i3 = c1180j.ccb + (i2 >> 3);
            bArr2[i3] = (byte) (bArr2[i3] | (c1180j3.cca[c1180j3.ccb + i2] << (i2 & 7)));
        }
    }

    /* renamed from: a */
    public static char m2595a(byte[] bArr, byte[] bArr2, long j, int i, byte[] bArr3, int i2) {
        C1180j c1180j = new C1180j(bArr);
        c1180j = new C1180j(bArr2);
        C1180j[] c1180jArr = new C1180j[16];
        for (int i3 = 0; i3 < 16; i3++) {
            c1180jArr[i3] = new C1180j(new byte[48]);
        }
        c1180j = new C1180j(new byte[256]);
        C1180j c1180j2 = new C1180j(new byte[24]);
        C1180j c1180j3 = new C1180j(new byte[64]);
        C1180j c1180j4 = new C1180j();
        C1180j c1180j5 = new C1180j();
        C1180j c1180j6 = new C1180j();
        C1180j c1180j7 = new C1180j();
        C1180j c1180j8 = new C1180j(new byte[64]);
        c1180j = new C1180j(new byte[48]);
        c1180j = new C1180j(new byte[32]);
        c1180j = new C1180j(new byte[9]);
        c1180j = new C1180j(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j2 = (7 + j) & -8;
            if (j2 != 0) {
                C1181k.m2600a(c1180j8, c1180j3, c1180j4, c1180j5, c1180j6, c1180j7);
                C1181k.m2603a(c1180jArr, c1180j2, bArr3, i, c1180j3, c1180j4, c1180j5, c1180j);
                int i4 = c1180j.ccb;
                int i5 = c1180j.ccb;
                long j3;
                long j4;
                if (i2 == 0) {
                    C1181k.m2602a(c1180j, c1180j, c1180jArr, i2, c1180j8, c1180j, c1180j, c1180j6, c1180j7, c1180j);
                    C1181k.m2606d(c1180j, c1180j, 8);
                    c1180j.ccb += 8;
                    j3 = 0;
                    j4 = j2 >> 3;
                    while (j3 < j4) {
                        C1181k.m2598a(c1180j, c1180j, c1180j);
                        C1181k.m2602a(c1180j, c1180j, c1180jArr, i2, c1180j8, c1180j, c1180j, c1180j6, c1180j7, c1180j);
                        C1181k.m2606d(c1180j, c1180j, 8);
                        j3++;
                        c1180j.ccb += 8;
                        c1180j.ccb += 8;
                    }
                } else {
                    C1181k.m2606d(c1180j, c1180j, 8);
                    c1180j.ccb += 8;
                    j3 = 1;
                    j4 = j2 >> 3;
                    while (j3 < j4) {
                        C1181k.m2602a(c1180j, c1180j, c1180jArr, i2, c1180j8, c1180j, c1180j, c1180j6, c1180j7, c1180j);
                        C1181k.m2598a(c1180j, c1180j, c1180j);
                        C1181k.m2606d(c1180j, c1180j, 8);
                        j3++;
                        c1180j.ccb += 8;
                        c1180j.ccb += 8;
                    }
                }
                c1180j.ccb = i4;
                c1180j.ccb = i5;
                return 1;
            }
        }
        return 0;
    }

    /* renamed from: d */
    private static void m2606d(C1180j c1180j, C1180j c1180j2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c1180j.cca[c1180j.ccb + i2] = c1180j2.cca[c1180j2.ccb + i2];
        }
    }

    /* renamed from: a */
    private static void m2596a(C1180j c1180j, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            c1180j.cca[c1180j.ccb + i2] = (byte) 0;
        }
    }
}
