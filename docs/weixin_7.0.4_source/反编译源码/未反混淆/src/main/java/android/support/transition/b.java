package android.support.transition;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import java.util.ArrayList;

final class b implements d {

    interface a {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    b() {
    }

    public final void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
    }

    public final void b(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }

    public final void c(Animator animator) {
        ArrayList listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                AnimatorListener animatorListener = (AnimatorListener) listeners.get(i);
                if (animatorListener instanceof a) {
                    ((a) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }
}
