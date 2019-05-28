package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMFragmentActivity.a;

public final class AppBrandEmbedUI extends AppBrandUI {
    public final long iFU = SystemClock.elapsedRealtimeNanos();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static boolean I(Intent intent) {
        AppMethodBeat.i(132927);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getClassName().equals(AppBrandEmbedUI.class.getName())) {
                    AppMethodBeat.o(132927);
                    return true;
                }
            } catch (Exception e) {
                ab.e("MicroMsg.AppBrandEmbedUI", "isIntentForEmbedUI e=%s", e);
                AppMethodBeat.o(132927);
                return false;
            }
        }
        AppMethodBeat.o(132927);
        return false;
    }

    public AppBrandEmbedUI() {
        AppMethodBeat.i(132928);
        AppMethodBeat.o(132928);
    }

    public final void finish() {
        AppMethodBeat.i(132929);
        if (isFinishing()) {
            AppMethodBeat.o(132929);
            return;
        }
        aMt();
        AppMethodBeat.o(132929);
    }

    /* Access modifiers changed, original: protected|final */
    public final void e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(132930);
        if (aMd()) {
            super.overridePendingTransition(a.ync, a.ynd);
            AppMethodBeat.o(132930);
            return;
        }
        super.overridePendingTransition(R.anim.a5, R.anim.s);
        AppMethodBeat.o(132930);
    }

    public final void initActivityCloseAnimation() {
        AppMethodBeat.i(132931);
        if (aMd()) {
            super.overridePendingTransition(a.yne, a.ynf);
            AppMethodBeat.o(132931);
            return;
        }
        overridePendingTransition(R.anim.s, R.anim.a3);
        AppMethodBeat.o(132931);
    }

    private boolean aMd() {
        AppMethodBeat.i(132932);
        if (this.iIP == null || !p.l(this.iIP.atv())) {
            AppMethodBeat.o(132932);
            return false;
        }
        AppMethodBeat.o(132932);
        return true;
    }
}
