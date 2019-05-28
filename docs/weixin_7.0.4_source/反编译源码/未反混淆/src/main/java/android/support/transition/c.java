package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

final class c implements d {
    c() {
    }

    public final void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    public final void b(Animator animator) {
        animator.pause();
    }

    public final void c(Animator animator) {
        animator.resume();
    }
}
