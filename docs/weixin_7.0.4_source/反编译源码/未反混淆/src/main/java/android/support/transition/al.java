package android.support.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

final class al implements am {
    private final ViewGroupOverlay AR;

    al(ViewGroup viewGroup) {
        this.AR = viewGroup.getOverlay();
    }

    public final void add(Drawable drawable) {
        this.AR.add(drawable);
    }

    public final void remove(Drawable drawable) {
        this.AR.remove(drawable);
    }

    public final void add(View view) {
        this.AR.add(view);
    }

    public final void remove(View view) {
        this.AR.remove(view);
    }
}
