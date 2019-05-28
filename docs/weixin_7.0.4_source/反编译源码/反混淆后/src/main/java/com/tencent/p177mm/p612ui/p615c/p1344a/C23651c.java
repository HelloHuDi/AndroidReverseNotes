package com.tencent.p177mm.p612ui.p615c.p1344a;

import android.view.animation.DecelerateInterpolator;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.ui.c.a.c */
public final class C23651c extends DecelerateInterpolator {
    public final float getInterpolation(float f) {
        AppMethodBeat.m2504i(106220);
        if (((double) f) <= 0.5d) {
            float interpolation = super.getInterpolation(2.0f * f);
            AppMethodBeat.m2505o(106220);
            return interpolation;
        }
        AppMethodBeat.m2505o(106220);
        return 1.0f;
    }
}
