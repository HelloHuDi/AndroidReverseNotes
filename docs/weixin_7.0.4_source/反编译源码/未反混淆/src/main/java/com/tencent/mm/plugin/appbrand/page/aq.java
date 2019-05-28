package com.tencent.mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k.ab;
import com.tencent.mm.plugin.appbrand.jsapi.k.g;
import com.tencent.mm.plugin.appbrand.jsapi.k.h;
import com.tencent.mm.plugin.appbrand.jsapi.k.j;

public enum aq {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(h.NAME),
    NAVIGATE_BACK(g.NAME),
    REDIRECT_TO(j.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB(ab.NAME);
    
    private final String type;

    static {
        AppMethodBeat.o(87347);
    }

    private aq(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
