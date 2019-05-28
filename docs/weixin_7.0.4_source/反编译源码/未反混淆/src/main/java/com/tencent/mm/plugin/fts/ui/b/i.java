package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.j;

public final class i extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62048);
        j jVar = new j(context, bVar, i);
        AppMethodBeat.o(62048);
        return jVar;
    }

    public final int getType() {
        return 4176;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
