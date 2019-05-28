package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.h;

public final class g extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62046);
        h hVar = new h(context, bVar, i);
        AppMethodBeat.o(62046);
        return hVar;
    }

    public final int getType() {
        return 4160;
    }

    public final int getPriority() {
        return 64;
    }
}
