package com.tencent.mm.plugin.sns.ui.b.b;

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
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.i.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class g extends a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    b rGA;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;

    public g(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40079);
        this.hwd = mMActivity;
        this.rGA = (b) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40074);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ab.i("MicroMsg.TurnCardAdBackAnimation", "value %f", Float.valueOf(floatValue));
                if (floatValue != 0.0f) {
                    g.this.rGA.rJf.setScaleX(floatValue);
                    g.this.rGA.rJf.setScaleY(floatValue);
                    g.this.rGA.rJf.setAlpha(floatValue);
                }
                AppMethodBeat.o(40074);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40075);
                if (g.this.rGA.eBB) {
                    ab.i("MicroMsg.TurnCardAdBackAnimation", "holder is busy");
                    Iterator it = g.this.rGa.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        ((Animator) it.next()).cancel();
                    }
                    AppMethodBeat.o(40075);
                    return;
                }
                g.this.rGA.eBB = true;
                g.this.rGA.rGQ.setAlpha(0.0f);
                g.this.rGA.rGR.setAlpha(0.0f);
                g.this.rGA.rJf.getLocationInWindow(g.this.rGg);
                ab.i("MicroMsg.TurnCardAdBackAnimation", "location in window %s, %s", Integer.valueOf(g.this.rGg[0]), Integer.valueOf(g.this.rGg[1]));
                g.this.rGA.rHB.removeView(g.this.rGA.rJf);
                ViewGroup.LayoutParams layoutParams = g.this.rGA.rHB.getLayoutParams();
                layoutParams.width = g.this.rGA.rJf.getWidth();
                layoutParams.height = (g.this.rGA.rJf.getHeight() + g.this.rGn.topMargin) + g.this.rGn.bottomMargin;
                g.this.rGA.rHB.setLayoutParams(layoutParams);
                g.this.rGj = new LayoutParams(-2, -2);
                g.this.rGj.leftMargin = g.this.rGg[0];
                g.this.rGj.rightMargin = (g.this.rGb.getWidth() - g.this.rGj.leftMargin) - g.this.rGA.rJf.getWidth();
                g.this.rGj.topMargin = g.this.rGg[1];
                g.this.rGj.bottomMargin = (g.this.rGb.getHeight() - g.this.rGj.topMargin) - g.this.rGA.rJf.getHeight();
                g.this.rGb.addView(g.this.rGA.rJf, g.this.rGj);
                AppMethodBeat.o(40075);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40076);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                g.this.rGA.rGQ.setAlpha(floatValue);
                g.this.rGA.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40076);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGA.rJf.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40077);
                ab.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation start");
                AppMethodBeat.o(40077);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40078);
                ab.i("MicroMsg.TurnCardAdBackAnimation", "onAnimation end");
                ((ViewGroup) g.this.rGA.rJf.getParent()).removeView(g.this.rGA.rJf);
                g.this.rGA.rHB.addView(g.this.rGA.rJf, g.this.rGn);
                g.this.rGA.rJf.setScaleX(1.0f);
                g.this.rGA.rJf.setScaleY(1.0f);
                g.this.rGA.rJf.setAlpha(1.0f);
                g.this.rGA.rGQ.setAlpha(1.0f);
                g.this.rGA.rGR.setAlpha(1.0f);
                if (g.this.rFW != null) {
                    g.this.rFW.onAnimationEnd();
                }
                g.this.rGA.eBB = false;
                AppMethodBeat.o(40078);
            }
        });
        AppMethodBeat.o(40079);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40080);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40080);
    }
}
