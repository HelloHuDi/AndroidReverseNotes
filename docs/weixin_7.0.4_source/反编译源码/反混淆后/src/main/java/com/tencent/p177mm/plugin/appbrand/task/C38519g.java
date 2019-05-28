package com.tencent.p177mm.plugin.appbrand.task;

import android.content.Intent;
import com.google.android.gms.common.api.Api.BaseClientBuilder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.config.AppBrandInitConfigWC;

/* renamed from: com.tencent.mm.plugin.appbrand.task.g */
public enum C38519g {
    WASERVICE(1, BaseClientBuilder.API_PRIORITY_OTHER),
    WAGAME(2, 2),
    NIL(0, 0);
    
    public int code;
    public int iFi;

    static {
        AppMethodBeat.m2505o(132847);
    }

    private C38519g(int i, int i2) {
        this.code = i;
        this.iFi = i2;
    }

    /* renamed from: G */
    public final Intent mo61248G(Intent intent) {
        AppMethodBeat.m2504i(132844);
        intent.putExtra("AppBrandServiceType", this.code);
        AppMethodBeat.m2505o(132844);
        return intent;
    }

    /* renamed from: H */
    public static C38519g m65220H(Intent intent) {
        AppMethodBeat.m2504i(132845);
        int intExtra = intent.getIntExtra("AppBrandServiceType", NIL.code);
        for (C38519g c38519g : C38519g.values()) {
            if (c38519g.code == intExtra) {
                AppMethodBeat.m2505o(132845);
                return c38519g;
            }
        }
        IllegalStateException illegalStateException = new IllegalStateException("AppBrandServiceType DeserializeFrom[Intent] Unreached Code");
        AppMethodBeat.m2505o(132845);
        throw illegalStateException;
    }

    /* renamed from: c */
    public static C38519g m65221c(AppBrandInitConfigWC appBrandInitConfigWC) {
        AppMethodBeat.m2504i(132846);
        C38519g c38519g;
        if (appBrandInitConfigWC.mo32992xy()) {
            c38519g = WAGAME;
            AppMethodBeat.m2505o(132846);
            return c38519g;
        }
        c38519g = WASERVICE;
        AppMethodBeat.m2505o(132846);
        return c38519g;
    }

    /* renamed from: eB */
    public static C38519g m65222eB(boolean z) {
        if (z) {
            return WAGAME;
        }
        return WASERVICE;
    }
}
