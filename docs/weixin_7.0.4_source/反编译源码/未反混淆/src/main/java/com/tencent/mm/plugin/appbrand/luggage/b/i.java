package com.tencent.mm.plugin.appbrand.luggage.b;

import android.content.Context;
import com.tencent.luggage.c.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.b.b;
import com.tencent.mm.plugin.appbrand.widget.b.d;
import com.tencent.mm.plugin.appbrand.widget.b.j;

public final class i implements a {
    public final j av(Context context) {
        AppMethodBeat.i(132102);
        d dVar = new d(context);
        dVar.setCancelable(false);
        AppMethodBeat.o(132102);
        return dVar;
    }

    public final void a(j jVar) {
        AppMethodBeat.i(132103);
        if (jVar instanceof b) {
            ((b) jVar).dismiss();
        }
        AppMethodBeat.o(132103);
    }
}
