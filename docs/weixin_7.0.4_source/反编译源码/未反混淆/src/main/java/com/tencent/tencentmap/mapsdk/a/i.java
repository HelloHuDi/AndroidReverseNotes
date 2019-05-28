package com.tencent.tencentmap.mapsdk.a;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class i {
    private static Boolean a = Boolean.FALSE;

    public static void a(String str, String str2) {
        AppMethodBeat.i(101227);
        a(str, str2, 'v');
        AppMethodBeat.o(101227);
    }

    public static void a(String str) {
        AppMethodBeat.i(101228);
        a(null, str, 'e');
        AppMethodBeat.o(101228);
    }

    private static void a(String str, String str2, char c) {
        AppMethodBeat.i(101229);
        if (a.booleanValue()) {
            TextUtils.isEmpty(str);
            AppMethodBeat.o(101229);
            return;
        }
        AppMethodBeat.o(101229);
    }
}
