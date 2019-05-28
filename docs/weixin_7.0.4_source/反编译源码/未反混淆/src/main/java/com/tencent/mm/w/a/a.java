package com.tencent.mm.w.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class a extends com.tencent.mm.plugin.fts.a.d.a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(124492);
        b bVar2 = new b(context, bVar, i);
        AppMethodBeat.o(124492);
        return bVar2;
    }

    public final int getType() {
        return 33;
    }

    public final int getPriority() {
        return 33;
    }
}
