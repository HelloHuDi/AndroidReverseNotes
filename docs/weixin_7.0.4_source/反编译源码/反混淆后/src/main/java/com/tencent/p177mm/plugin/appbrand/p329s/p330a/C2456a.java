package com.tencent.p177mm.plugin.appbrand.p329s.p330a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.p329s.C27289f.C27290a;

/* renamed from: com.tencent.mm.plugin.appbrand.s.a.a */
public enum C2456a implements C45680e, C27290a {
    ;
    
    public static final C45679c iRV = null;
    private final C45680e iRW;

    private C2456a(String str) {
        AppMethodBeat.m2504i(126646);
        this.iRW = new C2457b();
        AppMethodBeat.m2505o(126646);
    }

    static {
        iRV = new C45679c();
        AppMethodBeat.m2505o(126652);
    }

    public final void init(Context context) {
        AppMethodBeat.m2504i(126647);
        this.iRW.init(context);
        AppMethodBeat.m2505o(126647);
    }

    public final void release() {
        AppMethodBeat.m2504i(126648);
        this.iRW.release();
        AppMethodBeat.m2505o(126648);
    }

    public final C45679c aOb() {
        AppMethodBeat.m2504i(126649);
        C45679c aOb = this.iRW.aOb();
        AppMethodBeat.m2505o(126649);
        return aOb;
    }

    /* renamed from: da */
    public final void mo6375da(Context context) {
        AppMethodBeat.m2504i(126650);
        init(context);
        AppMethodBeat.m2505o(126650);
    }

    public final void aNZ() {
        AppMethodBeat.m2504i(126651);
        release();
        AppMethodBeat.m2505o(126651);
    }
}
