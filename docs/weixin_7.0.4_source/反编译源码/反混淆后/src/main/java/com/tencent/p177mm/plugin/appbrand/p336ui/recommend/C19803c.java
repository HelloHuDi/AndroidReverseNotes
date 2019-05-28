package com.tencent.p177mm.plugin.appbrand.p336ui.recommend;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;
import com.tencent.p177mm.storage.C5128ac.C5127a;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.recommend.c */
public final class C19803c {
    public static boolean aNE() {
        AppMethodBeat.m2504i(133562);
        if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_app_brand_recommend_enter_switch, 0) > 0) {
            AppMethodBeat.m2505o(133562);
            return true;
        }
        AppMethodBeat.m2505o(133562);
        return false;
    }

    public static boolean aNF() {
        AppMethodBeat.m2504i(133563);
        if (((Integer) C1720g.m3536RP().mo5239Ry().get(C5127a.USERINFO_APP_BRAND_RECOMMEND_DATA_STATE_INT_SYNC, Integer.valueOf(0))).intValue() == 1) {
            AppMethodBeat.m2505o(133563);
            return true;
        }
        AppMethodBeat.m2505o(133563);
        return false;
    }
}
