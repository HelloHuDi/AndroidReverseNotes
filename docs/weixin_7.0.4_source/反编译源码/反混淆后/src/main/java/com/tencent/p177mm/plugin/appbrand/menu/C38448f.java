package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.performance.AppBrandPerformanceManager;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.f */
public final class C38448f extends C10642a {
    public C38448f() {
        super(C38449o.EnablePerformancePanel.ordinal());
        AppMethodBeat.m2504i(132208);
        AppMethodBeat.m2505o(132208);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132209);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) c44709u.mo5937aa(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.hhd.gVt == 1) {
            CharSequence string;
            if (appBrandSysConfigWC.bQq) {
                string = context.getString(C25738R.string.f8977lf);
            } else {
                string = context.getString(C25738R.string.f8984lm);
            }
            c44273l.mo70068e(C38449o.EnablePerformancePanel.ordinal(), string);
        }
        AppMethodBeat.m2505o(132209);
    }

    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132210);
        if ((!((AppBrandSysConfigWC) c44709u.mo5937aa(AppBrandSysConfigWC.class)).bQq ? 1 : 0) != 0) {
            AppBrandPerformanceManager.m43284Dm(str);
            Toast.makeText(context, C25738R.string.f8985ln, 0).show();
            AppMethodBeat.m2505o(132210);
            return;
        }
        AppBrandPerformanceManager.m43285Dn(str);
        Toast.makeText(context, C25738R.string.f8978lg, 0).show();
        AppMethodBeat.m2505o(132210);
    }
}
