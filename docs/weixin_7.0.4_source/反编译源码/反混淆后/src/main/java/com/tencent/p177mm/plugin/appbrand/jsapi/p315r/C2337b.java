package com.tencent.p177mm.plugin.appbrand.jsapi.p315r;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.Window;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.statusbar.C5546d;
import com.tencent.p177mm.plugin.appbrand.jsapi.C10296a;
import com.tencent.p177mm.plugin.appbrand.jsapi.C2241c;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import org.json.JSONObject;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.r.b */
public final class C2337b extends C10296a {
    private static final int CTRL_INDEX = 580;
    private static final String NAME = "hideVirtualBottomNavigationBar";

    /* renamed from: a */
    public final void mo5994a(C2241c c2241c, JSONObject jSONObject, int i) {
        AppMethodBeat.m2504i(74808);
        mo6219c(c2241c, i);
        AppMethodBeat.m2505o(74808);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo6219c(final C2241c c2241c, final int i) {
        AppMethodBeat.m2504i(74809);
        if (C5004al.isMainThread()) {
            C4990ab.m7416i("JsApiHideVirtualBottomNavigationBar", MessengerShareContentUtility.SHARE_BUTTON_HIDE);
            m4576w(c2241c);
            c2241c.mo6107M(i, mo73394j("ok", null));
            AppMethodBeat.m2505o(74809);
            return;
        }
        C5004al.m7441d(new Runnable() {
            public final void run() {
                AppMethodBeat.m2504i(74806);
                C2337b.this.mo6219c(c2241c, i);
                AppMethodBeat.m2505o(74806);
            }
        });
        AppMethodBeat.m2505o(74809);
    }

    /* renamed from: w */
    private void m4576w(C2241c c2241c) {
        AppMethodBeat.m2504i(74810);
        Activity cY = C5546d.m8371cY(c2241c.getContext());
        if (cY == null) {
            C4990ab.m7416i("JsApiHideVirtualBottomNavigationBar", "null == activity");
            AppMethodBeat.m2505o(74810);
            return;
        }
        final Window window = cY.getWindow();
        if (window == null) {
            C4990ab.m7416i("JsApiHideVirtualBottomNavigationBar", "null == window");
            AppMethodBeat.m2505o(74810);
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
                AppMethodBeat.m2504i(74807);
                if ((i & 4) == 0) {
                    window.getDecorView().setSystemUiVisibility(systemUiVisibility);
                }
                AppMethodBeat.m2505o(74807);
            }
        });
        AppMethodBeat.m2505o(74810);
    }
}
