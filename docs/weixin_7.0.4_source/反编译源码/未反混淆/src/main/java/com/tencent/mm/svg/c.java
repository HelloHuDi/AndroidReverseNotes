package com.tencent.mm.svg;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c {
    public abstract int a(int i, Object... objArr);

    protected static void j(Looper looper) {
        if (looper != null) {
            b.f(looper);
        }
    }

    public static int a(c cVar) {
        return cVar.a(0, new Object[0]);
    }

    public static int b(c cVar) {
        return cVar.a(1, new Object[0]);
    }

    public static void a(c cVar, Canvas canvas, Looper looper) {
        cVar.a(2, canvas, looper);
    }

    protected static Paint k(Looper looper) {
        return b.a(looper, null);
    }

    protected static Paint a(Paint paint, Looper looper) {
        return b.a(looper, paint);
    }

    protected static float[] g(Looper looper) {
        return b.g(looper);
    }

    protected static Matrix h(Looper looper) {
        return b.h(looper);
    }

    protected static Path l(Looper looper) {
        return b.i(looper);
    }

    protected static float[] a(float[] fArr, float f, float f2, float f3, float f4, float f5, float f6) {
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
