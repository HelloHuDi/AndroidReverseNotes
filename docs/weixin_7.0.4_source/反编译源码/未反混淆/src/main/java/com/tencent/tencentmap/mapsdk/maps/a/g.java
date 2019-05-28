package com.tencent.tencentmap.mapsdk.maps.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class g {
    public static final byte[] a = new byte[0];
    private static final char[] b = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        AppMethodBeat.i(98963);
        if (bArr == null || bArr.length == 0) {
            AppMethodBeat.o(98963);
            return null;
        }
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            cArr[(i * 2) + 1] = b[b & 15];
            cArr[(i * 2) + 0] = b[((byte) (b >>> 4)) & 15];
        }
        String str = new String(cArr);
        AppMethodBeat.o(98963);
        return str;
    }
}
