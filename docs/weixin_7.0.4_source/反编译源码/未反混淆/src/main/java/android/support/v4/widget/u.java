package android.support.v4.widget;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

public final class u {
    private static final ThreadLocal<Matrix> SZ = new ThreadLocal();
    private static final ThreadLocal<RectF> Ta = new ThreadLocal();

    public static void a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix;
        rect.set(0, 0, view.getWidth(), view.getHeight());
        Matrix matrix2 = (Matrix) SZ.get();
        if (matrix2 == null) {
            matrix2 = new Matrix();
            SZ.set(matrix2);
            matrix = matrix2;
        } else {
            matrix2.reset();
            matrix = matrix2;
        }
        a((ViewParent) viewGroup, view, matrix);
        RectF rectF = (RectF) Ta.get();
        if (rectF == null) {
            rectF = new RectF();
            Ta.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    private static void a(ViewParent viewParent, View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            View view2 = (View) parent;
            a(viewParent, view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        if (!view.getMatrix().isIdentity()) {
            matrix.preConcat(view.getMatrix());
        }
    }
}
