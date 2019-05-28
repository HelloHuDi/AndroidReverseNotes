package com.tencent.p177mm.plugin.appbrand.widget.p337b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.plugin.appbrand.widget.b.i */
final class C45711i {
    ValueAnimator jcQ;
    private int jcR;
    View view;

    /* renamed from: com.tencent.mm.plugin.appbrand.widget.b.i$2 */
    class C109402 implements AnimatorUpdateListener {
        C109402() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(77421);
            if (C45711i.this.view != null) {
                C45711i.this.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
            AppMethodBeat.m2505o(77421);
        }
    }

    public C45711i(View view) {
        this.view = view;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: c */
    public final void mo73502c(int i, final Runnable runnable) {
        AppMethodBeat.m2504i(77422);
        if (this.view == null) {
            AppMethodBeat.m2505o(77422);
            return;
        }
        this.jcR = i;
        if ((this.view.getBackground() instanceof ColorDrawable) && ((ColorDrawable) this.view.getBackground()).getColor() == i) {
            if (runnable != null) {
                runnable.run();
            }
            if (this.jcQ != null) {
                this.jcQ.cancel();
            }
            AppMethodBeat.m2505o(77422);
            return;
        }
        C457101 c457101 = new AnimatorListenerAdapter() {
            public final void onAnimationCancel(Animator animator) {
                C45711i.this.jcQ = null;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(77420);
                if (runnable != null) {
                    runnable.run();
                }
                C45711i.this.jcQ = null;
                AppMethodBeat.m2505o(77420);
            }
        };
        if (this.jcQ != null && this.jcQ.isStarted() && this.jcQ.isRunning() && this.jcR == i) {
            this.jcQ.addListener(c457101);
            AppMethodBeat.m2505o(77422);
            return;
        }
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
        this.jcQ = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.jcR)});
        this.jcQ.addListener(c457101);
        this.jcQ.addUpdateListener(new C109402());
        this.jcQ.start();
        AppMethodBeat.m2505o(77422);
    }
}
