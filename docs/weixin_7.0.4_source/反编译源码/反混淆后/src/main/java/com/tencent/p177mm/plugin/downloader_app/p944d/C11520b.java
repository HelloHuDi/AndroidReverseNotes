package com.tencent.p177mm.plugin.downloader_app.p944d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.kernel.C1668a;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.plugin.downloader.p939a.C45826d;
import com.tencent.p177mm.plugin.downloader_app.p1251a.C42913e;
import com.tencent.p177mm.sdk.platformtools.C4990ab;

/* renamed from: com.tencent.mm.plugin.downloader_app.d.b */
public final class C11520b {
    public static C33936c biR() {
        AppMethodBeat.m2504i(136201);
        if (C1720g.m3534RN().mo5161QY()) {
            C1720g.m3534RN();
            if (!C1668a.m3393QT()) {
                if (C1720g.m3528K(C45826d.class) == null) {
                    C4990ab.m7412e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
                    AppMethodBeat.m2505o(136201);
                    return null;
                }
                C33936c biA = ((C42913e) C1720g.m3528K(C42913e.class)).biA();
                AppMethodBeat.m2505o(136201);
                return biA;
            }
        }
        C4990ab.m7412e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
        AppMethodBeat.m2505o(136201);
        return null;
    }

    /* renamed from: bU */
    public static boolean m19331bU(String str, int i) {
        AppMethodBeat.m2504i(136202);
        if (C11520b.biR() == null) {
            AppMethodBeat.m2505o(136202);
            return false;
        }
        C27718a c27718a = new C27718a();
        c27718a.field_appId = str;
        c27718a.field_status = i;
        c27718a.field_modifyTime = System.currentTimeMillis();
        boolean a = C11520b.biR().mo54481a(c27718a);
        AppMethodBeat.m2505o(136202);
        return a;
    }
}
