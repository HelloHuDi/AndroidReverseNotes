package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import android.view.ViewParent;

/* renamed from: android.support.transition.av */
class C37108av implements C44952ba {
    /* renamed from: Bn */
    private float[] f15747Bn;

    C37108av() {
    }

    /* renamed from: J */
    public C41494at mo59153J(View view) {
        return C25324ar.m39951I(view);
    }

    /* renamed from: K */
    public C8373be mo59154K(View view) {
        return new C16503bc(view.getWindowToken());
    }

    /* renamed from: c */
    public void mo18297c(View view, float f) {
        Float f2 = (Float) view.getTag(2131820663);
        if (f2 != null) {
            view.setAlpha(f2.floatValue() * f);
        } else {
            view.setAlpha(f);
        }
    }

    /* renamed from: L */
    public float mo18294L(View view) {
        Float f = (Float) view.getTag(2131820663);
        if (f != null) {
            return view.getAlpha() / f.floatValue();
        }
        return view.getAlpha();
    }

    /* renamed from: M */
    public void mo18295M(View view) {
        if (view.getTag(2131820663) == null) {
            view.setTag(2131820663, Float.valueOf(view.getAlpha()));
        }
    }

    /* renamed from: N */
    public void mo18296N(View view) {
        if (view.getVisibility() == 0) {
            view.setTag(2131820663, null);
        }
    }

    /* renamed from: a */
    public void mo31644a(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo31644a(view2, matrix);
            matrix.preTranslate((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
        }
        matrix.preTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            matrix.preConcat(matrix2);
        }
    }

    /* renamed from: b */
    public void mo31645b(View view, Matrix matrix) {
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            mo31645b(view2, matrix);
            matrix.postTranslate((float) view2.getScrollX(), (float) view2.getScrollY());
        }
        matrix.postTranslate((float) view.getLeft(), (float) view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (!matrix2.isIdentity()) {
            Matrix matrix3 = new Matrix();
            if (matrix2.invert(matrix3)) {
                matrix.postConcat(matrix3);
            }
        }
    }

    /* renamed from: c */
    public void mo31646c(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX((float) (view.getWidth() / 2));
            view.setPivotY((float) (view.getHeight() / 2));
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f15747Bn;
        if (fArr == null) {
            fArr = new float[9];
            this.f15747Bn = fArr;
        }
        matrix.getValues(fArr);
        float f = fArr[3];
        float sqrt = ((float) (fArr[0] < 0.0f ? -1 : 1)) * ((float) Math.sqrt((double) (1.0f - (f * f))));
        f = (float) Math.toDegrees(Math.atan2((double) f, (double) sqrt));
        float f2 = fArr[0] / sqrt;
        sqrt = fArr[4] / sqrt;
        float f3 = fArr[2];
        float f4 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f3);
        view.setTranslationY(f4);
        view.setRotation(f);
        view.setScaleX(f2);
        view.setScaleY(sqrt);
    }

    /* renamed from: b */
    public void mo41475b(View view, int i, int i2, int i3, int i4) {
        view.setLeft(i);
        view.setTop(i2);
        view.setRight(i3);
        view.setBottom(i4);
    }
}
