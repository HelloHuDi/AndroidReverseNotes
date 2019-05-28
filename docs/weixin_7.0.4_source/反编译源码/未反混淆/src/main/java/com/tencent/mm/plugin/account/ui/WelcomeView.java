package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

public abstract class WelcomeView extends LinearLayout {
    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void cj(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300);
        alphaAnimation.setAnimationListener(new AnimationListener() {
            public final void onAnimationStart(Animation animation) {
            }

            public final void onAnimationRepeat(Animation animation) {
            }

            public final void onAnimationEnd(Animation animation) {
            }
        });
        view.startAnimation(alphaAnimation);
    }
}
