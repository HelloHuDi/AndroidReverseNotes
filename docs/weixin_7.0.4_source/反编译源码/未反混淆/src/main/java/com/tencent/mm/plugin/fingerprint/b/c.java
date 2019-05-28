package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lv;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.wallet.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class c implements k {
    public static boolean bxj() {
        AppMethodBeat.i(41429);
        boolean bxn = ((l) g.K(l.class)).bxn();
        ab.i("MicroMsg.FingerPrintAuthMgr", "isSupportFP is ".concat(String.valueOf(bxn)));
        AppMethodBeat.o(41429);
        return bxn;
    }

    public static int a(com.tencent.mm.pluginsdk.wallet.c cVar, boolean z) {
        AppMethodBeat.i(41430);
        int a = ((l) g.K(l.class)).a(cVar, z);
        AppMethodBeat.o(41430);
        return a;
    }

    public static void release() {
        AppMethodBeat.i(41431);
        ((l) g.K(l.class)).bxt();
        AppMethodBeat.o(41431);
    }

    public static void abort() {
        AppMethodBeat.i(41432);
        ((l) g.K(l.class)).bxu();
        AppMethodBeat.o(41432);
    }

    public static void bxk() {
        AppMethodBeat.i(41433);
        ((l) g.K(l.class)).bxk();
        AppMethodBeat.o(41433);
    }

    public static boolean bxl() {
        AppMethodBeat.i(41434);
        boolean bxo = ((l) g.K(l.class)).bxo();
        AppMethodBeat.o(41434);
        return bxo;
    }

    public static void a(lv lvVar, int i, String str) {
        AppMethodBeat.i(41435);
        ((l) g.K(l.class)).a(lvVar, i, str);
        AppMethodBeat.o(41435);
    }

    public static j bxm() {
        AppMethodBeat.i(41436);
        j bxm = ((l) g.K(l.class)).bxm();
        AppMethodBeat.o(41436);
        return bxm;
    }
}
