package android.support.v4.a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import android.support.v4.content.a.a.b;
import android.support.v4.content.a.a.c;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

public final class g extends e {
    private static final Class Hg;
    private static final Constructor Hh;
    private static final Method Hj;
    private static final Method Hk;
    private static final Method Hl;
    private static final Method Hm;
    private static final Method Hn;

    static {
        Class cls;
        Constructor constructor;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method declaredMethod;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            constructor = cls.getConstructor(new Class[0]);
            method = cls.getMethod("addFontFromAssetManager", new Class[]{AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, Integer.TYPE, Integer.TYPE, Integer.TYPE, FontVariationAxis[].class});
            method2 = cls.getMethod("addFontFromBuffer", new Class[]{ByteBuffer.class, Integer.TYPE, FontVariationAxis[].class, Integer.TYPE, Integer.TYPE});
            method3 = cls.getMethod("freeze", new Class[0]);
            method4 = cls.getMethod("abortCreation", new Class[0]);
            declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", new Class[]{Array.newInstance(cls, 1).getClass(), Integer.TYPE, Integer.TYPE});
            declaredMethod.setAccessible(true);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            new StringBuilder("Unable to collect necessary methods for class ").append(e.getClass().getName());
            declaredMethod = null;
            method4 = null;
            method3 = null;
            method2 = null;
            method = null;
            constructor = null;
            cls = null;
        }
        Hh = constructor;
        Hg = cls;
        Hk = method;
        Hl = method2;
        Hm = method3;
        Hn = method4;
        Hj = declaredMethod;
    }

    private static boolean dy() {
        return Hk != null;
    }

    private static Object dx() {
        try {
            return Hh.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Context context, Object obj, String str, int i, int i2) {
        try {
            return ((Boolean) Hk.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), null})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) Hl.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static Typeface q(Object obj) {
        try {
            Array.set(Array.newInstance(Hg, 1), 0, obj);
            return (Typeface) Hj.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean r(Object obj) {
        try {
            return ((Boolean) Hm.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    private static void s(Object obj) {
        try {
            Hn.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public final Typeface a(Context context, b bVar, Resources resources, int i) {
        if (!dy()) {
            return super.a(context, bVar, resources, i);
        }
        Object dx = dx();
        c[] cVarArr = bVar.GN;
        int length = cVarArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            c cVar = cVarArr[i2];
            String str = cVar.mFileName;
            int i4 = cVar.GO;
            if (cVar.GP) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (a(context, dx, str, i4, i3)) {
                i2++;
            } else {
                s(dx);
                return null;
            }
        }
        if (r(dx)) {
            return q(dx);
        }
        return null;
    }

    public final Typeface a(Context context, android.support.v4.d.b.b[] bVarArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (bVarArr.length <= 0) {
            return null;
        }
        if (dy()) {
            Map a = android.support.v4.d.b.a(context, bVarArr);
            Object dx = dx();
            int length = bVarArr.length;
            int i2 = 0;
            Object obj = null;
            while (i2 < length) {
                Object obj2;
                android.support.v4.d.b.b bVar = bVarArr[i2];
                ByteBuffer byteBuffer = (ByteBuffer) a.get(bVar.mUri);
                if (byteBuffer != null) {
                    int i3;
                    int i4 = bVar.Ks;
                    int i5 = bVar.GO;
                    if (bVar.GP) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (a(dx, byteBuffer, i4, i5, i3)) {
                        obj2 = 1;
                    } else {
                        s(dx);
                        return null;
                    }
                }
                obj2 = obj;
                i2++;
                obj = obj2;
            }
            if (obj == null) {
                s(dx);
                return null;
            } else if (r(dx)) {
                return Typeface.create(q(dx), i);
            } else {
                return null;
            }
        }
        android.support.v4.d.b.b a2 = a(bVarArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.mUri, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.GO).setItalic(a2.GP).build();
                if (openFileDescriptor == null) {
                    return build;
                }
                openFileDescriptor.close();
                return build;
            } catch (Throwable th3) {
                th = th3;
                th2 = th;
            }
        } catch (IOException e) {
            return null;
        }
        throw th;
        if (openFileDescriptor != null) {
            if (th2 != null) {
                try {
                    openFileDescriptor.close();
                } catch (Throwable th4) {
                    th2.addSuppressed(th4);
                }
            } else {
                openFileDescriptor.close();
            }
        }
        throw th;
    }

    public final Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!dy()) {
            return super.a(context, resources, i, str, i2);
        }
        Object dx = dx();
        if (!a(context, dx, str, -1, -1)) {
            s(dx);
            return null;
        } else if (r(dx)) {
            return q(dx);
        } else {
            return null;
        }
    }
}
