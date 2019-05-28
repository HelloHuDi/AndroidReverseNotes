package com.tencent.mm.plugin.qqmail;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.qqmail.a.a;
import com.tencent.mm.plugin.qqmail.b.ac;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    private a ptm = new a();

    public Plugin() {
        AppMethodBeat.i(67898);
        AppMethodBeat.o(67898);
    }

    public final o createApplication() {
        AppMethodBeat.i(67899);
        a aVar = new a();
        AppMethodBeat.o(67899);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return this.ptm;
    }

    public final at createSubCore() {
        AppMethodBeat.i(67900);
        ac acVar = new ac();
        AppMethodBeat.o(67900);
        return acVar;
    }
}
