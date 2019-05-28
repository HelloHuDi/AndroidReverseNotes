package com.tencent.mm.ipcinvoker.f;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class b {
    private static final Set<Object> eGD = new HashSet();
    private static final Map<String, Set<c>> eGg = new HashMap();

    static {
        AppMethodBeat.i(114115);
        AppMethodBeat.o(114115);
    }

    public static void as(Object obj) {
        AppMethodBeat.i(114110);
        eGD.add(obj);
        AppMethodBeat.o(114110);
    }

    public static void at(Object obj) {
        AppMethodBeat.i(114111);
        eGD.remove(obj);
        AppMethodBeat.o(114111);
    }

    public static boolean a(String str, c cVar) {
        AppMethodBeat.i(114112);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114112);
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
                AppMethodBeat.o(114112);
            }
        }
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "addIntoSet(%s)", str);
        synchronized (set) {
            try {
                add = set.add(cVar);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(114112);
                }
            }
        }
        return add;
    }

    public static boolean b(String str, c cVar) {
        AppMethodBeat.i(114113);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114113);
            return false;
        }
        Set set;
        synchronized (eGg) {
            try {
                set = (Set) eGg.get(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114113);
            }
        }
        if (set == null) {
            return false;
        }
        boolean remove;
        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "removeFromSet(%s)", str);
        synchronized (set) {
            try {
                remove = set.remove(cVar);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114113);
            }
        }
        return remove;
    }

    public static void lk(String str) {
        AppMethodBeat.i(114114);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(114114);
            return;
        }
        Set<c> set;
        synchronized (eGg) {
            try {
                set = (Set) eGg.remove(str);
            } finally {
                while (true) {
                }
                AppMethodBeat.o(114114);
            }
        }
        if (set != null) {
            com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycleAll(%s)", str);
            synchronized (set) {
                try {
                    for (c hashCode : set) {
                        com.tencent.mm.ipcinvoker.h.b.i("IPC.ObjectRecycler", "recycle(%s)", Integer.valueOf(hashCode.hashCode()));
                        hashCode.recycle();
                    }
                    set.clear();
                } finally {
                    AppMethodBeat.o(114114);
                }
            }
        }
    }
}
