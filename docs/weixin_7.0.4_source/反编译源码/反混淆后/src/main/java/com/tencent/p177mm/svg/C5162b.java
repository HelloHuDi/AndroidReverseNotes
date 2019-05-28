package com.tencent.p177mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

/* renamed from: com.tencent.mm.svg.b */
final class C5162b {
    private static C5155a<Paint> ycF = new C5155a();
    private static C5155a<float[]> ycG = new C5155a();
    private static C5155a<Matrix> ycH = new C5155a();
    private static C5155a<Path> ycI = new C5155a();
    private static final float[] ycJ = new float[9];

    static {
        AppMethodBeat.m2504i(70062);
        AppMethodBeat.m2505o(70062);
    }

    /* renamed from: f */
    protected static synchronized void m7871f(Looper looper) {
        synchronized (C5162b.class) {
            AppMethodBeat.m2504i(70057);
            ycF.mo10616e(looper);
            ycG.mo10616e(looper);
            ycH.mo10616e(looper);
            ycI.mo10616e(looper);
            AppMethodBeat.m2505o(70057);
        }
    }

    /* renamed from: a */
    protected static synchronized Paint m7870a(Looper looper, Paint paint) {
        Paint paint2;
        synchronized (C5162b.class) {
            AppMethodBeat.m2504i(70058);
            paint2 = (Paint) ycF.dvC();
            if (paint2 == null) {
                paint2 = new Paint();
            } else {
                paint2.reset();
            }
            if (paint != null) {
                paint2.set(paint);
            }
            ycF.mo10614a(looper, paint2);
            AppMethodBeat.m2505o(70058);
        }
        return paint2;
    }

    /* renamed from: g */
    protected static synchronized float[] m7872g(Looper looper) {
        Object obj;
        synchronized (C5162b.class) {
            AppMethodBeat.m2504i(70059);
            obj = (float[]) ycG.dvC();
            if (obj == null) {
                obj = new float[9];
            } else {
                System.arraycopy(ycJ, 0, obj, 0, 9);
            }
            ycG.mo10614a(looper, obj);
            AppMethodBeat.m2505o(70059);
        }
        return obj;
    }

    /* renamed from: h */
    protected static synchronized Matrix m7873h(Looper looper) {
        Object obj;
        synchronized (C5162b.class) {
            AppMethodBeat.m2504i(70060);
            obj = (Matrix) ycH.dvC();
            if (obj == null) {
                obj = new Matrix();
            } else {
                obj.reset();
            }
            ycH.mo10614a(looper, obj);
            AppMethodBeat.m2505o(70060);
        }
        return obj;
    }

    /* renamed from: i */
    protected static synchronized Path m7874i(Looper looper) {
        Object obj;
        synchronized (C5162b.class) {
            AppMethodBeat.m2504i(70061);
            obj = (Path) ycI.dvC();
            if (obj == null) {
                obj = new Path();
            } else {
                obj.reset();
            }
            ycI.mo10614a(looper, obj);
            AppMethodBeat.m2505o(70061);
        }
        return obj;
    }
}
