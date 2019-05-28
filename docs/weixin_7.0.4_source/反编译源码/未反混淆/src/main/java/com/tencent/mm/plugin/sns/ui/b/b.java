package com.tencent.mm.plugin.sns.ui.b;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    public ValueAnimator nVD = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
    private Context rFO;
    public int rFP;
    public int rFQ;
    public int rFR;
    public int rFS;
    public a rFT;
    View view;

    public b(Activity activity, View view) {
        AppMethodBeat.i(40005);
        this.rFO = activity;
        this.view = view;
        this.nVD.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40002);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                b.this.view.setAlpha(1.0f - floatValue);
                if (floatValue != 1.0f) {
                    LayoutParams layoutParams = (LayoutParams) b.this.view.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) b.this.rFP) * floatValue);
                    layoutParams.topMargin = (int) (((float) b.this.rFQ) * floatValue);
                    ViewGroup viewGroup = (ViewGroup) b.this.view.getParent();
                    layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) b.this.rFR) * floatValue)) - ((float) layoutParams.leftMargin));
                    layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) b.this.rFS) * floatValue)) - ((float) layoutParams.topMargin));
                    b.this.view.setLayoutParams(layoutParams);
                }
                if (b.this.rFT != null) {
                    b.this.rFT.aZ(floatValue);
                }
                AppMethodBeat.o(40002);
            }
        });
        this.nVD.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40003);
                LayoutParams layoutParams = (LayoutParams) b.this.view.getLayoutParams();
                layoutParams.leftMargin = b.this.rFP;
                layoutParams.topMargin = b.this.rFQ;
                ViewGroup viewGroup = (ViewGroup) b.this.view.getParent();
                layoutParams.rightMargin = (viewGroup.getWidth() - b.this.rFR) - layoutParams.leftMargin;
                layoutParams.bottomMargin = (viewGroup.getHeight() - b.this.rFS) - layoutParams.topMargin;
                b.this.view.setLayoutParams(layoutParams);
                b.this.view.setVisibility(0);
                if (b.this.rFT != null) {
                    b.this.rFT.onAnimationStart();
                }
                AppMethodBeat.o(40003);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40004);
                if (b.this.rFT != null) {
                    b.this.rFT.onAnimationEnd();
                }
                b.this.view.setVisibility(8);
                AppMethodBeat.o(40004);
            }
        });
        this.nVD.setDuration(400);
        AppMethodBeat.o(40005);
    }
}
