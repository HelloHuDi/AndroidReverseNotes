package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.a.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.c;

public final class r {
    public static boolean avD() {
        AppMethodBeat.i(129363);
        if (g.RK()) {
            AppMethodBeat.o(129363);
            return true;
        }
        AppMethodBeat.o(129363);
        return false;
    }

    public static boolean avE() {
        AppMethodBeat.i(129364);
        if (g.RK()) {
            AppMethodBeat.o(129364);
            return true;
        }
        AppMethodBeat.o(129364);
        return false;
    }

    public static boolean avF() {
        AppMethodBeat.i(129365);
        if (g.RK()) {
            AppMethodBeat.o(129365);
            return true;
        }
        AppMethodBeat.o(129365);
        return false;
    }

    public static boolean avG() {
        AppMethodBeat.i(129366);
        if (g.RK()) {
            boolean z;
            c ll = com.tencent.mm.model.c.c.abi().ll("100399");
            if (f.IS_FLAVOR_RED) {
                z = true;
            } else {
                z = false;
            }
            if (!ll.isValid() || bo.getInt((String) ll.dru().get("isUseNewPackageLogic"), 0) <= 0) {
                AppMethodBeat.o(129366);
                return z;
            }
            AppMethodBeat.o(129366);
            return true;
        }
        AppMethodBeat.o(129366);
        return false;
    }

    public static boolean avH() {
        int i;
        AppMethodBeat.i(129367);
        boolean a = ((a) g.K(a.class)).a(a.a.clicfg_appbrand_game_split_codelib, false);
        String str = "MicroMsg.PkgABTest";
        String str2 = "openSplitCodeLib exp:%d";
        Object[] objArr = new Object[1];
        if (a) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        ab.i(str, str2, objArr);
        AppMethodBeat.o(129367);
        return a;
    }
}
