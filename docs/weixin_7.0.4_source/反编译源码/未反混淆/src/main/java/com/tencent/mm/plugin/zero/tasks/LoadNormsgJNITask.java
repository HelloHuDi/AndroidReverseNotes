package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class LoadNormsgJNITask extends a {
    public final void execute(g gVar) {
        AppMethodBeat.i(58780);
        k.a("stlport_shared", getClass().getClassLoader());
        k.a("wechatxlog", getClass().getClassLoader());
        k.a("wechatnormsg", getClass().getClassLoader());
        AppMethodBeat.o(58780);
    }

    public final String name() {
        return "boot-load-wechatnormsg-library";
    }
}
