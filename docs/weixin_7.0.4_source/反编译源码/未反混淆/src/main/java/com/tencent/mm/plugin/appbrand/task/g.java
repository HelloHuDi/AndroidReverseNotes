package com.tencent.mm.plugin.appbrand.task;

import android.content.Intent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfigWC;

public enum g {
    WASERVICE(1, BaseClientBuilder.API_PRIORITY_OTHER),
    WAGAME(2, 2),
    NIL(0, 0);
    
    public int code;
    public int iFi;

    static {
        AppMethodBeat.o(132847);
    }

    private g(int i, int i2) {
        this.code = i;
        this.iFi = i2;
    }

    public final Intent G(Intent intent) {
        AppMethodBeat.i(132844);
        intent.putExtra("AppBrandServiceType", this.code);
        AppMethodBeat.o(132844);
        return intent;
    }

    public static g H(Intent intent) {
        AppMethodBeat.i(132845);
        int intExtra = intent.getIntExtra("AppBrandServiceType", NIL.code);
        for (g gVar : values()) {
            if (gVar.code == intExtra) {
                AppMethodBeat.o(132845);
                return gVar;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
        AppMethodBeat.o(132845);
        throw illegalStateException;
    }

    public static g c(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.i(132846);
        g gVar;
        if (appBrandInitConfigWC.xy()) {
            gVar = WAGAME;
            AppMethodBeat.o(132846);
            return gVar;
        }
        gVar = WASERVICE;
        AppMethodBeat.o(132846);
        return gVar;
    }

    public static g eB(boolean z) {
        if (z) {
            return WAGAME;
        }
        return WASERVICE;
    }
}
