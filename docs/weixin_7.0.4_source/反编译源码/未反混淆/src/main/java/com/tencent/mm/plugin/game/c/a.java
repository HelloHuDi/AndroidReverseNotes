package com.tencent.mm.plugin.game.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.w;
import com.tencent.mm.plugin.downloader.model.c;
import com.tencent.mm.protocal.protobuf.bri;
import com.tencent.mm.protocal.protobuf.brj;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;

public final class a {

    static final class a {
        static int DOWNLOAD_STATUS_FAILED = 2;
        static int mTA = 0;
        static int mTB = 1;
    }

    public static void iN(long j) {
        AppMethodBeat.i(111183);
        com.tencent.mm.plugin.downloader.f.a hv = c.hv(j);
        if (hv == null) {
            ab.i("MicroMsg.ReportDownloadAppState", "report, info is null");
            AppMethodBeat.o(111183);
        } else if (!hv.field_fromWeApp) {
            ab.i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
            AppMethodBeat.o(111183);
        } else if (hv.field_status != 3 || e.ct(hv.field_filePath)) {
            bri bri = new bri();
            bri.fKh = hv.field_appId;
            if (hv.field_status == 3) {
                bri.jBT = a.mTB;
            } else if (hv.field_status == 4) {
                bri.jBT = a.DOWNLOAD_STATUS_FAILED;
            }
            com.tencent.mm.ai.b.a aVar = new com.tencent.mm.ai.b.a();
            aVar.fsI = 2683;
            aVar.uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
            aVar.fsJ = bri;
            aVar.fsK = new brj();
            aVar.fsL = 0;
            aVar.fsM = 0;
            w.a(aVar.acD(), new com.tencent.mm.ai.w.a() {
                public final int a(int i, int i2, String str, b bVar, m mVar) {
                    AppMethodBeat.i(111182);
                    ab.i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
                    AppMethodBeat.o(111182);
                    return 0;
                }
            });
            AppMethodBeat.o(111183);
        } else {
            ab.i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
            AppMethodBeat.o(111183);
        }
    }
}
