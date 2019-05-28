package com.tencent.p177mm.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

/* renamed from: com.tencent.mm.svg.c */
public abstract class C5163c {
    /* renamed from: a */
    public abstract int mo10620a(int i, Object... objArr);

    /* renamed from: j */
    protected static void m7882j(Looper looper) {
        if (looper != null) {
            C5162b.m7871f(looper);
        }
    }

    /* renamed from: a */
    public static int m7875a(C5163c c5163c) {
        return c5163c.mo10620a(0, new Object[0]);
    }

    /* renamed from: b */
    public static int m7879b(C5163c c5163c) {
        return c5163c.mo10620a(1, new Object[0]);
    }

    /* renamed from: a */
    public static void m7877a(C5163c c5163c, Canvas canvas, Looper looper) {
        c5163c.mo10620a(2, canvas, looper);
    }

    /* renamed from: k */
    protected static Paint m7883k(Looper looper) {
        return C5162b.m7870a(looper, null);
    }

    /* renamed from: a */
    protected static Paint m7876a(Paint paint, Looper looper) {
        return C5162b.m7870a(looper, paint);
    }

    /* renamed from: g */
    protected static float[] m7880g(Looper looper) {
        return C5162b.m7872g(looper);
    }

    /* renamed from: h */
    protected static Matrix m7881h(Looper looper) {
        return C5162b.m7873h(looper);
    }

    /* renamed from: l */
    protected static Path m7884l(Looper looper) {
        return C5162b.m7874i(looper);
    }

    /* renamed from: a */
    protected static float[] m7878a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6) {
        if (fArr != null) {
            fArr[0] = f;
            fArr[1] = f2;
            fArr[2] = f3;
            fArr[3] = f4;
            fArr[4] = f5;
            fArr[5] = f6;
            fArr[6] = 0.0f;
            fArr[7] = 0.0f;
            fArr[8] = 1.0f;
        }
        return fArr;
    }
}
