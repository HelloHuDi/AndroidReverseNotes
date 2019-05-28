package android.support.p057v4.view.p068b;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

/* renamed from: android.support.v4.view.b.f */
public final class C41516f {
    /* renamed from: c */
    public static Interpolator m72499c(Path path) {
        if (VERSION.SDK_INT >= 21) {
            return new PathInterpolator(path);
        }
        return new C25364e(path);
    }
}
