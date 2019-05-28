package com.tencent.luggage.p146d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.p146d.C45123i.C32184b;
import com.tencent.luggage.p146d.C45123i.C32185c;
import com.tencent.luggage.p146d.C45123i.C45122a;
import com.tencent.luggage.p146d.C45123i.C6274e;
import com.tencent.luggage.p146d.C45123i.C8863d;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.luggage.d.e */
public abstract class C8860e {
    protected C45123i bPd = new C45123i();
    public C41709g bPe;
    protected C8862a bPf;
    public Context mContext;

    /* renamed from: com.tencent.luggage.d.e$a */
    public static class C8862a {
        protected C8862a bPh;

        protected C8862a(C8862a c8862a) {
            this.bPh = c8862a;
        }
    }

    public abstract void destroy();

    /* renamed from: g */
    public abstract void mo20038g(String str, Bundle bundle);

    public abstract View getContentView();

    /* renamed from: wR */
    public abstract View mo20042wR();

    public C8860e(C41709g c41709g) {
        this.mContext = c41709g.getContext();
        this.bPe = c41709g;
    }

    /* renamed from: a */
    public void mo20035a(C8862a c8862a) {
        this.bPf = c8862a;
    }

    /* renamed from: wT */
    public final void mo20044wT() {
        mo20045wU();
        this.bPd.mo72932D(C8863d.class);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wU */
    public void mo20045wU() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wV */
    public final void mo20046wV() {
        mo20047wW();
        this.bPd.mo72932D(C32184b.class);
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wW */
    public void mo20047wW() {
    }

    /* Access modifiers changed, original: protected */
    /* renamed from: wY */
    public boolean mo20049wY() {
        return false;
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wZ */
    public final void mo20050wZ() {
        onDestroy();
        this.bPd.mo72932D(C32185c.class);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: a */
    public final void mo20034a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.m2504i(90772);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.m2505o(90772);
            }
        });
        animator.start();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wS */
    public final void mo20043wS() {
        this.bPd.mo72932D(C6274e.class);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: wX */
    public final boolean mo20048wX() {
        return this.bPd.mo72932D(C45122a.class) || mo20049wY();
    }

    /* Access modifiers changed, original: final */
    /* renamed from: g */
    public final void mo20037g(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[]{-(((float) getContentView().getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        mo20034a(ofFloat, runnable);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: h */
    public final void mo20040h(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[]{0.0f, (float) getContentView().getWidth()});
        ofFloat.setDuration(250);
        mo20034a(ofFloat, runnable);
    }
}
