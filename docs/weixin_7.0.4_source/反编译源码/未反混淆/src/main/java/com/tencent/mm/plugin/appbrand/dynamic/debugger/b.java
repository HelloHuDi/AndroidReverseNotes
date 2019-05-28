package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.l.a;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static final Map<String, List<a>> eGg = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> hmH = new ConcurrentHashMap();

    static {
        AppMethodBeat.i(10812);
        AppMethodBeat.o(10812);
    }

    public static DebuggerInfo Ad(String str) {
        AppMethodBeat.i(10807);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(10807);
            return null;
        }
        DebuggerInfo debuggerInfo = (DebuggerInfo) hmH.get(str);
        AppMethodBeat.o(10807);
        return debuggerInfo;
    }

    public static void a(String str, DebuggerInfo debuggerInfo) {
        AppMethodBeat.i(10808);
        if (str == null || str.length() == 0) {
            AppMethodBeat.o(10808);
            return;
        }
        hmH.put(str, debuggerInfo);
        AppMethodBeat.o(10808);
    }

    public static boolean c(String str, a aVar) {
        AppMethodBeat.i(10809);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(10809);
            return false;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            list = new LinkedList();
            eGg.put(str, list);
        } else if (list.contains(aVar)) {
            AppMethodBeat.o(10809);
            return true;
        }
        boolean add = list.add(aVar);
        AppMethodBeat.o(10809);
        return add;
    }

    public static boolean d(String str, a aVar) {
        AppMethodBeat.i(10810);
        if (bo.isNullOrNil(str) || aVar == null) {
            AppMethodBeat.o(10810);
            return false;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            AppMethodBeat.o(10810);
            return false;
        }
        boolean remove = list.remove(aVar);
        if (list.isEmpty()) {
            eGg.remove(str);
        }
        AppMethodBeat.o(10810);
        return remove;
    }

    public static void I(String str, int i) {
        AppMethodBeat.i(10811);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(10811);
            return;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            AppMethodBeat.o(10811);
            return;
        }
        for (a kS : new LinkedList(list)) {
            kS.kS(i);
        }
        AppMethodBeat.o(10811);
    }
}
