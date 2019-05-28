package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import com.facebook.internal.Utility;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;

public final class a extends com.tencent.mm.plugin.fts.a.d.a {
    public final e a(Context context, b bVar, int i) {
        AppMethodBeat.i(62040);
        com.tencent.mm.plugin.fts.ui.d.a aVar = new com.tencent.mm.plugin.fts.ui.d.a(context, bVar, i);
        AppMethodBeat.o(62040);
        return aVar;
    }

    public final int getType() {
        return Utility.DEFAULT_STREAM_BUFFER_SIZE;
    }

    public final int getPriority() {
        return BaseClientBuilder.API_PRIORITY_OTHER;
    }
}
