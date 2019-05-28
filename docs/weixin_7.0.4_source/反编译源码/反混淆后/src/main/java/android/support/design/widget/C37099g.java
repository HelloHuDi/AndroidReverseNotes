package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Method;

/* renamed from: android.support.design.widget.g */
final class C37099g {
    /* renamed from: pY */
    private static Method f15676pY;
    /* renamed from: pZ */
    private static boolean f15677pZ;

    /* renamed from: a */
    static boolean m62061a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!f15677pZ) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                f15676pY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f15677pZ = true;
        }
        if (f15676pY != null) {
            try {
                f15676pY.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
