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

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.h */
public final class C4033h extends C46252b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    C13665d rGr;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.h$1 */
    class C40341 implements AnimatorUpdateListener {
        C40341() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40040);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) floatValue) != 1.0d) {
                C4033h.this.rGr.contentView.setScaleX(floatValue);
                C4033h.this.rGr.contentView.setScaleY(floatValue);
                C4033h.this.rGr.contentView.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40040);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.h$2 */
    class C40352 implements AnimatorUpdateListener {
        C40352() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40041);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4033h.this.rGr.rHg.setAlpha(floatValue);
            C4033h.this.rGr.rHf.setAlpha(floatValue);
            AppMethodBeat.m2505o(40041);
        }
    }

    public C4033h(final MMActivity mMActivity, C35118a c35118a) {
        AppMethodBeat.m2504i(40044);
        this.hwd = mMActivity;
        this.rGr = (C13665d) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C40341());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C40352());
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGr.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40042);
                C4990ab.m7416i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
                C4033h.this.rGr.contentView.getLocationInWindow(C4033h.this.rGg);
                C4990ab.m7417i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", Integer.valueOf(C4033h.this.rGg[0]), Integer.valueOf(C4033h.this.rGg[1]));
                ((ViewGroup) C4033h.this.rGr.rpP).removeView(C4033h.this.rGr.contentView);
                ViewGroup.LayoutParams layoutParams = C4033h.this.rGr.rpP.getLayoutParams();
                layoutParams.width = C4033h.this.rGr.contentView.getWidth();
                layoutParams.height = (C4033h.this.rGr.contentView.getHeight() + C4033h.this.rGn.topMargin) + C4033h.this.rGn.bottomMargin;
                C4033h.this.rGr.rpP.setLayoutParams(layoutParams);
                C4033h.this.rGj = new LayoutParams(-2, -2);
                C4033h.this.rGj.leftMargin = C4033h.this.rGg[0];
                C4033h.this.rGj.rightMargin = (C4033h.this.rGb.getWidth() - C4033h.this.rGj.leftMargin) - C4033h.this.rGr.contentView.getWidth();
                C4033h.this.rGj.topMargin = C4033h.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C4033h.this.rGj.bottomMargin = (C4033h.this.rGb.getHeight() - C4033h.this.rGj.topMargin) - C4033h.this.rGr.contentView.getHeight();
                C4033h.this.rGb.addView(C4033h.this.rGr.contentView, C4033h.this.rGj);
                AppMethodBeat.m2505o(40042);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40043);
                C4990ab.m7416i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) C4033h.this.hwd.mController.ylv.getParent()).removeView(C4033h.this.rGr.contentView);
                ((ViewGroup) C4033h.this.rGr.rpP).addView(C4033h.this.rGr.contentView, C4033h.this.rGn);
                C4033h.this.rGr.contentView.setScaleX(1.0f);
                C4033h.this.rGr.contentView.setScaleY(1.0f);
                C4033h.this.rGr.contentView.setAlpha(1.0f);
                C4033h.this.rGr.rHg.setAlpha(1.0f);
                C4033h.this.rGr.rHf.setAlpha(1.0f);
                if (C4033h.this.rFW != null) {
                    C4033h.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40043);
            }
        });
        AppMethodBeat.m2505o(40044);
    }

    /* renamed from: kM */
    public final void mo8883kM(long j) {
        AppMethodBeat.m2504i(40045);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40045);
    }
}
