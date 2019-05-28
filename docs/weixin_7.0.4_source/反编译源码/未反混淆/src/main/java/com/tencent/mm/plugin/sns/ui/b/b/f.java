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

public final class f extends b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    a rGx;

    public f(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40072);
        this.hwd = mMActivity;
        this.rGx = (a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40067);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 1.0f) {
                    f.this.rGx.roq.setScaleX(floatValue);
                    f.this.rGx.roq.setScaleY(floatValue);
                    f.this.rGx.roq.setAlpha(floatValue);
                }
                AppMethodBeat.o(40067);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40068);
                if (f.this.rGx.eBB) {
                    ab.i("MicroMsg.FullCardAdClickAnimation", "holder is busy");
                    f.this.rGa.end();
                    AppMethodBeat.o(40068);
                    return;
                }
                f.this.rGx.eBB = true;
                f.this.rGx.roq.getLocationInWindow(f.this.rGg);
                ab.i("MicroMsg.FullCardAdClickAnimation", "location in window %s, %s", Integer.valueOf(f.this.rGg[0]), Integer.valueOf(f.this.rGg[1]));
                f.this.rGx.rHB.removeView(f.this.rGx.roq);
                ViewGroup.LayoutParams layoutParams = f.this.rGx.rHB.getLayoutParams();
                layoutParams.width = f.this.rGx.roq.getWidth();
                layoutParams.height = (f.this.rGx.roq.getHeight() + f.this.rGn.topMargin) + f.this.rGn.bottomMargin;
                f.this.rGx.rHB.setLayoutParams(layoutParams);
                f.this.rGj = new LayoutParams(-2, -2);
                f.this.rGj.leftMargin = f.this.rGg[0];
                f.this.rGj.rightMargin = (f.this.rGb.getWidth() - f.this.rGj.leftMargin) - f.this.rGx.roq.getWidth();
                f.this.rGj.topMargin = f.this.rGg[1];
                f.this.rGj.bottomMargin = (f.this.rGb.getHeight() - f.this.rGj.topMargin) - f.this.rGx.roq.getHeight();
                f.this.rGb.addView(f.this.rGx.roq, f.this.rGj);
                AppMethodBeat.o(40068);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40069);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f.this.rGx.rGQ.setAlpha(floatValue);
                f.this.rGx.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40069);
            }
        });
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGx.roq.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40070);
                ab.i("MicroMsg.FullCardAdClickAnimation", "onAnimation start");
                AppMethodBeat.o(40070);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40071);
                ab.i("MicroMsg.FullCardAdClickAnimation", "onAnimation end");
                ((ViewGroup) f.this.rGx.roq.getParent()).removeView(f.this.rGx.roq);
                f.this.rGx.rHB.addView(f.this.rGx.roq, f.this.rGn);
                f.this.rGx.roq.setScaleX(1.0f);
                f.this.rGx.roq.setScaleY(1.0f);
                f.this.rGx.roq.setAlpha(1.0f);
                f.this.rGx.rGQ.setAlpha(1.0f);
                f.this.rGx.rGR.setAlpha(1.0f);
                if (f.this.rFW != null) {
                    f.this.rFW.onAnimationEnd();
                }
                f.this.rGx.eBB = false;
                AppMethodBeat.o(40071);
            }
        });
        AppMethodBeat.o(40072);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40073);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40073);
    }
}
