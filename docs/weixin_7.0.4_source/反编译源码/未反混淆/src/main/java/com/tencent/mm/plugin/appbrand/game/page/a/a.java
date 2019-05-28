package com.tencent.mm.plugin.appbrand.game.page.a;

import android.app.Activity;
import android.os.Build.VERSION;
import android.support.v4.widget.j;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.game.page.f;
import com.tencent.mm.plugin.appbrand.page.b.c;
import com.tencent.mm.plugin.appbrand.page.b.c.b;
import com.tencent.mm.plugin.appbrand.ui.n;

public final class a implements c {
    private final f htg;
    private b hth = null;

    public a(f fVar) {
        this.htg = fVar;
    }

    public final void aBr() {
        AppMethodBeat.i(130280);
        this.hth = b.SHOWN;
        dP(false);
        if (VERSION.SDK_INT >= 21 && (this.htg.mContext instanceof Activity)) {
            Window window = ((Activity) this.htg.mContext).getWindow();
            if (window != null) {
                window.addFlags(j.INVALID_ID);
                window.setStatusBarColor(0);
            }
        }
        AppMethodBeat.o(130280);
    }

    public final void aBs() {
        AppMethodBeat.i(130281);
        this.hth = b.HIDDEN;
        dP(true);
        AppMethodBeat.o(130281);
    }

    public final void aAS() {
        AppMethodBeat.i(130282);
        if (this.hth == null) {
            this.hth = this.htg.getRuntime().getAppConfig().heX.hfi ? b.SHOWN : b.HIDDEN;
        }
        switch (this.hth) {
            case SHOWN:
                aBr();
                AppMethodBeat.o(130282);
                return;
            case HIDDEN:
                aBs();
                AppMethodBeat.o(130282);
                return;
            default:
                AppMethodBeat.o(130282);
                return;
        }
    }

    public final void onOrientationChanged(int i) {
    }

    public final b aBt() {
        return this.hth;
    }

    private void dP(boolean z) {
        AppMethodBeat.i(130283);
        if (this.htg.mContext instanceof Activity) {
            Window window = ((Activity) this.htg.mContext).getWindow();
            if (z) {
                n.c(window, true);
                AppMethodBeat.o(130283);
                return;
            }
            n.c(window, false);
            AppMethodBeat.o(130283);
            return;
        }
        AppMethodBeat.o(130283);
    }
}
