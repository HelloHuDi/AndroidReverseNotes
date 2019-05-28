package com.tencent.p177mm.plugin.appbrand.launching.p906b;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.launching.b.b */
enum C10594b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String fNY;
    final int scene;

    static {
        AppMethodBeat.m2505o(132034);
    }

    private C10594b(String str, int i) {
        this.fNY = str;
        this.scene = i;
    }

    static String aHI() {
        return "";
    }

    static String aHJ() {
        return "";
    }
}
