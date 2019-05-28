package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.w */
final class C25330w implements C31854y {
    C25330w() {
    }

    /* renamed from: a */
    public final PropertyValuesHolder mo31689a(Property<?, PointF> property, Path path) {
        return PropertyValuesHolder.ofFloat(new C41500u(property, path), new float[]{0.0f, 1.0f});
    }
}
