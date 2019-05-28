package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

/* renamed from: android.support.transition.b */
final class C44951b implements C31853d {

    /* renamed from: android.support.transition.b$a */
    interface C25326a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    C44951b() {
    }

    /* renamed from: a */
    public final void mo51834a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    /* renamed from: b */
    public final void mo51835b(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof C25326a) {
                    ((C25326a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    /* renamed from: c */
    public final void mo51836c(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof C25326a) {
                    ((C25326a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
