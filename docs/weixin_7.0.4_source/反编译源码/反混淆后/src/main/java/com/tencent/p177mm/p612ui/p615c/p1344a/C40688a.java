package com.tencent.p177mm.p612ui.p615c.p1344a;

import android.view.animation.BounceInterpolator;

/* renamed from: com.tencent.mm.ui.c.a.a */
public final class C40688a extends BounceInterpolator {
    public final float getInterpolation(float f) {
        if (((double) f) < 0.36363636363636365d) {
            return (float) ((((double) f) * 7.5625d) * ((double) f));
        }
        float f2;
        if (((double) f) < 0.7272727272727273d) {
            f2 = (float) (((double) f) - 0.5454545454545454d);
            return (float) ((((double) f2) * (((double) f2) * 7.5625d)) + 0.75d);
        }
        f2 = (float) (((double) f) - 0.8181818181818182d);
        return (float) ((((double) f2) * (((double) f2) * 7.5625d)) + 0.9375d);
    }
}
