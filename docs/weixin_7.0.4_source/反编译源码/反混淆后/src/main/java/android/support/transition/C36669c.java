package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* renamed from: android.support.transition.c */
final class C36669c implements C31853d {
    C36669c() {
    }

    /* renamed from: a */
    public final void mo51834a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        animator.addPauseListener(animatorListenerAdapter);
    }

    /* renamed from: b */
    public final void mo51835b(Animator animator) {
        animator.pause();
    }

    /* renamed from: c */
    public final void mo51836c(Animator animator) {
        animator.resume();
    }
}
