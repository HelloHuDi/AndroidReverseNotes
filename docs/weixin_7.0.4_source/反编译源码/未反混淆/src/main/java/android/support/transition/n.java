package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

final class n implements o {
    private static Method yY;
    private static boolean yZ;

    n() {
    }

    public final void a(ImageView imageView) {
    }

    public final void a(ImageView imageView, Animator animator) {
    }

    public final void a(ImageView imageView, Matrix matrix) {
        if (!yZ) {
            try {
                Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
                yY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            yZ = true;
        }
        if (yY != null) {
            try {
                yY.invoke(imageView, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
