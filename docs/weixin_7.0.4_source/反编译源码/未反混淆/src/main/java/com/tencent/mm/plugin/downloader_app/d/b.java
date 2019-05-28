package com.tencent.mm.plugin.downloader_app.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader.a.d;
import com.tencent.mm.plugin.downloader_app.a.e;
import com.tencent.mm.sdk.platformtools.ab;

public final class b {
    public static c biR() {
        AppMethodBeat.i(136201);
        if (g.RN().QY()) {
            g.RN();
            if (!a.QT()) {
                if (g.K(d.class) == null) {
                    ab.e("MicroMsg.DownloadTaskItemDbHelp", "service not ready");
                    AppMethodBeat.o(136201);
                    return null;
                }
                c biA = ((e) g.K(e.class)).biA();
                AppMethodBeat.o(136201);
                return biA;
            }
        }
        ab.e("MicroMsg.DownloadTaskItemDbHelp", "no user login");
        AppMethodBeat.o(136201);
        return null;
    }

    public static boolean bU(String str, int i) {
        AppMethodBeat.i(136202);
        if (biR() == null) {
            AppMethodBeat.o(136202);
            return false;
        }
        a aVar = new a();
        aVar.field_appId = str;
        aVar.field_status = i;
        aVar.field_modifyTime = System.currentTimeMillis();
        boolean a = biR().a(aVar);
        AppMethodBeat.o(136202);
        return a;
    }
}
