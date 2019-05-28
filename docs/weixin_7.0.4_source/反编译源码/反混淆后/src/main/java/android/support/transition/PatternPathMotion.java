package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.p058a.C0287c;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class PatternPathMotion extends PathMotion {
    /* renamed from: ya */
    private final Matrix f14620ya = new Matrix();
    /* renamed from: zg */
    private Path f14621zg;
    /* renamed from: zi */
    private final Path f14622zi = new Path();

    public PatternPathMotion() {
        this.f14622zi.lineTo(1.0f, 0.0f);
        this.f14621zg = this.f14622zi;
    }

    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15737zG);
        try {
            String b = C0379c.m643b(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (b == null) {
                throw new RuntimeException("pathData must be supplied for patternPathMotion");
            }
            Path K = C0287c.m485K(b);
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
            this.f14620ya.setTranslate(-f3, -f4);
            f3 = f - f3;
            f = f2 - f4;
            f4 = 1.0f / m51620r(f3, f);
            this.f14620ya.postScale(f4, f4);
            this.f14620ya.postRotate((float) Math.toDegrees(-Math.atan2((double) f, (double) f3)));
            K.transform(this.f14620ya, this.f14622zi);
            this.f14621zg = K;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public final Path getPath(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float r = m51620r(f5, f6);
        double atan2 = Math.atan2((double) f6, (double) f5);
        this.f14620ya.setScale(r, r);
        this.f14620ya.postRotate((float) Math.toDegrees(atan2));
        this.f14620ya.postTranslate(f, f2);
        Path path = new Path();
        this.f14622zi.transform(this.f14620ya, path);
        return path;
    }

    /* renamed from: r */
    private static float m51620r(float f, float f2) {
        return (float) Math.sqrt((double) ((f * f) + (f2 * f2)));
    }
}
