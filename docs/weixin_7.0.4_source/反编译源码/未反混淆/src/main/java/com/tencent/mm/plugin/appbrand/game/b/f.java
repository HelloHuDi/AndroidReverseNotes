package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class f extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(130087);
        g gVar = new g(context, bVar, i);
        AppMethodBeat.o(130087);
        return gVar;
    }

    public final int getType() {
        return 208;
    }

    public final int getPriority() {
        return 73;
    }
}
