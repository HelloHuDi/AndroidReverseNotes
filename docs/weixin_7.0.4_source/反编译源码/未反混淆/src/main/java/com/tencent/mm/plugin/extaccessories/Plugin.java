package com.tencent.mm.plugin.extaccessories;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(20461);
        a aVar = new a();
        AppMethodBeat.o(20461);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(20462);
        b bVar = new b();
        AppMethodBeat.o(20462);
        return bVar;
    }
}
