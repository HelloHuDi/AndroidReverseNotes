package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class f extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62045);
        com.tencent.mm.plugin.fts.ui.d.f fVar = new com.tencent.mm.plugin.fts.ui.d.f(context, bVar, i);
        AppMethodBeat.o(62045);
        return fVar;
    }

    public final int getType() {
        return 160;
    }

    public final int getPriority() {
        return 4096;
    }
}
