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

/* renamed from: com.tencent.mm.plugin.sns.ui.b.a.d */
public final class C35110d extends C46252b {
    C13655b rFX;
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    int[] rGg = new int[2];
    FrameLayout.LayoutParams rGj;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.d$1 */
    class C40261 implements AnimatorUpdateListener {
        C40261() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40016);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (((double) floatValue) != 1.0d) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) C35110d.this.rFX.contentView.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C35110d.this.rGj.leftMargin) * floatValue);
                layoutParams.rightMargin = (int) (((float) C35110d.this.rGj.rightMargin) * floatValue);
                layoutParams.topMargin = (int) (((float) C35110d.this.rGj.topMargin) * floatValue);
                layoutParams.bottomMargin = (int) (((float) C35110d.this.rGj.bottomMargin) * floatValue);
                C35110d.this.rFX.contentView.setLayoutParams(layoutParams);
                C35110d.this.rFX.rGN.setScaleX(floatValue);
                C35110d.this.rFX.rGN.setScaleY(floatValue);
                C35110d.this.rFX.rGN.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40016);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.a.d$2 */
    class C40272 implements AnimatorUpdateListener {
        C40272() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40017);
            C35110d.this.rFX.rGO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(40017);
        }
    }

    public C35110d(final MMActivity mMActivity, final C35118a c35118a) {
        AppMethodBeat.m2504i(40020);
        this.hwd = mMActivity;
        this.rFX = (C13655b) c35118a;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C40261());
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C40272());
        this.rFZ.setDuration(100);
        this.rGc = (LayoutParams) this.rFX.contentView.getLayoutParams();
        this.rGd = (LayoutParams) this.rFX.rGN.getLayoutParams();
        this.rGe = (LayoutParams) this.rFX.rGO.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.m2504i(40018);
                C4990ab.m7416i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
                C35110d.this.rFX.contentView.getLocationInWindow(C35110d.this.rGg);
                C4990ab.m7417i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", Integer.valueOf(C35110d.this.rGg[0]), Integer.valueOf(C35110d.this.rGg[1]));
                C35110d.this.rGj = new FrameLayout.LayoutParams(-2, -2);
                C35110d.this.rGj.leftMargin = C35110d.this.rGg[0];
                C35110d.this.rGj.rightMargin = (C35110d.this.rGb.getWidth() - C35110d.this.rGj.leftMargin) - C35110d.this.rFX.contentView.getWidth();
                C35110d.this.rGj.topMargin = C35110d.this.rGg[1] - C5222ae.getStatusBarHeight(mMActivity);
                C35110d.this.rGj.bottomMargin = (C35110d.this.rGb.getHeight() - C35110d.this.rGj.topMargin) - C35110d.this.rFX.contentView.getHeight();
                C4990ab.m7417i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", Integer.valueOf(C35110d.this.rGj.leftMargin), Integer.valueOf(C35110d.this.rGj.topMargin), Integer.valueOf(C35110d.this.rGj.rightMargin), Integer.valueOf(C35110d.this.rGj.bottomMargin));
                int[] iArr = new int[2];
                C35110d.this.rFX.rGN.getLocationInWindow(iArr);
                C4990ab.m7417i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (C35110d.this.rGb.getWidth() - layoutParams.leftMargin) - C35110d.this.rFX.rGN.getWidth();
                layoutParams.topMargin = iArr[1] - C5222ae.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (C35110d.this.rGb.getHeight() - layoutParams.topMargin) - C35110d.this.rFX.rGN.getHeight();
                int[] iArr2 = new int[2];
                C35110d.this.rFX.rGO.getLocationInWindow(iArr2);
                C4990ab.m7417i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (C35110d.this.rGb.getWidth() - layoutParams2.leftMargin) - ((C13655b) c35118a).rGO.getWidth();
                layoutParams2.topMargin = iArr2[1] - C5222ae.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (C35110d.this.rGb.getHeight() - layoutParams2.topMargin) - ((C13655b) c35118a).rGO.getHeight();
                ViewGroup.LayoutParams layoutParams3 = C35110d.this.rFX.rpP.getLayoutParams();
                layoutParams3.width = C35110d.this.rFX.contentView.getWidth();
                layoutParams3.height = (C35110d.this.rFX.contentView.getHeight() + C35110d.this.rGc.topMargin) + C35110d.this.rGc.bottomMargin;
                C35110d.this.rFX.rpP.setLayoutParams(layoutParams3);
                ((ViewGroup) C35110d.this.rFX.rpP).removeView(C35110d.this.rFX.contentView);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams4.leftMargin = C35110d.this.rGj.leftMargin;
                layoutParams4.rightMargin = C35110d.this.rGj.rightMargin;
                layoutParams4.topMargin = C35110d.this.rGj.topMargin;
                layoutParams4.bottomMargin = C35110d.this.rGj.bottomMargin;
                C35110d.this.rGb.addView(C35110d.this.rFX.contentView, layoutParams4);
                ((ViewGroup) C35110d.this.rFX.contentView).removeView(C35110d.this.rFX.rGN);
                C35110d.this.rGb.addView(C35110d.this.rFX.rGN, layoutParams);
                ((ViewGroup) C35110d.this.rFX.contentView).removeView(C35110d.this.rFX.rGO);
                C35110d.this.rGb.addView(C35110d.this.rFX.rGO, layoutParams2);
                AppMethodBeat.m2505o(40018);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(40019);
                C4990ab.m7416i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35110d.this.rFX.contentView);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35110d.this.rFX.rGN);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(C35110d.this.rFX.rGO);
                C35110d.this.rFX.rGN.setScaleX(1.0f);
                C35110d.this.rFX.rGN.setScaleY(1.0f);
                C35110d.this.rFX.rGN.setAlpha(1.0f);
                ((ViewGroup) C35110d.this.rFX.rpP).addView(C35110d.this.rFX.contentView, C35110d.this.rGc);
                ((ViewGroup) C35110d.this.rFX.contentView).addView(C35110d.this.rFX.rGN, C35110d.this.rGd);
                ((ViewGroup) C35110d.this.rFX.contentView).addView(C35110d.this.rFX.rGO, C35110d.this.rGe);
                C35110d.this.rFX.rGO.setAlpha(1.0f);
                if (C35110d.this.rFW != null) {
                    C35110d.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.m2505o(40019);
            }
        });
        AppMethodBeat.m2505o(40020);
    }

    /* renamed from: kM */
    public final void mo8883kM(long j) {
        AppMethodBeat.m2504i(40021);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40021);
    }
}
