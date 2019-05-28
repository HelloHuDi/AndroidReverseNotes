package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.g */
public class C36511g {
    /* renamed from: a */
    public static final byte[] f15370a = new byte[0];
    /* renamed from: b */
    private static final char[] f15371b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m60418a(byte[] bArr) {
        AppMethodBeat.m2504i(98963);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.m2505o(98963);
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[(i * 2) + 1] = f15371b[b & 15];
            cArr[(i * 2) + 0] = f15371b[((byte) (b >>> 4)) & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.m2505o(98963);
        return str;
    }
}
