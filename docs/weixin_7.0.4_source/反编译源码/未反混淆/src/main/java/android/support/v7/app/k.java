package android.support.v7.app;

import android.content.res.Resources;
import android.util.LongSparseArray;
import java.lang.reflect.Field;
import java.util.Map;

final class k {
    private static Field Wc;
    private static boolean Wd;
    private static Class We;
    private static boolean Wf;
    private static Field Wg;
    private static boolean Wh;
    private static Field Wi;
    private static boolean Wj;

    static boolean a(Resources resources) {
        if (!Wd) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                Wc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Wd = true;
        }
        if (Wc != null) {
            Map map;
            try {
                map = (Map) Wc.get(resources);
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

    static boolean b(Resources resources) {
        if (!Wd) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mDrawableCache");
                Wc = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Wd = true;
        }
        Object obj = null;
        if (Wc != null) {
            try {
                obj = Wc.get(resources);
            } catch (IllegalAccessException e2) {
            }
        }
        if (obj == null || obj == null || !M(obj)) {
            return false;
        }
        return true;
    }

    static boolean c(Resources resources) {
        Object obj = null;
        if (!Wj) {
            try {
                Field declaredField = Resources.class.getDeclaredField("mResourcesImpl");
                Wi = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            Wj = true;
        }
        if (Wi == null) {
            return false;
        }
        Object obj2;
        try {
            obj2 = Wi.get(resources);
        } catch (IllegalAccessException e2) {
            obj2 = obj;
        }
        if (obj2 == null) {
            return false;
        }
        if (!Wd) {
            try {
                Field declaredField2 = obj2.getClass().getDeclaredField("mDrawableCache");
                Wc = declaredField2;
                declaredField2.setAccessible(true);
            } catch (NoSuchFieldException e3) {
            }
            Wd = true;
        }
        if (Wc != null) {
            try {
                obj = Wc.get(obj2);
            } catch (IllegalAccessException e4) {
            }
        }
        if (obj == null || !M(obj)) {
            return false;
        }
        return true;
    }

    private static boolean M(Object obj) {
        if (!Wf) {
            try {
                We = Class.forName("android.content.res.ThemedResourceCache");
            } catch (ClassNotFoundException e) {
            }
            Wf = true;
        }
        if (We == null) {
            return false;
        }
        if (!Wh) {
            try {
                Field declaredField = We.getDeclaredField("mUnthemedEntries");
                Wg = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException e2) {
            }
            Wh = true;
        }
        if (Wg == null) {
            return false;
        }
        LongSparseArray longSparseArray;
        try {
            longSparseArray = (LongSparseArray) Wg.get(obj);
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
