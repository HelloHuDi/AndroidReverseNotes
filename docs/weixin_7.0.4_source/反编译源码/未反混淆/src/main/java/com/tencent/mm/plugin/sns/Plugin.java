package com.tencent.mm.plugin.sns;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    public o createApplication() {
        AppMethodBeat.i(35612);
        a aVar = new a();
        AppMethodBeat.o(35612);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        return null;
    }
}
