package com.tencent.mm.plugin.qmessage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.qmessage.a.g;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    private b jJC = new b() {
        public final a ac(Context context, String str) {
            AppMethodBeat.i(24063);
            if ("widget_type_contact".equals(str)) {
                com.tencent.mm.plugin.qmessage.ui.a aVar = new com.tencent.mm.plugin.qmessage.ui.a(context);
                AppMethodBeat.o(24063);
                return aVar;
            }
            a bVar = new com.tencent.mm.plugin.qmessage.ui.b(context);
            AppMethodBeat.o(24063);
            return bVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(24064);
        AppMethodBeat.o(24064);
    }

    public o createApplication() {
        AppMethodBeat.i(24065);
        a aVar = new a();
        AppMethodBeat.o(24065);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return this.jJC;
    }

    public at createSubCore() {
        AppMethodBeat.i(24066);
        g gVar = new g();
        AppMethodBeat.o(24066);
        return gVar;
    }
}
