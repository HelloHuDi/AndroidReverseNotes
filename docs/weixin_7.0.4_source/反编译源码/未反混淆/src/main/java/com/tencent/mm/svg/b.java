package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b {
    private static a<Paint> ycF = new a();
    private static a<float[]> ycG = new a();
    private static a<Matrix> ycH = new a();
    private static a<Path> ycI = new a();
    private static final float[] ycJ = new float[9];

    static {
        AppMethodBeat.i(70062);
        AppMethodBeat.o(70062);
    }

    protected static synchronized void f(Looper looper) {
        synchronized (b.class) {
            AppMethodBeat.i(70057);
            ycF.e(looper);
            ycG.e(looper);
            ycH.e(looper);
            ycI.e(looper);
            AppMethodBeat.o(70057);
        }
    }

    protected static synchronized Paint a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (b.class) {
            AppMethodBeat.i(70058);
            paint2 = (Paint) ycF.dvC();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            ycF.a(looper, paint2);
            AppMethodBeat.o(70058);
        }
        return paint2;
    }

    protected static synchronized float[] g(Looper looper) {
        Object obj;
        synchronized (b.class) {
            AppMethodBeat.i(70059);
            obj = (float[]) ycG.dvC();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(ycJ, 0, obj, 0, 9);
            }
            ycG.a(looper, obj);
            AppMethodBeat.o(70059);
        }
        return obj;
    }

    protected static synchronized Matrix h(Looper looper) {
        Object obj;
        synchronized (b.class) {
            AppMethodBeat.i(70060);
            obj = (Matrix) ycH.dvC();
            if (obj == null) {
                obj = new Matrix();
            } else {
                obj.reset();
            }
            ycH.a(looper, obj);
            AppMethodBeat.o(70060);
        }
        return obj;
    }

    protected static synchronized Path i(Looper looper) {
        Object obj;
        synchronized (b.class) {
            AppMethodBeat.i(70061);
            obj = (Path) ycI.dvC();
            if (obj == null) {
                obj = new Path();
            } else {
                obj.reset();
            }
            ycI.a(looper, obj);
            AppMethodBeat.o(70061);
        }
        return obj;
    }
}
