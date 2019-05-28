package com.tencent.mm.plugin.profile;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class Plugin implements c {
    public Plugin() {
        AppMethodBeat.i(23239);
        ab.i("MicroMsg.Plugin.profile", "profile constructor " + System.currentTimeMillis());
        AppMethodBeat.o(23239);
    }

    public final o createApplication() {
        AppMethodBeat.i(23240);
        ab.i("MicroMsg.Plugin.profile", "profile createApplication " + System.currentTimeMillis());
        b bVar = new b();
        AppMethodBeat.o(23240);
        return bVar;
    }

    public final b getContactWidgetFactory() {
        AppMethodBeat.i(23241);
        ab.i("MicroMsg.Plugin.profile", "profile getContactWidgetFactory " + System.currentTimeMillis());
        AppMethodBeat.o(23241);
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(23242);
        ab.i("MicroMsg.Plugin.profile", "profile createSubCore " + System.currentTimeMillis());
        c cVar = new c();
        AppMethodBeat.o(23242);
        return cVar;
    }
}
