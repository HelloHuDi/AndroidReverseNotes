package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.s;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

final class au {
    private static final ba Bi;
    private static Field Bj;
    private static boolean Bk;
    static final Property<View, Float> Bl = new Property<View, Float>(Float.class, "translationAlpha") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(au.L((View) obj));
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            au.c((View) obj, ((Float) obj2).floatValue());
        }
    };
    static final Property<View, Rect> Bm = new Property<View, Rect>(Rect.class, "clipBounds") {
        public final /* synthetic */ Object get(Object obj) {
            return s.au((View) obj);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            s.c((View) obj, (Rect) obj2);
        }
    };

    static {
        if (VERSION.SDK_INT >= 22) {
            Bi = new az();
        } else if (VERSION.SDK_INT >= 21) {
            Bi = new ay();
        } else if (VERSION.SDK_INT >= 19) {
            Bi = new ax();
        } else if (VERSION.SDK_INT >= 18) {
            Bi = new aw();
        } else {
            Bi = new av();
        }
    }

    static at J(View view) {
        return Bi.J(view);
    }

    static be K(View view) {
        return Bi.K(view);
    }

    static void c(View view, float f) {
        Bi.c(view, f);
    }

    static float L(View view) {
        return Bi.L(view);
    }

    static void M(View view) {
        Bi.M(view);
    }

    static void N(View view) {
        Bi.N(view);
    }

    static void a(View view, Matrix matrix) {
        Bi.a(view, matrix);
    }

    static void b(View view, Matrix matrix) {
        Bi.b(view, matrix);
    }

    static void c(View view, Matrix matrix) {
        Bi.c(view, matrix);
    }

    static void b(View view, int i, int i2, int i3, int i4) {
        Bi.b(view, i, i2, i3, i4);
    }

    static void l(View view, int i) {
        if (!Bk) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                Bj = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Bk = true;
        }
        if (Bj != null) {
            try {
                Bj.setInt(view, (Bj.getInt(view) & -13) | i);
            } catch (IllegalAccessException e2) {
            }
        }
    }
}
