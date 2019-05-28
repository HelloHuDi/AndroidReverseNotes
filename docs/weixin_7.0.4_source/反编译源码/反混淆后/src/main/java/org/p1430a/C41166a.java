package org.p1430a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/* renamed from: org.a.a */
public final class C41166a {
    private final Class<?> BYD;
    public final Object object;

    /* renamed from: org.a.a$a */
    static class C31202a {
        private C31202a() {
        }
    }

    /* renamed from: be */
    public static C41166a m71619be(Class<?> cls) {
        AppMethodBeat.m2504i(59244);
        C41166a c41166a = new C41166a(cls);
        AppMethodBeat.m2505o(59244);
        return c41166a;
    }

    /* renamed from: ep */
    public static C41166a m71622ep(Object obj) {
        AppMethodBeat.m2504i(59245);
        C41166a c41166a = new C41166a(obj == null ? Object.class : obj.getClass(), obj);
        AppMethodBeat.m2505o(59245);
        return c41166a;
    }

    /* renamed from: d */
    private static C41166a m71621d(Class<?> cls, Object obj) {
        AppMethodBeat.m2504i(59246);
        C41166a c41166a = new C41166a(cls, obj);
        AppMethodBeat.m2505o(59246);
        return c41166a;
    }

    /* renamed from: a */
    private static <T extends AccessibleObject> T m71612a(T t) {
        AppMethodBeat.m2504i(59247);
        if (t == null) {
            AppMethodBeat.m2505o(59247);
            return null;
        }
        if (t instanceof Member) {
            Member member = (Member) t;
            if (Modifier.isPublic(member.getModifiers()) && Modifier.isPublic(member.getDeclaringClass().getModifiers())) {
                AppMethodBeat.m2505o(59247);
                return t;
            }
        }
        if (!t.isAccessible()) {
            t.setAccessible(true);
        }
        AppMethodBeat.m2505o(59247);
        return t;
    }

    private C41166a(Class<?> cls) {
        this(cls, cls);
        AppMethodBeat.m2504i(59248);
        AppMethodBeat.m2505o(59248);
    }

    private C41166a(Class<?> cls, Object obj) {
        this.BYD = cls;
        this.object = obj;
    }

    public final <T> T get(String str) {
        AppMethodBeat.m2504i(59249);
        Object obj = awS(str).object;
        AppMethodBeat.m2505o(59249);
        return obj;
    }

    public final C41166a awS(String str) {
        AppMethodBeat.m2504i(59250);
        try {
            Field awT = awT(str);
            C41166a d = C41166a.m71621d(awT.getType(), awT.get(this.object));
            AppMethodBeat.m2505o(59250);
            return d;
        } catch (Exception e) {
            C46853b c46853b = new C46853b(e);
            AppMethodBeat.m2505o(59250);
            throw c46853b;
        }
    }

    /* renamed from: u */
    public final C41166a mo65761u(String str, Object... objArr) {
        C41166a a;
        NoSuchMethodException noSuchMethodException;
        AppMethodBeat.m2504i(59252);
        Class[] ac = C41166a.m71618ac(objArr);
        try {
            a = C41166a.m71615a(m71613a(str, ac), this.object, objArr);
            AppMethodBeat.m2505o(59252);
        } catch (NoSuchMethodException e) {
            Class cls = this.BYD;
            for (Method method : cls.getMethods()) {
                if (C41166a.m71616a(method, str, ac)) {
                    break;
                }
            }
            Class cls2 = cls;
            loop1:
            while (true) {
                for (Method method2 : cls2.getDeclaredMethods()) {
                    if (C41166a.m71616a(method2, str, ac)) {
                        break loop1;
                    }
                }
                Class superclass = cls2.getSuperclass();
                if (superclass == null) {
                    noSuchMethodException = new NoSuchMethodException("No similar method " + str + " with params " + Arrays.toString(ac) + " could be found on type " + this.BYD + ".");
                    AppMethodBeat.m2505o(59252);
                    throw noSuchMethodException;
                }
                cls2 = superclass;
            }
            a = C41166a.m71615a(method2, this.object, objArr);
            AppMethodBeat.m2505o(59252);
        } catch (NoSuchMethodException noSuchMethodException2) {
            C46853b c46853b = new C46853b(noSuchMethodException2);
            AppMethodBeat.m2505o(59252);
            throw c46853b;
        }
        return a;
    }

