package android.support.p057v4.p058a;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.Builder;
import android.graphics.fonts.FontVariationAxis;
import android.os.ParcelFileDescriptor;
import android.support.p057v4.content.p062a.C0372a.C0371c;
import android.support.p057v4.content.p062a.C0372a.C0373b;
import android.support.p057v4.p063d.C0391b;
import android.support.p057v4.p063d.C0391b.C0389b;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Map;

/* renamed from: android.support.v4.a.g */
public final class C7588g extends C7447e {
    /* renamed from: Hg */
    private static final Class f2117Hg;
    /* renamed from: Hh */
    private static final Constructor f2118Hh;
    /* renamed from: Hj */
    private static final Method f2119Hj;
    /* renamed from: Hk */
    private static final Method f2120Hk;
    /* renamed from: Hl */
    private static final Method f2121Hl;
    /* renamed from: Hm */
    private static final Method f2122Hm;
    /* renamed from: Hn */
    private static final Method f2123Hn;

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
        f2118Hh = constructor;
        f2117Hg = cls;
        f2120Hk = method;
        f2121Hl = method2;
        f2122Hm = method3;
        f2123Hn = method4;
        f2119Hj = declaredMethod;
    }

    /* renamed from: dy */
    private static boolean m13503dy() {
        return f2120Hk != null;
    }

    /* renamed from: dx */
    private static Object m13502dx() {
        try {
            return f2118Hh.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m13500a(Context context, Object obj, String str, int i, int i2) {
        try {
            return ((Boolean) f2120Hk.invoke(obj, new Object[]{context.getAssets(), str, Integer.valueOf(0), Boolean.FALSE, Integer.valueOf(0), Integer.valueOf(i), Integer.valueOf(i2), null})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    private static boolean m13501a(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) f2121Hl.invoke(obj, new Object[]{byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3)})).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: q */
    private static Typeface m13504q(Object obj) {
        try {
            Array.set(Array.newInstance(f2117Hg, 1), 0, obj);
            return (Typeface) f2119Hj.invoke(null, new Object[]{r0, Integer.valueOf(-1), Integer.valueOf(-1)});
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: r */
    private static boolean m13505r(Object obj) {
        try {
            return ((Boolean) f2122Hm.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: s */
    private static void m13506s(Object obj) {
        try {
            f2123Hn.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public final Typeface mo466a(Context context, C0373b c0373b, Resources resources, int i) {
        if (!C7588g.m13503dy()) {
            return super.mo466a(context, c0373b, resources, i);
        }
        Object dx = C7588g.m13502dx();
        C0371c[] c0371cArr = c0373b.f420GN;
        int length = c0371cArr.length;
        int i2 = 0;
        while (i2 < length) {
            int i3;
            C0371c c0371c = c0371cArr[i2];
            String str = c0371c.mFileName;
            int i4 = c0371c.f417GO;
            if (c0371c.f418GP) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            if (C7588g.m13500a(context, dx, str, i4, i3)) {
                i2++;
            } else {
                C7588g.m13506s(dx);
                return null;
            }
        }
        if (C7588g.m13505r(dx)) {
            return C7588g.m13504q(dx);
        }
        return null;
    }

    /* renamed from: a */
    public final Typeface mo467a(Context context, C0389b[] c0389bArr, int i) {
        ParcelFileDescriptor openFileDescriptor;
        Throwable th;
        Throwable th2;
        if (c0389bArr.length <= 0) {
            return null;
        }
        if (C7588g.m13503dy()) {
            Map a = C0391b.m659a(context, c0389bArr);
            Object dx = C7588g.m13502dx();
            int length = c0389bArr.length;
            int i2 = 0;
            Object obj = null;
            while (i2 < length) {
                Object obj2;
                C0389b c0389b = c0389bArr[i2];
                ByteBuffer byteBuffer = (ByteBuffer) a.get(c0389b.mUri);
                if (byteBuffer != null) {
                    int i3;
                    int i4 = c0389b.f441Ks;
                    int i5 = c0389b.f438GO;
                    if (c0389b.f439GP) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    if (C7588g.m13501a(dx, byteBuffer, i4, i5, i3)) {
                        obj2 = 1;
                    } else {
                        C7588g.m13506s(dx);
                        return null;
                    }
                }
                obj2 = obj;
                i2++;
                obj = obj2;
            }
            if (obj == null) {
                C7588g.m13506s(dx);
                return null;
            } else if (C7588g.m13505r(dx)) {
                return Typeface.create(C7588g.m13504q(dx), i);
            } else {
                return null;
            }
        }
        C0389b a2 = mo13752a(c0389bArr, i);
        try {
            openFileDescriptor = context.getContentResolver().openFileDescriptor(a2.mUri, "r", null);
            if (openFileDescriptor == null) {
                if (openFileDescriptor != null) {
                    openFileDescriptor.close();
                }
                return null;
            }
            try {
                Typeface build = new Builder(openFileDescriptor.getFileDescriptor()).setWeight(a2.f438GO).setItalic(a2.f439GP).build();
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

    /* renamed from: a */
    public final Typeface mo465a(Context context, Resources resources, int i, String str, int i2) {
        if (!C7588g.m13503dy()) {
            return super.mo465a(context, resources, i, str, i2);
        }
        Object dx = C7588g.m13502dx();
        if (!C7588g.m13500a(context, dx, str, -1, -1)) {
            C7588g.m13506s(dx);
            return null;
        } else if (C7588g.m13505r(dx)) {
            return C7588g.m13504q(dx);
        } else {
            return null;
        }
    }
}
