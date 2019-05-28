package com.tencent.mm.plugin.auto;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(17099);
        a aVar = new a();
        AppMethodBeat.o(17099);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(17100);
        com.tencent.mm.plugin.auto.a.b bVar = new com.tencent.mm.plugin.auto.a.b();
        AppMethodBeat.o(17100);
        return bVar;
    }
}
