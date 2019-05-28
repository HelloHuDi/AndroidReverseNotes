package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class b extends a {
    public final e a(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        AppMethodBeat.i(62041);
        com.tencent.mm.plugin.fts.ui.d.b bVar2 = new com.tencent.mm.plugin.fts.ui.d.b(context, bVar, i);
        AppMethodBeat.o(62041);
        return bVar2;
    }

    public final int getType() {
        return 4128;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
