package com.tencent.mm.plugin.game.luggage.c.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.luggage.d;
import com.tencent.mm.protocal.protobuf.bbb;

public final class i extends a {
    public i() {
        super(7);
    }

    public final void a(Context context, d dVar, bbb bbb) {
        AppMethodBeat.i(135909);
        if (dVar.getWebView() != null) {
            dVar.getWebView().reload();
        }
        AppMethodBeat.o(135909);
    }
}
