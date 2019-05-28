package com.tencent.p177mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.b */
public enum C2319b {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);
    
    public final int har;

    static {
        AppMethodBeat.m2505o(101978);
    }

    private C2319b(int i) {
        this.har = i;
    }

    /* renamed from: a */
    public static C2319b m4539a(String str, C2319b c2319b) {
        AppMethodBeat.m2504i(101976);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(101976);
            return c2319b;
        }
        for (C2319b c2319b2 : C2319b.values()) {
            if (c2319b2.name().toLowerCase().equals(str)) {
                AppMethodBeat.m2505o(101976);
                return c2319b2;
            }
        }
        AppMethodBeat.m2505o(101976);
        return c2319b;
    }

    /* renamed from: ot */
    public static C2319b m4540ot(int i) {
        AppMethodBeat.m2504i(101977);
        for (C2319b c2319b : C2319b.values()) {
            if (c2319b.har == i) {
                AppMethodBeat.m2505o(101977);
                return c2319b;
            }
        }
        C2319b c2319b2 = RELEASE;
        AppMethodBeat.m2505o(101977);
        return c2319b2;
    }
}
