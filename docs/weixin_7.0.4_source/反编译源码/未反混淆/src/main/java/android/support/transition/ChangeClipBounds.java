package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
    private static final String[] xk = new String[]{"android:clipBounds:clip"};

    public final String[] getTransitionProperties() {
        return xk;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private static void c(ah ahVar) {
        View view = ahVar.view;
        if (view.getVisibility() != 8) {
            Rect au = s.au(view);
            ahVar.values.put("android:clipBounds:clip", au);
            if (au == null) {
                ahVar.values.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        if (ahVar == null || ahVar2 == null || !ahVar.values.containsKey("android:clipBounds:clip") || !ahVar2.values.containsKey("android:clipBounds:clip")) {
            return null;
        }
        int i;
        Rect rect = (Rect) ahVar.values.get("android:clipBounds:clip");
        Object obj = (Rect) ahVar2.values.get("android:clipBounds:clip");
        if (obj == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (rect == null && obj == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) ahVar.values.get("android:clipBounds:bounds");
        } else if (obj == null) {
            Rect obj2 = (Rect) ahVar2.values.get("android:clipBounds:bounds");
        }
        if (rect.equals(obj2)) {
            return null;
        }
        s.c(ahVar2.view, rect);
        z zVar = new z(new Rect());
        Animator ofObject = ObjectAnimator.ofObject(ahVar2.view, au.Bm, zVar, new Rect[]{rect, obj2});
        if (i == 0) {
            return ofObject;
        }
        final View view = ahVar2.view;
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                s.c(view, null);
            }
        });
        return ofObject;
    }
}
