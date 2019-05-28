package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ii extends if {
    private float e = 0.0f;
    private float f = 0.0f;
    private float g = 0.0f;
    private float h = 0.0f;
    private float i = 0.0f;

    public ii(float f, float f2, float f3, float f4, float f5) {
        this.e = f;
        this.f = f2;
        this.g = f3;
        this.h = f4;
        this.i = f5;
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99844);
        float interpolation = ((this.f - this.e) * interpolator.getInterpolation(f)) + this.e;
        if (this.d != null) {
            this.d.a(interpolation, this.g, this.h, this.i);
        }
        AppMethodBeat.o(99844);
    }
}
