package com.tencent.p177mm.plugin.appbrand.menu;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.base.C44273l;
import com.tencent.p177mm.plugin.appbrand.C38492q;
import com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator.C33376d;
import com.tencent.p177mm.plugin.appbrand.menu.p909a.C10642a;
import com.tencent.p177mm.plugin.appbrand.page.C44709u;
import com.tencent.p177mm.plugin.appbrand.report.C19690c;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5047bp;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.menu.g */
public final class C33456g extends C10642a {
    C33456g() {
        super(C38449o.Exit.ordinal());
        AppMethodBeat.m2504i(132211);
        AppMethodBeat.m2505o(132211);
    }

    /* renamed from: a */
    public final void mo6300a(Context context, C44709u c44709u, C44273l c44273l, String str) {
        AppMethodBeat.m2504i(132212);
        if (C5047bp.dpL()) {
            c44273l.mo70048a(this.inj, context.getResources().getColor(C25738R.color.f12267y0), context.getString(C25738R.string.f8851h3));
        }
        AppMethodBeat.m2505o(132212);
    }

    /* renamed from: a */
    public final void mo6301a(Context context, C44709u c44709u, String str, C42636n c42636n) {
        AppMethodBeat.m2504i(132213);
        C33376d c33376d = new C33376d();
        C38492q xT = c44709u.mo44926xT();
        JSONObject jSONObject = new JSONObject();
        c33376d.mo53856c(xT);
        C19690c.m30500a(str, c44709u.getURL(), 10, "", C5046bo.anT(), 1, 0);
        AppMethodBeat.m2505o(132213);
    }
}
