package com.tencent.mm.ipcinvoker.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.a.a;

public final class b {
    private static a eGG = new a();

    static {
        AppMethodBeat.i(114128);
        AppMethodBeat.o(114128);
    }

    public static boolean b(a aVar) {
        if (aVar == null) {
            return false;
        }
        eGG = aVar;
        return true;
    }

    public static void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(114124);
        eGG.a(4, str, str2, objArr);
        AppMethodBeat.o(114124);
    }

    public static void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(114125);
        eGG.a(6, str, str2, objArr);
        AppMethodBeat.o(114125);
    }

    public static void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(114126);
        eGG.a(5, str, str2, objArr);
        AppMethodBeat.o(114126);
    }

    public static void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(114127);
        eGG.a(3, str, str2, objArr);
        AppMethodBeat.o(114127);
    }
}
