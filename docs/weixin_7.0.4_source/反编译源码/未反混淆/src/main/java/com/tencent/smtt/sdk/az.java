package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class az implements a {
    final /* synthetic */ TbsLogReport a;

    az(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        AppMethodBeat.i(64480);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:".concat(String.valueOf(i)));
        if (i < 300) {
            TbsLogReport.b(this.a);
        }
        AppMethodBeat.o(64480);
    }
}
