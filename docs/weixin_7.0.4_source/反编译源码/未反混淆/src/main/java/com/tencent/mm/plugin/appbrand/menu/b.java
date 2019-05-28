package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.plugin.appbrand.page.r;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class b extends a {
    b() {
        super(o.BackToHome.ordinal());
        AppMethodBeat.i(132193);
        AppMethodBeat.o(132193);
    }

    public final void a(Context context, u uVar, l lVar, String str) {
        AppMethodBeat.i(132194);
        q asV = uVar.getRuntime().asV();
        if ((asV instanceof r) && ((r) asV).aAW()) {
            lVar.e(this.inj, context.getString(R.string.h4));
        }
        AppMethodBeat.o(132194);
    }

    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132195);
        uVar.getRuntime().asV().af(uVar.getRuntime().getAppConfig().ayw(), true);
        if (uVar.aJz() != null) {
            c.a(str, uVar.getURL(), 20, "", bo.anT(), 1, 0);
        }
        AppMethodBeat.o(132195);
    }
}
