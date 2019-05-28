package com.tencent.mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.c.a;
import com.tencent.mm.ipcinvoker.extension.e;
import com.tencent.mm.ipcinvoker.h.b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class k {
    private static final Map<String, e> eGg = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(114048);
        AppMethodBeat.o(114048);
    }

    public static <T> T b(String str, Class<?> cls) {
        AppMethodBeat.i(114045);
        try {
            Class cls2 = Class.forName(str);
            T t;
            if (!cls.isAssignableFrom(cls2)) {
                b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls, cls2);
                AppMethodBeat.o(114045);
                return null;
            } else if (cls2.isAnnotationPresent(a.class)) {
                e eVar = (e) eGg.get(str);
                if (eVar == null) {
                    eVar = new e(cls2);
                    eGg.put(str, eVar);
                }
                t = eVar.get();
                AppMethodBeat.o(114045);
                return t;
            } else {
                t = com.tencent.mm.ipcinvoker.g.b.c(str, cls);
                AppMethodBeat.o(114045);
                return t;
            }
        } catch (Exception e) {
            AppMethodBeat.o(114045);
            return null;
        }
    }

    public static <T> T i(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.i(114046);
        try {
            T t;
            if (!cls2.isAssignableFrom(cls)) {
                b.e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls2, cls);
                AppMethodBeat.o(114046);
                return null;
            } else if (cls.isAnnotationPresent(a.class)) {
                String name = cls.getName();
                e eVar = (e) eGg.get(name);
                if (eVar == null) {
                    eVar = new e(cls);
                    eGg.put(name, eVar);
                }
                t = eVar.get();
                AppMethodBeat.o(114046);
                return t;
            } else {
                t = com.tencent.mm.ipcinvoker.g.b.j(cls, cls2);
                AppMethodBeat.o(114046);
                return t;
            }
        } catch (Exception e) {
            AppMethodBeat.o(114046);
            return null;
        }
    }

    public static <T> T c(String str, Class<?> cls) {
        AppMethodBeat.i(114047);
        Object c = com.tencent.mm.ipcinvoker.g.b.c(str, cls);
        AppMethodBeat.o(114047);
        return c;
    }
}
