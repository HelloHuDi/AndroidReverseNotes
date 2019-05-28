package android.support.v4.view.b;

import android.view.animation.Interpolator;

abstract class d implements Interpolator {
    private final float Os = (1.0f / ((float) (this.yh.length - 1)));
    private final float[] yh;

    protected d(float[] fArr) {
        this.yh = fArr;
    }

    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) (((float) (this.yh.length - 1)) * f), this.yh.length - 2);
        float f2 = (f - (((float) min) * this.Os)) / this.Os;
        return ((this.yh[min + 1] - this.yh[min]) * f2) + this.yh[min];
    }
}
