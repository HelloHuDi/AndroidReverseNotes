package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.ax */
class C8371ax extends C44950aw {
    /* renamed from: Bo */
    private static Method f2325Bo;
    /* renamed from: Bp */
    private static boolean f2326Bp;
    /* renamed from: Bq */
    private static Method f2327Bq;
    /* renamed from: Br */
    private static boolean f2328Br;

    C8371ax() {
    }

    /* renamed from: M */
    public final void mo18295M(View view) {
    }

    /* renamed from: N */
    public final void mo18296N(View view) {
    }

    /* renamed from: c */
    public final void mo18297c(View view, float f) {
        if (!f2326Bp) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                f2325Bo = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f2326Bp = true;
        }
        if (f2325Bo != null) {
            try {
                f2325Bo.invoke(view, new Object[]{Float.valueOf(f)});
                return;
            } catch (IllegalAccessException e2) {
                return;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        view.setAlpha(f);
    }

    /* renamed from: L */
    public final float mo18294L(View view) {
        if (!f2328Br) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                f2327Bq = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f2328Br = true;
        }
        if (f2327Bq != null) {
            try {
                return ((Float) f2327Bq.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        return super.mo18294L(view);
    }
}
