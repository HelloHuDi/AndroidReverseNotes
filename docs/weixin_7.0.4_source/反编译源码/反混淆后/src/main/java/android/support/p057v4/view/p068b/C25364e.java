package android.support.p057v4.view.p068b;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* renamed from: android.support.v4.view.b.e */
final class C25364e implements Interpolator {
    /* renamed from: uH */
    private final float[] f5196uH;
    /* renamed from: uI */
    private final float[] f5197uI;

    C25364e(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f5196uH = new float[i];
        this.f5197uI = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((((float) i2) * length) / ((float) (i - 1)), fArr, null);
            this.f5196uH[i2] = fArr[0];
            this.f5197uI[i2] = fArr[1];
        }
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f5196uH.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f5196uH[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f5196uH[length] - this.f5196uH[i];
        if (f2 == 0.0f) {
            return this.f5197uI[i];
        }
        float f3 = (f - this.f5196uH[i]) / f2;
        f2 = this.f5197uI[i];
        return (f3 * (this.f5197uI[length] - f2)) + f2;
    }
}
