package com.tencent.mm.plugin.masssend;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.masssend.a.h;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    private b jJC = new b() {
        public final a ac(Context context, String str) {
            AppMethodBeat.i(22717);
            com.tencent.mm.plugin.masssend.ui.a aVar = new com.tencent.mm.plugin.masssend.ui.a(context);
            AppMethodBeat.o(22717);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(22718);
        AppMethodBeat.o(22718);
    }

    public o createApplication() {
        AppMethodBeat.i(22719);
        a aVar = new a();
        AppMethodBeat.o(22719);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return this.jJC;
    }

    public at createSubCore() {
        AppMethodBeat.i(22720);
        h hVar = new h();
        AppMethodBeat.o(22720);
        return hVar;
    }
}
