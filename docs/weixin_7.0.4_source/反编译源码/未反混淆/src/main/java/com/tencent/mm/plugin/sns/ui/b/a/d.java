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

public final class d extends b {
    b rFX;
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    private AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    int[] rGg = new int[2];
    FrameLayout.LayoutParams rGj;

    public d(final MMActivity mMActivity, final a aVar) {
        AppMethodBeat.i(40020);
        this.hwd = mMActivity;
        this.rFX = (b) aVar;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40016);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (((double) floatValue) != 1.0d) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.rFX.contentView.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) d.this.rGj.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) d.this.rGj.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) d.this.rGj.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) d.this.rGj.bottomMargin) * floatValue);
                    d.this.rFX.contentView.setLayoutParams(layoutParams);
                    d.this.rFX.rGN.setScaleX(floatValue);
                    d.this.rFX.rGN.setScaleY(floatValue);
                    d.this.rFX.rGN.setAlpha(floatValue);
                }
                AppMethodBeat.o(40016);
            }
        });
        this.rFY.setDuration(400);
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40017);
                d.this.rFX.rGO.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(40017);
            }
        });
        this.rFZ.setDuration(100);
        this.rGc = (LayoutParams) this.rFX.contentView.getLayoutParams();
        this.rGd = (LayoutParams) this.rFX.rGN.getLayoutParams();
        this.rGe = (LayoutParams) this.rFX.rGO.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40018);
                ab.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation start");
                d.this.rFX.contentView.getLocationInWindow(d.this.rGg);
                ab.i("MicroMsg.CardAdDetailClickAnimation", "card container location in window %s, %s", Integer.valueOf(d.this.rGg[0]), Integer.valueOf(d.this.rGg[1]));
                d.this.rGj = new FrameLayout.LayoutParams(-2, -2);
                d.this.rGj.leftMargin = d.this.rGg[0];
                d.this.rGj.rightMargin = (d.this.rGb.getWidth() - d.this.rGj.leftMargin) - d.this.rFX.contentView.getWidth();
                d.this.rGj.topMargin = d.this.rGg[1] - ae.getStatusBarHeight(mMActivity);
                d.this.rGj.bottomMargin = (d.this.rGb.getHeight() - d.this.rGj.topMargin) - d.this.rFX.contentView.getHeight();
                ab.i("MicroMsg.CardAdDetailClickAnimation", "left %s, top %s, right %s, bottom %s", Integer.valueOf(d.this.rGj.leftMargin), Integer.valueOf(d.this.rGj.topMargin), Integer.valueOf(d.this.rGj.rightMargin), Integer.valueOf(d.this.rGj.bottomMargin));
                int[] iArr = new int[2];
                d.this.rFX.rGN.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdDetailClickAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (d.this.rGb.getWidth() - layoutParams.leftMargin) - d.this.rFX.rGN.getWidth();
                layoutParams.topMargin = iArr[1] - ae.getStatusBarHeight(mMActivity);
                layoutParams.bottomMargin = (d.this.rGb.getHeight() - layoutParams.topMargin) - d.this.rFX.rGN.getHeight();
                int[] iArr2 = new int[2];
                d.this.rFX.rGO.getLocationInWindow(iArr2);
                ab.i("MicroMsg.CardAdDetailClickAnimation", "other container location in window %s, %s", Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr2[0];
                layoutParams2.rightMargin = (d.this.rGb.getWidth() - layoutParams2.leftMargin) - ((b) aVar).rGO.getWidth();
                layoutParams2.topMargin = iArr2[1] - ae.getStatusBarHeight(mMActivity);
                layoutParams2.bottomMargin = (d.this.rGb.getHeight() - layoutParams2.topMargin) - ((b) aVar).rGO.getHeight();
                ViewGroup.LayoutParams layoutParams3 = d.this.rFX.rpP.getLayoutParams();
                layoutParams3.width = d.this.rFX.contentView.getWidth();
                layoutParams3.height = (d.this.rFX.contentView.getHeight() + d.this.rGc.topMargin) + d.this.rGc.bottomMargin;
                d.this.rFX.rpP.setLayoutParams(layoutParams3);
                ((ViewGroup) d.this.rFX.rpP).removeView(d.this.rFX.contentView);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams4.leftMargin = d.this.rGj.leftMargin;
                layoutParams4.rightMargin = d.this.rGj.rightMargin;
                layoutParams4.topMargin = d.this.rGj.topMargin;
                layoutParams4.bottomMargin = d.this.rGj.bottomMargin;
                d.this.rGb.addView(d.this.rFX.contentView, layoutParams4);
                ((ViewGroup) d.this.rFX.contentView).removeView(d.this.rFX.rGN);
                d.this.rGb.addView(d.this.rFX.rGN, layoutParams);
                ((ViewGroup) d.this.rFX.contentView).removeView(d.this.rFX.rGO);
                d.this.rGb.addView(d.this.rFX.rGO, layoutParams2);
                AppMethodBeat.o(40018);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40019);
                ab.i("MicroMsg.CardAdDetailClickAnimation", "onAnimation end");
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(d.this.rFX.contentView);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(d.this.rFX.rGN);
                ((ViewGroup) mMActivity.mController.ylv.getParent()).removeView(d.this.rFX.rGO);
                d.this.rFX.rGN.setScaleX(1.0f);
                d.this.rFX.rGN.setScaleY(1.0f);
                d.this.rFX.rGN.setAlpha(1.0f);
                ((ViewGroup) d.this.rFX.rpP).addView(d.this.rFX.contentView, d.this.rGc);
                ((ViewGroup) d.this.rFX.contentView).addView(d.this.rFX.rGN, d.this.rGd);
                ((ViewGroup) d.this.rFX.contentView).addView(d.this.rFX.rGO, d.this.rGe);
                d.this.rFX.rGO.setAlpha(1.0f);
                if (d.this.rFW != null) {
                    d.this.rFW.onAnimationEnd();
                }
                AppMethodBeat.o(40019);
            }
        });
        AppMethodBeat.o(40020);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40021);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40021);
    }
}
