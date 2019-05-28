package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.support.p057v4.view.C0477s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
    /* renamed from: xk */
    private static final String[] f2297xk = new String[]{"android:clipBounds:clip"};

    public final String[] getTransitionProperties() {
        return f2297xk;
    }

    public ChangeClipBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: c */
    private static void m14751c(C8368ah c8368ah) {
        View view = c8368ah.view;
        if (view.getVisibility() != 8) {
            Rect au = C0477s.m929au(view);
            c8368ah.values.put("android:clipBounds:clip", au);
            if (au == null) {
                c8368ah.values.put("android:clipBounds:bounds", new Rect(0, 0, view.getWidth(), view.getHeight()));
            }
        }
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        m14751c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        m14751c(c8368ah);
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null || c8368ah2 == null || !c8368ah.values.containsKey("android:clipBounds:clip") || !c8368ah2.values.containsKey("android:clipBounds:clip")) {
            return null;
        }
        int i;
        Rect rect = (Rect) c8368ah.values.get("android:clipBounds:clip");
        Object obj = (Rect) c8368ah2.values.get("android:clipBounds:clip");
        if (obj == null) {
            i = 1;
        } else {
            i = 0;
        }
        if (rect == null && obj == null) {
            return null;
        }
        if (rect == null) {
            rect = (Rect) c8368ah.values.get("android:clipBounds:bounds");
        } else if (obj == null) {
            Rect obj2 = (Rect) c8368ah2.values.get("android:clipBounds:bounds");
        }
        if (rect.equals(obj2)) {
            return null;
        }
        C0477s.m937c(c8368ah2.view, rect);
        C37110z c37110z = new C37110z(new Rect());
        Animator ofObject = ObjectAnimator.ofObject(c8368ah2.view, C41495au.f16772Bm, c37110z, new Rect[]{rect, obj2});
        if (i == 0) {
            return ofObject;
        }
        final View view = c8368ah2.view;
        ofObject.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                C0477s.m937c(view, null);
            }
        });
        return ofObject;
    }
}
