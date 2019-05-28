package android.support.design.widget;

import android.support.p057v4.view.p068b.C6198a;
import android.support.p057v4.view.p068b.C6199b;
import android.support.p057v4.view.p068b.C6200c;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

/* renamed from: android.support.design.widget.a */
final class C31841a {
    /* renamed from: mf */
    static final Interpolator f14579mf = new LinearInterpolator();
    /* renamed from: mg */
    static final Interpolator f14580mg = new C6199b();
    /* renamed from: mh */
    static final Interpolator f14581mh = new C6198a();
    /* renamed from: mi */
    static final Interpolator f14582mi = new C6200c();
    /* renamed from: mj */
    static final Interpolator f14583mj = new DecelerateInterpolator();

    /* renamed from: b */
    static float m51586b(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    /* renamed from: b */
    static int m51587b(int i, int i2, float f) {
        return Math.round(((float) (i2 - i)) * f) + i;
    }
}
