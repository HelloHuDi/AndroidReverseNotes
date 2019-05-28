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
import com.tencent.mm.plugin.sns.ui.c.a.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class e extends a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    c rGm;
    LinearLayout.LayoutParams rGn;

    public e(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(40026);
        this.hwd = mMActivity;
        this.rGm = (c) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40022);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    e.this.rGm.contentView.setScaleX(floatValue);
                    e.this.rGm.contentView.setScaleY(floatValue);
                    e.this.rGm.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(40022);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40023);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                e.this.rGm.rGQ.setAlpha(floatValue);
                e.this.rGm.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40023);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGm.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40024);
                ab.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation start");
                e.this.rGm.rGQ.setAlpha(0.0f);
                e.this.rGm.rGR.setAlpha(0.0f);
                e.this.rGm.contentView.getLocationInWindow(e.this.rGg);
                ab.i("MicroMsg.FullCardAdDetailBackAnimation", "location in window %s, %s", Integer.valueOf(e.this.rGg[0]), Integer.valueOf(e.this.rGg[1]));
                ((ViewGroup) e.this.rGm.rpP).removeView(e.this.rGm.contentView);
                ViewGroup.LayoutParams layoutParams = e.this.rGm.rpP.getLayoutParams();
                layoutParams.width = e.this.rGm.contentView.getWidth();
                layoutParams.height = (e.this.rGm.contentView.getHeight() + e.this.rGn.topMargin) + e.this.rGn.bottomMargin;
                e.this.rGm.rpP.setLayoutParams(layoutParams);
                e.this.rGj = new LayoutParams(-2, -2);
                e.this.rGj.leftMargin = e.this.rGg[0];
                e.this.rGj.rightMargin = (e.this.rGb.getWidth() - e.this.rGj.leftMargin) - e.this.rGm.contentView.getWidth();
                e.this.rGj.topMargin = e.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                e.this.rGj.bottomMargin = (e.this.rGb.getHeight() - e.this.rGj.topMargin) - e.this.rGm.contentView.getHeight();
                e.this.rGb.addView(e.this.rGm.contentView, e.this.rGj);
                AppMethodBeat.o(40024);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40025);
                ab.i("MicroMsg.FullCardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) e.this.hwd.mController.ylv.getParent()).removeView(e.this.rGm.contentView);
                ((ViewGroup) e.this.rGm.rpP).addView(e.this.rGm.contentView, e.this.rGn);
                e.this.rGm.contentView.setScaleX(1.0f);
                e.this.rGm.contentView.setScaleY(1.0f);
                e.this.rGm.contentView.setAlpha(1.0f);
                e.this.rGm.rGQ.setAlpha(1.0f);
                e.this.rGm.rGR.setAlpha(1.0f);
                if (e.this.rFW != null) {
                    e.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40025);
            }
        });
        AppMethodBeat.o(40026);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40027);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40027);
    }
}
