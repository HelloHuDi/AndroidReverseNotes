package android.support.design.widget;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import java.util.ArrayList;

/* renamed from: android.support.design.widget.m */
final class C25313m {
    /* renamed from: rA */
    private final AnimatorListener f5115rA = new C253141();
    /* renamed from: rx */
    final ArrayList<C8349a> f5116rx = new ArrayList();
    /* renamed from: ry */
    C8349a f5117ry = null;
    /* renamed from: rz */
    ValueAnimator f5118rz = null;

    /* renamed from: android.support.design.widget.m$a */
    static class C8349a {
        /* renamed from: rC */
        final int[] f2286rC;
        /* renamed from: rD */
        final ValueAnimator f2287rD;

        C8349a(int[] iArr, ValueAnimator valueAnimator) {
            this.f2286rC = iArr;
            this.f2287rD = valueAnimator;
        }
    }

    /* renamed from: android.support.design.widget.m$1 */
    class C253141 extends AnimatorListenerAdapter {
        C253141() {
        }

        public final void onAnimationEnd(Animator animator) {
            if (C25313m.this.f5118rz == animator) {
                C25313m.this.f5118rz = null;
            }
        }
    }

    C25313m() {
    }

    /* renamed from: a */
    public final void mo42264a(int[] iArr, ValueAnimator valueAnimator) {
        C8349a c8349a = new C8349a(iArr, valueAnimator);
        valueAnimator.addListener(this.f5115rA);
        this.f5116rx.add(c8349a);
    }
}
