package android.support.p069v7.p071c.p072a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.p057v4.content.C0380b;
import android.support.p069v7.widget.C0716i;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

/* renamed from: android.support.v7.c.a.b */
public final class C0589b {
    /* renamed from: Xk */
    private static final ThreadLocal<TypedValue> f906Xk = new ThreadLocal();
    /* renamed from: Xl */
    private static final WeakHashMap<Context, SparseArray<C0588a>> f907Xl = new WeakHashMap(0);
    /* renamed from: Xm */
    private static final Object f908Xm = new Object();

    /* renamed from: android.support.v7.c.a.b$a */
    static class C0588a {
        /* renamed from: Xn */
        final ColorStateList f904Xn;
        /* renamed from: Xo */
        final Configuration f905Xo;

        C0588a(ColorStateList colorStateList, Configuration configuration) {
            this.f904Xn = colorStateList;
            this.f905Xo = configuration;
        }
    }

    /* renamed from: h */
    public static ColorStateList m1276h(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList l = C0589b.m1278l(context, i);
        if (l != null) {
            return l;
        }
        ColorStateList k = C0589b.m1277k(context, i);
        if (k == null) {
            return C0380b.m650h(context, i);
        }
        synchronized (f908Xm) {
            SparseArray sparseArray = (SparseArray) f907Xl.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                f907Xl.put(context, sparseArray);
            }
            sparseArray.append(i, new C0588a(k, context.getResources().getConfiguration()));
        }
        return k;
    }

    /* renamed from: g */
    public static Drawable m1275g(Context context, int i) {
        return C0716i.m1606hE().mo2082a(context, i, false);
    }

    /* renamed from: k */
    private static ColorStateList m1277k(Context context, int i) {
        boolean z;
        Resources resources = context.getResources();
        TypedValue typedValue = (TypedValue) f906Xk.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            f906Xk.set(typedValue);
        }
        resources.getValue(i, typedValue, true);
        if (typedValue.type < 28 || typedValue.type > 31) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        Resources resources2 = context.getResources();
        try {
            return C0587a.createFromXml(resources2, resources2.getXml(i), context.getTheme());
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: l */
    private static ColorStateList m1278l(Context context, int i) {
        synchronized (f908Xm) {
            SparseArray sparseArray = (SparseArray) f907Xl.get(context);
            if (sparseArray != null && sparseArray.size() > 0) {
                C0588a c0588a = (C0588a) sparseArray.get(i);
                if (c0588a != null) {
                    if (c0588a.f905Xo.equals(context.getResources().getConfiguration())) {
                        ColorStateList colorStateList = c0588a.f904Xn;
                        return colorStateList;
                    }
                    sparseArray.remove(i);
                }
            }
        }
    }
}
