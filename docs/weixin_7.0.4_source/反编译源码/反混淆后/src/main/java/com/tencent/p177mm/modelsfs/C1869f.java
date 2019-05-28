package com.tencent.p177mm.modelsfs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.modelsfs.f */
public final class C1869f {
    /* renamed from: th */
    public static boolean m3981th(String str) {
        AppMethodBeat.m2504i(93200);
        if (str.lastIndexOf(";?enc=") > 0) {
            AppMethodBeat.m2505o(93200);
            return true;
        }
        AppMethodBeat.m2505o(93200);
        return false;
    }

    /* renamed from: s */
    public static String m3980s(String str, long j) {
        AppMethodBeat.m2504i(93201);
        String format;
        if (j == 0) {
            format = String.format(str + ";?enc=%d", new Object[]{Long.valueOf(314159265)});
            AppMethodBeat.m2505o(93201);
            return format;
        }
        format = String.format(str + ";?enc=%d", new Object[]{Long.valueOf(j)});
        AppMethodBeat.m2505o(93201);
        return format;
    }

    /* renamed from: ti */
    public static String m3982ti(String str) {
        AppMethodBeat.m2504i(93202);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
            AppMethodBeat.m2505o(93202);
            return str;
        }
        AppMethodBeat.m2505o(93202);
        return str;
    }

    /* renamed from: tj */
    public static long m3983tj(String str) {
        AppMethodBeat.m2504i(93203);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        if (lastIndexOf > 0) {
            long anl = C5046bo.anl(str.substring(lastIndexOf + 6));
            AppMethodBeat.m2505o(93203);
            return anl;
        }
        AppMethodBeat.m2505o(93203);
        return 0;
    }

    /* renamed from: tk */
    public static String m3984tk(String str) {
        AppMethodBeat.m2504i(93204);
        int lastIndexOf = str.lastIndexOf(";?enc=");
        String trim;
        if (lastIndexOf > 0) {
            trim = str.substring(lastIndexOf + 6).trim();
            AppMethodBeat.m2505o(93204);
            return trim;
        }
        trim = "";
        AppMethodBeat.m2505o(93204);
        return trim;
    }
}
