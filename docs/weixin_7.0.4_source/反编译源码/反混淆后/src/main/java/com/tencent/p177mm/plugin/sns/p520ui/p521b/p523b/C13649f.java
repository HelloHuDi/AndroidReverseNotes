package com.tencent.p177mm.plugin.sns.p520ui.p521b.p523b;

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
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.plugin.sns.p520ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.p177mm.plugin.sns.p520ui.item.C41313c.C13687a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.f */
public final class C13649f extends C46253b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    C13687a rGx;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.f$2 */
    class C136472 extends AnimatorListenerAdapter {
        C136472() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40068);
            if (C13649f.this.rGx.eBB) {
                C4990ab.m7416i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
                C13649f.this.rGa.end();
                AppMethodBeat.m2505o(40068);
                return;
            }
            C13649f.this.rGx.eBB = true;
            C13649f.this.rGx.roq.getLocationInWindow(C13649f.this.rGg);
            C4990ab.m7417i("MicroMsg.FullCardAdClickAnimation", "location in window %s, %s", Integer.valueOf(C13649f.this.rGg[0]), Integer.valueOf(C13649f.this.rGg[1]));
            C13649f.this.rGx.rHB.removeView(C13649f.this.rGx.roq);
            ViewGroup.LayoutParams layoutParams = C13649f.this.rGx.rHB.getLayoutParams();
            layoutParams.width = C13649f.this.rGx.roq.getWidth();
            layoutParams.height = (C13649f.this.rGx.roq.getHeight() + C13649f.this.rGn.topMargin) + C13649f.this.rGn.bottomMargin;
            C13649f.this.rGx.rHB.setLayoutParams(layoutParams);
            C13649f.this.rGj = new LayoutParams(-2, -2);
            C13649f.this.rGj.leftMargin = C13649f.this.rGg[0];
            C13649f.this.rGj.rightMargin = (C13649f.this.rGb.getWidth() - C13649f.this.rGj.leftMargin) - C13649f.this.rGx.roq.getWidth();
            C13649f.this.rGj.topMargin = C13649f.this.rGg[1];
            C13649f.this.rGj.bottomMargin = (C13649f.this.rGb.getHeight() - C13649f.this.rGj.topMargin) - C13649f.this.rGx.roq.getHeight();
            C13649f.this.rGb.addView(C13649f.this.rGx.roq, C13649f.this.rGj);
            AppMethodBeat.m2505o(40068);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.f$4 */
    class C136484 extends AnimatorListenerAdapter {
        C136484() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40070);
            C4990ab.m7416i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40070);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40071);
            C4990ab.m7416i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
            ((ViewGroup) C13649f.this.rGx.roq.getParent()).removeView(C13649f.this.rGx.roq);
            C13649f.this.rGx.rHB.addView(C13649f.this.rGx.roq, C13649f.this.rGn);
            C13649f.this.rGx.roq.setScaleX(1.0f);
            C13649f.this.rGx.roq.setScaleY(1.0f);
            C13649f.this.rGx.roq.setAlpha(1.0f);
            C13649f.this.rGx.rGQ.setAlpha(1.0f);
            C13649f.this.rGx.rGR.setAlpha(1.0f);
            if (C13649f.this.rFW != null) {
                C13649f.this.rFW.onAnimationEnd();
            }
            C13649f.this.rGx.eBB = false;
            AppMethodBeat.m2505o(40071);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.f$3 */
    class C136503 implements AnimatorUpdateListener {
        C136503() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40069);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C13649f.this.rGx.rGQ.setAlpha(floatValue);
            C13649f.this.rGx.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40069);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.f$1 */
    class C136511 implements AnimatorUpdateListener {
        C136511() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40067);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 1.0f) {
                C13649f.this.rGx.roq.setScaleX(floatValue);
                C13649f.this.rGx.roq.setScaleY(floatValue);
                C13649f.this.rGx.roq.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40067);
        }
    }

    public C13649f(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40072);
        this.hwd = mMActivity;
        this.rGx = (C13687a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C136511());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C136472());
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C136503());
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGx.roq.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new C136484());
        AppMethodBeat.m2505o(40072);
    }

    /* renamed from: kM */
    public final void mo25856kM(long j) {
        AppMethodBeat.m2504i(40073);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40073);
    }
}
