package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class d extends a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(130083);
        e eVar = new e(context, bVar, i);
        AppMethodBeat.o(130083);
        return eVar;
    }

    public final int getType() {
        return 4240;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
