package com.tencent.mm.plugin.pwdgroup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(23972);
        a aVar = new a();
        AppMethodBeat.o(23972);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(23973);
        c cVar = new c();
        AppMethodBeat.o(23973);
        return cVar;
    }
}
