package android.support.transition;

import android.graphics.Matrix;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ay extends ax {
    private static Method Bs;
    private static boolean Bt;
    private static Method Bu;
    private static boolean Bv;
    private static Method Bw;
    private static boolean Bx;

    ay() {
    }

    public final void a(View view, Matrix matrix) {
        if (!Bt) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[]{Matrix.class});
                Bs = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Bt = true;
        }
        if (Bs != null) {
            try {
                Bs.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    public final void b(View view, Matrix matrix) {
        if (!Bv) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[]{Matrix.class});
                Bu = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Bv = true;
        }
        if (Bu != null) {
            try {
                Bu.invoke(view, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    public final void c(View view, Matrix matrix) {
        if (!Bx) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setAnimationMatrix", new Class[]{Matrix.class});
                Bw = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Bx = true;
        }
        if (Bw != null) {
            try {
                Bw.invoke(view, new Object[]{matrix});
            } catch (InvocationTargetException e2) {
            } catch (IllegalAccessException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
