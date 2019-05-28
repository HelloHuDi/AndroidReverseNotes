package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.QbSdk.PreInitCallback;
import com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback;

final class m implements TbsDownloaderCallback {
    final /* synthetic */ Context a;
    final /* synthetic */ PreInitCallback b;

    m(Context context, PreInitCallback preInitCallback) {
        this.a = context;
        this.b = preInitCallback;
    }

    public final void onNeedDownloadFinish(boolean z, int i) {
        AppMethodBeat.i(63990);
        if (TbsShareManager.findCoreForThirdPartyApp(this.a) != 0 || TbsShareManager.getCoreDisabled()) {
            if (QbSdk.i && TbsShareManager.isThirdPartyApp(this.a)) {
                TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
            }
            QbSdk.preInit(this.a, this.b);
        } else {
            TbsShareManager.forceToLoadX5ForThirdApp(this.a, false);
            if (QbSdk.i && TbsShareManager.isThirdPartyApp(this.a)) {
                TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(this.a);
                AppMethodBeat.o(63990);
                return;
            }
        }
        AppMethodBeat.o(63990);
    }
}
