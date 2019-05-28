package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;

/* renamed from: android.support.transition.ag */
final class C25320ag {

    /* renamed from: android.support.transition.ag$a */
    static class C25321a implements TypeEvaluator<Matrix> {
        /* renamed from: AB */
        final float[] f5126AB = new float[9];
        /* renamed from: AC */
        final float[] f5127AC = new float[9];
        /* renamed from: ya */
        final Matrix f5128ya = new Matrix();

        C25321a() {
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            Matrix matrix = (Matrix) obj2;
            ((Matrix) obj).getValues(this.f5126AB);
            matrix.getValues(this.f5127AC);
            for (int i = 0; i < 9; i++) {
                this.f5127AC[i] = ((this.f5127AC[i] - this.f5126AB[i]) * f) + this.f5126AB[i];
            }
            this.f5128ya.setValues(this.f5127AC);
            return this.f5128ya;
        }
    }

    /* renamed from: a */
    static Animator m39949a(Animator animator, Animator animator2) {
        if (animator == null) {
            return animator2;
        }
        if (animator2 == null) {
            return animator;
        }
        Animator animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{animator, animator2});
        return animatorSet;
    }
}
