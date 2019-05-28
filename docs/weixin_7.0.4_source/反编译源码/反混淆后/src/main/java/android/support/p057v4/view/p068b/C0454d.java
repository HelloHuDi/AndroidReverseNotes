package android.support.p057v4.view.p068b;

import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.b.d */
abstract class C0454d implements Interpolator {
    /* renamed from: Os */
    private final float f551Os = (1.0f / ((float) (this.f552yh.length - 1)));
    /* renamed from: yh */
    private final float[] f552yh;

    protected C0454d(float[] fArr) {
        this.f552yh = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.f552yh.length - 1)) * f), this.f552yh.length - 2);
        float f2 = (f - (((float) min) * this.f551Os)) / this.f551Os;
        return ((this.f552yh[min + 1] - this.f552yh[min]) * f2) + this.f552yh[min];
    }
}
