package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ie */
public class C41063ie extends C31056if {
    /* renamed from: e */
    private float f16510e = 0.0f;
    /* renamed from: f */
    private float f16511f = 0.0f;

    public C41063ie(float f, float f2) {
        this.f16510e = f;
        this.f16511f = f2;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99836);
        float interpolation = ((this.f16511f - this.f16510e) * interpolator.getInterpolation(f)) + this.f16510e;
        if (this.f14163d != null) {
            this.f14163d.mo29453a(interpolation);
        }
        AppMethodBeat.m2505o(99836);
    }
}
