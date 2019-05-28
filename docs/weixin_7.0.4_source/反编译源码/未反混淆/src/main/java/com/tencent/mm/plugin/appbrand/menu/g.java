package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.d;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.bp;
import com.tencent.mm.ui.base.l;
import org.json.JSONObject;

public final class g extends a {
    g() {
        super(o.Exit.ordinal());
        AppMethodBeat.i(132211);
        AppMethodBeat.o(132211);
    }

    public final void a(Context context, u uVar, l lVar, String str) {
        AppMethodBeat.i(132212);
        if (bp.dpL()) {
            lVar.a(this.inj, context.getResources().getColor(R.color.y0), context.getString(R.string.h3));
        }
        AppMethodBeat.o(132212);
    }

    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132213);
        d dVar = new d();
        q xT = uVar.xT();
        JSONObject jSONObject = new JSONObject();
        dVar.c(xT);
        c.a(str, uVar.getURL(), 10, "", bo.anT(), 1, 0);
        AppMethodBeat.o(132213);
    }
}
