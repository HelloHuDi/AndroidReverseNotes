package com.tencent.mm.plugin.nearlife;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.nearlife.a.a;
import com.tencent.mm.plugin.nearlife.b.d;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(22921);
        a aVar = new a();
        AppMethodBeat.o(22921);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(22922);
        d dVar = new d();
        AppMethodBeat.o(22922);
        return dVar;
    }
}
