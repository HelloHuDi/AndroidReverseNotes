package android.support.design.widget;

import android.support.v4.view.b.b;
import android.support.v4.view.b.c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

final class a {
    static final Interpolator mf = new LinearInterpolator();
    static final Interpolator mg = new b();
    static final Interpolator mh = new android.support.v4.view.b.a();
    static final Interpolator mi = new c();
    static final Interpolator mj = new DecelerateInterpolator();

    static float b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    static int b(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
