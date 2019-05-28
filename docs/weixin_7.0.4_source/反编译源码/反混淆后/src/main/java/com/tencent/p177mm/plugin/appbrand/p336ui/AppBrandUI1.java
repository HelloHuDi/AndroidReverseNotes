package com.tencent.p177mm.plugin.appbrand.p336ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.AppBrandUI1 */
public class AppBrandUI1 extends AppBrandUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(133152);
        super.onCreate(bundle);
        AppMethodBeat.m2505o(133152);
    }

    public void onResume() {
        AppMethodBeat.m2504i(133153);
        super.onResume();
        AppMethodBeat.m2505o(133153);
    }
}
