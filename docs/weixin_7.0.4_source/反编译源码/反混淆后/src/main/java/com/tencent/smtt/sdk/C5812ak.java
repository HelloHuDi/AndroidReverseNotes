package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.utils.C44463n.C24288a;
import com.tencent.smtt.utils.TbsLog;

/* renamed from: com.tencent.smtt.sdk.ak */
final class C5812ak implements C24288a {
    /* renamed from: a */
    final /* synthetic */ TbsDownloadConfig f1396a;
    /* renamed from: b */
    final /* synthetic */ boolean f1397b;

    C5812ak(TbsDownloadConfig tbsDownloadConfig, boolean z) {
        this.f1396a = tbsDownloadConfig;
        this.f1397b = z;
    }

    /* renamed from: a */
    public final void mo12147a(int i) {
        AppMethodBeat.m2504i(64347);
        this.f1396a.f1368a.put(TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
        this.f1396a.commit();
        TbsLog.m80434i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=".concat(String.valueOf(i)));
        if (TbsShareManager.isThirdPartyApp(TbsDownloader.f4488c) && i == 200) {
            this.f1396a.f1368a.put(TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
            this.f1396a.f1368a.put(TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(0));
            this.f1396a.f1368a.put(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(0));
            this.f1396a.commit();
        }
        if (i >= 300) {
            if (this.f1397b) {
                this.f1396a.setDownloadInterruptCode(-107);
                AppMethodBeat.m2505o(64347);
                return;
            }
            this.f1396a.setDownloadInterruptCode(-207);
        }
        AppMethodBeat.m2505o(64347);
    }
}
