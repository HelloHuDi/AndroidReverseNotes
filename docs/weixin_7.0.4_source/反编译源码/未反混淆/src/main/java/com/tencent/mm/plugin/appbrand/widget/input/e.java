package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.r.i;
import java.util.Set;

public final class e {
    private static final i<u, aa> jdy = new i();

    public interface a {
        boolean a(aa aaVar);
    }

    static {
        AppMethodBeat.i(123598);
        AppMethodBeat.o(123598);
    }

    public static void a(u uVar, aa aaVar) {
        AppMethodBeat.i(123595);
        jdy.f(uVar, aaVar);
        AppMethodBeat.o(123595);
    }

    public static void t(u uVar) {
        AppMethodBeat.i(123596);
        jdy.bD(uVar);
        AppMethodBeat.o(123596);
    }

    public static aa a(u uVar, a aVar) {
        AppMethodBeat.i(123597);
        if (uVar == null) {
            AppMethodBeat.o(123597);
            return null;
        }
        Set<aa> bC = jdy.bC(uVar);
        if (bC != null) {
            for (aa aaVar : bC) {
                if (aaVar != null && aVar.a(aaVar)) {
                    AppMethodBeat.o(123597);
                    return aaVar;
                }
            }
        }
        AppMethodBeat.o(123597);
        return null;
    }
}
