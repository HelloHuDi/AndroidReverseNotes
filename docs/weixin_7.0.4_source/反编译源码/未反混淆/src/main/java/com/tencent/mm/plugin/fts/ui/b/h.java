package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.i;

public final class h extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62047);
        i iVar = new i(context, bVar, i);
        AppMethodBeat.o(62047);
        return iVar;
    }

    public final int getType() {
        return 64;
    }

    public final int getPriority() {
        return 64;
    }
}
