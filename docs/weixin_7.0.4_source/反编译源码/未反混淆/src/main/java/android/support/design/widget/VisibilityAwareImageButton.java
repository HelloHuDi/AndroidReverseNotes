package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class VisibilityAwareImageButton extends ImageButton {
    private int uf;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.uf = getVisibility();
    }

    public void setVisibility(int i) {
        j(i, true);
    }

    /* Access modifiers changed, original: final */
    public final void j(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.uf = i;
        }
    }

    /* Access modifiers changed, original: final */
    public final int getUserSetVisibility() {
        return this.uf;
    }
}
