package com.tencent.mm.plugin.appbrand.jsapi.r;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.ui.statusbar.d;
import org.json.JSONObject;

public final class b extends a {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "hideVirtualBottomNavigationBar";

    public final void a(c cVar, JSONObject jSONObject, int i) {
        AppMethodBeat.i(74808);
        c(cVar, i);
        AppMethodBeat.o(74808);
    }

    /* Access modifiers changed, original: final */
    public final void c(final c cVar, final int i) {
        AppMethodBeat.i(74809);
        if (al.isMainThread()) {
            ab.i("JsApiHideVirtualBottomNavigationBar", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
            w(cVar);
            cVar.M(i, j("ok", null));
            AppMethodBeat.o(74809);
            return;
        }
        al.d(new Runnable() {
            public final void run() {
                AppMethodBeat.i(74806);
                b.this.c(cVar, i);
                AppMethodBeat.o(74806);
            }
        });
        AppMethodBeat.o(74809);
    }

    private void w(c cVar) {
        AppMethodBeat.i(74810);
        Activity cY = d.cY(cVar.getContext());
        if (cY == null) {
            ab.i("JsApiHideVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.o(74810);
            return;
        }
        final Window window = cY.getWindow();
        if (window == null) {
            ab.i("JsApiHideVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.o(74810);
            return;
        }
        int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
        if (VERSION.SDK_INT >= 20) {
            systemUiVisibility = (systemUiVisibility | 512) | 2;
        }
        if (VERSION.SDK_INT >= 19) {
            systemUiVisibility |= 4096;
        }
        systemUiVisibility |= 256;
        window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        window.getDecorView().setOnSystemUiVisibilityChangeListener(new OnSystemUiVisibilityChangeListener() {
            public final void onSystemUiVisibilityChange(int i) {
                AppMethodBeat.i(74807);
                if ((i & 4) == 0) {
                    window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                }
                AppMethodBeat.o(74807);
            }
        });
        AppMethodBeat.o(74810);
    }
}
