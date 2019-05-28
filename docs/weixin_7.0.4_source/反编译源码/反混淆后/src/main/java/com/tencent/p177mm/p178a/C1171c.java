package com.tencent.p177mm.p178a;

import com.tencent.p177mm.pointers.PByteArray;

/* renamed from: com.tencent.mm.a.c */
public final class C1171c {
    /* renamed from: a */
    public static int m2554a(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int i;
        int length = 8 - (bArr.length % 8);
        if (length == 0) {
            i = 8;
        } else {
            i = length;
        }
        byte[] bArr3 = new byte[(bArr.length + i)];
        for (length = 0; length < bArr.length; length++) {
            bArr3[length] = bArr[length];
        }
        for (length = 0; length < i; length++) {
            bArr3[bArr.length + length] = (byte) i;
        }
        pByteArray.value = new byte[((bArr.length + i) + 32)];
        if (C1181k.m2595a(pByteArray.value, bArr3, (long) bArr3.length, bArr2.length, bArr2, 0) == 0) {
            return 11;
        }
        bArr3 = new byte[((bArr.length + i) + 8)];
        for (length = 0; length < bArr3.length; length++) {
            bArr3[length] = pByteArray.value[length];
        }
        pByteArray.value = bArr3;
        return 0;
    }

    /* renamed from: b */
    public static int m2555b(PByteArray pByteArray, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return 2;
        }
        if (bArr.length < 0 || bArr2.length <= 0) {
            return 2;
        }
        int length = bArr.length;
        pByteArray.value = new byte[length];
        if (C1181k.m2595a(pByteArray.value, bArr, (long) length, bArr2.length, bArr2, 1) == 0) {
            return 12;
        }
        byte b = pByteArray.value[(length - 1) - 8];
        if (b <= (byte) 0 || b > (byte) 8) {
            return 12;
        }
        byte[] bArr3 = new byte[((length - b) - 8)];
        for (int i = 0; i < bArr3.length; i++) {
            bArr3[i] = pByteArray.value[i];
        }
        pByteArray.value = bArr3;
        return 0;
    }
}
