package android.support.p057v4.view;

import android.content.Context;
import android.os.Build.VERSION;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

/* renamed from: android.support.v4.view.t */
public final class C44962t {
    /* renamed from: Nn */
    private static Method f17697Nn;

    static {
        if (VERSION.SDK_INT == 25) {
            try {
                f17697Nn = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
            } catch (Exception e) {
            }
        }
    }

    @Deprecated
    /* renamed from: a */
    public static int m82264a(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    /* renamed from: a */
    public static float m82263a(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return C44962t.m82266c(viewConfiguration, context);
    }

    /* renamed from: b */
    public static float m82265b(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 26) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return C44962t.m82266c(viewConfiguration, context);
    }

    /* renamed from: c */
    private static float m82266c(ViewConfiguration viewConfiguration, Context context) {
        if (VERSION.SDK_INT >= 25 && f17697Nn != null) {
            try {
                return (float) ((Integer) f17697Nn.invoke(viewConfiguration, new Object[0])).intValue();
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
