package com.tencent.mm.plugin.appbrand.ui;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AppBrandUI1 extends AppBrandUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(133152);
        super.onCreate(bundle);
        AppMethodBeat.o(133152);
    }

    public void onResume() {
        AppMethodBeat.i(133153);
        super.onResume();
        AppMethodBeat.o(133153);
    }
}
