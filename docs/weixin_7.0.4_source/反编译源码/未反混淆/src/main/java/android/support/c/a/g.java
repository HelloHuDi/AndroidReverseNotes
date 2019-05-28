package android.support.c.a;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.v4.content.a.c;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.google.android.gms.auth.api.proxy.AuthApiStatusCodes;
import org.xmlpull.v1.XmlPullParser;

public final class g implements Interpolator {
    private float[] uH;
    private float[] uI;

    public g(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    private g(Resources resources, Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray a = c.a(resources, theme, attributeSet, a.ut);
        if (c.a(xmlPullParser, "pathData")) {
            String b = c.b(a, xmlPullParser, "pathData", 4);
            Path K = android.support.v4.a.c.K(b);
            if (K == null) {
                throw new InflateException("The path is null, which is created from ".concat(String.valueOf(b)));
            }
            a(K);
        } else if (!c.a(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (c.a(xmlPullParser, "controlY1")) {
            float a2 = c.a(a, xmlPullParser, "controlX1", 0, 0.0f);
            float a3 = c.a(a, xmlPullParser, "controlY1", 1, 0.0f);
            boolean a4 = c.a(xmlPullParser, "controlX2");
            Path path;
            if (a4 != c.a(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (a4) {
                float a5 = c.a(a, xmlPullParser, "controlX2", 2, 0.0f);
                float a6 = c.a(a, xmlPullParser, "controlY2", 3, 0.0f);
                path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.cubicTo(a2, a3, a5, a6, 1.0f, 1.0f);
                a(path);
            } else {
                path = new Path();
                path.moveTo(0.0f, 0.0f);
                path.quadTo(a2, a3, 1.0f, 1.0f);
                a(path);
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
        a.recycle();
    }

    private void a(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(AuthApiStatusCodes.AUTH_API_INVALID_CREDENTIALS, ((int) (length / 0.002f)) + 1);
        if (min <= 0) {
            throw new IllegalArgumentException("The Path has a invalid length ".concat(String.valueOf(length)));
        }
        int i;
        this.uH = new float[min];
        this.uI = new float[min];
        float[] fArr = new float[2];
        for (i = 0; i < min; i++) {
            pathMeasure.getPosTan((((float) i) * length) / ((float) (min - 1)), fArr, null);
            this.uH[i] = fArr[0];
            this.uI[i] = fArr[1];
        }
        if (((double) Math.abs(this.uH[0])) > 1.0E-5d || ((double) Math.abs(this.uI[0])) > 1.0E-5d || ((double) Math.abs(this.uH[min - 1] - 1.0f)) > 1.0E-5d || ((double) Math.abs(this.uI[min - 1] - 1.0f)) > 1.0E-5d) {
            throw new IllegalArgumentException("The Path must start at (0,0) and end at (1,1) start: " + this.uH[0] + "," + this.uI[0] + " end:" + this.uH[min - 1] + "," + this.uI[min - 1]);
        }
        length = 0.0f;
        i = 0;
        int i2 = 0;
        while (i2 < min) {
            int i3 = i + 1;
            float f = this.uH[i];
            if (f < length) {
                throw new IllegalArgumentException("The Path cannot loop back on itself, x :".concat(String.valueOf(f)));
            }
            this.uH[i2] = f;
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
        int length = this.uH.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.uH[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float f2 = this.uH[length] - this.uH[i];
        if (f2 == 0.0f) {
            return this.uI[i];
        }
        float f3 = (f - this.uH[i]) / f2;
        f2 = this.uI[i];
        return (f3 * (this.uI[length] - f2)) + f2;
    }
}
