package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandEmbedUI */
public final class AppBrandEmbedUI extends AppBrandUI {
    public final long iFU = SystemClock.elapsedRealtimeNanos();

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    /* renamed from: I */
    static boolean m30570I(Intent intent) {
        AppMethodBeat.m2504i(132927);
        if (intent != null) {
            try {
                if (intent.getComponent() != null && intent.getComponent().getClassName().equals(AppBrandEmbedUI.class.getName())) {
                    AppMethodBeat.m2505o(132927);
                    return true;
                }
            } catch (Exception e) {
                C4990ab.m7413e("MicroMsg.AppBrandEmbedUI", "isIntentForEmbedUI e=%s", e);
                AppMethodBeat.m2505o(132927);
                return false;
            }
        }
        AppMethodBeat.m2505o(132927);
        return false;
    }

    public AppBrandEmbedUI() {
        AppMethodBeat.m2504i(132928);
        AppMethodBeat.m2505o(132928);
    }

    public final void finish() {
        AppMethodBeat.m2504i(132929);
        if (isFinishing()) {
            AppMethodBeat.m2505o(132929);
            return;
        }
        aMt();
        AppMethodBeat.m2505o(132929);
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: e */
    public final void mo34978e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(132930);
        if (aMd()) {
            super.overridePendingTransition(C5206a.ync, C5206a.ynd);
            AppMethodBeat.m2505o(132930);
            return;
        }
        super.overridePendingTransition(C25738R.anim.f8302a5, C25738R.anim.f8293s);
        AppMethodBeat.m2505o(132930);
    }

    public final void initActivityCloseAnimation() {
        AppMethodBeat.m2504i(132931);
        if (aMd()) {
            super.overridePendingTransition(C5206a.yne, C5206a.ynf);
            AppMethodBeat.m2505o(132931);
            return;
        }
        overridePendingTransition(C25738R.anim.f8293s, C25738R.anim.f8300a3);
        AppMethodBeat.m2505o(132931);
    }

    private boolean aMd() {
        AppMethodBeat.m2504i(132932);
        if (this.iIP == null || !C42641p.m75513l(this.iIP.atv())) {
            AppMethodBeat.m2505o(132932);
            return false;
        }
        AppMethodBeat.m2505o(132932);
        return true;
    }
}
