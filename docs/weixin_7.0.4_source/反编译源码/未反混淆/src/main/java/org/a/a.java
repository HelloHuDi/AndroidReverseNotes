package org.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public final class a {
    private final Class<?> BYD;
    public final Object object;

    static class a {
        private a() {
        }
    }

    public static a be(Class<?> cls) {
        AppMethodBeat.i(59244);
        a aVar = new a(cls);
        AppMethodBeat.o(59244);
        return aVar;
    }

    public static a ep(Object obj) {
        AppMethodBeat.i(59245);
        a aVar = new a(obj == null ? Object.class : obj.getClass(), obj);
        AppMethodBeat.o(59245);
        return aVar;
    }

    private static a d(Class<?> cls, Object obj) {
        AppMethodBeat.i(59246);
        a aVar = new a(cls, obj);
        AppMethodBeat.o(59246);
        return aVar;
    }

    private static <T extends AccessibleObject> T a(T t) {
        AppMethodBeat.i(59247);
        if (t == null) {
            AppMethodBeat.o(59247);
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                AppMethodBeat.o(59247);
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        AppMethodBeat.o(59247);
        return t;
    }

    private a(Class<?> cls) {
        this(cls, cls);
        AppMethodBeat.i(59248);
        AppMethodBeat.o(59248);
    }

    private a(Class<?> cls, Object obj) {
        this.BYD = cls;
        this.object = obj;
    }

    public final <T> T get(String str) {
        AppMethodBeat.i(59249);
        Object obj = awS(str).object;
        AppMethodBeat.o(59249);
        return obj;
    }

    public final a awS(String str) {
        AppMethodBeat.i(59250);
        try {
            Field awT = awT(str);
            a d = d(awT.getType(), awT.get(this.object));
            AppMethodBeat.o(59250);
            return d;
        } catch (Exception e) {
            b bVar = new b(e);
            AppMethodBeat.o(59250);
            throw bVar;
        }
    }

    public final a u(String str, Object... objArr) {
        a a;
        NoSuchMethodException noSuchMethodException;
        AppMethodBeat.i(59252);
        Class[] ac = ac(objArr);
        try {
            a = a(a(str, ac), this.object, objArr);
            AppMethodBeat.o(59252);
        } catch (NoSuchMethodException e) {
            Class cls = this.BYD;
            for (Method method : cls.getMethods()) {
                if (a(method, str, ac)) {
                    break;
                }
            }
            Class cls2 = cls;
            loop1:
            while (true) {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (a(method2, str, ac)) {
                        break loop1;
                    }
                }
                Class superclass = cls2.getSuperclass();
                if (superclass == null) {
                    noSuchMethodException = new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(ac) + " could be found on type " + this.BYD + ".");
                    AppMethodBeat.o(59252);
                    throw noSuchMethodException;
                }
                cls2 = superclass;
            }
            a = a(method2, this.object, objArr);
            AppMethodBeat.o(59252);
        } catch (NoSuchMethodException noSuchMethodException2) {
            b bVar = new b(noSuchMethodException2);
            AppMethodBeat.o(59252);
            throw bVar;
        }
        return a;
    }

    private static boolean a(Method method, String str, Class<?>[] clsArr) {
        AppMethodBeat.i(59254);
        if (method.getName().equals(str) && a(method.getParameterTypes(), (Class[]) clsArr)) {
            AppMethodBeat.o(59254);
            return true;
        }
        AppMethodBeat.o(59254);
        return false;
    }

    public final a ab(Object... objArr) {
        AppMethodBeat.i(59255);
        Class[] ac = ac(objArr);
        a a;
        try {
            a = a(this.BYD.getDeclaredConstructor(ac), objArr);
            AppMethodBeat.o(59255);
            return a;
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : this.BYD.getDeclaredConstructors()) {
                if (a(constructor.getParameterTypes(), ac)) {
                    a = a(constructor, objArr);
                    AppMethodBeat.o(59255);
                    return a;
                }
            }
            b bVar = new b(e);
            AppMethodBeat.o(59255);
            throw bVar;
        }
    }

    private static boolean a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        AppMethodBeat.i(59256);
        if (clsArr.length == clsArr2.length) {
            int i = 0;
            while (i < clsArr2.length) {
                if (clsArr2[i] == a.class || bf(clsArr[i]).isAssignableFrom(bf(clsArr2[i]))) {
                    i++;
                } else {
                    AppMethodBeat.o(59256);
                    return false;
                }
            }
            AppMethodBeat.o(59256);
            return true;
        }
        AppMethodBeat.o(59256);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.i(59257);
        int hashCode = this.object.hashCode();
        AppMethodBeat.o(59257);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.i(59258);
        if (obj instanceof a) {
            boolean equals = this.object.equals(((a) obj).object);
            AppMethodBeat.o(59258);
            return equals;
        }
        AppMethodBeat.o(59258);
        return false;
    }

    public final String toString() {
        AppMethodBeat.i(59259);
        String obj = this.object.toString();
        AppMethodBeat.o(59259);
        return obj;
    }

    private static a a(Constructor<?> constructor, Object... objArr) {
        AppMethodBeat.i(59260);
        try {
            a d = d(constructor.getDeclaringClass(), ((Constructor) a(constructor)).newInstance(objArr));
            AppMethodBeat.o(59260);
            return d;
        } catch (Exception e) {
            b bVar = new b(e);
            AppMethodBeat.o(59260);
            throw bVar;
        }
    }

    private static a a(Method method, Object obj, Object... objArr) {
        AppMethodBeat.i(59261);
        try {
            a ep;
            a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                ep = ep(obj);
                AppMethodBeat.o(59261);
            } else {
                ep = ep(method.invoke(obj, objArr));
                AppMethodBeat.o(59261);
            }
            return ep;
        } catch (Exception e) {
            b bVar = new b(e);
            AppMethodBeat.o(59261);
            throw bVar;
        }
    }

    private static Class<?>[] ac(Object... objArr) {
        int i = 0;
        AppMethodBeat.i(59262);
        if (objArr == null) {
            Class[] clsArr = new Class[0];
            AppMethodBeat.o(59262);
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[objArr.length];
        while (i < objArr.length) {
            Object obj = objArr[i];
            clsArr2[i] = obj == null ? a.class : obj.getClass();
            i++;
        }
        AppMethodBeat.o(59262);
        return clsArr2;
    }

    private static Class<?> bf(Class<?> cls) {
        AppMethodBeat.i(59263);
        if (cls == null) {
            AppMethodBeat.o(59263);
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                cls = Boolean.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Integer.TYPE == cls) {
                cls = Integer.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Long.TYPE == cls) {
                cls = Long.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Short.TYPE == cls) {
                cls = Short.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Byte.TYPE == cls) {
                cls = Byte.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Double.TYPE == cls) {
                cls = Double.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Float.TYPE == cls) {
                cls = Float.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Character.TYPE == cls) {
                cls = Character.class;
                AppMethodBeat.o(59263);
                return cls;
            } else if (Void.TYPE == cls) {
                cls = Void.class;
                AppMethodBeat.o(59263);
                return cls;
            }
        }
        AppMethodBeat.o(59263);
        return cls;
    }

    private Field awT(String str) {
        Field field;
        AppMethodBeat.i(59251);
        Class cls = this.BYD;
        try {
            field = (Field) a(cls.getField(str));
            AppMethodBeat.o(59251);
        } catch (NoSuchFieldException e) {
            Throwable th = e;
            while (true) {
                try {
                    field = (Field) a(cls.getDeclaredField(str));
                    AppMethodBeat.o(59251);
                    break;
                } catch (NoSuchFieldException e2) {
                    Class superclass = cls.getSuperclass();
                    if (superclass == null) {
                        b bVar = new b(th);
                        AppMethodBeat.o(59251);
                        throw bVar;
                    }
                    cls = superclass;
                }
            }
        }
        return field;
    }

    private Method a(String str, Class<?>[] clsArr) {
        Method method;
        NoSuchMethodException noSuchMethodException;
        AppMethodBeat.i(59253);
        Class cls = this.BYD;
        try {
            method = cls.getMethod(str, clsArr);
            AppMethodBeat.o(59253);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    AppMethodBeat.o(59253);
                } catch (NoSuchMethodException e2) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        noSuchMethodException = new NoSuchMethodException();
                        AppMethodBeat.o(59253);
                        throw noSuchMethodException;
                    }
                }
            } while (cls == null);
            noSuchMethodException = new NoSuchMethodException();
            AppMethodBeat.o(59253);
            throw noSuchMethodException;
        }
        return method;
    }
}
