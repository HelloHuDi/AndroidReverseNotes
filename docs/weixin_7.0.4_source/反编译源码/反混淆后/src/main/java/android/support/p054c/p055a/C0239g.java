package android.support.p054c.p055a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.p057v4.content.p062a.C0379c;
import android.support.p057v4.p058a.C0287c;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: android.support.c.a.g */
public final class C0239g implements Interpolator {
    /* renamed from: uH */
    private float[] f56uH;
    /* renamed from: uI */
    private float[] f57uI;

    public C0239g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private C0239g(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = C0379c.m638a(resources, theme, attributeSet, C0230a.f47ut);
        if (C0379c.m641a(xmlPullParser, "pathData")) {
            String b = C0379c.m643b(a, xmlPullParser, "pathData", 4);
            Path K = C0287c.m485K(b);
            if (K == null) {
                throw new InflateException("The path is null, which is created from ".concat(String.valueOf(b)));
            }
            m360a(K);
        } else if (!C0379c.m641a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (C0379c.m641a(xmlPullParser, "controlY1")) {
            float a2 = C0379c.m635a(a, xmlPullParser, "controlX1", 0, 0.0f);
            float a3 = C0379c.m635a(a, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a4 = C0379c.m641a(xmlPullParser, "controlX2");
            Path path;
            if (a4 != C0379c.m641a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (a4) {
                float a5 = C0379c.m635a(a, xmlPullParser, "controlX2", 2, 0.0f);
                float a6 = C0379c.m635a(a, xmlPullParser, "controlY2", 3, 0.0f);
                path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.cubicTo(a2, a3, a5, a6, 1.0f, 1.0f);
                m360a(path);
            } else {
                path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(a2, a3, 1.0f, 1.0f);
                m360a(path);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        a.recycle();
    }

    /* renamed from: a */
    private void m360a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(length)));
        }
        int i;
        this.f56uH = new float[min];
        this.f57uI = new float[min];
        float[] fArr = new float[2];
        for (i = 0; i < min; i++) {
            pathMeasure.getPosTan((((float) i) * length) / ((float) (min - 1)), fArr, null);
            this.f56uH[i] = fArr[0];
            this.f57uI[i] = fArr[1];
        }
        if (((double) Math.abs(this.f56uH[0])) > 1.0E-5d || ((double) Math.abs(this.f57uI[0])) > 1.0E-5d || ((double) Math.abs(this.f56uH[min - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.f57uI[min - 1] - 1.0f)) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.f56uH[0] + "," + this.f57uI[0] + " end:" + this.f56uH[min - 1] + "," + this.f57uI[min - 1]);
        }
        length = 0.0f;
        i = 0;
        int i2 = 0;
        while (i2 < min) {
            int i3 = i + 1;
            float f = this.f56uH[i];
            if (f < length) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f)));
            }
            this.f56uH[i2] = f;
            i2++;
            i = i3;
            length = f;
        }
        if (pathMeasure.nextContour()) {
            throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
        }
    }

    public final float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f56uH.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f56uH[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.f56uH[length] - this.f56uH[i];
        if (f2 == 0.0f) {
            return this.f57uI[i];
        }
        float f3 = (f - this.f56uH[i]) / f2;
        f2 = this.f57uI[i];
        return (f3 * (this.f57uI[length] - f2)) + f2;
    }
}
