package com.tencent.mm.plugin.brandservice.ui.timeline.preload.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class TmplWebViewTooLMpUI extends TmplWebViewToolUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
