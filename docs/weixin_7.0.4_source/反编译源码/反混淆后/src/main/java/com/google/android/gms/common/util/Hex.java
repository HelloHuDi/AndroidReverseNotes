package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.util.VideoMaterialUtil;

public class Hex {
    private static final char[] zzaaa = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static final char[] zzzz = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String bytesToColonDelimitedStringLowercase(byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(90206);
        String str;
        if (bArr.length == 0) {
            str = new String();
            AppMethodBeat.m2505o(90206);
            return str;
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr.length - 1) {
                i = bArr[i2] & 255;
                int i4 = i3 + 1;
                cArr[i3] = zzaaa[i >>> 4];
                i3 = i4 + 1;
                cArr[i4] = zzaaa[i & 15];
                i = i3 + 1;
                cArr[i3] = ':';
                i2++;
            } else {
                i2 = bArr[bArr.length - 1] & 255;
                i = i3 + 1;
                cArr[i3] = zzaaa[i2 >>> 4];
                cArr[i] = zzaaa[i2 & 15];
                str = new String(cArr);
                AppMethodBeat.m2505o(90206);
                return str;
            }
        }
    }

    public static String bytesToColonDelimitedStringUppercase(byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(90205);
        String str;
        if (bArr.length == 0) {
            str = new String();
            AppMethodBeat.m2505o(90205);
            return str;
        }
        char[] cArr = new char[((bArr.length * 3) - 1)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr.length - 1) {
                i = bArr[i2] & 255;
                int i4 = i3 + 1;
                cArr[i3] = zzzz[i >>> 4];
                i3 = i4 + 1;
                cArr[i4] = zzzz[i & 15];
                i = i3 + 1;
                cArr[i3] = ':';
                i2++;
            } else {
                i2 = bArr[bArr.length - 1] & 255;
                i = i3 + 1;
                cArr[i3] = zzzz[i2 >>> 4];
                cArr[i] = zzzz[i2 & 15];
                str = new String(cArr);
                AppMethodBeat.m2505o(90205);
                return str;
            }
        }
    }

    public static String bytesToStringLowercase(byte[] bArr) {
        int i = 0;
        AppMethodBeat.m2504i(90204);
        char[] cArr = new char[(bArr.length << 1)];
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 < bArr.length) {
                int i4 = bArr[i2] & 255;
                int i5 = i3 + 1;
                cArr[i3] = zzaaa[i4 >>> 4];
                i = i5 + 1;
                cArr[i5] = zzaaa[i4 & 15];
                i2++;
            } else {
                String str = new String(cArr);
                AppMethodBeat.m2505o(90204);
                return str;
            }
        }
    }

    public static String bytesToStringUppercase(byte[] bArr) {
        AppMethodBeat.m2504i(90202);
        String bytesToStringUppercase = bytesToStringUppercase(bArr, false);
        AppMethodBeat.m2505o(90202);
        return bytesToStringUppercase;
    }

    public static String bytesToStringUppercase(byte[] bArr, boolean z) {
        AppMethodBeat.m2504i(90203);
        int length = bArr.length;
        StringBuilder stringBuilder = new StringBuilder(length << 1);
        int i = 0;
        while (i < length && (!z || i != length - 1 || (bArr[i] & 255) != 0)) {
            stringBuilder.append(zzzz[(bArr[i] & 240) >>> 4]);
            stringBuilder.append(zzzz[bArr[i] & 15]);
            i++;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(90203);
        return stringBuilder2;
    }

    public static byte[] colonDelimitedStringToBytes(String str) {
        AppMethodBeat.m2504i(90207);
        byte[] stringToBytes = stringToBytes(str.replace(VideoMaterialUtil.FRAMES_ID_SEPARATOR_3D, ""));
        AppMethodBeat.m2505o(90207);
        return stringToBytes;
    }

    public static byte[] stringToBytes(String str) {
        AppMethodBeat.m2504i(90208);
        int length = str.length();
        if (length % 2 != 0) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Hex string has odd number of characters");
            AppMethodBeat.m2505o(90208);
            throw illegalArgumentException;
        }
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) Integer.parseInt(str.substring(i, i + 2), 16);
        }
        AppMethodBeat.m2505o(90208);
        return bArr;
    }
}
