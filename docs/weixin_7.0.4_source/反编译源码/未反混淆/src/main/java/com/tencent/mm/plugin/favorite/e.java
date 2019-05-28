package com.tencent.mm.plugin.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.af.j.b;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.model.o;
import com.tencent.mm.pluginsdk.ui.applet.q;
import com.tencent.mm.pluginsdk.ui.tools.a;

public final class e implements ab {
    public final int a(WXMediaMessage wXMediaMessage, String str, String str2, String str3) {
        AppMethodBeat.i(20527);
        int a = l.a(wXMediaMessage, str, str2, str3, 3, null);
        AppMethodBeat.o(20527);
        return a;
    }

    public final int a(b bVar, WXMediaMessage wXMediaMessage, String str) {
        AppMethodBeat.i(20528);
        int a = l.a(bVar, wXMediaMessage, str);
        AppMethodBeat.o(20528);
        return a;
    }

    public final void a(Activity activity, String str, String str2) {
        AppMethodBeat.i(20529);
        a.a(activity, str, str2, 2);
        AppMethodBeat.o(20529);
    }

    public final void b(Activity activity, int i, int i2, Intent intent) {
        AppMethodBeat.i(20530);
        a.a(activity, i, i2, intent, true, R.string.d7m, R.string.d7n, 2);
        AppMethodBeat.o(20530);
    }

    public final int LU(String str) {
        AppMethodBeat.i(20531);
        int aiD = o.aiD(str);
        AppMethodBeat.o(20531);
        return aiD;
    }

    public final void a(Context context, String str, g gVar, boolean z, q.a aVar) {
        AppMethodBeat.i(20532);
        com.tencent.mm.pluginsdk.ui.applet.g.a aVar2 = new com.tencent.mm.pluginsdk.ui.applet.g.a(context);
        aVar2.cx(str);
        d.a(aVar2, context, gVar);
        d.b(aVar2, context, gVar);
        aVar2.h(Boolean.valueOf(z)).KQ(R.string.tf).a(aVar).gud.show();
        AppMethodBeat.o(20532);
    }
}
