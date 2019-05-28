package com.tencent.p177mm.plugin.sns.p520ui.p521b.p522a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.C5222ae;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C13655b;
import com.tencent.p177mm.plugin.sns.p520ui.p524c.p525a.C35118a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.c */
public final class C35109c extends C39833a {
    C13655b rFX;
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    FrameLayout.LayoutParams rGf;
    int[] rGg = new int[2];

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.c$2 */
    class C292022 implements AnimatorUpdateListener {
        C292022() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40011);
            C35109c.this.rFX.rGO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(40011);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.c$1 */
    class C351081 implements AnimatorUpdateListener {
        C351081() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40010);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) C35109c.this.rFX.contentView.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C35109c.this.rGf.leftMargin) * floatValue);
                layoutParams.rightMargin = (int) (((float) C35109c.this.rGf.rightMargin) * floatValue);
                layoutParams.topMargin = (int) (((float) C35109c.this.rGf.topMargin) * floatValue);
                layoutParams.bottomMargin = (int) (((float) C35109c.this.rGf.bottomMargin) * floatValue);
                layoutParams.width = (C35109c.this.rGb.getWidth() - layoutParams.leftMargin) - layoutParams.rightMargin;
                layoutParams.height = (C35109c.this.rGb.getHeight() - layoutParams.topMargin) - layoutParams.bottomMargin;
                C35109c.this.rFX.contentView.setLayoutParams(layoutParams);
                C35109c.this.rFX.contentView.setAlpha(floatValue);
                C35109c.this.rFX.rGN.setScaleX(floatValue);
                C35109c.this.rFX.rGN.setScaleY(floatValue);
                C35109c.this.rFX.rGN.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40010);
        }
    }

    public C35109c(final MMActivity mMActivity, final C35118a c35118a) {
        AppMethodBeat.m2504i(40014);
        this.hwd = mMActivity;
        this.rFX = (C13655b) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C351081());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C292022());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGc = (LayoutParams) this.rFX.contentView.getLayoutParams();
        this.rGd = (LayoutParams) this.rFX.rGN.getLayoutParams();
        this.rGe = (LayoutParams) this.rFX.rGO.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40012);
                C4990ab.m7416i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
                C35109c.this.rFX.contentView.getLocationInWindow(C35109c.this.rGg);
                C4990ab.m7417i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", Integer.valueOf(C35109c.this.rGg[0]), Integer.valueOf(C35109c.this.rGg[1]));
                C35109c.this.rGf = new FrameLayout.LayoutParams(-2, -2);
                C35109c.this.rGf.leftMargin = C35109c.this.rGg[0];
                C35109c.this.rGf.rightMargin = (C35109c.this.rGb.getWidth() - C35109c.this.rGf.leftMargin) - C35109c.this.rFX.contentView.getWidth();
                C35109c.this.rGf.topMargin = C35109c.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C35109c.this.rGf.bottomMargin = (C35109c.this.rGb.getHeight() - C35109c.this.rGf.topMargin) - C35109c.this.rFX.contentView.getHeight();
                int[] iArr = new int[2];
                C35109c.this.rFX.rGN.getLocationInWindow(iArr);
                C4990ab.m7417i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (C35109c.this.rGb.getWidth() - layoutParams.leftMargin) - C35109c.this.rFX.rGN.getWidth();
                layoutParams.topMargin = iArr[1] - C5222ae.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (C35109c.this.rGb.getHeight() - layoutParams.topMargin) - C35109c.this.rFX.rGN.getHeight();
                int[] iArr2 = new int[2];
                C35109c.this.rFX.rGO.getLocationInWindow(iArr2);
                C4990ab.m7417i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (C35109c.this.rGb.getWidth() - layoutParams2.leftMargin) - ((C13655b) c35118a).rGO.getWidth();
                layoutParams2.topMargin = iArr2[1] - C5222ae.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (C35109c.this.rGb.getHeight() - layoutParams2.topMargin) - ((C13655b) c35118a).rGO.getHeight();
                ViewGroup.LayoutParams layoutParams3 = C35109c.this.rFX.rpP.getLayoutParams();
                layoutParams3.width = C35109c.this.rFX.contentView.getWidth();
                layoutParams3.height = (C35109c.this.rFX.contentView.getHeight() + C35109c.this.rGc.topMargin) + C35109c.this.rGc.bottomMargin;
                C35109c.this.rFX.rpP.setLayoutParams(layoutParams3);
                C35109c.this.rFX.rGO.setAlpha(0.0f);
                ((ViewGroup) C35109c.this.rFX.rpP).removeView(C35109c.this.rFX.contentView);
                C35109c.this.rGb.addView(C35109c.this.rFX.contentView, new FrameLayout.LayoutParams(-1, -1));
                ((ViewGroup) C35109c.this.rFX.contentView).removeView(C35109c.this.rFX.rGN);
                C35109c.this.rGb.addView(C35109c.this.rFX.rGN, layoutParams);
                ((ViewGroup) C35109c.this.rFX.contentView).removeView(C35109c.this.rFX.rGO);
                C35109c.this.rGb.addView(C35109c.this.rFX.rGO, layoutParams2);
                C35109c.this.rFX.rGN.setScaleX(0.0f);
                C35109c.this.rFX.rGN.setScaleY(0.0f);
                C35109c.this.rFX.rGN.setAlpha(0.0f);
                AppMethodBeat.m2505o(40012);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40013);
                C4990ab.m7416i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35109c.this.rFX.contentView);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35109c.this.rFX.rGN);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35109c.this.rFX.rGO);
                C35109c.this.rFX.rGN.setScaleX(1.0f);
                C35109c.this.rFX.rGN.setScaleY(1.0f);
                C35109c.this.rFX.rGN.setAlpha(1.0f);
                ((ViewGroup) C35109c.this.rFX.rpP).addView(C35109c.this.rFX.contentView, C35109c.this.rGc);
                ((ViewGroup) C35109c.this.rFX.contentView).addView(C35109c.this.rFX.rGN, C35109c.this.rGd);
                ((ViewGroup) C35109c.this.rFX.contentView).addView(C35109c.this.rFX.rGO, C35109c.this.rGe);
                C35109c.this.rFX.contentView.setAlpha(1.0f);
                C35109c.this.rFX.rGO.setAlpha(1.0f);
                if (C35109c.this.rFW != null) {
                    C35109c.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40013);
            }
        });
        AppMethodBeat.m2505o(40014);
    }

    /* renamed from: kM */
    public final void mo8878kM(long j) {
        AppMethodBeat.m2504i(40015);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40015);
    }
}
