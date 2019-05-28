package com.tencent.tinker.loader.shareutil;

import android.content.Context;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ShareReflectUtil {
    /* renamed from: b */
    public static Field m9395b(Object obj, String str) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Field declaredField = cls.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + obj.getClass());
    }

    /* renamed from: d */
    public static Field m9400d(Class<?> cls, String str) {
        Class cls2 = cls;
        while (cls2 != null) {
            try {
                Field declaredField = cls2.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException e) {
                cls2 = cls2.getSuperclass();
            }
        }
        throw new NoSuchFieldException("Field " + str + " not found in " + cls);
    }

    /* renamed from: b */
    public static Method m9396b(Object obj, String str, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* renamed from: c */
    public static Method m9398c(Class<?> cls, String str, Class<?>... clsArr) {
        Class cls2;
        while (cls2 != null) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                cls2 = cls2.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Method " + str + " with parameters " + Arrays.asList(clsArr) + " not found in " + cls2);
    }

    /* renamed from: a */
    public static Constructor<?> m9393a(Object obj, Class<?>... clsArr) {
        Class cls = obj.getClass();
        while (cls != null) {
            try {
                Constructor declaredConstructor = cls.getDeclaredConstructor(clsArr);
                if (!declaredConstructor.isAccessible()) {
                    declaredConstructor.setAccessible(true);
                }
                return declaredConstructor;
            } catch (NoSuchMethodException e) {
                cls = cls.getSuperclass();
            }
        }
        throw new NoSuchMethodException("Constructor with parameters " + Arrays.asList(clsArr) + " not found in " + obj.getClass());
    }

    /* renamed from: b */
    public static void m9397b(Object obj, String str, Object[] objArr) {
        Field b = m9395b(obj, str);
        Object[] objArr2 = (Object[]) b.get(obj);
        Object[] objArr3 = (Object[]) Array.newInstance(objArr2.getClass().getComponentType(), objArr2.length + objArr.length);
        System.arraycopy(objArr, 0, objArr3, 0, objArr.length);
        System.arraycopy(objArr2, 0, objArr3, objArr.length, objArr2.length);
        b.set(obj, objArr3);
    }

    /* renamed from: a */
    public static void m9394a(Object obj, String str, int i) {
        if (i > 0) {
            Field b = m9395b(obj, str);
            Object[] objArr = (Object[]) b.get(obj);
            int length = objArr.length - i;
            if (length > 0) {
                Object[] objArr2 = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), length);
                System.arraycopy(objArr, i, objArr2, 0, length);
                b.set(obj, objArr2);
            }
        }
    }

    /* renamed from: d */
    public static Object m9399d(Context context, Class<?> cls) {
        Class cls2;
        if (cls2 == null) {
            try {
                cls2 = Class.forName("android.app.ActivityThread");
            } catch (Throwable th) {
                return null;
            }
        }
        Method method = cls2.getMethod("currentActivityThread", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        if (invoke != null || context == null) {
            return invoke;
        }
        Field field = context.getClass().getField("mLoadedApk");
        field.setAccessible(true);
        invoke = field.get(context);
        Field declaredField = invoke.getClass().getDeclaredField("mActivityThread");
        declaredField.setAccessible(true);
        return declaredField.get(invoke);
    }

    /* renamed from: e */
    public static int m9401e(Class<?> cls, String str) {
        try {
            return m9400d((Class) cls, str).getInt(null);
        } catch (Throwable th) {
            return 0;
        }
    }
}
