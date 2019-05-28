package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

final class m {
    private final AnimatorListener rA = new AnimatorListenerAdapter() {
        public final void onAnimationEnd(Animator animator) {
            if (m.this.rz == animator) {
                m.this.rz = null;
            }
        }
    };
    final ArrayList<a> rx = new ArrayList();
    a ry = null;
    ValueAnimator rz = null;

    static class a {
        final int[] rC;
        final ValueAnimator rD;

        a(int[] iArr, ValueAnimator valueAnimator) {
            this.rC = iArr;
            this.rD = valueAnimator;
        }
    }

    m() {
    }

    public final void a(int[] iArr, ValueAnimator valueAnimator) {
        a aVar = new a(iArr, valueAnimator);
        valueAnimator.addListener(this.rA);
        this.rx.add(aVar);
    }
}
