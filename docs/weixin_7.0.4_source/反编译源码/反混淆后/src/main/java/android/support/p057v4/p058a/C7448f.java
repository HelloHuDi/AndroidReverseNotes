package android.support.p057v4.p058a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.p057v4.content.p062a.C0372a.C0371c;
import android.support.p057v4.content.p062a.C0372a.C0373b;
import android.support.p057v4.p063d.C0391b.C0389b;
import android.support.p057v4.p065f.C0417m;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

/* renamed from: android.support.v4.a.f */
final class C7448f extends C6176h {
    /* renamed from: Hg */
    private static final Class f2039Hg;
    /* renamed from: Hh */
    private static final Constructor f2040Hh;
    /* renamed from: Hi */
    private static final Method f2041Hi;
    /* renamed from: Hj */
    private static final Method f2042Hj;

    C7448f() {
    }

    static {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontWeightStyle", new Class[]{ByteBuffer.class, Integer.TYPE, List.class, Integer.TYPE, Boolean.TYPE});
            method2 = Typeface.class.getMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass()});
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.getClass().getName();
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
        }
        f2040Hh = constructor;
        f2039Hg = cls;
        f2041Hi = method;
        f2042Hj = method2;
    }

    /* renamed from: dw */
    public static boolean m12697dw() {
        return f2041Hi != null;
    }

    /* renamed from: dx */
    private static Object m12698dx() {
        try {
            return f2040Hh.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m12696a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) f2041Hi.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: q */
    private static Typeface m12699q(Object obj) {
        try {
            Array.set(Array.newInstance(f2039Hg, 1), 0, obj);
            return (Typeface) f2042Hj.invoke(null, new Object[]{r0});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final Typeface mo467a(Context context, C0389b[] c0389bArr, int i) {
        Object dx = C7448f.m12698dx();
        C0417m c0417m = new C0417m();
        for (C0389b c0389b : c0389bArr) {
            Uri uri = c0389b.mUri;
            ByteBuffer byteBuffer = (ByteBuffer) c0417m.get(uri);
            if (byteBuffer == null) {
                byteBuffer = C0291i.m507b(context, uri);
                c0417m.put(uri, byteBuffer);
            }
            if (!C7448f.m12696a(dx, byteBuffer, c0389b.f441Ks, c0389b.f438GO, c0389b.f439GP)) {
                return null;
            }
        }
        return Typeface.create(C7448f.m12699q(dx), i);
    }

    /* renamed from: a */
    public final Typeface mo466a(Context context, C0373b c0373b, Resources resources, int i) {
        Object dx = C7448f.m12698dx();
        for (C0371c c0371c : c0373b.f420GN) {
            ByteBuffer a = C0291i.m504a(context, resources, c0371c.f419GQ);
            if (a == null || !C7448f.m12696a(dx, a, 0, c0371c.f417GO, c0371c.f418GP)) {
                return null;
            }
        }
        return C7448f.m12699q(dx);
    }
}
