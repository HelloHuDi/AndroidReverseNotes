package android.support.p057v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* renamed from: android.support.v4.widget.u */
public final class C31872u {
    /* renamed from: SZ */
    private static final ThreadLocal<Matrix> f14654SZ = new ThreadLocal();
    /* renamed from: Ta */
    private static final ThreadLocal<RectF> f14655Ta = new ThreadLocal();

    /* renamed from: a */
    public static void m51651a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix2 = (Matrix) f14654SZ.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            f14654SZ.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.reset();
            matrix = matrix2;
        }
        C31872u.m51652a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) f14655Ta.get();
        if (rectF == null) {
            rectF = new RectF();
            f14655Ta.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* renamed from: a */
    private static void m51652a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            C31872u.m51652a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
