package com.tencent.p177mm.plugin.appbrand.dynamic.debugger;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.modelappbrand.C18651l.C18650a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.tencent.mm.plugin.appbrand.dynamic.debugger.b */
public final class C42423b {
    private static final Map<String, List<C18650a>> eGg = new ConcurrentHashMap();
    private static final Map<String, DebuggerInfo> hmH = new ConcurrentHashMap();

    static {
        AppMethodBeat.m2504i(10812);
        AppMethodBeat.m2505o(10812);
    }

    /* renamed from: Ad */
    public static DebuggerInfo m75141Ad(String str) {
        AppMethodBeat.m2504i(10807);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(10807);
            return null;
        }
        DebuggerInfo debuggerInfo = (DebuggerInfo) hmH.get(str);
        AppMethodBeat.m2505o(10807);
        return debuggerInfo;
    }

    /* renamed from: a */
    public static void m75143a(String str, DebuggerInfo debuggerInfo) {
        AppMethodBeat.m2504i(10808);
        if (str == null || str.length() == 0) {
            AppMethodBeat.m2505o(10808);
            return;
        }
        hmH.put(str, debuggerInfo);
        AppMethodBeat.m2505o(10808);
    }

    /* renamed from: c */
    public static boolean m75144c(String str, C18650a c18650a) {
        AppMethodBeat.m2504i(10809);
        if (C5046bo.isNullOrNil(str) || c18650a == null) {
            AppMethodBeat.m2505o(10809);
            return false;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            list = new LinkedList();
            eGg.put(str, list);
        } else if (list.contains(c18650a)) {
            AppMethodBeat.m2505o(10809);
            return true;
        }
        boolean add = list.add(c18650a);
        AppMethodBeat.m2505o(10809);
        return add;
    }

    /* renamed from: d */
    public static boolean m75145d(String str, C18650a c18650a) {
        AppMethodBeat.m2504i(10810);
        if (C5046bo.isNullOrNil(str) || c18650a == null) {
            AppMethodBeat.m2505o(10810);
            return false;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            AppMethodBeat.m2505o(10810);
            return false;
        }
        boolean remove = list.remove(c18650a);
        if (list.isEmpty()) {
            eGg.remove(str);
        }
        AppMethodBeat.m2505o(10810);
        return remove;
    }

    /* renamed from: I */
    public static void m75142I(String str, int i) {
        AppMethodBeat.m2504i(10811);
        if (C5046bo.isNullOrNil(str)) {
            AppMethodBeat.m2505o(10811);
            return;
        }
        List list = (List) eGg.get(str);
        if (list == null) {
            AppMethodBeat.m2505o(10811);
            return;
        }
        for (C18650a kS : new LinkedList(list)) {
            kS.mo17534kS(i);
        }
        AppMethodBeat.m2505o(10811);
    }
}
