package com.tencent.p177mm.plugin.wear.p1061ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.wear.ui.WearYoLockUI */
public class WearYoLockUI extends WearYoUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
