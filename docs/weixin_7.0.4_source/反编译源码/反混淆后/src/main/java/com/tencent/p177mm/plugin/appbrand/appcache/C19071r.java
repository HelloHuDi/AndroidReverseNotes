package com.tencent.p177mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.p262c.C18624c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C5058f;
import com.tencent.p177mm.storage.C5141c;

/* renamed from: com.tencent.mm.plugin.appbrand.appcache.r */
public final class C19071r {
    public static boolean avD() {
        AppMethodBeat.m2504i(129363);
        if (C1720g.m3531RK()) {
            AppMethodBeat.m2505o(129363);
            return true;
        }
        AppMethodBeat.m2505o(129363);
        return false;
    }

    public static boolean avE() {
        AppMethodBeat.m2504i(129364);
        if (C1720g.m3531RK()) {
            AppMethodBeat.m2505o(129364);
            return true;
        }
        AppMethodBeat.m2505o(129364);
        return false;
    }

    public static boolean avF() {
        AppMethodBeat.m2504i(129365);
        if (C1720g.m3531RK()) {
            AppMethodBeat.m2505o(129365);
            return true;
        }
        AppMethodBeat.m2505o(129365);
        return false;
    }

    public static boolean avG() {
        AppMethodBeat.m2504i(129366);
        if (C1720g.m3531RK()) {
            boolean z;
            C5141c ll = C18624c.abi().mo17131ll("100399");
            if (C5058f.IS_FLAVOR_RED) {
                z = true;
            } else {
                z = false;
            }
            if (!ll.isValid() || C5046bo.getInt((String) ll.dru().get("isUseNewPackageLogic"), 0) <= 0) {
                AppMethodBeat.m2505o(129366);
                return z;
            }
            AppMethodBeat.m2505o(129366);
            return true;
        }
        AppMethodBeat.m2505o(129366);
        return false;
    }

    public static boolean avH() {
        int i;
        AppMethodBeat.m2504i(129367);
        boolean a = ((C34069a) C1720g.m3528K(C34069a.class)).mo54614a(C11745a.clicfg_appbrand_game_split_codelib, false);
        String str = "MicroMsg.PkgABTest";
        String str2 = "openSplitCodeLib exp:%d";
        Object[] objArr = new Object[1];
        if (a) {
            i = 1;
        } else {
            i = 0;
        }
        objArr[0] = Integer.valueOf(i);
        C4990ab.m7417i(str, str2, objArr);
        AppMethodBeat.m2505o(129367);
        return a;
    }
}
