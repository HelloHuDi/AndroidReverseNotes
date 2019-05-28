package android.support.design.widget;

import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import java.lang.reflect.Method;

final class g {
    private static Method pY;
    private static boolean pZ;

    static boolean a(DrawableContainer drawableContainer, ConstantState constantState) {
        if (!pZ) {
            try {
                Method declaredMethod = DrawableContainer.class.getDeclaredMethod("setConstantState", new Class[]{DrawableContainerState.class});
                pY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            pZ = true;
        }
        if (pY != null) {
            try {
                pY.invoke(drawableContainer, new Object[]{constantState});
                return true;
            } catch (Exception e2) {
            }
        }
        return false;
    }
}
