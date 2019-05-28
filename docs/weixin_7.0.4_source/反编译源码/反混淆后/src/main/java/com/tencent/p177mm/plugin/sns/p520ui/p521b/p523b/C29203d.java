package com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.item.C4078a.C4081a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.d */
public final class C29203d extends C46253b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    int[] rGg = new int[2];
    FrameLayout.LayoutParams rGj;
    C4081a rGu;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.d$1 */
    class C40371 implements AnimatorUpdateListener {
        C40371() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40053);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 1.0f) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) C29203d.this.rGu.rIE.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C29203d.this.rGj.leftMargin) * floatValue);
                layoutParams.rightMargin = (int) (((float) C29203d.this.rGj.rightMargin) * floatValue);
                layoutParams.topMargin = (int) (((float) C29203d.this.rGj.topMargin) * floatValue);
                layoutParams.bottomMargin = (int) (((float) C29203d.this.rGj.bottomMargin) * floatValue);
                C29203d.this.rGu.rIE.setLayoutParams(layoutParams);
                C29203d.this.rGu.rIF.setScaleX(floatValue);
                C29203d.this.rGu.rIF.setScaleY(floatValue);
                C29203d.this.rGu.rIF.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40053);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.d$2 */
    class C292042 extends AnimatorListenerAdapter {
        C292042() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40054);
            if (C29203d.this.rGu.eBB) {
                C4990ab.m7416i("MicroMsg.CardAdClickAnimation", "holder is busy");
                C29203d.this.rGa.end();
                AppMethodBeat.m2505o(40054);
                return;
            }
            C29203d.this.rGu.eBB = true;
            C29203d.this.rGu.rIE.getLocationInWindow(C29203d.this.rGg);
            C4990ab.m7417i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", Integer.valueOf(C29203d.this.rGg[0]), Integer.valueOf(C29203d.this.rGg[1]));
            C29203d.this.rGj = new FrameLayout.LayoutParams(-2, -2);
            C29203d.this.rGj.leftMargin = C29203d.this.rGg[0];
            C29203d.this.rGj.rightMargin = (C29203d.this.rGb.getWidth() - C29203d.this.rGj.leftMargin) - C29203d.this.rGu.rIE.getWidth();
            C29203d.this.rGj.topMargin = C29203d.this.rGg[1];
            C29203d.this.rGj.bottomMargin = (C29203d.this.rGb.getHeight() - C29203d.this.rGj.topMargin) - C29203d.this.rGu.rIE.getHeight();
            int[] iArr = new int[2];
            C29203d.this.rGu.rIF.getLocationInWindow(iArr);
            C4990ab.m7417i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = iArr[0];
            layoutParams.rightMargin = (C29203d.this.rGb.getWidth() - layoutParams.leftMargin) - C29203d.this.rGu.rIF.getWidth();
            layoutParams.topMargin = iArr[1];
            layoutParams.bottomMargin = (C29203d.this.rGb.getHeight() - layoutParams.topMargin) - C29203d.this.rGu.rIF.getHeight();
            iArr = new int[2];
            C29203d.this.rGu.rIG.getLocationInWindow(iArr);
            C4990ab.m7417i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams2.leftMargin = iArr[0];
            layoutParams2.rightMargin = (C29203d.this.rGb.getWidth() - layoutParams2.leftMargin) - C29203d.this.rGu.rIG.getWidth();
            layoutParams2.topMargin = iArr[1];
            layoutParams2.bottomMargin = (C29203d.this.rGb.getHeight() - layoutParams2.topMargin) - C29203d.this.rGu.rIG.getHeight();
            ViewGroup.LayoutParams layoutParams3 = C29203d.this.rGu.rHB.getLayoutParams();
            layoutParams3.width = C29203d.this.rGu.rIE.getWidth();
            layoutParams3.height = (C29203d.this.rGu.rIE.getHeight() + C29203d.this.rGc.topMargin) + C29203d.this.rGc.bottomMargin;
            C29203d.this.rGu.rHB.setLayoutParams(layoutParams3);
            FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams4.leftMargin = C29203d.this.rGj.leftMargin;
            layoutParams4.rightMargin = C29203d.this.rGj.rightMargin;
            layoutParams4.topMargin = C29203d.this.rGj.topMargin;
            layoutParams4.bottomMargin = C29203d.this.rGj.bottomMargin;
            C29203d.this.rGu.rHB.removeView(C29203d.this.rGu.rIE);
            C29203d.this.rGb.addView(C29203d.this.rGu.rIE, layoutParams4);
            C29203d.this.rGu.rIE.removeView(C29203d.this.rGu.rIF);
            C29203d.this.rGb.addView(C29203d.this.rGu.rIF, layoutParams);
            C29203d.this.rGu.rIE.removeView(C29203d.this.rGu.rIG);
            C29203d.this.rGb.addView(C29203d.this.rGu.rIG, layoutParams2);
            AppMethodBeat.m2505o(40054);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.d$3 */
    class C292053 implements AnimatorUpdateListener {
        C292053() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40055);
            C29203d.this.rGu.rIG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(40055);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.d$4 */
    class C292064 extends AnimatorListenerAdapter {
        C292064() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40056);
            C4990ab.m7416i("MicroMsg.CardAdClickAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40056);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40057);
            C4990ab.m7416i("MicroMsg.CardAdClickAnimation", "onAnimation end");
            ((ViewGroup) C29203d.this.rGu.rIE.getParent()).removeView(C29203d.this.rGu.rIE);
            ((ViewGroup) C29203d.this.rGu.rIF.getParent()).removeView(C29203d.this.rGu.rIF);
            ((ViewGroup) C29203d.this.rGu.rIG.getParent()).removeView(C29203d.this.rGu.rIG);
            C29203d.this.rGu.rHB.addView(C29203d.this.rGu.rIE, C29203d.this.rGc);
            C29203d.this.rGu.rIE.addView(C29203d.this.rGu.rIF, C29203d.this.rGd);
            C29203d.this.rGu.rIE.addView(C29203d.this.rGu.rIG, C29203d.this.rGe);
            C29203d.this.rGu.rIF.setScaleX(1.0f);
            C29203d.this.rGu.rIF.setScaleY(1.0f);
            C29203d.this.rGu.rIF.setAlpha(1.0f);
            C29203d.this.rGu.rIG.setAlpha(1.0f);
            if (C29203d.this.rFW != null) {
                C29203d.this.rFW.onAnimationEnd();
            }
            C29203d.this.rGu.eBB = false;
            AppMethodBeat.m2505o(40057);
        }
    }

    public C29203d(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40058);
        this.hwd = mMActivity;
        this.rGu = (C4081a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C40371());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C292042());
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C292053());
        this.rFZ.setDuration(100);
        this.rGc = (LayoutParams) this.rGu.rIE.getLayoutParams();
        this.rGd = (LayoutParams) this.rGu.rIF.getLayoutParams();
        this.rGe = (LayoutParams) this.rGu.rIG.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new C292064());
        AppMethodBeat.m2505o(40058);
    }

    /* renamed from: kM */
    public final void mo25856kM(long j) {
        AppMethodBeat.m2504i(40059);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40059);
    }
}
