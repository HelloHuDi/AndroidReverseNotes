package com.tencent.mm.plugin.backup;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(17111);
        a aVar = new a();
        AppMethodBeat.o(17111);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        return null;
    }
}
