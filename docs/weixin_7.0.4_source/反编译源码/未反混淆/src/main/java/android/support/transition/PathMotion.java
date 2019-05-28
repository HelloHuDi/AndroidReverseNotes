package android.support.transition;

import android.content.Context;
import android.graphics.Path;
import android.util.AttributeSet;

public abstract class PathMotion {
    public abstract Path getPath(float f, float f2, float f3, float f4);

    public PathMotion(Context context, AttributeSet attributeSet) {
    }
}
