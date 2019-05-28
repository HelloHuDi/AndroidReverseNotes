package com.tencent.mm.plugin.ext;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public at createSubCore() {
        AppMethodBeat.i(20259);
        b bVar = new b();
        AppMethodBeat.o(20259);
        return bVar;
    }

    public o createApplication() {
        AppMethodBeat.i(20260);
        a aVar = new a();
        AppMethodBeat.o(20260);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
