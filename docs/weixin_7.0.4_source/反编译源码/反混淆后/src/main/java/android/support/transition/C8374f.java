package android.support.transition;

import android.animation.TypeEvaluator;

/* renamed from: android.support.transition.f */
final class C8374f implements TypeEvaluator<float[]> {
    /* renamed from: yu */
    private float[] f2330yu;

    public final /* bridge */ /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
        float[] fArr = (float[]) obj;
        float[] fArr2 = (float[]) obj2;
        Object obj3 = this.f2330yu;
        if (obj3 == null) {
            obj3 = new float[fArr.length];
        }
        for (int i = 0; i < obj3.length; i++) {
            float f2 = fArr[i];
            obj3[i] = f2 + ((fArr2[i] - f2) * f);
        }
        return obj3;
    }

    C8374f(float[] fArr) {
        this.f2330yu = fArr;
    }
}
