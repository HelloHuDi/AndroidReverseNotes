package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: android.support.transition.s */
final class C44643s implements C41499t {
    C44643s() {
    }

    /* renamed from: a */
    public final <T> ObjectAnimator mo66233a(T t, Property<T, PointF> property, Path path) {
        return ObjectAnimator.ofObject(t, property, null, path);
    }
}
