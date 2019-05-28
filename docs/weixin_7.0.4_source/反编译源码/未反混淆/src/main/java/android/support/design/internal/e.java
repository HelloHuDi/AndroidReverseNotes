package android.support.design.internal;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.support.transition.Transition;
import android.support.transition.ah;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Map;

public final class e extends Transition {
    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    private static void c(ah ahVar) {
        if (ahVar.view instanceof TextView) {
            ahVar.values.put("android:textscale:scale", Float.valueOf(((TextView) ahVar.view).getScaleX()));
        }
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        float f = 1.0f;
        if (ahVar == null || ahVar2 == null || !(ahVar.view instanceof TextView) || !(ahVar2.view instanceof TextView)) {
            return null;
        }
        final TextView textView = (TextView) ahVar2.view;
        Map map = ahVar.values;
        Map map2 = ahVar2.values;
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
