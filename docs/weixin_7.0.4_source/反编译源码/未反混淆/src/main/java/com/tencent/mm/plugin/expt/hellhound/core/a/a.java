package com.tencent.mm.plugin.expt.hellhound.core.a;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public final class a {
    private static Object lMl = null;
    private static Class<?> lMm = null;
    private static Handler lMn = null;

    private static void bqp() {
        AppMethodBeat.i(73347);
        if (lMl == null) {
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                lMm = cls;
                Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
                declaredMethod.setAccessible(true);
                lMl = declaredMethod.invoke(null, new Object[0]);
                AppMethodBeat.o(73347);
                return;
            } catch (Exception e) {
                ab.printErrStackTrace("HellReflector", e, "habbyge-mali, ActivityThreadReflect", new Object[0]);
                h.pYm.a(932, 2, 1, false);
            }
        }
        AppMethodBeat.o(73347);
    }

    public static Object bqq() {
        AppMethodBeat.i(73348);
        bqp();
        Object obj = lMl;
        AppMethodBeat.o(73348);
        return obj;
    }

    public static Class<?> bqr() {
        AppMethodBeat.i(73349);
        bqp();
        Class cls = lMm;
        AppMethodBeat.o(73349);
        return cls;
    }

    public static List<Class<?>> ap(Class<?> cls) {
        AppMethodBeat.i(73350);
        if (cls == null) {
            AppMethodBeat.o(73350);
            return null;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        a(cls, linkedHashSet);
        List<Class<?>> arrayList = new ArrayList(linkedHashSet);
        AppMethodBeat.o(73350);
        return arrayList;
    }

    private static void a(Class<?> cls, HashSet<Class<?>> hashSet) {
        AppMethodBeat.i(73351);
        Class cls2;
        while (cls2 != null) {
            for (Object obj : cls2.getInterfaces()) {
                if (hashSet.add(obj)) {
                    a(obj, hashSet);
                }
            }
            cls2 = cls2.getSuperclass();
        }
        AppMethodBeat.o(73351);
    }
}
