package com.tencent.mm.plugin.brandservice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(13800);
        b bVar = new b();
        AppMethodBeat.o(13800);
        return bVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        return null;
    }
}
