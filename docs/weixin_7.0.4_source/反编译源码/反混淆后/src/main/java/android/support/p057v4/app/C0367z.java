package android.support.p057v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

/* renamed from: android.support.v4.app.z */
final class C0367z implements OnAttachStateChangeListener, OnPreDrawListener {
    /* renamed from: FT */
    private ViewTreeObserver f416FT;
    private final Runnable mRunnable;
    private final View mView;

    private C0367z(View view, Runnable runnable) {
        this.mView = view;
        this.f416FT = view.getViewTreeObserver();
        this.mRunnable = runnable;
    }

    /* renamed from: a */
    public static C0367z m618a(View view, Runnable runnable) {
        C0367z c0367z = new C0367z(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(c0367z);
        view.addOnAttachStateChangeListener(c0367z);
        return c0367z;
    }

    public final boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    private void removeListener() {
        if (this.f416FT.isAlive()) {
            this.f416FT.removeOnPreDrawListener(this);
        } else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mView.removeOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        this.f416FT = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        removeListener();
    }
}
