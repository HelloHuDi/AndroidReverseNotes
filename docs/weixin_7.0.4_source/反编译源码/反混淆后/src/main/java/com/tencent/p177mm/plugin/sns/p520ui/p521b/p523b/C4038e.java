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
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.e */
public final class C4038e extends C39835a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    C13687a rGx;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.e$4 */
    class C40394 extends AnimatorListenerAdapter {
        C40394() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40063);
            C4990ab.m7416i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40063);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40064);
            C4990ab.m7416i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
            ((ViewGroup) C4038e.this.rGx.roq.getParent()).removeView(C4038e.this.rGx.roq);
            C4038e.this.rGx.rHB.addView(C4038e.this.rGx.roq, C4038e.this.rGn);
            C4038e.this.rGx.roq.setScaleX(1.0f);
            C4038e.this.rGx.roq.setScaleY(1.0f);
            C4038e.this.rGx.roq.setAlpha(1.0f);
            C4038e.this.rGx.rGQ.setAlpha(1.0f);
            C4038e.this.rGx.rGR.setAlpha(1.0f);
            if (C4038e.this.rFW != null) {
                C4038e.this.rFW.onAnimationEnd();
            }
            C4038e.this.rGx.eBB = false;
            AppMethodBeat.m2505o(40064);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.e$2 */
    class C40402 extends AnimatorListenerAdapter {
        C40402() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40061);
            if (C4038e.this.rGx.eBB) {
                C4990ab.m7416i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
                Iterator it = C4038e.this.rGa.getChildAnimations().iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).cancel();
                }
                AppMethodBeat.m2505o(40061);
                return;
            }
            C4038e.this.rGx.eBB = true;
            C4038e.this.rGx.roq.getLocationInWindow(C4038e.this.rGg);
            C4990ab.m7417i("MicroMsg.FullCardAdBackAnimation", "location in window %s, %s", Integer.valueOf(C4038e.this.rGg[0]), Integer.valueOf(C4038e.this.rGg[1]));
            C4038e.this.rGx.rHB.removeView(C4038e.this.rGx.roq);
            ViewGroup.LayoutParams layoutParams = C4038e.this.rGx.rHB.getLayoutParams();
            layoutParams.width = C4038e.this.rGx.roq.getWidth();
            layoutParams.height = (C4038e.this.rGx.roq.getHeight() + C4038e.this.rGn.topMargin) + C4038e.this.rGn.bottomMargin;
            C4038e.this.rGx.rHB.setLayoutParams(layoutParams);
            C4038e.this.rGj = new LayoutParams(-2, -2);
            C4038e.this.rGj.leftMargin = C4038e.this.rGg[0];
            C4038e.this.rGj.rightMargin = (C4038e.this.rGb.getWidth() - C4038e.this.rGj.leftMargin) - C4038e.this.rGx.roq.getWidth();
            C4038e.this.rGj.topMargin = C4038e.this.rGg[1];
            C4038e.this.rGj.bottomMargin = (C4038e.this.rGb.getHeight() - C4038e.this.rGj.topMargin) - C4038e.this.rGx.roq.getHeight();
            C4038e.this.rGb.addView(C4038e.this.rGx.roq, C4038e.this.rGj);
            C4038e.this.rGx.rGQ.setAlpha(0.0f);
            C4038e.this.rGx.rGR.setAlpha(0.0f);
            AppMethodBeat.m2505o(40061);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.e$3 */
    class C40413 implements AnimatorUpdateListener {
        C40413() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40062);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4038e.this.rGx.rGQ.setAlpha(floatValue);
            C4038e.this.rGx.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40062);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.e$1 */
    class C40421 implements AnimatorUpdateListener {
        C40421() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40060);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (floatValue != 0.0f) {
                C4038e.this.rGx.roq.setScaleX(floatValue);
                C4038e.this.rGx.roq.setScaleY(floatValue);
                C4038e.this.rGx.roq.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40060);
        }
    }

    public C4038e(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40065);
        this.hwd = mMActivity;
        this.rGx = (C13687a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C40421());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C40402());
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C40413());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGx.roq.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new C40394());
        AppMethodBeat.m2505o(40065);
    }

    /* renamed from: kM */
    public final void mo8889kM(long j) {
        AppMethodBeat.m2504i(40066);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40066);
    }
}
