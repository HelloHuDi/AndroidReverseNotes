package com.tencent.mm.plugin.wear.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class WearYoLockUI extends WearYoUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
