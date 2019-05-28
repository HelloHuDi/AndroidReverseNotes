package com.tencent.p177mm.plugin.appbrand.jsapi.camera;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.HashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a */
public final class C10360a {
    boolean hGi;
    boolean hGj;
    HashMap<Integer, C33272e> hGk;

    /* renamed from: com.tencent.mm.plugin.appbrand.jsapi.camera.a$a */
    static class C10361a {
        private static C10360a hGl = new C10360a();

        static {
            AppMethodBeat.m2504i(126238);
            AppMethodBeat.m2505o(126238);
        }
    }

    /* synthetic */ C10360a(byte b) {
        this();
    }

    private C10360a() {
        AppMethodBeat.m2504i(126239);
        this.hGi = true;
        this.hGj = true;
        this.hGk = new HashMap();
        AppMethodBeat.m2505o(126239);
    }

    public final boolean aDa() {
        AppMethodBeat.m2504i(126240);
        if (!this.hGi) {
            C4990ab.m7416i("MicroMsg.AppBrandCameraMrg", "no camera permission");
        }
        boolean z = this.hGi;
        AppMethodBeat.m2505o(126240);
        return z;
    }
}
