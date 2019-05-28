package com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13665d;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C35118a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.g */
public final class C13642g extends C39833a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    C13665d rGr;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.g$1 */
    class C136441 implements AnimatorUpdateListener {
        C136441() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40034);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                C13642g.this.rGr.contentView.setScaleX(floatValue);
                C13642g.this.rGr.contentView.setScaleY(floatValue);
                C13642g.this.rGr.contentView.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40034);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.g$2 */
    class C136452 implements AnimatorUpdateListener {
        C136452() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40035);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C13642g.this.rGr.rHg.setAlpha(floatValue);
            C13642g.this.rGr.rHf.setAlpha(floatValue);
            AppMethodBeat.m2505o(40035);
        }
    }

    public C13642g(final MMActivity mMActivity, C35118a c35118a) {
        AppMethodBeat.m2504i(40038);
        this.hwd = mMActivity;
        this.rGr = (C13665d) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C136441());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C136452());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGr.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40036);
                C4990ab.m7416i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
                C13642g.this.rGr.rHg.setAlpha(0.0f);
                C13642g.this.rGr.rHf.setAlpha(0.0f);
                C13642g.this.rGr.contentView.getLocationInWindow(C13642g.this.rGg);
                C4990ab.m7417i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", Integer.valueOf(C13642g.this.rGg[0]), Integer.valueOf(C13642g.this.rGg[1]));
                ((ViewGroup) C13642g.this.rGr.rpP).removeView(C13642g.this.rGr.contentView);
                ViewGroup.LayoutParams layoutParams = C13642g.this.rGr.rpP.getLayoutParams();
                layoutParams.width = C13642g.this.rGr.contentView.getWidth();
                layoutParams.height = (C13642g.this.rGr.contentView.getHeight() + C13642g.this.rGn.topMargin) + C13642g.this.rGn.bottomMargin;
                C13642g.this.rGr.rpP.setLayoutParams(layoutParams);
                C13642g.this.rGj = new LayoutParams(-2, -2);
                C13642g.this.rGj.leftMargin = C13642g.this.rGg[0];
                C13642g.this.rGj.rightMargin = (C13642g.this.rGb.getWidth() - C13642g.this.rGj.leftMargin) - C13642g.this.rGr.contentView.getWidth();
                C13642g.this.rGj.topMargin = C13642g.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C13642g.this.rGj.bottomMargin = (C13642g.this.rGb.getHeight() - C13642g.this.rGj.topMargin) - C13642g.this.rGr.contentView.getHeight();
                C13642g.this.rGb.addView(C13642g.this.rGr.contentView, C13642g.this.rGj);
                AppMethodBeat.m2505o(40036);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40037);
                C4990ab.m7416i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) C13642g.this.hwd.mController.ylv.getParent()).removeView(C13642g.this.rGr.contentView);
                ((ViewGroup) C13642g.this.rGr.rpP).addView(C13642g.this.rGr.contentView, C13642g.this.rGn);
                C13642g.this.rGr.contentView.setScaleX(1.0f);
                C13642g.this.rGr.contentView.setScaleY(1.0f);
                C13642g.this.rGr.contentView.setAlpha(1.0f);
                C13642g.this.rGr.rHf.setAlpha(1.0f);
                C13642g.this.rGr.rHg.setAlpha(1.0f);
                if (C13642g.this.rFW != null) {
                    C13642g.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40037);
            }
        });
        AppMethodBeat.m2505o(40038);
    }

    /* renamed from: kM */
    public final void mo8878kM(long j) {
        AppMethodBeat.m2504i(40039);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40039);
    }
}
