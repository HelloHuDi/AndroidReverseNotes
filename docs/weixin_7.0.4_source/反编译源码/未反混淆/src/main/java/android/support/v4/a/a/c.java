package android.support.v4.a.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;

final class c extends b {
    protected c(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public final void getOutline(Outline outline) {
        dz();
        outline.setRoundRect(this.Hx, this.rf);
    }

    /* Access modifiers changed, original: final */
    public final void a(int i, int i2, int i3, Rect rect, Rect rect2) {
        Gravity.apply(i, i2, i3, rect, rect2, 0);
    }
}
