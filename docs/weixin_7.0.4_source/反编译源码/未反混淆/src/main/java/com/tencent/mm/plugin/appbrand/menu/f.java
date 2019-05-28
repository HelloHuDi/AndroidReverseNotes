package com.tencent.mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandSysConfigWC;
import com.tencent.mm.plugin.appbrand.menu.a.a;
import com.tencent.mm.plugin.appbrand.page.u;
import com.tencent.mm.plugin.appbrand.performance.AppBrandPerformanceManager;
import com.tencent.mm.ui.base.l;

public final class f extends a {
    public f() {
        super(o.EnablePerformancePanel.ordinal());
        AppMethodBeat.i(132208);
        AppMethodBeat.o(132208);
    }

    public final void a(Context context, u uVar, l lVar, String str) {
        AppMethodBeat.i(132209);
        AppBrandSysConfigWC appBrandSysConfigWC = (AppBrandSysConfigWC) uVar.aa(AppBrandSysConfigWC.class);
        if (appBrandSysConfigWC.hhd.gVt == 1) {
            CharSequence string;
            if (appBrandSysConfigWC.bQq) {
                string = context.getString(R.string.lf);
            } else {
                string = context.getString(R.string.lm);
            }
            lVar.e(o.EnablePerformancePanel.ordinal(), string);
        }
        AppMethodBeat.o(132209);
    }

    public final void a(Context context, u uVar, String str, n nVar) {
        AppMethodBeat.i(132210);
        if ((!((AppBrandSysConfigWC) uVar.aa(AppBrandSysConfigWC.class)).bQq ? 1 : 0) != 0) {
            AppBrandPerformanceManager.Dm(str);
            Toast.makeText(context, R.string.ln, 0).show();
            AppMethodBeat.o(132210);
            return;
        }
        AppBrandPerformanceManager.Dn(str);
        Toast.makeText(context, R.string.lg, 0).show();
        AppMethodBeat.o(132210);
    }
}
