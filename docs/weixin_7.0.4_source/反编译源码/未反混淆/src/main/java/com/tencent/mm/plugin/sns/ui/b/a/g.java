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

public final class g extends a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    int[] rGg = new int[2];
    LayoutParams rGj;
    LinearLayout.LayoutParams rGn;
    d rGr;

    public g(final MMActivity mMActivity, a aVar) {
        AppMethodBeat.i(40038);
        this.hwd = mMActivity;
        this.rGr = (d) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40034);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    g.this.rGr.contentView.setScaleX(floatValue);
                    g.this.rGr.contentView.setScaleY(floatValue);
                    g.this.rGr.contentView.setAlpha(floatValue);
                }
                AppMethodBeat.o(40034);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40035);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                g.this.rGr.rHg.setAlpha(floatValue);
                g.this.rGr.rHf.setAlpha(floatValue);
                AppMethodBeat.o(40035);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGn = (LinearLayout.LayoutParams) this.rGr.contentView.getLayoutParams();
        this.rGb = (FrameLayout) this.hwd.mController.ylv.getParent();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40036);
                ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation start");
                g.this.rGr.rHg.setAlpha(0.0f);
                g.this.rGr.rHf.setAlpha(0.0f);
                g.this.rGr.contentView.getLocationInWindow(g.this.rGg);
                ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "location in window %s, %s", Integer.valueOf(g.this.rGg[0]), Integer.valueOf(g.this.rGg[1]));
                ((ViewGroup) g.this.rGr.rpP).removeView(g.this.rGr.contentView);
                ViewGroup.LayoutParams layoutParams = g.this.rGr.rpP.getLayoutParams();
                layoutParams.width = g.this.rGr.contentView.getWidth();
                layoutParams.height = (g.this.rGr.contentView.getHeight() + g.this.rGn.topMargin) + g.this.rGn.bottomMargin;
                g.this.rGr.rpP.setLayoutParams(layoutParams);
                g.this.rGj = new LayoutParams(-2, -2);
                g.this.rGj.leftMargin = g.this.rGg[0];
                g.this.rGj.rightMargin = (g.this.rGb.getWidth() - g.this.rGj.leftMargin) - g.this.rGr.contentView.getWidth();
                g.this.rGj.topMargin = g.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                g.this.rGj.bottomMargin = (g.this.rGb.getHeight() - g.this.rGj.topMargin) - g.this.rGr.contentView.getHeight();
                g.this.rGb.addView(g.this.rGr.contentView, g.this.rGj);
                AppMethodBeat.o(40036);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40037);
                ab.i("MicroMsg.TurnCardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) g.this.hwd.mController.ylv.getParent()).removeView(g.this.rGr.contentView);
                ((ViewGroup) g.this.rGr.rpP).addView(g.this.rGr.contentView, g.this.rGn);
                g.this.rGr.contentView.setScaleX(1.0f);
                g.this.rGr.contentView.setScaleY(1.0f);
                g.this.rGr.contentView.setAlpha(1.0f);
                g.this.rGr.rHf.setAlpha(1.0f);
                g.this.rGr.rHg.setAlpha(1.0f);
                if (g.this.rFW != null) {
                    g.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40037);
            }
        });
        AppMethodBeat.o(40038);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40039);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40039);
    }
}
