package android.support.p069v7.widget;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* renamed from: android.support.v7.widget.c */
class C0711c extends Drawable {
    final ActionBarContainer acD;

    public C0711c(ActionBarContainer actionBarContainer) {
        this.acD = actionBarContainer;
    }

    public void draw(Canvas canvas) {
        if (!this.acD.acK) {
            if (this.acD.abb != null) {
                this.acD.abb.draw(canvas);
            }
            if (this.acD.acI != null && this.acD.acL) {
                this.acD.acI.draw(canvas);
            }
        } else if (this.acD.acJ != null) {
            this.acD.acJ.draw(canvas);
        }
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
