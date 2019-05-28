package com.tencent.mm.plugin.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class c extends a {
    public final void execute(g gVar) {
        AppMethodBeat.i(18523);
        k.a("tencentloc", getClass().getClassLoader());
        AppMethodBeat.o(18523);
    }

    public final String name() {
        return "boot-load-tencentloc-library";
    }
}
