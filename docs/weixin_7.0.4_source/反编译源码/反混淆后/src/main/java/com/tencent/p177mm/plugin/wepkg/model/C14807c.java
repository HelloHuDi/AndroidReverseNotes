package com.tencent.p177mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.wepkg.model.c */
public final class C14807c {
    public static final String uWL;

    static {
        AppMethodBeat.m2504i(63519);
        String str = C6457e.eSj;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        uWL = str + "wepkg/";
        AppMethodBeat.m2505o(63519);
    }

    public static String ahQ(String str) {
        AppMethodBeat.m2504i(63517);
        String str2;
        if (C5046bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.m2505o(63517);
            return str2;
        }
        str2 = uWL + str + "/";
        AppMethodBeat.m2505o(63517);
        return str2;
    }

    /* renamed from: hx */
    public static String m23034hx(String str, String str2) {
        AppMethodBeat.m2504i(63518);
        String str3;
        if (C5046bo.isNullOrNil(str) || C5046bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.m2505o(63518);
            return str3;
        }
        str3 = C14807c.ahQ(str) + str2;
        AppMethodBeat.m2505o(63518);
        return str3;
    }
}
