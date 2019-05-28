package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

final class as implements at {
    private final ViewOverlay Bh;

    as(View view) {
        this.Bh = view.getOverlay();
    }

    public final void add(Drawable drawable) {
        this.Bh.add(drawable);
    }

    public final void remove(Drawable drawable) {
        this.Bh.remove(drawable);
    }
}
