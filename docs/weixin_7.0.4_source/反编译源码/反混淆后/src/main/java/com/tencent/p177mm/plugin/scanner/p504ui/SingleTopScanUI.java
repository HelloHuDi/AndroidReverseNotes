package com.tencent.p177mm.plugin.scanner.p504ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.scanner.ui.SingleTopScanUI */
public class SingleTopScanUI extends BaseScanUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
