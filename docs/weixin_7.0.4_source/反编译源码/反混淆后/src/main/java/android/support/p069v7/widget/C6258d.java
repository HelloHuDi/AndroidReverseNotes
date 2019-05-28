package android.support.p069v7.widget;

import android.graphics.Outline;

/* renamed from: android.support.v7.widget.d */
final class C6258d extends C0711c {
    public C6258d(ActionBarContainer actionBarContainer) {
        super(actionBarContainer);
    }

    public final void getOutline(Outline outline) {
        if (this.acD.acK) {
            if (this.acD.acJ != null) {
                this.acD.acJ.getOutline(outline);
            }
        } else if (this.acD.abb != null) {
            this.acD.abb.getOutline(outline);
        }
    }
}
