package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.TypeEvaluator;
import android.graphics.Matrix;

final class ag {

    static class a implements TypeEvaluator<Matrix> {
        final float[] AB = new float[9];
        final float[] AC = new float[9];
        final Matrix ya = new Matrix();

        a() {
        }

        public final /* synthetic */ Object evaluate(float f, Object obj, Object obj2) {
            Matrix matrix = (Matrix) obj2;
            ((Matrix) obj).getValues(this.AB);
            matrix.getValues(this.AC);
            for (int i = 0; i < 9; i++) {
                this.AC[i] = ((this.AC[i] - this.AB[i]) * f) + this.AB[i];
            }
            this.ya.setValues(this.AC);
            return this.ya;
        }
    }

    static Animator a(Animator animator, Animator animator2) {
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
