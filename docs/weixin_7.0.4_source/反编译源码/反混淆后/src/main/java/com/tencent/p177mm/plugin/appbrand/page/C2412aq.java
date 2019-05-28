package com.tencent.p177mm.plugin.appbrand.page;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C2300h;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C24698g;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C33340j;
import com.tencent.p177mm.plugin.appbrand.jsapi.p310k.C42522ab;

/* renamed from: com.tencent.mm.plugin.appbrand.page.aq */
public enum C2412aq {
    APP_LAUNCH("appLaunch"),
    NAVIGATE_TO(C2300h.NAME),
    NAVIGATE_BACK(C24698g.NAME),
    REDIRECT_TO(C33340j.NAME),
    RE_LAUNCH("reLaunch"),
    AUTO_RE_LAUNCH("autoReLaunch"),
    SWITCH_TAB(C42522ab.NAME);
    
    private final String type;

    static {
        AppMethodBeat.m2505o(87347);
    }

    private C2412aq(String str) {
        this.type = str;
    }

    public final String toString() {
        return this.type;
    }
}
