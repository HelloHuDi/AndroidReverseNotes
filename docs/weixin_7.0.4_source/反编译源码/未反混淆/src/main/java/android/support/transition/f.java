package android.support.transition;

import android.animation.TypeEvaluator;

final class f implements TypeEvaluator<float[]> {
    private float[] yu;

    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        Object obj3 = this.yu;
        if (obj3 == null) {
            obj3 = new float[fArr.length];
        }
        for (int i = 0; i < obj3.length; i++) {
            float f2 = fArr[i];
            obj3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return obj3;
    }

    f(float[] fArr) {
        this.yu = fArr;
    }
}
