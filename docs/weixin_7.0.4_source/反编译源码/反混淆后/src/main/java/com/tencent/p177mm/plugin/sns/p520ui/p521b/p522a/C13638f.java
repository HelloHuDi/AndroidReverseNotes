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

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.f */
public final class C13638f extends C46252b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    C13658c rGp;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.f$1 */
    class C136401 implements AnimatorUpdateListener {
        C136401() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40028);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                C13638f.this.rGp.contentView.setScaleX(floatValue);
                C13638f.this.rGp.contentView.setScaleY(floatValue);
                C13638f.this.rGp.contentView.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40028);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.f$2 */
    class C136412 implements AnimatorUpdateListener {
        C136412() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40029);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C13638f.this.rGp.rGQ.setAlpha(floatValue);
            C13638f.this.rGp.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40029);
        }
    }

    public C13638f(final MMActivity mMActivity, C35118a c35118a) {
        AppMethodBeat.m2504i(40032);
        this.hwd = mMActivity;
        this.rGp = (C13658c) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C136401());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C136412());
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGp.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40030);
                C4990ab.m7416i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
                C13638f.this.rGp.contentView.getLocationInWindow(C13638f.this.rGg);
                C4990ab.m7417i("MicroMsg.FullCardAdDetailClickAnimation", "location in window %s, %s", Integer.valueOf(C13638f.this.rGg[0]), Integer.valueOf(C13638f.this.rGg[1]));
                ((ViewGroup) C13638f.this.rGp.rpP).removeView(C13638f.this.rGp.contentView);
                ViewGroup.LayoutParams layoutParams = C13638f.this.rGp.rpP.getLayoutParams();
                layoutParams.width = C13638f.this.rGp.contentView.getWidth();
                layoutParams.height = (C13638f.this.rGp.contentView.getHeight() + C13638f.this.rGn.topMargin) + C13638f.this.rGn.bottomMargin;
                C13638f.this.rGp.rpP.setLayoutParams(layoutParams);
                C13638f.this.rGj = new LayoutParams(-2, -2);
                C13638f.this.rGj.leftMargin = C13638f.this.rGg[0];
                C13638f.this.rGj.rightMargin = (C13638f.this.rGb.getWidth() - C13638f.this.rGj.leftMargin) - C13638f.this.rGp.contentView.getWidth();
                C13638f.this.rGj.topMargin = C13638f.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C13638f.this.rGj.bottomMargin = (C13638f.this.rGb.getHeight() - C13638f.this.rGj.topMargin) - C13638f.this.rGp.contentView.getHeight();
                C13638f.this.rGb.addView(C13638f.this.rGp.contentView, C13638f.this.rGj);
                AppMethodBeat.m2505o(40030);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40031);
                C4990ab.m7416i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) C13638f.this.hwd.mController.ylv.getParent()).removeView(C13638f.this.rGp.contentView);
                ((ViewGroup) C13638f.this.rGp.rpP).addView(C13638f.this.rGp.contentView, C13638f.this.rGn);
                C13638f.this.rGp.contentView.setScaleX(1.0f);
                C13638f.this.rGp.contentView.setScaleY(1.0f);
                C13638f.this.rGp.contentView.setAlpha(1.0f);
                C13638f.this.rGp.rGQ.setAlpha(1.0f);
                C13638f.this.rGp.rGR.setAlpha(1.0f);
                if (C13638f.this.rFW != null) {
                    C13638f.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40031);
            }
        });
        AppMethodBeat.m2505o(40032);
    }

    /* renamed from: kM */
    public final void mo8883kM(long j) {
        AppMethodBeat.m2504i(40033);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40033);
    }
}
