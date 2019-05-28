package com.tencent.p177mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.p177mm.plugin.appbrand.p336ui.AppBrandPluginUI;
import com.tencent.p177mm.plugin.appbrand.p336ui.C42696n;
import com.tencent.p177mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.appbrand.weishi.AppBrandWeishiUI */
public class AppBrandWeishiUI extends AppBrandPluginUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onResume() {
        AppMethodBeat.m2504i(133637);
        super.onResume();
        C4990ab.m7416i("MicroMsg.AppBrandWeishiUI", "onResume");
        C42696n.m75620c(getWindow(), true);
        AppMethodBeat.m2505o(133637);
    }

    /* renamed from: e */
    public final void mo34978e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.m2504i(133638);
        C4990ab.m7416i("MicroMsg.AppBrandWeishiUI", "initAppBrandUIOpenAnimation, weishi animation");
        C33570d.m54820b(this, appBrandInitConfigWC);
        AppMethodBeat.m2505o(133638);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.m2504i(133639);
        super.onDetachedFromWindow();
        AppMethodBeat.m2505o(133639);
    }
}
