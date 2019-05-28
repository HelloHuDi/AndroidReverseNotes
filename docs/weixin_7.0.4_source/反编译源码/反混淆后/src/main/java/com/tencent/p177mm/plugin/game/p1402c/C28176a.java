package com.tencent.p177mm.plugin.game.p1402c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p183ai.C1207m;
import com.tencent.p177mm.p183ai.C1226w;
import com.tencent.p177mm.p183ai.C1226w.C1224a;
import com.tencent.p177mm.p183ai.C7472b;
import com.tencent.p177mm.p183ai.C7472b.C1196a;
import com.tencent.p177mm.plugin.downloader.model.C2895c;
import com.tencent.p177mm.plugin.downloader.p1607f.C42911a;
import com.tencent.p177mm.protocal.protobuf.bri;
import com.tencent.p177mm.protocal.protobuf.brj;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.vfs.C5730e;

/* renamed from: com.tencent.mm.plugin.game.c.a */
public final class C28176a {

    /* renamed from: com.tencent.mm.plugin.game.c.a$1 */
    static class C281751 implements C1224a {
        C281751() {
        }

        /* renamed from: a */
        public final int mo4496a(int i, int i2, String str, C7472b c7472b, C1207m c1207m) {
            AppMethodBeat.m2504i(111182);
            C4990ab.m7417i("MicroMsg.ReportDownloadAppState", "doCgi, errType = %d, errCode = %d, errMsg = %s", Integer.valueOf(i), Integer.valueOf(i2), str);
            AppMethodBeat.m2505o(111182);
            return 0;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.c.a$a */
    static final class C28177a {
        static int DOWNLOAD_STATUS_FAILED = 2;
        static int mTA = 0;
        static int mTB = 1;
    }

    /* renamed from: iN */
    public static void m44756iN(long j) {
        AppMethodBeat.m2504i(111183);
        C42911a hv = C2895c.m5147hv(j);
        if (hv == null) {
            C4990ab.m7416i("MicroMsg.ReportDownloadAppState", "report, info is null");
            AppMethodBeat.m2505o(111183);
        } else if (!hv.field_fromWeApp) {
            C4990ab.m7416i("MicroMsg.ReportDownloadAppState", "report,not from weApp, return");
            AppMethodBeat.m2505o(111183);
        } else if (hv.field_status != 3 || C5730e.m8628ct(hv.field_filePath)) {
            bri bri = new bri();
            bri.fKh = hv.field_appId;
            if (hv.field_status == 3) {
                bri.jBT = C28177a.mTB;
            } else if (hv.field_status == 4) {
                bri.jBT = C28177a.DOWNLOAD_STATUS_FAILED;
            }
            C1196a c1196a = new C1196a();
            c1196a.fsI = 2683;
            c1196a.uri = "/cgi-bin/mmgame-bin/reportappdownloadstatus";
            c1196a.fsJ = bri;
            c1196a.fsK = new brj();
            c1196a.fsL = 0;
            c1196a.fsM = 0;
            C1226w.m2654a(c1196a.acD(), new C281751());
            AppMethodBeat.m2505o(111183);
        } else {
            C4990ab.m7416i("MicroMsg.ReportDownloadAppState", "download success, but file not exist");
            AppMethodBeat.m2505o(111183);
        }
    }
}
