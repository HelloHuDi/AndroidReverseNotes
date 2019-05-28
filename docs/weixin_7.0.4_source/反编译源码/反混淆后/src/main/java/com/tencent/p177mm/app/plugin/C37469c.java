package com.tencent.p177mm.app.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.app.plugin.c */
public final class C37469c {
    /* renamed from: Cj */
    public static boolean m63212Cj() {
        AppMethodBeat.m2504i(15617);
        if (C25985d.afj("translate")) {
            String value = C26373g.m41964Nu().getValue("TranslateMsgOff");
            if (C5046bo.isNullOrNil(value)) {
                AppMethodBeat.m2505o(15617);
                return true;
            } else if (C5046bo.ank(value) != 0) {
                AppMethodBeat.m2505o(15617);
                return false;
            } else {
                AppMethodBeat.m2505o(15617);
                return true;
            }
        }
        AppMethodBeat.m2505o(15617);
        return false;
    }

    /* renamed from: Ck */
    public static boolean m63213Ck() {
        AppMethodBeat.m2504i(15618);
        if (C25985d.afj("translate")) {
            String value = C26373g.m41964Nu().getValue("ReTranslateSwitch");
            if (C5046bo.isNullOrNil(value)) {
                AppMethodBeat.m2505o(15618);
                return true;
            } else if (C5046bo.ank(value) != 0) {
                AppMethodBeat.m2505o(15618);
                return false;
            } else {
                AppMethodBeat.m2505o(15618);
                return true;
            }
        }
        AppMethodBeat.m2505o(15618);
        return false;
    }
}
