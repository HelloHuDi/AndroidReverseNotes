package com.tencent.mm.plugin.appbrand.game.c;

import com.tencent.magicbrush.a.b;
import com.tencent.magicbrush.a.c.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public final class d {
    static {
        AppMethodBeat.i(130149);
        long yz = bo.yz();
        b.yB();
        long yz2 = bo.yz();
        b.loadLibrary("gamelog_delegate");
        ab.i("MicroMsg.MBLogDelegateRegistry", "dl: load magicbrush & gamelog_delegate cost = [%d]ms magicbrush cost [%d]ms", Long.valueOf(bo.az(yz)), Long.valueOf(yz2 - yz));
        AppMethodBeat.o(130149);
    }

    public static void axy() {
        AppMethodBeat.i(130148);
        c.a(new com.tencent.magicbrush.a.c.b() {
            public final void v(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130142);
                ab.v(str, str2, objArr);
                AppMethodBeat.o(130142);
            }

            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130143);
                ab.d(str, str2, objArr);
                AppMethodBeat.o(130143);
            }

            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130144);
                ab.i(str, str2, objArr);
                AppMethodBeat.o(130144);
            }

            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130145);
                ab.w(str, str2, objArr);
                AppMethodBeat.o(130145);
            }

            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(130146);
                ab.e(str, str2, objArr);
                AppMethodBeat.o(130146);
            }

            public final void a(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(130147);
                ab.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(130147);
            }
        });
        AppMethodBeat.o(130148);
    }
}
