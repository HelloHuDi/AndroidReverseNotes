package com.tencent.mm.plugin.appbrand.widget.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class i {
    ValueAnimator jcQ;
    private int jcR;
    View view;

    public i(View view) {
        this.view = view;
    }

    /* Access modifiers changed, original: final */
    public final void c(int i, final Runnable runnable) {
        AppMethodBeat.i(77422);
        if (this.view == null) {
            AppMethodBeat.o(77422);
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
            AppMethodBeat.o(77422);
            return;
        }
        AnonymousClass1 anonymousClass1 = new AnimatorListenerAdapter() {
            public final void onAnimationCancel(Animator animator) {
                i.this.jcQ = null;
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(77420);
                if (runnable != null) {
                    runnable.run();
                }
                i.this.jcQ = null;
                AppMethodBeat.o(77420);
            }
        };
        if (this.jcQ != null && this.jcQ.isStarted() && this.jcQ.isRunning() && this.jcR == i) {
            this.jcQ.addListener(anonymousClass1);
            AppMethodBeat.o(77422);
            return;
        }
        if (this.jcQ != null) {
            this.jcQ.cancel();
        }
        int color = this.view.getBackground() instanceof ColorDrawable ? ((ColorDrawable) this.view.getBackground()).getColor() : 0;
        this.jcQ = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(color), Integer.valueOf(this.jcR)});
        this.jcQ.addListener(anonymousClass1);
        this.jcQ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(77421);
                if (i.this.view != null) {
                    i.this.view.setBackgroundColor(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
                AppMethodBeat.o(77421);
            }
        });
        this.jcQ.start();
        AppMethodBeat.o(77422);
    }
}
