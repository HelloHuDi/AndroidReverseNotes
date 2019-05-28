package com.tencent.tencentmap.mapsdk.maps.p667a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C30982aj.C24326f;
import com.tencent.tencentmap.mapsdk.p666a.C31000cw;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.iu */
public class C41066iu implements C24326f {
    /* renamed from: a */
    private C31061iz f16514a;

    public C41066iu(C31061iz c31061iz) {
        this.f16514a = c31061iz;
    }

    public boolean onIndoorBuildingFocused() {
        AppMethodBeat.m2504i(99873);
        if (this.f16514a == null) {
            AppMethodBeat.m2505o(99873);
            return false;
        }
        this.f16514a.onIndoorBuildingFocused();
        if (this.f16514a.f14283r != null) {
            this.f16514a.f14283r.onIndoorBuildingFocused();
        }
        C44829lf c44829lf = this.f16514a.f14275j;
        if (c44829lf != null) {
            c44829lf.mo72032b(true);
        }
        AppMethodBeat.m2505o(99873);
        return true;
    }

    public boolean onIndoorLevelActivated(C31000cw c31000cw) {
        AppMethodBeat.m2504i(99874);
        if (this.f16514a == null) {
            AppMethodBeat.m2505o(99874);
            return false;
        }
        this.f16514a.onIndoorLevelActivated(c31000cw);
        if (this.f16514a.f14283r != null) {
            this.f16514a.f14283r.onIndoorLevelActivated(c31000cw);
        }
        C44829lf c44829lf = this.f16514a.f14275j;
        if (c44829lf != null && c44829lf.mo72033b() && this.f16514a.mo75386b().mo20225h() >= 16) {
            c44829lf.mo72030a(c31000cw);
        }
        AppMethodBeat.m2505o(99874);
        return true;
    }

    public boolean onIndoorBuildingDeactivated() {
        AppMethodBeat.m2504i(99875);
        if (this.f16514a == null) {
            AppMethodBeat.m2505o(99875);
            return false;
        }
        this.f16514a.onIndoorBuildingDeactivated();
        if (this.f16514a.f14283r != null) {
            this.f16514a.f14283r.onIndoorBuildingDeactivated();
        }
        C44829lf c44829lf = this.f16514a.f14275j;
        if (c44829lf != null) {
            c44829lf.mo72032b(false);
        }
        AppMethodBeat.m2505o(99875);
        return true;
    }
}
