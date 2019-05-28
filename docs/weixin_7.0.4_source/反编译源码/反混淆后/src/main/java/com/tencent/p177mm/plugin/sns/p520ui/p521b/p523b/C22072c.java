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
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.c */
public final class C22072c extends C39835a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    FrameLayout.LayoutParams rGf;
    int[] rGg = new int[2];
    C4081a rGu;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.c$2 */
    class C136462 extends AnimatorListenerAdapter {
        C136462() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40047);
            if (C22072c.this.rGu.eBB) {
                C4990ab.m7416i("MicroMsg.CardAdBackAnimation", "holder is busy");
                Iterator it = C22072c.this.rGa.getChildAnimations().iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).cancel();
                }
                AppMethodBeat.m2505o(40047);
                return;
            }
            C22072c.this.rGu.eBB = true;
            C22072c.this.rGu.rIE.getLocationInWindow(C22072c.this.rGg);
            C4990ab.m7417i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", Integer.valueOf(C22072c.this.rGg[0]), Integer.valueOf(C22072c.this.rGg[1]));
            C22072c.this.rGf = new FrameLayout.LayoutParams(-2, -2);
            C22072c.this.rGf.leftMargin = C22072c.this.rGg[0];
            C22072c.this.rGf.rightMargin = (C22072c.this.rGb.getWidth() - C22072c.this.rGf.leftMargin) - C22072c.this.rGu.rIE.getWidth();
            C22072c.this.rGf.topMargin = C22072c.this.rGg[1];
            C22072c.this.rGf.bottomMargin = (C22072c.this.rGb.getHeight() - C22072c.this.rGf.topMargin) - C22072c.this.rGu.rIE.getHeight();
            int[] iArr = new int[2];
            C22072c.this.rGu.rIF.getLocationInWindow(iArr);
            C4990ab.m7417i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
            layoutParams.leftMargin = iArr[0];
            layoutParams.rightMargin = (C22072c.this.rGb.getWidth() - layoutParams.leftMargin) - C22072c.this.rGu.rIF.getWidth();
            layoutParams.topMargin = iArr[1];
            layoutParams.bottomMargin = (C22072c.this.rGb.getHeight() - layoutParams.topMargin) - C22072c.this.rGu.rIF.getHeight();
            ViewGroup.LayoutParams layoutParams2 = C22072c.this.rGu.rHB.getLayoutParams();
            layoutParams2.width = C22072c.this.rGu.rIE.getWidth();
            layoutParams2.height = (C22072c.this.rGu.rIE.getHeight() + C22072c.this.rGc.topMargin) + C22072c.this.rGc.bottomMargin;
            C22072c.this.rGu.rHB.setLayoutParams(layoutParams2);
            iArr = new int[2];
            C22072c.this.rGu.rIG.getLocationInWindow(iArr);
            C4990ab.m7417i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
            FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
            layoutParams3.leftMargin = iArr[0];
            layoutParams3.rightMargin = (C22072c.this.rGb.getWidth() - layoutParams3.leftMargin) - C22072c.this.rGu.rIG.getWidth();
            layoutParams3.topMargin = iArr[1];
            layoutParams3.bottomMargin = (C22072c.this.rGb.getHeight() - layoutParams3.topMargin) - C22072c.this.rGu.rIG.getHeight();
            C22072c.this.rGu.rIG.setAlpha(0.0f);
            C22072c.this.rGu.rHB.removeView(C22072c.this.rGu.rIE);
            C22072c.this.rGb.addView(C22072c.this.rGu.rIE, new FrameLayout.LayoutParams(-1, -1));
            C22072c.this.rGu.rIE.removeView(C22072c.this.rGu.rIF);
            C22072c.this.rGb.addView(C22072c.this.rGu.rIF, layoutParams);
            C22072c.this.rGu.rIE.removeView(C22072c.this.rGu.rIG);
            C22072c.this.rGb.addView(C22072c.this.rGu.rIG, layoutParams3);
            C22072c.this.rGu.rIF.setScaleX(0.0f);
            C22072c.this.rGu.rIF.setScaleY(0.0f);
            C22072c.this.rGu.rIF.setAlpha(0.0f);
            AppMethodBeat.m2505o(40047);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.c$1 */
    class C220731 implements AnimatorUpdateListener {
        C220731() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40046);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) C22072c.this.rGu.rIE.getLayoutParams();
                layoutParams.leftMargin = (int) (((float) C22072c.this.rGf.leftMargin) * floatValue);
                layoutParams.rightMargin = (int) (((float) C22072c.this.rGf.rightMargin) * floatValue);
                layoutParams.topMargin = (int) (((float) C22072c.this.rGf.topMargin) * floatValue);
                layoutParams.bottomMargin = (int) (((float) C22072c.this.rGf.bottomMargin) * floatValue);
                C22072c.this.rGu.rIE.setLayoutParams(layoutParams);
                C22072c.this.rGu.rIF.setScaleX(floatValue);
                C22072c.this.rGu.rIF.setScaleY(floatValue);
                C22072c.this.rGu.rIF.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40046);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.c$3 */
    class C220743 implements AnimatorUpdateListener {
        C220743() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40048);
            C22072c.this.rGu.rIG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            AppMethodBeat.m2505o(40048);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.c$4 */
    class C220754 extends AnimatorListenerAdapter {
        C220754() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40049);
            C4990ab.m7416i("MicroMsg.CardAdBackAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40049);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40050);
            C4990ab.m7416i("MicroMsg.CardAdBackAnimation", "onAnimation end");
            ((ViewGroup) C22072c.this.rGu.rIE.getParent()).removeView(C22072c.this.rGu.rIE);
            ((ViewGroup) C22072c.this.rGu.rIF.getParent()).removeView(C22072c.this.rGu.rIF);
            ((ViewGroup) C22072c.this.rGu.rIG.getParent()).removeView(C22072c.this.rGu.rIG);
            C22072c.this.rGu.rHB.addView(C22072c.this.rGu.rIE, C22072c.this.rGc);
            C22072c.this.rGu.rIE.addView(C22072c.this.rGu.rIF, C22072c.this.rGd);
            C22072c.this.rGu.rIE.addView(C22072c.this.rGu.rIG, C22072c.this.rGe);
            C22072c.this.rGu.rIF.setScaleX(1.0f);
            C22072c.this.rGu.rIF.setScaleY(1.0f);
            C22072c.this.rGu.rIF.setAlpha(1.0f);
            C22072c.this.rGu.rIG.setAlpha(1.0f);
            if (C22072c.this.rFW != null) {
                C22072c.this.rFW.onAnimationEnd();
            }
            C22072c.this.rGu.eBB = false;
            AppMethodBeat.m2505o(40050);
        }
    }

    public C22072c(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40051);
        this.hwd = mMActivity;
        this.rGu = (C4081a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C220731());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C136462());
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C220743());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGc = (LayoutParams) this.rGu.rIE.getLayoutParams();
        this.rGd = (LayoutParams) this.rGu.rIF.getLayoutParams();
        this.rGe = (LayoutParams) this.rGu.rIG.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new C220754());
        AppMethodBeat.m2505o(40051);
    }

    /* renamed from: kM */
    public final void mo8889kM(long j) {
        AppMethodBeat.m2504i(40052);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40052);
    }
}
