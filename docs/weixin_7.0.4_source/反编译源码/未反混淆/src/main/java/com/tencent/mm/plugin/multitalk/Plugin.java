package com.tencent.mm.plugin.multitalk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.multitalk.model.p;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        return null;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(53878);
        p pVar = new p();
        AppMethodBeat.o(53878);
        return pVar;
    }
}
