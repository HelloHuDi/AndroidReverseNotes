package com.tencent.mm.plugin.appbrand.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.luggage.export.functionalpage.k;
import com.tencent.mm.plugin.appbrand.p;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.b;

@a(1)
public class AppBrandPluginUI extends AppBrandUI implements r {
    private boolean iHc = false;

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onResume() {
        AppMethodBeat.i(133003);
        super.onResume();
        if (VERSION.SDK_INT < 21) {
            Looper.myQueue().addIdleHandler(new IdleHandler() {
                public final boolean queueIdle() {
                    AppMethodBeat.i(133002);
                    Looper.myQueue().removeIdleHandler(this);
                    b.a(AppBrandPluginUI.this, null);
                    AppMethodBeat.o(133002);
                    return false;
                }
            });
        }
        AppMethodBeat.o(133003);
    }

    public void onEnterAnimationComplete() {
        AppMethodBeat.i(133004);
        super.onEnterAnimationComplete();
        b.a(this, null);
        AppMethodBeat.o(133004);
    }

    /* Access modifiers changed, original: protected */
    public void e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(133005);
        if (k.a(this, appBrandInitConfigWC, appBrandStatObject)) {
            b.a(this, null);
            AppMethodBeat.o(133005);
            return;
        }
        super.overridePendingTransition(MMFragmentActivity.a.ync, MMFragmentActivity.a.ynd);
        AppMethodBeat.o(133005);
    }

    public void initActivityCloseAnimation() {
        AppMethodBeat.i(133006);
        if (this.iHc) {
            AppMethodBeat.o(133006);
            return;
        }
        super.overridePendingTransition(MMFragmentActivity.a.yne, MMFragmentActivity.a.ynf);
        AppMethodBeat.o(133006);
    }

    public void onSwipeBack() {
        AppMethodBeat.i(133007);
        super.onSwipeBack();
        this.iHc = true;
        AppMethodBeat.o(133007);
    }

    public final boolean apx() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    public final void J(Intent intent) {
        AppMethodBeat.i(133008);
        super.J(intent);
        i atv = this.iIP == null ? null : this.iIP.atv();
        if (p.l(atv)) {
            atv.gNS = true;
        }
        AppMethodBeat.o(133008);
    }
}
