package com.tencent.p177mm.plugin.sns.p520ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.sns.ui.SnsTimeLineUserPagerUI */
public class SnsTimeLineUserPagerUI extends SnsTimeLineUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
