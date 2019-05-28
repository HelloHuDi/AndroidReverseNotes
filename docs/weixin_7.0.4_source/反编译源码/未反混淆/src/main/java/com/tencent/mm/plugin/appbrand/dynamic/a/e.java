package com.tencent.mm.plugin.appbrand.dynamic.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.l;
import com.tencent.mm.plugin.appbrand.appcache.j.a;
import com.tencent.mm.plugin.appbrand.dynamic.WxaWidgetInitializer;
import com.tencent.mm.plugin.appbrand.dynamic.debugger.b;
import com.tencent.mm.plugin.appbrand.dynamic.ui.WxaWidgetDebugUI;

public final class e implements l {
    boolean hmn;

    public final void e(Context context, Bundle bundle) {
        AppMethodBeat.i(10761);
        Intent intent = new Intent(context, WxaWidgetDebugUI.class);
        String bL = WxaWidgetInitializer.bL(bundle.getString("app_id"), bundle.getString("msg_id"));
        intent.putExtras(bundle);
        intent.putExtra("id", bL);
        context.startActivity(intent);
        AppMethodBeat.o(10761);
    }

    public final void bT(Context context) {
        AppMethodBeat.i(10762);
        com.tencent.mm.plugin.appbrand.wxawidget.console.e.dr(context);
        AppMethodBeat.o(10762);
    }

    public final boolean kR(int i) {
        AppMethodBeat.i(10763);
        boolean kR = a.kR(i);
        AppMethodBeat.o(10763);
        return kR;
    }

    public final boolean a(String str, l.a aVar) {
        AppMethodBeat.i(10764);
        boolean c = b.c(str, aVar);
        AppMethodBeat.o(10764);
        return c;
    }

    public final boolean b(String str, l.a aVar) {
        AppMethodBeat.i(10765);
        boolean d = b.d(str, aVar);
        AppMethodBeat.o(10765);
        return d;
    }

    public final void cA(boolean z) {
        this.hmn = z;
    }

    public final boolean abE() {
        return this.hmn;
    }

    public final boolean abF() {
        AppMethodBeat.i(10766);
        boolean dnO = com.tencent.mm.sdk.a.b.dnO();
        AppMethodBeat.o(10766);
        return dnO;
    }
}
