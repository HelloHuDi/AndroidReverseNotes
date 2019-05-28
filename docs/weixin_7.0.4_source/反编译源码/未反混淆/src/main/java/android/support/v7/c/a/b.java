package android.support.v7.c.a;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.i;
import android.util.SparseArray;
import android.util.TypedValue;
import java.util.WeakHashMap;

public final class b {
    private static final ThreadLocal<TypedValue> Xk = new ThreadLocal();
    private static final WeakHashMap<Context, SparseArray<a>> Xl = new WeakHashMap(0);
    private static final Object Xm = new Object();

    static class a {
        final ColorStateList Xn;
        final Configuration Xo;

        a(ColorStateList colorStateList, Configuration configuration) {
            this.Xn = colorStateList;
            this.Xo = configuration;
        }
    }

    public static ColorStateList h(Context context, int i) {
        if (VERSION.SDK_INT >= 23) {
            return context.getColorStateList(i);
        }
        ColorStateList l = l(context, i);
        if (l != null) {
            return l;
        }
        ColorStateList k = k(context, i);
        if (k == null) {
            return android.support.v4.content.b.h(context, i);
        }
        synchronized (Xm) {
            SparseArray sparseArray = (SparseArray) Xl.get(context);
            if (sparseArray == null) {
                sparseArray = new SparseArray();
                Xl.put(context, sparseArray);
            }
            sparseArray.append(i, new a(k, context.getResources().getConfiguration()));
        }
        return k;
    }

    public static Drawable g(Context context, int i) {
        return i.hE().a(context, i, false);
    }

    private static ColorStateList k(Context context, int i) {
        boolean z;
        Resources resources = context.getResources();
        TypedValue typedValue = (TypedValue) Xk.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            Xk.set(typedValue);
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
            return a.createFromXml(resources2, resources2.getXml(i), context.getTheme());
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARNING: Missing block: B:20:?, code skipped:
            return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static ColorStateList l(Context context, int i) {
        synchronized (Xm) {
            SparseArray sparseArray = (SparseArray) Xl.get(context);
            if (sparseArray != null && sparseArray.size() > 0) {
                a aVar = (a) sparseArray.get(i);
                if (aVar != null) {
                    if (aVar.Xo.equals(context.getResources().getConfiguration())) {
                        ColorStateList colorStateList = aVar.Xn;
                        return colorStateList;
                    }
                    sparseArray.remove(i);
                }
            }
        }
    }
}
