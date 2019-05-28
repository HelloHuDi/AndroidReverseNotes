package com.tencent.p177mm.pluginsdk.p592g.p593a.p594a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C5128ac.C5127a;
import com.tencent.smtt.sdk.TbsDownloadConfig;

/* renamed from: com.tencent.mm.pluginsdk.g.a.a.p */
final class C44048p {
    private static void dir() {
        AppMethodBeat.m2504i(79562);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3536RP().mo5239Ry().set(C5127a.USERINFO_RES_DOWNLOADER_CHECK_RES_UPDATE_INTERVAL_LONG, Long.valueOf(C5046bo.anT() + TbsDownloadConfig.DEFAULT_RETRY_INTERVAL_SEC));
            AppMethodBeat.m2505o(79562);
            return;
        }
        AppMethodBeat.m2505o(79562);
    }

    static void aVi() {
        AppMethodBeat.m2504i(79563);
        C1720g.m3535RO().eJo.mo14541a(new C44796m(), 0);
        C44048p.dir();
        AppMethodBeat.m2505o(79563);
    }
}
