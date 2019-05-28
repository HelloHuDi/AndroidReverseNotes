package com.tencent.mm.plugin.nearby;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.nearby.a.f;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    private b jJC = new b() {
        public final a ac(Context context, String str) {
            AppMethodBeat.i(55348);
            com.tencent.mm.plugin.nearby.ui.a aVar = new com.tencent.mm.plugin.nearby.ui.a(context);
            AppMethodBeat.o(55348);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(55349);
        AppMethodBeat.o(55349);
    }

    public o createApplication() {
        AppMethodBeat.i(55350);
        a aVar = new a();
        AppMethodBeat.o(55350);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return this.jJC;
    }

    public at createSubCore() {
        AppMethodBeat.i(55351);
        f fVar = new f();
        AppMethodBeat.o(55351);
        return fVar;
    }
}
