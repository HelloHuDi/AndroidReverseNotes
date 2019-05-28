package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMFragmentActivity.C5206a;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.base.C5274b;
import com.tencent.p177mm.plugin.appbrand.C42641p;
import com.tencent.p177mm.plugin.appbrand.C6750i;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.luggage.export.functionalpage.C42625k;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;

@C5271a(1)
/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI */
public class AppBrandPluginUI extends AppBrandUI implements C27334r {
    private boolean iHc = false;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI$1 */
    class C107681 implements IdleHandler {
        C107681() {
        }

        public final boolean queueIdle() {
            AppMethodBeat.m2504i(133002);
            Looper.myQueue().removeIdleHandler(this);
            C5274b.m8045a(AppBrandPluginUI.this, null);
            AppMethodBeat.m2505o(133002);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onResume() {
        AppMethodBeat.m2504i(133003);
        super.onResume();
        if (VERSION.SDK_INT < 21) {
            Looper.myQueue().addIdleHandler(new C107681());
        }
        AppMethodBeat.m2505o(133003);
    }

    public void onEnterAnimationComplete() {
        AppMethodBeat.m2504i(133004);
        super.onEnterAnimationComplete();
        C5274b.m8045a(this, null);
        AppMethodBeat.m2505o(133004);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: e */
    public void mo34978e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(133005);
        if (C42625k.m75487a(this, appBrandInitConfigWC, appBrandStatObject)) {
            C5274b.m8045a(this, null);
            AppMethodBeat.m2505o(133005);
            return;
        }
        super.overridePendingTransition(C5206a.ync, C5206a.ynd);
        AppMethodBeat.m2505o(133005);
    }

    public void initActivityCloseAnimation() {
        AppMethodBeat.m2504i(133006);
        if (this.iHc) {
            AppMethodBeat.m2505o(133006);
            return;
        }
        super.overridePendingTransition(C5206a.yne, C5206a.ynf);
        AppMethodBeat.m2505o(133006);
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(133007);
        super.onSwipeBack();
        this.iHc = true;
        AppMethodBeat.m2505o(133007);
    }

    public final boolean apx() {
        return true;
    }

    /* Access modifiers changed, original: protected|final */
    /* renamed from: J */
    public final void mo34979J(Intent intent) {
        AppMethodBeat.m2504i(133008);
        super.mo34979J(intent);
        C6750i atv = this.iIP == null ? null : this.iIP.atv();
        if (C42641p.m75513l(atv)) {
            atv.gNS = true;
        }
        AppMethodBeat.m2505o(133008);
    }
}
