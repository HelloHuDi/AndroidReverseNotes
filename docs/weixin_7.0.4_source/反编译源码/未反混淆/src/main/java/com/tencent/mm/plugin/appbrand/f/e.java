package com.tencent.mm.plugin.appbrand.f;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class e extends a {
    public final com.tencent.mm.plugin.fts.a.d.e a(Context context, b bVar, int i) {
        AppMethodBeat.i(129975);
        f fVar = new f(context, bVar, i);
        AppMethodBeat.o(129975);
        return fVar;
    }

    public final int getType() {
        return 4224;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
