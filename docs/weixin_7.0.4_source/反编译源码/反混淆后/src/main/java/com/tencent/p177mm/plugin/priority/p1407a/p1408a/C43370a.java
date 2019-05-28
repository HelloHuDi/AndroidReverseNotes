package com.tencent.p177mm.plugin.priority.p1407a.p1408a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.expt.p394a.C34069a;
import com.tencent.p177mm.plugin.expt.p394a.C34069a.C11745a;

/* renamed from: com.tencent.mm.plugin.priority.a.a.a */
public final class C43370a {
    /* renamed from: eW */
    public static final boolean m77394eW(int i, int i2) {
        return (i & i2) > 0;
    }

    public static final boolean bZu() {
        AppMethodBeat.m2504i(97737);
        try {
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mmc2c_img_auto_download_strategy, 0) == 0) {
                AppMethodBeat.m2505o(97737);
                return true;
            }
            AppMethodBeat.m2505o(97737);
            return false;
        } catch (Exception e) {
            AppMethodBeat.m2505o(97737);
            return true;
        }
    }

    public static final boolean bhI() {
        AppMethodBeat.m2504i(97738);
        try {
            if (((C34069a) C1720g.m3528K(C34069a.class)).mo54611a(C11745a.clicfg_mmc2c_img_auto_download_strategy, 0) == 1) {
                AppMethodBeat.m2505o(97738);
                return true;
            }
            AppMethodBeat.m2505o(97738);
            return false;
        } catch (Exception e) {
            AppMethodBeat.m2505o(97738);
            return false;
        }
    }
}
