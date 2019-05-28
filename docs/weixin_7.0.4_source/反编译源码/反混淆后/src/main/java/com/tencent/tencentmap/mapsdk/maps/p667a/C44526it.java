package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.it */
public class C44526it implements C31044fv {
    /* renamed from: a */
    private C31061iz f17447a;

    public C44526it(C31061iz c31061iz) {
        this.f17447a = c31061iz;
    }

    /* renamed from: a */
    public void mo29059a() {
        AppMethodBeat.m2504i(99872);
        if (this.f17447a == null || this.f17447a.f14287v == null) {
            AppMethodBeat.m2505o(99872);
            return;
        }
        this.f17447a.f14287v.sendEmptyMessage(1);
        AppMethodBeat.m2505o(99872);
    }
}
