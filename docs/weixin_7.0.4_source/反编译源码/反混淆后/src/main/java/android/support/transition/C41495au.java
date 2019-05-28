package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.p057v4.view.C0477s;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

/* renamed from: android.support.transition.au */
final class C41495au {
    /* renamed from: Bi */
    private static final C44952ba f16768Bi;
    /* renamed from: Bj */
    private static Field f16769Bj;
    /* renamed from: Bk */
    private static boolean f16770Bk;
    /* renamed from: Bl */
    static final Property<View, Float> f16771Bl = new Property<View, Float>(Float.class, "translationAlpha") {
        public final /* synthetic */ Object get(Object obj) {
            return Float.valueOf(C41495au.m72476L((View) obj));
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C41495au.m72482c((View) obj, ((Float) obj2).floatValue());
        }
    };
    /* renamed from: Bm */
    static final Property<View, Rect> f16772Bm = new Property<View, Rect>(Rect.class, "clipBounds") {
        public final /* synthetic */ Object get(Object obj) {
            return C0477s.m929au((View) obj);
        }

        public final /* synthetic */ void set(Object obj, Object obj2) {
            C0477s.m937c((View) obj, (Rect) obj2);
        }
    };

    static {
        if (VERSION.SDK_INT >= 22) {
            f16768Bi = new C24640az();
        } else if (VERSION.SDK_INT >= 21) {
            f16768Bi = new C17415ay();
        } else if (VERSION.SDK_INT >= 19) {
            f16768Bi = new C8371ax();
        } else if (VERSION.SDK_INT >= 18) {
            f16768Bi = new C44950aw();
        } else {
            f16768Bi = new C37108av();
        }
    }

    /* renamed from: J */
    static C41494at m72474J(View view) {
        return f16768Bi.mo59153J(view);
    }

    /* renamed from: K */
    static C8373be m72475K(View view) {
        return f16768Bi.mo59154K(view);
    }

    /* renamed from: c */
    static void m72482c(View view, float f) {
        f16768Bi.mo18297c(view, f);
    }

    /* renamed from: L */
    static float m72476L(View view) {
        return f16768Bi.mo18294L(view);
    }

    /* renamed from: M */
    static void m72477M(View view) {
        f16768Bi.mo18295M(view);
    }

    /* renamed from: N */
    static void m72478N(View view) {
        f16768Bi.mo18296N(view);
    }

    /* renamed from: a */
    static void m72479a(View view, Matrix matrix) {
        f16768Bi.mo31644a(view, matrix);
    }

    /* renamed from: b */
    static void m72481b(View view, Matrix matrix) {
        f16768Bi.mo31645b(view, matrix);
    }

    /* renamed from: c */
    static void m72483c(View view, Matrix matrix) {
        f16768Bi.mo31646c(view, matrix);
    }

    /* renamed from: b */
    static void m72480b(View view, int i, int i2, int i3, int i4) {
        f16768Bi.mo41475b(view, i, i2, i3, i4);
    }

    /* renamed from: l */
    static void m72484l(View view, int i) {
        if (!f16770Bk) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f16769Bj = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f16770Bk = true;
        }
        if (f16769Bj != null) {
            try {
                f16769Bj.setInt(view, (f16769Bj.getInt(view) & -13) | i);
            } catch (IllegalAccessException e2) {
            }
        }
    }
}
