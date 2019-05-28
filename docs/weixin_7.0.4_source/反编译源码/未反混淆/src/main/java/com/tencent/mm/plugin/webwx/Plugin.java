package com.tencent.mm.plugin.webwx;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.webwx.a.g;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(26478);
        a aVar = new a();
        AppMethodBeat.o(26478);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(26479);
        g gVar = new g();
        AppMethodBeat.o(26479);
        return gVar;
    }
}
