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
import com.tencent.mm.plugin.sns.ui.item.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.Iterator;

public final class e extends a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    a rGx;

    public e(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40065);
        this.hwd = mMActivity;
        this.rGx = (a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40060);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    e.this.rGx.roq.setScaleX(floatValue);
                    e.this.rGx.roq.setScaleY(floatValue);
                    e.this.rGx.roq.setAlpha(floatValue);
                }
                AppMethodBeat.o(40060);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40061);
                if (e.this.rGx.eBB) {
                    ab.i("MicroMsg.FullCardAdBackAnimation", "holder is busy");
                    Iterator it = e.this.rGa.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        ((Animator) it.next()).cancel();
                    }
                    AppMethodBeat.o(40061);
                    return;
                }
                e.this.rGx.eBB = true;
                e.this.rGx.roq.getLocationInWindow(e.this.rGg);
                ab.i("MicroMsg.FullCardAdBackAnimation", "location in window %s, %s", Integer.valueOf(e.this.rGg[0]), Integer.valueOf(e.this.rGg[1]));
                e.this.rGx.rHB.removeView(e.this.rGx.roq);
                ViewGroup.LayoutParams layoutParams = e.this.rGx.rHB.getLayoutParams();
                layoutParams.width = e.this.rGx.roq.getWidth();
                layoutParams.height = (e.this.rGx.roq.getHeight() + e.this.rGn.topMargin) + e.this.rGn.bottomMargin;
                e.this.rGx.rHB.setLayoutParams(layoutParams);
                e.this.rGj = new LayoutParams(-2, -2);
                e.this.rGj.leftMargin = e.this.rGg[0];
                e.this.rGj.rightMargin = (e.this.rGb.getWidth() - e.this.rGj.leftMargin) - e.this.rGx.roq.getWidth();
                e.this.rGj.topMargin = e.this.rGg[1];
                e.this.rGj.bottomMargin = (e.this.rGb.getHeight() - e.this.rGj.topMargin) - e.this.rGx.roq.getHeight();
                e.this.rGb.addView(e.this.rGx.roq, e.this.rGj);
                e.this.rGx.rGQ.setAlpha(0.0f);
                e.this.rGx.rGR.setAlpha(0.0f);
                AppMethodBeat.o(40061);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40062);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                e.this.rGx.rGQ.setAlpha(floatValue);
                e.this.rGx.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40062);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGx.roq.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40063);
                ab.i("MicroMsg.FullCardAdBackAnimation", "onAnimation start");
                AppMethodBeat.o(40063);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40064);
                ab.i("MicroMsg.FullCardAdBackAnimation", "onAnimation end");
                ((ViewGroup) e.this.rGx.roq.getParent()).removeView(e.this.rGx.roq);
                e.this.rGx.rHB.addView(e.this.rGx.roq, e.this.rGn);
                e.this.rGx.roq.setScaleX(1.0f);
                e.this.rGx.roq.setScaleY(1.0f);
                e.this.rGx.roq.setAlpha(1.0f);
                e.this.rGx.rGQ.setAlpha(1.0f);
                e.this.rGx.rGR.setAlpha(1.0f);
                if (e.this.rFW != null) {
                    e.this.rFW.onAnimationEnd();
                }
                e.this.rGx.eBB = false;
                AppMethodBeat.o(40064);
            }
        });
        AppMethodBeat.o(40065);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40066);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40066);
    }
}
