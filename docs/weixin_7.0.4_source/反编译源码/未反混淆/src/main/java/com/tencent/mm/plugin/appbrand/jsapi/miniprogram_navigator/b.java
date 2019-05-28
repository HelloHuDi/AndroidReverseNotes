package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public enum b {
    RELEASE(0),
    DEVELOP(1),
    TRIAL(2);
    
    public final int har;

    static {
        AppMethodBeat.o(101978);
    }

    private b(int i) {
        this.har = i;
    }

    public static b a(String str, b bVar) {
        AppMethodBeat.i(101976);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(101976);
            return bVar;
        }
        for (b bVar2 : values()) {
            if (bVar2.name().toLowerCase().equals(str)) {
                AppMethodBeat.o(101976);
                return bVar2;
            }
        }
        AppMethodBeat.o(101976);
        return bVar;
    }

    public static b ot(int i) {
        AppMethodBeat.i(101977);
        for (b bVar : values()) {
            if (bVar.har == i) {
                AppMethodBeat.o(101977);
                return bVar;
            }
        }
        b bVar2 = RELEASE;
        AppMethodBeat.o(101977);
        return bVar2;
    }
}
