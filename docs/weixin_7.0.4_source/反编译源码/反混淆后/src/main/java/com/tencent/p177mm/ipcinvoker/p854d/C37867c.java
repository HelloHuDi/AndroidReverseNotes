package com.tencent.p177mm.ipcinvoker.p854d;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.ipcinvoker.d.c */
public class C37867c {
    private static volatile C37867c eGt;
    Map<String, List<C32714e>> eGu = new ConcurrentHashMap();

    /* renamed from: PT */
    public static C37867c m63901PT() {
        AppMethodBeat.m2504i(114073);
        if (eGt == null) {
            synchronized (C37867c.class) {
                try {
                    if (eGt == null) {
                        eGt = new C37867c();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114073);
                    }
                }
            }
        }
        C37867c c37867c = eGt;
        AppMethodBeat.m2505o(114073);
        return c37867c;
    }

    private C37867c() {
        AppMethodBeat.m2504i(114074);
        AppMethodBeat.m2505o(114074);
    }

    /* renamed from: k */
    public final boolean mo60591k(String str, Bundle bundle) {
        AppMethodBeat.m2504i(114075);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114075);
            return false;
        }
        List list = (List) this.eGu.get(str);
        if (list == null || list.isEmpty()) {
            AppMethodBeat.m2505o(114075);
            return true;
        }
        synchronized (list) {
            try {
                ArrayList<C32714e> arrayList = new ArrayList(list);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114075);
            }
        }
        for (C32714e ao : arrayList) {
            ao.mo5960ao(bundle);
        }
        return true;
    }

    /* renamed from: a */
    public final boolean mo60589a(String str, C32714e c32714e) {
        AppMethodBeat.m2504i(114076);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114076);
            return false;
        }
        List list = (List) this.eGu.get(str);
        if (list == null) {
            list = new LinkedList();
            this.eGu.put(str, list);
        }
        if (list.contains(c32714e)) {
            AppMethodBeat.m2505o(114076);
            return false;
        }
        boolean add;
        synchronized (list) {
            try {
                add = list.add(c32714e);
            } finally {
                while (true) {
                }
                AppMethodBeat.m2505o(114076);
            }
        }
        return add;
    }

    /* renamed from: b */
    public final boolean mo60590b(String str, C32714e c32714e) {
        AppMethodBeat.m2504i(114077);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(114077);
            return false;
        }
        boolean z;
        List list = (List) this.eGu.get(str);
        if (list != null) {
            boolean remove;
            synchronized (list) {
                try {
                    remove = list.remove(c32714e);
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(114077);
                    }
                }
            }
            if (list.isEmpty()) {
                this.eGu.remove(str);
            }
            z = remove;
        } else {
            z = false;
        }
        AppMethodBeat.m2505o(114077);
        return z;
    }
}
