package com.tencent.mm.plugin.sns.ui.b.a;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.c.a.a;
import com.tencent.mm.plugin.sns.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ae;

public final class c extends a {
    b rFX;
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    FrameLayout.LayoutParams rGf;
    int[] rGg = new int[2];

    public c(final MMActivity mMActivity, final a aVar) {
        AppMethodBeat.i(40014);
        this.hwd = mMActivity;
        this.rFX = (b) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40010);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.rFX.contentView.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) c.this.rGf.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) c.this.rGf.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) c.this.rGf.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) c.this.rGf.bottomMargin) * floatValue);
                    layoutParams.width = (c.this.rGb.getWidth() - layoutParams.leftMargin) - layoutParams.rightMargin;
                    layoutParams.height = (c.this.rGb.getHeight() - layoutParams.topMargin) - layoutParams.bottomMargin;
                    c.this.rFX.contentView.setLayoutParams(layoutParams);
                    c.this.rFX.contentView.setAlpha(floatValue);
                    c.this.rFX.rGN.setScaleX(floatValue);
                    c.this.rFX.rGN.setScaleY(floatValue);
                    c.this.rFX.rGN.setAlpha(floatValue);
                }
                AppMethodBeat.o(40010);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40011);
                c.this.rFX.rGO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(40011);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGc = (LayoutParams) this.rFX.contentView.getLayoutParams();
        this.rGd = (LayoutParams) this.rFX.rGN.getLayoutParams();
        this.rGe = (LayoutParams) this.rFX.rGO.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40012);
                ab.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation start");
                c.this.rFX.contentView.getLocationInWindow(c.this.rGg);
                ab.i("MicroMsg.CardAdDetailBackAnimation", "card container location in window %s, %s", Integer.valueOf(c.this.rGg[0]), Integer.valueOf(c.this.rGg[1]));
                c.this.rGf = new FrameLayout.LayoutParams(-2, -2);
                c.this.rGf.leftMargin = c.this.rGg[0];
                c.this.rGf.rightMargin = (c.this.rGb.getWidth() - c.this.rGf.leftMargin) - c.this.rFX.contentView.getWidth();
                c.this.rGf.topMargin = c.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                c.this.rGf.bottomMargin = (c.this.rGb.getHeight() - c.this.rGf.topMargin) - c.this.rFX.contentView.getHeight();
                int[] iArr = new int[2];
                c.this.rFX.rGN.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdDetailBackAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (c.this.rGb.getWidth() - layoutParams.leftMargin) - c.this.rFX.rGN.getWidth();
                layoutParams.topMargin = iArr[1] - ae.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (c.this.rGb.getHeight() - layoutParams.topMargin) - c.this.rFX.rGN.getHeight();
                int[] iArr2 = new int[2];
                c.this.rFX.rGO.getLocationInWindow(iArr2);
                ab.i("MicroMsg.CardAdDetailBackAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (c.this.rGb.getWidth() - layoutParams2.leftMargin) - ((b) aVar).rGO.getWidth();
                layoutParams2.topMargin = iArr2[1] - ae.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (c.this.rGb.getHeight() - layoutParams2.topMargin) - ((b) aVar).rGO.getHeight();
                ViewGroup.LayoutParams layoutParams3 = c.this.rFX.rpP.getLayoutParams();
                layoutParams3.width = c.this.rFX.contentView.getWidth();
                layoutParams3.height = (c.this.rFX.contentView.getHeight() + c.this.rGc.topMargin) + c.this.rGc.bottomMargin;
                c.this.rFX.rpP.setLayoutParams(layoutParams3);
                c.this.rFX.rGO.setAlpha(0.0f);
                ((ViewGroup) c.this.rFX.rpP).removeView(c.this.rFX.contentView);
                c.this.rGb.addView(c.this.rFX.contentView, new FrameLayout.LayoutParams(-1, -1));
                ((ViewGroup) c.this.rFX.contentView).removeView(c.this.rFX.rGN);
                c.this.rGb.addView(c.this.rFX.rGN, layoutParams);
                ((ViewGroup) c.this.rFX.contentView).removeView(c.this.rFX.rGO);
                c.this.rGb.addView(c.this.rFX.rGO, layoutParams2);
                c.this.rFX.rGN.setScaleX(0.0f);
                c.this.rFX.rGN.setScaleY(0.0f);
                c.this.rFX.rGN.setAlpha(0.0f);
                AppMethodBeat.o(40012);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40013);
                ab.i("MicroMsg.CardAdDetailBackAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(c.this.rFX.contentView);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(c.this.rFX.rGN);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(c.this.rFX.rGO);
                c.this.rFX.rGN.setScaleX(1.0f);
                c.this.rFX.rGN.setScaleY(1.0f);
                c.this.rFX.rGN.setAlpha(1.0f);
                ((ViewGroup) c.this.rFX.rpP).addView(c.this.rFX.contentView, c.this.rGc);
                ((ViewGroup) c.this.rFX.contentView).addView(c.this.rFX.rGN, c.this.rGd);
                ((ViewGroup) c.this.rFX.contentView).addView(c.this.rFX.rGO, c.this.rGe);
                c.this.rFX.contentView.setAlpha(1.0f);
                c.this.rFX.rGO.setAlpha(1.0f);
                if (c.this.rFW != null) {
                    c.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40013);
            }
        });
        AppMethodBeat.o(40014);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40015);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40015);
    }
}
