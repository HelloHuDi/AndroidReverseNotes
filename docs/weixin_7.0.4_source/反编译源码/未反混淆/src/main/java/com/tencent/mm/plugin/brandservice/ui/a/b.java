package com.tencent.mm.plugin.brandservice.ui.a;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;

public final class b extends a {
    public final e a(Context context, com.tencent.mm.plugin.fts.a.d.e.b bVar, int i) {
        AppMethodBeat.i(14087);
        c cVar = new c(context, bVar, i);
        AppMethodBeat.o(14087);
        return cVar;
    }

    public final int getType() {
        return 4208;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
