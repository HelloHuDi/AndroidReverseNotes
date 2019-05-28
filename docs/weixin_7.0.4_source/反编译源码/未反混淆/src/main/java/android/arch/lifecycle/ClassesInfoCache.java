package android.arch.lifecycle;

import android.arch.lifecycle.Lifecycle.Event;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class ClassesInfoCache {
    static ClassesInfoCache cd = new ClassesInfoCache();
    private final Map<Class, CallbackInfo> ce = new HashMap();
    private final Map<Class, Boolean> cf = new HashMap();

    static class CallbackInfo {
        final Map<Event, List<MethodReference>> cg = new HashMap();
        final Map<MethodReference, Event> ch;

        CallbackInfo(Map<MethodReference, Event> map) {
            this.ch = map;
            for (Entry entry : map.entrySet()) {
                Event event = (Event) entry.getValue();
                List list = (List) this.cg.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.cg.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        static void a(List<MethodReference> list, LifecycleOwner lifecycleOwner, Event event, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    MethodReference methodReference = (MethodReference) list.get(size);
                    try {
                        switch (methodReference.ci) {
                            case 0:
                                methodReference.mMethod.invoke(obj, new Object[0]);
                                break;
                            case 1:
                                methodReference.mMethod.invoke(obj, new Object[]{lifecycleOwner});
                                break;
                            case 2:
                                methodReference.mMethod.invoke(obj, new Object[]{lifecycleOwner, event});
                                break;
                            default:
                                break;
                        }
                        size--;
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException("Failed to call observer method", e.getCause());
                    } catch (IllegalAccessException e2) {
                        throw new RuntimeException(e2);
                    }
                }
            }
        }
    }

    static class MethodReference {
        final int ci;
        final Method mMethod;

        MethodReference(int i, Method method) {
            this.ci = i;
            this.mMethod = method;
            this.mMethod.setAccessible(true);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            MethodReference methodReference = (MethodReference) obj;
            if (this.ci == methodReference.ci && this.mMethod.getName().equals(methodReference.mMethod.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.ci * 31) + this.mMethod.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    /* Access modifiers changed, original: final */
    public final boolean d(Class cls) {
        if (this.cf.containsKey(cls)) {
            return ((Boolean) this.cf.get(cls)).booleanValue();
        }
        Method[] e = e(cls);
        for (Method annotation : e) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                a(cls, e);
                return true;
            }
        }
        this.cf.put(cls, Boolean.FALSE);
        return false;
    }

    private static Method[] e(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* Access modifiers changed, original: final */
    public final CallbackInfo f(Class cls) {
        CallbackInfo callbackInfo = (CallbackInfo) this.ce.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return a(cls, null);
    }

    private static void a(Map<MethodReference, Event> map, MethodReference methodReference, Event event, Class cls) {
        Event event2 = (Event) map.get(methodReference);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + methodReference.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    private CallbackInfo a(Class cls, Method[] methodArr) {
        CallbackInfo f;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            f = f(superclass);
            if (f != null) {
                hashMap.putAll(f.ch);
            }
        }
        for (Class f2 : cls.getInterfaces()) {
            for (Entry entry : f(f2).ch.entrySet()) {
                a(hashMap, (MethodReference) entry.getKey(), (Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = e(cls);
        }
        int length = methodArr.length;
        int i = 0;
        boolean z = false;
        while (i < length) {
            boolean z2;
            Method method = methodArr[i];
            OnLifecycleEvent onLifecycleEvent = (OnLifecycleEvent) method.getAnnotation(OnLifecycleEvent.class);
            if (onLifecycleEvent != null) {
                int i2;
                Class[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i2 = 0;
                } else if (parameterTypes[0].isAssignableFrom(LifecycleOwner.class)) {
                    i2 = 1;
                } else {
                    throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                }
                Event value = onLifecycleEvent.value();
                if (parameterTypes.length > 1) {
                    if (!parameterTypes[1].isAssignableFrom(Event.class)) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    } else if (value != Event.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    } else {
                        i2 = 2;
                    }
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                a(hashMap, new MethodReference(i2, method), value, cls);
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        f = new CallbackInfo(hashMap);
        this.ce.put(cls, f);
        this.cf.put(cls, Boolean.valueOf(z));
        return f;
    }
}
