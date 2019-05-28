package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

final class w implements y {
    w() {
    }

    public final PropertyValuesHolder a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new u(property, path), new float[]{0.0f, 1.0f});
    }
}
