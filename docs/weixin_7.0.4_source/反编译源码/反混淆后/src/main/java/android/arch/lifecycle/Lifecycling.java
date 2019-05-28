package android.arch.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lifecycling {
    /* renamed from: cw */
    private static Map<Class, Integer> f12cw = new HashMap();
    /* renamed from: cx */
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> f13cx = new HashMap();

    /* renamed from: e */
    static GenericLifecycleObserver m319e(Object obj) {
        int i = 0;
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (m321h(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) f13cx.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(m318a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
            }
            generatedAdapterArr[i2] = m318a((Constructor) list.get(i2), obj);
            i = i2 + 1;
        }
    }

    /* renamed from: a */
    private static GeneratedAdapter m318a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
        try {
            return (GeneratedAdapter) constructor.newInstance(new Object[]{obj});
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: g */
    private static Constructor<? extends GeneratedAdapter> m320g(Class<?> cls) {
        try {
            Package packageR = cls.getPackage();
            String canonicalName = cls.getCanonicalName();
            String name = packageR != null ? packageR.getName() : "";
            if (!name.isEmpty()) {
                canonicalName = canonicalName.substring(name.length() + 1);
            }
            canonicalName = getAdapterName(canonicalName);
            if (!name.isEmpty()) {
                canonicalName = name + "." + canonicalName;
            }
            Constructor<? extends GeneratedAdapter> declaredConstructor = Class.forName(canonicalName).getDeclaredConstructor(new Class[]{cls});
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException e) {
            return null;
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException(e2);
        }
    }

    /* renamed from: h */
    private static int m321h(Class<?> cls) {
        if (f12cw.containsKey(cls)) {
            return ((Integer) f12cw.get(cls)).intValue();
        }
        int i = m322i(cls);
        f12cw.put(cls, Integer.valueOf(i));
        return i;
    }

    /* renamed from: i */
    private static int m322i(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor g = m320g(cls);
        if (g != null) {
            f13cx.put(cls, Collections.singletonList(g));
            return 2;
        } else if (ClassesInfoCache.f4cd.mo284d(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            List list = null;
            if (m323j(superclass)) {
                if (m321h(superclass) == 1) {
                    return 1;
                }
                list = new ArrayList((Collection) f13cx.get(superclass));
            }
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (i < length) {
                List list2;
                Class cls2 = interfaces[i];
                if (!m323j(cls2)) {
                    list2 = list;
                } else if (m321h(cls2) == 1) {
                    return 1;
                } else {
                    if (list == null) {
                        list2 = new ArrayList();
                    } else {
                        list2 = list;
                    }
                    list2.addAll((Collection) f13cx.get(cls2));
                }
                i++;
                list = list2;
            }
            if (list == null) {
                return 1;
            }
            f13cx.put(cls, list);
            return 2;
        }
    }

    /* renamed from: j */
    private static boolean m323j(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static String getAdapterName(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
