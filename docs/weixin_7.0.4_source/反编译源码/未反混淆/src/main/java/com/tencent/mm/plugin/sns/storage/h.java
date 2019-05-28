package com.tencent.mm.plugin.sns.storage;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.sns.model.af;

public final class h {
    public static n YS(String str) {
        AppMethodBeat.i(37835);
        n kD;
        if (v.WT(str)) {
            kD = af.cnF().kD(v.Zm(str));
            AppMethodBeat.o(37835);
            return kD;
        }
        e ku = af.cnI().ku(v.Zm(str));
        if (ku != null) {
            kD = ku.cqB();
            AppMethodBeat.o(37835);
            return kD;
        }
        AppMethodBeat.o(37835);
        return null;
    }

    public static boolean a(String str, n nVar) {
        AppMethodBeat.i(37836);
        boolean b;
        if (v.WT(str)) {
            b = af.cnF().b(v.Zm(str), nVar);
            AppMethodBeat.o(37836);
            return b;
        }
        b = af.cnI().b(v.Zm(str), nVar.crd());
        AppMethodBeat.o(37836);
        return b;
    }

    public static n YT(String str) {
        AppMethodBeat.i(37837);
        n DK;
        if (v.WT(str)) {
            DK = af.cnF().DK(v.Zn(str));
            AppMethodBeat.o(37837);
            return DK;
        }
        e DG = af.cnI().DG(v.Zn(str));
        if (DG != null) {
            DK = DG.cqB();
            AppMethodBeat.o(37837);
            return DK;
        }
        AppMethodBeat.o(37837);
        return null;
    }
}
