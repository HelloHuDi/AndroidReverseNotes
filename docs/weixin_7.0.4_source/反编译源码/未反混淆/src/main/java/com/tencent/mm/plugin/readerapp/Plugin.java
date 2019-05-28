package com.tencent.mm.plugin.readerapp;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;
import com.tencent.mm.sdk.platformtools.ab;

public final class Plugin implements c {
    private b jJC = new b() {
        public final a ac(Context context, String str) {
            AppMethodBeat.i(76736);
            ab.i("MicroMsg.ReaderApp.Plugin", "create contact widget type[%s]", str);
            if ("widget_type_news".equals(str)) {
                com.tencent.mm.plugin.readerapp.ui.b bVar = new com.tencent.mm.plugin.readerapp.ui.b(context);
                AppMethodBeat.o(76736);
                return bVar;
            }
            AppMethodBeat.o(76736);
            return null;
        }
    };

    public Plugin() {
        AppMethodBeat.i(76737);
        AppMethodBeat.o(76737);
    }

    public final o createApplication() {
        AppMethodBeat.i(76738);
        com.tencent.mm.plugin.readerapp.b.a aVar = new com.tencent.mm.plugin.readerapp.b.a();
        AppMethodBeat.o(76738);
        return aVar;
    }

    public final b getContactWidgetFactory() {
        return this.jJC;
    }

    public final at createSubCore() {
        return null;
    }
}
