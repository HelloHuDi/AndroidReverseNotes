package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62043);
        com.tencent.mm.plugin.fts.ui.d.d dVar = new com.tencent.mm.plugin.fts.ui.d.d(context, bVar, i);
        AppMethodBeat.o(62043);
        return dVar;
    }

    public final int getType() {
        return 4112;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