    /* renamed from: a */
    private static boolean m71616a(Method method, String str, Class<?>[] clsArr) {
        AppMethodBeat.m2504i(59254);
        if (method.getName().equals(str) && C41166a.m71617a(method.getParameterTypes(), (Class[]) clsArr)) {
            AppMethodBeat.m2505o(59254);
            return true;
        }
        AppMethodBeat.m2505o(59254);
        return false;
    }

    /* renamed from: ab */
    public final C41166a mo65755ab(Object... objArr) {
        AppMethodBeat.m2504i(59255);
        Class[] ac = C41166a.m71618ac(objArr);
        C41166a a;
        try {
            a = C41166a.m71614a(this.BYD.getDeclaredConstructor(ac), objArr);
            AppMethodBeat.m2505o(59255);
            return a;
        } catch (NoSuchMethodException e) {
            for (Constructor constructor : this.BYD.getDeclaredConstructors()) {
                if (C41166a.m71617a(constructor.getParameterTypes(), ac)) {
                    a = C41166a.m71614a(constructor, objArr);
                    AppMethodBeat.m2505o(59255);
                    return a;
                }
            }
            C46853b c46853b = new C46853b(e);
            AppMethodBeat.m2505o(59255);
            throw c46853b;
        }
    }

    /* renamed from: a */
    private static boolean m71617a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        AppMethodBeat.m2504i(59256);
        if (clsArr.length == clsArr2.length) {
            int i = 0;
            while (i < clsArr2.length) {
                if (clsArr2[i] == C31202a.class || C41166a.m71620bf(clsArr[i]).isAssignableFrom(C41166a.m71620bf(clsArr2[i]))) {
                    i++;
                } else {
                    AppMethodBeat.m2505o(59256);
                    return false;
                }
            }
            AppMethodBeat.m2505o(59256);
            return true;
        }
        AppMethodBeat.m2505o(59256);
        return false;
    }

    public final int hashCode() {
        AppMethodBeat.m2504i(59257);
        int hashCode = this.object.hashCode();
        AppMethodBeat.m2505o(59257);
        return hashCode;
    }

    public final boolean equals(Object obj) {
        AppMethodBeat.m2504i(59258);
        if (obj instanceof C41166a) {
            boolean equals = this.object.equals(((C41166a) obj).object);
            AppMethodBeat.m2505o(59258);
            return equals;
        }
        AppMethodBeat.m2505o(59258);
        return false;
    }

    public final String toString() {
        AppMethodBeat.m2504i(59259);
        String obj = this.object.toString();
        AppMethodBeat.m2505o(59259);
        return obj;
    }

    /* renamed from: a */
    private static C41166a m71614a(Constructor<?> constructor, Object... objArr) {
        AppMethodBeat.m2504i(59260);
        try {
            C41166a d = C41166a.m71621d(constructor.getDeclaringClass(), ((Constructor) C41166a.m71612a(constructor)).newInstance(objArr));
            AppMethodBeat.m2505o(59260);
            return d;
        } catch (Exception e) {
            C46853b c46853b = new C46853b(e);
            AppMethodBeat.m2505o(59260);
            throw c46853b;
        }
    }

    /* renamed from: a */
    private static C41166a m71615a(Method method, Object obj, Object... objArr) {
        AppMethodBeat.m2504i(59261);
        try {
            C41166a ep;
            C41166a.m71612a(method);
            if (method.getReturnType() == Void.TYPE) {
                method.invoke(obj, objArr);
                ep = C41166a.m71622ep(obj);
                AppMethodBeat.m2505o(59261);
            } else {
                ep = C41166a.m71622ep(method.invoke(obj, objArr));
                AppMethodBeat.m2505o(59261);
            }
            return ep;
        } catch (Exception e) {
            C46853b c46853b = new C46853b(e);
            AppMethodBeat.m2505o(59261);
            throw c46853b;
        }
    }

    /* renamed from: ac */
    private static Class<?>[] m71618ac(Object... objArr) {
        int i = 0;
        AppMethodBeat.m2504i(59262);
        if (objArr == null) {
            Class[] clsArr = new Class[0];
            AppMethodBeat.m2505o(59262);
            return clsArr;
        }
        Class<?>[] clsArr2 = new Class[objArr.length];
        while (i < objArr.length) {
            Object obj = objArr[i];
            clsArr2[i] = obj == null ? C31202a.class : obj.getClass();
            i++;
        }
        AppMethodBeat.m2505o(59262);
        return clsArr2;
    }

    /* renamed from: bf */
    private static Class<?> m71620bf(Class<?> cls) {
        AppMethodBeat.m2504i(59263);
        if (cls == null) {
            AppMethodBeat.m2505o(59263);
            return null;
        }
        if (cls.isPrimitive()) {
            if (Boolean.TYPE == cls) {
                cls = Boolean.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Integer.TYPE == cls) {
                cls = Integer.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Long.TYPE == cls) {
                cls = Long.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Short.TYPE == cls) {
                cls = Short.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Byte.TYPE == cls) {
                cls = Byte.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Double.TYPE == cls) {
                cls = Double.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Float.TYPE == cls) {
                cls = Float.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Character.TYPE == cls) {
                cls = Character.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            } else if (Void.TYPE == cls) {
                cls = Void.class;
                AppMethodBeat.m2505o(59263);
                return cls;
            }
        }
        AppMethodBeat.m2505o(59263);
        return cls;
    }

    private Field awT(String str) {
        Field field;
        AppMethodBeat.m2504i(59251);
        Class cls = this.BYD;
        try {
            field = (Field) C41166a.m71612a(cls.getField(str));
            AppMethodBeat.m2505o(59251);
        } catch (NoSuchFieldException e) {
            Throwable th = e;
            while (true) {
                try {
                    field = (Field) C41166a.m71612a(cls.getDeclaredField(str));
                    AppMethodBeat.m2505o(59251);
                    break;
                } catch (NoSuchFieldException e2) {
                    Class superclass = cls.getSuperclass();
                    if (superclass == null) {
                        C46853b c46853b = new C46853b(th);
                        AppMethodBeat.m2505o(59251);
                        throw c46853b;
                    }
                    cls = superclass;
                }
            }
        }
        return field;
    }

    /* renamed from: a */
    private Method m71613a(String str, Class<?>[] clsArr) {
        Method method;
        NoSuchMethodException noSuchMethodException;
        AppMethodBeat.m2504i(59253);
        Class cls = this.BYD;
        try {
            method = cls.getMethod(str, clsArr);
            AppMethodBeat.m2505o(59253);
        } catch (NoSuchMethodException e) {
            do {
                try {
                    method = cls.getDeclaredMethod(str, clsArr);
                    AppMethodBeat.m2505o(59253);
                } catch (NoSuchMethodException e2) {
                    cls = cls.getSuperclass();
                    if (cls == null) {
                        noSuchMethodException = new NoSuchMethodException();
                        AppMethodBeat.m2505o(59253);
                        throw noSuchMethodException;
                    }
                }
            } while (cls == null);
            noSuchMethodException = new NoSuchMethodException();
            AppMethodBeat.m2505o(59253);
            throw noSuchMethodException;
        }
        return method;
    }
}
