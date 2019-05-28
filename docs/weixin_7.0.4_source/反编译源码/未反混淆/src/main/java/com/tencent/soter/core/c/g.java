package com.tencent.soter.core.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class g {
    public static boolean isNullOrNil(String str) {
        AppMethodBeat.i(73036);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.o(73036);
            return true;
        }
        AppMethodBeat.o(73036);
        return false;
    }

    public static String nullAsNil(String str) {
        return str == null ? "" : str;
    }

    public static long nC(long j) {
        AppMethodBeat.i(73037);
        long nanoTime = ((System.nanoTime() - j) / 1000) / 1000;
        AppMethodBeat.o(73037);
        return nanoTime;
    }

    public static String x(byte[] bArr) {
        AppMethodBeat.i(73038);
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            byte[] digest = instance.digest();
            int length = digest.length;
            char[] cArr2 = new char[(length * 2)];
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte b = digest[i];
                int i3 = i2 + 1;
                cArr2[i2] = cArr[(b >>> 4) & 15];
                int i4 = i3 + 1;
                cArr2[i3] = cArr[b & 15];
                i++;
                i2 = i4;
            }
            String str = new String(cArr2);
            AppMethodBeat.o(73038);
            return str;
        } catch (Exception e) {
            AppMethodBeat.o(73038);
            return null;
        }
    }
}
