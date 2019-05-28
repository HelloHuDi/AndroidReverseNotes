package com.tencent.p177mm.plugin.appbrand.ipc;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.ipc.AppBrandTaskProxyUI */
public class AppBrandTaskProxyUI extends AppBrandProcessProxyUI {
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }
}
