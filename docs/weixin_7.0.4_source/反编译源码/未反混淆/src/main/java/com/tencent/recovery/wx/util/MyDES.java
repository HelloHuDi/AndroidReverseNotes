package com.tencent.recovery.wx.util;

import com.tencent.wxmm.v2encoder;

public class MyDES {
    private static void a(MyByteArray myByteArray, MyByteArray myByteArray2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            byte[] bArr = myByteArray.cca;
            int i3 = myByteArray.ccb + i2;
            bArr[i3] = (byte) (bArr[i3] ^ myByteArray2.cca[myByteArray2.ccb + i2]);
        }
    }

    private static void b(MyByteArray myByteArray, MyByteArray myByteArray2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            myByteArray.cca[myByteArray.ccb + i2] = (byte) ((myByteArray2.cca[(i2 >> 3) + myByteArray2.ccb] >> (i2 & 7)) & 1);
        }
    }

    private static void c(MyByteArray myByteArray, MyByteArray myByteArray2, int i) {
        int i2 = 0;
        d(myByteArray2, myByteArray, i);
        for (int i3 = 0; i3 < 28 - i; i3++) {
            myByteArray.cca[myByteArray.ccb + i3] = myByteArray.cca[(myByteArray.ccb + i3) + i];
        }
        while (i2 < i) {
            myByteArray.cca[((myByteArray.ccb + i2) + 28) - i] = myByteArray2.cca[myByteArray2.ccb + i2];
            i2++;
        }
    }

    private static void a(MyByteArray myByteArray, MyByteArray myByteArray2, byte[] bArr, int i, MyByteArray myByteArray3) {
        for (int i2 = 0; i2 < i; i2++) {
            myByteArray3.cca[myByteArray3.ccb + i2] = myByteArray2.cca[(myByteArray2.ccb + bArr[i2]) - 1];
        }
        d(myByteArray, myByteArray3, i);
    }

    private static void a(MyByteArray myByteArray, MyByteArray myByteArray2, MyByteArray[] myByteArrayArr, MyByteArray myByteArray3, MyByteArray myByteArray4, MyByteArray myByteArray5, MyByteArray myByteArray6, MyByteArray myByteArray7, MyByteArray myByteArray8) {
        int i;
        byte[] bArr = new byte[]{(byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 28, (byte) 20, (byte) 12, (byte) 4, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 64, (byte) 56, (byte) 48, (byte) 40, (byte) 32, (byte) 24, v2encoder.enumCODEC_vcodec2, (byte) 8, (byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7};
        byte[] bArr2 = new byte[]{(byte) 40, (byte) 8, (byte) 48, v2encoder.enumCODEC_vcodec2, (byte) 56, (byte) 24, (byte) 64, (byte) 32, (byte) 39, (byte) 7, (byte) 47, (byte) 15, (byte) 55, (byte) 23, (byte) 63, (byte) 31, (byte) 38, (byte) 6, (byte) 46, (byte) 14, (byte) 54, (byte) 22, (byte) 62, (byte) 30, (byte) 37, (byte) 5, (byte) 45, (byte) 13, (byte) 53, (byte) 21, (byte) 61, (byte) 29, (byte) 36, (byte) 4, (byte) 44, (byte) 12, (byte) 52, (byte) 20, (byte) 60, (byte) 28, (byte) 35, (byte) 3, (byte) 43, (byte) 11, (byte) 51, (byte) 19, (byte) 59, (byte) 27, (byte) 34, (byte) 2, (byte) 42, (byte) 10, (byte) 50, (byte) 18, (byte) 58, (byte) 26, (byte) 33, (byte) 1, (byte) 41, (byte) 9, (byte) 49, (byte) 17, (byte) 57, (byte) 25};
        b(myByteArray3, myByteArray2, 64);
        a(myByteArray3, myByteArray3, bArr, 64, myByteArray8);
        for (i = 0; i < 16; i++) {
            d(myByteArray5, myByteArray7, 32);
            MyByteArray myByteArray9 = myByteArrayArr[i];
            byte[] bArr3 = new byte[]{v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 20, (byte) 21, (byte) 29, (byte) 12, (byte) 28, (byte) 17, (byte) 1, (byte) 15, (byte) 23, (byte) 26, (byte) 5, (byte) 18, (byte) 31, (byte) 10, (byte) 2, (byte) 8, (byte) 24, (byte) 14, (byte) 32, (byte) 27, (byte) 3, (byte) 9, (byte) 19, (byte) 13, (byte) 30, (byte) 6, (byte) 22, (byte) 11, (byte) 4, (byte) 25};
            a(myByteArray4, myByteArray7, new byte[]{(byte) 32, (byte) 1, (byte) 2, (byte) 3, (byte) 4, (byte) 5, (byte) 4, (byte) 5, (byte) 6, (byte) 7, (byte) 8, (byte) 9, (byte) 8, (byte) 9, (byte) 10, (byte) 11, (byte) 12, (byte) 13, (byte) 12, (byte) 13, (byte) 14, (byte) 15, v2encoder.enumCODEC_vcodec2, (byte) 17, v2encoder.enumCODEC_vcodec2, (byte) 17, (byte) 18, (byte) 19, (byte) 20, (byte) 21, (byte) 20, (byte) 21, (byte) 22, (byte) 23, (byte) 24, (byte) 25, (byte) 24, (byte) 25, (byte) 26, (byte) 27, (byte) 28, (byte) 29, (byte) 28, (byte) 29, (byte) 30, (byte) 31, (byte) 32, (byte) 1}, 48, myByteArray8);
            a(myByteArray4, myByteArray9, 48);
            r6 = new byte[8][][];
            r6[0] = new byte[][]{new byte[]{(byte) 14, (byte) 4, (byte) 13, (byte) 1, (byte) 2, (byte) 15, (byte) 11, (byte) 8, (byte) 3, (byte) 10, (byte) 6, (byte) 12, (byte) 5, (byte) 9, (byte) 0, (byte) 7}, new byte[]{(byte) 0, (byte) 15, (byte) 7, (byte) 4, (byte) 14, (byte) 2, (byte) 13, (byte) 1, (byte) 10, (byte) 6, (byte) 12, (byte) 11, (byte) 9, (byte) 5, (byte) 3, (byte) 8}, new byte[]{(byte) 4, (byte) 1, (byte) 14, (byte) 8, (byte) 13, (byte) 6, (byte) 2, (byte) 11, (byte) 15, (byte) 12, (byte) 9, (byte) 7, (byte) 3, (byte) 10, (byte) 5, (byte) 0}, new byte[]{(byte) 15, (byte) 12, (byte) 8, (byte) 2, (byte) 4, (byte) 9, (byte) 1, (byte) 7, (byte) 5, (byte) 11, (byte) 3, (byte) 14, (byte) 10, (byte) 0, (byte) 6, (byte) 13}};
            r6[1] = new byte[][]{new byte[]{(byte) 15, (byte) 1, (byte) 8, (byte) 14, (byte) 6, (byte) 11, (byte) 3, (byte) 4, (byte) 9, (byte) 7, (byte) 2, (byte) 13, (byte) 12, (byte) 0, (byte) 5, (byte) 10}, new byte[]{(byte) 3, (byte) 13, (byte) 4, (byte) 7, (byte) 15, (byte) 2, (byte) 8, (byte) 14, (byte) 12, (byte) 0, (byte) 1, (byte) 10, (byte) 6, (byte) 9, (byte) 11, (byte) 5}, new byte[]{(byte) 0, (byte) 14, (byte) 7, (byte) 11, (byte) 10, (byte) 4, (byte) 13, (byte) 1, (byte) 5, (byte) 8, (byte) 12, (byte) 6, (byte) 9, (byte) 3, (byte) 2, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 10, (byte) 1, (byte) 3, (byte) 15, (byte) 4, (byte) 2, (byte) 11, (byte) 6, (byte) 7, (byte) 12, (byte) 0, (byte) 5, (byte) 14, (byte) 9}};
            r6[2] = new byte[][]{new byte[]{(byte) 10, (byte) 0, (byte) 9, (byte) 14, (byte) 6, (byte) 3, (byte) 15, (byte) 5, (byte) 1, (byte) 13, (byte) 12, (byte) 7, (byte) 11, (byte) 4, (byte) 2, (byte) 8}, new byte[]{(byte) 13, (byte) 7, (byte) 0, (byte) 9, (byte) 3, (byte) 4, (byte) 6, (byte) 10, (byte) 2, (byte) 8, (byte) 5, (byte) 14, (byte) 12, (byte) 11, (byte) 15, (byte) 1}, new byte[]{(byte) 13, (byte) 6, (byte) 4, (byte) 9, (byte) 8, (byte) 15, (byte) 3, (byte) 0, (byte) 11, (byte) 1, (byte) 2, (byte) 12, (byte) 5, (byte) 10, (byte) 14, (byte) 7}, new byte[]{(byte) 1, (byte) 10, (byte) 13, (byte) 0, (byte) 6, (byte) 9, (byte) 8, (byte) 7, (byte) 4, (byte) 15, (byte) 14, (byte) 3, (byte) 11, (byte) 5, (byte) 2, (byte) 12}};
            r6[3] = new byte[][]{new byte[]{(byte) 7, (byte) 13, (byte) 14, (byte) 3, (byte) 0, (byte) 6, (byte) 9, (byte) 10, (byte) 1, (byte) 2, (byte) 8, (byte) 5, (byte) 11, (byte) 12, (byte) 4, (byte) 15}, new byte[]{(byte) 13, (byte) 8, (byte) 11, (byte) 5, (byte) 6, (byte) 15, (byte) 0, (byte) 3, (byte) 4, (byte) 7, (byte) 2, (byte) 12, (byte) 1, (byte) 10, (byte) 14, (byte) 9}, new byte[]{(byte) 10, (byte) 6, (byte) 9, (byte) 0, (byte) 12, (byte) 11, (byte) 7, (byte) 13, (byte) 15, (byte) 1, (byte) 3, (byte) 14, (byte) 5, (byte) 2, (byte) 8, (byte) 4}, new byte[]{(byte) 3, (byte) 15, (byte) 0, (byte) 6, (byte) 10, (byte) 1, (byte) 13, (byte) 8, (byte) 9, (byte) 4, (byte) 5, (byte) 11, (byte) 12, (byte) 7, (byte) 2, (byte) 14}};
            r6[4] = new byte[][]{new byte[]{(byte) 2, (byte) 12, (byte) 4, (byte) 1, (byte) 7, (byte) 10, (byte) 11, (byte) 6, (byte) 8, (byte) 5, (byte) 3, (byte) 15, (byte) 13, (byte) 0, (byte) 14, (byte) 9}, new byte[]{(byte) 14, (byte) 11, (byte) 2, (byte) 12, (byte) 4, (byte) 7, (byte) 13, (byte) 1, (byte) 5, (byte) 0, (byte) 15, (byte) 10, (byte) 3, (byte) 9, (byte) 8, (byte) 6}, new byte[]{(byte) 4, (byte) 2, (byte) 1, (byte) 11, (byte) 10, (byte) 13, (byte) 7, (byte) 8, (byte) 15, (byte) 9, (byte) 12, (byte) 5, (byte) 6, (byte) 3, (byte) 0, (byte) 14}, new byte[]{(byte) 11, (byte) 8, (byte) 12, (byte) 7, (byte) 1, (byte) 14, (byte) 2, (byte) 13, (byte) 6, (byte) 15, (byte) 0, (byte) 9, (byte) 10, (byte) 4, (byte) 5, (byte) 3}};
            r6[5] = new byte[][]{new byte[]{(byte) 12, (byte) 1, (byte) 10, (byte) 15, (byte) 9, (byte) 2, (byte) 6, (byte) 8, (byte) 0, (byte) 13, (byte) 3, (byte) 4, (byte) 14, (byte) 7, (byte) 5, (byte) 11}, new byte[]{(byte) 10, (byte) 15, (byte) 4, (byte) 2, (byte) 7, (byte) 12, (byte) 9, (byte) 5, (byte) 6, (byte) 1, (byte) 13, (byte) 14, (byte) 0, (byte) 11, (byte) 3, (byte) 8}, new byte[]{(byte) 9, (byte) 14, (byte) 15, (byte) 5, (byte) 2, (byte) 8, (byte) 12, (byte) 3, (byte) 7, (byte) 0, (byte) 4, (byte) 10, (byte) 1, (byte) 13, (byte) 11, (byte) 6}, new byte[]{(byte) 4, (byte) 3, (byte) 2, (byte) 12, (byte) 9, (byte) 5, (byte) 15, (byte) 10, (byte) 11, (byte) 14, (byte) 1, (byte) 7, (byte) 6, (byte) 0, (byte) 8, (byte) 13}};
            r6[6] = new byte[][]{new byte[]{(byte) 4, (byte) 11, (byte) 2, (byte) 14, (byte) 15, (byte) 0, (byte) 8, (byte) 13, (byte) 3, (byte) 12, (byte) 9, (byte) 7, (byte) 5, (byte) 10, (byte) 6, (byte) 1}, new byte[]{(byte) 13, (byte) 0, (byte) 11, (byte) 7, (byte) 4, (byte) 9, (byte) 1, (byte) 10, (byte) 14, (byte) 3, (byte) 5, (byte) 12, (byte) 2, (byte) 15, (byte) 8, (byte) 6}, new byte[]{(byte) 1, (byte) 4, (byte) 11, (byte) 13, (byte) 12, (byte) 3, (byte) 7, (byte) 14, (byte) 10, (byte) 15, (byte) 6, (byte) 8, (byte) 0, (byte) 5, (byte) 9, (byte) 2}, new byte[]{(byte) 6, (byte) 11, (byte) 13, (byte) 8, (byte) 1, (byte) 4, (byte) 10, (byte) 7, (byte) 9, (byte) 5, (byte) 0, (byte) 15, (byte) 14, (byte) 2, (byte) 3, (byte) 12}};
            r6[7] = new byte[][]{new byte[]{(byte) 13, (byte) 2, (byte) 8, (byte) 4, (byte) 6, (byte) 15, (byte) 11, (byte) 1, (byte) 10, (byte) 9, (byte) 3, (byte) 14, (byte) 5, (byte) 0, (byte) 12, (byte) 7}, new byte[]{(byte) 1, (byte) 15, (byte) 13, (byte) 8, (byte) 10, (byte) 3, (byte) 7, (byte) 4, (byte) 12, (byte) 5, (byte) 6, (byte) 11, (byte) 0, (byte) 14, (byte) 9, (byte) 2}, new byte[]{(byte) 7, (byte) 11, (byte) 4, (byte) 1, (byte) 9, (byte) 12, (byte) 14, (byte) 2, (byte) 0, (byte) 6, (byte) 10, (byte) 13, (byte) 15, (byte) 3, (byte) 5, (byte) 8}, new byte[]{(byte) 2, (byte) 1, (byte) 14, (byte) 7, (byte) 4, (byte) 10, (byte) 8, (byte) 13, (byte) 15, (byte) 12, (byte) 9, (byte) 0, (byte) 3, (byte) 5, (byte) 6, (byte) 11}};
            int i2 = myByteArray4.ccb;
            int i3 = myByteArray7.ccb;
            int i4 = 0;
            while (i4 < 8) {
                byte b = (byte) ((((myByteArray4.cca[myByteArray4.ccb + 1] << 3) + (myByteArray4.cca[myByteArray4.ccb + 2] << 2)) + (myByteArray4.cca[myByteArray4.ccb + 3] << 1)) + myByteArray4.cca[myByteArray4.ccb + 4]);
                MyByteArray myByteArray10 = myByteArray7;
                b(myByteArray10, new MyByteArray(r6[i4][(byte) ((myByteArray4.cca[myByteArray4.ccb + 0] << 1) + myByteArray4.cca[myByteArray4.ccb + 5])][b]), 4);
                i4 = (byte) (i4 + 1);
                myByteArray4.ccb += 6;
                myByteArray7.ccb += 4;
            }
            myByteArray4.ccb = i2;
            myByteArray7.ccb = i3;
            a(myByteArray7, myByteArray7, bArr3, 32, myByteArray8);
            a(myByteArray7, myByteArray6, 32);
            d(myByteArray6, myByteArray5, 32);
        }
        a(myByteArray3, myByteArray3, bArr2, 64, myByteArray8);
        a(myByteArray, 8);
        for (i = 0; i < 64; i++) {
            byte[] bArr4 = myByteArray.cca;
            int i5 = myByteArray.ccb + (i >> 3);
            bArr4[i5] = (byte) (bArr4[i5] | (myByteArray3.cca[myByteArray3.ccb + i] << (i & 7)));
        }
    }

    public static char a(byte[] bArr, byte[] bArr2, long j, int i, byte[] bArr3) {
        int i2;
        MyByteArray myByteArray = new MyByteArray(bArr);
        MyByteArray myByteArray2 = new MyByteArray(bArr2);
        MyByteArray[] myByteArrayArr = new MyByteArray[16];
        for (i2 = 0; i2 < 16; i2++) {
            myByteArrayArr[i2] = new MyByteArray(new byte[48]);
        }
        MyByteArray myByteArray3 = new MyByteArray(new byte[256]);
        MyByteArray myByteArray4 = new MyByteArray(new byte[24]);
        MyByteArray myByteArray5 = new MyByteArray(new byte[64]);
        MyByteArray myByteArray6 = new MyByteArray();
        MyByteArray myByteArray7 = new MyByteArray();
        MyByteArray myByteArray8 = new MyByteArray();
        MyByteArray myByteArray9 = new MyByteArray();
        MyByteArray myByteArray10 = new MyByteArray(new byte[64]);
        MyByteArray myByteArray11 = new MyByteArray(new byte[48]);
        MyByteArray myByteArray12 = new MyByteArray(new byte[32]);
        MyByteArray myByteArray13 = new MyByteArray(new byte[9]);
        MyByteArray myByteArray14 = new MyByteArray(new byte[8]);
        if (bArr3 != null && bArr3.length > 0) {
            long j2 = (7 + j) & -8;
            if (j2 != 0) {
                int i3;
                myByteArray6.ccb = 0;
                myByteArray6.cca = myByteArray5.cca;
                myByteArray7.ccb = 28;
                myByteArray7.cca = myByteArray5.cca;
                myByteArray8.ccb = 0;
                myByteArray8.cca = myByteArray10.cca;
                myByteArray9.ccb = 32;
                myByteArray9.cca = myByteArray10.cca;
                a(myByteArray4, 24);
                myByteArray2 = new MyByteArray(bArr3);
                if (i > 24) {
                    i = 24;
                }
                d(myByteArray4, myByteArray2, i);
                byte[] bArr4 = new byte[56];
                bArr4 = new byte[]{(byte) 57, (byte) 49, (byte) 41, (byte) 33, (byte) 25, (byte) 17, (byte) 9, (byte) 1, (byte) 58, (byte) 50, (byte) 42, (byte) 34, (byte) 26, (byte) 18, (byte) 10, (byte) 2, (byte) 59, (byte) 51, (byte) 43, (byte) 35, (byte) 27, (byte) 19, (byte) 11, (byte) 3, (byte) 60, (byte) 52, (byte) 44, (byte) 36, (byte) 63, (byte) 55, (byte) 47, (byte) 39, (byte) 31, (byte) 23, (byte) 15, (byte) 7, (byte) 62, (byte) 54, (byte) 46, (byte) 38, (byte) 30, (byte) 22, (byte) 14, (byte) 6, (byte) 61, (byte) 53, (byte) 45, (byte) 37, (byte) 29, (byte) 21, (byte) 13, (byte) 5, (byte) 28, (byte) 20, (byte) 12, (byte) 4};
                byte[] bArr5 = new byte[48];
                bArr5 = new byte[]{(byte) 14, (byte) 17, (byte) 11, (byte) 24, (byte) 1, (byte) 5, (byte) 3, (byte) 28, (byte) 15, (byte) 6, (byte) 21, (byte) 10, (byte) 23, (byte) 19, (byte) 12, (byte) 4, (byte) 26, (byte) 8, v2encoder.enumCODEC_vcodec2, (byte) 7, (byte) 27, (byte) 20, (byte) 13, (byte) 2, (byte) 41, (byte) 52, (byte) 31, (byte) 37, (byte) 47, (byte) 55, (byte) 30, (byte) 40, (byte) 51, (byte) 45, (byte) 33, (byte) 48, (byte) 44, (byte) 49, (byte) 39, (byte) 56, (byte) 34, (byte) 53, (byte) 46, (byte) 42, (byte) 50, (byte) 36, (byte) 29, (byte) 32};
                byte[] bArr6 = new byte[16];
                bArr6 = new byte[]{(byte) 1, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 2, (byte) 1};
                b(myByteArray5, myByteArray4, 64);
                a(myByteArray5, myByteArray5, bArr4, 56, myByteArray3);
                for (i3 = 0; i3 < 16; i3++) {
                    c(myByteArray6, myByteArray3, bArr6[i3]);
                    c(myByteArray7, myByteArray3, bArr6[i3]);
                    a(myByteArrayArr[i3], myByteArray5, bArr5, 48, myByteArray3);
                }
                i3 = myByteArray2.ccb;
                int i4 = myByteArray.ccb;
                a(myByteArray, myByteArray13, myByteArrayArr, myByteArray10, myByteArray11, myByteArray12, myByteArray8, myByteArray9, myByteArray3);
                d(myByteArray14, myByteArray, 8);
                myByteArray.ccb += 8;
                long j3 = 0;
                j2 >>= 3;
                while (j3 < j2) {
                    for (i2 = 0; i2 < 8; i2++) {
                        myByteArray14.cca[myByteArray14.ccb + i2] = (byte) (myByteArray14.cca[myByteArray14.ccb + i2] ^ myByteArray2.cca[myByteArray2.ccb + i2]);
                    }
                    a(myByteArray, myByteArray14, myByteArrayArr, myByteArray10, myByteArray11, myByteArray12, myByteArray8, myByteArray9, myByteArray3);
                    d(myByteArray14, myByteArray, 8);
                    j3++;
                    myByteArray.ccb += 8;
                    myByteArray2.ccb += 8;
                }
                myByteArray2.ccb = i3;
                myByteArray.ccb = i4;
                return 1;
            }
        }
        return 0;
    }

    private static void d(MyByteArray myByteArray, MyByteArray myByteArray2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            myByteArray.cca[myByteArray.ccb + i2] = myByteArray2.cca[myByteArray2.ccb + i2];
        }
    }

    private static void a(MyByteArray myByteArray, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            myByteArray.cca[myByteArray.ccb + i2] = (byte) 0;
        }
    }
}
