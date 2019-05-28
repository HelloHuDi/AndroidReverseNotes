package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.C8368ah;
import android.support.transition.Transition;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

/* renamed from: android.support.design.internal.e */
public final class C0253e extends Transition {
    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        C0253e.m423c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        C0253e.m423c(c8368ah);
    }

    /* renamed from: c */
    private static void m423c(C8368ah c8368ah) {
        if (c8368ah.view instanceof TextView) {
            c8368ah.values.put("android:textscale:scale", Float.valueOf(((TextView) c8368ah.view).getScaleX()));
        }
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        float f = 1.0f;
        if (c8368ah == null || c8368ah2 == null || !(c8368ah.view instanceof TextView) || !(c8368ah2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) c8368ah2.view;
        Map map = c8368ah.values;
        Map map2 = c8368ah2.values;
        float floatValue = map.get("android:textscale:scale") != null ? ((Float) map.get("android:textscale:scale")).floatValue() : 1.0f;
        if (map2.get("android:textscale:scale") != null) {
            f = ((Float) map2.get("android:textscale:scale")).floatValue();
        }
        if (floatValue == f) {
            return null;
        }
        Animator ofFloat = ValueAnimator.ofFloat(new float[]{floatValue, f});
        ofFloat.addUpdateListener(new AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }
}
