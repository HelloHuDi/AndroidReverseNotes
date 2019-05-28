package com.tencent.mm.plugin.voip_cs;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        return null;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(135281);
        com.tencent.mm.plugin.voip_cs.b.c cVar = new com.tencent.mm.plugin.voip_cs.b.c();
        AppMethodBeat.o(135281);
        return cVar;
    }
}
