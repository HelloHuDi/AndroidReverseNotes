package com.tencent.mm.plugin.radar;

import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

@l(dWo = {1, 1, 13}, dWp = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, dWq = {"Lcom/tencent/mm/plugin/radar/Plugin;", "Lcom/tencent/mm/pluginsdk/deprecated/IPlugin;", "()V", "createApplication", "Lcom/tencent/mm/pluginsdk/IPluginApplication;", "createSubCore", "Lcom/tencent/mm/model/ISubCore;", "getContactWidgetFactory", "Lcom/tencent/mm/pluginsdk/deprecated/IContactWidgetFactory;", "plugin-radar_release"})
public final class Plugin implements c {
    public final o createApplication() {
        AppMethodBeat.i(102844);
        o aVar = new a();
        AppMethodBeat.o(102844);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return null;
    }

    public final at createSubCore() {
        AppMethodBeat.i(102845);
        at bVar = new b();
        AppMethodBeat.o(102845);
        return bVar;
    }
}
