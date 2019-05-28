package com.tencent.p177mm.p178a;

/* renamed from: com.tencent.mm.a.l */
public final class C1182l {
    /* renamed from: c */
    public static byte[] m2607c(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return C1182l.m2609e(bArr, bArr2);
    }

    /* renamed from: d */
    public static byte[] m2608d(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        return C1182l.m2609e(bArr, bArr2);
    }

    /* renamed from: z */
    private static byte[] m2610z(byte[] bArr) {
        int i;
        byte[] bArr2 = new byte[256];
        for (i = 0; i < 256; i++) {
            bArr2[i] = (byte) i;
        }
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < 256) {
            int i4 = (((bArr[i3] & 255) + (bArr2[i] & 255)) + i2) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i4];
            bArr2[i4] = b;
            i3 = (i3 + 1) % bArr.length;
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    /* renamed from: e */
    private static byte[] m2609e(byte[] bArr, byte[] bArr2) {
        byte[] z = C1182l.m2610z(bArr2);
        byte[] bArr3 = new byte[bArr.length];
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < bArr.length) {
            i3 = (i3 + 1) & 255;
            int i4 = ((z[i3] & 255) + i2) & 255;
            byte b = z[i3];
            z[i3] = z[i4];
            z[i4] = b;
            i2 = ((z[i3] & 255) + (z[i4] & 255)) & 255;
            bArr3[i] = (byte) (z[i2] ^ bArr[i]);
            i++;
            i2 = i4;
        }
        return bArr3;
    }
}
