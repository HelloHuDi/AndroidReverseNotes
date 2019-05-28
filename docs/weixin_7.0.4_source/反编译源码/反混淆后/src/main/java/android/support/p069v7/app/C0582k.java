package android.support.p069v7.app;

import android.content.res.Resources;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

/* renamed from: android.support.v7.app.k */
final class C0582k {
    /* renamed from: Wc */
    private static Field f883Wc;
    /* renamed from: Wd */
    private static boolean f884Wd;
    /* renamed from: We */
    private static Class f885We;
    /* renamed from: Wf */
    private static boolean f886Wf;
    /* renamed from: Wg */
    private static Field f887Wg;
    /* renamed from: Wh */
    private static boolean f888Wh;
    /* renamed from: Wi */
    private static Field f889Wi;
    /* renamed from: Wj */
    private static boolean f890Wj;

    /* renamed from: a */
    static boolean m1263a(Resources resources) {
        if (!f884Wd) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f883Wc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f884Wd = true;
        }
        if (f883Wc != null) {
            Map map;
            try {
                map = (Map) f883Wc.get(resources);
            } catch (IllegalAccessException e2) {
                map = null;
            }
            if (map != null) {
                map.clear();
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static boolean m1264b(Resources resources) {
        if (!f884Wd) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                f883Wc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f884Wd = true;
        }
        Object obj = null;
        if (f883Wc != null) {
            try {
                obj = f883Wc.get(resources);
            } catch (IllegalAccessException e2) {
            }
        }
        if (obj == null || obj == null || !C0582k.m1262M(obj)) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    static boolean m1265c(Resources resources) {
        Object obj = null;
        if (!f890Wj) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                f889Wi = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f890Wj = true;
        }
        if (f889Wi == null) {
            return false;
        }
        Object obj2;
        try {
            obj2 = f889Wi.get(resources);
        } catch (IllegalAccessException e2) {
            obj2 = obj;
        }
        if (obj2 == null) {
            return false;
        }
        if (!f884Wd) {
            try {
                Field declaredField2 = obj2.getClass().getDeclaredField("mDrawableCache");
                f883Wc = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e3) {
            }
            f884Wd = true;
        }
        if (f883Wc != null) {
            try {
                obj = f883Wc.get(obj2);
            } catch (IllegalAccessException e4) {
            }
        }
        if (obj == null || !C0582k.m1262M(obj)) {
            return false;
        }
        return true;
    }

    /* renamed from: M */
    private static boolean m1262M(Object obj) {
        if (!f886Wf) {
            try {
                f885We = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
            }
            f886Wf = true;
        }
        if (f885We == null) {
            return false;
        }
        if (!f888Wh) {
            try {
                Field declaredField = f885We.getDeclaredField("mUnthemedEntries");
                f887Wg = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            f888Wh = true;
        }
        if (f887Wg == null) {
            return false;
        }
        LongSparseArray longSparseArray;
        try {
            longSparseArray = (LongSparseArray) f887Wg.get(obj);
        } catch (IllegalAccessException e3) {
            longSparseArray = null;
        }
        if (longSparseArray == null) {
            return false;
        }
        longSparseArray.clear();
        return true;
    }
}
