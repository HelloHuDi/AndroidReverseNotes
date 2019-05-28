package com.tencent.mm.plugin.bottle;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.bottle.a.d;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public final class Plugin implements c {
    private b jJC = new b() {
        public final a ac(Context context, String str) {
            return null;
        }
    };

    public Plugin() {
        AppMethodBeat.i(18529);
        AppMethodBeat.o(18529);
    }

    public final o createApplication() {
        AppMethodBeat.i(18530);
        a aVar = new a();
        AppMethodBeat.o(18530);
        return aVar;
    }

    public final at createSubCore() {
        AppMethodBeat.i(18531);
        d dVar = new d();
        AppMethodBeat.o(18531);
        return dVar;
    }

    public final b getContactWidgetFactory() {
        return this.jJC;
    }
}
