package com.tencent.mm.plugin.traceroute;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.traceroute.a.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(25971);
        a aVar = new a();
        AppMethodBeat.o(25971);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        return null;
    }
}
