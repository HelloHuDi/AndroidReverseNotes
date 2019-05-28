package com.tencent.mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public final class f {
    public static boolean th(String str) {
        AppMethodBeat.i(93200);
        if (str.lastIndexOf(";?enc=") > 0) {
            AppMethodBeat.o(93200);
            return true;
        }
        AppMethodBeat.o(93200);
        return false;
    }

    public static String s(String str, long j) {
        AppMethodBeat.i(93201);
        String format;
        if (j == 0) {
            format = String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
            AppMethodBeat.o(93201);
            return format;
        }
        format = String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
        AppMethodBeat.o(93201);
        return format;
    }

    public static String ti(String str) {
        AppMethodBeat.i(93202);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
            AppMethodBeat.o(93202);
            return str;
        }
        AppMethodBeat.o(93202);
        return str;
    }

    public static long tj(String str) {
        AppMethodBeat.i(93203);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            long anl = bo.anl(str.substring(lastIndexOf + 6));
            AppMethodBeat.o(93203);
            return anl;
        }
        AppMethodBeat.o(93203);
        return 0;
    }

    public static String tk(String str) {
        AppMethodBeat.i(93204);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        String trim;
        if (lastIndexOf > 0) {
            trim = str.substring(lastIndexOf + 6).trim();
            AppMethodBeat.o(93204);
            return trim;
        }
        trim = "";
        AppMethodBeat.o(93204);
        return trim;
    }
}
