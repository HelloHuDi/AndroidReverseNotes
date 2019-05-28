package com.google.android.gms.common.util;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class Base64Utils {
    public static byte[] decode(String str) {
        AppMethodBeat.i(90035);
        if (str == null) {
            AppMethodBeat.o(90035);
            return null;
        }
        byte[] decode = Base64.decode(str, 0);
        AppMethodBeat.o(90035);
        return decode;
    }

    public static byte[] decodeUrlSafe(String str) {
        AppMethodBeat.i(90036);
        if (str == null) {
            AppMethodBeat.o(90036);
            return null;
        }
        byte[] decode = Base64.decode(str, 10);
        AppMethodBeat.o(90036);
        return decode;
    }

    public static byte[] decodeUrlSafeNoPadding(String str) {
        AppMethodBeat.i(90037);
        if (str == null) {
            AppMethodBeat.o(90037);
            return null;
        }
        byte[] decode = Base64.decode(str, 11);
        AppMethodBeat.o(90037);
        return decode;
    }

    public static byte[] decodeUrlSafeNoPadding(byte[] bArr) {
        AppMethodBeat.i(90038);
        if (bArr == null) {
            AppMethodBeat.o(90038);
            return null;
        }
        byte[] decode = Base64.decode(bArr, 11);
        AppMethodBeat.o(90038);
        return decode;
    }

    public static String encode(byte[] bArr) {
        AppMethodBeat.i(90039);
        if (bArr == null) {
            AppMethodBeat.o(90039);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 0);
        AppMethodBeat.o(90039);
        return encodeToString;
    }

    public static String encodeUrlSafe(byte[] bArr) {
        AppMethodBeat.i(90040);
        if (bArr == null) {
            AppMethodBeat.o(90040);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 10);
        AppMethodBeat.o(90040);
        return encodeToString;
    }

    public static String encodeUrlSafeNoPadding(byte[] bArr) {
        AppMethodBeat.i(90041);
        if (bArr == null) {
            AppMethodBeat.o(90041);
            return null;
        }
        String encodeToString = Base64.encodeToString(bArr, 11);
        AppMethodBeat.o(90041);
        return encodeToString;
    }
}
