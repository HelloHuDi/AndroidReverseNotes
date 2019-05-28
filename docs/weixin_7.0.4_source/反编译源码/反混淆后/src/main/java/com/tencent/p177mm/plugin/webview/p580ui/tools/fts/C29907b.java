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

/* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.b */
public final class C29907b extends C40306a {

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.b$4 */
    class C229694 implements Runnable {
        C229694() {
        }

        public final void run() {
            AppMethodBeat.m2504i(8577);
            C29907b.this.uCn.setY(C29907b.this.uCw[0][1]);
            C29907b.this.uCn.setX(C29907b.this.uCw[1][1]);
            AppMethodBeat.m2505o(8577);
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.b$3 */
    class C299063 implements AnimatorListener {
        C299063() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8575);
            C29907b.this.isAnimating = true;
            if (C29907b.this.uCy != null) {
                C29907b.this.uCy.onAnimationStart();
            }
            C29907b.this.uCo.setVisibility(0);
            AppMethodBeat.m2505o(8575);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8576);
            C29907b.this.isAnimating = false;
            if (C29907b.this.uCy != null) {
                C29907b.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8576);
        }

        public final void onAnimationCancel(Animator animator) {
            C29907b.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    /* renamed from: com.tencent.mm.plugin.webview.ui.tools.fts.b$5 */
    class C299085 implements AnimatorListener {
        C299085() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(8578);
            C29907b.this.isAnimating = true;
            if (C29907b.this.uCy != null) {
                C29907b.this.uCy.onAnimationStart();
            }
            AppMethodBeat.m2505o(8578);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(8579);
            C29907b.this.isAnimating = false;
            if (C29907b.this.uCy != null) {
                C29907b.this.uCy.onAnimationEnd();
            }
            AppMethodBeat.m2505o(8579);
        }

        public final void onAnimationCancel(Animator animator) {
            C29907b.this.isAnimating = false;
        }

        public final void onAnimationRepeat(Animator animator) {
        }
    }

    public C29907b(Context context, View view, final View view2, View view3, View view4, View view5, final View view6, View view7, View view8, View view9) {
        super(context, view, view2, view3, view4, view5, view6, view7, view8, view9);
        AppMethodBeat.m2504i(8581);
        view2.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8573);
                view2.getViewTreeObserver().removeOnPreDrawListener(this);
                LayoutParams layoutParams = (LayoutParams) view2.getLayoutParams();
                C29907b.this.uCm = layoutParams.leftMargin - C29907b.this.oIe;
                AppMethodBeat.m2505o(8573);
                return true;
            }
        });
        view6.getViewTreeObserver().addOnPreDrawListener(new OnPreDrawListener() {
            public final boolean onPreDraw() {
                AppMethodBeat.m2504i(8574);
                view6.getViewTreeObserver().removeOnPreDrawListener(this);
                C29907b.this.uCl = (int) view6.getX();
                AppMethodBeat.m2505o(8574);
                return true;
            }
        });
        AppMethodBeat.m2505o(8581);
    }

    /* renamed from: b */
    public final void mo48143b(C40305b c40305b) {
        AppMethodBeat.m2504i(8582);
        mo48142a(c40305b, true);
        AppMethodBeat.m2505o(8582);
    }

    /* renamed from: a */
    public final void mo48142a(C40305b c40305b, boolean z) {
        AppMethodBeat.m2504i(8583);
        if (c40305b == this.uCx) {
            AppMethodBeat.m2505o(8583);
            return;
        }
        switch (c40305b) {
            case Init:
                dbQ();
                AppMethodBeat.m2505o(8583);
                return;
            case Search:
                if (!z) {
                    dbS();
                    break;
                }
                dbR();
                AppMethodBeat.m2505o(8583);
                return;
        }
        AppMethodBeat.m2505o(8583);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbQ() {
        AppMethodBeat.m2504i(8584);
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
        animatorSet.addListener(new C299063());
        animatorSet.start();
        AppMethodBeat.m2505o(8584);
    }

    private void dbS() {
        AppMethodBeat.m2504i(8585);
        this.uCo.setAlpha(0.0f);
        this.uCn.setPadding(this.uCm, 0, 0, 0);
        int i = this.uCj;
        LayoutParams layoutParams = (LayoutParams) this.uCn.getLayoutParams();
        layoutParams.leftMargin = this.uCj - i;
        layoutParams.rightMargin = this.uCj - i;
        layoutParams.width = (i * 2) + ((int) this.uCw[2][0]);
        this.uCn.setLayoutParams(layoutParams);
        this.uCn.post(new C229694());
        AppMethodBeat.m2505o(8585);
    }

    /* Access modifiers changed, original: protected|final */
    public final void dbR() {
        AppMethodBeat.m2504i(8586);
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
        animatorSet.addListener(new C299085());
        animatorSet.start();
        AppMethodBeat.m2505o(8586);
    }
}
