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
import org.xwalk.core.Log;

public final class d extends a {
    public d(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.i(8604);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8598);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                d.this.uCm = layoutParams.leftMargin - d.this.oIe;
                AppMethodBeat.o(8598);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8599);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                d.this.uCl = 0;
                AppMethodBeat.o(8599);
                return true;
            }
        });
        AppMethodBeat.o(8604);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.i(8605);
        Log.i("MicroMsg.FTS.SosAnimatorController", "search to init");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.uCw[0][0] - ((float) this.uCk) >= 0.0f) {
            ofFloat.addUpdateListener(this.uCB);
        } else {
            ofFloat.addUpdateListener(this.uCC);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uCo, "alpha", new float[]{0.0f, 1.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(8600);
                d.this.isAnimating = true;
                if (d.this.uCy != null) {
                    d.this.uCy.onAnimationStart();
                }
                d.this.uCo.setVisibility(0);
                AppMethodBeat.o(8600);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8601);
                d.this.isAnimating = false;
                if (d.this.uCy != null) {
                    d.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8601);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8605);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.i(8606);
        Log.i("MicroMsg.FTS.SosAnimatorController", "init to search");
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        if (this.uCw[0][0] - ((float) this.uCk) >= 0.0f) {
            ofFloat.addUpdateListener(this.uCz);
        } else {
            ofFloat.addUpdateListener(this.uCA);
        }
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.uCo, "alpha", new float[]{1.0f, 0.0f});
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(new Animator[]{ofFloat, ofFloat2});
        animatorSet.setDuration(300);
        animatorSet.addListener(new AnimatorListener() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(8602);
                d.this.isAnimating = true;
                if (d.this.uCy != null) {
                    d.this.uCy.onAnimationStart();
                }
                AppMethodBeat.o(8602);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8603);
                d.this.isAnimating = false;
                if (d.this.uCy != null) {
                    d.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8603);
            }

            public final void onAnimationCancel(Animator animator) {
                d.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8606);
    }
}
