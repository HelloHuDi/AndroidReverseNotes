package com.tencent.d.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class c {
    public static byte[] dQC() {
        AppMethodBeat.i(114594);
        try {
            StringBuffer stringBuffer = new StringBuffer();
            String str = "http://pmir.3g.qq.com";
            int[] iArr = new int[]{-36, -46, -45, -77, -22, -10, 47, -77, -72, -69, -32, 25, 21, -21, -6, -75, -71, 31, -39, -49, -49};
            for (int i = 0; i < str.length(); i++) {
                stringBuffer.append((char) (str.charAt(i) + iArr[i]));
            }
            byte[] bytes = stringBuffer.toString().getBytes("UTF-8");
            AppMethodBeat.o(114594);
            return bytes;
        } catch (UnsupportedEncodingException e) {
            AppMethodBeat.o(114594);
            return null;
        }
    }

    private static void a(byte[] bArr, int[] iArr) {
        int i;
        int i2;
        int length = bArr.length >> 2;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i = i4 + 1;
            iArr[i3] = bArr[i4] & 255;
            i4 = i + 1;
            iArr[i3] = ((bArr[i] & 255) << 8) | iArr[i3];
            int i5 = i4 + 1;
            iArr[i3] = iArr[i3] | ((bArr[i4] & 255) << 16);
            i2 = i5 + 1;
            iArr[i3] = iArr[i3] | ((bArr[i5] & 255) << 24);
            i3++;
            i4 = i2;
        }
        if (i4 < bArr.length) {
            i2 = i4 + 1;
            iArr[i3] = bArr[i4] & 255;
            i = 8;
            while (i2 < bArr.length) {
                iArr[i3] = iArr[i3] | ((bArr[i2] & 255) << i);
                i2++;
                i += 8;
            }
        }
    }

    private static void a(int[] iArr, int i, byte[] bArr) {
        int i2;
        int length = bArr.length >> 2;
        if (length > i) {
            length = i;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            i2 = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            i4 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i3] >>> 8) & 255);
            i2 = i4 + 1;
            bArr[i4] = (byte) ((iArr[i3] >>> 16) & 255);
            i4 = i2 + 1;
            bArr[i2] = (byte) ((iArr[i3] >>> 24) & 255);
            i3++;
        }
        if (i > length && i4 < bArr.length) {
            length = i4 + 1;
            bArr[i4] = (byte) (iArr[i3] & 255);
            i4 = 8;
            while (i4 <= 24 && length < bArr.length) {
                i2 = length + 1;
                bArr[length] = (byte) ((iArr[i3] >>> i4) & 255);
                i4 += 8;
                length = i2;
            }
        }
    }

    private static byte[] cm(byte[] bArr) {
        AppMethodBeat.i(114595);
        if (bArr != null && bArr.length > 16) {
            try {
                MessageDigest instance = MessageDigest.getInstance("MD5");
                instance.update(bArr);
                bArr = instance.digest();
            } catch (NoSuchAlgorithmException e) {
                bArr = null;
            }
        }
        AppMethodBeat.o(114595);
        return bArr;
    }

    public static byte[] m(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(114596);
        byte[] cm = cm(bArr2);
        if (bArr == null || cm == null || bArr.length == 0) {
            AppMethodBeat.o(114596);
            return bArr;
        }
        int i;
        int length = bArr.length % 4 == 0 ? (bArr.length >>> 2) + 1 : (bArr.length >>> 2) + 2;
        int[] iArr = new int[length];
        a(bArr, iArr);
        iArr[length - 1] = bArr.length;
        length = cm.length % 4 == 0 ? cm.length >>> 2 : (cm.length >>> 2) + 1;
        if (length < 4) {
            length = 4;
        }
        int[] iArr2 = new int[length];
        for (i = 0; i < length; i++) {
            iArr2[i] = 0;
        }
        a(cm, iArr2);
        int length2 = iArr.length - 1;
        int i2 = iArr[length2];
        length = (52 / (length2 + 1)) + 6;
        int i3 = 0;
        while (true) {
            i = length - 1;
            if (length > 0) {
                int i4;
                i3 -= 1640531527;
                int i5 = (i3 >>> 2) & 3;
                length = 0;
                while (length < length2) {
                    i4 = iArr[length + 1];
                    i2 = (((i2 ^ iArr2[(length & 3) ^ i5]) + (i4 ^ i3)) ^ (((i2 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i2 << 4)))) + iArr[length];
                    iArr[length] = i2;
                    length++;
                }
                i4 = iArr[0];
                i2 = iArr[length2] + (((iArr2[(length & 3) ^ i5] ^ i2) + (i4 ^ i3)) ^ (((i2 >>> 5) ^ (i4 << 2)) + ((i4 >>> 3) ^ (i2 << 4))));
                iArr[length2] = i2;
                length = i;
            } else {
                bArr = new byte[(iArr.length << 2)];
                a(iArr, iArr.length, bArr);
                AppMethodBeat.o(114596);
                return bArr;
            }
        }
    }

    public static byte[] n(byte[] bArr, byte[] bArr2) {
        AppMethodBeat.i(114597);
        byte[] cm = cm(bArr2);
        if (bArr == null || cm == null || bArr.length == 0) {
            AppMethodBeat.o(114597);
            return bArr;
        } else if (bArr.length % 4 != 0 || bArr.length < 8) {
            AppMethodBeat.o(114597);
            return null;
        } else {
            int i;
            int[] iArr = new int[(bArr.length >>> 2)];
            a(bArr, iArr);
            int length = cm.length % 4 == 0 ? cm.length >>> 2 : (cm.length >>> 2) + 1;
            if (length < 4) {
                length = 4;
            }
            int[] iArr2 = new int[length];
            for (i = 0; i < length; i++) {
                iArr2[i] = 0;
            }
            a(cm, iArr2);
            i = iArr.length - 1;
            int i2 = iArr[0];
            for (int i3 = ((52 / (i + 1)) + 6) * -1640531527; i3 != 0; i3 -= -1640531527) {
                int i4;
                int i5 = (i3 >>> 2) & 3;
                length = i;
                while (length > 0) {
                    i4 = iArr[length - 1];
                    i2 = iArr[length] - (((i2 ^ i3) + (i4 ^ iArr2[(length & 3) ^ i5])) ^ (((i4 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i4 << 4))));
                    iArr[length] = i2;
                    length--;
                }
                i4 = iArr[i];
                i2 = iArr[0] - (((iArr2[(length & 3) ^ i5] ^ i4) + (i2 ^ i3)) ^ (((i4 >>> 5) ^ (i2 << 2)) + ((i2 >>> 3) ^ (i4 << 4))));
                iArr[0] = i2;
            }
            length = iArr[i];
            if (length < 0 || length > ((iArr.length - 1) << 2)) {
                AppMethodBeat.o(114597);
                return null;
            }
            bArr = new byte[length];
            a(iArr, iArr.length - 1, bArr);
            AppMethodBeat.o(114597);
            return bArr;
        }
    }
}
