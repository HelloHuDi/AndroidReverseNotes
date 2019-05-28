package com.tencent.mm.plugin.notification;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.notification.d.f;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    a oVv = new a();

    public Plugin() {
        AppMethodBeat.i(23097);
        AppMethodBeat.o(23097);
    }

    public o createApplication() {
        return this.oVv;
    }

    public b getContactWidgetFactory() {
        return null;
    }

    public at createSubCore() {
        AppMethodBeat.i(23098);
        f bWP = f.bWP();
        AppMethodBeat.o(23098);
        return bWP;
    }
}
