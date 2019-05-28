package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class c extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62042);
        com.tencent.mm.plugin.fts.ui.d.c cVar = new com.tencent.mm.plugin.fts.ui.d.c(context, bVar, i);
        AppMethodBeat.o(62042);
        return cVar;
    }

    public final int getType() {
        return 48;
    }

    public final int getPriority() {
        return 48;
    }
}
