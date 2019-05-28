package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C44463n.C24288a;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.az */
class C44452az implements C24288a {
    /* renamed from: a */
    final /* synthetic */ TbsLogReport f17294a;

    C44452az(TbsLogReport tbsLogReport) {
        this.f17294a = tbsLogReport;
    }

    /* renamed from: a */
    public void mo12147a(int i) {
        AppMethodBeat.m2504i(64480);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportDownloadStat] onHttpResponseCode:".concat(String.valueOf(i)));
        if (i < 300) {
            TbsLogReport.m49457b(this.f17294a);
        }
        AppMethodBeat.m2505o(64480);
    }
}
