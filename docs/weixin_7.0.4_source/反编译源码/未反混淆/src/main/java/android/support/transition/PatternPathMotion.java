package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.a.c;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    private final Matrix ya = new Matrix();
    private Path zg;
    private final Path zi = new Path();

    public PatternPathMotion() {
        this.zi.lineTo(1.0f, 0.0f);
        this.zg = this.zi;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ac.zG);
        try {
            String b = c.b(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (b == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            Path K = android.support.v4.a.c.K(b);
            PathMeasure pathMeasure = new PathMeasure(K, false);
            float[] fArr = new float[2];
            pathMeasure.getPosTan(pathMeasure.getLength(), fArr, null);
            float f = fArr[0];
            float f2 = fArr[1];
            pathMeasure.getPosTan(0.0f, fArr, null);
            float f3 = fArr[0];
            float f4 = fArr[1];
            if (f3 == f && f4 == f2) {
                throw new IllegalArgumentException("pattern must not end at the starting point");
            }
            this.ya.setTranslate(-f3, -f4);
            f3 = f - f3;
            f = f2 - f4;
            f4 = 1.0f / r(f3, f);
            this.ya.postScale(f4, f4);
            this.ya.postRotate((float) Math.toDegrees(-Math.atan2((double) f, (double) f3)));
            K.transform(this.ya, this.zi);
            this.zg = K;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float r = r(f5, f6);
        double atan2 = Math.atan2((double) f6, (double) f5);
        this.ya.setScale(r, r);
        this.ya.postRotate((float) Math.toDegrees(atan2));
        this.ya.postTranslate(f, f2);
        Path path = new Path();
        this.zi.transform(this.ya, path);
        return path;
    }

    private static float r(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
