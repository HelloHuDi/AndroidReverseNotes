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

public final class h extends b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    b rGA;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;

    public h(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40086);
        this.hwd = mMActivity;
        this.rGA = (b) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40081);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ab.i("MicroMsg.TurnCardAdClickAnimation", "value %f", Float.valueOf(floatValue));
                if (floatValue != 1.0f) {
                    h.this.rGA.rJf.setScaleX(floatValue);
                    h.this.rGA.rJf.setScaleY(floatValue);
                    h.this.rGA.rJf.setAlpha(floatValue);
                }
                AppMethodBeat.o(40081);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40082);
                if (h.this.rGA.eBB) {
                    ab.i("MicroMsg.TurnCardAdClickAnimation", "holder is busy");
                    Iterator it = h.this.rGa.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        ((Animator) it.next()).cancel();
                    }
                    AppMethodBeat.o(40082);
                    return;
                }
                h.this.rGA.eBB = true;
                h.this.rGA.rJf.getLocationInWindow(h.this.rGg);
                ab.i("MicroMsg.TurnCardAdClickAnimation", "location in window %s, %s, %s, %s", Integer.valueOf(h.this.rGg[0]), Integer.valueOf(h.this.rGg[1]), Integer.valueOf(h.this.rGA.rJf.getWidth()), Integer.valueOf(h.this.rGA.rJf.getHeight()));
                h.this.rGA.rHB.removeView(h.this.rGA.rJf);
                ViewGroup.LayoutParams layoutParams = h.this.rGA.rHB.getLayoutParams();
                layoutParams.width = h.this.rGA.rJf.getWidth();
                layoutParams.height = (h.this.rGA.rJf.getHeight() + h.this.rGn.topMargin) + h.this.rGn.bottomMargin;
                h.this.rGA.rHB.setLayoutParams(layoutParams);
                h.this.rGj = new LayoutParams(-2, -2);
                h.this.rGj.leftMargin = h.this.rGg[0];
                h.this.rGj.rightMargin = (h.this.rGb.getWidth() - h.this.rGj.leftMargin) - h.this.rGA.rJf.getWidth();
                h.this.rGj.topMargin = h.this.rGg[1];
                h.this.rGj.bottomMargin = (h.this.rGb.getHeight() - h.this.rGj.topMargin) - h.this.rGA.rJf.getHeight();
                h.this.rGb.addView(h.this.rGA.rJf, h.this.rGj);
                AppMethodBeat.o(40082);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40083);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                h.this.rGA.rGQ.setAlpha(floatValue);
                h.this.rGA.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40083);
            }
        });
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGA.rJf.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40084);
                ab.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation start");
                AppMethodBeat.o(40084);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40085);
                ab.i("MicroMsg.TurnCardAdClickAnimation", "onAnimation end");
                ((ViewGroup) h.this.rGA.rJf.getParent()).removeView(h.this.rGA.rJf);
                h.this.rGA.rHB.addView(h.this.rGA.rJf, h.this.rGn);
                h.this.rGA.rJf.setScaleX(1.0f);
                h.this.rGA.rJf.setScaleY(1.0f);
                h.this.rGA.rJf.setAlpha(1.0f);
                h.this.rGA.rGQ.setAlpha(1.0f);
                h.this.rGA.rGR.setAlpha(1.0f);
                if (h.this.rFW != null) {
                    h.this.rFW.onAnimationEnd();
                }
                h.this.rGA.eBB = false;
                AppMethodBeat.o(40085);
            }
        });
        AppMethodBeat.o(40086);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40087);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40087);
    }
}
