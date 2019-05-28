package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.Context;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.C41243o;
import com.tencent.p177mm.plugin.appbrand.debugger.C26852t;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.h */
public final class C33457h extends C10642a {
    public C33457h() {
        super(C38449o.OpenGamePreload.ordinal());
        AppMethodBeat.m2504i(132214);
        AppMethodBeat.m2505o(132214);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132215);
        if (c44709u.getRuntime() instanceof C41243o) {
            C41243o c41243o = (C41243o) c44709u.getRuntime();
            if (c41243o.mo65903xy() && c41243o.mo43493yd()) {
                if (C26852t.azr()) {
                    c44273l.mo70068e(this.inj, "Disable Preload");
                    AppMethodBeat.m2505o(132215);
                    return;
                }
                c44273l.mo70068e(this.inj, "Enable Preload");
            }
        }
        AppMethodBeat.m2505o(132215);
    }

    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132216);
        if (C26852t.azr()) {
            C26852t.m42767dL(false);
            Toast.makeText(context, "Disable success, please restart WeChat to take effect.", 1).show();
            AppMethodBeat.m2505o(132216);
            return;
        }
        C26852t.m42767dL(true);
        Toast.makeText(context, "Enable success, please restart WeChat to take effect.", 1).show();
        AppMethodBeat.m2505o(132216);
    }
}
