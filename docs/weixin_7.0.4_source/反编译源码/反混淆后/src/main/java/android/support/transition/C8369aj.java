package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

/* renamed from: android.support.transition.aj */
final class C8369aj {

    /* renamed from: android.support.transition.aj$a */
    static class C8370a extends AnimatorListenerAdapter {
        /* renamed from: AI */
        private final View f2316AI;
        /* renamed from: AJ */
        private final View f2317AJ;
        /* renamed from: AK */
        private final int f2318AK;
        /* renamed from: AL */
        private final int f2319AL;
        /* renamed from: AM */
        private int[] f2320AM;
        /* renamed from: AN */
        private float f2321AN;
        /* renamed from: AO */
        private float f2322AO;
        /* renamed from: AP */
        private final float f2323AP;
        /* renamed from: AQ */
        private final float f2324AQ;

        /* synthetic */ C8370a(View view, View view2, int i, int i2, float f, float f2, byte b) {
            this(view, view2, i, i2, f, f2);
        }

        private C8370a(View view, View view2, int i, int i2, float f, float f2) {
            this.f2317AJ = view;
            this.f2316AI = view2;
            this.f2318AK = i - Math.round(this.f2317AJ.getTranslationX());
            this.f2319AL = i2 - Math.round(this.f2317AJ.getTranslationY());
            this.f2323AP = f;
            this.f2324AQ = f2;
            this.f2320AM = (int[]) this.f2316AI.getTag(2131820682);
            if (this.f2320AM != null) {
                this.f2316AI.setTag(2131820682, null);
            }
        }

        public final void onAnimationCancel(Animator animator) {
            if (this.f2320AM == null) {
                this.f2320AM = new int[2];
            }
            this.f2320AM[0] = Math.round(((float) this.f2318AK) + this.f2317AJ.getTranslationX());
            this.f2320AM[1] = Math.round(((float) this.f2319AL) + this.f2317AJ.getTranslationY());
            this.f2316AI.setTag(2131820682, this.f2320AM);
        }

        public final void onAnimationEnd(Animator animator) {
            this.f2317AJ.setTranslationX(this.f2323AP);
            this.f2317AJ.setTranslationY(this.f2324AQ);
        }

        public final void onAnimationPause(Animator animator) {
            this.f2321AN = this.f2317AJ.getTranslationX();
            this.f2322AO = this.f2317AJ.getTranslationY();
            this.f2317AJ.setTranslationX(this.f2323AP);
            this.f2317AJ.setTranslationY(this.f2324AQ);
        }

        public final void onAnimationResume(Animator animator) {
            this.f2317AJ.setTranslationX(this.f2321AN);
            this.f2317AJ.setTranslationY(this.f2322AO);
        }
    }

    /* renamed from: a */
    static Animator m14773a(View view, C8368ah c8368ah, int i, int i2, float f, float f2, float f3, float f4, TimeInterpolator timeInterpolator) {
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c8368ah.view.getTag(2131820682);
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
        C8370a c8370a = new C8370a(view, c8368ah.view, round, round2, translationX, translationY, (byte) 0);
        ofPropertyValuesHolder.addListener(c8370a);
        C37102a.m62100a(ofPropertyValuesHolder, c8370a);
        ofPropertyValuesHolder.setInterpolator(timeInterpolator);
        return ofPropertyValuesHolder;
    }
}
