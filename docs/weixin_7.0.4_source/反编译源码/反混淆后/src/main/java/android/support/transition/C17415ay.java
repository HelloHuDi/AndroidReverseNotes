package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.ay */
class C17415ay extends C8371ax {
    /* renamed from: Bs */
    private static Method f3857Bs;
    /* renamed from: Bt */
    private static boolean f3858Bt;
    /* renamed from: Bu */
    private static Method f3859Bu;
    /* renamed from: Bv */
    private static boolean f3860Bv;
    /* renamed from: Bw */
    private static Method f3861Bw;
    /* renamed from: Bx */
    private static boolean f3862Bx;

    C17415ay() {
    }

    /* renamed from: a */
    public final void mo31644a(View view, Matrix matrix) {
        if (!f3858Bt) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                f3857Bs = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f3858Bt = true;
        }
        if (f3857Bs != null) {
            try {
                f3857Bs.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    /* renamed from: b */
    public final void mo31645b(View view, Matrix matrix) {
        if (!f3860Bv) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                f3859Bu = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f3860Bv = true;
        }
        if (f3859Bu != null) {
            try {
                f3859Bu.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    /* renamed from: c */
    public final void mo31646c(View view, Matrix matrix) {
        if (!f3862Bx) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[]{Matrix.class});
                f3861Bw = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f3862Bx = true;
        }
        if (f3861Bw != null) {
            try {
                f3861Bw.invoke(view, new Object[]{matrix});
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
