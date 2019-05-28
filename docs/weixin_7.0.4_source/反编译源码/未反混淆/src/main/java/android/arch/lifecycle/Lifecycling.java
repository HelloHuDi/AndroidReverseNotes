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
    private static Map<Class, Integer> cw = new HashMap();
    private static Map<Class, List<Constructor<? extends GeneratedAdapter>>> cx = new HashMap();

    static GenericLifecycleObserver e(Object obj) {
        int i = 0;
        if (obj instanceof FullLifecycleObserver) {
            return new FullLifecycleObserverAdapter((FullLifecycleObserver) obj);
        }
        if (obj instanceof GenericLifecycleObserver) {
            return (GenericLifecycleObserver) obj;
        }
        Class cls = obj.getClass();
        if (h(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(obj);
        }
        List list = (List) cx.get(cls);
        if (list.size() == 1) {
            return new SingleGeneratedAdapterObserver(a((Constructor) list.get(0), obj));
        }
        GeneratedAdapter[] generatedAdapterArr = new GeneratedAdapter[list.size()];
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                return new CompositeGeneratedAdaptersObserver(generatedAdapterArr);
            }
            generatedAdapterArr[i2] = a((Constructor) list.get(i2), obj);
            i = i2 + 1;
        }
    }

    private static GeneratedAdapter a(Constructor<? extends GeneratedAdapter> constructor, Object obj) {
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

    private static Constructor<? extends GeneratedAdapter> g(Class<?> cls) {
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

    private static int h(Class<?> cls) {
        if (cw.containsKey(cls)) {
            return ((Integer) cw.get(cls)).intValue();
        }
        int i = i(cls);
        cw.put(cls, Integer.valueOf(i));
        return i;
    }

    private static int i(Class<?> cls) {
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor g = g(cls);
        if (g != null) {
            cx.put(cls, Collections.singletonList(g));
            return 2;
        } else if (ClassesInfoCache.cd.d(cls)) {
            return 1;
        } else {
            Class superclass = cls.getSuperclass();
            List list = null;
            if (j(superclass)) {
                if (h(superclass) == 1) {
                    return 1;
                }
                list = new ArrayList((Collection) cx.get(superclass));
            }
            Class[] interfaces = cls.getInterfaces();
            int length = interfaces.length;
            int i = 0;
            while (i < length) {
                List list2;
                Class cls2 = interfaces[i];
                if (!j(cls2)) {
                    list2 = list;
                } else if (h(cls2) == 1) {
                    return 1;
                } else {
                    if (list == null) {
                        list2 = new ArrayList();
                    } else {
                        list2 = list;
                    }
                    list2.addAll((Collection) cx.get(cls2));
                }
                i++;
                list = list2;
            }
            if (list == null) {
                return 1;
            }
            cx.put(cls, list);
            return 2;
        }
    }

    private static boolean j(Class<?> cls) {
        return cls != null && LifecycleObserver.class.isAssignableFrom(cls);
    }

    public static String getAdapterName(String str) {
        return str.replace(".", "_") + "_LifecycleAdapter";
    }
}
