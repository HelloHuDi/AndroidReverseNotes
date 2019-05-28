package com.tencent.p177mm.plugin.appbrand.page.p327a;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.tencent.ttpic.thread.FaceGestureDetGLThread;

/* renamed from: com.tencent.mm.plugin.appbrand.page.a.a */
public abstract class C44705a implements C42642c {
    public abstract Context getContext();

    /* renamed from: q */
    public abstract void mo54077q(Drawable drawable);

    /* renamed from: y */
    public abstract void mo54078y(CharSequence charSequence);

    /* renamed from: cs */
    public static Animator m81346cs(View view) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f, 1.0f});
        ofFloat.setDuration(FaceGestureDetGLThread.BRIGHTNESS_DURATION);
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        return ofFloat;
    }
}
