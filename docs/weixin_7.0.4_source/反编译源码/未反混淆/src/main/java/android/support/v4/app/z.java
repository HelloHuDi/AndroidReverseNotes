package android.support.v4.app;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;

final class z implements OnAttachStateChangeListener, OnPreDrawListener {
    private ViewTreeObserver FT;
    private final Runnable mRunnable;
    private final View mView;

    private z(View view, Runnable runnable) {
        this.mView = view;
        this.FT = view.getViewTreeObserver();
        this.mRunnable = runnable;
    }

    public static z a(View view, Runnable runnable) {
        z zVar = new z(view, runnable);
        view.getViewTreeObserver().addOnPreDrawListener(zVar);
        view.addOnAttachStateChangeListener(zVar);
        return zVar;
    }

    public final boolean onPreDraw() {
        removeListener();
        this.mRunnable.run();
        return true;
    }

    private void removeListener() {
        if (this.FT.isAlive()) {
            this.FT.removeOnPreDrawListener(this);
        } else {
            this.mView.getViewTreeObserver().removeOnPreDrawListener(this);
        }
        this.mView.removeOnAttachStateChangeListener(this);
    }

    public final void onViewAttachedToWindow(View view) {
        this.FT = view.getViewTreeObserver();
    }

    public final void onViewDetachedFromWindow(View view) {
        removeListener();
    }
}
