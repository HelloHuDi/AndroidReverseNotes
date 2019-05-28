package com.tencent.mm.plugin.fav.ui.b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class b extends a {
    public final e a(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        AppMethodBeat.i(74499);
        c cVar = new c(context, bVar, i);
        AppMethodBeat.o(74499);
        return cVar;
    }

    public final int getType() {
        return 4192;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
