package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.view.C0477s;
import android.support.transition.Transition.C31852c;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class Fade extends Visibility {

    /* renamed from: android.support.transition.Fade$a */
    static class C31850a extends AnimatorListenerAdapter {
        private final View mView;
        /* renamed from: yt */
        private boolean f14619yt = false;

        C31850a(View view) {
            this.mView = view;
        }

        public final void onAnimationStart(Animator animator) {
            if (C0477s.m921am(this.mView) && this.mView.getLayerType() == 0) {
                this.f14619yt = true;
                this.mView.setLayerType(2, null);
            }
        }

        public final void onAnimationEnd(Animator animator) {
            C41495au.m72482c(this.mView, 1.0f);
            if (this.f14619yt) {
                this.mView.setLayerType(0, null);
            }
        }
    }

    public Fade(int i) {
        setMode(i);
    }

    public Fade(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15732zB);
        setMode(C0379c.m637a(obtainStyledAttributes, (XmlResourceParser) attributeSet, "fadingMode", 0, this.mMode));
        obtainStyledAttributes.recycle();
    }

    /* renamed from: a */
    public final void mo410a(C8368ah c8368ah) {
        super.mo410a(c8368ah);
        c8368ah.values.put("android:fade:transitionAlpha", Float.valueOf(C41495au.m72476L(c8368ah.view)));
    }

    /* renamed from: b */
    private Animator m51616b(final View view, float f, float f2) {
        if (f == f2) {
            return null;
        }
        C41495au.m72482c(view, f);
        Animator ofFloat = ObjectAnimator.ofFloat(view, C41495au.f16771Bl, new float[]{f2});
        ofFloat.addListener(new C31850a(view));
        mo42271a((C31852c) new C36668ad() {
            /* renamed from: a */
            public final void mo452a(Transition transition) {
                C41495au.m72482c(view, 1.0f);
                C41495au.m72478N(view);
                transition.mo42277b((C31852c) this);
            }
        });
        return ofFloat;
    }

    /* renamed from: a */
    public final Animator mo18283a(ViewGroup viewGroup, View view, C8368ah c8368ah, C8368ah c8368ah2) {
        float f = 0.0f;
        float a = m51615a(c8368ah, 0.0f);
        if (a != 1.0f) {
            f = a;
        }
        return m51616b(view, f, 1.0f);
    }

    /* renamed from: a */
    public final Animator mo18282a(ViewGroup viewGroup, View view, C8368ah c8368ah) {
        C41495au.m72477M(view);
        return m51616b(view, m51615a(c8368ah, 1.0f), 0.0f);
    }

    /* renamed from: a */
    private static float m51615a(C8368ah c8368ah, float f) {
        if (c8368ah == null) {
            return f;
        }
        Float f2 = (Float) c8368ah.values.get("android:fade:transitionAlpha");
        if (f2 != null) {
            return f2.floatValue();
        }
        return f;
    }
}
