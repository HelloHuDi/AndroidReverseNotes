package com.tencent.p177mm.ipcinvoker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.extension.C18510e;
import com.tencent.p177mm.ipcinvoker.p1384g.C26339b;
import com.tencent.p177mm.ipcinvoker.p853c.C9546a;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ipcinvoker.k */
public final class C26341k {
    private static final Map<String, C18510e> eGg = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(114048);
        AppMethodBeat.m2505o(114048);
    }

    /* renamed from: b */
    public static <T> T m41919b(String str, Class<?> cls) {
        AppMethodBeat.m2504i(114045);
        try {
            Class cls2 = Class.forName(str);
            T t;
            if (!cls.isAssignableFrom(cls2)) {
                C26340b.m41916e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls, cls2);
                AppMethodBeat.m2505o(114045);
                return null;
            } else if (cls2.isAnnotationPresent(C9546a.class)) {
                C18510e c18510e = (C18510e) eGg.get(str);
                if (c18510e == null) {
                    c18510e = new C18510e(cls2);
                    eGg.put(str, c18510e);
                }
                t = c18510e.get();
                AppMethodBeat.m2505o(114045);
                return t;
            } else {
                t = C26339b.m41912c(str, cls);
                AppMethodBeat.m2505o(114045);
                return t;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(114045);
            return null;
        }
    }

    /* renamed from: i */
    public static <T> T m41921i(Class<?> cls, Class<?> cls2) {
        AppMethodBeat.m2504i(114046);
        try {
            T t;
            if (!cls2.isAssignableFrom(cls)) {
                C26340b.m41916e("IPC.ObjectStore", "%s isAssignableFrom %s return false", cls2, cls);
                AppMethodBeat.m2505o(114046);
                return null;
            } else if (cls.isAnnotationPresent(C9546a.class)) {
                String name = cls.getName();
                C18510e c18510e = (C18510e) eGg.get(name);
                if (c18510e == null) {
                    c18510e = new C18510e(cls);
                    eGg.put(name, c18510e);
                }
                t = c18510e.get();
                AppMethodBeat.m2505o(114046);
                return t;
            } else {
                t = C26339b.m41913j(cls, cls2);
                AppMethodBeat.m2505o(114046);
                return t;
            }
        } catch (Exception e) {
            AppMethodBeat.m2505o(114046);
            return null;
        }
    }

    /* renamed from: c */
    public static <T> T m41920c(String str, Class<?> cls) {
        AppMethodBeat.m2504i(114047);
        Object c = C26339b.m41912c(str, cls);
        AppMethodBeat.m2505o(114047);
        return c;
    }
}
