package android.support.design.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageButton;

class VisibilityAwareImageButton extends ImageButton {
    /* renamed from: uf */
    private int f160uf;

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VisibilityAwareImageButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f160uf = getVisibility();
    }

    public void setVisibility(int i) {
        mo415j(i, true);
    }

    /* Access modifiers changed, original: final */
    /* renamed from: j */
    public final void mo415j(int i, boolean z) {
        super.setVisibility(i);
        if (z) {
            this.f160uf = i;
        }
    }

    /* Access modifiers changed, original: final */
    public final int getUserSetVisibility() {
        return this.f160uf;
    }
}
