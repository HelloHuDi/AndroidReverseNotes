package com.tencent.mm.plugin.music;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.music.model.b;
import com.tencent.mm.plugin.music.model.e;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(104807);
        b bVar = new b();
        AppMethodBeat.o(104807);
        return bVar;
    }

    public com.tencent.mm.pluginsdk.b.b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(104808);
        e eVar = new e();
        AppMethodBeat.o(104808);
        return eVar;
    }
}
