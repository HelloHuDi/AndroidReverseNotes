package com.tencent.luggage.a;

import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

public final class e {
    private static LinkedHashMap<String, c> bOc = new LinkedHashMap();
    private static Map<Class<? extends d>, Object> bOd = new HashMap();

    static {
        AppMethodBeat.i(90711);
        a aVar = new a();
        d.i("Luggage.Luggage", "plugin:[%s] installed", aVar.getName());
        bOc.put(aVar.getName(), aVar);
        AppMethodBeat.o(90711);
    }

    public static <T extends b> T B(Class<T> cls) {
        AppMethodBeat.i(90707);
        if (cls == null) {
            AppMethodBeat.o(90707);
            return null;
        }
        ListIterator listIterator = new ArrayList(bOc.values()).listIterator(bOc.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.wH() != null && cVar.wH().get(cls) != null) {
                b bVar = (b) cVar.wH().get(cls);
                AppMethodBeat.o(90707);
                return bVar;
            }
        }
        d.w("Luggage.Luggage", "no customize found for [%s]", cls.getCanonicalName());
        AppMethodBeat.o(90707);
        return null;
    }

    public static <T extends b> void a(Class<T> cls, T t) {
        AppMethodBeat.i(90708);
        if (cls == null || t == null) {
            AppMethodBeat.o(90708);
            return;
        }
        ((c) bOc.get("luggage-core")).wH().put(cls, t);
        AppMethodBeat.o(90708);
    }

    public static <T extends d> void a(Class<T> cls, T t) {
        AppMethodBeat.i(90709);
        if (cls == null || t == null) {
            AppMethodBeat.o(90709);
            return;
        }
        ((c) bOc.get("luggage-core")).wI().put(cls, t);
        AppMethodBeat.o(90709);
    }

    public static <T extends d> T C(Class<T> cls) {
        d dVar;
        AppMethodBeat.i(90710);
        ListIterator listIterator = new ArrayList(bOc.values()).listIterator(bOc.size());
        while (listIterator.hasPrevious()) {
            c cVar = (c) listIterator.previous();
            if (cVar != null && cVar.wI() != null && cVar.wI().get(cls) != null) {
                dVar = (d) cVar.wI().get(cls);
                AppMethodBeat.o(90710);
                return dVar;
            }
        }
        d.w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", cls.getCanonicalName(), Boolean.TRUE);
        if (bOd.get(cls) != null) {
            dVar = (d) bOd.get(cls);
            AppMethodBeat.o(90710);
            return dVar;
        }
        AnonymousClass1 anonymousClass1 = new InvocationHandler() {
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return null;
            }
        };
        dVar = (d) Proxy.newProxyInstance(d.class.getClassLoader(), new Class[]{cls}, anonymousClass1);
        bOd.put(cls, dVar);
        AppMethodBeat.o(90710);
        return dVar;
    }
}
