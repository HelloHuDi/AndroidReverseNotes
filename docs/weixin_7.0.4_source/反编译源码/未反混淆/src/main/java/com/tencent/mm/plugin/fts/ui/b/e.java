package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class e extends a {
    public final com.tencent.mm.plugin.fts.a.d.e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62044);
        com.tencent.mm.plugin.fts.ui.d.e eVar = new com.tencent.mm.plugin.fts.ui.d.e(context, bVar, i);
        AppMethodBeat.o(62044);
        return eVar;
    }

    public final int getType() {
        return 32;
    }

    public final int getPriority() {
        return 32;
    }
}
