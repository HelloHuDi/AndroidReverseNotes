package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.smtt.sdk.TbsDownloadConfig;

final class p {
    private static void dir() {
        AppMethodBeat.i(79562);
        if (g.RN().QY()) {
            g.RP().Ry().set(a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(bo.anT() + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC));
            AppMethodBeat.o(79562);
            return;
        }
        AppMethodBeat.o(79562);
    }

    static void aVi() {
        AppMethodBeat.i(79563);
        g.RO().eJo.a(new m(), 0);
        dir();
        AppMethodBeat.o(79563);
    }
}
