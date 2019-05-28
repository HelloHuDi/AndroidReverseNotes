package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.statusbar.d;
import org.json.JSONObject;

public final class e extends a<c> {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "showVirtualBottomNavigationBar";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74815);
        c(cVar, i);
        AppMethodBeat.o(74815);
    }

    /* Access modifiers changed, original: final */
    public final void c(final c cVar, final int i) {
        AppMethodBeat.i(74816);
        if (al.isMainThread()) {
            ab.i("JsApiShowVirtualBottomNavigationBar", "show");
            w(cVar);
            cVar.M(i, j("ok", null));
            AppMethodBeat.o(74816);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74814);
                e.this.c(cVar, i);
                AppMethodBeat.o(74814);
            }
        });
        AppMethodBeat.o(74816);
    }

    private static void w(c cVar) {
        AppMethodBeat.i(74817);
        Activity cY = d.cY(cVar.getContext());
        if (cY == null) {
            ab.i("JsApiShowVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.o(74817);
            return;
        }
        Window window = cY.getWindow();
        if (window == null) {
            ab.i("JsApiShowVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.o(74817);
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
        AppMethodBeat.o(74817);
    }
}
