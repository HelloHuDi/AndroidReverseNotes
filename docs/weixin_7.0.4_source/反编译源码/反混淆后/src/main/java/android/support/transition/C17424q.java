package android.support.transition;

import android.animation.ObjectAnimator;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: android.support.transition.q */
final class C17424q {
    /* renamed from: za */
    private static final C41499t f3875za;

    static {
        if (VERSION.SDK_INT >= 21) {
            f3875za = new C44643s();
        } else {
            f3875za = new C44642r();
        }
    }

    /* renamed from: a */
    static <T> ObjectAnimator m27066a(T t, Property<T, PointF> property, Path path) {
        return f3875za.mo66233a(t, property, path);
    }
}
