package com.tencent.p177mm.plugin.appbrand.game.page.p1536a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.p057v4.widget.C8415j;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.game.page.C33204f;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c;
import com.tencent.p177mm.plugin.appbrand.page.p910b.C19627c.C19628b;

/* renamed from: com.tencent.mm.plugin.appbrand.game.page.a.a */
public final class C42447a implements C19627c {
    private final C33204f htg;
    private C19628b hth = null;

    public C42447a(C33204f c33204f) {
        this.htg = c33204f;
    }

    public final void aBr() {
        AppMethodBeat.m2504i(130280);
        this.hth = C19628b.SHOWN;
        m75177dP(false);
        if (VERSION.SDK_INT >= 21 && (this.htg.mContext instanceof Activity)) {
            Window window = ((Activity) this.htg.mContext).getWindow();
            if (window != null) {
                window.addFlags(C8415j.INVALID_ID);
                window.setStatusBarColor(0);
            }
        }
        AppMethodBeat.m2505o(130280);
    }

    public final void aBs() {
        AppMethodBeat.m2504i(130281);
        this.hth = C19628b.HIDDEN;
        m75177dP(true);
        AppMethodBeat.m2505o(130281);
    }

    public final void aAS() {
        AppMethodBeat.m2504i(130282);
        if (this.hth == null) {
            this.hth = this.htg.getRuntime().getAppConfig().heX.hfi ? C19628b.SHOWN : C19628b.HIDDEN;
        }
        switch (this.hth) {
            case SHOWN:
                aBr();
                AppMethodBeat.m2505o(130282);
                return;
            case HIDDEN:
                aBs();
                AppMethodBeat.m2505o(130282);
                return;
            default:
                AppMethodBeat.m2505o(130282);
                return;
        }
    }

    public final void onOrientationChanged(int i) {
    }

    public final C19628b aBt() {
        return this.hth;
    }

    /* renamed from: dP */
    private void m75177dP(boolean z) {
        AppMethodBeat.m2504i(130283);
        if (this.htg.mContext instanceof Activity) {
            Window window = ((Activity) this.htg.mContext).getWindow();
            if (z) {
                C42696n.m75620c(window, true);
                AppMethodBeat.m2505o(130283);
                return;
            }
            C42696n.m75620c(window, false);
            AppMethodBeat.m2505o(130283);
            return;
        }
        AppMethodBeat.m2505o(130283);
    }
}
