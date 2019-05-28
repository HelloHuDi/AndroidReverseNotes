package android.support.v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class bk {
    private static Method avi;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                Method declaredMethod = View.class.getDeclaredMethod("computeFitSystemWindows", new Class[]{Rect.class, Rect.class});
                avi = declaredMethod;
                if (!declaredMethod.isAccessible()) {
                    avi.setAccessible(true);
                }
            } catch (NoSuchMethodException e) {
            }
        }
    }

    public static boolean bW(View view) {
        return s.T(view) == 1;
    }

    public static void a(View view, Rect rect, Rect rect2) {
        if (avi != null) {
            try {
                avi.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
            }
        }
    }

    public static void bX(View view) {
        if (VERSION.SDK_INT >= 16) {
            try {
                Method method = view.getClass().getMethod("makeOptionalFitsSystemWindows", new Class[0]);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                method.invoke(view, new Object[0]);
            } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            }
        }
    }
}
