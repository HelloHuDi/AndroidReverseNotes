package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* renamed from: android.support.transition.al */
final class C44948al implements C37105am {
    /* renamed from: AR */
    private final ViewGroupOverlay f17664AR;

    C44948al(ViewGroup viewGroup) {
        this.f17664AR = viewGroup.getOverlay();
    }

    public final void add(Drawable drawable) {
        this.f17664AR.add(drawable);
    }

    public final void remove(Drawable drawable) {
        this.f17664AR.remove(drawable);
    }

    public final void add(View view) {
        this.f17664AR.add(view);
    }

    public final void remove(View view) {
        this.f17664AR.remove(view);
    }
}
