package android.support.v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class t {
    private static Method Nn;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                Nn = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    public static int a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float a(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return c(viewConfiguration, context);
    }

    public static float b(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return c(viewConfiguration, context);
    }

    private static float c(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 25 && Nn != null) {
            try {
                return (float) ((Integer) Nn.invoke(viewConfiguration, new Object[0])).intValue();
            } catch (Exception e) {
            }
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
            return typedValue.getDimension(context.getResources().getDisplayMetrics());
        }
        return 0.0f;
    }
}
