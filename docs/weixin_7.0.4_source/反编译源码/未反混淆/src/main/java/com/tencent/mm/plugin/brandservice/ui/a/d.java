package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(14092);
        e eVar = new e(context, bVar, i);
        AppMethodBeat.o(14092);
        return eVar;
    }

    public final int getType() {
        return 96;
    }

    public final int getPriority() {
        return 96;
    }
}
