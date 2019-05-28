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
    /* renamed from: cd */
    static ClassesInfoCache f4cd = new ClassesInfoCache();
    /* renamed from: ce */
    private final Map<Class, CallbackInfo> f5ce = new HashMap();
    /* renamed from: cf */
    private final Map<Class, Boolean> f6cf = new HashMap();

    static class CallbackInfo {
        /* renamed from: cg */
        final Map<Event, List<MethodReference>> f1cg = new HashMap();
        /* renamed from: ch */
        final Map<MethodReference, Event> f2ch;

        CallbackInfo(Map<MethodReference, Event> map) {
            this.f2ch = map;
            for (Entry entry : map.entrySet()) {
                Event event = (Event) entry.getValue();
                List list = (List) this.f1cg.get(event);
                if (list == null) {
                    list = new ArrayList();
                    this.f1cg.put(event, list);
                }
                list.add(entry.getKey());
            }
        }

        /* renamed from: a */
        static void m311a(List<MethodReference> list, LifecycleOwner lifecycleOwner, Event event, Object obj) {
            if (list != null) {
                int size = list.size() - 1;
                while (size >= 0) {
                    MethodReference methodReference = (MethodReference) list.get(size);
                    try {
                        switch (methodReference.f3ci) {
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
        /* renamed from: ci */
        final int f3ci;
        final Method mMethod;

        MethodReference(int i, Method method) {
            this.f3ci = i;
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
            if (this.f3ci == methodReference.f3ci && this.mMethod.getName().equals(methodReference.mMethod.getName())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.f3ci * 31) + this.mMethod.getName().hashCode();
        }
    }

    ClassesInfoCache() {
    }

    /* Access modifiers changed, original: final */
    /* renamed from: d */
    public final boolean mo284d(Class cls) {
        if (this.f6cf.containsKey(cls)) {
            return ((Boolean) this.f6cf.get(cls)).booleanValue();
        }
        Method[] e = m314e(cls);
        for (Method annotation : e) {
            if (((OnLifecycleEvent) annotation.getAnnotation(OnLifecycleEvent.class)) != null) {
                m312a(cls, e);
                return true;
            }
        }
        this.f6cf.put(cls, Boolean.FALSE);
        return false;
    }

    /* renamed from: e */
    private static Method[] m314e(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* Access modifiers changed, original: final */
    /* renamed from: f */
    public final CallbackInfo mo285f(Class cls) {
        CallbackInfo callbackInfo = (CallbackInfo) this.f5ce.get(cls);
        if (callbackInfo != null) {
            return callbackInfo;
        }
        return m312a(cls, null);
    }

    /* renamed from: a */
    private static void m313a(Map<MethodReference, Event> map, MethodReference methodReference, Event event, Class cls) {
        Event event2 = (Event) map.get(methodReference);
        if (event2 != null && event != event2) {
            throw new IllegalArgumentException("Method " + methodReference.mMethod.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + event2 + ", new value " + event);
        } else if (event2 == null) {
            map.put(methodReference, event);
        }
    }

    /* renamed from: a */
    private CallbackInfo m312a(Class cls, Method[] methodArr) {
        CallbackInfo f;
        Class superclass = cls.getSuperclass();
        HashMap hashMap = new HashMap();
        if (superclass != null) {
            f = mo285f(superclass);
            if (f != null) {
                hashMap.putAll(f.f2ch);
            }
        }
        for (Class f2 : cls.getInterfaces()) {
            for (Entry entry : mo285f(f2).f2ch.entrySet()) {
                m313a(hashMap, (MethodReference) entry.getKey(), (Event) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m314e(cls);
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
                m313a(hashMap, new MethodReference(i2, method), value, cls);
                z2 = true;
            } else {
                z2 = z;
            }
            i++;
            z = z2;
        }
        f = new CallbackInfo(hashMap);
        this.f5ce.put(cls, f);
        this.f6cf.put(cls, Boolean.valueOf(z));
        return f;
    }
}
