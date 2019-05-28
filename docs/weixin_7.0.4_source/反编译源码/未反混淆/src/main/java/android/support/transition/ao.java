package android.support.transition;

import android.animation.LayoutTransition;
import android.view.ViewGroup;
import com.tencent.mm.R;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ao implements aq {
    private static LayoutTransition AT;
    private static Field AU;
    private static boolean AV;
    private static Method AW;
    private static boolean AX;

    ao() {
    }

    public void c(ViewGroup viewGroup, boolean z) {
        int i = 0;
        if (AT == null) {
            AnonymousClass1 anonymousClass1 = new LayoutTransition() {
                public final boolean isChangingLayout() {
                    return true;
                }
            };
            AT = anonymousClass1;
            anonymousClass1.setAnimator(2, null);
            AT.setAnimator(0, null);
            AT.setAnimator(1, null);
            AT.setAnimator(3, null);
            AT.setAnimator(4, null);
        }
        LayoutTransition layoutTransition;
        if (z) {
            layoutTransition = viewGroup.getLayoutTransition();
            if (layoutTransition != null) {
                if (layoutTransition.isRunning()) {
                    if (!AX) {
                        try {
                            Method declaredMethod = LayoutTransition.class.getDeclaredMethod("cancel", new Class[0]);
                            AW = declaredMethod;
                            declaredMethod.setAccessible(true);
                        } catch (NoSuchMethodException e) {
                        }
                        AX = true;
                    }
                    if (AW != null) {
                        try {
                            AW.invoke(layoutTransition, new Object[0]);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                        }
                    }
                }
                if (layoutTransition != AT) {
                    viewGroup.setTag(R.id.d0, layoutTransition);
                }
            }
            viewGroup.setLayoutTransition(AT);
            return;
        }
        viewGroup.setLayoutTransition(null);
        if (!AV) {
            try {
                Field declaredField = ViewGroup.class.getDeclaredField("mLayoutSuppressed");
                AU = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e3) {
            }
            AV = true;
        }
        if (AU != null) {
            try {
                i = AU.getBoolean(viewGroup);
                if (i != 0) {
                    AU.setBoolean(viewGroup, false);
                }
            } catch (IllegalAccessException e4) {
            }
        }
        if (i != 0) {
            viewGroup.requestLayout();
        }
        layoutTransition = (LayoutTransition) viewGroup.getTag(R.id.d0);
        if (layoutTransition != null) {
            viewGroup.setTag(R.id.d0, null);
            viewGroup.setLayoutTransition(layoutTransition);
        }
    }

    public am c(ViewGroup viewGroup) {
        return (ak) ar.I(viewGroup);
    }
}
