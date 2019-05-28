package android.support.p069v7.widget;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: android.support.v7.widget.bk */
public final class C0709bk {
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

    /* renamed from: bW */
    public static boolean m1576bW(View view) {
        return C0477s.m893T(view) == 1;
    }

    /* renamed from: a */
    public static void m1575a(View view, Rect rect, Rect rect2) {
        if (avi != null) {
            try {
                avi.invoke(view, new Object[]{rect, rect2});
            } catch (Exception e) {
            }
        }
    }

    /* renamed from: bX */
    public static void m1577bX(View view) {
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
