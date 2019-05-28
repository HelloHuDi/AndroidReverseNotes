package com.tencent.p177mm.plugin.webview.luggage;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.webview.luggage.o */
public final class C46420o {
    /* renamed from: C */
    public static void m87431C(Context context, Intent intent) {
        AppMethodBeat.m2504i(6223);
        if (C5046bo.isNullOrNil(intent.getStringExtra("rawUrl"))) {
            AppMethodBeat.m2505o(6223);
            return;
        }
        C25985d.m41467b(context, "game", ".luggage.LuggageGameWebViewUI", intent);
        AppMethodBeat.m2505o(6223);
    }
}
