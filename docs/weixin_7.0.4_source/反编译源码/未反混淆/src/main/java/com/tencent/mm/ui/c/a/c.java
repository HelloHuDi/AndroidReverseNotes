package com.tencent.mm.ui.c.a;

import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class c extends DecelerateInterpolator {
    public final float getInterpolation(float f) {
        AppMethodBeat.i(106220);
        if (((double) f) <= 0.5d) {
            float interpolation = super.getInterpolation(2.0f * f);
            AppMethodBeat.o(106220);
            return interpolation;
        }
        AppMethodBeat.o(106220);
        return 1.0f;
    }
}
