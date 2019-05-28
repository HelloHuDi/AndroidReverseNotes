package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;

public final class b extends a {
    public final void execute(g gVar) {
        AppMethodBeat.i(58786);
        k.a("commonimgdec", getClass().getClassLoader());
        k.a("wechatcommon", getClass().getClassLoader());
        AppMethodBeat.o(58786);
    }

    public final String name() {
        return "boot-load-wechatcommon-library";
    }
}
