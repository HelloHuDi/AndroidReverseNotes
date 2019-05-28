package com.tencent.p177mm.plugin.account.p275ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;

/* renamed from: com.tencent.mm.plugin.account.ui.WelcomeView */
public abstract class WelcomeView extends LinearLayout {

    /* renamed from: com.tencent.mm.plugin.account.ui.WelcomeView$1 */
    class C380791 implements AnimationListener {
        C380791() {
        }

        public final void onAnimationStart(Animation animation) {
        }

        public final void onAnimationRepeat(Animation animation) {
        }

        public final void onAnimationEnd(Animation animation) {
        }
    }

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: cj */
    public final void mo60826cj(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setDuration(300);
        alphaAnimation.setAnimationListener(new C380791());
        view.startAnimation(alphaAnimation);
    }
}
