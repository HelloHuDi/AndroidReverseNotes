package com.tencent.mm.plugin.sandbox;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(24379);
        a aVar = new a();
        AppMethodBeat.o(24379);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(24380);
        SubCoreSandBox subCoreSandBox = new SubCoreSandBox();
        AppMethodBeat.o(24380);
        return subCoreSandBox;
    }
}
