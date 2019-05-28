package android.support.p057v4.p058a;

import android.graphics.Color;

/* renamed from: android.support.v4.a.b */
public final class C0284b {
    /* renamed from: GZ */
    private static final ThreadLocal<double[]> f202GZ = new ThreadLocal();

    /* renamed from: s */
    public static int m477s(int i, int i2) {
        int alpha = Color.alpha(i2);
        int alpha2 = Color.alpha(i);
        int i3 = 255 - (((255 - alpha) * (255 - alpha2)) / 255);
        return Color.argb(i3, C0284b.m473b(Color.red(i), alpha2, Color.red(i2), alpha, i3), C0284b.m473b(Color.green(i), alpha2, Color.green(i2), alpha, i3), C0284b.m473b(Color.blue(i), alpha2, Color.blue(i2), alpha, i3));
    }

    /* renamed from: b */
    private static int m473b(int i, int i2, int i3, int i4, int i5) {
        if (i5 == 0) {
            return 0;
        }
        return (((i * 255) * i2) + ((i3 * i4) * (255 - i2))) / (i5 * 255);
    }

    /* renamed from: t */
    private static double m478t(int i, int i2) {
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        }
        if (Color.alpha(i) < 255) {
            i = C0284b.m477s(i, i2);
        }
        double au = C0284b.m472au(i) + 0.05d;
        double au2 = C0284b.m472au(i2) + 0.05d;
        return Math.max(au, au2) / Math.min(au, au2);
    }

    /* renamed from: d */
    public static int m474d(int i, int i2, float f) {
        int i3 = 0;
        int i4 = 255;
        if (Color.alpha(i2) != 255) {
            throw new IllegalArgumentException("background can not be translucent: #" + Integer.toHexString(i2));
        } else if (C0284b.m478t(C0284b.m479u(i, 255), i2) < ((double) f)) {
            return -1;
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i3;
                if (i6 > 10 || i4 - i5 <= 1) {
                    return i4;
                }
                i3 = (i5 + i4) / 2;
                if (C0284b.m478t(C0284b.m479u(i, i3), i2) < ((double) f)) {
                    i5 = i3;
                } else {
                    i4 = i3;
                }
                i3 = i6 + 1;
            }
        }
    }

    /* renamed from: a */
    public static void m471a(int i, int i2, int i3, float[] fArr) {
        float f = ((float) i) / 255.0f;
        float f2 = ((float) i2) / 255.0f;
        float f3 = ((float) i3) / 255.0f;
        float max = Math.max(f, Math.max(f2, f3));
        float min = Math.min(f, Math.min(f2, f3));
        float f4 = max - min;
        float f5 = (max + min) / 2.0f;
        if (max == min) {
            f2 = 0.0f;
            f = 0.0f;
        } else {
            if (max == f) {
                f = ((f2 - f3) / f4) % 6.0f;
            } else if (max == f2) {
                f = ((f3 - f) / f4) + 2.0f;
            } else {
                f = ((f - f2) / f4) + 4.0f;
            }
            f2 = f4 / (1.0f - Math.abs((2.0f * f5) - 1.0f));
        }
        f = (f * 60.0f) % 360.0f;
        if (f < 0.0f) {
            f += 360.0f;
        }
        fArr[0] = C0284b.m476s(f, 360.0f);
        fArr[1] = C0284b.m476s(f2, 1.0f);
        fArr[2] = C0284b.m476s(f5, 1.0f);
    }

    /* renamed from: d */
    public static void m475d(int i, float[] fArr) {
        C0284b.m471a(Color.red(i), Color.green(i), Color.blue(i), fArr);
    }

    /* renamed from: u */
    public static int m479u(int i, int i2) {
        if (i2 >= 0 && i2 <= 255) {
            return (16777215 & i) | (i2 << 24);
        }
        throw new IllegalArgumentException("alpha must be between 0 and 255.");
    }

    /* renamed from: s */
    private static float m476s(float f, float f2) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f <= f2 ? f : f2;
    }

    /* renamed from: au */
    private static double m472au(int i) {
        double[] dArr = (double[]) f202GZ.get();
        if (dArr == null) {
            dArr = new double[3];
            f202GZ.set(dArr);
        }
        int red = Color.red(i);
        int green = Color.green(i);
        int blue = Color.blue(i);
        if (dArr.length != 3) {
            throw new IllegalArgumentException("outXyz must have a length of 3.");
        }
        double d = ((double) red) / 255.0d;
        double pow = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) green) / 255.0d;
        double pow2 = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        d = ((double) blue) / 255.0d;
        d = d < 0.04045d ? d / 12.92d : Math.pow((d + 0.055d) / 1.055d, 2.4d);
        dArr[0] = 100.0d * (((0.4124d * pow) + (0.3576d * pow2)) + (0.1805d * d));
        dArr[1] = 100.0d * (((0.2126d * pow) + (0.7152d * pow2)) + (0.0722d * d));
        dArr[2] = ((d * 0.9505d) + ((pow2 * 0.1192d) + (pow * 0.0193d))) * 100.0d;
        return dArr[1] / 100.0d;
    }
}
