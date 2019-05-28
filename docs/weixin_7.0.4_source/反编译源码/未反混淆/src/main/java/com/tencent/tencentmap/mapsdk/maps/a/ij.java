package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ij extends if {
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;

    public ij(float f, float f2, float f3, float f4) {
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99845);
        if (f < 0.0f) {
            AppMethodBeat.o(99845);
            return;
        }
        float f2 = this.f - this.e;
        float f3 = this.h - this.g;
        float interpolation = interpolator.getInterpolation(f);
        f2 = (f2 * interpolation) + this.e;
        f3 = (f3 * interpolation) + this.g;
        if (this.d != null) {
            this.d.a(f2, f3);
        }
        AppMethodBeat.o(99845);
    }
}
