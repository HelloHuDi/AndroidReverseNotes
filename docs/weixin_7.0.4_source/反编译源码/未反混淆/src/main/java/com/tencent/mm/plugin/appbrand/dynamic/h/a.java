package com.tencent.mm.plugin.appbrand.dynamic.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class a {
    private static volatile a hoC;
    public Map<String, List<IPCDynamicPageView>> hoD = new ConcurrentHashMap();
    public Map<String, a> hoE = new ConcurrentHashMap();

    public interface a {
        void a(String str, IPCDynamicPageView iPCDynamicPageView);
    }

    private a() {
        AppMethodBeat.i(10939);
        AppMethodBeat.o(10939);
    }

    public static a aAb() {
        AppMethodBeat.i(10940);
        if (hoC == null) {
            synchronized (a.class) {
                try {
                    if (hoC == null) {
                        hoC = new a();
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10940);
                    }
                }
            }
        }
        a aVar = hoC;
        AppMethodBeat.o(10940);
        return aVar;
    }

    public final IPCDynamicPageView Ak(String str) {
        AppMethodBeat.i(10941);
        if (str == null) {
            AppMethodBeat.o(10941);
            return null;
        }
        for (Entry entry : this.hoD.entrySet()) {
            if (entry.getValue() != null) {
                for (IPCDynamicPageView iPCDynamicPageView : (List) entry.getValue()) {
                    if (iPCDynamicPageView.getExtId() != null && iPCDynamicPageView.getExtId().equals(str)) {
                        AppMethodBeat.o(10941);
                        return iPCDynamicPageView;
                    }
                }
                continue;
            }
        }
        AppMethodBeat.o(10941);
        return null;
    }

    public final boolean b(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.i(10942);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.o(10942);
            return false;
        }
        List list = (List) this.hoD.get(str);
        if (list == null) {
            AppMethodBeat.o(10942);
            return false;
        }
        boolean remove;
        synchronized (list) {
            try {
                remove = list.remove(iPCDynamicPageView);
            } catch (Throwable th) {
                while (true) {
                    AppMethodBeat.o(10942);
                }
            }
        }
        if (list.isEmpty()) {
            this.hoD.remove(str);
        }
        AppMethodBeat.o(10942);
        return remove;
    }

    public final boolean c(String str, IPCDynamicPageView iPCDynamicPageView) {
        AppMethodBeat.i(10943);
        if (str == null || str.length() == 0 || iPCDynamicPageView == null) {
            AppMethodBeat.o(10943);
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
                    AppMethodBeat.o(10943);
                }
            }
            return true;
        }
        boolean add = list.add(iPCDynamicPageView);
        if (list.size() > 4) {
            synchronized (list) {
                try {
                    if (list.size() > 4) {
                        IPCDynamicPageView aF = aF(list);
                        if (aF != null) {
                            a aVar = (a) this.hoE.get(str);
                            if (aVar != null) {
                                aVar.a(str, aF);
                            }
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(10943);
                    }
                }
            }
        }
        AppMethodBeat.o(10943);
        return add;
    }

    private static IPCDynamicPageView aF(List<IPCDynamicPageView> list) {
        AppMethodBeat.i(10944);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= list.size()) {
                AppMethodBeat.o(10944);
                return null;
            } else if (((IPCDynamicPageView) list.get(i2)).isPaused()) {
                IPCDynamicPageView iPCDynamicPageView = (IPCDynamicPageView) list.remove(i2);
                AppMethodBeat.o(10944);
                return iPCDynamicPageView;
            } else {
                i = i2 + 1;
            }
        }
    }
}
