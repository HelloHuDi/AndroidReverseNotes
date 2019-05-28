package com.tencent.mm.plugin.shake;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.at;
import com.tencent.mm.plugin.shake.b.m;
import com.tencent.mm.pluginsdk.b.a;
import com.tencent.mm.pluginsdk.b.b;
import com.tencent.mm.pluginsdk.b.c;
import com.tencent.mm.pluginsdk.o;

public class Plugin implements c {
    private b qrp = new b() {
        public final a ac(Context context, String str) {
            AppMethodBeat.i(24407);
            com.tencent.mm.plugin.shake.ui.a aVar = new com.tencent.mm.plugin.shake.ui.a(context);
            AppMethodBeat.o(24407);
            return aVar;
        }
    };

    public Plugin() {
        AppMethodBeat.i(24408);
        AppMethodBeat.o(24408);
    }

    public o createApplication() {
        AppMethodBeat.i(24409);
        a aVar = new a();
        AppMethodBeat.o(24409);
        return aVar;
    }

    public b getContactWidgetFactory() {
        return this.qrp;
    }

    public at createSubCore() {
        AppMethodBeat.i(24410);
        m mVar = new m();
        AppMethodBeat.o(24410);
        return mVar;
    }
}
