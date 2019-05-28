package com.tencent.mm.plugin.record.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.gh;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.record.ui.a.b;
import com.tencent.mm.sdk.b.a;

public final class g {
    public static String a(b bVar) {
        AppMethodBeat.i(24163);
        gh ghVar = new gh();
        ghVar.cAH.type = 2;
        ghVar.cAH.cAJ = bVar.cAv;
        a.xxA.m(ghVar);
        String str = ghVar.cAI.path;
        AppMethodBeat.o(24163);
        return str;
    }

    public static String b(b bVar) {
        AppMethodBeat.i(24164);
        gh ghVar = new gh();
        ghVar.cAH.type = 2;
        ghVar.cAH.cAJ = bVar.cAv;
        a.xxA.m(ghVar);
        String str = ghVar.cAI.thumbPath;
        AppMethodBeat.o(24164);
        return str;
    }

    public static boolean c(b bVar) {
        AppMethodBeat.i(24165);
        gh ghVar = new gh();
        ghVar.cAH.type = 14;
        ghVar.cAH.cAJ = bVar.cAv;
        a.xxA.m(ghVar);
        if (ghVar.cAI.ret == 1) {
            AppMethodBeat.o(24165);
            return true;
        }
        AppMethodBeat.o(24165);
        return false;
    }

    public static com.tencent.mm.plugin.fav.a.g jD(long j) {
        AppMethodBeat.i(24166);
        com.tencent.mm.plugin.fav.a.g iE = ((ae) com.tencent.mm.kernel.g.M(ae.class)).getFavItemInfoStorage().iE(j);
        AppMethodBeat.o(24166);
        return iE;
    }
}
