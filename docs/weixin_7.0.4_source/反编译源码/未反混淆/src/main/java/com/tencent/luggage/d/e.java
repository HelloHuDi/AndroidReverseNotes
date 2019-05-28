package com.tencent.luggage.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.luggage.d.i.b;
import com.tencent.luggage.d.i.c;
import com.tencent.luggage.d.i.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class e {
    protected i bPd = new i();
    public g bPe;
    protected a bPf;
    public Context mContext;

    public static class a {
        protected a bPh;

        protected a(a aVar) {
            this.bPh = aVar;
        }
    }

    public abstract void destroy();

    public abstract void g(String str, Bundle bundle);

    public abstract View getContentView();

    public abstract View wR();

    public e(g gVar) {
        this.mContext = gVar.getContext();
        this.bPe = gVar;
    }

    public void a(a aVar) {
        this.bPf = aVar;
    }

    public final void wT() {
        wU();
        this.bPd.D(d.class);
    }

    /* Access modifiers changed, original: protected */
    public void wU() {
    }

    /* Access modifiers changed, original: final */
    public final void wV() {
        wW();
        this.bPd.D(b.class);
    }

    /* Access modifiers changed, original: protected */
    public void wW() {
    }

    /* Access modifiers changed, original: protected */
    public boolean wY() {
        return false;
    }

    /* Access modifiers changed, original: final */
    public final void wZ() {
        onDestroy();
        this.bPd.D(c.class);
    }

    /* Access modifiers changed, original: protected */
    public void onDestroy() {
    }

    /* Access modifiers changed, original: final */
    public final void a(Animator animator, final Runnable runnable) {
        animator.addListener(new AnimatorListenerAdapter() {
            public final void onAnimationEnd(Animator animator) {
                AppMethodBeat.i(90772);
                if (runnable != null) {
                    runnable.run();
                }
                AppMethodBeat.o(90772);
            }
        });
        animator.start();
    }

    /* Access modifiers changed, original: final */
    public final void wS() {
        this.bPd.D(com.tencent.luggage.d.i.e.class);
    }

    /* Access modifiers changed, original: final */
    public final boolean wX() {
        return this.bPd.D(com.tencent.luggage.d.i.a.class) || wY();
    }

    /* Access modifiers changed, original: final */
    public final void g(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[]{-(((float) getContentView().getWidth()) * 0.25f), 0.0f});
        ofFloat.setDuration(250);
        a(ofFloat, runnable);
    }

    /* Access modifiers changed, original: final */
    public final void h(Runnable runnable) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getContentView(), "translationX", new float[]{0.0f, (float) getContentView().getWidth()});
        ofFloat.setDuration(250);
        a(ofFloat, runnable);
    }
}
