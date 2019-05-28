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
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13658c;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C35118a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.e */
public final class C4029e extends C39833a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    C13658c rGm;
    LinearLayout.LayoutParams rGn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.e$1 */
    class C40301 implements AnimatorUpdateListener {
        C40301() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40022);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                C4029e.this.rGm.contentView.setScaleX(floatValue);
                C4029e.this.rGm.contentView.setScaleY(floatValue);
                C4029e.this.rGm.contentView.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40022);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.e$2 */
    class C40312 implements AnimatorUpdateListener {
        C40312() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40023);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4029e.this.rGm.rGQ.setAlpha(floatValue);
            C4029e.this.rGm.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40023);
        }
    }

    public C4029e(final MMActivity mMActivity, C35118a c35118a) {
        AppMethodBeat.m2504i(40026);
        this.hwd = mMActivity;
        this.rGm = (C13658c) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C40301());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C40312());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGm.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40024);
                C4990ab.m7416i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
                C4029e.this.rGm.rGQ.setAlpha(0.0f);
                C4029e.this.rGm.rGR.setAlpha(0.0f);
                C4029e.this.rGm.contentView.getLocationInWindow(C4029e.this.rGg);
                C4990ab.m7417i("MicroMsg.FullCardAdDetailBackAnimation", "location in window %s, %s", Integer.valueOf(C4029e.this.rGg[0]), Integer.valueOf(C4029e.this.rGg[1]));
                ((ViewGroup) C4029e.this.rGm.rpP).removeView(C4029e.this.rGm.contentView);
                ViewGroup.LayoutParams layoutParams = C4029e.this.rGm.rpP.getLayoutParams();
                layoutParams.width = C4029e.this.rGm.contentView.getWidth();
                layoutParams.height = (C4029e.this.rGm.contentView.getHeight() + C4029e.this.rGn.topMargin) + C4029e.this.rGn.bottomMargin;
                C4029e.this.rGm.rpP.setLayoutParams(layoutParams);
                C4029e.this.rGj = new LayoutParams(-2, -2);
                C4029e.this.rGj.leftMargin = C4029e.this.rGg[0];
                C4029e.this.rGj.rightMargin = (C4029e.this.rGb.getWidth() - C4029e.this.rGj.leftMargin) - C4029e.this.rGm.contentView.getWidth();
                C4029e.this.rGj.topMargin = C4029e.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C4029e.this.rGj.bottomMargin = (C4029e.this.rGb.getHeight() - C4029e.this.rGj.topMargin) - C4029e.this.rGm.contentView.getHeight();
                C4029e.this.rGb.addView(C4029e.this.rGm.contentView, C4029e.this.rGj);
                AppMethodBeat.m2505o(40024);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40025);
                C4990ab.m7416i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) C4029e.this.hwd.mController.ylv.getParent()).removeView(C4029e.this.rGm.contentView);
                ((ViewGroup) C4029e.this.rGm.rpP).addView(C4029e.this.rGm.contentView, C4029e.this.rGn);
                C4029e.this.rGm.contentView.setScaleX(1.0f);
                C4029e.this.rGm.contentView.setScaleY(1.0f);
                C4029e.this.rGm.contentView.setAlpha(1.0f);
                C4029e.this.rGm.rGQ.setAlpha(1.0f);
                C4029e.this.rGm.rGR.setAlpha(1.0f);
                if (C4029e.this.rFW != null) {
                    C4029e.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40025);
            }
        });
        AppMethodBeat.m2505o(40026);
    }

    /* renamed from: kM */
    public final void mo8878kM(long j) {
        AppMethodBeat.m2504i(40027);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40027);
    }
}
