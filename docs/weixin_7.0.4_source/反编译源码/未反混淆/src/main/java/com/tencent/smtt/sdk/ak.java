package com.tencent.smtt.sdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.n.a;

final class ak implements a {
    final /* synthetic */ TbsDownloadConfig a;
    final /* synthetic */ boolean b;

    ak(TbsDownloadConfig tbsDownloadConfig, boolean z) {
        this.a = tbsDownloadConfig;
        this.b = z;
    }

    public final void a(int i) {
        AppMethodBeat.i(64347);
        this.a.a.put(TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
        this.a.commit();
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=".concat(String.valueOf(i)));
        if (TbsShareManager.isThirdPartyApp(TbsDownloader.c) && i == 200) {
            this.a.a.put(TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
            this.a.a.put(TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(0));
            this.a.a.put(TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(0));
            this.a.commit();
        }
        if (i >= 300) {
            if (this.b) {
                this.a.setDownloadInterruptCode(-107);
                AppMethodBeat.o(64347);
                return;
            }
            this.a.setDownloadInterruptCode(-207);
        }
        AppMethodBeat.o(64347);
    }
}
