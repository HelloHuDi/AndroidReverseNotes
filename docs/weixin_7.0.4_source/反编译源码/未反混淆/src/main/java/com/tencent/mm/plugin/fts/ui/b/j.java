package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.k;

public final class j extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62049);
        k kVar = new k(context, bVar, i);
        AppMethodBeat.o(62049);
        return kVar;
    }

    public final int getType() {
        return 112;
    }

    public final int getPriority() {
        return 112;
    }
}
