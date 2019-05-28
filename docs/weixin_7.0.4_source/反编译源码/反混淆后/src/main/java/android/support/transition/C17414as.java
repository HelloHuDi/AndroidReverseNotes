package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* renamed from: android.support.transition.as */
final class C17414as implements C41494at {
    /* renamed from: Bh */
    private final ViewOverlay f3856Bh;

    C17414as(View view) {
        this.f3856Bh = view.getOverlay();
    }

    public final void add(Drawable drawable) {
        this.f3856Bh.add(drawable);
    }

    public final void remove(Drawable drawable) {
        this.f3856Bh.remove(drawable);
    }
}
