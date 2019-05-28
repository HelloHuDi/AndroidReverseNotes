package com.tencent.p177mm.plugin.appbrand.jsapi.p315r;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.r.e */
public final class C33389e extends C10296a<C2241c> {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "showVirtualBottomNavigationBar";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74815);
        mo53863c(c2241c, i);
        AppMethodBeat.m2505o(74815);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo53863c(final C2241c c2241c, final int i) {
        AppMethodBeat.m2504i(74816);
        if (C5004al.isMainThread()) {
            C4990ab.m7416i("JsApiShowVirtualBottomNavigationBar", "show");
            C33389e.m54583w(c2241c);
            c2241c.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74816);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74814);
                C33389e.this.mo53863c(c2241c, i);
                AppMethodBeat.m2505o(74814);
            }
        });
        AppMethodBeat.m2505o(74816);
    }

    /* renamed from: w */
    private static void m54583w(C2241c c2241c) {
        AppMethodBeat.m2504i(74817);
        Activity cY = C5546d.m8371cY(c2241c.getContext());
        if (cY == null) {
            C4990ab.m7416i("JsApiShowVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.m2505o(74817);
            return;
        }
        Window window = cY.getWindow();
        if (window == null) {
            C4990ab.m7416i("JsApiShowVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.m2505o(74817);
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (VERSION.SDK_INT >= 20) {
            systemUiVisibility = (systemUiVisibility & -513) & -3;
        }
        if (VERSION.SDK_INT >= 19) {
            systemUiVisibility &= -4097;
        }
        window.getDecorView().setSystemUiVisibility(systemUiVisibility & -257);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(null);
        AppMethodBeat.m2505o(74817);
    }
}
