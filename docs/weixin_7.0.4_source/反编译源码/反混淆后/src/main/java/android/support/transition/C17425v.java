package android.support.transition;

import android.animation.PropertyValuesHolder;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build.VERSION;
import android.util.Property;

/* renamed from: android.support.transition.v */
final class C17425v {
    /* renamed from: zj */
    private static final C31854y f3876zj;

    static {
        if (VERSION.SDK_INT >= 21) {
            f3876zj = new C17426x();
        } else {
            f3876zj = new C25330w();
        }
    }

    /* renamed from: a */
    static PropertyValuesHolder m27067a(Property<?, PointF> property, Path path) {
        return f3876zj.mo31689a(property, path);
    }
}
