package com.tencent.p177mm.plugin.appbrand.p329s;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.s.r */
public final class C19721r {
    /* renamed from: Ei */
    public static String m30532Ei(String str) {
        AppMethodBeat.m2504i(91185);
        if (str == null) {
            AppMethodBeat.m2505o(91185);
            return null;
        }
        String replace = str.replace(8232, 10).replace(8233, 10);
        AppMethodBeat.m2505o(91185);
        return replace;
    }

    /* renamed from: t */
    public static boolean m30533t(String str, String str2) {
        AppMethodBeat.m2504i(91186);
        if (str == null || str.length() < 0 || str2.length() < 0) {
            AppMethodBeat.m2505o(91186);
            return false;
        } else if (str2.length() > str.length()) {
            AppMethodBeat.m2505o(91186);
            return false;
        } else if (str2.equalsIgnoreCase(str.substring(0, str2.length()))) {
            AppMethodBeat.m2505o(91186);
            return true;
        } else {
            AppMethodBeat.m2505o(91186);
            return false;
        }
    }
}
