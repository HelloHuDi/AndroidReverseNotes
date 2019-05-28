package android.support.v4.view.b;

import android.graphics.Path;
import android.os.Build.VERSION;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;

public final class f {
    public static Interpolator c(Path path) {
        if (VERSION.SDK_INT >= 21) {
            return new PathInterpolator(path);
        }
        return new e(path);
    }
}
