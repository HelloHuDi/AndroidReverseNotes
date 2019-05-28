package com.tencent.p177mm.opensdk.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.opensdk.utils.d */
public final class C18754d {
    /* renamed from: a */
    public static boolean m29304a(int i) {
        return i == 36 || i == 46;
    }

    /* renamed from: b */
    public static boolean m29305b(String str) {
        AppMethodBeat.m2504i(128074);
        if (str == null || str.length() <= 0) {
            AppMethodBeat.m2505o(128074);
            return true;
        }
        AppMethodBeat.m2505o(128074);
        return false;
    }

    /* renamed from: c */
    public static int m29306c(String str) {
        int i = 0;
        AppMethodBeat.m2504i(128075);
        if (str != null) {
            try {
                if (str.length() > 0) {
                    i = Integer.parseInt(str);
                    AppMethodBeat.m2505o(128075);
                    return i;
                }
            } catch (Exception e) {
                AppMethodBeat.m2505o(128075);
            }
        }
        AppMethodBeat.m2505o(128075);
        return i;
    }
}
