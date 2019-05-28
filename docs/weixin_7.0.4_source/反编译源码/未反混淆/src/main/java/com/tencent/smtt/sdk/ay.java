package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

class ay implements a {
    final /* synthetic */ TbsLogReport a;

    ay(TbsLogReport tbsLogReport) {
        this.a = tbsLogReport;
    }

    public void a(int i) {
        AppMethodBeat.i(64479);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=".concat(String.valueOf(i)));
        AppMethodBeat.o(64479);
    }
}
