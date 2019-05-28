package com.tencent.mm.plugin.sns.ui.b.a;

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
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class h extends b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    d rGr;

    public h(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(40044);
        this.hwd = mMActivity;
        this.rGr = (d) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40040);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) floatValue) != 1.0d) {
                    h.this.rGr.contentView.setScaleX(floatValue);
                    h.this.rGr.contentView.setScaleY(floatValue);
                    h.this.rGr.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(40040);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40041);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                h.this.rGr.rHg.setAlpha(floatValue);
                h.this.rGr.rHf.setAlpha(floatValue);
                AppMethodBeat.o(40041);
            }
        });
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGr.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40042);
                ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation start");
                h.this.rGr.contentView.getLocationInWindow(h.this.rGg);
                ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "location in window %s, %s", Integer.valueOf(h.this.rGg[0]), Integer.valueOf(h.this.rGg[1]));
                ((ViewGroup) h.this.rGr.rpP).removeView(h.this.rGr.contentView);
                ViewGroup.LayoutParams layoutParams = h.this.rGr.rpP.getLayoutParams();
                layoutParams.width = h.this.rGr.contentView.getWidth();
                layoutParams.height = (h.this.rGr.contentView.getHeight() + h.this.rGn.topMargin) + h.this.rGn.bottomMargin;
                h.this.rGr.rpP.setLayoutParams(layoutParams);
                h.this.rGj = new LayoutParams(-2, -2);
                h.this.rGj.leftMargin = h.this.rGg[0];
                h.this.rGj.rightMargin = (h.this.rGb.getWidth() - h.this.rGj.leftMargin) - h.this.rGr.contentView.getWidth();
                h.this.rGj.topMargin = h.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                h.this.rGj.bottomMargin = (h.this.rGb.getHeight() - h.this.rGj.topMargin) - h.this.rGr.contentView.getHeight();
                h.this.rGb.addView(h.this.rGr.contentView, h.this.rGj);
                AppMethodBeat.o(40042);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40043);
                ab.i("MicroMsg.TurnCardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) h.this.hwd.mController.ylv.getParent()).removeView(h.this.rGr.contentView);
                ((ViewGroup) h.this.rGr.rpP).addView(h.this.rGr.contentView, h.this.rGn);
                h.this.rGr.contentView.setScaleX(1.0f);
                h.this.rGr.contentView.setScaleY(1.0f);
                h.this.rGr.contentView.setAlpha(1.0f);
                h.this.rGr.rHg.setAlpha(1.0f);
                h.this.rGr.rHf.setAlpha(1.0f);
                if (h.this.rFW != null) {
                    h.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40043);
            }
        });
        AppMethodBeat.o(40044);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40045);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40045);
    }
}
