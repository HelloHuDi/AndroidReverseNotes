package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    /* renamed from: xV */
    private static final String[] f188xV = new String[]{"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        m448c(c8368ah);
    }

    /* renamed from: b */
    public final void mo411b(C8368ah c8368ah) {
        m448c(c8368ah);
    }

    public final String[] getTransitionProperties() {
        return f188xV;
    }

    /* renamed from: c */
    private static void m448c(C8368ah c8368ah) {
        c8368ah.values.put("android:changeScroll:x", Integer.valueOf(c8368ah.view.getScrollX()));
        c8368ah.values.put("android:changeScroll:y", Integer.valueOf(c8368ah.view.getScrollY()));
    }

    /* renamed from: a */
    public final Animator mo409a(ViewGroup viewGroup, C8368ah c8368ah, C8368ah c8368ah2) {
        if (c8368ah == null || c8368ah2 == null) {
            return null;
        }
        Animator ofInt;
        Animator ofInt2;
        View view = c8368ah2.view;
        int intValue = ((Integer) c8368ah.values.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) c8368ah2.values.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) c8368ah.values.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) c8368ah2.values.get("android:changeScroll:y")).intValue();
        if (intValue != intValue2) {
            view.setScrollX(intValue);
            ofInt = ObjectAnimator.ofInt(view, "scrollX", new int[]{intValue, intValue2});
        } else {
            ofInt = null;
        }
        if (intValue3 != intValue4) {
            view.setScrollY(intValue3);
            ofInt2 = ObjectAnimator.ofInt(view, "scrollY", new int[]{intValue3, intValue4});
        } else {
            ofInt2 = null;
        }
        return C25320ag.m39949a(ofInt, ofInt2);
    }
}
