package com.tencent.mm.plugin.extqlauncher;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public at createSubCore() {
        AppMethodBeat.i(20471);
        b bVar = new b();
        AppMethodBeat.o(20471);
        return bVar;
    }

    public o createApplication() {
        AppMethodBeat.i(20472);
        a aVar = new a();
        AppMethodBeat.o(20472);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }
}
