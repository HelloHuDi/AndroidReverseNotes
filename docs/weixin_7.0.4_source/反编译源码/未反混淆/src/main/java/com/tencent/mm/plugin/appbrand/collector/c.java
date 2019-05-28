package com.tencent.mm.plugin.appbrand.collector;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashSet;
import java.util.Set;

public final class c {
    private static b heE = new h();
    private static boolean heF;
    private static final Set<String> heG = new HashSet();

    static {
        AppMethodBeat.i(57040);
        AppMethodBeat.o(57040);
    }

    public static void yK(String str) {
        AppMethodBeat.i(57024);
        if (str.length() == 0) {
            AppMethodBeat.o(57024);
            return;
        }
        heG.add(str);
        AppMethodBeat.o(57024);
    }

    public static void yL(String str) {
        AppMethodBeat.i(57025);
        if (str.length() == 0) {
            AppMethodBeat.o(57025);
            return;
        }
        heG.remove(str);
        AppMethodBeat.o(57025);
    }

    public static boolean yM(String str) {
        AppMethodBeat.i(57026);
        if (str.length() == 0) {
            AppMethodBeat.o(57026);
            return false;
        }
        boolean contains = heG.contains(str);
        AppMethodBeat.o(57026);
        return contains;
    }

    public static void dG(boolean z) {
        heF = z;
    }

    public static boolean ayt() {
        return heF;
    }

    private static boolean yN(String str) {
        AppMethodBeat.i(57027);
        if (heF && heG.contains(str)) {
            AppMethodBeat.o(57027);
            return true;
        }
        AppMethodBeat.o(57027);
        return false;
    }

    private static boolean yO(String str) {
        AppMethodBeat.i(57028);
        if (heF) {
            CollectSession yH = heE.yH(str);
            if (yH == null) {
                AppMethodBeat.o(57028);
                return false;
            } else if (heG.contains(yH.groupId)) {
                AppMethodBeat.o(57028);
                return true;
            } else {
                AppMethodBeat.o(57028);
                return false;
            }
        }
        AppMethodBeat.o(57028);
        return false;
    }

    public static void clear() {
        AppMethodBeat.i(57029);
        if (heF) {
            heE.clear();
            AppMethodBeat.o(57029);
            return;
        }
        AppMethodBeat.o(57029);
    }

    public static void d(String str, String str2, String str3, boolean z) {
        AppMethodBeat.i(57030);
        if (yN(str)) {
            heE.d(str, str2, str3, z);
            AppMethodBeat.o(57030);
            return;
        }
        AppMethodBeat.o(57030);
    }

    public static void bE(String str, String str2) {
        AppMethodBeat.i(57031);
        if (yO(str)) {
            heE.bE(str, str2);
            AppMethodBeat.o(57031);
            return;
        }
        AppMethodBeat.o(57031);
    }

    public static void a(CollectSession collectSession) {
        AppMethodBeat.i(57032);
        if (collectSession == null) {
            AppMethodBeat.o(57032);
        } else if (yN(collectSession.groupId)) {
            heE.a(collectSession);
            AppMethodBeat.o(57032);
        } else {
            AppMethodBeat.o(57032);
        }
    }

    public static CollectSession bD(String str, String str2) {
        AppMethodBeat.i(57033);
        if (yO(str)) {
            CollectSession bD = heE.bD(str, str2);
            AppMethodBeat.o(57033);
            return bD;
        }
        AppMethodBeat.o(57033);
        return null;
    }

    public static void l(String str, String str2, boolean z) {
        AppMethodBeat.i(57034);
        if (yO(str)) {
            heE.l(str, str2, z);
            AppMethodBeat.o(57034);
            return;
        }
        AppMethodBeat.o(57034);
    }

    public static CollectSession yH(String str) {
        AppMethodBeat.i(57035);
        if (yO(str)) {
            CollectSession yH = heE.yH(str);
            AppMethodBeat.o(57035);
            return yH;
        }
        AppMethodBeat.o(57035);
        return null;
    }

    public static CollectSession yI(String str) {
        AppMethodBeat.i(57036);
        if (heF) {
            CollectSession yI = heE.yI(str);
            AppMethodBeat.o(57036);
            return yI;
        }
        AppMethodBeat.o(57036);
        return null;
    }

    public static void print(String str) {
        AppMethodBeat.i(57037);
        if (yO(str)) {
            heE.print(str);
            AppMethodBeat.o(57037);
            return;
        }
        AppMethodBeat.o(57037);
    }

    public static int bF(String str, String str2) {
        AppMethodBeat.i(57038);
        if (yN(str)) {
            int bF = heE.bF(str, str2);
            AppMethodBeat.o(57038);
            return bF;
        }
        AppMethodBeat.o(57038);
        return 0;
    }

    public static StringBuilder yJ(String str) {
        AppMethodBeat.i(57039);
        StringBuilder yJ;
        if (yN(str)) {
            yJ = heE.yJ(str);
            AppMethodBeat.o(57039);
            return yJ;
        }
        yJ = new StringBuilder();
        AppMethodBeat.o(57039);
        return yJ;
    }
}
