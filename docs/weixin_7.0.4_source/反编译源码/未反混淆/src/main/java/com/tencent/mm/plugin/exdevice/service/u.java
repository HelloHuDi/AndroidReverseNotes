package com.tencent.mm.plugin.exdevice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.exdevice.model.c;

public final class u {
    private static u lwO = null;
    private c lwP;
    private f lwQ;

    private static u bpw() {
        AppMethodBeat.i(19626);
        if (lwO == null) {
            lwO = new u();
        }
        u uVar = lwO;
        AppMethodBeat.o(19626);
        return uVar;
    }

    public static f bpx() {
        AppMethodBeat.i(19627);
        if (bpw().lwQ == null) {
            bpw().lwQ = new f();
        }
        f fVar = bpw().lwQ;
        AppMethodBeat.o(19627);
        return fVar;
    }

    public static void a(m mVar) {
        AppMethodBeat.i(19628);
        bpy().lqX = mVar;
        AppMethodBeat.o(19628);
    }

    public static c bpy() {
        AppMethodBeat.i(19629);
        if (bpw().lwP == null) {
            bpw().lwP = c.boB();
        }
        c cVar = bpw().lwP;
        AppMethodBeat.o(19629);
        return cVar;
    }
}
