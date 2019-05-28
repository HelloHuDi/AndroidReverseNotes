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
import java.util.Iterator;

public final class c extends a {
    private ValueAnimator rFY;
    private ValueAnimator rFZ;
    AnimatorSet rGa;
    ViewGroup rGb;
    LayoutParams rGc;
    LayoutParams rGd;
    LayoutParams rGe;
    FrameLayout.LayoutParams rGf;
    int[] rGg = new int[2];
    a rGu;

    public c(MMActivity mMActivity, BaseViewHolder baseViewHolder) {
        AppMethodBeat.i(40051);
        this.hwd = mMActivity;
        this.rGu = (a) baseViewHolder;
        this.rFY = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFY.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40046);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue != 0.0f) {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) c.this.rGu.rIE.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) c.this.rGf.leftMargin) * floatValue);
                    layoutParams.rightMargin = (int) (((float) c.this.rGf.rightMargin) * floatValue);
                    layoutParams.topMargin = (int) (((float) c.this.rGf.topMargin) * floatValue);
                    layoutParams.bottomMargin = (int) (((float) c.this.rGf.bottomMargin) * floatValue);
                    c.this.rGu.rIE.setLayoutParams(layoutParams);
                    c.this.rGu.rIF.setScaleX(floatValue);
                    c.this.rGu.rIF.setScaleY(floatValue);
                    c.this.rGu.rIF.setAlpha(floatValue);
                }
                AppMethodBeat.o(40046);
            }
        });
        this.rFY.setDuration(400);
        this.rFY.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40047);
                if (c.this.rGu.eBB) {
                    ab.i("MicroMsg.CardAdBackAnimation", "holder is busy");
                    Iterator it = c.this.rGa.getChildAnimations().iterator();
                    while (it.hasNext()) {
                        ((Animator) it.next()).cancel();
                    }
                    AppMethodBeat.o(40047);
                    return;
                }
                c.this.rGu.eBB = true;
                c.this.rGu.rIE.getLocationInWindow(c.this.rGg);
                ab.i("MicroMsg.CardAdBackAnimation", "card container location in window %s, %s", Integer.valueOf(c.this.rGg[0]), Integer.valueOf(c.this.rGg[1]));
                c.this.rGf = new FrameLayout.LayoutParams(-2, -2);
                c.this.rGf.leftMargin = c.this.rGg[0];
                c.this.rGf.rightMargin = (c.this.rGb.getWidth() - c.this.rGf.leftMargin) - c.this.rGu.rIE.getWidth();
                c.this.rGf.topMargin = c.this.rGg[1];
                c.this.rGf.bottomMargin = (c.this.rGb.getHeight() - c.this.rGf.topMargin) - c.this.rGu.rIE.getHeight();
                int[] iArr = new int[2];
                c.this.rGu.rIF.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdBackAnimation", "media container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                layoutParams.leftMargin = iArr[0];
                layoutParams.rightMargin = (c.this.rGb.getWidth() - layoutParams.leftMargin) - c.this.rGu.rIF.getWidth();
                layoutParams.topMargin = iArr[1];
                layoutParams.bottomMargin = (c.this.rGb.getHeight() - layoutParams.topMargin) - c.this.rGu.rIF.getHeight();
                ViewGroup.LayoutParams layoutParams2 = c.this.rGu.rHB.getLayoutParams();
                layoutParams2.width = c.this.rGu.rIE.getWidth();
                layoutParams2.height = (c.this.rGu.rIE.getHeight() + c.this.rGc.topMargin) + c.this.rGc.bottomMargin;
                c.this.rGu.rHB.setLayoutParams(layoutParams2);
                iArr = new int[2];
                c.this.rGu.rIG.getLocationInWindow(iArr);
                ab.i("MicroMsg.CardAdBackAnimation", "other container location in window %s, %s", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
                FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-1, -2);
                layoutParams3.leftMargin = iArr[0];
                layoutParams3.rightMargin = (c.this.rGb.getWidth() - layoutParams3.leftMargin) - c.this.rGu.rIG.getWidth();
                layoutParams3.topMargin = iArr[1];
                layoutParams3.bottomMargin = (c.this.rGb.getHeight() - layoutParams3.topMargin) - c.this.rGu.rIG.getHeight();
                c.this.rGu.rIG.setAlpha(0.0f);
                c.this.rGu.rHB.removeView(c.this.rGu.rIE);
                c.this.rGb.addView(c.this.rGu.rIE, new FrameLayout.LayoutParams(-1, -1));
                c.this.rGu.rIE.removeView(c.this.rGu.rIF);
                c.this.rGb.addView(c.this.rGu.rIF, layoutParams);
                c.this.rGu.rIE.removeView(c.this.rGu.rIG);
                c.this.rGb.addView(c.this.rGu.rIG, layoutParams3);
                c.this.rGu.rIF.setScaleX(0.0f);
                c.this.rGu.rIF.setScaleY(0.0f);
                c.this.rGu.rIF.setAlpha(0.0f);
                AppMethodBeat.o(40047);
            }
        });
        this.rFZ = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.rFZ.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40048);
                c.this.rGu.rIG.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                AppMethodBeat.o(40048);
            }
        });
        this.rFZ.setDuration(100);
        this.rFZ.setStartDelay(300);
        this.rGc = (LayoutParams) this.rGu.rIE.getLayoutParams();
        this.rGd = (LayoutParams) this.rGu.rIF.getLayoutParams();
        this.rGe = (LayoutParams) this.rGu.rIG.getLayoutParams();
        this.rGa = new AnimatorSet();
        this.rGa.playTogether(new Animator[]{this.rFY, this.rFZ});
        this.rGb = (FrameLayout) mMActivity.mController.ylv.getParent();
        this.rGa.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40049);
                ab.i("MicroMsg.CardAdBackAnimation", "onAnimation start");
                AppMethodBeat.o(40049);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40050);
                ab.i("MicroMsg.CardAdBackAnimation", "onAnimation end");
                ((ViewGroup) c.this.rGu.rIE.getParent()).removeView(c.this.rGu.rIE);
                ((ViewGroup) c.this.rGu.rIF.getParent()).removeView(c.this.rGu.rIF);
                ((ViewGroup) c.this.rGu.rIG.getParent()).removeView(c.this.rGu.rIG);
                c.this.rGu.rHB.addView(c.this.rGu.rIE, c.this.rGc);
                c.this.rGu.rIE.addView(c.this.rGu.rIF, c.this.rGd);
                c.this.rGu.rIE.addView(c.this.rGu.rIG, c.this.rGe);
                c.this.rGu.rIF.setScaleX(1.0f);
                c.this.rGu.rIF.setScaleY(1.0f);
                c.this.rGu.rIF.setAlpha(1.0f);
                c.this.rGu.rIG.setAlpha(1.0f);
                if (c.this.rFW != null) {
                    c.this.rFW.onAnimationEnd();
                }
                c.this.rGu.eBB = false;
                AppMethodBeat.o(40050);
            }
        });
        AppMethodBeat.o(40051);
    }

    public final void kM(long j) {
        AppMethodBeat.i(40052);
        if (!this.rGa.isStarted()) {
            this.rGa.setStartDelay(j);
            this.rGa.start();
        }
        AppMethodBeat.o(40052);
    }
}
