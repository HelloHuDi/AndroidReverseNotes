package android.support.transition;

import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.az */
final class C24640az extends C17415ay {
    /* renamed from: By */
    private static Method f4949By;
    /* renamed from: Bz */
    private static boolean f4950Bz;

    C24640az() {
    }

    /* renamed from: b */
    public final void mo41475b(View view, int i, int i2, int i3, int i4) {
        if (!f4950Bz) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("setLeftTopRightBottom", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE});
                f4949By = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f4950Bz = true;
        }
        if (f4949By != null) {
            try {
                f4949By.invoke(view, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
