package com.tencent.tencentmap.mapsdk.maps.p667a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.tencentmap.mapsdk.maps.a.ij */
public class C44523ij extends C31056if {
    /* renamed from: e */
    private float f17439e = 0.0f;
    /* renamed from: f */
    private float f17440f = 0.0f;
    /* renamed from: g */
    private float f17441g = 0.0f;
    /* renamed from: h */
    private float f17442h = 0.0f;

    public C44523ij(float f, float f2, float f3, float f4) {
        this.f17439e = f;
        this.f17440f = f2;
        this.f17441g = f3;
        this.f17442h = f4;
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: a */
    public void mo29509a(float f, Interpolator interpolator) {
        AppMethodBeat.m2504i(99845);
        if (f < 0.0f) {
            AppMethodBeat.m2505o(99845);
            return;
        }
        float f2 = this.f17440f - this.f17439e;
        float f3 = this.f17442h - this.f17441g;
        float interpolation = interpolator.getInterpolation(f);
        f2 = (f2 * interpolation) + this.f17439e;
        f3 = (f3 * interpolation) + this.f17441g;
        if (this.f14163d != null) {
            this.f14163d.mo29454a(f2, f3);
        }
        AppMethodBeat.m2505o(99845);
    }
}
