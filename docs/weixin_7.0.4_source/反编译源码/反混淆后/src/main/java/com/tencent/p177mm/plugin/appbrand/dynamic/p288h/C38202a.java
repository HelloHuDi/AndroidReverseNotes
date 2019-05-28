package com.tencent.p177mm.plugin.appbrand.dynamic.p288h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.a */
public class C38202a {
    private static volatile C38202a hoC;
    public Map<String, List<IPCDynamicPageView>> hoD = new ConcurrentHashMap();
    public Map<String, C10215a> hoE = new ConcurrentHashMap();

    /* renamed from: com.tencent.mm.plugin.appbrand.dynamic.h.a$a */
    public interface C10215a {
        /* renamed from: a */
        void mo21629a(String str, IPCDynamicPageView iPCDynamicPageView);
    }

    private C38202a() {
        AppMethodBeat.m2504i(10939);
        AppMethodBeat.m2505o(10939);
    }

    public static C38202a aAb() {
        AppMethodBeat.m2504i(10940);
        if (hoC == null) {
            synchronized (C38202a.class) {
                try {
                    if (hoC == null) {
                        hoC = new C38202a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10940);
                    }
                }
            }
        }
        C38202a c38202a = hoC;
        AppMethodBeat.m2505o(10940);
        return c38202a;
    }

    /* renamed from: Ak */
    public final IPCDynamicPageView mo60935Ak(String str) {
        AppMethodBeat.m2504i(10941);
        if (str == null) {
            AppMethodBeat.m2505o(10941);
            return null;
        }
        for (Entry entry : this.hoD.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : (List) entry.getValue()) {
                    if (iPCDynamicPageView.getExtId() != null && iPCDynamicPageView.getExtId().equals(str)) {
                        AppMethodBeat.m2505o(10941);
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.m2505o(10941);
        return null;
    }

    /* renamed from: b */
    public final boolean mo60936b(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.m2504i(10942);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.m2505o(10942);
            return false;
        }
        List list = (List) this.hoD.get(str);
        if (list == null) {
            AppMethodBeat.m2505o(10942);
            return false;
        }
        boolean remove;
        synchronized (list) {
            try {
                remove = list.remove(iPCDynamicPageView);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.m2505o(10942);
                }
            }
        }
        if (list.isEmpty()) {
            this.hoD.remove(str);
        }
        AppMethodBeat.m2505o(10942);
        return remove;
    }

    /* renamed from: c */
    public final boolean mo60937c(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.m2504i(10943);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.m2505o(10943);
            return false;
        }
        List list;
        List list2 = (List) this.hoD.get(str);
        if (list2 == null) {
            LinkedList linkedList = new LinkedList();
            this.hoD.put(str, linkedList);
            list = linkedList;
        } else {
            list = list2;
        }
        if (list.contains(iPCDynamicPageView)) {
            synchronized (list) {
                try {
                    list.remove(iPCDynamicPageView);
                    list.add(iPCDynamicPageView);
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.m2505o(10943);
                }
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                try {
                    if (list.size() > 4) {
                        IPCDynamicPageView aF = C38202a.m64645aF(list);
                        if (aF != null) {
                            C10215a c10215a = (C10215a) this.hoE.get(str);
                            if (c10215a != null) {
                                c10215a.mo21629a(str, aF);
                            }
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.m2505o(10943);
                    }
                }
            }
        }
        AppMethodBeat.m2505o(10943);
        return add;
    }

    /* renamed from: aF */
    private static IPCDynamicPageView m64645aF(List<IPCDynamicPageView> list) {
        AppMethodBeat.m2504i(10944);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                AppMethodBeat.m2505o(10944);
                return null;
            } else if (((IPCDynamicPageView) list.get(i2)).isPaused()) {
                IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) list.remove(i2);
                AppMethodBeat.m2505o(10944);
                return iPCDynamicPageView;
            } else {
                i = i2 + 1;
            }
        }
    }
}
