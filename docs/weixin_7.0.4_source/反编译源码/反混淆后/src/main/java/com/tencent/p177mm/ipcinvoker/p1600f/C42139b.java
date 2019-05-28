package com.tencent.p177mm.ipcinvoker.p1600f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.ipcinvoker.p855h.C26340b;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.tencent.mm.ipcinvoker.f.b */
public final class C42139b {
    private static final Set<Object> eGD = new HashSet();
    private static final Map<String, Set<C42140c>> eGg = new HashMap();

    static {
        AppMethodBeat.m2504i(114115);
        AppMethodBeat.m2505o(114115);
    }

    /* renamed from: as */
    public static void m74290as(Object obj) {
        AppMethodBeat.m2504i(114110);
        eGD.add(obj);
        AppMethodBeat.m2505o(114110);
    }

    /* renamed from: at */
    public static void m74291at(Object obj) {
        AppMethodBeat.m2504i(114111);
        eGD.remove(obj);
        AppMethodBeat.m2505o(114111);
    }

    /* renamed from: a */
    public static boolean m74289a(String str, C42140c c42140c) {
        AppMethodBeat.m2504i(114112);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114112);
            return false;
        }
        Set set;
        boolean add;
        synchronized (eGg) {
            try {
                Set set2 = (Set) eGg.get(str);
                if (set2 == null) {
                    HashSet hashSet = new HashSet();
                    eGg.put(str, hashSet);
                    set = hashSet;
                } else {
                    set = set2;
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114112);
            }
        }
        C26340b.m41917i("IPC.ObjectRecycler", "addIntoSet(%s)", str);
        synchronized (set) {
            try {
                add = set.add(c42140c);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(114112);
                }
            }
        }
        return add;
    }

    /* renamed from: b */
    public static boolean m74292b(String str, C42140c c42140c) {
        AppMethodBeat.m2504i(114113);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114113);
            return false;
        }
        Set set;
        synchronized (eGg) {
            try {
                set = (Set) eGg.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114113);
            }
        }
        if (set == null) {
            return false;
        }
        boolean remove;
        C26340b.m41917i("IPC.ObjectRecycler", "removeFromSet(%s)", str);
        synchronized (set) {
            try {
                remove = set.remove(c42140c);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114113);
            }
        }
        return remove;
    }

    /* renamed from: lk */
    public static void m74293lk(String str) {
        AppMethodBeat.m2504i(114114);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114114);
            return;
        }
        Set<C42140c> set;
        synchronized (eGg) {
            try {
                set = (Set) eGg.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114114);
            }
        }
        if (set != null) {
            C26340b.m41917i("IPC.ObjectRecycler", "recycleAll(%s)", str);
            synchronized (set) {
                try {
                    for (C42140c hashCode : set) {
                        C26340b.m41917i("IPC.ObjectRecycler", "recycle(%s)", Integer.valueOf(hashCode.hashCode()));
                        hashCode.recycle();
                    }
                    set.clear();
                } finally {
                    AppMethodBeat.m2505o(114114);
                }
            }
        }
    }
}
