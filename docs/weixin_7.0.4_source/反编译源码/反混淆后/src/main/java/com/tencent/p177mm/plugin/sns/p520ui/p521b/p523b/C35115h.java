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
import com.tencent.p177mm.plugin.sns.p520ui.item.C13690i.C13697b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.util.Iterator;

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.h */
public final class C35115h extends C46253b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    C13697b rGA;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.h$2 */
    class C220762 extends AnimatorListenerAdapter {
        C220762() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40082);
            if (C35115h.this.rGA.eBB) {
                C4990ab.m7416i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
                Iterator it = C35115h.this.rGa.getChildAnimations().iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).cancel();
                }
                AppMethodBeat.m2505o(40082);
                return;
            }
            C35115h.this.rGA.eBB = true;
            C35115h.this.rGA.rJf.getLocationInWindow(C35115h.this.rGg);
            C4990ab.m7417i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", Integer.valueOf(C35115h.this.rGg[0]), Integer.valueOf(C35115h.this.rGg[1]), Integer.valueOf(C35115h.this.rGA.rJf.getWidth()), Integer.valueOf(C35115h.this.rGA.rJf.getHeight()));
            C35115h.this.rGA.rHB.removeView(C35115h.this.rGA.rJf);
            ViewGroup.LayoutParams layoutParams = C35115h.this.rGA.rHB.getLayoutParams();
            layoutParams.width = C35115h.this.rGA.rJf.getWidth();
            layoutParams.height = (C35115h.this.rGA.rJf.getHeight() + C35115h.this.rGn.topMargin) + C35115h.this.rGn.bottomMargin;
            C35115h.this.rGA.rHB.setLayoutParams(layoutParams);
            C35115h.this.rGj = new LayoutParams(-2, -2);
            C35115h.this.rGj.leftMargin = C35115h.this.rGg[0];
            C35115h.this.rGj.rightMargin = (C35115h.this.rGb.getWidth() - C35115h.this.rGj.leftMargin) - C35115h.this.rGA.rJf.getWidth();
            C35115h.this.rGj.topMargin = C35115h.this.rGg[1];
            C35115h.this.rGj.bottomMargin = (C35115h.this.rGb.getHeight() - C35115h.this.rGj.topMargin) - C35115h.this.rGA.rJf.getHeight();
            C35115h.this.rGb.addView(C35115h.this.rGA.rJf, C35115h.this.rGj);
            AppMethodBeat.m2505o(40082);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.h$1 */
    class C351141 implements AnimatorUpdateListener {
        C351141() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40081);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4990ab.m7417i("MicroMsg.TurnCardAdClickAnimation", "value %f", Float.valueOf(floatValue));
            if (floatValue != 1.0f) {
                C35115h.this.rGA.rJf.setScaleX(floatValue);
                C35115h.this.rGA.rJf.setScaleY(floatValue);
                C35115h.this.rGA.rJf.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40081);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.h$3 */
    class C351163 implements AnimatorUpdateListener {
        C351163() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40083);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C35115h.this.rGA.rGQ.setAlpha(floatValue);
            C35115h.this.rGA.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40083);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.h$4 */
    class C351174 extends AnimatorListenerAdapter {
        C351174() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40084);
            C4990ab.m7416i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40084);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40085);
            C4990ab.m7416i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
            ((ViewGroup) C35115h.this.rGA.rJf.getParent()).removeView(C35115h.this.rGA.rJf);
            C35115h.this.rGA.rHB.addView(C35115h.this.rGA.rJf, C35115h.this.rGn);
            C35115h.this.rGA.rJf.setScaleX(1.0f);
            C35115h.this.rGA.rJf.setScaleY(1.0f);
            C35115h.this.rGA.rJf.setAlpha(1.0f);
            C35115h.this.rGA.rGQ.setAlpha(1.0f);
            C35115h.this.rGA.rGR.setAlpha(1.0f);
            if (C35115h.this.rFW != null) {
                C35115h.this.rFW.onAnimationEnd();
            }
            C35115h.this.rGA.eBB = false;
            AppMethodBeat.m2505o(40085);
        }
    }

    public C35115h(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40086);
        this.hwd = mMActivity;
        this.rGA = (C13697b) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new C351141());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C220762());
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new C351163());
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGA.rJf.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new C351174());
        AppMethodBeat.m2505o(40086);
    }

    /* renamed from: kM */
    public final void mo25856kM(long j) {
        AppMethodBeat.m2504i(40087);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40087);
    }
}
