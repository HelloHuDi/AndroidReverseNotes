package com.tencent.mm.plugin.wenote;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(26583);
        a aVar = new a();
        AppMethodBeat.o(26583);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(26584);
        com.tencent.mm.plugin.wenote.model.c cVar = new com.tencent.mm.plugin.wenote.model.c();
        AppMethodBeat.o(26584);
        return cVar;
    }
}
