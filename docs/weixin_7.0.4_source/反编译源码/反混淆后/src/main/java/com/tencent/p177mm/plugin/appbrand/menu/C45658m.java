package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.C33183g;
import com.tencent.p177mm.plugin.appbrand.C33183g.C33184d;
import com.tencent.p177mm.plugin.appbrand.config.C16597h;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.p336ui.banner.AppBrandStickyBannerLogic.C19773a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.plugin.appbrand.widget.recentview.C11048d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.m */
public final class C45658m extends C10642a {
    public C45658m() {
        super(C38449o.StickInWeChat.ordinal());
        AppMethodBeat.m2504i(132251);
        AppMethodBeat.m2505o(132251);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132252);
        C1720g.m3528K(C11048d.class);
        AppMethodBeat.m2505o(132252);
    }

    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132253);
        C16597h ye = c44709u.getRuntime().mo15034ye();
        C19773a.aMP();
        C33183g.m54275a(str, C33184d.HANG);
        C19773a.m30604a(context, ye.appId, ye.hhd.gVt, ye.cwz, ye.hgW);
        C19690c.m30500a(str, c44709u.getURL(), 13, "", C5046bo.anT(), 1, 0);
        AppMethodBeat.m2505o(132253);
    }
}
