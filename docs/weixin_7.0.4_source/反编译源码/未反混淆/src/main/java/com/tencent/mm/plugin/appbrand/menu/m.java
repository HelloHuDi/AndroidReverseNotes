package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.config.h;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.recentview.d;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.l;

public final class m extends a {
    public m() {
        super(o.StickInWeChat.ordinal());
        AppMethodBeat.i(132251);
        AppMethodBeat.o(132251);
    }

    public final void a(Context context, u uVar, l lVar, String str) {
        AppMethodBeat.i(132252);
        g.K(d.class);
        AppMethodBeat.o(132252);
    }

    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132253);
        h ye = uVar.getRuntime().ye();
        AppBrandStickyBannerLogic.a.aMP();
        com.tencent.mm.plugin.appbrand.g.a(str, com.tencent.mm.plugin.appbrand.g.d.HANG);
        AppBrandStickyBannerLogic.a.a(context, ye.appId, ye.hhd.gVt, ye.cwz, ye.hgW);
        c.a(str, uVar.getURL(), 13, "", bo.anT(), 1, 0);
        AppMethodBeat.o(132253);
    }
}
