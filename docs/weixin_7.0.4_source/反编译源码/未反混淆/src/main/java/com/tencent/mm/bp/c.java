package com.tencent.mm.bp;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.model.q;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;

public final class c {
    public static n vwA;
    public static m vwB;

    public static void aks(String str) {
        AppMethodBeat.i(114682);
        if (((h) g.RM().Rn()).SG()) {
            d.a(str, vwA, vwB);
        }
        AppMethodBeat.o(114682);
    }

    public static void b(final String str, final q qVar) {
        AppMethodBeat.i(114683);
        new a() {
            public final void execute(com.tencent.mm.kernel.b.g gVar) {
                AppMethodBeat.i(114680);
                String str = str;
                q qVar = qVar;
                d.a(str, c.vwA, c.vwB);
                if (qVar == null) {
                    qVar = new q(c.akt(str));
                }
                q.a("plugin.".concat(String.valueOf(str)), qVar);
                AppMethodBeat.o(114680);
            }
        }.alone();
        AppMethodBeat.o(114683);
    }

    public static q.a akt(final String str) {
        AppMethodBeat.i(114684);
        ab.i("MicroMsg.PluginCompatHelper", "CompatSubCore creator %s for plugin %s", new q.a() {
            public final at createSubCore() {
                AppMethodBeat.i(114681);
                at akv = d.akv(str);
                AppMethodBeat.o(114681);
                return akv;
            }
        }, str);
        AppMethodBeat.o(114684);
        return /* anonymous class already generated */;
    }
}
