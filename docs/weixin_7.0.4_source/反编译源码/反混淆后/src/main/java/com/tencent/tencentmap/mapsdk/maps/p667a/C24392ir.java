package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ir */
public class C24392ir implements C5884gt {
    /* renamed from: a */
    private C31061iz f4739a;

    public C24392ir(C31061iz c31061iz) {
        this.f4739a = c31061iz;
    }

    /* renamed from: a */
    public void mo12476a(C24382gs c24382gs) {
        AppMethodBeat.m2504i(99870);
        if (this.f4739a == null) {
            AppMethodBeat.m2505o(99870);
            return;
        }
        if (c24382gs != null) {
            this.f4739a.mo50431a(this.f4739a.mo75386b().mo20231j());
        }
        if (this.f4739a.f14287v != null) {
            this.f4739a.f14287v.sendEmptyMessage(0);
        }
        AppMethodBeat.m2505o(99870);
    }
}
