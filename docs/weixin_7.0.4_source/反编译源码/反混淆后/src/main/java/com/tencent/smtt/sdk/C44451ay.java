package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.C44463n.C24288a;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.ay */
class C44451ay implements C24288a {
    /* renamed from: a */
    final /* synthetic */ TbsLogReport f17293a;

    C44451ay(TbsLogReport tbsLogReport) {
        this.f17293a = tbsLogReport;
    }

    /* renamed from: a */
    public void mo12147a(int i) {
        AppMethodBeat.m2504i(64479);
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsApkDownloadStat.reportTbsLog] httpResponseCode=".concat(String.valueOf(i)));
        AppMethodBeat.m2505o(64479);
    }
}
