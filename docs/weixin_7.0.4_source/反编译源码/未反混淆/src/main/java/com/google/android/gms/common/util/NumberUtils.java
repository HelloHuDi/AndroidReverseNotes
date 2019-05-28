package com.google.android.gms.common.util;

import com.tencent.matrix.trace.core.AppMethodBeat;

@VisibleForTesting
public class NumberUtils {
    private NumberUtils() {
    }

    public static int compare(int i, int i2) {
        return i < i2 ? -1 : i == i2 ? 0 : 1;
    }

    public static int compare(long j, long j2) {
        return j < j2 ? -1 : j == j2 ? 0 : 1;
    }

    public static boolean isNumeric(String str) {
        AppMethodBeat.i(90252);
        try {
            Long.parseLong(str);
            AppMethodBeat.o(90252);
            return true;
        } catch (NumberFormatException e) {
            AppMethodBeat.o(90252);
            return false;
        }
    }

    public static long parseHexLong(String str) {
        AppMethodBeat.i(90251);
        long parseLong;
        if (str.length() > 16) {
            NumberFormatException numberFormatException = new NumberFormatException(new StringBuilder(String.valueOf(str).length() + 37).append("Invalid input: ").append(str).append(" exceeds 16 characters").toString());
            AppMethodBeat.o(90251);
            throw numberFormatException;
        } else if (str.length() == 16) {
            parseLong = Long.parseLong(str.substring(8), 16) | (Long.parseLong(str.substring(0, 8), 16) << 32);
            AppMethodBeat.o(90251);
            return parseLong;
        } else {
            parseLong = Long.parseLong(str, 16);
            AppMethodBeat.o(90251);
            return parseLong;
        }
    }
}
