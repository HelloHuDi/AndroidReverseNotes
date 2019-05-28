package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C38470q;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.page.C45665r;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.b */
public final class C33454b extends C10642a {
    C33454b() {
        super(C38449o.BackToHome.ordinal());
        AppMethodBeat.m2504i(132193);
        AppMethodBeat.m2505o(132193);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132194);
        C38470q asV = c44709u.getRuntime().asV();
        if ((asV instanceof C45665r) && ((C45665r) asV).aAW()) {
            c44273l.mo70068e(this.inj, context.getString(C25738R.string.f8852h4));
        }
        AppMethodBeat.m2505o(132194);
    }

    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132195);
        c44709u.getRuntime().asV().mo21671af(c44709u.getRuntime().getAppConfig().ayw(), true);
        if (c44709u.aJz() != null) {
            C19690c.m30500a(str, c44709u.getURL(), 20, "", C5046bo.anT(), 1, 0);
        }
        AppMethodBeat.m2505o(132195);
    }
}
