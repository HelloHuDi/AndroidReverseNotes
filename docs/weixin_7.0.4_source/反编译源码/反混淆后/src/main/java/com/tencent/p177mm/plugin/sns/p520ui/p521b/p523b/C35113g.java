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

/* renamed from: com.tencent.mm.plugin.sns.ui.b.b.g */
public final class C35113g extends C39835a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    C13697b rGA;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.g$2 */
    class C136522 extends AnimatorListenerAdapter {
        C136522() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40075);
            if (C35113g.this.rGA.eBB) {
                C4990ab.m7416i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
                Iterator it = C35113g.this.rGa.getChildAnimations().iterator();
                while (it.hasNext()) {
                    ((Animator) it.next()).cancel();
                }
                AppMethodBeat.m2505o(40075);
                return;
            }
            C35113g.this.rGA.eBB = true;
            C35113g.this.rGA.rGQ.setAlpha(0.0f);
            C35113g.this.rGA.rGR.setAlpha(0.0f);
            C35113g.this.rGA.rJf.getLocationInWindow(C35113g.this.rGg);
            C4990ab.m7417i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", Integer.valueOf(C35113g.this.rGg[0]), Integer.valueOf(C35113g.this.rGg[1]));
            C35113g.this.rGA.rHB.removeView(C35113g.this.rGA.rJf);
            ViewGroup.LayoutParams layoutParams = C35113g.this.rGA.rHB.getLayoutParams();
            layoutParams.width = C35113g.this.rGA.rJf.getWidth();
            layoutParams.height = (C35113g.this.rGA.rJf.getHeight() + C35113g.this.rGn.topMargin) + C35113g.this.rGn.bottomMargin;
            C35113g.this.rGA.rHB.setLayoutParams(layoutParams);
            C35113g.this.rGj = new LayoutParams(-2, -2);
            C35113g.this.rGj.leftMargin = C35113g.this.rGg[0];
            C35113g.this.rGj.rightMargin = (C35113g.this.rGb.getWidth() - C35113g.this.rGj.leftMargin) - C35113g.this.rGA.rJf.getWidth();
            C35113g.this.rGj.topMargin = C35113g.this.rGg[1];
            C35113g.this.rGj.bottomMargin = (C35113g.this.rGb.getHeight() - C35113g.this.rGj.topMargin) - C35113g.this.rGA.rJf.getHeight();
            C35113g.this.rGb.addView(C35113g.this.rGA.rJf, C35113g.this.rGj);
            AppMethodBeat.m2505o(40075);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.g$1 */
    class C292071 implements AnimatorUpdateListener {
        C292071() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40074);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C4990ab.m7417i("MicroMsg.TurnCardAdBackAnimation", "value %f", Float.valueOf(floatValue));
            if (floatValue != 0.0f) {
                C35113g.this.rGA.rJf.setScaleX(floatValue);
                C35113g.this.rGA.rJf.setScaleY(floatValue);
                C35113g.this.rGA.rJf.setAlpha(floatValue);
            }
            AppMethodBeat.m2505o(40074);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.g$3 */
    class C292083 implements AnimatorUpdateListener {
        C292083() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            AppMethodBeat.m2504i(40076);
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            C35113g.this.rGA.rGQ.setAlpha(floatValue);
            C35113g.this.rGA.rGR.setAlpha(floatValue);
            AppMethodBeat.m2505o(40076);
        }
    }

    /* renamed from: com.tencent.mm.plugin.sns.ui.b.b.g$4 */
    class C292094 extends AnimatorListenerAdapter {
        C292094() {
        }

        public final void onAnimationStart(Animator animator) {
            AppMethodBeat.m2504i(40077);
            C4990ab.m7416i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
            AppMethodBeat.m2505o(40077);
        }

        public final void onAnimationEnd(Animator animator) {
            AppMethodBeat.m2504i(40078);
            C4990ab.m7416i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
            ((ViewGroup) C35113g.this.rGA.rJf.getParent()).removeView(C35113g.this.rGA.rJf);
            C35113g.this.rGA.rHB.addView(C35113g.this.rGA.rJf, C35113g.this.rGn);
            C35113g.this.rGA.rJf.setScaleX(1.0f);
            C35113g.this.rGA.rJf.setScaleY(1.0f);
            C35113g.this.rGA.rJf.setAlpha(1.0f);
            C35113g.this.rGA.rGQ.setAlpha(1.0f);
            C35113g.this.rGA.rGR.setAlpha(1.0f);
            if (C35113g.this.rFW != null) {
                C35113g.this.rFW.onAnimationEnd();
            }
            C35113g.this.rGA.eBB = false;
            AppMethodBeat.m2505o(40078);
        }
    }

    public C35113g(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.m2504i(40079);
        this.hwd = mMActivity;
        this.rGA = (C13697b) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new C292071());
        this.rFY.setDuration(400);
        this.rFY.addListener(new C136522());
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new C292083());
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGA.rJf.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new C292094());
        AppMethodBeat.m2505o(40079);
    }

    /* renamed from: kM */
    public final void mo8889kM(long j) {
        AppMethodBeat.m2504i(40080);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.m2505o(40080);
    }
}
