package com.tencent.p177mm.plugin.expt.p395c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.expt.p1257e.C27892c;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.sdk.platformtools.C5046bo;

/* renamed from: com.tencent.mm.plugin.expt.c.a */
public final class C45899a {
    public static boolean bqW() {
        AppMethodBeat.m2504i(73520);
        C27892c.bru();
        if (C5046bo.getInt(C27892c.m44337a(C11745a.clicfg_weixin_rpt_mm_app_mgr, "", false), 0) > 0) {
            AppMethodBeat.m2505o(73520);
            return true;
        }
        AppMethodBeat.m2505o(73520);
        return false;
    }

    public static boolean bqX() {
        AppMethodBeat.m2504i(73521);
        C27892c.bru();
        if (C5046bo.getInt(C27892c.m44337a(C11745a.clicfg_weixin_rpt_mm_life_call, "", false), 0) > 0) {
            AppMethodBeat.m2505o(73521);
            return true;
        }
        AppMethodBeat.m2505o(73521);
        return false;
    }

    public static boolean bqY() {
        AppMethodBeat.m2504i(73522);
        C27892c.bru();
        if (C5046bo.getInt(C27892c.m44337a(C11745a.clicfg_weixin_rpt_mm_hell_hound, "", false), 0) > 0) {
            AppMethodBeat.m2505o(73522);
            return true;
        }
        AppMethodBeat.m2505o(73522);
        return false;
    }

    /* renamed from: b */
    public static int m85091b(C11745a c11745a) {
        AppMethodBeat.m2504i(73523);
        C27892c.bru();
        int i = C5046bo.getInt(C27892c.m44337a(c11745a, "", false), 0);
        AppMethodBeat.m2505o(73523);
        return i;
    }
}
