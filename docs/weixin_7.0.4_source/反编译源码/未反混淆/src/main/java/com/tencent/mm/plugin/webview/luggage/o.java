package com.tencent.mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bp.d;
import com.tencent.mm.sdk.platformtools.bo;

public final class o {
    public static void C(Context context, Intent intent) {
        AppMethodBeat.i(6223);
        if (bo.isNullOrNil(intent.getStringExtra("rawUrl"))) {
            AppMethodBeat.o(6223);
            return;
        }
        d.b(context, "game", ".luggage.LuggageGameWebViewUI", intent);
        AppMethodBeat.o(6223);
    }
}
