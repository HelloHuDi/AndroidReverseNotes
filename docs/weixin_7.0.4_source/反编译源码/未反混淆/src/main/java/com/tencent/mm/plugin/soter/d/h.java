package com.tencent.mm.plugin.soter.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.soter.core.c.c;

public final class h implements c {
    public final void v(String str, String str2, Object... objArr) {
        AppMethodBeat.i(59337);
        ab.v(str, str2, objArr);
        AppMethodBeat.o(59337);
    }

    public final void d(String str, String str2, Object... objArr) {
        AppMethodBeat.i(59338);
        ab.d(str, str2, objArr);
        AppMethodBeat.o(59338);
    }

    public final void i(String str, String str2, Object... objArr) {
        AppMethodBeat.i(59339);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(59339);
    }

    public final void w(String str, String str2, Object... objArr) {
        AppMethodBeat.i(59340);
        ab.w(str, str2, objArr);
        AppMethodBeat.o(59340);
    }

    public final void e(String str, String str2, Object... objArr) {
        AppMethodBeat.i(59341);
        ab.e(str, str2, objArr);
        AppMethodBeat.o(59341);
    }

    public final void a(String str, Throwable th, String str2) {
        AppMethodBeat.i(59342);
        ab.printErrStackTrace(str, th, str2, new Object[0]);
        AppMethodBeat.o(59342);
    }
}
