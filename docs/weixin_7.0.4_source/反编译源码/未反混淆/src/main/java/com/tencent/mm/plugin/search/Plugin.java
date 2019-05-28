package com.tencent.mm.plugin.search;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.search.a.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(24398);
        a aVar = new a();
        AppMethodBeat.o(24398);
        return aVar;
    }

    public final at createSubCore() {
        AppMethodBeat.i(24399);
        b bVar = new b();
        AppMethodBeat.o(24399);
        return bVar;
    }

    public final com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }
}
