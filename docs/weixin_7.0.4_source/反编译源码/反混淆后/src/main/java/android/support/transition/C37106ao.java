package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.ao */
class C37106ao implements C17413aq {
    /* renamed from: AT */
    private static LayoutTransition f15742AT;
    /* renamed from: AU */
    private static Field f15743AU;
    /* renamed from: AV */
    private static boolean f15744AV;
    /* renamed from: AW */
    private static Method f15745AW;
    /* renamed from: AX */
    private static boolean f15746AX;

    /* renamed from: android.support.transition.ao$1 */
    class C253231 extends LayoutTransition {
        C253231() {
        }

        public final boolean isChangingLayout() {
            return true;
        }
    }

    C37106ao() {
    }

    /* renamed from: c */
    public void mo31641c(ViewGroup viewGroup, boolean z) {
        int i = 0;
        if (f15742AT == null) {
            C253231 c253231 = new C253231();
            f15742AT = c253231;
            c253231.setAnimator(2, null);
            f15742AT.setAnimator(0, null);
            f15742AT.setAnimator(1, null);
            f15742AT.setAnimator(3, null);
            f15742AT.setAnimator(4, null);
        }
        LayoutTransition layoutTransition;
        if (z) {
            layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    if (!f15746AX) {
                        try {
                            Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                            f15745AW = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                        }
                        f15746AX = true;
                    }
                    if (f15745AW != null) {
                        try {
                            f15745AW.invoke(layoutTransition, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                        }
                    }
                }
                if (layoutTransition != f15742AT) {
                    viewGroup.setTag(2131820681, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(f15742AT);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!f15744AV) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                f15743AU = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
            }
            f15744AV = true;
        }
        if (f15743AU != null) {
            try {
                i = f15743AU.getBoolean(viewGroup);
                if (i != 0) {
                    f15743AU.setBoolean(viewGroup, false);
                }
            } catch (IllegalAccessException e4) {
            }
        }
        if (i != 0) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(2131820681);
        if (layoutTransition != null) {
            viewGroup.setTag(2131820681, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    /* renamed from: c */
    public C37105am mo31640c(ViewGroup viewGroup) {
        return (C41493ak) C25324ar.m39951I(viewGroup);
    }
}
