package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeScroll extends Transition {
    private static final String[] xV = new String[]{"android:changeScroll:x", "android:changeScroll:y"};

    public ChangeScroll(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void a(ah ahVar) {
        c(ahVar);
    }

    public final void b(ah ahVar) {
        c(ahVar);
    }

    public final String[] getTransitionProperties() {
        return xV;
    }

    private static void c(ah ahVar) {
        ahVar.values.put("android:changeScroll:x", Integer.valueOf(ahVar.view.getScrollX()));
        ahVar.values.put("android:changeScroll:y", Integer.valueOf(ahVar.view.getScrollY()));
    }

    public final Animator a(ViewGroup viewGroup, ah ahVar, ah ahVar2) {
        if (ahVar == null || ahVar2 == null) {
            return null;
        }
        Animator ofInt;
        Animator ofInt2;
        View view = ahVar2.view;
        int intValue = ((Integer) ahVar.values.get("android:changeScroll:x")).intValue();
        int intValue2 = ((Integer) ahVar2.values.get("android:changeScroll:x")).intValue();
        int intValue3 = ((Integer) ahVar.values.get("android:changeScroll:y")).intValue();
        int intValue4 = ((Integer) ahVar2.values.get("android:changeScroll:y")).intValue();
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
        return ag.a(ofInt, ofInt2);
    }
}
