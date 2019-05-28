package com.tencent.mm.plugin.appbrand.page.a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

public abstract class a implements c {
    public abstract Context getContext();

    public abstract void q(Drawable drawable);

    public abstract void y(CharSequence charSequence);

    public static Animator cs(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        ofFloat.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        return ofFloat;
    }
}
