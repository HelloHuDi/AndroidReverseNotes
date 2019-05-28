package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

final class q {
    private static final t za;

    static {
        if (VERSION.SDK_INT >= 21) {
            za = new s();
        } else {
            za = new r();
        }
    }

    static <T> ObjectAnimator a(T t, Property<T, PointF> property, Path path) {
        return za.a(t, property, path);
    }
}
