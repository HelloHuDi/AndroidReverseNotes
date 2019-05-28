package com.tencent.mm.plugin.appbrand.weishi;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI;
import com.tencent.mm.plugin.appbrand.ui.n;
import com.tencent.mm.sdk.platformtools.ab;

public class AppBrandWeishiUI extends AppBrandPluginUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onResume() {
        AppMethodBeat.i(133637);
        super.onResume();
        ab.i("MicroMsg.AppBrandWeishiUI", "onResume");
        n.c(getWindow(), true);
        AppMethodBeat.o(133637);
    }

    public final void e(AppBrandInitConfigWC appBrandInitConfigWC, AppBrandStatObject appBrandStatObject) {
        AppMethodBeat.i(133638);
        ab.i("MicroMsg.AppBrandWeishiUI", "initAppBrandUIOpenAnimation, weishi animation");
        d.b(this, appBrandInitConfigWC);
        AppMethodBeat.o(133638);
    }

    public void onDetachedFromWindow() {
        AppMethodBeat.i(133639);
        super.onDetachedFromWindow();
        AppMethodBeat.o(133639);
    }
}
