package com.tencent.p177mm.plugin.normsg.p474b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.normsg.b.d */
public final class C21394d {
    private static final char[] HEX_DIGITS = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: v */
    public static String m32816v(byte[] bArr, int i, int i2) {
        AppMethodBeat.m2504i(10436);
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
        AppMethodBeat.m2505o(10436);
        return str;
    }

    /* renamed from: TQ */
    public static String m32815TQ(String str) {
        AppMethodBeat.m2504i(10437);
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
                    AppMethodBeat.m2505o(10437);
                    return stringBuilder2;
                }
                stringBuilder.append((char) i2);
                i++;
            } catch (Throwable th) {
                stringBuilder2 = stringBuilder.toString();
                AppMethodBeat.m2505o(10437);
                return stringBuilder2;
            }
        }
    }
}
