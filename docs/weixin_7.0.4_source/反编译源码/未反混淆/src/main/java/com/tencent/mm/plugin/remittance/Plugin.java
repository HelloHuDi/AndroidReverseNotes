package com.tencent.mm.plugin.remittance;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        return null;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(44421);
        com.tencent.mm.plugin.remittance.a.c cVar = new com.tencent.mm.plugin.remittance.a.c();
        AppMethodBeat.o(44421);
        return cVar;
    }
}
