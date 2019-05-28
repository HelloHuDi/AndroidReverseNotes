package com.tencent.mm.plugin.priority.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;

public final class a {
    public static final boolean eW(int i, int i2) {
        return (i & i2) > 0;
    }

    public static final boolean bZu() {
        AppMethodBeat.i(97737);
        try {
            if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mmc2c_img_auto_download_strategy, 0) == 0) {
                AppMethodBeat.o(97737);
                return true;
            }
            AppMethodBeat.o(97737);
            return false;
        } catch (Exception e) {
            AppMethodBeat.o(97737);
            return true;
        }
    }

    public static final boolean bhI() {
        AppMethodBeat.i(97738);
        try {
            if (((com.tencent.mm.plugin.expt.a.a) g.K(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.clicfg_mmc2c_img_auto_download_strategy, 0) == 1) {
                AppMethodBeat.o(97738);
                return true;
            }
            AppMethodBeat.o(97738);
            return false;
        } catch (Exception e) {
            AppMethodBeat.o(97738);
            return false;
        }
    }
}
