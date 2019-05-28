package android.support.p057v4.p058a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.p057v4.content.p062a.C0372a.C0370a;
import android.support.p057v4.content.p062a.C0372a.C0373b;
import android.support.p057v4.content.p062a.C0372a.C0374d;
import android.support.p057v4.content.p062a.C0378b.C0377a;
import android.support.p057v4.p063d.C0391b;
import android.support.p057v4.p063d.C0391b.C0389b;
import android.support.p057v4.p065f.C0408g;

/* renamed from: android.support.v4.a.d */
public final class C0289d {
    /* renamed from: He */
    private static final C0288a f207He;
    /* renamed from: Hf */
    private static final C0408g<String, Typeface> f208Hf = new C0408g(16);

    /* renamed from: android.support.v4.a.d$a */
    interface C0288a {
        /* renamed from: a */
        Typeface mo465a(Context context, Resources resources, int i, String str, int i2);

        /* renamed from: a */
        Typeface mo466a(Context context, C0373b c0373b, Resources resources, int i);

        /* renamed from: a */
        Typeface mo467a(Context context, C0389b[] c0389bArr, int i);
    }

    static {
        if (VERSION.SDK_INT >= 26) {
            f207He = new C7588g();
        } else if (VERSION.SDK_INT >= 24 && C7448f.m12697dw()) {
            f207He = new C7448f();
        } else if (VERSION.SDK_INT >= 21) {
            f207He = new C7447e();
        } else {
            f207He = new C6176h();
        }
    }

    /* renamed from: a */
    public static Typeface m499a(Resources resources, int i, int i2) {
        return (Typeface) f208Hf.get(C0289d.m500b(resources, i, i2));
    }

    /* renamed from: b */
    private static String m500b(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* renamed from: a */
    public static Typeface m497a(Context context, C0370a c0370a, Resources resources, int i, int i2, C0377a c0377a) {
        Object a;
        if (c0370a instanceof C0374d) {
            boolean z;
            C0374d c0374d = (C0374d) c0370a;
            if (c0374d.f423GU == 0) {
                z = true;
            } else {
                z = false;
            }
            Context context2 = context;
            a = C0391b.m656a(context2, c0374d.f421GR, c0377a, z, c0374d.f422GS, i2);
        } else {
            Typeface a2 = f207He.mo466a(context, (C0373b) c0370a, resources, i2);
            if (c0377a != null) {
                if (a2 != null) {
                    c0377a.mo663a(a2, null);
                } else {
                    c0377a.mo662a(-3, null);
                }
            }
        }
        if (a2 != null) {
            f208Hf.put(C0289d.m500b(resources, i, i2), a2);
        }
        return a2;
    }

    /* renamed from: a */
    public static Typeface m496a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a = f207He.mo465a(context, resources, i, str, i2);
        if (a != null) {
            f208Hf.put(C0289d.m500b(resources, i, i2), a);
        }
        return a;
    }

    /* renamed from: a */
    public static Typeface m498a(Context context, C0389b[] c0389bArr, int i) {
        return f207He.mo467a(context, c0389bArr, i);
    }
}
