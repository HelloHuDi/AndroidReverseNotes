package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build.VERSION;

final class a {
    private static final d xc;

    static {
        if (VERSION.SDK_INT >= 19) {
            xc = new c();
        } else {
            xc = new b();
        }
    }

    static void a(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        xc.a(animator, animatorListenerAdapter);
    }

    static void b(Animator animator) {
        xc.b(animator);
    }

    static void c(Animator animator) {
        xc.c(animator);
    }
}
