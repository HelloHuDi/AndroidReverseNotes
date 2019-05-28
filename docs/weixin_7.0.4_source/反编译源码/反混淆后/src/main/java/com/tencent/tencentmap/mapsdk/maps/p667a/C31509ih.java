package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.p666a.C24343db;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ih */
public class C31509ih extends C31056if {
    /* renamed from: e */
    private C24343db f14409e = null;

    public C31509ih(C24343db c24343db) {
        this.f14409e = c24343db;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99843);
        float interpolation = interpolator.getInterpolation(f);
        if (this.f14163d != null) {
            this.f14163d.mo29457b(interpolation);
        }
        AppMethodBeat.m2505o(99843);
    }

    /* renamed from: g */
    public C24343db mo29513g() {
        return this.f14409e;
    }
}
