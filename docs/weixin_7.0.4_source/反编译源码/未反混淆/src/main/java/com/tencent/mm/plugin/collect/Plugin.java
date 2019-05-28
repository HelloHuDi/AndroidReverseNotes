package com.tencent.mm.plugin.collect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.collect.a.a;
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
        AppMethodBeat.i(40905);
        a aVar = new a();
        AppMethodBeat.o(40905);
        return aVar;
    }
}
