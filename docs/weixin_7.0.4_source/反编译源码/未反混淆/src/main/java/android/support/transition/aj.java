package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;
import com.tencent.mm.R;

final class aj {

    static class a extends AnimatorListenerAdapter {
        private final View AI;
        private final View AJ;
        private final int AK;
        private final int AL;
        private int[] AM;
        private float AN;
        private float AO;
        private final float AP;
        private final float AQ;

        /* synthetic */ a(View view, View view2, int i, int i2, float f, float f2, byte b) {
            this(view, view2, i, i2, f, f2);
        }

        private a(View view, View view2, int i, int i2, float f, float f2) {
            this.AJ = view;
            this.AI = view2;
            this.AK = i - Math.round(this.AJ.getTranslationX());
            this.AL = i2 - Math.round(this.AJ.getTranslationY());
            this.AP = f;
            this.AQ = f2;
            this.AM = (int[]) this.AI.getTag(R.id.d1);
            if (this.AM != null) {
                this.AI.setTag(R.id.d1, null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.AM == null) {
                this.AM = new int[2];
            }
            this.AM[0] = Math.round(((float) this.AK) + this.AJ.getTranslationX());
            this.AM[1] = Math.round(((float) this.AL) + this.AJ.getTranslationY());
            this.AI.setTag(R.id.d1, this.AM);
        }

        public final void onAnimationEnd(Animator animator) {
            this.AJ.setTranslationX(this.AP);
            this.AJ.setTranslationY(this.AQ);
        }

        public final void onAnimationPause(Animator animator) {
            this.AN = this.AJ.getTranslationX();
            this.AO = this.AJ.getTranslationY();
            this.AJ.setTranslationX(this.AP);
            this.AJ.setTranslationY(this.AQ);
        }

        public final void onAnimationResume(Animator animator) {
            this.AJ.setTranslationX(this.AN);
            this.AJ.setTranslationY(this.AO);
        }
    }

    static Animator a(View view, ah ahVar, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) ahVar.view.getTag(R.id.d1);
        if (iArr != null) {
            f = ((float) (iArr[0] - i)) + translationX;
            f2 = ((float) (iArr[1] - i2)) + translationY;
        }
        int round = i + Math.round(f - translationX);
        int round2 = i2 + Math.round(f2 - translationY);
        view.setTranslationX(f);
        view.setTranslationY(f2);
        if (f == f3 && f2 == f4) {
            return null;
        }
        PropertyValuesHolder[] propertyValuesHolderArr = new PropertyValuesHolder[2];
        propertyValuesHolderArr[0] = PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{f, f3});
        propertyValuesHolderArr[1] = PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{f2, f4});
        Animator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, propertyValuesHolderArr);
        a aVar = new a(view, ahVar.view, round, round2, translationX, translationY, (byte) 0);
        ofPropertyValuesHolder.addListener(aVar);
        a.a(ofPropertyValuesHolder, aVar);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
