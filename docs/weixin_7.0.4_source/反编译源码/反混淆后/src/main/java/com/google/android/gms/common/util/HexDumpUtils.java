package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;
import java.util.StringTokenizer;

public final class HexDumpUtils {
    public static byte[] bytesFromString(String str) {
        AppMethodBeat.m2504i(90210);
        StringTokenizer stringTokenizer = new StringTokenizer(str, " \t\n");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (stringTokenizer.hasMoreTokens()) {
            try {
                byteArrayOutputStream.write(Integer.parseInt(stringTokenizer.nextToken(), 16) & 255);
            } catch (NumberFormatException e) {
                AppMethodBeat.m2505o(90210);
                return null;
            }
        }
        byte[] toByteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.m2505o(90210);
        return toByteArray;
    }

    public static String dump(byte[] bArr, int i, int i2, boolean z) {
        AppMethodBeat.m2504i(90209);
        if (bArr == null || bArr.length == 0 || i < 0 || i2 <= 0 || i + i2 > bArr.length) {
            AppMethodBeat.m2505o(90209);
            return null;
        }
        int i3 = 57;
        if (z) {
            i3 = 75;
        }
        StringBuilder stringBuilder = new StringBuilder(i3 * (((i2 + 16) - 1) / 16));
        int i4 = 0;
        i3 = 0;
        int i5 = i2;
        int i6 = i;
        while (i5 > 0) {
            if (i4 == 0) {
                if (i2 < 65536) {
                    stringBuilder.append(String.format("%04X:", new Object[]{Integer.valueOf(i6)}));
                    i3 = i6;
                } else {
                    stringBuilder.append(String.format("%08X:", new Object[]{Integer.valueOf(i6)}));
                    i3 = i6;
                }
            } else if (i4 == 8) {
                stringBuilder.append(" -");
            }
            stringBuilder.append(String.format(" %02X", new Object[]{Integer.valueOf(bArr[i6] & 255)}));
            int i7 = i5 - 1;
            i5 = i4 + 1;
            if (z && (i5 == 16 || i7 == 0)) {
                int i8 = 16 - i5;
                if (i8 > 0) {
                    for (i4 = 0; i4 < i8; i4++) {
                        stringBuilder.append("   ");
                    }
                }
                if (i8 >= 8) {
                    stringBuilder.append("  ");
                }
                stringBuilder.append("  ");
                for (i8 = 0; i8 < i5; i8++) {
                    char c = (char) bArr[i3 + i8];
                    if (c < ' ' || c > '~') {
                        c = '.';
                    }
                    stringBuilder.append(c);
                }
            }
            if (i5 == 16 || i7 == 0) {
                stringBuilder.append(10);
                i4 = 0;
            } else {
                i4 = i5;
            }
            i6++;
            i5 = i7;
        }
        String stringBuilder2 = stringBuilder.toString();
        AppMethodBeat.m2505o(90209);
        return stringBuilder2;
    }
}
