package com.tencent.mm.plugin.normsg.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static String v(byte[] bArr, int i, int i2) {
        AppMethodBeat.i(10436);
        char[] cArr = new char[((i2 - i) * 2)];
        int i3 = 0;
        while (i < i2) {
            byte b = bArr[i];
            int i4 = i3 + 1;
            cArr[i3] = HEX_DIGITS[(b >>> 4) & 15];
            i3 = i4 + 1;
            cArr[i4] = HEX_DIGITS[b & 15];
            i++;
        }
        String str = new String(cArr);
        AppMethodBeat.o(10436);
        return str;
    }

    public static String TQ(String str) {
        AppMethodBeat.i(10437);
        StringBuilder stringBuilder = new StringBuilder(str.length());
        int i = 1;
        while (true) {
            int i2 = 0;
            String stringBuilder2;
            try {
                i2 = str.charAt(i - 1) ^ str.charAt(i);
                if (i + 1 == str.length()) {
                    stringBuilder.append((char) i2);
                    stringBuilder2 = stringBuilder.toString();
                    AppMethodBeat.o(10437);
                    return stringBuilder2;
                }
                stringBuilder.append((char) i2);
                i++;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.o(10437);
                return stringBuilder2;
            }
        }
    }
}
