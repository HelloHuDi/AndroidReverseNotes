package com.tencent.mm.plugin.sns.ui.b.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.ui.item.BaseTimeLineItem.BaseViewHolder;
import com.tencent.mm.plugin.sns.ui.item.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

public final class d extends b {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    int[] rGg = new int[2];
    FrameLayout.LayoutParams rGj;
    a rGu;

    public d(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40058);
        this.hwd = mMActivity;
        this.rGu = (a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40053);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 1.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) d.this.rGu.rIE.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) d.this.rGj.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) d.this.rGj.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) d.this.rGj.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) d.this.rGj.bottomMargin) * floatValue);
                    d.this.rGu.rIE.setLayoutParams(layoutParams);
                    d.this.rGu.rIF.setScaleX(floatValue);
                    d.this.rGu.rIF.setScaleY(floatValue);
                    d.this.rGu.rIF.setAlpha(floatValue);
                }
                AppMethodBeat.o(40053);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40054);
                if (d.this.rGu.eBB) {
                    ab.i("MicroMsg.CardAdClickAnimation", "holder is busy");
                    d.this.rGa.end();
                    AppMethodBeat.o(40054);
                    return;
                }
                d.this.rGu.eBB = true;
                d.this.rGu.rIE.getLocationInWindow(d.this.rGg);
                ab.i("MicroMsg.CardAdClickAnimation", "card container location in window %s, %s", Integer.valueOf(d.this.rGg[0]), Integer.valueOf(d.this.rGg[1]));
                d.this.rGj = new FrameLayout.LayoutParams(-2, -2);
                d.this.rGj.leftMargin = d.this.rGg[0];
                d.this.rGj.rightMargin = (d.this.rGb.getWidth() - d.this.rGj.leftMargin) - d.this.rGu.rIE.getWidth();
                d.this.rGj.topMargin = d.this.rGg[1];
                d.this.rGj.bottomMargin = (d.this.rGb.getHeight() - d.this.rGj.topMargin) - d.this.rGu.rIE.getHeight();
                int[] iArr = new int[2];
                d.this.rGu.rIF.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdClickAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (d.this.rGb.getWidth() - layoutParams.leftMargin) - d.this.rGu.rIF.getWidth();
                layoutParams.topMargin = iArr[1];
                layoutParams.bottomMargin = (d.this.rGb.getHeight() - layoutParams.topMargin) - d.this.rGu.rIF.getHeight();
                iArr = new int[2];
                d.this.rGu.rIG.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdClickAnimation", "other container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams2.leftMargin = iArr[0];
                layoutParams2.rightMargin = (d.this.rGb.getWidth() - layoutParams2.leftMargin) - d.this.rGu.rIG.getWidth();
                layoutParams2.topMargin = iArr[1];
                layoutParams2.bottomMargin = (d.this.rGb.getHeight() - layoutParams2.topMargin) - d.this.rGu.rIG.getHeight();
                ViewGroup.LayoutParams layoutParams3 = d.this.rGu.rHB.getLayoutParams();
                layoutParams3.width = d.this.rGu.rIE.getWidth();
                layoutParams3.height = (d.this.rGu.rIE.getHeight() + d.this.rGc.topMargin) + d.this.rGc.bottomMargin;
                d.this.rGu.rHB.setLayoutParams(layoutParams3);
                FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-1, -1);
                layoutParams4.leftMargin = d.this.rGj.leftMargin;
                layoutParams4.rightMargin = d.this.rGj.rightMargin;
                layoutParams4.topMargin = d.this.rGj.topMargin;
                layoutParams4.bottomMargin = d.this.rGj.bottomMargin;
                d.this.rGu.rHB.removeView(d.this.rGu.rIE);
                d.this.rGb.addView(d.this.rGu.rIE, layoutParams4);
                d.this.rGu.rIE.removeView(d.this.rGu.rIF);
                d.this.rGb.addView(d.this.rGu.rIF, layoutParams);
                d.this.rGu.rIE.removeView(d.this.rGu.rIG);
                d.this.rGb.addView(d.this.rGu.rIG, layoutParams2);
                AppMethodBeat.o(40054);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40055);
                d.this.rGu.rIG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(40055);
            }
        });
        this.rFZ.setDuration(100);
        this.rGc = (LayoutParams) this.rGu.rIE.getLayoutParams();
        this.rGd = (LayoutParams) this.rGu.rIF.getLayoutParams();
        this.rGe = (LayoutParams) this.rGu.rIG.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40056);
                ab.i("MicroMsg.CardAdClickAnimation", "onAnimation start");
                AppMethodBeat.o(40056);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40057);
                ab.i("MicroMsg.CardAdClickAnimation", "onAnimation end");
                ((ViewGroup) d.this.rGu.rIE.getParent()).removeView(d.this.rGu.rIE);
                ((ViewGroup) d.this.rGu.rIF.getParent()).removeView(d.this.rGu.rIF);
                ((ViewGroup) d.this.rGu.rIG.getParent()).removeView(d.this.rGu.rIG);
                d.this.rGu.rHB.addView(d.this.rGu.rIE, d.this.rGc);
                d.this.rGu.rIE.addView(d.this.rGu.rIF, d.this.rGd);
                d.this.rGu.rIE.addView(d.this.rGu.rIG, d.this.rGe);
                d.this.rGu.rIF.setScaleX(1.0f);
                d.this.rGu.rIF.setScaleY(1.0f);
                d.this.rGu.rIF.setAlpha(1.0f);
                d.this.rGu.rIG.setAlpha(1.0f);
                if (d.this.rFW != null) {
                    d.this.rFW.onAnimationEnd();
                }
                d.this.rGu.eBB = false;
                AppMethodBeat.o(40057);
            }
        });
        AppMethodBeat.o(40058);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40059);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40059);
    }
}
