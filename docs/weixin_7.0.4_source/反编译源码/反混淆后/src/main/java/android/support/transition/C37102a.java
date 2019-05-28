package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

/* renamed from: android.support.transition.a */
final class C37102a {
    /* renamed from: xc */
    private static final C31853d f15730xc;

    static {
        if (VERSION.SDK_INT >= 19) {
            f15730xc = new C36669c();
        } else {
            f15730xc = new C44951b();
        }
    }

    /* renamed from: a */
    static void m62100a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        f15730xc.mo51834a(animator, animatorListenerAdapter);
    }

    /* renamed from: b */
    static void m62101b(Animator animator) {
        f15730xc.mo51835b(animator);
    }

    /* renamed from: c */
    static void m62102c(Animator animator) {
        f15730xc.mo51836c(animator);
    }
}
