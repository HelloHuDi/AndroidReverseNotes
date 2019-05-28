package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class ap extends ao {
    private static Method AZ;
    private static boolean Ba;

    ap() {
    }

    public final am c(ViewGroup viewGroup) {
        return new al(viewGroup);
    }

    public final void c(ViewGroup viewGroup, boolean z) {
        if (!Ba) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                AZ = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            Ba = true;
        }
        if (AZ != null) {
            try {
                AZ.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException | InvocationTargetException e2) {
            }
        }
    }
}
