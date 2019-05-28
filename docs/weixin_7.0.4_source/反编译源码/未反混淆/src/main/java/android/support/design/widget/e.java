package android.support.design.widget;

import android.graphics.Outline;

final class e extends d {
    e() {
    }

    public final void getOutline(Outline outline) {
        copyBounds(this.mRect);
        outline.setOval(this.mRect);
    }
}
