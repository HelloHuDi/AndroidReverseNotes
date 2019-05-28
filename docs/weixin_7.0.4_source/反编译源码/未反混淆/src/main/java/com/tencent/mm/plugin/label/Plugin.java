package com.tencent.mm.plugin.label;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(22509);
        a aVar = new a();
        AppMethodBeat.o(22509);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(22510);
        e eVar = new e();
        AppMethodBeat.o(22510);
        return eVar;
    }
}
