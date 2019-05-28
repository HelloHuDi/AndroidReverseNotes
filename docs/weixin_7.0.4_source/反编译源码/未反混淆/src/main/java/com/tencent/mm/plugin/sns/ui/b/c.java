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

public final class c {
    public ValueAnimator nVD = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
    private Context rFO;
    public int rFP;
    public int rFQ;
    public int rFR;
    public int rFS;
    public a rFT;
    View view;

    public c(Activity activity, View view) {
        AppMethodBeat.i(40009);
        this.rFO = activity;
        this.view = view;
        this.nVD.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                AppMethodBeat.i(40006);
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                c.this.view.setAlpha(1.0f - floatValue);
                if (floatValue != 0.0f) {
                    LayoutParams layoutParams = (LayoutParams) c.this.view.getLayoutParams();
                    layoutParams.leftMargin = (int) (((float) c.this.rFP) * floatValue);
                    layoutParams.topMargin = (int) (((float) c.this.rFQ) * floatValue);
                    ViewGroup viewGroup = (ViewGroup) c.this.view.getParent();
                    layoutParams.rightMargin = (int) (((((float) viewGroup.getWidth()) * floatValue) - (((float) c.this.rFR) * floatValue)) - ((float) layoutParams.leftMargin));
                    layoutParams.bottomMargin = (int) (((((float) viewGroup.getHeight()) * floatValue) - (((float) c.this.rFS) * floatValue)) - ((float) layoutParams.topMargin));
                    c.this.view.setLayoutParams(layoutParams);
                }
                if (c.this.rFT != null) {
                    c.this.rFT.aZ(floatValue);
                }
                AppMethodBeat.o(40006);
            }
        });
        this.nVD.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationStart(Animator animator) {
                AppMethodBeat.i(40007);
                if (c.this.rFT != null) {
                    c.this.rFT.onAnimationStart();
                }
                c.this.view.setVisibility(0);
                AppMethodBeat.o(40007);
            }

            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(40008);
                if (c.this.rFT != null) {
                    c.this.rFT.onAnimationEnd();
                }
                c.this.view.setVisibility(8);
                AppMethodBeat.o(40008);
            }
        });
        this.nVD.setDuration(400);
        AppMethodBeat.o(40009);
    }
}
