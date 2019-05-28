package android.support.v4.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v4.content.a.a;
import android.support.v4.content.a.a.c;
import android.support.v4.d.b.b;
import android.support.v4.f.m;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

final class f extends h {
    private static final Class Hg;
    private static final Constructor Hh;
    private static final Method Hi;
    private static final Method Hj;

    f() {
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
        Hh = constructor;
        Hg = cls;
        Hi = method;
        Hj = method2;
    }

    public static boolean dw() {
        return Hi != null;
    }

    private static Object dx() {
        try {
            return Hh.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, boolean z) {
        try {
            return ((Boolean) Hi.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Boolean.valueOf(z)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface q(Object obj) {
        try {
            Array.set(Array.newInstance(Hg, 1), 0, obj);
            return (Typeface) Hj.invoke(null, new Object[]{r0});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public final Typeface a(Context context, b[] bVarArr, int i) {
        Object dx = dx();
        m mVar = new m();
        for (b bVar : bVarArr) {
            Uri uri = bVar.mUri;
            ByteBuffer byteBuffer = (ByteBuffer) mVar.get(uri);
            if (byteBuffer == null) {
                byteBuffer = i.b(context, uri);
                mVar.put(uri, byteBuffer);
            }
            if (!a(dx, byteBuffer, bVar.Ks, bVar.GO, bVar.GP)) {
                return null;
            }
        }
        return Typeface.create(q(dx), i);
    }

    public final Typeface a(Context context, a.b bVar, Resources resources, int i) {
        Object dx = dx();
        for (c cVar : bVar.GN) {
            ByteBuffer a = i.a(context, resources, cVar.GQ);
            if (a == null || !a(dx, a, 0, cVar.GO, cVar.GP)) {
                return null;
            }
        }
        return q(dx);
    }
}
