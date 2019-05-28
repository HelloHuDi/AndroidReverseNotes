package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.fts.a.b;

public final class c extends a {
    public c(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.i(8594);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8587);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                c.this.uCm = layoutParams.leftMargin - c.this.oIe;
                AppMethodBeat.o(8587);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8588);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                c.this.uCl = (int) view6.getX();
                AppMethodBeat.o(8588);
                return true;
            }
        });
        AppMethodBeat.o(8594);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.i(8596);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.uCw[0][0] - ((float) this.uCk) >= 0.0f) {
            ofFloat.addUpdateListener(this.uCB);
        } else {
            ofFloat.addUpdateListener(this.uCC);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uCv, "alpha", new float[]{0.0f, 1.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.uCo, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(8589);
                c.this.isAnimating = true;
                if (c.this.uCy != null) {
                    c.this.uCy.onAnimationStart();
                }
                c.this.uCo.setVisibility(0);
                AppMethodBeat.o(8589);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8590);
                c.this.isAnimating = false;
                if (c.this.uCy != null) {
                    c.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8590);
            }

            public final void onAnimationCancel(Animator animator) {
                c.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8596);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.i(8597);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.uCw[0][0] - ((float) this.uCk) >= 0.0f) {
            ofFloat.addUpdateListener(this.uCz);
        } else {
            ofFloat.addUpdateListener(this.uCA);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uCv, "alpha", new float[]{1.0f, 0.0f});
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.uCo, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat3, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(8591);
                c.this.isAnimating = true;
                if (c.this.uCy != null) {
                    c.this.uCy.onAnimationStart();
                }
                AppMethodBeat.o(8591);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8592);
                c.this.isAnimating = false;
                if (c.this.uCy != null) {
                    c.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8592);
            }

            public final void onAnimationCancel(Animator animator) {
                c.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8597);
    }

    public final void b(b bVar) {
        AppMethodBeat.i(8595);
        if (bVar != this.uCx) {
            switch (bVar) {
                case Init:
                    dbQ();
                    AppMethodBeat.o(8595);
                    return;
                case Search:
                    dbR();
                    break;
            }
        }
        AppMethodBeat.o(8595);
    }
}
