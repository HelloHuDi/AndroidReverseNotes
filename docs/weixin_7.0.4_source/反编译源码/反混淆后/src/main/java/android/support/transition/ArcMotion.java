package android.support.transition;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.support.p057v4.content.p062a.C0379c;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public class ArcMotion extends PathMotion {
    /* renamed from: xd */
    private static final float f2290xd = ((float) Math.tan(Math.toRadians(35.0d)));
    /* renamed from: xe */
    private float f2291xe = 0.0f;
    /* renamed from: xf */
    private float f2292xf = 0.0f;
    /* renamed from: xg */
    private float f2293xg = 70.0f;
    /* renamed from: xh */
    private float f2294xh = 0.0f;
    /* renamed from: xi */
    private float f2295xi = 0.0f;
    /* renamed from: xj */
    private float f2296xj = f2290xd;

    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C37103ac.f15736zF);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        float a = C0379c.m635a(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f);
        this.f2292xf = a;
        this.f2295xi = m14750r(a);
        a = C0379c.m635a(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f);
        this.f2291xe = a;
        this.f2294xh = m14750r(a);
        a = C0379c.m635a(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f);
        this.f2293xg = a;
        this.f2296xj = m14750r(a);
        obtainStyledAttributes.recycle();
    }

    /* renamed from: r */
    private static float m14750r(float f) {
        if (f >= 0.0f && f <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public final Path getPath(float f, float f2, float f3, float f4) {
        float f5;
        Path path = new Path();
        path.moveTo(f, f2);
        float f6 = f3 - f;
        float f7 = f4 - f2;
        float f8 = (f7 * f7) + (f6 * f6);
        float f9 = (f + f3) / 2.0f;
        float f10 = (f2 + f4) / 2.0f;
        float f11 = f8 * 0.25f;
        Object obj = f2 > f4 ? 1 : null;
        if (Math.abs(f6) < Math.abs(f7)) {
            f6 = Math.abs(f8 / (2.0f * f7));
            if (obj != null) {
                f5 = f4 + f6;
                f6 = f3;
            } else {
                f5 = f2 + f6;
                f6 = f;
            }
            f7 = (this.f2295xi * f11) * this.f2295xi;
        } else {
            f6 = f8 / (f6 * 2.0f);
            if (obj != null) {
                f6 += f;
                f5 = f2;
            } else {
                f6 = f3 - f6;
                f5 = f4;
            }
            f7 = (this.f2294xh * f11) * this.f2294xh;
        }
        f8 = f9 - f6;
        float f12 = f10 - f5;
        f12 = (f12 * f12) + (f8 * f8);
        f8 = (this.f2296xj * f11) * this.f2296xj;
        if (f12 >= f7) {
            if (f12 > f8) {
                f7 = f8;
            } else {
                f7 = 0.0f;
            }
        }
        if (f7 != 0.0f) {
            f7 = (float) Math.sqrt((double) (f7 / f12));
            f8 = ((f5 - f10) * f7) + f10;
            f7 = ((f6 - f9) * f7) + f9;
        } else {
            f8 = f5;
            f7 = f6;
        }
        path.cubicTo((f + f7) / 2.0f, (f2 + f8) / 2.0f, (f7 + f3) / 2.0f, (f8 + f4) / 2.0f, f3, f4);
        return path;
    }
}
