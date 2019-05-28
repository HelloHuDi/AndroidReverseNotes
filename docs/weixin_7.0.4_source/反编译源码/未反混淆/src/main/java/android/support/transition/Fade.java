package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.content.a.c;
import android.support.v4.view.s;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {

    static class a extends AnimatorListenerAdapter {
        private final View mView;
        private boolean yt = false;

        a(View view) {
            this.mView = view;
        }

        public final void onAnimationStart(Animator animator) {
            if (s.am(this.mView) && this.mView.getLayerType() == 0) {
                this.yt = true;
                this.mView.setLayerType(2, null);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            au.c(this.mView, 1.0f);
            if (this.yt) {
                this.mView.setLayerType(0, null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zB);
        setMode(c.a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.mMode));
        obtainStyledAttributes.recycle();
    }

    public final void a(ah ahVar) {
        super.a(ahVar);
        ahVar.values.put("android:fade:transitionAlpha", Float.valueOf(au.L(ahVar.view)));
    }

    private Animator b(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        au.c(view, f);
        Animator ofFloat = ObjectAnimator.ofFloat(view, au.Bl, new float[]{f2});
        ofFloat.addListener(new a(view));
        a((Transition.c) new ad() {
            public final void a(Transition transition) {
                au.c(view, 1.0f);
                au.N(view);
                transition.b((Transition.c) this);
            }
        });
        return ofFloat;
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar, ah ahVar2) {
        float f = 0.0f;
        float a = a(ahVar, 0.0f);
        if (a != 1.0f) {
            f = a;
        }
        return b(view, f, 1.0f);
    }

    public final Animator a(ViewGroup viewGroup, View view, ah ahVar) {
        au.M(view);
        return b(view, a(ahVar, 1.0f), 0.0f);
    }

    private static float a(ah ahVar, float f) {
        if (ahVar == null) {
            return f;
        }
        Float f2 = (Float) ahVar.values.get("android:fade:transitionAlpha");
        if (f2 != null) {
            return f2.floatValue();
        }
        return f;
    }
}
