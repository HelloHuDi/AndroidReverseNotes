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

public final class b extends a {
    public b(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.i(8581);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8573);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                b.this.uCm = layoutParams.leftMargin - b.this.oIe;
                AppMethodBeat.o(8573);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.i(8574);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                b.this.uCl = (int) view6.getX();
                AppMethodBeat.o(8574);
                return true;
            }
        });
        AppMethodBeat.o(8581);
    }

    public final void b(com.tencent.mm.plugin.webview.ui.tools.fts.a.b bVar) {
        AppMethodBeat.i(8582);
        a(bVar, true);
        AppMethodBeat.o(8582);
    }

    public final void a(com.tencent.mm.plugin.webview.ui.tools.fts.a.b bVar, boolean z) {
        AppMethodBeat.i(8583);
        if (bVar == this.uCx) {
            AppMethodBeat.o(8583);
            return;
        }
        switch (bVar) {
            case Init:
                dbQ();
                AppMethodBeat.o(8583);
                return;
            case Search:
                if (!z) {
                    dbS();
                    break;
                }
                dbR();
                AppMethodBeat.o(8583);
                return;
        }
        AppMethodBeat.o(8583);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.i(8584);
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
                AppMethodBeat.i(8575);
                b.this.isAnimating = true;
                if (b.this.uCy != null) {
                    b.this.uCy.onAnimationStart();
                }
                b.this.uCo.setVisibility(0);
                AppMethodBeat.o(8575);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8576);
                b.this.isAnimating = false;
                if (b.this.uCy != null) {
                    b.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8576);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8584);
    }

    private void dbS() {
        AppMethodBeat.i(8585);
        this.uCo.setAlpha(0.0f);
        this.uCn.setPadding(this.uCm, 0, 0, 0);
        int i = this.uCj;
        LayoutParams layoutParams = (LayoutParams) this.uCn.getLayoutParams();
        layoutParams.leftMargin = this.uCj - i;
        layoutParams.rightMargin = this.uCj - i;
        layoutParams.width = (i * 2) + ((int) this.uCw[2][0]);
        this.uCn.setLayoutParams(layoutParams);
        this.uCn.post(new Runnable() {
            public final void run() {
                AppMethodBeat.i(8577);
                b.this.uCn.setY(b.this.uCw[0][1]);
                b.this.uCn.setX(b.this.uCw[1][1]);
                AppMethodBeat.o(8577);
            }
        });
        AppMethodBeat.o(8585);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.i(8586);
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
                AppMethodBeat.i(8578);
                b.this.isAnimating = true;
                if (b.this.uCy != null) {
                    b.this.uCy.onAnimationStart();
                }
                AppMethodBeat.o(8578);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(8579);
                b.this.isAnimating = false;
                if (b.this.uCy != null) {
                    b.this.uCy.onAnimationEnd();
                }
                AppMethodBeat.o(8579);
            }

            public final void onAnimationCancel(Animator animator) {
                b.this.isAnimating = false;
            }

            public final void onAnimationRepeat(Animator animator) {
            }
        });
        animatorSet.start();
        AppMethodBeat.o(8586);
    }
}
