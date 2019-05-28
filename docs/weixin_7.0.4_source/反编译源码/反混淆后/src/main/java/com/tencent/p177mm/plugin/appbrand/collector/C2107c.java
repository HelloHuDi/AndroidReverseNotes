package com.tencent.p177mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.tencent.mm.plugin.appbrand.collector.c */
public final class C2107c {
    private static C2106b heE = new C33130h();
    private static boolean heF;
    private static final Set<String> heG = new HashSet();

    static {
        AppMethodBeat.m2504i(57040);
        AppMethodBeat.m2505o(57040);
    }

    /* renamed from: yK */
    public static void m4321yK(String str) {
        AppMethodBeat.m2504i(57024);
        if (str.length() == 0) {
            AppMethodBeat.m2505o(57024);
            return;
        }
        heG.add(str);
        AppMethodBeat.m2505o(57024);
    }

    /* renamed from: yL */
    public static void m4322yL(String str) {
        AppMethodBeat.m2504i(57025);
        if (str.length() == 0) {
            AppMethodBeat.m2505o(57025);
            return;
        }
        heG.remove(str);
        AppMethodBeat.m2505o(57025);
    }

    /* renamed from: yM */
    public static boolean m4323yM(String str) {
        AppMethodBeat.m2504i(57026);
        if (str.length() == 0) {
            AppMethodBeat.m2505o(57026);
            return false;
        }
        boolean contains = heG.contains(str);
        AppMethodBeat.m2505o(57026);
        return contains;
    }

    /* renamed from: dG */
    public static void m4316dG(boolean z) {
        heF = z;
    }

    public static boolean ayt() {
        return heF;
    }

    /* renamed from: yN */
    private static boolean m4324yN(String str) {
        AppMethodBeat.m2504i(57027);
        if (heF && heG.contains(str)) {
            AppMethodBeat.m2505o(57027);
            return true;
        }
        AppMethodBeat.m2505o(57027);
        return false;
    }

    /* renamed from: yO */
    private static boolean m4325yO(String str) {
        AppMethodBeat.m2504i(57028);
        if (heF) {
            CollectSession yH = heE.mo5924yH(str);
            if (yH == null) {
                AppMethodBeat.m2505o(57028);
                return false;
            } else if (heG.contains(yH.groupId)) {
                AppMethodBeat.m2505o(57028);
                return true;
            } else {
                AppMethodBeat.m2505o(57028);
                return false;
            }
        }
        AppMethodBeat.m2505o(57028);
        return false;
    }

    public static void clear() {
        AppMethodBeat.m2504i(57029);
        if (heF) {
            heE.clear();
            AppMethodBeat.m2505o(57029);
            return;
        }
        AppMethodBeat.m2505o(57029);
    }

    /* renamed from: d */
    public static void m4315d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.m2504i(57030);
        if (C2107c.m4324yN(str)) {
            heE.mo5921d(str, str2, str3, z);
            AppMethodBeat.m2505o(57030);
            return;
        }
        AppMethodBeat.m2505o(57030);
    }

    /* renamed from: bE */
    public static void m4313bE(String str, String str2) {
        AppMethodBeat.m2504i(57031);
        if (C2107c.m4325yO(str)) {
            heE.mo5918bE(str, str2);
            AppMethodBeat.m2505o(57031);
            return;
        }
        AppMethodBeat.m2505o(57031);
    }

    /* renamed from: a */
    public static void m4311a(CollectSession collectSession) {
        AppMethodBeat.m2504i(57032);
        if (collectSession == null) {
            AppMethodBeat.m2505o(57032);
        } else if (C2107c.m4324yN(collectSession.groupId)) {
            heE.mo5916a(collectSession);
            AppMethodBeat.m2505o(57032);
        } else {
            AppMethodBeat.m2505o(57032);
        }
    }

    /* renamed from: bD */
    public static CollectSession m4312bD(String str, String str2) {
        AppMethodBeat.m2504i(57033);
        if (C2107c.m4325yO(str)) {
            CollectSession bD = heE.mo5917bD(str, str2);
            AppMethodBeat.m2505o(57033);
            return bD;
        }
        AppMethodBeat.m2505o(57033);
        return null;
    }

    /* renamed from: l */
    public static void m4317l(String str, String str2, boolean z) {
        AppMethodBeat.m2504i(57034);
        if (C2107c.m4325yO(str)) {
            heE.mo5922l(str, str2, z);
            AppMethodBeat.m2505o(57034);
            return;
        }
        AppMethodBeat.m2505o(57034);
    }

    /* renamed from: yH */
    public static CollectSession m4318yH(String str) {
        AppMethodBeat.m2504i(57035);
        if (C2107c.m4325yO(str)) {
            CollectSession yH = heE.mo5924yH(str);
            AppMethodBeat.m2505o(57035);
            return yH;
        }
        AppMethodBeat.m2505o(57035);
        return null;
    }

    /* renamed from: yI */
    public static CollectSession m4319yI(String str) {
        AppMethodBeat.m2504i(57036);
        if (heF) {
            CollectSession yI = heE.mo5925yI(str);
            AppMethodBeat.m2505o(57036);
            return yI;
        }
        AppMethodBeat.m2505o(57036);
        return null;
    }

    public static void print(String str) {
        AppMethodBeat.m2504i(57037);
        if (C2107c.m4325yO(str)) {
            heE.print(str);
            AppMethodBeat.m2505o(57037);
            return;
        }
        AppMethodBeat.m2505o(57037);
    }

    /* renamed from: bF */
    public static int m4314bF(String str, String str2) {
        AppMethodBeat.m2504i(57038);
        if (C2107c.m4324yN(str)) {
            int bF = heE.mo5919bF(str, str2);
            AppMethodBeat.m2505o(57038);
            return bF;
        }
        AppMethodBeat.m2505o(57038);
        return 0;
    }

    /* renamed from: yJ */
    public static StringBuilder m4320yJ(String str) {
        AppMethodBeat.m2504i(57039);
        StringBuilder yJ;
        if (C2107c.m4324yN(str)) {
            yJ = heE.mo5926yJ(str);
            AppMethodBeat.m2505o(57039);
            return yJ;
        }
        yJ = new StringBuilder();
        AppMethodBeat.m2505o(57039);
        return yJ;
    }
}
