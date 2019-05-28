package com.tencent.p177mm.p612ui.p615c.p1344a;

import android.view.animation.CycleInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.c.a.b */
public final class C30411b extends CycleInterpolator {
    public C30411b() {
        super(0.5f);
    }

    public final float getInterpolation(float f) {
        AppMethodBeat.m2504i(106219);
        float pow = (float) (1.0d - Math.pow((double) ((2.0f * f) - 1.0f), 2.0d));
        AppMethodBeat.m2505o(106219);
        return pow;
    }
}
