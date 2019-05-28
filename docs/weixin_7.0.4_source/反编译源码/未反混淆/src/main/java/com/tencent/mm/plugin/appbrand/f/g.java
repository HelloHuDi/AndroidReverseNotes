package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class g extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(129979);
        h hVar = new h(context, bVar, i);
        AppMethodBeat.o(129979);
        return hVar;
    }

    public final int getType() {
        return 144;
    }

    public final int getPriority() {
        return 89;
    }
}
