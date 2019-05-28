package com.tencent.mm.plugin.wepkg.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.sdk.platformtools.bo;

public final class c {
    public static final String uWL;

    static {
        AppMethodBeat.i(63519);
        String str = e.eSj;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        uWL = str + "wepkg/";
        AppMethodBeat.o(63519);
    }

    public static String ahQ(String str) {
        AppMethodBeat.i(63517);
        String str2;
        if (bo.isNullOrNil(str)) {
            str2 = "";
            AppMethodBeat.o(63517);
            return str2;
        }
        str2 = uWL + str + "/";
        AppMethodBeat.o(63517);
        return str2;
    }

    public static String hx(String str, String str2) {
        AppMethodBeat.i(63518);
        String str3;
        if (bo.isNullOrNil(str) || bo.isNullOrNil(str2)) {
            str3 = "";
            AppMethodBeat.o(63518);
            return str3;
        }
        str3 = ahQ(str) + str2;
        AppMethodBeat.o(63518);
        return str3;
    }
}
