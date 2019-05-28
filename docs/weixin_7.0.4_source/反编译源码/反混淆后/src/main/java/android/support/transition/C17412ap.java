package android.support.transition;

import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.ap */
final class C17412ap extends C37106ao {
    /* renamed from: AZ */
    private static Method f3854AZ;
    /* renamed from: Ba */
    private static boolean f3855Ba;

    C17412ap() {
    }

    /* renamed from: c */
    public final C37105am mo31640c(ViewGroup viewGroup) {
        return new C44948al(viewGroup);
    }

    /* renamed from: c */
    public final void mo31641c(ViewGroup viewGroup, boolean z) {
        if (!f3855Ba) {
            try {
                Method declaredMethod = ViewGroup.class.getDeclaredMethod("suppressLayout", new Class[]{Boolean.TYPE});
                f3854AZ = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f3855Ba = true;
        }
        if (f3854AZ != null) {
            try {
                f3854AZ.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
            } catch (IllegalAccessException | InvocationTargetException e2) {
            }
        }
    }
}
