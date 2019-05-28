package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.content.a.a.b;
import android.support.v4.f.g;

public final class d {
    private static final a He;
    private static final g<String, Typeface> Hf = new g(16);

    interface a {
        Typeface a(Context context, Resources resources, int i, String str, int i2);

        Typeface a(Context context, b bVar, Resources resources, int i);

        Typeface a(Context context, android.support.v4.d.b.b[] bVarArr, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            He = new g();
        } else if (VERSION.SDK_INT >= 24 && f.dw()) {
            He = new f();
        } else if (VERSION.SDK_INT >= 21) {
            He = new e();
        } else {
            He = new h();
        }
    }

    public static Typeface a(Resources resources, int i, int i2) {
        return (Typeface) Hf.get(b(resources, i, i2));
    }

    private static String b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    public static Typeface a(Context context, android.support.v4.content.a.a.a aVar, Resources resources, int i, int i2, android.support.v4.content.a.b.a aVar2) {
        Object a;
        if (aVar instanceof android.support.v4.content.a.a.d) {
            boolean z;
            android.support.v4.content.a.a.d dVar = (android.support.v4.content.a.a.d) aVar;
            if (dVar.GU == 0) {
                z = true;
            } else {
                z = false;
            }
            Context context2 = context;
            a = android.support.v4.d.b.a(context2, dVar.GR, aVar2, z, dVar.GS, i2);
        } else {
            Typeface a2 = He.a(context, (b) aVar, resources, i2);
            if (aVar2 != null) {
                if (a2 != null) {
                    aVar2.a(a2, null);
                } else {
                    aVar2.a(-3, null);
                }
            }
        }
        if (a2 != null) {
            Hf.put(b(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = He.a(context, resources, i, str, i2);
        if (a != null) {
            Hf.put(b(resources, i, i2), a);
        }
        return a;
    }

    public static Typeface a(Context context, android.support.v4.d.b.b[] bVarArr, int i) {
        return He.a(context, bVarArr, i);
    }
}
