package com.tencent.luggage.p1170a;

import com.tencent.luggage.p147g.C45124d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;

/* renamed from: com.tencent.luggage.a.e */
public final class C37384e {
    private static LinkedHashMap<String, C37383c> bOc = new LinkedHashMap();
    private static Map<Class<? extends C45116d>, Object> bOd = new HashMap();

    /* renamed from: com.tencent.luggage.a.e$1 */
    static class C321771 implements InvocationHandler {
        C321771() {
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) {
            return null;
        }
    }

    static {
        AppMethodBeat.m2504i(90711);
        C17815a c17815a = new C17815a();
        C45124d.m82930i("Luggage.Luggage", "plugin:[%s] installed", c17815a.getName());
        bOc.put(c17815a.getName(), c17815a);
        AppMethodBeat.m2505o(90711);
    }

    /* renamed from: B */
    public static <T extends C25681b> T m62985B(Class<T> cls) {
        AppMethodBeat.m2504i(90707);
        if (cls == null) {
            AppMethodBeat.m2505o(90707);
            return null;
        }
        ListIterator listIterator = new ArrayList(bOc.values()).listIterator(bOc.size());
        while (listIterator.hasPrevious()) {
            C37383c c37383c = (C37383c) listIterator.previous();
            if (c37383c != null && c37383c.mo32972wH() != null && c37383c.mo32972wH().get(cls) != null) {
                C25681b c25681b = (C25681b) c37383c.mo32972wH().get(cls);
                AppMethodBeat.m2505o(90707);
                return c25681b;
            }
        }
        C45124d.m82934w("Luggage.Luggage", "no customize found for [%s]", cls.getCanonicalName());
        AppMethodBeat.m2505o(90707);
        return null;
    }

    /* renamed from: a */
    public static <T extends C25681b> void m62987a(Class<T> cls, T t) {
        AppMethodBeat.m2504i(90708);
        if (cls == null || t == null) {
            AppMethodBeat.m2505o(90708);
            return;
        }
        ((C37383c) bOc.get("luggage-core")).mo32972wH().put(cls, t);
        AppMethodBeat.m2505o(90708);
    }

    /* renamed from: a */
    public static <T extends C45116d> void m62988a(Class<T> cls, T t) {
        AppMethodBeat.m2504i(90709);
        if (cls == null || t == null) {
            AppMethodBeat.m2505o(90709);
            return;
        }
        ((C37383c) bOc.get("luggage-core")).mo32973wI().put(cls, t);
        AppMethodBeat.m2505o(90709);
    }

    /* renamed from: C */
    public static <T extends C45116d> T m62986C(Class<T> cls) {
        C45116d c45116d;
        AppMethodBeat.m2504i(90710);
        ListIterator listIterator = new ArrayList(bOc.values()).listIterator(bOc.size());
        while (listIterator.hasPrevious()) {
            C37383c c37383c = (C37383c) listIterator.previous();
            if (c37383c != null && c37383c.mo32973wI() != null && c37383c.mo32973wI().get(cls) != null) {
                c45116d = (C45116d) c37383c.mo32973wI().get(cls);
                AppMethodBeat.m2505o(90710);
                return c45116d;
            }
        }
        C45124d.m82934w("Luggage.Luggage", "no profiler found for [%s], genDummy[%b]", cls.getCanonicalName(), Boolean.TRUE);
        if (bOd.get(cls) != null) {
            c45116d = (C45116d) bOd.get(cls);
            AppMethodBeat.m2505o(90710);
            return c45116d;
        }
        C321771 c321771 = new C321771();
        c45116d = (C45116d) Proxy.newProxyInstance(C45116d.class.getClassLoader(), new Class[]{cls}, c321771);
        bOd.put(cls, c45116d);
        AppMethodBeat.m2505o(90710);
        return c45116d;
    }
}
