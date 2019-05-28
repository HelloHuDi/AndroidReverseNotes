package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

final class v {
    private static final y zj;

    static {
        if (VERSION.SDK_INT >= 21) {
            zj = new x();
        } else {
            zj = new w();
        }
    }

    static PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return zj.a(property, path);
    }
}
