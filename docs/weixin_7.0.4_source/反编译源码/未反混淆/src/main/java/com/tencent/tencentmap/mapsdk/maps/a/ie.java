package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ie extends if {
    private float e = 0.0f;
    private float f = 0.0f;

    public ie(float f, float f2) {
        this.e = f;
        this.f = f2;
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99836);
        float interpolation = ((this.f - this.e) * interpolator.getInterpolation(f)) + this.e;
        if (this.d != null) {
            this.d.a(interpolation);
        }
        AppMethodBeat.o(99836);
    }
}
