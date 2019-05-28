package android.support.design.widget;

import android.graphics.Outline;

/* renamed from: android.support.design.widget.e */
final class C8345e extends C31842d {
    C8345e() {
    }

    public final void getOutline(Outline outline) {
        copyBounds(this.mRect);
        outline.setOval(this.mRect);
    }
}
