package com.tencent.mm.plugin.appbrand.launching.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

enum b {
    WALLET("weapp://wallet/", 1019),
    SEARCH_NATIVE_FEATURE("weapp://search/", 1005);
    
    final String fNY;
    final int scene;

    static {
        AppMethodBeat.o(132034);
    }

    private b(String str, int i) {
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
