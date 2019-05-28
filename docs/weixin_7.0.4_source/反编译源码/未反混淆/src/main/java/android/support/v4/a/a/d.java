package android.support.v4.a.a;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build.VERSION;

public final class d {

    static class a extends b {
        a(Resources resources, Bitmap bitmap) {
            super(resources, bitmap);
        }

        /* Access modifiers changed, original: final */
        public final void a(int i, int i2, int i3, Rect rect, Rect rect2) {
            android.support.v4.view.d.apply(i, i2, i3, rect, rect2, 0);
        }
    }

    public static b a(Resources resources, Bitmap bitmap) {
        if (VERSION.SDK_INT >= 21) {
            return new c(resources, bitmap);
        }
        return new a(resources, bitmap);
    }
}
