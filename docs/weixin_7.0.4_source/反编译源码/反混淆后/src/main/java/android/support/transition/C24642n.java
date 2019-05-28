package android.support.transition;

import android.animation.Animator;
import android.graphics.Matrix;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.transition.n */
final class C24642n implements C17421o {
    /* renamed from: yY */
    private static Method f4951yY;
    /* renamed from: yZ */
    private static boolean f4952yZ;

    C24642n() {
    }

    /* renamed from: a */
    public final void mo31655a(ImageView imageView) {
    }

    /* renamed from: a */
    public final void mo31656a(ImageView imageView, Animator animator) {
    }

    /* renamed from: a */
    public final void mo31657a(ImageView imageView, Matrix matrix) {
        if (!f4952yZ) {
            try {
                Method declaredMethod = ImageView.class.getDeclaredMethod("animateTransform", new Class[]{Matrix.class});
                f4951yY = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException e) {
            }
            f4952yZ = true;
        }
        if (f4951yY != null) {
            try {
                f4951yY.invoke(imageView, new Object[]{matrix});
            } catch (IllegalAccessException e2) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }
}
