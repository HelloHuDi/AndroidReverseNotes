package com.tencent.tencentmap.mapsdk.maps.a;

import android.view.animation.Interpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.a.db;

public class ih extends if {
    private db e = null;

    public ih(db dbVar) {
        this.e = dbVar;
    }

    /* Access modifiers changed, original: protected */
    public void a(float f, Interpolator interpolator) {
        AppMethodBeat.i(99843);
        float interpolation = interpolator.getInterpolation(f);
        if (this.d != null) {
            this.d.b(interpolation);
        }
        AppMethodBeat.o(99843);
    }

    public db g() {
        return this.e;
    }
}
