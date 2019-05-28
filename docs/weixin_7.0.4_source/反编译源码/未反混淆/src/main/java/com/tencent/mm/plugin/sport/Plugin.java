package com.tencent.mm.plugin.sport;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(25133);
        c cVar = new c();
        AppMethodBeat.o(25133);
        return cVar;
    }

    public b getContactWidgetFactory() {
        AppMethodBeat.i(25134);
        com.tencent.mm.plugin.sport.ui.a.b bVar = new com.tencent.mm.plugin.sport.ui.a.b();
        AppMethodBeat.o(25134);
        return bVar;
    }

    public at createSubCore() {
        AppMethodBeat.i(25135);
        com.tencent.mm.plugin.sport.model.o oVar = new com.tencent.mm.plugin.sport.model.o();
        AppMethodBeat.o(25135);
        return oVar;
    }
}
