package com.tencent.p177mm.plugin.expt.hellhound.core.p1258a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.expt.hellhound.core.a.a */
public final class C45900a {
    private static Object lMl = null;
    private static Class<?> lMm = null;
    private static Handler lMn = null;

    private static void bqp() {
        AppMethodBeat.m2504i(73347);
        if (lMl == null) {
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                lMm = cls;
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                lMl = declaredMethod.invoke(null, new Object[0]);
                AppMethodBeat.m2505o(73347);
                return;
            } catch (Exception e) {
                C4990ab.printErrStackTrace("HellReflector", e, "habbyge-mali, ActivityThreadReflect", new Object[0]);
                C7060h.pYm.mo8378a(932, 2, 1, false);
            }
        }
        AppMethodBeat.m2505o(73347);
    }

    public static Object bqq() {
        AppMethodBeat.m2504i(73348);
        C45900a.bqp();
        Object obj = lMl;
        AppMethodBeat.m2505o(73348);
        return obj;
    }

    public static Class<?> bqr() {
        AppMethodBeat.m2504i(73349);
        C45900a.bqp();
        Class cls = lMm;
        AppMethodBeat.m2505o(73349);
        return cls;
    }

    /* renamed from: ap */
    public static List<Class<?>> m85093ap(Class<?> cls) {
        AppMethodBeat.m2504i(73350);
        if (cls == null) {
            AppMethodBeat.m2505o(73350);
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        C45900a.m85092a(cls, linkedHashSet);
        List<Class<?>> arrayList = new ArrayList(linkedHashSet);
        AppMethodBeat.m2505o(73350);
        return arrayList;
    }

    /* renamed from: a */
    private static void m85092a(Class<?> cls, HashSet<Class<?>> hashSet) {
        AppMethodBeat.m2504i(73351);
        Class cls2;
        while (cls2 != null) {
            for (Object obj : cls2.getInterfaces()) {
                if (hashSet.add(obj)) {
                    C45900a.m85092a(obj, hashSet);
                }
            }
            cls2 = cls2.getSuperclass();
        }
        AppMethodBeat.m2505o(73351);
    }
}
