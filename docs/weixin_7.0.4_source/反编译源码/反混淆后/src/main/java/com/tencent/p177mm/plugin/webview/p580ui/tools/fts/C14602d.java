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
import org.xwalk.core.Log;

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.d */
public final class C14602d extends C40306a {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.d$4 */
    class C146044 implements AnimatorListener {
        C146044() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8602);
            C14602d.this.isAnimating = true;
            if (C14602d.this.uCy != null) {
                C14602d.this.uCy.onAnimationStart();
            }
            AppMethodBeat.m2505o(8602);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8603);
            C14602d.this.isAnimating = false;
            if (C14602d.this.uCy != null) {
                C14602d.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8603);
        }

        public final void onAnimationCancel(Animator animator) {
            C14602d.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.d$3 */
    class C146053 implements AnimatorListener {
        C146053() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8600);
            C14602d.this.isAnimating = true;
            if (C14602d.this.uCy != null) {
                C14602d.this.uCy.onAnimationStart();
            }
            C14602d.this.uCo.setVisibility(0);
            AppMethodBeat.m2505o(8600);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8601);
            C14602d.this.isAnimating = false;
            if (C14602d.this.uCy != null) {
                C14602d.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8601);
        }

        public final void onAnimationCancel(Animator animator) {
            C14602d.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public C14602d(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.m2504i(8604);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8598);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                C14602d.this.uCm = layoutParams.leftMargin - C14602d.this.oIe;
                AppMethodBeat.m2505o(8598);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8599);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                C14602d.this.uCl = 0;
                AppMethodBeat.m2505o(8599);
                return true;
            }
        });
        AppMethodBeat.m2505o(8604);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.m2504i(8605);
        Log.m81049i("MicroMsg.FTS.SosAnimatorController", "search to init");
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
        animatorSet.addListener(new C146053());
        animatorSet.start();
        AppMethodBeat.m2505o(8605);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.m2504i(8606);
        Log.m81049i("MicroMsg.FTS.SosAnimatorController", "init to search");
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
        animatorSet.addListener(new C146044());
        animatorSet.start();
        AppMethodBeat.m2505o(8606);
    }
}
