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

public final class f extends b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    c rGp;

    public f(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(40032);
        this.hwd = mMActivity;
        this.rGp = (c) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40028);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    f.this.rGp.contentView.setScaleX(floatValue);
                    f.this.rGp.contentView.setScaleY(floatValue);
                    f.this.rGp.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(40028);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40029);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                f.this.rGp.rGQ.setAlpha(floatValue);
                f.this.rGp.rGR.setAlpha(floatValue);
                AppMethodBeat.o(40029);
            }
        });
        this.rFZ.setDuration(100);
        this.rGn = (LinearLayout.LayoutParams) this.rGp.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40030);
                ab.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation start");
                f.this.rGp.contentView.getLocationInWindow(f.this.rGg);
                ab.i("MicroMsg.FullCardAdDetailClickAnimation", "location in window %s, %s", Integer.valueOf(f.this.rGg[0]), Integer.valueOf(f.this.rGg[1]));
                ((ViewGroup) f.this.rGp.rpP).removeView(f.this.rGp.contentView);
                ViewGroup.LayoutParams layoutParams = f.this.rGp.rpP.getLayoutParams();
                layoutParams.width = f.this.rGp.contentView.getWidth();
                layoutParams.height = (f.this.rGp.contentView.getHeight() + f.this.rGn.topMargin) + f.this.rGn.bottomMargin;
                f.this.rGp.rpP.setLayoutParams(layoutParams);
                f.this.rGj = new LayoutParams(-2, -2);
                f.this.rGj.leftMargin = f.this.rGg[0];
                f.this.rGj.rightMargin = (f.this.rGb.getWidth() - f.this.rGj.leftMargin) - f.this.rGp.contentView.getWidth();
                f.this.rGj.topMargin = f.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                f.this.rGj.bottomMargin = (f.this.rGb.getHeight() - f.this.rGj.topMargin) - f.this.rGp.contentView.getHeight();
                f.this.rGb.addView(f.this.rGp.contentView, f.this.rGj);
                AppMethodBeat.o(40030);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40031);
                ab.i("MicroMsg.FullCardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) f.this.hwd.mController.ylv.getParent()).removeView(f.this.rGp.contentView);
                ((ViewGroup) f.this.rGp.rpP).addView(f.this.rGp.contentView, f.this.rGn);
                f.this.rGp.contentView.setScaleX(1.0f);
                f.this.rGp.contentView.setScaleY(1.0f);
                f.this.rGp.contentView.setAlpha(1.0f);
                f.this.rGp.rGQ.setAlpha(1.0f);
                f.this.rGp.rGR.setAlpha(1.0f);
                if (f.this.rFW != null) {
                    f.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40031);
            }
        });
        AppMethodBeat.o(40032);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40033);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40033);
    }
}
