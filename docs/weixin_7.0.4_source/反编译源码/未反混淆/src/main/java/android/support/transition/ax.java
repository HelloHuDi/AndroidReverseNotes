package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ax extends aw {
    private static Method Bo;
    private static boolean Bp;
    private static Method Bq;
    private static boolean Br;

    ax() {
    }

    public final void M(View view) {
    }

    public final void N(View view) {
    }

    public final void c(View view, float f) {
        if (!Bp) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setTransitionAlpha", new Class[]{Float.TYPE});
                Bo = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Bp = true;
        }
        if (Bo != null) {
            try {
                Bo.invoke(view, new Object[]{Float.valueOf(f)});
                return;
            } catch (IllegalAccessException e2) {
                return;
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        view.setAlpha(f);
    }

    public final float L(View view) {
        if (!Br) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("getTransitionAlpha", new Class[0]);
                Bq = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Br = true;
        }
        if (Bq != null) {
            try {
                return ((Float) Bq.invoke(view, new Object[0])).floatValue();
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
        return super.L(view);
    }
}
