package com.tencent.p177mm.plugin.webview.p580ui.tools.fts;

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
import com.tencent.p177mm.plugin.webview.p580ui.tools.fts.C40306a.C40305b;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.c */
public final class C29911c extends C40306a {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.c$3 */
    class C299133 implements AnimatorListener {
        C299133() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8589);
            C29911c.this.isAnimating = true;
            if (C29911c.this.uCy != null) {
                C29911c.this.uCy.onAnimationStart();
            }
            C29911c.this.uCo.setVisibility(0);
            AppMethodBeat.m2505o(8589);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8590);
            C29911c.this.isAnimating = false;
            if (C29911c.this.uCy != null) {
                C29911c.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8590);
        }

        public final void onAnimationCancel(Animator animator) {
            C29911c.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.c$4 */
    class C299144 implements AnimatorListener {
        C299144() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8591);
            C29911c.this.isAnimating = true;
            if (C29911c.this.uCy != null) {
                C29911c.this.uCy.onAnimationStart();
            }
            AppMethodBeat.m2505o(8591);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8592);
            C29911c.this.isAnimating = false;
            if (C29911c.this.uCy != null) {
                C29911c.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8592);
        }

        public final void onAnimationCancel(Animator animator) {
            C29911c.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public C29911c(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.m2504i(8594);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8587);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                C29911c.this.uCm = layoutParams.leftMargin - C29911c.this.oIe;
                AppMethodBeat.m2505o(8587);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8588);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                C29911c.this.uCl = (int) view6.getX();
                AppMethodBeat.m2505o(8588);
                return true;
            }
        });
        AppMethodBeat.m2505o(8594);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.m2504i(8596);
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
        animatorSet.addListener(new C299133());
        animatorSet.start();
        AppMethodBeat.m2505o(8596);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.m2504i(8597);
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
        animatorSet.addListener(new C299144());
        animatorSet.start();
        AppMethodBeat.m2505o(8597);
    }

    /* renamed from: b */
    public final void mo48143b(C40305b c40305b) {
        AppMethodBeat.m2504i(8595);
        if (c40305b != this.uCx) {
            switch (c40305b) {
                case Init:
                    dbQ();
                    AppMethodBeat.m2505o(8595);
                    return;
                case Search:
                    dbR();
                    break;
            }
        }
        AppMethodBeat.m2505o(8595);
    }
}
