package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.r */
final class C44642r implements C41499t {
    C44642r() {
    }

    /* renamed from: a */
    public final <T> ObjectAnimator mo66233a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofFloat(t, new C41500u(property, path), new float[]{0.0f, 1.0f});
    }
}
